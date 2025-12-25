package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;
import p000.ii2;
import p000.tl1;

/* renamed from: com.google.android.exoplayer2.source.n */
/* loaded from: classes.dex */
public final class C0708n implements MediaPeriod {

    /* renamed from: c */
    public static final TrackGroupArray f11612c = new TrackGroupArray(new TrackGroup(SilenceMediaSource.f11051j));

    /* renamed from: a */
    public final long f11613a;

    /* renamed from: b */
    public final ArrayList f11614b = new ArrayList();

    public C0708n(long j) {
        this.f11613a = j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final boolean continueLoading(long j) {
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final void discardBuffer(long j, boolean z) {
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        return Util.constrainValue(j, 0L, this.f11613a);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final long getBufferedPositionUs() {
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final long getNextLoadPositionUs() {
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final /* synthetic */ List getStreamKeys(List list) {
        return tl1.m7499a(this, list);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final TrackGroupArray getTrackGroups() {
        return f11612c;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final boolean isLoading() {
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final void maybeThrowPrepareError() {
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final void prepare(MediaPeriod.Callback callback, long j) {
        callback.onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long readDiscontinuity() {
        return C0643C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final void reevaluateBuffer(long j) {
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long seekToUs(long j) {
        long constrainValue = Util.constrainValue(j, 0L, this.f11613a);
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f11614b;
            if (i < arrayList.size()) {
                ((ii2) arrayList.get(i)).m5246a(constrainValue);
                i++;
            } else {
                return constrainValue;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        long constrainValue = Util.constrainValue(j, 0L, this.f11613a);
        for (int i = 0; i < exoTrackSelectionArr.length; i++) {
            SampleStream sampleStream = sampleStreamArr[i];
            ArrayList arrayList = this.f11614b;
            if (sampleStream != null && (exoTrackSelectionArr[i] == null || !zArr[i])) {
                arrayList.remove(sampleStream);
                sampleStreamArr[i] = null;
            }
            if (sampleStreamArr[i] == null && exoTrackSelectionArr[i] != null) {
                ii2 ii2Var = new ii2(this.f11613a);
                ii2Var.m5246a(constrainValue);
                arrayList.add(ii2Var);
                sampleStreamArr[i] = ii2Var;
                zArr2[i] = true;
            }
        }
        return constrainValue;
    }
}
