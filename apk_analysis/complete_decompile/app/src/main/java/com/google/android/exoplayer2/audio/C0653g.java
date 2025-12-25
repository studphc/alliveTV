package com.google.android.exoplayer2.audio;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;

/* renamed from: com.google.android.exoplayer2.audio.g */
/* loaded from: classes.dex */
public final class C0653g extends BaseAudioProcessor {

    /* renamed from: f */
    public static final int f9827f = Float.floatToIntBits(Float.NaN);

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public final AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) {
        int i = audioFormat.encoding;
        if (Util.isEncodingHighResolutionPcm(i)) {
            if (i != 4) {
                return new AudioProcessor.AudioFormat(audioFormat.sampleRate, audioFormat.channelCount, 4);
            }
            return AudioProcessor.AudioFormat.NOT_SET;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void queueInput(ByteBuffer byteBuffer) {
        ByteBuffer replaceOutputBuffer;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int i2 = this.inputAudioFormat.encoding;
        int i3 = f9827f;
        if (i2 != 536870912) {
            if (i2 == 805306368) {
                replaceOutputBuffer = replaceOutputBuffer(i);
                while (position < limit) {
                    int floatToIntBits = Float.floatToIntBits((float) (((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24)) * 4.656612875245797E-10d));
                    if (floatToIntBits == i3) {
                        floatToIntBits = Float.floatToIntBits(RecyclerView.f7068F0);
                    }
                    replaceOutputBuffer.putInt(floatToIntBits);
                    position += 4;
                }
            } else {
                throw new IllegalStateException();
            }
        } else {
            replaceOutputBuffer = replaceOutputBuffer((i / 3) * 4);
            while (position < limit) {
                int floatToIntBits2 = Float.floatToIntBits((float) ((((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24)) * 4.656612875245797E-10d));
                if (floatToIntBits2 == i3) {
                    floatToIntBits2 = Float.floatToIntBits(RecyclerView.f7068F0);
                }
                replaceOutputBuffer.putInt(floatToIntBits2);
                position += 3;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        replaceOutputBuffer.flip();
    }
}
