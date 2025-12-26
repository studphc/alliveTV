package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.ClippingMediaSource;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
import p000.C1695pp;
import p000.tl1;

/* loaded from: classes.dex */
public final class ClippingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {

    /* renamed from: a */
    public MediaPeriod.Callback f10909a;

    /* renamed from: b */
    public C1695pp[] f10910b = new C1695pp[0];

    /* renamed from: c */
    public long f10911c;

    /* renamed from: d */
    public long f10912d;

    /* renamed from: e */
    public long f10913e;

    /* renamed from: f */
    public ClippingMediaSource.IllegalClippingException f10914f;
    public final MediaPeriod mediaPeriod;

    public ClippingMediaPeriod(MediaPeriod mediaPeriod, boolean z, long j, long j2) {
        long j3;
        this.mediaPeriod = mediaPeriod;
        if (z) {
            j3 = j;
        } else {
            j3 = C0643C.TIME_UNSET;
        }
        this.f10911c = j3;
        this.f10912d = j;
        this.f10913e = j2;
    }

    /* renamed from: a */
    public final boolean m2726a() {
        if (this.f10911c != C0643C.TIME_UNSET) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        return this.mediaPeriod.continueLoading(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        this.mediaPeriod.discardBuffer(j, z);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        long j2;
        long j3 = this.f10912d;
        if (j == j3) {
            return j3;
        }
        long constrainValue = Util.constrainValue(seekParameters.toleranceBeforeUs, 0L, j - j3);
        long j4 = seekParameters.toleranceAfterUs;
        long j5 = this.f10913e;
        if (j5 == Long.MIN_VALUE) {
            j2 = Long.MAX_VALUE;
        } else {
            j2 = j5 - j;
        }
        long constrainValue2 = Util.constrainValue(j4, 0L, j2);
        if (constrainValue != seekParameters.toleranceBeforeUs || constrainValue2 != seekParameters.toleranceAfterUs) {
            seekParameters = new SeekParameters(constrainValue, constrainValue2);
        }
        return this.mediaPeriod.getAdjustedSeekPositionUs(j, seekParameters);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        long bufferedPositionUs = this.mediaPeriod.getBufferedPositionUs();
        if (bufferedPositionUs != Long.MIN_VALUE) {
            long j = this.f10913e;
            if (j == Long.MIN_VALUE || bufferedPositionUs < j) {
                return bufferedPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.mediaPeriod.getNextLoadPositionUs();
        if (nextLoadPositionUs != Long.MIN_VALUE) {
            long j = this.f10913e;
            if (j == Long.MIN_VALUE || nextLoadPositionUs < j) {
                return nextLoadPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final /* synthetic */ List getStreamKeys(List list) {
        return tl1.m7499a(this, list);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.mediaPeriod.getTrackGroups();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.mediaPeriod.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() {
        ClippingMediaSource.IllegalClippingException illegalClippingException = this.f10914f;
        if (illegalClippingException == null) {
            this.mediaPeriod.maybeThrowPrepareError();
            return;
        }
        throw illegalClippingException;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        if (this.f10914f != null) {
            return;
        }
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.f10909a)).onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j) {
        this.f10909a = callback;
        this.mediaPeriod.prepare(this, j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        boolean z;
        if (m2726a()) {
            long j = this.f10911c;
            this.f10911c = C0643C.TIME_UNSET;
            long readDiscontinuity = readDiscontinuity();
            if (readDiscontinuity != C0643C.TIME_UNSET) {
                return readDiscontinuity;
            }
            return j;
        }
        long readDiscontinuity2 = this.mediaPeriod.readDiscontinuity();
        if (readDiscontinuity2 == C0643C.TIME_UNSET) {
            return C0643C.TIME_UNSET;
        }
        boolean z2 = false;
        if (readDiscontinuity2 >= this.f10912d) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        long j2 = this.f10913e;
        if (j2 == Long.MIN_VALUE || readDiscontinuity2 <= j2) {
            z2 = true;
        }
        Assertions.checkState(z2);
        return readDiscontinuity2;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        this.mediaPeriod.reevaluateBuffer(j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        if (r0 > r6) goto L17;
     */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long seekToUs(long j) {
        this.f10911c = C0643C.TIME_UNSET;
        boolean z = false;
        for (C1695pp c1695pp : this.f10910b) {
            if (c1695pp != null) {
                c1695pp.f25244b = false;
            }
        }
        long seekToUs = this.mediaPeriod.seekToUs(j);
        if (seekToUs != j) {
            if (seekToUs >= this.f10912d) {
                long j2 = this.f10913e;
                if (j2 != Long.MIN_VALUE) {
                }
            }
            Assertions.checkState(z);
            return seekToUs;
        }
        z = true;
        Assertions.checkState(z);
        return seekToUs;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
    
        if (r1 > r3) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0084  */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        long j2;
        boolean z;
        this.f10910b = new C1695pp[sampleStreamArr.length];
        SampleStream[] sampleStreamArr2 = new SampleStream[sampleStreamArr.length];
        int i = 0;
        while (true) {
            SampleStream sampleStream = null;
            if (i >= sampleStreamArr.length) {
                break;
            }
            C1695pp[] c1695ppArr = this.f10910b;
            C1695pp c1695pp = (C1695pp) sampleStreamArr[i];
            c1695ppArr[i] = c1695pp;
            if (c1695pp != null) {
                sampleStream = c1695pp.f25243a;
            }
            sampleStreamArr2[i] = sampleStream;
            i++;
        }
        long selectTracks = this.mediaPeriod.selectTracks(exoTrackSelectionArr, zArr, sampleStreamArr2, zArr2, j);
        if (m2726a()) {
            long j3 = this.f10912d;
            if (j == j3 && j3 != 0) {
                for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
                    if (exoTrackSelection != null) {
                        Format selectedFormat = exoTrackSelection.getSelectedFormat();
                        if (!MimeTypes.allSamplesAreSyncSamples(selectedFormat.sampleMimeType, selectedFormat.codecs)) {
                            j2 = selectTracks;
                            break;
                        }
                    }
                }
            }
        }
        j2 = C0643C.TIME_UNSET;
        this.f10911c = j2;
        if (selectTracks != j) {
            if (selectTracks >= this.f10912d) {
                long j4 = this.f10913e;
                if (j4 != Long.MIN_VALUE) {
                }
            }
            z = false;
            Assertions.checkState(z);
            for (int i2 = 0; i2 < sampleStreamArr.length; i2++) {
                SampleStream sampleStream2 = sampleStreamArr2[i2];
                if (sampleStream2 == null) {
                    this.f10910b[i2] = null;
                } else {
                    C1695pp[] c1695ppArr2 = this.f10910b;
                    C1695pp c1695pp2 = c1695ppArr2[i2];
                    if (c1695pp2 == null || c1695pp2.f25243a != sampleStream2) {
                        c1695ppArr2[i2] = new C1695pp(this, sampleStream2);
                    }
                }
                sampleStreamArr[i2] = this.f10910b[i2];
            }
            return selectTracks;
        }
        z = true;
        Assertions.checkState(z);
        while (i2 < sampleStreamArr.length) {
        }
        return selectTracks;
    }

    public void setClippingError(ClippingMediaSource.IllegalClippingException illegalClippingException) {
        this.f10914f = illegalClippingException;
    }

    public void updateClipping(long j, long j2) {
        this.f10912d = j;
        this.f10913e = j2;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.f10909a)).onContinueLoadingRequested(this);
    }
}
