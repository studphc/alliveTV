package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import java.util.List;
import p000.mn1;

/* renamed from: com.google.android.exoplayer2.source.k */
/* loaded from: classes.dex */
public final class C0705k implements MediaPeriod, MediaPeriod.Callback {

    /* renamed from: a */
    public final MediaPeriod f11534a;

    /* renamed from: b */
    public final long f11535b;

    /* renamed from: c */
    public MediaPeriod.Callback f11536c;

    public C0705k(MediaPeriod mediaPeriod, long j) {
        this.f11534a = mediaPeriod;
        this.f11535b = j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final boolean continueLoading(long j) {
        return this.f11534a.continueLoading(j - this.f11535b);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final void discardBuffer(long j, boolean z) {
        this.f11534a.discardBuffer(j - this.f11535b, z);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        long j2 = this.f11535b;
        return this.f11534a.getAdjustedSeekPositionUs(j - j2, seekParameters) + j2;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final long getBufferedPositionUs() {
        long bufferedPositionUs = this.f11534a.getBufferedPositionUs();
        if (bufferedPositionUs == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return this.f11535b + bufferedPositionUs;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.f11534a.getNextLoadPositionUs();
        if (nextLoadPositionUs == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return this.f11535b + nextLoadPositionUs;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final List getStreamKeys(List list) {
        return this.f11534a.getStreamKeys(list);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final TrackGroupArray getTrackGroups() {
        return this.f11534a.getTrackGroups();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final boolean isLoading() {
        return this.f11534a.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final void maybeThrowPrepareError() {
        this.f11534a.maybeThrowPrepareError();
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public final void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.f11536c)).onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public final void onPrepared(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.f11536c)).onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final void prepare(MediaPeriod.Callback callback, long j) {
        this.f11536c = callback;
        this.f11534a.prepare(this, j - this.f11535b);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long readDiscontinuity() {
        long readDiscontinuity = this.f11534a.readDiscontinuity();
        if (readDiscontinuity == C0643C.TIME_UNSET) {
            return C0643C.TIME_UNSET;
        }
        return this.f11535b + readDiscontinuity;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final void reevaluateBuffer(long j) {
        this.f11534a.reevaluateBuffer(j - this.f11535b);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long seekToUs(long j) {
        long j2 = this.f11535b;
        return this.f11534a.seekToUs(j - j2) + j2;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        SampleStream[] sampleStreamArr2 = new SampleStream[sampleStreamArr.length];
        int i = 0;
        while (true) {
            SampleStream sampleStream = null;
            if (i >= sampleStreamArr.length) {
                break;
            }
            mn1 mn1Var = (mn1) sampleStreamArr[i];
            if (mn1Var != null) {
                sampleStream = mn1Var.f23006a;
            }
            sampleStreamArr2[i] = sampleStream;
            i++;
        }
        long j2 = this.f11535b;
        long selectTracks = this.f11534a.selectTracks(exoTrackSelectionArr, zArr, sampleStreamArr2, zArr2, j - j2);
        for (int i2 = 0; i2 < sampleStreamArr.length; i2++) {
            SampleStream sampleStream2 = sampleStreamArr2[i2];
            if (sampleStream2 == null) {
                sampleStreamArr[i2] = null;
            } else {
                SampleStream sampleStream3 = sampleStreamArr[i2];
                if (sampleStream3 == null || ((mn1) sampleStream3).f23006a != sampleStream2) {
                    sampleStreamArr[i2] = new mn1(sampleStream2, j2);
                }
            }
        }
        return selectTracks + j2;
    }
}
