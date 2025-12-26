package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import p000.ln1;
import p000.tl1;

/* renamed from: com.google.android.exoplayer2.source.l */
/* loaded from: classes.dex */
public final class C0706l implements MediaPeriod, MediaPeriod.Callback {

    /* renamed from: a */
    public final MediaPeriod[] f11537a;

    /* renamed from: c */
    public final CompositeSequenceableLoaderFactory f11539c;

    /* renamed from: f */
    public MediaPeriod.Callback f11542f;

    /* renamed from: g */
    public TrackGroupArray f11543g;

    /* renamed from: i */
    public SequenceableLoader f11545i;

    /* renamed from: d */
    public final ArrayList f11540d = new ArrayList();

    /* renamed from: e */
    public final HashMap f11541e = new HashMap();

    /* renamed from: b */
    public final IdentityHashMap f11538b = new IdentityHashMap();

    /* renamed from: h */
    public MediaPeriod[] f11544h = new MediaPeriod[0];

    public C0706l(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, long[] jArr, MediaPeriod... mediaPeriodArr) {
        this.f11539c = compositeSequenceableLoaderFactory;
        this.f11537a = mediaPeriodArr;
        this.f11545i = compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(new SequenceableLoader[0]);
        for (int i = 0; i < mediaPeriodArr.length; i++) {
            long j = jArr[i];
            if (j != 0) {
                this.f11537a[i] = new C0705k(mediaPeriodArr[i], j);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final boolean continueLoading(long j) {
        ArrayList arrayList = this.f11540d;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((MediaPeriod) arrayList.get(i)).continueLoading(j);
            }
            return false;
        }
        return this.f11545i.continueLoading(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final void discardBuffer(long j, boolean z) {
        for (MediaPeriod mediaPeriod : this.f11544h) {
            mediaPeriod.discardBuffer(j, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        MediaPeriod mediaPeriod;
        MediaPeriod[] mediaPeriodArr = this.f11544h;
        if (mediaPeriodArr.length > 0) {
            mediaPeriod = mediaPeriodArr[0];
        } else {
            mediaPeriod = this.f11537a[0];
        }
        return mediaPeriod.getAdjustedSeekPositionUs(j, seekParameters);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final long getBufferedPositionUs() {
        return this.f11545i.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final long getNextLoadPositionUs() {
        return this.f11545i.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final /* synthetic */ List getStreamKeys(List list) {
        return tl1.m7499a(this, list);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final TrackGroupArray getTrackGroups() {
        return (TrackGroupArray) Assertions.checkNotNull(this.f11543g);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final boolean isLoading() {
        return this.f11545i.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final void maybeThrowPrepareError() {
        for (MediaPeriod mediaPeriod : this.f11537a) {
            mediaPeriod.maybeThrowPrepareError();
        }
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public final void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.f11542f)).onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public final void onPrepared(MediaPeriod mediaPeriod) {
        ArrayList arrayList = this.f11540d;
        arrayList.remove(mediaPeriod);
        if (!arrayList.isEmpty()) {
            return;
        }
        MediaPeriod[] mediaPeriodArr = this.f11537a;
        int i = 0;
        for (MediaPeriod mediaPeriod2 : mediaPeriodArr) {
            i += mediaPeriod2.getTrackGroups().length;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[i];
        int i2 = 0;
        for (int i3 = 0; i3 < mediaPeriodArr.length; i3++) {
            TrackGroupArray trackGroups = mediaPeriodArr[i3].getTrackGroups();
            int i4 = trackGroups.length;
            int i5 = 0;
            while (i5 < i4) {
                TrackGroup trackGroup = trackGroups.get(i5);
                TrackGroup copyWithId = trackGroup.copyWithId(i3 + ":" + trackGroup.f11089id);
                this.f11541e.put(copyWithId, trackGroup);
                trackGroupArr[i2] = copyWithId;
                i5++;
                i2++;
            }
        }
        this.f11543g = new TrackGroupArray(trackGroupArr);
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.f11542f)).onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final void prepare(MediaPeriod.Callback callback, long j) {
        this.f11542f = callback;
        ArrayList arrayList = this.f11540d;
        MediaPeriod[] mediaPeriodArr = this.f11537a;
        Collections.addAll(arrayList, mediaPeriodArr);
        for (MediaPeriod mediaPeriod : mediaPeriodArr) {
            mediaPeriod.prepare(this, j);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long readDiscontinuity() {
        long j = -9223372036854775807L;
        for (MediaPeriod mediaPeriod : this.f11544h) {
            long readDiscontinuity = mediaPeriod.readDiscontinuity();
            if (readDiscontinuity != C0643C.TIME_UNSET) {
                if (j == C0643C.TIME_UNSET) {
                    for (MediaPeriod mediaPeriod2 : this.f11544h) {
                        if (mediaPeriod2 == mediaPeriod) {
                            break;
                        }
                        if (mediaPeriod2.seekToUs(readDiscontinuity) != readDiscontinuity) {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    j = readDiscontinuity;
                } else if (readDiscontinuity != j) {
                    throw new IllegalStateException("Conflicting discontinuities.");
                }
            } else if (j != C0643C.TIME_UNSET && mediaPeriod.seekToUs(j) != j) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final void reevaluateBuffer(long j) {
        this.f11545i.reevaluateBuffer(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long seekToUs(long j) {
        long seekToUs = this.f11544h[0].seekToUs(j);
        int i = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.f11544h;
            if (i < mediaPeriodArr.length) {
                if (mediaPeriodArr[i].seekToUs(seekToUs) == seekToUs) {
                    i++;
                } else {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else {
                return seekToUs;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        HashMap hashMap;
        IdentityHashMap identityHashMap;
        MediaPeriod[] mediaPeriodArr;
        SampleStream sampleStream;
        HashMap hashMap2;
        ArrayList arrayList;
        Integer num;
        int intValue;
        int[] iArr = new int[exoTrackSelectionArr.length];
        int[] iArr2 = new int[exoTrackSelectionArr.length];
        int i = 0;
        while (true) {
            int length = exoTrackSelectionArr.length;
            hashMap = this.f11541e;
            identityHashMap = this.f11538b;
            mediaPeriodArr = this.f11537a;
            if (i >= length) {
                break;
            }
            SampleStream sampleStream2 = sampleStreamArr[i];
            if (sampleStream2 == null) {
                num = null;
            } else {
                num = (Integer) identityHashMap.get(sampleStream2);
            }
            if (num == null) {
                intValue = -1;
            } else {
                intValue = num.intValue();
            }
            iArr[i] = intValue;
            iArr2[i] = -1;
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i];
            if (exoTrackSelection != null) {
                TrackGroup trackGroup = (TrackGroup) Assertions.checkNotNull((TrackGroup) hashMap.get(exoTrackSelection.getTrackGroup()));
                int i2 = 0;
                while (true) {
                    if (i2 >= mediaPeriodArr.length) {
                        break;
                    }
                    if (mediaPeriodArr[i2].getTrackGroups().indexOf(trackGroup) != -1) {
                        iArr2[i] = i2;
                        break;
                    }
                    i2++;
                }
            }
            i++;
        }
        identityHashMap.clear();
        int length2 = exoTrackSelectionArr.length;
        SampleStream[] sampleStreamArr2 = new SampleStream[length2];
        SampleStream[] sampleStreamArr3 = new SampleStream[exoTrackSelectionArr.length];
        ExoTrackSelection[] exoTrackSelectionArr2 = new ExoTrackSelection[exoTrackSelectionArr.length];
        ArrayList arrayList2 = new ArrayList(mediaPeriodArr.length);
        long j2 = j;
        int i3 = 0;
        while (i3 < mediaPeriodArr.length) {
            int i4 = 0;
            while (i4 < exoTrackSelectionArr.length) {
                if (iArr[i4] == i3) {
                    sampleStream = sampleStreamArr[i4];
                } else {
                    sampleStream = null;
                }
                sampleStreamArr3[i4] = sampleStream;
                if (iArr2[i4] == i3) {
                    ExoTrackSelection exoTrackSelection2 = (ExoTrackSelection) Assertions.checkNotNull(exoTrackSelectionArr[i4]);
                    arrayList = arrayList2;
                    hashMap2 = hashMap;
                    exoTrackSelectionArr2[i4] = new ln1(exoTrackSelection2, (TrackGroup) Assertions.checkNotNull((TrackGroup) hashMap.get(exoTrackSelection2.getTrackGroup())));
                } else {
                    hashMap2 = hashMap;
                    arrayList = arrayList2;
                    exoTrackSelectionArr2[i4] = null;
                }
                i4++;
                arrayList2 = arrayList;
                hashMap = hashMap2;
            }
            HashMap hashMap3 = hashMap;
            ArrayList arrayList3 = arrayList2;
            int i5 = i3;
            ExoTrackSelection[] exoTrackSelectionArr3 = exoTrackSelectionArr2;
            long selectTracks = mediaPeriodArr[i3].selectTracks(exoTrackSelectionArr2, zArr, sampleStreamArr3, zArr2, j2);
            if (i5 == 0) {
                j2 = selectTracks;
            } else if (selectTracks != j2) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z = false;
            for (int i6 = 0; i6 < exoTrackSelectionArr.length; i6++) {
                boolean z2 = true;
                if (iArr2[i6] == i5) {
                    SampleStream sampleStream3 = (SampleStream) Assertions.checkNotNull(sampleStreamArr3[i6]);
                    sampleStreamArr2[i6] = sampleStreamArr3[i6];
                    identityHashMap.put(sampleStream3, Integer.valueOf(i5));
                    z = true;
                } else if (iArr[i6] == i5) {
                    if (sampleStreamArr3[i6] != null) {
                        z2 = false;
                    }
                    Assertions.checkState(z2);
                }
            }
            if (z) {
                arrayList3.add(mediaPeriodArr[i5]);
            }
            i3 = i5 + 1;
            arrayList2 = arrayList3;
            exoTrackSelectionArr2 = exoTrackSelectionArr3;
            hashMap = hashMap3;
        }
        System.arraycopy(sampleStreamArr2, 0, sampleStreamArr, 0, length2);
        MediaPeriod[] mediaPeriodArr2 = (MediaPeriod[]) arrayList2.toArray(new MediaPeriod[0]);
        this.f11544h = mediaPeriodArr2;
        this.f11545i = this.f11539c.createCompositeSequenceableLoader(mediaPeriodArr2);
        return j2;
    }
}
