package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.analytics.PlayerId;
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
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.EventStream;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.source.dash.manifest.ServiceDescriptionElement;
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
import com.google.common.math.LongMath;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;
import p000.C1249gy;
import p000.C1334iy;
import p000.RunnableC1175ey;
import p000.b01;
import p000.da0;

/* loaded from: classes.dex */
public final class DashMediaSource extends BaseMediaSource {
    public static final long DEFAULT_FALLBACK_TARGET_LIVE_OFFSET_MS = 30000;

    @Deprecated
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_MS = 30000;
    public static final String DEFAULT_MEDIA_ID = "DashMediaSource";

    /* renamed from: A */
    public Loader f11212A;

    /* renamed from: B */
    public TransferListener f11213B;

    /* renamed from: C */
    public DashManifestStaleException f11214C;

    /* renamed from: D */
    public Handler f11215D;

    /* renamed from: E */
    public MediaItem.LiveConfiguration f11216E;

    /* renamed from: F */
    public Uri f11217F;

    /* renamed from: G */
    public Uri f11218G;

    /* renamed from: H */
    public DashManifest f11219H;

    /* renamed from: I */
    public boolean f11220I;

    /* renamed from: J */
    public long f11221J;

    /* renamed from: K */
    public long f11222K;

    /* renamed from: L */
    public long f11223L;

    /* renamed from: M */
    public int f11224M;

    /* renamed from: N */
    public long f11225N;

    /* renamed from: O */
    public int f11226O;

    /* renamed from: h */
    public final MediaItem f11227h;

    /* renamed from: i */
    public final boolean f11228i;

    /* renamed from: j */
    public final DataSource.Factory f11229j;

    /* renamed from: k */
    public final DashChunkSource.Factory f11230k;

    /* renamed from: l */
    public final CompositeSequenceableLoaderFactory f11231l;

    /* renamed from: m */
    public final DrmSessionManager f11232m;

    /* renamed from: n */
    public final LoadErrorHandlingPolicy f11233n;

    /* renamed from: o */
    public final BaseUrlExclusionList f11234o = new BaseUrlExclusionList();

    /* renamed from: p */
    public final long f11235p;

    /* renamed from: q */
    public final MediaSourceEventListener.EventDispatcher f11236q;

    /* renamed from: r */
    public final ParsingLoadable.Parser f11237r;

    /* renamed from: s */
    public final C1334iy f11238s;

    /* renamed from: t */
    public final Object f11239t;

    /* renamed from: u */
    public final SparseArray f11240u;

    /* renamed from: v */
    public final RunnableC1175ey f11241v;

    /* renamed from: w */
    public final RunnableC1175ey f11242w;

    /* renamed from: x */
    public final C0695b f11243x;

    /* renamed from: y */
    public final LoaderErrorThrower f11244y;

    /* renamed from: z */
    public DataSource f11245z;

    /* loaded from: classes.dex */
    public static final class Factory implements MediaSourceFactory {

        /* renamed from: a */
        public final DashChunkSource.Factory f11246a;

        /* renamed from: b */
        public final DataSource.Factory f11247b;

        /* renamed from: c */
        public DrmSessionManagerProvider f11248c;

        /* renamed from: d */
        public CompositeSequenceableLoaderFactory f11249d;

        /* renamed from: e */
        public LoadErrorHandlingPolicy f11250e;

        /* renamed from: f */
        public long f11251f;

        /* renamed from: g */
        public ParsingLoadable.Parser f11252g;

        public Factory(DataSource.Factory factory) {
            this(new DefaultDashChunkSource.Factory(factory), factory);
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        public int[] getSupportedTypes() {
            return new int[]{0};
        }

        public Factory setCompositeSequenceableLoaderFactory(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory) {
            this.f11249d = (CompositeSequenceableLoaderFactory) Assertions.checkNotNull(compositeSequenceableLoaderFactory, "DashMediaSource.Factory#setCompositeSequenceableLoaderFactory no longer handles null by instantiating a new DefaultCompositeSequenceableLoaderFactory. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory setFallbackTargetLiveOffsetMs(long j) {
            this.f11251f = j;
            return this;
        }

        public Factory setManifestParser(@Nullable ParsingLoadable.Parser<? extends DashManifest> parser) {
            this.f11252g = parser;
            return this;
        }

        public Factory(DashChunkSource.Factory factory, @Nullable DataSource.Factory factory2) {
            this.f11246a = (DashChunkSource.Factory) Assertions.checkNotNull(factory);
            this.f11247b = factory2;
            this.f11248c = new DefaultDrmSessionManagerProvider();
            this.f11250e = new DefaultLoadErrorHandlingPolicy();
            this.f11251f = 30000L;
            this.f11249d = new DefaultCompositeSequenceableLoaderFactory();
        }

        public DashMediaSource createMediaSource(DashManifest dashManifest) {
            return createMediaSource(dashManifest, new MediaItem.Builder().setUri(Uri.EMPTY).setMediaId(DashMediaSource.DEFAULT_MEDIA_ID).setMimeType(MimeTypes.APPLICATION_MPD).build());
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        public Factory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f11248c = (DrmSessionManagerProvider) Assertions.checkNotNull(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        public Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f11250e = (LoadErrorHandlingPolicy) Assertions.checkNotNull(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public DashMediaSource createMediaSource(DashManifest dashManifest, MediaItem mediaItem) {
            Assertions.checkArgument(!dashManifest.dynamic);
            MediaItem.Builder mimeType = mediaItem.buildUpon().setMimeType(MimeTypes.APPLICATION_MPD);
            if (mediaItem.localConfiguration == null) {
                mimeType.setUri(Uri.EMPTY);
            }
            MediaItem build = mimeType.build();
            return new DashMediaSource(build, dashManifest, null, null, this.f11246a, this.f11249d, this.f11248c.get(build), this.f11250e, this.f11251f);
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        public DashMediaSource createMediaSource(MediaItem mediaItem) {
            Assertions.checkNotNull(mediaItem.localConfiguration);
            ParsingLoadable.Parser parser = this.f11252g;
            if (parser == null) {
                parser = new DashManifestParser();
            }
            List<StreamKey> list = mediaItem.localConfiguration.streamKeys;
            return new DashMediaSource(mediaItem, null, this.f11247b, !list.isEmpty() ? new FilteringManifestParser(parser, list) : parser, this.f11246a, this.f11249d, this.f11248c.get(mediaItem), this.f11250e, this.f11251f);
        }
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.dash");
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [ey] */
    /* JADX WARN: Type inference failed for: r2v8, types: [ey] */
    public DashMediaSource(MediaItem mediaItem, DashManifest dashManifest, DataSource.Factory factory, ParsingLoadable.Parser parser, DashChunkSource.Factory factory2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j) {
        boolean z;
        this.f11227h = mediaItem;
        this.f11216E = mediaItem.liveConfiguration;
        this.f11217F = ((MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem.localConfiguration)).uri;
        this.f11218G = mediaItem.localConfiguration.uri;
        this.f11219H = dashManifest;
        this.f11229j = factory;
        this.f11237r = parser;
        this.f11230k = factory2;
        this.f11232m = drmSessionManager;
        this.f11233n = loadErrorHandlingPolicy;
        this.f11235p = j;
        this.f11231l = compositeSequenceableLoaderFactory;
        if (dashManifest != null) {
            z = true;
        } else {
            z = false;
        }
        this.f11228i = z;
        this.f11236q = createEventDispatcher(null);
        this.f11239t = new Object();
        this.f11240u = new SparseArray();
        this.f11243x = new C0695b(this);
        this.f11225N = C0643C.TIME_UNSET;
        this.f11223L = C0643C.TIME_UNSET;
        if (z) {
            Assertions.checkState(true ^ dashManifest.dynamic);
            this.f11238s = null;
            this.f11241v = null;
            this.f11242w = null;
            this.f11244y = new LoaderErrorThrower.Dummy();
            return;
        }
        this.f11238s = new C1334iy(this);
        this.f11244y = new b01(10, this);
        final int i = 0;
        this.f11241v = new Runnable(this) { // from class: ey

            /* renamed from: b */
            public final /* synthetic */ DashMediaSource f17033b;

            {
                this.f17033b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                DashMediaSource dashMediaSource = this.f17033b;
                switch (i) {
                    case 0:
                        String str = DashMediaSource.DEFAULT_MEDIA_ID;
                        dashMediaSource.m2777d();
                        return;
                    default:
                        String str2 = DashMediaSource.DEFAULT_MEDIA_ID;
                        dashMediaSource.m2776c(false);
                        return;
                }
            }
        };
        final int i2 = 1;
        this.f11242w = new Runnable(this) { // from class: ey

            /* renamed from: b */
            public final /* synthetic */ DashMediaSource f17033b;

            {
                this.f17033b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                DashMediaSource dashMediaSource = this.f17033b;
                switch (i2) {
                    case 0:
                        String str = DashMediaSource.DEFAULT_MEDIA_ID;
                        dashMediaSource.m2777d();
                        return;
                    default:
                        String str2 = DashMediaSource.DEFAULT_MEDIA_ID;
                        dashMediaSource.m2776c(false);
                        return;
                }
            }
        };
    }

    /* renamed from: a */
    public static boolean m2774a(Period period) {
        for (int i = 0; i < period.adaptationSets.size(); i++) {
            int i2 = period.adaptationSets.get(i).type;
            if (i2 == 1 || i2 == 2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public final void m2775b(ParsingLoadable parsingLoadable, long j, long j2) {
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        this.f11233n.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        this.f11236q.loadCanceled(loadEventInfo, parsingLoadable.type);
    }

    /* JADX WARN: Removed duplicated region for block: B:160:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:208:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01fd  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2776c(boolean z) {
        int i;
        Period period;
        Period period2;
        boolean z2;
        DashManifest dashManifest;
        boolean z3;
        Period period3;
        long j;
        long j2;
        DashManifest dashManifest2;
        MediaItem.LiveConfiguration liveConfiguration;
        long j3;
        Period period4;
        boolean z4;
        long j4;
        long j5;
        ServiceDescriptionElement serviceDescriptionElement;
        long j6;
        Period period5;
        long j7;
        boolean z5;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            SparseArray sparseArray = this.f11240u;
            if (i3 >= sparseArray.size()) {
                break;
            }
            int keyAt = sparseArray.keyAt(i3);
            if (keyAt >= this.f11226O) {
                C0694a c0694a = (C0694a) sparseArray.valueAt(i3);
                DashManifest dashManifest3 = this.f11219H;
                int i4 = keyAt - this.f11226O;
                c0694a.f11313v = dashManifest3;
                c0694a.f11314w = i4;
                c0694a.f11304m.updateManifest(dashManifest3);
                ChunkSampleStream[] chunkSampleStreamArr = c0694a.f11310s;
                if (chunkSampleStreamArr != null) {
                    for (ChunkSampleStream chunkSampleStream : chunkSampleStreamArr) {
                        ((DashChunkSource) chunkSampleStream.getChunkSource()).updateManifest(dashManifest3, i4);
                    }
                    c0694a.f11309r.onContinueLoadingRequested(c0694a);
                }
                c0694a.f11315x = dashManifest3.getPeriod(i4).eventStreams;
                for (da0 da0Var : c0694a.f11311t) {
                    Iterator it = c0694a.f11315x.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            EventStream eventStream = (EventStream) it.next();
                            if (eventStream.m2788id().equals(da0Var.f16308e.m2788id())) {
                                int periodCount = dashManifest3.getPeriodCount() - 1;
                                if (dashManifest3.dynamic && i4 == periodCount) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                da0Var.m4558a(eventStream, z5);
                            }
                        }
                    }
                }
            }
            i3++;
        }
        Period period6 = this.f11219H.getPeriod(0);
        int periodCount2 = this.f11219H.getPeriodCount() - 1;
        Period period7 = this.f11219H.getPeriod(periodCount2);
        long periodDurationUs = this.f11219H.getPeriodDurationUs(periodCount2);
        long msToUs = Util.msToUs(Util.getNowUnixTimeMs(this.f11223L));
        long periodDurationUs2 = this.f11219H.getPeriodDurationUs(0);
        long msToUs2 = Util.msToUs(period6.startMs);
        boolean m2774a = m2774a(period6);
        int i5 = 0;
        long j8 = periodDurationUs;
        long j9 = msToUs2;
        while (true) {
            i = 3;
            period = period7;
            long j10 = j9;
            if (i5 < period6.adaptationSets.size()) {
                AdaptationSet adaptationSet = period6.adaptationSets.get(i5);
                List<Representation> list = adaptationSet.representations;
                if ((m2774a && adaptationSet.type == 3) || list.isEmpty()) {
                    j9 = j10;
                } else {
                    DashSegmentIndex index = list.get(0).getIndex();
                    if (index == null || index.getAvailableSegmentCount(periodDurationUs2, msToUs) == 0) {
                        break;
                    } else {
                        j9 = Math.max(j10, index.getTimeUs(index.getFirstAvailableSegmentNum(periodDurationUs2, msToUs)) + msToUs2);
                    }
                }
                i5++;
                period7 = period;
            } else {
                msToUs2 = j10;
                break;
            }
        }
        long msToUs3 = Util.msToUs(period.startMs);
        boolean m2774a2 = m2774a(period);
        int i6 = 0;
        long j11 = Long.MAX_VALUE;
        while (true) {
            if (i6 < period.adaptationSets.size()) {
                AdaptationSet adaptationSet2 = period.adaptationSets.get(i6);
                List<Representation> list2 = adaptationSet2.representations;
                if ((m2774a2 && adaptationSet2.type == i) || list2.isEmpty()) {
                    period5 = period6;
                    j6 = j8;
                    j7 = msToUs3;
                } else {
                    DashSegmentIndex index2 = list2.get(i2).getIndex();
                    if (index2 == null) {
                        msToUs3 += j8;
                        period2 = period6;
                        break;
                    }
                    Period period8 = period6;
                    j6 = j8;
                    long availableSegmentCount = index2.getAvailableSegmentCount(j6, msToUs);
                    if (availableSegmentCount == 0) {
                        period2 = period8;
                        break;
                    }
                    period5 = period8;
                    long firstAvailableSegmentNum = (index2.getFirstAvailableSegmentNum(j6, msToUs) + availableSegmentCount) - 1;
                    j7 = msToUs3;
                    j11 = Math.min(j11, index2.getDurationUs(firstAvailableSegmentNum, j6) + index2.getTimeUs(firstAvailableSegmentNum) + msToUs3);
                }
                i6++;
                msToUs3 = j7;
                i = 3;
                j8 = j6;
                period6 = period5;
                i2 = 0;
            } else {
                period2 = period6;
                msToUs3 = j11;
                break;
            }
        }
        if (this.f11219H.dynamic) {
            for (int i7 = 0; i7 < period.adaptationSets.size(); i7++) {
                DashSegmentIndex index3 = period.adaptationSets.get(i7).representations.get(0).getIndex();
                if (index3 != null && !index3.isExplicit()) {
                }
            }
            z2 = true;
            if (z2) {
                long j12 = this.f11219H.timeShiftBufferDepthMs;
                if (j12 != C0643C.TIME_UNSET) {
                    msToUs2 = Math.max(msToUs2, msToUs3 - Util.msToUs(j12));
                }
            }
            long j13 = msToUs3 - msToUs2;
            dashManifest = this.f11219H;
            if (!dashManifest.dynamic) {
                if (dashManifest.availabilityStartTimeMs != C0643C.TIME_UNSET) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Assertions.checkState(z4);
                long msToUs4 = (msToUs - Util.msToUs(this.f11219H.availabilityStartTimeMs)) - msToUs2;
                long usToMs = Util.usToMs(msToUs4);
                MediaItem mediaItem = this.f11227h;
                long j14 = mediaItem.liveConfiguration.maxOffsetMs;
                if (j14 != C0643C.TIME_UNSET) {
                    j4 = Math.min(usToMs, j14);
                } else {
                    ServiceDescriptionElement serviceDescriptionElement2 = this.f11219H.serviceDescription;
                    if (serviceDescriptionElement2 != null) {
                        long j15 = serviceDescriptionElement2.maxOffsetMs;
                        if (j15 != C0643C.TIME_UNSET) {
                            j4 = Math.min(usToMs, j15);
                        }
                    }
                    j4 = usToMs;
                }
                long usToMs2 = Util.usToMs(msToUs4 - j13);
                if (usToMs2 < 0 && j4 > 0) {
                    usToMs2 = 0;
                }
                z3 = z2;
                long j16 = this.f11219H.minBufferTimeMs;
                if (j16 != C0643C.TIME_UNSET) {
                    j5 = Math.min(usToMs2 + j16, usToMs);
                } else {
                    j5 = usToMs2;
                }
                long j17 = mediaItem.liveConfiguration.minOffsetMs;
                if (j17 != C0643C.TIME_UNSET) {
                    j5 = Util.constrainValue(j17, j5, usToMs);
                } else {
                    ServiceDescriptionElement serviceDescriptionElement3 = this.f11219H.serviceDescription;
                    if (serviceDescriptionElement3 != null) {
                        long j18 = serviceDescriptionElement3.minOffsetMs;
                        if (j18 != C0643C.TIME_UNSET) {
                            j5 = Util.constrainValue(j18, j5, usToMs);
                        }
                    }
                }
                long j19 = j5;
                if (j19 > j4) {
                    j4 = j19;
                }
                long j20 = this.f11216E.targetOffsetMs;
                if (j20 == C0643C.TIME_UNSET) {
                    DashManifest dashManifest4 = this.f11219H;
                    ServiceDescriptionElement serviceDescriptionElement4 = dashManifest4.serviceDescription;
                    if (serviceDescriptionElement4 != null) {
                        long j21 = serviceDescriptionElement4.targetOffsetMs;
                        if (j21 != C0643C.TIME_UNSET) {
                            j20 = j21;
                        }
                    }
                    j20 = dashManifest4.suggestedPresentationDelayMs;
                    if (j20 == C0643C.TIME_UNSET) {
                        j20 = this.f11235p;
                    }
                }
                if (j20 < j19) {
                    j20 = j19;
                }
                if (j20 > j4) {
                    j20 = Util.constrainValue(Util.usToMs(msToUs4 - Math.min(5000000L, j13 / 2)), j19, j4);
                }
                MediaItem.LiveConfiguration liveConfiguration2 = mediaItem.liveConfiguration;
                float f = liveConfiguration2.minPlaybackSpeed;
                if (f == -3.4028235E38f) {
                    ServiceDescriptionElement serviceDescriptionElement5 = this.f11219H.serviceDescription;
                    if (serviceDescriptionElement5 != null) {
                        f = serviceDescriptionElement5.minPlaybackSpeed;
                    } else {
                        f = -3.4028235E38f;
                    }
                }
                float f2 = liveConfiguration2.maxPlaybackSpeed;
                if (f2 == -3.4028235E38f) {
                    ServiceDescriptionElement serviceDescriptionElement6 = this.f11219H.serviceDescription;
                    if (serviceDescriptionElement6 != null) {
                        f2 = serviceDescriptionElement6.maxPlaybackSpeed;
                    } else {
                        f2 = -3.4028235E38f;
                    }
                }
                if (f == -3.4028235E38f && f2 == -3.4028235E38f && ((serviceDescriptionElement = this.f11219H.serviceDescription) == null || serviceDescriptionElement.targetOffsetMs == C0643C.TIME_UNSET)) {
                    f = 1.0f;
                    f2 = 1.0f;
                }
                this.f11216E = new MediaItem.LiveConfiguration.Builder().setTargetOffsetMs(j20).setMinOffsetMs(j19).setMaxOffsetMs(j4).setMinPlaybackSpeed(f).setMaxPlaybackSpeed(f2).build();
                long usToMs3 = Util.usToMs(msToUs2) + this.f11219H.availabilityStartTimeMs;
                long msToUs5 = msToUs4 - Util.msToUs(this.f11216E.targetOffsetMs);
                long min = Math.min(5000000L, j13 / 2);
                if (msToUs5 < min) {
                    j = usToMs3;
                    j2 = min;
                } else {
                    j2 = msToUs5;
                    j = usToMs3;
                }
                period3 = period2;
            } else {
                z3 = z2;
                period3 = period2;
                j = C0643C.TIME_UNSET;
                j2 = 0;
            }
            long msToUs6 = msToUs2 - Util.msToUs(period3.startMs);
            dashManifest2 = this.f11219H;
            long j22 = dashManifest2.availabilityStartTimeMs;
            long j23 = this.f11223L;
            int i8 = this.f11226O;
            if (!dashManifest2.dynamic) {
                liveConfiguration = this.f11216E;
            } else {
                liveConfiguration = null;
            }
            refreshSourceInfo(new C1249gy(j22, j, j23, i8, msToUs6, j13, j2, dashManifest2, this.f11227h, liveConfiguration));
            if (this.f11228i) {
                Handler handler = this.f11215D;
                RunnableC1175ey runnableC1175ey = this.f11242w;
                handler.removeCallbacks(runnableC1175ey);
                if (z3) {
                    Handler handler2 = this.f11215D;
                    DashManifest dashManifest5 = this.f11219H;
                    long nowUnixTimeMs = Util.getNowUnixTimeMs(this.f11223L);
                    int periodCount3 = dashManifest5.getPeriodCount() - 1;
                    Period period9 = dashManifest5.getPeriod(periodCount3);
                    long msToUs7 = Util.msToUs(period9.startMs);
                    long periodDurationUs3 = dashManifest5.getPeriodDurationUs(periodCount3);
                    long msToUs8 = Util.msToUs(nowUnixTimeMs);
                    long msToUs9 = Util.msToUs(dashManifest5.availabilityStartTimeMs);
                    long msToUs10 = Util.msToUs(5000L);
                    int i9 = 0;
                    while (i9 < period9.adaptationSets.size()) {
                        List<Representation> list3 = period9.adaptationSets.get(i9).representations;
                        if (list3.isEmpty()) {
                            period4 = period9;
                        } else {
                            period4 = period9;
                            DashSegmentIndex index4 = list3.get(0).getIndex();
                            if (index4 != null) {
                                long nextSegmentAvailableTimeUs = (index4.getNextSegmentAvailableTimeUs(periodDurationUs3, msToUs8) + (msToUs9 + msToUs7)) - msToUs8;
                                if (nextSegmentAvailableTimeUs < msToUs10 - 100000 || (nextSegmentAvailableTimeUs > msToUs10 && nextSegmentAvailableTimeUs < msToUs10 + 100000)) {
                                    msToUs10 = nextSegmentAvailableTimeUs;
                                }
                            }
                        }
                        i9++;
                        period9 = period4;
                    }
                    handler2.postDelayed(runnableC1175ey, LongMath.divide(msToUs10, 1000L, RoundingMode.CEILING));
                }
                if (this.f11220I) {
                    m2777d();
                    return;
                }
                if (z) {
                    DashManifest dashManifest6 = this.f11219H;
                    if (dashManifest6.dynamic) {
                        long j24 = dashManifest6.minUpdatePeriodMs;
                        if (j24 != C0643C.TIME_UNSET) {
                            if (j24 == 0) {
                                j3 = 5000;
                            } else {
                                j3 = j24;
                            }
                            this.f11215D.postDelayed(this.f11241v, Math.max(0L, (this.f11221J + j3) - SystemClock.elapsedRealtime()));
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        z2 = false;
        if (z2) {
        }
        long j132 = msToUs3 - msToUs2;
        dashManifest = this.f11219H;
        if (!dashManifest.dynamic) {
        }
        long msToUs62 = msToUs2 - Util.msToUs(period3.startMs);
        dashManifest2 = this.f11219H;
        long j222 = dashManifest2.availabilityStartTimeMs;
        long j232 = this.f11223L;
        int i82 = this.f11226O;
        if (!dashManifest2.dynamic) {
        }
        refreshSourceInfo(new C1249gy(j222, j, j232, i82, msToUs62, j132, j2, dashManifest2, this.f11227h, liveConfiguration));
        if (this.f11228i) {
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        int intValue = ((Integer) mediaPeriodId.periodUid).intValue() - this.f11226O;
        MediaSourceEventListener.EventDispatcher createEventDispatcher = createEventDispatcher(mediaPeriodId, this.f11219H.getPeriod(intValue).startMs);
        DrmSessionEventListener.EventDispatcher createDrmEventDispatcher = createDrmEventDispatcher(mediaPeriodId);
        int i = this.f11226O + intValue;
        DashManifest dashManifest = this.f11219H;
        TransferListener transferListener = this.f11213B;
        long j2 = this.f11223L;
        PlayerId playerId = getPlayerId();
        C0694a c0694a = new C0694a(i, dashManifest, this.f11234o, intValue, this.f11230k, transferListener, this.f11232m, createDrmEventDispatcher, this.f11233n, createEventDispatcher, j2, this.f11244y, allocator, this.f11231l, this.f11243x, playerId);
        this.f11240u.put(i, c0694a);
        return c0694a;
    }

    /* renamed from: d */
    public final void m2777d() {
        Uri uri;
        this.f11215D.removeCallbacks(this.f11241v);
        if (this.f11212A.hasFatalError()) {
            return;
        }
        if (this.f11212A.isLoading()) {
            this.f11220I = true;
            return;
        }
        synchronized (this.f11239t) {
            uri = this.f11217F;
        }
        this.f11220I = false;
        ParsingLoadable parsingLoadable = new ParsingLoadable(this.f11245z, uri, 4, this.f11237r);
        this.f11236q.loadStarted(new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, this.f11212A.startLoading(parsingLoadable, this.f11238s, this.f11233n.getMinimumLoadableRetryCount(4))), parsingLoadable.type);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        return this.f11227h;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
        this.f11244y.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        this.f11213B = transferListener;
        DrmSessionManager drmSessionManager = this.f11232m;
        drmSessionManager.prepare();
        drmSessionManager.setPlayer(Looper.myLooper(), getPlayerId());
        if (this.f11228i) {
            m2776c(false);
            return;
        }
        this.f11245z = this.f11229j.createDataSource();
        this.f11212A = new Loader(DEFAULT_MEDIA_ID);
        this.f11215D = Util.createHandlerForCurrentLooper();
        m2777d();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        C0694a c0694a = (C0694a) mediaPeriod;
        c0694a.f11304m.release();
        for (ChunkSampleStream chunkSampleStream : c0694a.f11310s) {
            chunkSampleStream.release(c0694a);
        }
        c0694a.f11309r = null;
        this.f11240u.remove(c0694a.f11292a);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        DashManifest dashManifest;
        this.f11220I = false;
        this.f11245z = null;
        Loader loader = this.f11212A;
        if (loader != null) {
            loader.release();
            this.f11212A = null;
        }
        this.f11221J = 0L;
        this.f11222K = 0L;
        if (this.f11228i) {
            dashManifest = this.f11219H;
        } else {
            dashManifest = null;
        }
        this.f11219H = dashManifest;
        this.f11217F = this.f11218G;
        this.f11214C = null;
        Handler handler = this.f11215D;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f11215D = null;
        }
        this.f11223L = C0643C.TIME_UNSET;
        this.f11224M = 0;
        this.f11225N = C0643C.TIME_UNSET;
        this.f11226O = 0;
        this.f11240u.clear();
        this.f11234o.reset();
        this.f11232m.release();
    }

    public void replaceManifestUri(Uri uri) {
        synchronized (this.f11239t) {
            this.f11217F = uri;
            this.f11218G = uri;
        }
    }
}
