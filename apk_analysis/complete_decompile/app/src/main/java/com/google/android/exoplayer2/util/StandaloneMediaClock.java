package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.PlaybackParameters;

/* loaded from: classes.dex */
public final class StandaloneMediaClock implements MediaClock {

    /* renamed from: a */
    public final Clock f12762a;

    /* renamed from: b */
    public boolean f12763b;

    /* renamed from: c */
    public long f12764c;

    /* renamed from: d */
    public long f12765d;

    /* renamed from: e */
    public PlaybackParameters f12766e = PlaybackParameters.DEFAULT;

    public StandaloneMediaClock(Clock clock) {
        this.f12762a = clock;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters getPlaybackParameters() {
        return this.f12766e;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        long mediaTimeUsForPlayoutTimeMs;
        long j = this.f12764c;
        if (this.f12763b) {
            long elapsedRealtime = this.f12762a.elapsedRealtime() - this.f12765d;
            PlaybackParameters playbackParameters = this.f12766e;
            if (playbackParameters.speed == 1.0f) {
                mediaTimeUsForPlayoutTimeMs = Util.msToUs(elapsedRealtime);
            } else {
                mediaTimeUsForPlayoutTimeMs = playbackParameters.getMediaTimeUsForPlayoutTimeMs(elapsedRealtime);
            }
            return j + mediaTimeUsForPlayoutTimeMs;
        }
        return j;
    }

    public void resetPosition(long j) {
        this.f12764c = j;
        if (this.f12763b) {
            this.f12765d = this.f12762a.elapsedRealtime();
        }
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        if (this.f12763b) {
            resetPosition(getPositionUs());
        }
        this.f12766e = playbackParameters;
    }

    public void start() {
        if (!this.f12763b) {
            this.f12765d = this.f12762a.elapsedRealtime();
            this.f12763b = true;
        }
    }

    public void stop() {
        if (this.f12763b) {
            resetPosition(getPositionUs());
            this.f12763b = false;
        }
    }
}
