package p000;

import android.util.Pair;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.source.ads.ServerSideAdInsertionMediaSource;
import com.google.android.exoplayer2.source.ads.ServerSideAdInsertionUtil;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class xg2 implements MediaPeriod {

    /* renamed from: a */
    public final ah2 f28550a;

    /* renamed from: b */
    public final MediaSource.MediaPeriodId f28551b;

    /* renamed from: c */
    public final MediaSourceEventListener.EventDispatcher f28552c;

    /* renamed from: d */
    public final DrmSessionEventListener.EventDispatcher f28553d;

    /* renamed from: e */
    public MediaPeriod.Callback f28554e;

    /* renamed from: f */
    public long f28555f;

    /* renamed from: g */
    public boolean[] f28556g = new boolean[0];

    public xg2(ah2 ah2Var, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener.EventDispatcher eventDispatcher2) {
        this.f28550a = ah2Var;
        this.f28551b = mediaPeriodId;
        this.f28552c = eventDispatcher;
        this.f28553d = eventDispatcher2;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final boolean continueLoading(long j) {
        long streamPositionUs;
        ah2 ah2Var = this.f28550a;
        xg2 xg2Var = ah2Var.f196f;
        if (xg2Var != null && !equals(xg2Var)) {
            for (Pair pair : ah2Var.f193c.values()) {
                xg2Var.f28552c.loadCompleted((LoadEventInfo) pair.first, ServerSideAdInsertionMediaSource.m2759b(xg2Var, (MediaLoadData) pair.second, ah2Var.f195e));
                this.f28552c.loadStarted((LoadEventInfo) pair.first, ServerSideAdInsertionMediaSource.m2759b(this, (MediaLoadData) pair.second, ah2Var.f195e));
            }
        }
        ah2Var.f196f = this;
        long j2 = this.f28555f;
        MediaSource.MediaPeriodId mediaPeriodId = this.f28551b;
        if (j < j2) {
            streamPositionUs = ServerSideAdInsertionUtil.getStreamPositionUs(j2, mediaPeriodId, ah2Var.f195e) - (this.f28555f - j);
        } else {
            streamPositionUs = ServerSideAdInsertionUtil.getStreamPositionUs(j, mediaPeriodId, ah2Var.f195e);
        }
        return ah2Var.f191a.continueLoading(streamPositionUs);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final void discardBuffer(long j, boolean z) {
        ah2 ah2Var = this.f28550a;
        ah2Var.getClass();
        ah2Var.f191a.discardBuffer(ServerSideAdInsertionUtil.getStreamPositionUs(j, this.f28551b, ah2Var.f195e), z);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        ah2 ah2Var = this.f28550a;
        ah2Var.getClass();
        AdPlaybackState adPlaybackState = ah2Var.f195e;
        MediaSource.MediaPeriodId mediaPeriodId = this.f28551b;
        return ServerSideAdInsertionUtil.getMediaPeriodPositionUs(ah2Var.f191a.getAdjustedSeekPositionUs(ServerSideAdInsertionUtil.getStreamPositionUs(j, mediaPeriodId, adPlaybackState), seekParameters), mediaPeriodId, ah2Var.f195e);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final long getBufferedPositionUs() {
        return this.f28550a.m88a(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final long getNextLoadPositionUs() {
        ah2 ah2Var = this.f28550a;
        return ah2Var.m89b(this, ah2Var.f191a.getNextLoadPositionUs());
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final List getStreamKeys(List list) {
        return this.f28550a.f191a.getStreamKeys(list);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final TrackGroupArray getTrackGroups() {
        return this.f28550a.f191a.getTrackGroups();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final boolean isLoading() {
        ah2 ah2Var = this.f28550a;
        if (equals(ah2Var.f196f) && ah2Var.f191a.isLoading()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final void maybeThrowPrepareError() {
        this.f28550a.f191a.maybeThrowPrepareError();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final void prepare(MediaPeriod.Callback callback, long j) {
        this.f28554e = callback;
        ah2 ah2Var = this.f28550a;
        this.f28555f = j;
        if (ah2Var.f197g) {
            if (ah2Var.f198h) {
                ((MediaPeriod.Callback) Assertions.checkNotNull(callback)).onPrepared(this);
            }
        } else {
            ah2Var.f197g = true;
            ah2Var.f191a.prepare(ah2Var, ServerSideAdInsertionUtil.getStreamPositionUs(j, this.f28551b, ah2Var.f195e));
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long readDiscontinuity() {
        ah2 ah2Var = this.f28550a;
        if (!equals(ah2Var.f192b.get(0))) {
            return C0643C.TIME_UNSET;
        }
        long readDiscontinuity = ah2Var.f191a.readDiscontinuity();
        if (readDiscontinuity == C0643C.TIME_UNSET) {
            return C0643C.TIME_UNSET;
        }
        return ServerSideAdInsertionUtil.getMediaPeriodPositionUs(readDiscontinuity, this.f28551b, ah2Var.f195e);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final void reevaluateBuffer(long j) {
        long streamPositionUs;
        ah2 ah2Var = this.f28550a;
        long j2 = this.f28555f;
        MediaSource.MediaPeriodId mediaPeriodId = this.f28551b;
        if (j < j2) {
            streamPositionUs = ServerSideAdInsertionUtil.getStreamPositionUs(j2, mediaPeriodId, ah2Var.f195e) - (this.f28555f - j);
        } else {
            streamPositionUs = ServerSideAdInsertionUtil.getStreamPositionUs(j, mediaPeriodId, ah2Var.f195e);
        }
        ah2Var.f191a.reevaluateBuffer(streamPositionUs);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long seekToUs(long j) {
        ah2 ah2Var = this.f28550a;
        ah2Var.getClass();
        AdPlaybackState adPlaybackState = ah2Var.f195e;
        MediaSource.MediaPeriodId mediaPeriodId = this.f28551b;
        return ServerSideAdInsertionUtil.getMediaPeriodPositionUs(ah2Var.f191a.seekToUs(ServerSideAdInsertionUtil.getStreamPositionUs(j, mediaPeriodId, adPlaybackState)), mediaPeriodId, ah2Var.f195e);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        SampleStream emptySampleStream;
        SampleStream[] sampleStreamArr2;
        if (this.f28556g.length == 0) {
            this.f28556g = new boolean[sampleStreamArr.length];
        }
        ah2 ah2Var = this.f28550a;
        this.f28555f = j;
        if (equals(ah2Var.f192b.get(0))) {
            ah2Var.f199i = (ExoTrackSelection[]) Arrays.copyOf(exoTrackSelectionArr, exoTrackSelectionArr.length);
            AdPlaybackState adPlaybackState = ah2Var.f195e;
            MediaSource.MediaPeriodId mediaPeriodId = this.f28551b;
            long streamPositionUs = ServerSideAdInsertionUtil.getStreamPositionUs(j, mediaPeriodId, adPlaybackState);
            SampleStream[] sampleStreamArr3 = ah2Var.f200j;
            if (sampleStreamArr3.length == 0) {
                sampleStreamArr2 = new SampleStream[exoTrackSelectionArr.length];
            } else {
                sampleStreamArr2 = (SampleStream[]) Arrays.copyOf(sampleStreamArr3, sampleStreamArr3.length);
            }
            SampleStream[] sampleStreamArr4 = sampleStreamArr2;
            long selectTracks = ah2Var.f191a.selectTracks(exoTrackSelectionArr, zArr, sampleStreamArr4, zArr2, streamPositionUs);
            ah2Var.f200j = (SampleStream[]) Arrays.copyOf(sampleStreamArr4, sampleStreamArr4.length);
            ah2Var.f201k = (MediaLoadData[]) Arrays.copyOf(ah2Var.f201k, sampleStreamArr4.length);
            for (int i = 0; i < sampleStreamArr4.length; i++) {
                if (sampleStreamArr4[i] == null) {
                    sampleStreamArr[i] = null;
                    ah2Var.f201k[i] = null;
                } else if (sampleStreamArr[i] == null || zArr2[i]) {
                    sampleStreamArr[i] = new yg2(this, i);
                    ah2Var.f201k[i] = null;
                }
            }
            return ServerSideAdInsertionUtil.getMediaPeriodPositionUs(selectTracks, mediaPeriodId, ah2Var.f195e);
        }
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i2];
            boolean z = true;
            if (exoTrackSelection != null) {
                if (zArr[i2] && sampleStreamArr[i2] != null) {
                    z = false;
                }
                zArr2[i2] = z;
                if (z) {
                    if (Util.areEqual(ah2Var.f199i[i2], exoTrackSelection)) {
                        emptySampleStream = new yg2(this, i2);
                    } else {
                        emptySampleStream = new EmptySampleStream();
                    }
                    sampleStreamArr[i2] = emptySampleStream;
                }
            } else {
                sampleStreamArr[i2] = null;
                zArr2[i2] = true;
            }
        }
        return j;
    }
}
