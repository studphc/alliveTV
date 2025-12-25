package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class TeeAudioProcessor extends BaseAudioProcessor {

    /* renamed from: f */
    public final AudioBufferSink f9802f;

    /* loaded from: classes.dex */
    public interface AudioBufferSink {
        void flush(int i, int i2, int i3);

        void handleBuffer(ByteBuffer byteBuffer);
    }

    /* loaded from: classes.dex */
    public static final class WavFileAudioBufferSink implements AudioBufferSink {

        /* renamed from: a */
        public final String f9803a;

        /* renamed from: b */
        public final byte[] f9804b;

        /* renamed from: c */
        public final ByteBuffer f9805c;

        /* renamed from: d */
        public int f9806d;

        /* renamed from: e */
        public int f9807e;

        /* renamed from: f */
        public int f9808f;

        /* renamed from: g */
        public RandomAccessFile f9809g;

        /* renamed from: h */
        public int f9810h;

        /* renamed from: i */
        public int f9811i;

        public WavFileAudioBufferSink(String str) {
            this.f9803a = str;
            byte[] bArr = new byte[1024];
            this.f9804b = bArr;
            this.f9805c = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        }

        /* renamed from: a */
        public final void m2477a() {
            if (this.f9809g != null) {
                return;
            }
            int i = this.f9810h;
            this.f9810h = i + 1;
            RandomAccessFile randomAccessFile = new RandomAccessFile(Util.formatInvariant("%s-%04d.wav", this.f9803a, Integer.valueOf(i)), "rw");
            randomAccessFile.writeInt(WavUtil.RIFF_FOURCC);
            randomAccessFile.writeInt(-1);
            randomAccessFile.writeInt(WavUtil.WAVE_FOURCC);
            randomAccessFile.writeInt(WavUtil.FMT_FOURCC);
            ByteBuffer byteBuffer = this.f9805c;
            byteBuffer.clear();
            byteBuffer.putInt(16);
            byteBuffer.putShort((short) WavUtil.getTypeForPcmEncoding(this.f9808f));
            byteBuffer.putShort((short) this.f9807e);
            byteBuffer.putInt(this.f9806d);
            int pcmFrameSize = Util.getPcmFrameSize(this.f9808f, this.f9807e);
            byteBuffer.putInt(this.f9806d * pcmFrameSize);
            byteBuffer.putShort((short) pcmFrameSize);
            byteBuffer.putShort((short) ((pcmFrameSize * 8) / this.f9807e));
            randomAccessFile.write(this.f9804b, 0, byteBuffer.position());
            randomAccessFile.writeInt(WavUtil.DATA_FOURCC);
            randomAccessFile.writeInt(-1);
            this.f9809g = randomAccessFile;
            this.f9811i = 44;
        }

        /* renamed from: b */
        public final void m2478b() {
            byte[] bArr = this.f9804b;
            ByteBuffer byteBuffer = this.f9805c;
            RandomAccessFile randomAccessFile = this.f9809g;
            if (randomAccessFile == null) {
                return;
            }
            try {
                byteBuffer.clear();
                byteBuffer.putInt(this.f9811i - 8);
                randomAccessFile.seek(4L);
                randomAccessFile.write(bArr, 0, 4);
                byteBuffer.clear();
                byteBuffer.putInt(this.f9811i - 44);
                randomAccessFile.seek(40L);
                randomAccessFile.write(bArr, 0, 4);
            } catch (IOException e) {
                Log.m3028w("WaveFileAudioBufferSink", "Error updating file size", e);
            }
            try {
                randomAccessFile.close();
            } finally {
                this.f9809g = null;
            }
        }

        @Override // com.google.android.exoplayer2.audio.TeeAudioProcessor.AudioBufferSink
        public void flush(int i, int i2, int i3) {
            try {
                m2478b();
            } catch (IOException e) {
                Log.m3024e("WaveFileAudioBufferSink", "Error resetting", e);
            }
            this.f9806d = i;
            this.f9807e = i2;
            this.f9808f = i3;
        }

        @Override // com.google.android.exoplayer2.audio.TeeAudioProcessor.AudioBufferSink
        public void handleBuffer(ByteBuffer byteBuffer) {
            try {
                m2477a();
                RandomAccessFile randomAccessFile = (RandomAccessFile) Assertions.checkNotNull(this.f9809g);
                while (byteBuffer.hasRemaining()) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.f9804b;
                    int min = Math.min(remaining, bArr.length);
                    byteBuffer.get(bArr, 0, min);
                    randomAccessFile.write(bArr, 0, min);
                    this.f9811i += min;
                }
            } catch (IOException e) {
                Log.m3024e("WaveFileAudioBufferSink", "Error writing data", e);
            }
        }
    }

    public TeeAudioProcessor(AudioBufferSink audioBufferSink) {
        this.f9802f = (AudioBufferSink) Assertions.checkNotNull(audioBufferSink);
    }

    /* renamed from: a */
    public final void m2476a() {
        if (isActive()) {
            AudioProcessor.AudioFormat audioFormat = this.inputAudioFormat;
            this.f9802f.flush(audioFormat.sampleRate, audioFormat.channelCount, audioFormat.encoding);
        }
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) {
        return audioFormat;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onFlush() {
        m2476a();
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onQueueEndOfStream() {
        m2476a();
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onReset() {
        m2476a();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining == 0) {
            return;
        }
        this.f9802f.handleBuffer(byteBuffer.asReadOnlyBuffer());
        replaceOutputBuffer(remaining).put(byteBuffer).flip();
    }
}
