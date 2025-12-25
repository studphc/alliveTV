package p000;

import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ClippingMediaPeriod;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;

/* loaded from: classes.dex */
public final class ul1 {

    /* renamed from: a */
    public final Object f27321a;

    /* renamed from: b */
    public final Object f27322b;

    /* renamed from: c */
    public final SampleStream[] f27323c;

    /* renamed from: d */
    public boolean f27324d;

    /* renamed from: e */
    public boolean f27325e;

    /* renamed from: f */
    public vl1 f27326f;

    /* renamed from: g */
    public boolean f27327g;

    /* renamed from: h */
    public final boolean[] f27328h;

    /* renamed from: i */
    public final RendererCapabilities[] f27329i;

    /* renamed from: j */
    public final TrackSelector f27330j;

    /* renamed from: k */
    public final um1 f27331k;

    /* renamed from: l */
    public ul1 f27332l;

    /* renamed from: m */
    public TrackGroupArray f27333m;

    /* renamed from: n */
    public TrackSelectorResult f27334n;

    /* renamed from: o */
    public long f27335o;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.google.android.exoplayer2.source.ClippingMediaPeriod] */
    public ul1(RendererCapabilities[] rendererCapabilitiesArr, long j, TrackSelector trackSelector, Allocator allocator, um1 um1Var, vl1 vl1Var, TrackSelectorResult trackSelectorResult) {
        this.f27329i = rendererCapabilitiesArr;
        this.f27335o = j;
        this.f27330j = trackSelector;
        this.f27331k = um1Var;
        MediaSource.MediaPeriodId mediaPeriodId = vl1Var.f27854a;
        this.f27322b = mediaPeriodId.periodUid;
        this.f27326f = vl1Var;
        this.f27333m = TrackGroupArray.EMPTY;
        this.f27334n = trackSelectorResult;
        this.f27323c = new SampleStream[rendererCapabilitiesArr.length];
        this.f27328h = new boolean[rendererCapabilitiesArr.length];
        um1Var.getClass();
        Object childTimelineUidFromConcatenatedUid = AbstractConcatenatedTimeline.getChildTimelineUidFromConcatenatedUid(mediaPeriodId.periodUid);
        MediaSource.MediaPeriodId copyWithPeriodUid = mediaPeriodId.copyWithPeriodUid(AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(mediaPeriodId.periodUid));
        tm1 tm1Var = (tm1) Assertions.checkNotNull((tm1) um1Var.f27366d.get(childTimelineUidFromConcatenatedUid));
        um1Var.f27371i.add(tm1Var);
        sm1 sm1Var = (sm1) um1Var.f27370h.get(tm1Var);
        if (sm1Var != null) {
            sm1Var.f26489a.enable(sm1Var.f26490b);
        }
        tm1Var.f26878c.add(copyWithPeriodUid);
        MaskingMediaPeriod createPeriod = tm1Var.f26876a.createPeriod(copyWithPeriodUid, allocator, vl1Var.f27855b);
        um1Var.f27365c.put(createPeriod, tm1Var);
        um1Var.m7751c();
        long j2 = vl1Var.f27857d;
        this.f27321a = j2 != C0643C.TIME_UNSET ? new ClippingMediaPeriod(createPeriod, true, 0L, j2) : createPeriod;
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [com.google.android.exoplayer2.source.MediaPeriod, java.lang.Object] */
    /* renamed from: a */
    public final long m7738a(TrackSelectorResult trackSelectorResult, long j, boolean z, boolean[] zArr) {
        RendererCapabilities[] rendererCapabilitiesArr;
        SampleStream[] sampleStreamArr;
        boolean z2;
        int i = 0;
        while (true) {
            boolean z3 = true;
            if (i >= trackSelectorResult.length) {
                break;
            }
            if (z || !trackSelectorResult.isEquivalent(this.f27334n, i)) {
                z3 = false;
            }
            this.f27328h[i] = z3;
            i++;
        }
        int i2 = 0;
        while (true) {
            rendererCapabilitiesArr = this.f27329i;
            int length = rendererCapabilitiesArr.length;
            sampleStreamArr = this.f27323c;
            if (i2 >= length) {
                break;
            }
            if (rendererCapabilitiesArr[i2].getTrackType() == -2) {
                sampleStreamArr[i2] = null;
            }
            i2++;
        }
        m7739b();
        this.f27334n = trackSelectorResult;
        m7740c();
        long selectTracks = this.f27321a.selectTracks(trackSelectorResult.selections, this.f27328h, this.f27323c, zArr, j);
        for (int i3 = 0; i3 < rendererCapabilitiesArr.length; i3++) {
            if (rendererCapabilitiesArr[i3].getTrackType() == -2 && this.f27334n.isRendererEnabled(i3)) {
                sampleStreamArr[i3] = new EmptySampleStream();
            }
        }
        this.f27325e = false;
        for (int i4 = 0; i4 < sampleStreamArr.length; i4++) {
            if (sampleStreamArr[i4] != null) {
                Assertions.checkState(trackSelectorResult.isRendererEnabled(i4));
                if (rendererCapabilitiesArr[i4].getTrackType() != -2) {
                    this.f27325e = true;
                }
            } else {
                if (trackSelectorResult.selections[i4] == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Assertions.checkState(z2);
            }
        }
        return selectTracks;
    }

    /* renamed from: b */
    public final void m7739b() {
        if (this.f27332l == null) {
            int i = 0;
            while (true) {
                TrackSelectorResult trackSelectorResult = this.f27334n;
                if (i < trackSelectorResult.length) {
                    boolean isRendererEnabled = trackSelectorResult.isRendererEnabled(i);
                    ExoTrackSelection exoTrackSelection = this.f27334n.selections[i];
                    if (isRendererEnabled && exoTrackSelection != null) {
                        exoTrackSelection.disable();
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    public final void m7740c() {
        if (this.f27332l == null) {
            int i = 0;
            while (true) {
                TrackSelectorResult trackSelectorResult = this.f27334n;
                if (i < trackSelectorResult.length) {
                    boolean isRendererEnabled = trackSelectorResult.isRendererEnabled(i);
                    ExoTrackSelection exoTrackSelection = this.f27334n.selections[i];
                    if (isRendererEnabled && exoTrackSelection != null) {
                        exoTrackSelection.enable();
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.google.android.exoplayer2.source.MediaPeriod, java.lang.Object] */
    /* renamed from: d */
    public final long m7741d() {
        long j;
        if (!this.f27324d) {
            return this.f27326f.f27855b;
        }
        if (this.f27325e) {
            j = this.f27321a.getBufferedPositionUs();
        } else {
            j = Long.MIN_VALUE;
        }
        if (j == Long.MIN_VALUE) {
            return this.f27326f.f27858e;
        }
        return j;
    }

    /* renamed from: e */
    public final long m7742e() {
        return this.f27326f.f27855b + this.f27335o;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.exoplayer2.source.MediaPeriod, java.lang.Object] */
    /* renamed from: f */
    public final void m7743f() {
        m7739b();
        ?? r0 = this.f27321a;
        try {
            boolean z = r0 instanceof ClippingMediaPeriod;
            um1 um1Var = this.f27331k;
            if (z) {
                um1Var.m7754f(((ClippingMediaPeriod) r0).mediaPeriod);
            } else {
                um1Var.m7754f(r0);
            }
        } catch (RuntimeException e) {
            Log.m3024e("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    /* renamed from: g */
    public final TrackSelectorResult m7744g(float f, Timeline timeline) {
        TrackSelectorResult selectTracks = this.f27330j.selectTracks(this.f27329i, this.f27333m, this.f27326f.f27854a, timeline);
        for (ExoTrackSelection exoTrackSelection : selectTracks.selections) {
            if (exoTrackSelection != null) {
                exoTrackSelection.onPlaybackSpeed(f);
            }
        }
        return selectTracks;
    }

    /* renamed from: h */
    public final void m7745h() {
        Object obj = this.f27321a;
        if (obj instanceof ClippingMediaPeriod) {
            long j = this.f27326f.f27857d;
            if (j == C0643C.TIME_UNSET) {
                j = Long.MIN_VALUE;
            }
            ((ClippingMediaPeriod) obj).updateClipping(0L, j);
        }
    }
}
