package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;

/* renamed from: com.google.android.exoplayer2.audio.j */
/* loaded from: classes.dex */
public final class C0656j extends BaseAudioProcessor {

    /* renamed from: f */
    public int f9829f;

    /* renamed from: g */
    public int f9830g;

    /* renamed from: h */
    public boolean f9831h;

    /* renamed from: i */
    public int f9832i;

    /* renamed from: j */
    public byte[] f9833j;

    /* renamed from: k */
    public int f9834k;

    /* renamed from: l */
    public long f9835l;

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor, com.google.android.exoplayer2.audio.AudioProcessor
    public final ByteBuffer getOutput() {
        int i;
        if (super.isEnded() && (i = this.f9834k) > 0) {
            replaceOutputBuffer(i).put(this.f9833j, 0, this.f9834k).flip();
            this.f9834k = 0;
        }
        return super.getOutput();
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor, com.google.android.exoplayer2.audio.AudioProcessor
    public final boolean isEnded() {
        if (super.isEnded() && this.f9834k == 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public final AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) {
        if (audioFormat.encoding == 2) {
            this.f9831h = true;
            if (this.f9829f == 0 && this.f9830g == 0) {
                return AudioProcessor.AudioFormat.NOT_SET;
            }
            return audioFormat;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public final void onFlush() {
        if (this.f9831h) {
            this.f9831h = false;
            int i = this.f9830g;
            int i2 = this.inputAudioFormat.bytesPerFrame;
            this.f9833j = new byte[i * i2];
            this.f9832i = this.f9829f * i2;
        }
        this.f9834k = 0;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public final void onQueueEndOfStream() {
        if (this.f9831h) {
            if (this.f9834k > 0) {
                this.f9835l += r0 / this.inputAudioFormat.bytesPerFrame;
            }
            this.f9834k = 0;
        }
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public final void onReset() {
        this.f9833j = Util.EMPTY_BYTE_ARRAY;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void queueInput(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        if (i == 0) {
            return;
        }
        int min = Math.min(i, this.f9832i);
        this.f9835l += min / this.inputAudioFormat.bytesPerFrame;
        this.f9832i -= min;
        byteBuffer.position(position + min);
        if (this.f9832i > 0) {
            return;
        }
        int i2 = i - min;
        int length = (this.f9834k + i2) - this.f9833j.length;
        ByteBuffer replaceOutputBuffer = replaceOutputBuffer(length);
        int constrainValue = Util.constrainValue(length, 0, this.f9834k);
        replaceOutputBuffer.put(this.f9833j, 0, constrainValue);
        int constrainValue2 = Util.constrainValue(length - constrainValue, 0, i2);
        byteBuffer.limit(byteBuffer.position() + constrainValue2);
        replaceOutputBuffer.put(byteBuffer);
        byteBuffer.limit(limit);
        int i3 = i2 - constrainValue2;
        int i4 = this.f9834k - constrainValue;
        this.f9834k = i4;
        byte[] bArr = this.f9833j;
        System.arraycopy(bArr, constrainValue, bArr, 0, i4);
        byteBuffer.get(this.f9833j, this.f9834k, i3);
        this.f9834k += i3;
        replaceOutputBuffer.flip();
    }
}
