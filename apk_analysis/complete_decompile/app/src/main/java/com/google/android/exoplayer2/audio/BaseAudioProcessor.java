package com.google.android.exoplayer2.audio;

import androidx.annotation.CallSuper;
import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public abstract class BaseAudioProcessor implements AudioProcessor {

    /* renamed from: a */
    public AudioProcessor.AudioFormat f9656a;

    /* renamed from: b */
    public AudioProcessor.AudioFormat f9657b;

    /* renamed from: c */
    public ByteBuffer f9658c;

    /* renamed from: d */
    public ByteBuffer f9659d;

    /* renamed from: e */
    public boolean f9660e;
    protected AudioProcessor.AudioFormat inputAudioFormat;
    protected AudioProcessor.AudioFormat outputAudioFormat;

    public BaseAudioProcessor() {
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.f9658c = byteBuffer;
        this.f9659d = byteBuffer;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.f9656a = audioFormat;
        this.f9657b = audioFormat;
        this.inputAudioFormat = audioFormat;
        this.outputAudioFormat = audioFormat;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final AudioProcessor.AudioFormat configure(AudioProcessor.AudioFormat audioFormat) {
        this.f9656a = audioFormat;
        this.f9657b = onConfigure(audioFormat);
        if (isActive()) {
            return this.f9657b;
        }
        return AudioProcessor.AudioFormat.NOT_SET;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void flush() {
        this.f9659d = AudioProcessor.EMPTY_BUFFER;
        this.f9660e = false;
        this.inputAudioFormat = this.f9656a;
        this.outputAudioFormat = this.f9657b;
        onFlush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    @CallSuper
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.f9659d;
        this.f9659d = AudioProcessor.EMPTY_BUFFER;
        return byteBuffer;
    }

    public final boolean hasPendingOutput() {
        return this.f9659d.hasRemaining();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        if (this.f9657b != AudioProcessor.AudioFormat.NOT_SET) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    @CallSuper
    public boolean isEnded() {
        if (this.f9660e && this.f9659d == AudioProcessor.EMPTY_BUFFER) {
            return true;
        }
        return false;
    }

    public AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) {
        return AudioProcessor.AudioFormat.NOT_SET;
    }

    public void onFlush() {
    }

    public void onQueueEndOfStream() {
    }

    public void onReset() {
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void queueEndOfStream() {
        this.f9660e = true;
        onQueueEndOfStream();
    }

    public final ByteBuffer replaceOutputBuffer(int i) {
        if (this.f9658c.capacity() < i) {
            this.f9658c = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.f9658c.clear();
        }
        ByteBuffer byteBuffer = this.f9658c;
        this.f9659d = byteBuffer;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void reset() {
        flush();
        this.f9658c = AudioProcessor.EMPTY_BUFFER;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.f9656a = audioFormat;
        this.f9657b = audioFormat;
        this.inputAudioFormat = audioFormat;
        this.outputAudioFormat = audioFormat;
        onReset();
    }
}
