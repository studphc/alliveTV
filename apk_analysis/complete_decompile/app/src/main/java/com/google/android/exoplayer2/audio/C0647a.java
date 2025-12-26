package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;

/* renamed from: com.google.android.exoplayer2.audio.a */
/* loaded from: classes.dex */
public final class C0647a extends BaseAudioProcessor {

    /* renamed from: f */
    public int[] f9812f;

    /* renamed from: g */
    public int[] f9813g;

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public final AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) {
        boolean z;
        boolean z2;
        int[] iArr = this.f9812f;
        if (iArr == null) {
            return AudioProcessor.AudioFormat.NOT_SET;
        }
        if (audioFormat.encoding == 2) {
            if (audioFormat.channelCount != iArr.length) {
                z = true;
            } else {
                z = false;
            }
            for (int i = 0; i < iArr.length; i++) {
                int i2 = iArr[i];
                if (i2 < audioFormat.channelCount) {
                    if (i2 != i) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z |= z2;
                } else {
                    throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
                }
            }
            if (z) {
                return new AudioProcessor.AudioFormat(audioFormat.sampleRate, iArr.length, 2);
            }
            return AudioProcessor.AudioFormat.NOT_SET;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public final void onFlush() {
        this.f9813g = this.f9812f;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public final void onReset() {
        this.f9813g = null;
        this.f9812f = null;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void queueInput(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) Assertions.checkNotNull(this.f9813g);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer replaceOutputBuffer = replaceOutputBuffer(((limit - position) / this.inputAudioFormat.bytesPerFrame) * this.outputAudioFormat.bytesPerFrame);
        while (position < limit) {
            for (int i : iArr) {
                replaceOutputBuffer.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.inputAudioFormat.bytesPerFrame;
        }
        byteBuffer.position(limit);
        replaceOutputBuffer.flip();
    }
}
