package p000;

import com.google.android.exoplayer2.C0672f;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.StandaloneMediaClock;

/* loaded from: classes.dex */
public final class x00 implements MediaClock {

    /* renamed from: a */
    public final StandaloneMediaClock f28410a;

    /* renamed from: b */
    public final C0672f f28411b;

    /* renamed from: c */
    public Renderer f28412c;

    /* renamed from: d */
    public MediaClock f28413d;

    /* renamed from: e */
    public boolean f28414e = true;

    /* renamed from: f */
    public boolean f28415f;

    public x00(C0672f c0672f, Clock clock) {
        this.f28411b = c0672f;
        this.f28410a = new StandaloneMediaClock(clock);
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public final PlaybackParameters getPlaybackParameters() {
        MediaClock mediaClock = this.f28413d;
        if (mediaClock != null) {
            return mediaClock.getPlaybackParameters();
        }
        return this.f28410a.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public final long getPositionUs() {
        if (this.f28414e) {
            return this.f28410a.getPositionUs();
        }
        return ((MediaClock) Assertions.checkNotNull(this.f28413d)).getPositionUs();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public final void setPlaybackParameters(PlaybackParameters playbackParameters) {
        MediaClock mediaClock = this.f28413d;
        if (mediaClock != null) {
            mediaClock.setPlaybackParameters(playbackParameters);
            playbackParameters = this.f28413d.getPlaybackParameters();
        }
        this.f28410a.setPlaybackParameters(playbackParameters);
    }
}
