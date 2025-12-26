package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManagerProvider;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.offline.FilteringManifestParser;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p000.RunnableC0006a5;

/* loaded from: classes.dex */
public final class SsMediaSource extends BaseMediaSource implements Loader.Callback<ParsingLoadable<SsManifest>> {

    /* renamed from: A */
    public static final /* synthetic */ int f11641A = 0;
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_MS = 30000;

    /* renamed from: h */
    public final boolean f11642h;

    /* renamed from: i */
    public final Uri f11643i;

    /* renamed from: j */
    public final MediaItem f11644j;

    /* renamed from: k */
    public final DataSource.Factory f11645k;

    /* renamed from: l */
    public final SsChunkSource.Factory f11646l;

    /* renamed from: m */
    public final CompositeSequenceableLoaderFactory f11647m;

    /* renamed from: n */
    public final DrmSessionManager f11648n;

    /* renamed from: o */
    public final LoadErrorHandlingPolicy f11649o;

    /* renamed from: p */
    public final long f11650p;

    /* renamed from: q */
    public final MediaSourceEventListener.EventDispatcher f11651q;

    /* renamed from: r */
    public final ParsingLoadable.Parser f11652r;

    /* renamed from: s */
    public final ArrayList f11653s;

    /* renamed from: t */
    public DataSource f11654t;

    /* renamed from: u */
    public Loader f11655u;

    /* renamed from: v */
    public LoaderErrorThrower f11656v;

    /* renamed from: w */
    public TransferListener f11657w;

    /* renamed from: x */
    public long f11658x;

    /* renamed from: y */
    public SsManifest f11659y;

    /* renamed from: z */
    public Handler f11660z;

    /* loaded from: classes.dex */
    public static final class Factory implements MediaSourceFactory {

        /* renamed from: a */
        public final SsChunkSource.Factory f11661a;

        /* renamed from: b */
        public final DataSource.Factory f11662b;

        /* renamed from: c */
        public CompositeSequenceableLoaderFactory f11663c;

        /* renamed from: d */
        public DrmSessionManagerProvider f11664d;

        /* renamed from: e */
        public LoadErrorHandlingPolicy f11665e;

        /* renamed from: f */
        public long f11666f;

        /* renamed from: g */
        public ParsingLoadable.Parser f11667g;

        public Factory(DataSource.Factory factory) {
            this(new DefaultSsChunkSource.Factory(factory), factory);
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        public int[] getSupportedTypes() {
            return new int[]{1};
        }

        public Factory setCompositeSequenceableLoaderFactory(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory) {
            this.f11663c = (CompositeSequenceableLoaderFactory) Assertions.checkNotNull(compositeSequenceableLoaderFactory, "SsMediaSource.Factory#setCompositeSequenceableLoaderFactory no longer handles null by instantiating a new DefaultCompositeSequenceableLoaderFactory. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory setLivePresentationDelayMs(long j) {
            this.f11666f = j;
            return this;
        }

        public Factory setManifestParser(@Nullable ParsingLoadable.Parser<? extends SsManifest> parser) {
            this.f11667g = parser;
            return this;
        }

        public Factory(SsChunkSource.Factory factory, @Nullable DataSource.Factory factory2) {
            this.f11661a = (SsChunkSource.Factory) Assertions.checkNotNull(factory);
            this.f11662b = factory2;
            this.f11664d = new DefaultDrmSessionManagerProvider();
            this.f11665e = new DefaultLoadErrorHandlingPolicy();
            this.f11666f = 30000L;
            this.f11663c = new DefaultCompositeSequenceableLoaderFactory();
        }

        public SsMediaSource createMediaSource(SsManifest ssManifest) {
            return createMediaSource(ssManifest, MediaItem.fromUri(Uri.EMPTY));
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        public Factory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f11664d = (DrmSessionManagerProvider) Assertions.checkNotNull(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        public Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f11665e = (LoadErrorHandlingPolicy) Assertions.checkNotNull(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public SsMediaSource createMediaSource(SsManifest ssManifest, MediaItem mediaItem) {
            List<StreamKey> m3902of;
            Assertions.checkArgument(!ssManifest.isLive);
            MediaItem.LocalConfiguration localConfiguration = mediaItem.localConfiguration;
            if (localConfiguration != null) {
                m3902of = localConfiguration.streamKeys;
            } else {
                m3902of = ImmutableList.m3902of();
            }
            if (!m3902of.isEmpty()) {
                ssManifest = ssManifest.copy(m3902of);
            }
            SsManifest ssManifest2 = ssManifest;
            MediaItem build = mediaItem.buildUpon().setMimeType(MimeTypes.APPLICATION_SS).setUri(mediaItem.localConfiguration != null ? mediaItem.localConfiguration.uri : Uri.EMPTY).build();
            return new SsMediaSource(build, ssManifest2, null, null, this.f11661a, this.f11663c, this.f11664d.get(build), this.f11665e, this.f11666f);
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        public SsMediaSource createMediaSource(MediaItem mediaItem) {
            Assertions.checkNotNull(mediaItem.localConfiguration);
            ParsingLoadable.Parser parser = this.f11667g;
            if (parser == null) {
                parser = new SsManifestParser();
            }
            List<StreamKey> list = mediaItem.localConfiguration.streamKeys;
            return new SsMediaSource(mediaItem, null, this.f11662b, !list.isEmpty() ? new FilteringManifestParser(parser, list) : parser, this.f11661a, this.f11663c, this.f11664d.get(mediaItem), this.f11665e, this.f11666f);
        }
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.smoothstreaming");
    }

    public SsMediaSource(MediaItem mediaItem, SsManifest ssManifest, DataSource.Factory factory, ParsingLoadable.Parser parser, SsChunkSource.Factory factory2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j) {
        boolean z;
        Uri fixSmoothStreamingIsmManifestUri;
        if (ssManifest != null && ssManifest.isLive) {
            z = false;
        } else {
            z = true;
        }
        Assertions.checkState(z);
        this.f11644j = mediaItem;
        MediaItem.LocalConfiguration localConfiguration = (MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem.localConfiguration);
        this.f11659y = ssManifest;
        if (localConfiguration.uri.equals(Uri.EMPTY)) {
            fixSmoothStreamingIsmManifestUri = null;
        } else {
            fixSmoothStreamingIsmManifestUri = Util.fixSmoothStreamingIsmManifestUri(localConfiguration.uri);
        }
        this.f11643i = fixSmoothStreamingIsmManifestUri;
        this.f11645k = factory;
        this.f11652r = parser;
        this.f11646l = factory2;
        this.f11647m = compositeSequenceableLoaderFactory;
        this.f11648n = drmSessionManager;
        this.f11649o = loadErrorHandlingPolicy;
        this.f11650p = j;
        this.f11651q = createEventDispatcher(null);
        this.f11642h = ssManifest != null;
        this.f11653s = new ArrayList();
    }

    /* renamed from: a */
    public final void m2828a() {
        long j;
        SinglePeriodTimeline singlePeriodTimeline;
        long j2;
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f11653s;
            if (i >= arrayList.size()) {
                break;
            }
            C0711a c0711a = (C0711a) arrayList.get(i);
            SsManifest ssManifest = this.f11659y;
            c0711a.f11679l = ssManifest;
            for (ChunkSampleStream chunkSampleStream : c0711a.f11680m) {
                ((SsChunkSource) chunkSampleStream.getChunkSource()).updateManifest(ssManifest);
            }
            c0711a.f11678k.onContinueLoadingRequested(c0711a);
            i++;
        }
        long j3 = Long.MIN_VALUE;
        long j4 = Long.MAX_VALUE;
        for (SsManifest.StreamElement streamElement : this.f11659y.streamElements) {
            if (streamElement.chunkCount > 0) {
                j4 = Math.min(j4, streamElement.getStartTimeUs(0));
                j3 = Math.max(j3, streamElement.getChunkDurationUs(streamElement.chunkCount - 1) + streamElement.getStartTimeUs(streamElement.chunkCount - 1));
            }
        }
        if (j4 == Long.MAX_VALUE) {
            if (this.f11659y.isLive) {
                j2 = -9223372036854775807L;
            } else {
                j2 = 0;
            }
            SsManifest ssManifest2 = this.f11659y;
            boolean z = ssManifest2.isLive;
            singlePeriodTimeline = new SinglePeriodTimeline(j2, 0L, 0L, 0L, true, z, z, (Object) ssManifest2, this.f11644j);
        } else {
            SsManifest ssManifest3 = this.f11659y;
            if (ssManifest3.isLive) {
                long j5 = ssManifest3.dvrWindowLengthUs;
                if (j5 != C0643C.TIME_UNSET && j5 > 0) {
                    j4 = Math.max(j4, j3 - j5);
                }
                long j6 = j4;
                long j7 = j3 - j6;
                long msToUs = j7 - Util.msToUs(this.f11650p);
                if (msToUs < 5000000) {
                    msToUs = Math.min(5000000L, j7 / 2);
                }
                singlePeriodTimeline = new SinglePeriodTimeline(C0643C.TIME_UNSET, j7, j6, msToUs, true, true, true, (Object) this.f11659y, this.f11644j);
            } else {
                long j8 = ssManifest3.durationUs;
                if (j8 != C0643C.TIME_UNSET) {
                    j = j8;
                } else {
                    j = j3 - j4;
                }
                singlePeriodTimeline = new SinglePeriodTimeline(j4 + j, j, j4, 0L, true, false, false, (Object) this.f11659y, this.f11644j);
            }
        }
        refreshSourceInfo(singlePeriodTimeline);
    }

    /* renamed from: b */
    public final void m2829b() {
        if (this.f11655u.hasFatalError()) {
            return;
        }
        ParsingLoadable parsingLoadable = new ParsingLoadable(this.f11654t, this.f11643i, 4, this.f11652r);
        this.f11651q.loadStarted(new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, this.f11655u.startLoading(parsingLoadable, this, this.f11649o.getMinimumLoadableRetryCount(parsingLoadable.type))), parsingLoadable.type);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        MediaSourceEventListener.EventDispatcher createEventDispatcher = createEventDispatcher(mediaPeriodId);
        DrmSessionEventListener.EventDispatcher createDrmEventDispatcher = createDrmEventDispatcher(mediaPeriodId);
        SsManifest ssManifest = this.f11659y;
        TransferListener transferListener = this.f11657w;
        LoaderErrorThrower loaderErrorThrower = this.f11656v;
        C0711a c0711a = new C0711a(ssManifest, this.f11646l, transferListener, this.f11647m, this.f11648n, createDrmEventDispatcher, this.f11649o, createEventDispatcher, loaderErrorThrower, allocator);
        this.f11653s.add(c0711a);
        return c0711a;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        return this.f11644j;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
        this.f11656v.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        this.f11657w = transferListener;
        DrmSessionManager drmSessionManager = this.f11648n;
        drmSessionManager.prepare();
        drmSessionManager.setPlayer(Looper.myLooper(), getPlayerId());
        if (this.f11642h) {
            this.f11656v = new LoaderErrorThrower.Dummy();
            m2828a();
            return;
        }
        this.f11654t = this.f11645k.createDataSource();
        Loader loader = new Loader("SsMediaSource");
        this.f11655u = loader;
        this.f11656v = loader;
        this.f11660z = Util.createHandlerForCurrentLooper();
        m2829b();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        C0711a c0711a = (C0711a) mediaPeriod;
        for (ChunkSampleStream chunkSampleStream : c0711a.f11680m) {
            chunkSampleStream.release();
        }
        c0711a.f11678k = null;
        this.f11653s.remove(mediaPeriod);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        SsManifest ssManifest;
        if (this.f11642h) {
            ssManifest = this.f11659y;
        } else {
            ssManifest = null;
        }
        this.f11659y = ssManifest;
        this.f11654t = null;
        this.f11658x = 0L;
        Loader loader = this.f11655u;
        if (loader != null) {
            loader.release();
            this.f11655u = null;
        }
        Handler handler = this.f11660z;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f11660z = null;
        }
        this.f11648n.release();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(ParsingLoadable<SsManifest> parsingLoadable, long j, long j2, boolean z) {
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        this.f11649o.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        this.f11651q.loadCanceled(loadEventInfo, parsingLoadable.type);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(ParsingLoadable<SsManifest> parsingLoadable, long j, long j2) {
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        this.f11649o.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        this.f11651q.loadCompleted(loadEventInfo, parsingLoadable.type);
        this.f11659y = parsingLoadable.getResult();
        this.f11658x = j - j2;
        m2828a();
        if (this.f11659y.isLive) {
            this.f11660z.postDelayed(new RunnableC0006a5(29, this), Math.max(0L, (this.f11658x + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public Loader.LoadErrorAction onLoadError(ParsingLoadable<SsManifest> parsingLoadable, long j, long j2, IOException iOException, int i) {
        Loader.LoadErrorAction createRetryAction;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable.type), iOException, i);
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f11649o;
        long retryDelayMsFor = loadErrorHandlingPolicy.getRetryDelayMsFor(loadErrorInfo);
        if (retryDelayMsFor == C0643C.TIME_UNSET) {
            createRetryAction = Loader.DONT_RETRY_FATAL;
        } else {
            createRetryAction = Loader.createRetryAction(false, retryDelayMsFor);
        }
        boolean isRetry = createRetryAction.isRetry();
        this.f11651q.loadError(loadEventInfo, parsingLoadable.type, iOException, !isRetry);
        if (!isRetry) {
            loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        }
        return createRetryAction;
    }
}
