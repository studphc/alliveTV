package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SilenceSkippingAudioProcessor extends BaseAudioProcessor {
    public static final long DEFAULT_MINIMUM_SILENCE_DURATION_US = 150000;
    public static final long DEFAULT_PADDING_SILENCE_US = 20000;
    public static final short DEFAULT_SILENCE_THRESHOLD_LEVEL = 1024;

    /* renamed from: f */
    public final long f9775f;

    /* renamed from: g */
    public final long f9776g;

    /* renamed from: h */
    public final short f9777h;

    /* renamed from: i */
    public int f9778i;

    /* renamed from: j */
    public boolean f9779j;

    /* renamed from: k */
    public byte[] f9780k;

    /* renamed from: l */
    public byte[] f9781l;

    /* renamed from: m */
    public int f9782m;

    /* renamed from: n */
    public int f9783n;

    /* renamed from: o */
    public int f9784o;

    /* renamed from: p */
    public boolean f9785p;

    /* renamed from: q */
    public long f9786q;

    public SilenceSkippingAudioProcessor() {
        this(DEFAULT_MINIMUM_SILENCE_DURATION_US, DEFAULT_PADDING_SILENCE_US, DEFAULT_SILENCE_THRESHOLD_LEVEL);
    }

    /* renamed from: a */
    public final int m2473a(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position(); position < byteBuffer.limit(); position += 2) {
            if (Math.abs((int) byteBuffer.getShort(position)) > this.f9777h) {
                int i = this.f9778i;
                return (position / i) * i;
            }
        }
        return byteBuffer.limit();
    }

    /* renamed from: b */
    public final void m2474b(int i, byte[] bArr) {
        replaceOutputBuffer(i).put(bArr, 0, i).flip();
        if (i > 0) {
            this.f9785p = true;
        }
    }

    /* renamed from: c */
    public final void m2475c(int i, byte[] bArr, ByteBuffer byteBuffer) {
        int min = Math.min(byteBuffer.remaining(), this.f9784o);
        int i2 = this.f9784o - min;
        System.arraycopy(bArr, i - i2, this.f9781l, 0, i2);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.f9781l, i2, min);
    }

    public long getSkippedFrames() {
        return this.f9786q;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.f9779j;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) {
        if (audioFormat.encoding == 2) {
            if (!this.f9779j) {
                return AudioProcessor.AudioFormat.NOT_SET;
            }
            return audioFormat;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onFlush() {
        if (this.f9779j) {
            AudioProcessor.AudioFormat audioFormat = this.inputAudioFormat;
            int i = audioFormat.bytesPerFrame;
            this.f9778i = i;
            int i2 = audioFormat.sampleRate;
            int i3 = ((int) ((this.f9775f * i2) / 1000000)) * i;
            if (this.f9780k.length != i3) {
                this.f9780k = new byte[i3];
            }
            int i4 = ((int) ((this.f9776g * i2) / 1000000)) * i;
            this.f9784o = i4;
            if (this.f9781l.length != i4) {
                this.f9781l = new byte[i4];
            }
        }
        this.f9782m = 0;
        this.f9786q = 0L;
        this.f9783n = 0;
        this.f9785p = false;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onQueueEndOfStream() {
        int i = this.f9783n;
        if (i > 0) {
            m2474b(i, this.f9780k);
        }
        if (!this.f9785p) {
            this.f9786q += this.f9784o / this.f9778i;
        }
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onReset() {
        this.f9779j = false;
        this.f9784o = 0;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        this.f9780k = bArr;
        this.f9781l = bArr;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        int position;
        while (byteBuffer.hasRemaining() && !hasPendingOutput()) {
            int i = this.f9782m;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int limit = byteBuffer.limit();
                        int m2473a = m2473a(byteBuffer);
                        byteBuffer.limit(m2473a);
                        this.f9786q += byteBuffer.remaining() / this.f9778i;
                        m2475c(this.f9784o, this.f9781l, byteBuffer);
                        if (m2473a < limit) {
                            m2474b(this.f9784o, this.f9781l);
                            this.f9782m = 0;
                            byteBuffer.limit(limit);
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    int limit2 = byteBuffer.limit();
                    int m2473a2 = m2473a(byteBuffer);
                    int position2 = m2473a2 - byteBuffer.position();
                    byte[] bArr = this.f9780k;
                    int length = bArr.length;
                    int i2 = this.f9783n;
                    int i3 = length - i2;
                    if (m2473a2 < limit2 && position2 < i3) {
                        m2474b(i2, bArr);
                        this.f9783n = 0;
                        this.f9782m = 0;
                    } else {
                        int min = Math.min(position2, i3);
                        byteBuffer.limit(byteBuffer.position() + min);
                        byteBuffer.get(this.f9780k, this.f9783n, min);
                        int i4 = this.f9783n + min;
                        this.f9783n = i4;
                        byte[] bArr2 = this.f9780k;
                        if (i4 == bArr2.length) {
                            if (this.f9785p) {
                                m2474b(this.f9784o, bArr2);
                                this.f9786q += (this.f9783n - (this.f9784o * 2)) / this.f9778i;
                            } else {
                                this.f9786q += (i4 - this.f9784o) / this.f9778i;
                            }
                            m2475c(this.f9783n, this.f9780k, byteBuffer);
                            this.f9783n = 0;
                            this.f9782m = 2;
                        }
                        byteBuffer.limit(limit2);
                    }
                }
            } else {
                int limit3 = byteBuffer.limit();
                byteBuffer.limit(Math.min(limit3, byteBuffer.position() + this.f9780k.length));
                int limit4 = byteBuffer.limit() - 2;
                while (true) {
                    if (limit4 >= byteBuffer.position()) {
                        if (Math.abs((int) byteBuffer.getShort(limit4)) > this.f9777h) {
                            int i5 = this.f9778i;
                            position = ((limit4 / i5) * i5) + i5;
                            break;
                        }
                        limit4 -= 2;
                    } else {
                        position = byteBuffer.position();
                        break;
                    }
                }
                if (position == byteBuffer.position()) {
                    this.f9782m = 1;
                } else {
                    byteBuffer.limit(position);
                    int remaining = byteBuffer.remaining();
                    replaceOutputBuffer(remaining).put(byteBuffer).flip();
                    if (remaining > 0) {
                        this.f9785p = true;
                    }
                }
                byteBuffer.limit(limit3);
            }
        }
    }

    public void setEnabled(boolean z) {
        this.f9779j = z;
    }

    public SilenceSkippingAudioProcessor(long j, long j2, short s) {
        Assertions.checkArgument(j2 <= j);
        this.f9775f = j;
        this.f9776g = j2;
        this.f9777h = s;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        this.f9780k = bArr;
        this.f9781l = bArr;
    }
}
