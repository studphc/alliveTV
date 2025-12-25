package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import p000.el2;

/* loaded from: classes.dex */
public final class SonicAudioProcessor implements AudioProcessor {
    public static final int SAMPLE_RATE_NO_CHANGE = -1;

    /* renamed from: a */
    public int f9787a;

    /* renamed from: b */
    public float f9788b = 1.0f;

    /* renamed from: c */
    public float f9789c = 1.0f;

    /* renamed from: d */
    public AudioProcessor.AudioFormat f9790d;

    /* renamed from: e */
    public AudioProcessor.AudioFormat f9791e;

    /* renamed from: f */
    public AudioProcessor.AudioFormat f9792f;

    /* renamed from: g */
    public AudioProcessor.AudioFormat f9793g;

    /* renamed from: h */
    public boolean f9794h;

    /* renamed from: i */
    public el2 f9795i;

    /* renamed from: j */
    public ByteBuffer f9796j;

    /* renamed from: k */
    public ShortBuffer f9797k;

    /* renamed from: l */
    public ByteBuffer f9798l;

    /* renamed from: m */
    public long f9799m;

    /* renamed from: n */
    public long f9800n;

    /* renamed from: o */
    public boolean f9801o;

    public SonicAudioProcessor() {
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.f9790d = audioFormat;
        this.f9791e = audioFormat;
        this.f9792f = audioFormat;
        this.f9793g = audioFormat;
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.f9796j = byteBuffer;
        this.f9797k = byteBuffer.asShortBuffer();
        this.f9798l = byteBuffer;
        this.f9787a = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public AudioProcessor.AudioFormat configure(AudioProcessor.AudioFormat audioFormat) {
        if (audioFormat.encoding == 2) {
            int i = this.f9787a;
            if (i == -1) {
                i = audioFormat.sampleRate;
            }
            this.f9790d = audioFormat;
            AudioProcessor.AudioFormat audioFormat2 = new AudioProcessor.AudioFormat(i, audioFormat.channelCount, 2);
            this.f9791e = audioFormat2;
            this.f9794h = true;
            return audioFormat2;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        if (isActive()) {
            AudioProcessor.AudioFormat audioFormat = this.f9790d;
            this.f9792f = audioFormat;
            AudioProcessor.AudioFormat audioFormat2 = this.f9791e;
            this.f9793g = audioFormat2;
            if (this.f9794h) {
                this.f9795i = new el2(audioFormat.sampleRate, audioFormat.channelCount, this.f9788b, this.f9789c, audioFormat2.sampleRate);
            } else {
                el2 el2Var = this.f9795i;
                if (el2Var != null) {
                    el2Var.f16879k = 0;
                    el2Var.f16881m = 0;
                    el2Var.f16883o = 0;
                    el2Var.f16884p = 0;
                    el2Var.f16885q = 0;
                    el2Var.f16886r = 0;
                    el2Var.f16887s = 0;
                    el2Var.f16888t = 0;
                    el2Var.f16889u = 0;
                    el2Var.f16890v = 0;
                }
            }
        }
        this.f9798l = AudioProcessor.EMPTY_BUFFER;
        this.f9799m = 0L;
        this.f9800n = 0L;
        this.f9801o = false;
    }

    public long getMediaDuration(long j) {
        if (this.f9800n >= 1024) {
            long j2 = this.f9799m;
            el2 el2Var = (el2) Assertions.checkNotNull(this.f9795i);
            long j3 = j2 - ((el2Var.f16879k * el2Var.f16870b) * 2);
            int i = this.f9793g.sampleRate;
            int i2 = this.f9792f.sampleRate;
            if (i == i2) {
                return Util.scaleLargeTimestamp(j, j3, this.f9800n);
            }
            return Util.scaleLargeTimestamp(j, j3 * i, this.f9800n * i2);
        }
        return (long) (this.f9788b * j);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        el2 el2Var = this.f9795i;
        if (el2Var != null) {
            int i = el2Var.f16881m;
            int i2 = el2Var.f16870b;
            int i3 = i * i2 * 2;
            if (i3 > 0) {
                if (this.f9796j.capacity() < i3) {
                    ByteBuffer order = ByteBuffer.allocateDirect(i3).order(ByteOrder.nativeOrder());
                    this.f9796j = order;
                    this.f9797k = order.asShortBuffer();
                } else {
                    this.f9796j.clear();
                    this.f9797k.clear();
                }
                ShortBuffer shortBuffer = this.f9797k;
                int min = Math.min(shortBuffer.remaining() / i2, el2Var.f16881m);
                int i4 = min * i2;
                shortBuffer.put(el2Var.f16880l, 0, i4);
                int i5 = el2Var.f16881m - min;
                el2Var.f16881m = i5;
                short[] sArr = el2Var.f16880l;
                System.arraycopy(sArr, i4, sArr, 0, i5 * i2);
                this.f9800n += i3;
                this.f9796j.limit(i3);
                this.f9798l = this.f9796j;
            }
        }
        ByteBuffer byteBuffer = this.f9798l;
        this.f9798l = AudioProcessor.EMPTY_BUFFER;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        if (this.f9791e.sampleRate != -1 && (Math.abs(this.f9788b - 1.0f) >= 1.0E-4f || Math.abs(this.f9789c - 1.0f) >= 1.0E-4f || this.f9791e.sampleRate != this.f9790d.sampleRate)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        el2 el2Var;
        if (this.f9801o && ((el2Var = this.f9795i) == null || el2Var.f16881m * el2Var.f16870b * 2 == 0)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueEndOfStream() {
        el2 el2Var = this.f9795i;
        if (el2Var != null) {
            int i = el2Var.f16879k;
            float f = el2Var.f16871c;
            float f2 = el2Var.f16872d;
            int i2 = el2Var.f16881m + ((int) ((((i / (f / f2)) + el2Var.f16883o) / (el2Var.f16873e * f2)) + 0.5f));
            short[] sArr = el2Var.f16878j;
            int i3 = el2Var.f16876h * 2;
            el2Var.f16878j = el2Var.m4731c(sArr, i, i3 + i);
            int i4 = 0;
            while (true) {
                int i5 = el2Var.f16870b;
                if (i4 >= i3 * i5) {
                    break;
                }
                el2Var.f16878j[(i5 * i) + i4] = 0;
                i4++;
            }
            el2Var.f16879k = i3 + el2Var.f16879k;
            el2Var.m4733f();
            if (el2Var.f16881m > i2) {
                el2Var.f16881m = i2;
            }
            el2Var.f16879k = 0;
            el2Var.f16886r = 0;
            el2Var.f16883o = 0;
        }
        this.f9801o = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return;
        }
        el2 el2Var = (el2) Assertions.checkNotNull(this.f9795i);
        ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
        int remaining = byteBuffer.remaining();
        this.f9799m += remaining;
        el2Var.getClass();
        int remaining2 = asShortBuffer.remaining();
        int i = el2Var.f16870b;
        int i2 = remaining2 / i;
        short[] m4731c = el2Var.m4731c(el2Var.f16878j, el2Var.f16879k, i2);
        el2Var.f16878j = m4731c;
        asShortBuffer.get(m4731c, el2Var.f16879k * i, ((i2 * i) * 2) / 2);
        el2Var.f16879k += i2;
        el2Var.m4733f();
        byteBuffer.position(byteBuffer.position() + remaining);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.f9788b = 1.0f;
        this.f9789c = 1.0f;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.f9790d = audioFormat;
        this.f9791e = audioFormat;
        this.f9792f = audioFormat;
        this.f9793g = audioFormat;
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.f9796j = byteBuffer;
        this.f9797k = byteBuffer.asShortBuffer();
        this.f9798l = byteBuffer;
        this.f9787a = -1;
        this.f9794h = false;
        this.f9795i = null;
        this.f9799m = 0L;
        this.f9800n = 0L;
        this.f9801o = false;
    }

    public void setOutputSampleRateHz(int i) {
        this.f9787a = i;
    }

    public void setPitch(float f) {
        if (this.f9789c != f) {
            this.f9789c = f;
            this.f9794h = true;
        }
    }

    public void setSpeed(float f) {
        if (this.f9788b != f) {
            this.f9788b = f;
            this.f9794h = true;
        }
    }
}
