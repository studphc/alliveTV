package com.google.android.exoplayer2.audio;

import android.os.SystemClock;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.util.Log;

/* renamed from: com.google.android.exoplayer2.audio.e */
/* loaded from: classes.dex */
public final class C0651e implements AudioTrackPositionTracker$Listener {

    /* renamed from: a */
    public final /* synthetic */ DefaultAudioSink f9825a;

    public C0651e(DefaultAudioSink defaultAudioSink) {
        this.f9825a = defaultAudioSink;
    }

    @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker$Listener
    public final void onInvalidLatency(long j) {
        Log.m3027w("DefaultAudioSink", "Ignoring impossibly large audio latency: " + j);
    }

    @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker$Listener
    public final void onPositionAdvancing(long j) {
        AudioSink.Listener listener = this.f9825a.f9728r;
        if (listener != null) {
            listener.onPositionAdvancing(j);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker$Listener
    public final void onPositionFramesMismatch(long j, long j2, long j3, long j4) {
        StringBuilder sb = new StringBuilder("Spurious audio timestamp (frame position mismatch): ");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(j3);
        sb.append(", ");
        sb.append(j4);
        sb.append(", ");
        DefaultAudioSink defaultAudioSink = this.f9825a;
        sb.append(defaultAudioSink.m2458e());
        sb.append(", ");
        sb.append(defaultAudioSink.m2459f());
        String sb2 = sb.toString();
        if (!DefaultAudioSink.failOnSpuriousAudioTimestamp) {
            Log.m3027w("DefaultAudioSink", sb2);
            return;
        }
        throw new RuntimeException(sb2);
    }

    @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker$Listener
    public final void onSystemTimeUsMismatch(long j, long j2, long j3, long j4) {
        StringBuilder sb = new StringBuilder("Spurious audio timestamp (system clock mismatch): ");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(j3);
        sb.append(", ");
        sb.append(j4);
        sb.append(", ");
        DefaultAudioSink defaultAudioSink = this.f9825a;
        sb.append(defaultAudioSink.m2458e());
        sb.append(", ");
        sb.append(defaultAudioSink.m2459f());
        String sb2 = sb.toString();
        if (!DefaultAudioSink.failOnSpuriousAudioTimestamp) {
            Log.m3027w("DefaultAudioSink", sb2);
            return;
        }
        throw new RuntimeException(sb2);
    }

    @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker$Listener
    public final void onUnderrun(int i, long j) {
        DefaultAudioSink defaultAudioSink = this.f9825a;
        if (defaultAudioSink.f9728r != null) {
            defaultAudioSink.f9728r.onUnderrun(i, j, SystemClock.elapsedRealtime() - defaultAudioSink.f9708Z);
        }
    }
}
