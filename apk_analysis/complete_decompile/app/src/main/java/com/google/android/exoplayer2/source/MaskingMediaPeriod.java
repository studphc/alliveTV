package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.List;
import p000.tl1;

/* loaded from: classes.dex */
public final class MaskingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {

    /* renamed from: a */
    public final long f10960a;

    /* renamed from: b */
    public final Allocator f10961b;

    /* renamed from: c */
    public MediaSource f10962c;

    /* renamed from: d */
    public MediaPeriod f10963d;

    /* renamed from: e */
    public MediaPeriod.Callback f10964e;

    /* renamed from: f */
    public PrepareListener f10965f;

    /* renamed from: g */
    public boolean f10966g;

    /* renamed from: h */
    public long f10967h = C0643C.TIME_UNSET;

    /* renamed from: id */
    public final MediaSource.MediaPeriodId f10968id;

    /* loaded from: classes.dex */
    public interface PrepareListener {
        void onPrepareComplete(MediaSource.MediaPeriodId mediaPeriodId);

        void onPrepareError(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException);
    }

    public MaskingMediaPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        this.f10968id = mediaPeriodId;
        this.f10961b = allocator;
        this.f10960a = j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        MediaPeriod mediaPeriod = this.f10963d;
        if (mediaPeriod != null && mediaPeriod.continueLoading(j)) {
            return true;
        }
        return false;
    }

    public void createPeriod(MediaSource.MediaPeriodId mediaPeriodId) {
        long j = this.f10967h;
        if (j == C0643C.TIME_UNSET) {
            j = this.f10960a;
        }
        MediaPeriod createPeriod = ((MediaSource) Assertions.checkNotNull(this.f10962c)).createPeriod(mediaPeriodId, this.f10961b, j);
        this.f10963d = createPeriod;
        if (this.f10964e != null) {
            createPeriod.prepare(this, j);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        ((MediaPeriod) Util.castNonNull(this.f10963d)).discardBuffer(j, z);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        return ((MediaPeriod) Util.castNonNull(this.f10963d)).getAdjustedSeekPositionUs(j, seekParameters);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return ((MediaPeriod) Util.castNonNull(this.f10963d)).getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return ((MediaPeriod) Util.castNonNull(this.f10963d)).getNextLoadPositionUs();
    }

    public long getPreparePositionOverrideUs() {
        return this.f10967h;
    }

    public long getPreparePositionUs() {
        return this.f10960a;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final /* synthetic */ List getStreamKeys(List list) {
        return tl1.m7499a(this, list);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return ((MediaPeriod) Util.castNonNull(this.f10963d)).getTrackGroups();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        MediaPeriod mediaPeriod = this.f10963d;
        if (mediaPeriod != null && mediaPeriod.isLoading()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() {
        try {
            MediaPeriod mediaPeriod = this.f10963d;
            if (mediaPeriod != null) {
                mediaPeriod.maybeThrowPrepareError();
            } else {
                MediaSource mediaSource = this.f10962c;
                if (mediaSource != null) {
                    mediaSource.maybeThrowSourceInfoRefreshError();
                }
            }
        } catch (IOException e) {
            PrepareListener prepareListener = this.f10965f;
            if (prepareListener != null) {
                if (!this.f10966g) {
                    this.f10966g = true;
                    prepareListener.onPrepareError(this.f10968id, e);
                    return;
                }
                return;
            }
            throw e;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Util.castNonNull(this.f10964e)).onPrepared(this);
        PrepareListener prepareListener = this.f10965f;
        if (prepareListener != null) {
            prepareListener.onPrepareComplete(this.f10968id);
        }
    }

    public void overridePreparePositionUs(long j) {
        this.f10967h = j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j) {
        this.f10964e = callback;
        MediaPeriod mediaPeriod = this.f10963d;
        if (mediaPeriod != null) {
            long j2 = this.f10967h;
            if (j2 == C0643C.TIME_UNSET) {
                j2 = this.f10960a;
            }
            mediaPeriod.prepare(this, j2);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        return ((MediaPeriod) Util.castNonNull(this.f10963d)).readDiscontinuity();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        ((MediaPeriod) Util.castNonNull(this.f10963d)).reevaluateBuffer(j);
    }

    public void releasePeriod() {
        if (this.f10963d != null) {
            ((MediaSource) Assertions.checkNotNull(this.f10962c)).releasePeriod(this.f10963d);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        return ((MediaPeriod) Util.castNonNull(this.f10963d)).seekToUs(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.f10967h;
        if (j3 != C0643C.TIME_UNSET && j == this.f10960a) {
            this.f10967h = C0643C.TIME_UNSET;
            j2 = j3;
        } else {
            j2 = j;
        }
        return ((MediaPeriod) Util.castNonNull(this.f10963d)).selectTracks(exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j2);
    }

    public void setMediaSource(MediaSource mediaSource) {
        boolean z;
        if (this.f10962c == null) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.f10962c = mediaSource;
    }

    public void setPrepareListener(PrepareListener prepareListener) {
        this.f10965f = prepareListener;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Util.castNonNull(this.f10964e)).onContinueLoadingRequested(this);
    }
}
