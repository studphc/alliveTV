package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p000.sj2;
import p000.tl1;

/* renamed from: com.google.android.exoplayer2.source.p */
/* loaded from: classes.dex */
public final class C0710p implements MediaPeriod, Loader.Callback {

    /* renamed from: a */
    public final DataSpec f11618a;

    /* renamed from: b */
    public final DataSource.Factory f11619b;

    /* renamed from: c */
    public final TransferListener f11620c;

    /* renamed from: d */
    public final LoadErrorHandlingPolicy f11621d;

    /* renamed from: e */
    public final MediaSourceEventListener.EventDispatcher f11622e;

    /* renamed from: f */
    public final TrackGroupArray f11623f;

    /* renamed from: h */
    public final long f11625h;

    /* renamed from: j */
    public final Format f11627j;

    /* renamed from: k */
    public final boolean f11628k;

    /* renamed from: l */
    public boolean f11629l;

    /* renamed from: m */
    public byte[] f11630m;

    /* renamed from: n */
    public int f11631n;

    /* renamed from: g */
    public final ArrayList f11624g = new ArrayList();

    /* renamed from: i */
    public final Loader f11626i = new Loader("SingleSampleMediaPeriod");

    public C0710p(DataSpec dataSpec, DataSource.Factory factory, TransferListener transferListener, Format format, long j, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher, boolean z) {
        this.f11618a = dataSpec;
        this.f11619b = factory;
        this.f11620c = transferListener;
        this.f11627j = format;
        this.f11625h = j;
        this.f11621d = loadErrorHandlingPolicy;
        this.f11622e = eventDispatcher;
        this.f11628k = z;
        this.f11623f = new TrackGroupArray(new TrackGroup(format));
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final boolean continueLoading(long j) {
        if (!this.f11629l) {
            Loader loader = this.f11626i;
            if (!loader.isLoading() && !loader.hasFatalError()) {
                DataSource createDataSource = this.f11619b.createDataSource();
                TransferListener transferListener = this.f11620c;
                if (transferListener != null) {
                    createDataSource.addTransferListener(transferListener);
                }
                sj2 sj2Var = new sj2(createDataSource, this.f11618a);
                this.f11622e.loadStarted(new LoadEventInfo(sj2Var.f26456a, this.f11618a, loader.startLoading(sj2Var, this, this.f11621d.getMinimumLoadableRetryCount(1))), 1, -1, this.f11627j, 0, null, 0L, this.f11625h);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final void discardBuffer(long j, boolean z) {
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final long getBufferedPositionUs() {
        if (this.f11629l) {
            return Long.MIN_VALUE;
        }
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final long getNextLoadPositionUs() {
        if (!this.f11629l && !this.f11626i.isLoading()) {
            return 0L;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final /* synthetic */ List getStreamKeys(List list) {
        return tl1.m7499a(this, list);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final TrackGroupArray getTrackGroups() {
        return this.f11623f;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final boolean isLoading() {
        return this.f11626i.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final void maybeThrowPrepareError() {
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public final void onLoadCanceled(Loader.Loadable loadable, long j, long j2, boolean z) {
        sj2 sj2Var = (sj2) loadable;
        StatsDataSource statsDataSource = sj2Var.f26458c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sj2Var.f26456a, sj2Var.f26457b, statsDataSource.getLastOpenedUri(), statsDataSource.getLastResponseHeaders(), j, j2, statsDataSource.getBytesRead());
        this.f11621d.onLoadTaskConcluded(sj2Var.f26456a);
        this.f11622e.loadCanceled(loadEventInfo, 1, -1, null, 0, null, 0L, this.f11625h);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public final void onLoadCompleted(Loader.Loadable loadable, long j, long j2) {
        sj2 sj2Var = (sj2) loadable;
        this.f11631n = (int) sj2Var.f26458c.getBytesRead();
        this.f11630m = (byte[]) Assertions.checkNotNull(sj2Var.f26459d);
        this.f11629l = true;
        StatsDataSource statsDataSource = sj2Var.f26458c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sj2Var.f26456a, sj2Var.f26457b, statsDataSource.getLastOpenedUri(), statsDataSource.getLastResponseHeaders(), j, j2, this.f11631n);
        this.f11621d.onLoadTaskConcluded(sj2Var.f26456a);
        this.f11622e.loadCompleted(loadEventInfo, 1, -1, this.f11627j, 0, null, 0L, this.f11625h);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public final Loader.LoadErrorAction onLoadError(Loader.Loadable loadable, long j, long j2, IOException iOException, int i) {
        boolean z;
        Loader.LoadErrorAction loadErrorAction;
        sj2 sj2Var = (sj2) loadable;
        StatsDataSource statsDataSource = sj2Var.f26458c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sj2Var.f26456a, sj2Var.f26457b, statsDataSource.getLastOpenedUri(), statsDataSource.getLastResponseHeaders(), j, j2, statsDataSource.getBytesRead());
        LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(1, -1, this.f11627j, 0, null, 0L, Util.usToMs(this.f11625h)), iOException, i);
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f11621d;
        long retryDelayMsFor = loadErrorHandlingPolicy.getRetryDelayMsFor(loadErrorInfo);
        if (retryDelayMsFor != C0643C.TIME_UNSET && i < loadErrorHandlingPolicy.getMinimumLoadableRetryCount(1)) {
            z = false;
        } else {
            z = true;
        }
        if (this.f11628k && z) {
            Log.m3028w("SingleSampleMediaPeriod", "Loading failed, treating as end-of-stream.", iOException);
            this.f11629l = true;
            loadErrorAction = Loader.DONT_RETRY;
        } else if (retryDelayMsFor != C0643C.TIME_UNSET) {
            loadErrorAction = Loader.createRetryAction(false, retryDelayMsFor);
        } else {
            loadErrorAction = Loader.DONT_RETRY_FATAL;
        }
        Loader.LoadErrorAction loadErrorAction2 = loadErrorAction;
        boolean isRetry = loadErrorAction2.isRetry();
        this.f11622e.loadError(loadEventInfo, 1, -1, this.f11627j, 0, null, 0L, this.f11625h, iOException, !isRetry);
        if (!isRetry) {
            loadErrorHandlingPolicy.onLoadTaskConcluded(sj2Var.f26456a);
        }
        return loadErrorAction2;
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
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f11624g;
            if (i < arrayList.size()) {
                C0709o c0709o = (C0709o) arrayList.get(i);
                if (c0709o.f11615a == 2) {
                    c0709o.f11615a = 1;
                }
                i++;
            } else {
                return j;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        for (int i = 0; i < exoTrackSelectionArr.length; i++) {
            SampleStream sampleStream = sampleStreamArr[i];
            ArrayList arrayList = this.f11624g;
            if (sampleStream != null && (exoTrackSelectionArr[i] == null || !zArr[i])) {
                arrayList.remove(sampleStream);
                sampleStreamArr[i] = null;
            }
            if (sampleStreamArr[i] == null && exoTrackSelectionArr[i] != null) {
                C0709o c0709o = new C0709o(this);
                arrayList.add(c0709o);
                sampleStreamArr[i] = c0709o;
                zArr2[i] = true;
            }
        }
        return j;
    }
}
