package p000;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* loaded from: classes.dex */
public final class l52 {

    /* renamed from: s */
    public static final MediaSource.MediaPeriodId f22331s = new MediaSource.MediaPeriodId(new Object());

    /* renamed from: a */
    public final Timeline f22332a;

    /* renamed from: b */
    public final MediaSource.MediaPeriodId f22333b;

    /* renamed from: c */
    public final long f22334c;

    /* renamed from: d */
    public final long f22335d;

    /* renamed from: e */
    public final int f22336e;

    /* renamed from: f */
    public final ExoPlaybackException f22337f;

    /* renamed from: g */
    public final boolean f22338g;

    /* renamed from: h */
    public final TrackGroupArray f22339h;

    /* renamed from: i */
    public final TrackSelectorResult f22340i;

    /* renamed from: j */
    public final List f22341j;

    /* renamed from: k */
    public final MediaSource.MediaPeriodId f22342k;

    /* renamed from: l */
    public final boolean f22343l;

    /* renamed from: m */
    public final int f22344m;

    /* renamed from: n */
    public final PlaybackParameters f22345n;

    /* renamed from: o */
    public final boolean f22346o;

    /* renamed from: p */
    public volatile long f22347p;

    /* renamed from: q */
    public volatile long f22348q;

    /* renamed from: r */
    public volatile long f22349r;

    public l52(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, int i, ExoPlaybackException exoPlaybackException, boolean z, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult, List list, MediaSource.MediaPeriodId mediaPeriodId2, boolean z2, int i2, PlaybackParameters playbackParameters, long j3, long j4, long j5, boolean z3) {
        this.f22332a = timeline;
        this.f22333b = mediaPeriodId;
        this.f22334c = j;
        this.f22335d = j2;
        this.f22336e = i;
        this.f22337f = exoPlaybackException;
        this.f22338g = z;
        this.f22339h = trackGroupArray;
        this.f22340i = trackSelectorResult;
        this.f22341j = list;
        this.f22342k = mediaPeriodId2;
        this.f22343l = z2;
        this.f22344m = i2;
        this.f22345n = playbackParameters;
        this.f22347p = j3;
        this.f22348q = j4;
        this.f22349r = j5;
        this.f22346o = z3;
    }

    /* renamed from: h */
    public static l52 m5855h(TrackSelectorResult trackSelectorResult) {
        Timeline timeline = Timeline.EMPTY;
        TrackGroupArray trackGroupArray = TrackGroupArray.EMPTY;
        ImmutableList m3902of = ImmutableList.m3902of();
        PlaybackParameters playbackParameters = PlaybackParameters.DEFAULT;
        MediaSource.MediaPeriodId mediaPeriodId = f22331s;
        return new l52(timeline, mediaPeriodId, C0643C.TIME_UNSET, 0L, 1, null, false, trackGroupArray, trackSelectorResult, m3902of, mediaPeriodId, false, 0, playbackParameters, 0L, 0L, 0L, false);
    }

    /* renamed from: a */
    public final l52 m5856a(MediaSource.MediaPeriodId mediaPeriodId) {
        return new l52(this.f22332a, this.f22333b, this.f22334c, this.f22335d, this.f22336e, this.f22337f, this.f22338g, this.f22339h, this.f22340i, this.f22341j, mediaPeriodId, this.f22343l, this.f22344m, this.f22345n, this.f22347p, this.f22348q, this.f22349r, this.f22346o);
    }

    /* renamed from: b */
    public final l52 m5857b(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, long j3, long j4, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult, List list) {
        return new l52(this.f22332a, mediaPeriodId, j2, j3, this.f22336e, this.f22337f, this.f22338g, trackGroupArray, trackSelectorResult, list, this.f22342k, this.f22343l, this.f22344m, this.f22345n, this.f22347p, j4, j, this.f22346o);
    }

    /* renamed from: c */
    public final l52 m5858c(int i, boolean z) {
        return new l52(this.f22332a, this.f22333b, this.f22334c, this.f22335d, this.f22336e, this.f22337f, this.f22338g, this.f22339h, this.f22340i, this.f22341j, this.f22342k, z, i, this.f22345n, this.f22347p, this.f22348q, this.f22349r, this.f22346o);
    }

    /* renamed from: d */
    public final l52 m5859d(ExoPlaybackException exoPlaybackException) {
        return new l52(this.f22332a, this.f22333b, this.f22334c, this.f22335d, this.f22336e, exoPlaybackException, this.f22338g, this.f22339h, this.f22340i, this.f22341j, this.f22342k, this.f22343l, this.f22344m, this.f22345n, this.f22347p, this.f22348q, this.f22349r, this.f22346o);
    }

    /* renamed from: e */
    public final l52 m5860e(PlaybackParameters playbackParameters) {
        return new l52(this.f22332a, this.f22333b, this.f22334c, this.f22335d, this.f22336e, this.f22337f, this.f22338g, this.f22339h, this.f22340i, this.f22341j, this.f22342k, this.f22343l, this.f22344m, playbackParameters, this.f22347p, this.f22348q, this.f22349r, this.f22346o);
    }

    /* renamed from: f */
    public final l52 m5861f(int i) {
        return new l52(this.f22332a, this.f22333b, this.f22334c, this.f22335d, i, this.f22337f, this.f22338g, this.f22339h, this.f22340i, this.f22341j, this.f22342k, this.f22343l, this.f22344m, this.f22345n, this.f22347p, this.f22348q, this.f22349r, this.f22346o);
    }

    /* renamed from: g */
    public final l52 m5862g(Timeline timeline) {
        return new l52(timeline, this.f22333b, this.f22334c, this.f22335d, this.f22336e, this.f22337f, this.f22338g, this.f22339h, this.f22340i, this.f22341j, this.f22342k, this.f22343l, this.f22344m, this.f22345n, this.f22347p, this.f22348q, this.f22349r, this.f22346o);
    }
}
