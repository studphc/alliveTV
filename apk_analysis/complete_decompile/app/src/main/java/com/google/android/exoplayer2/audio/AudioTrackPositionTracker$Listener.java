package com.google.android.exoplayer2.audio;

/* loaded from: classes.dex */
public interface AudioTrackPositionTracker$Listener {
    void onInvalidLatency(long j);

    void onPositionAdvancing(long j);

    void onPositionFramesMismatch(long j, long j2, long j3, long j4);

    void onSystemTimeUsMismatch(long j, long j2, long j3, long j4);

    void onUnderrun(int i, long j);
}
