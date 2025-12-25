package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public interface AudioProcessor {
    public static final ByteBuffer EMPTY_BUFFER = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    /* loaded from: classes.dex */
    public static final class AudioFormat {
        public static final AudioFormat NOT_SET = new AudioFormat(-1, -1, -1);
        public final int bytesPerFrame;
        public final int channelCount;
        public final int encoding;
        public final int sampleRate;

        public AudioFormat(int i, int i2, int i3) {
            int i4;
            this.sampleRate = i;
            this.channelCount = i2;
            this.encoding = i3;
            if (Util.isEncodingLinearPcm(i3)) {
                i4 = Util.getPcmFrameSize(i3, i2);
            } else {
                i4 = -1;
            }
            this.bytesPerFrame = i4;
        }

        public String toString() {
            return "AudioFormat[sampleRate=" + this.sampleRate + ", channelCount=" + this.channelCount + ", encoding=" + this.encoding + ']';
        }
    }

    /* loaded from: classes.dex */
    public static final class UnhandledAudioFormatException extends Exception {
        public UnhandledAudioFormatException(AudioFormat audioFormat) {
            super("Unhandled format: " + audioFormat);
        }
    }

    AudioFormat configure(AudioFormat audioFormat);

    void flush();

    ByteBuffer getOutput();

    boolean isActive();

    boolean isEnded();

    void queueEndOfStream();

    void queueInput(ByteBuffer byteBuffer);

    void reset();
}
