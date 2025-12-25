package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.util.Log;
import p000.AbstractC1544md;

/* renamed from: com.google.android.exoplayer2.audio.b */
/* loaded from: classes.dex */
public final class C0648b implements AudioSink.Listener {

    /* renamed from: a */
    public final /* synthetic */ DecoderAudioRenderer f9814a;

    public C0648b(DecoderAudioRenderer decoderAudioRenderer) {
        this.f9814a = decoderAudioRenderer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
    public final void onAudioSinkError(Exception exc) {
        Log.m3024e("DecoderAudioRenderer", "Audio sink error", exc);
        this.f9814a.f9670n.audioSinkError(exc);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
    public final /* synthetic */ void onOffloadBufferEmptying() {
        AbstractC1544md.m6132b(this);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
    public final /* synthetic */ void onOffloadBufferFull() {
        AbstractC1544md.m6133c(this);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
    public final void onPositionAdvancing(long j) {
        this.f9814a.f9670n.positionAdvancing(j);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
    public final void onPositionDiscontinuity() {
        this.f9814a.onPositionDiscontinuity();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
    public final void onSkipSilenceEnabledChanged(boolean z) {
        this.f9814a.f9670n.skipSilenceEnabledChanged(z);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
    public final void onUnderrun(int i, long j, long j2) {
        this.f9814a.f9670n.underrun(i, j, j2);
    }
}
