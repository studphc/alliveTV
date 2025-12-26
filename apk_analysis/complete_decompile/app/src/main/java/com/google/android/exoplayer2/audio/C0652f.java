package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import android.media.AudioTrack$StreamEventCallback;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.util.Assertions;
import p000.i00;

/* renamed from: com.google.android.exoplayer2.audio.f */
/* loaded from: classes.dex */
public final class C0652f extends AudioTrack$StreamEventCallback {

    /* renamed from: a */
    public final /* synthetic */ i00 f9826a;

    public C0652f(i00 i00Var) {
        this.f9826a = i00Var;
    }

    public final void onDataRequest(AudioTrack audioTrack, int i) {
        boolean z;
        if (audioTrack == this.f9826a.f18236c.f9731u) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        DefaultAudioSink defaultAudioSink = this.f9826a.f18236c;
        AudioSink.Listener listener = defaultAudioSink.f9728r;
        if (listener != null && defaultAudioSink.f9703U) {
            listener.onOffloadBufferEmptying();
        }
    }

    public final void onTearDown(AudioTrack audioTrack) {
        boolean z;
        if (audioTrack == this.f9826a.f18236c.f9731u) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        DefaultAudioSink defaultAudioSink = this.f9826a.f18236c;
        AudioSink.Listener listener = defaultAudioSink.f9728r;
        if (listener != null && defaultAudioSink.f9703U) {
            listener.onOffloadBufferEmptying();
        }
    }
}
