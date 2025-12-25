package com.google.android.exoplayer2.source;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManagerProvider;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import p000.C1294i5;
import p000.v72;

/* loaded from: classes.dex */
public final class ProgressiveMediaSource extends BaseMediaSource implements v72 {
    public static final int DEFAULT_LOADING_CHECK_INTERVAL_BYTES = 1048576;

    /* renamed from: h */
    public final MediaItem f10997h;

    /* renamed from: i */
    public final MediaItem.LocalConfiguration f10998i;

    /* renamed from: j */
    public final DataSource.Factory f10999j;

    /* renamed from: k */
    public final ProgressiveMediaExtractor.Factory f11000k;

    /* renamed from: l */
    public final DrmSessionManager f11001l;

    /* renamed from: m */
    public final LoadErrorHandlingPolicy f11002m;

    /* renamed from: n */
    public final int f11003n;

    /* renamed from: o */
    public boolean f11004o = true;

    /* renamed from: p */
    public long f11005p = C0643C.TIME_UNSET;

    /* renamed from: q */
    public boolean f11006q;

    /* renamed from: r */
    public boolean f11007r;

    /* renamed from: s */
    public TransferListener f11008s;

    /* loaded from: classes.dex */
    public static final class Factory implements MediaSourceFactory {

        /* renamed from: a */
        public final DataSource.Factory f11009a;

        /* renamed from: b */
        public final ProgressiveMediaExtractor.Factory f11010b;

        /* renamed from: c */
        public DrmSessionManagerProvider f11011c;

        /* renamed from: d */
        public LoadErrorHandlingPolicy f11012d;

        /* renamed from: e */
        public int f11013e;

        public Factory(DataSource.Factory factory) {
            this(factory, new DefaultExtractorsFactory());
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        public int[] getSupportedTypes() {
            return new int[]{4};
        }

        public Factory setContinueLoadingCheckIntervalBytes(int i) {
            this.f11013e = i;
            return this;
        }

        public Factory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
            this(factory, new C1294i5(17, extractorsFactory));
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        public ProgressiveMediaSource createMediaSource(MediaItem mediaItem) {
            Assertions.checkNotNull(mediaItem.localConfiguration);
            Object obj = mediaItem.localConfiguration.tag;
            return new ProgressiveMediaSource(mediaItem, this.f11009a, this.f11010b, this.f11011c.get(mediaItem), this.f11012d, this.f11013e);
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        public Factory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f11011c = (DrmSessionManagerProvider) Assertions.checkNotNull(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        public Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f11012d = (LoadErrorHandlingPolicy) Assertions.checkNotNull(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory(DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2) {
            this(factory, factory2, new DefaultDrmSessionManagerProvider(), new DefaultLoadErrorHandlingPolicy(), 1048576);
        }

        public Factory(DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2, DrmSessionManagerProvider drmSessionManagerProvider, LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i) {
            this.f11009a = factory;
            this.f11010b = factory2;
            this.f11011c = drmSessionManagerProvider;
            this.f11012d = loadErrorHandlingPolicy;
            this.f11013e = i;
        }
    }

    public ProgressiveMediaSource(MediaItem mediaItem, DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i) {
        this.f10998i = (MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem.localConfiguration);
        this.f10997h = mediaItem;
        this.f10999j = factory;
        this.f11000k = factory2;
        this.f11001l = drmSessionManager;
        this.f11002m = loadErrorHandlingPolicy;
        this.f11003n = i;
    }

    /* renamed from: a */
    public final void m2742a() {
        Timeline singlePeriodTimeline = new SinglePeriodTimeline(this.f11005p, this.f11006q, false, this.f11007r, (Object) null, this.f10997h);
        if (this.f11004o) {
            singlePeriodTimeline = new ForwardingTimeline(singlePeriodTimeline);
        }
        refreshSourceInfo(singlePeriodTimeline);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        DataSource createDataSource = this.f10999j.createDataSource();
        TransferListener transferListener = this.f11008s;
        if (transferListener != null) {
            createDataSource.addTransferListener(transferListener);
        }
        MediaItem.LocalConfiguration localConfiguration = this.f10998i;
        return new C0707m(localConfiguration.uri, createDataSource, this.f11000k.createProgressiveMediaExtractor(getPlayerId()), this.f11001l, createDrmEventDispatcher(mediaPeriodId), this.f11002m, createEventDispatcher(mediaPeriodId), this, allocator, localConfiguration.customCacheKey, this.f11003n);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        return this.f10997h;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // p000.v72
    public void onSourceInfoRefreshed(long j, boolean z, boolean z2) {
        if (j == C0643C.TIME_UNSET) {
            j = this.f11005p;
        }
        if (!this.f11004o && this.f11005p == j && this.f11006q == z && this.f11007r == z2) {
            return;
        }
        this.f11005p = j;
        this.f11006q = z;
        this.f11007r = z2;
        this.f11004o = false;
        m2742a();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        this.f11008s = transferListener;
        DrmSessionManager drmSessionManager = this.f11001l;
        drmSessionManager.prepare();
        drmSessionManager.setPlayer((Looper) Assertions.checkNotNull(Looper.myLooper()), getPlayerId());
        m2742a();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        C0707m c0707m = (C0707m) mediaPeriod;
        if (c0707m.f11581v) {
            for (SampleQueue sampleQueue : c0707m.f11578s) {
                sampleQueue.preRelease();
            }
        }
        c0707m.f11570k.release(c0707m);
        c0707m.f11575p.removeCallbacksAndMessages(null);
        c0707m.f11576q = null;
        c0707m.f11559L = true;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.f11001l.release();
    }
}
