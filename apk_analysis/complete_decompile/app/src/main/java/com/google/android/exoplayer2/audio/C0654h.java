package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.util.Log;

/* renamed from: com.google.android.exoplayer2.audio.h */
/* loaded from: classes.dex */
public final class C0654h implements AudioSink.Listener {

    /* renamed from: a */
    public final /* synthetic */ MediaCodecAudioRenderer f9828a;

    public C0654h(MediaCodecAudioRenderer mediaCodecAudioRenderer) {
        this.f9828a = mediaCodecAudioRenderer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
    public final void onAudioSinkError(Exception exc) {
        Log.m3024e("MediaCodecAudioRenderer", "Audio sink error", exc);
        this.f9828a.f9757G0.audioSinkError(exc);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
    public final void onOffloadBufferEmptying() {
        Renderer.WakeupListener wakeupListener = this.f9828a.f9767Q0;
        if (wakeupListener != null) {
            wakeupListener.onWakeup();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
    public final void onOffloadBufferFull() {
        Renderer.WakeupListener wakeupListener = this.f9828a.f9767Q0;
        if (wakeupListener != null) {
            wakeupListener.onSleep();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
    public final void onPositionAdvancing(long j) {
        this.f9828a.f9757G0.positionAdvancing(j);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
    public final void onPositionDiscontinuity() {
        this.f9828a.onPositionDiscontinuity();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
    public final void onSkipSilenceEnabledChanged(boolean z) {
        this.f9828a.f9757G0.skipSilenceEnabledChanged(z);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
    public final void onUnderrun(int i, long j, long j2) {
        this.f9828a.f9757G0.underrun(i, j, j2);
    }
}
