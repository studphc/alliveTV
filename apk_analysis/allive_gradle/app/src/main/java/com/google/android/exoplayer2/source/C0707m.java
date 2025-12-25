package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000.RunnableC0583c7;
import p000.t72;
import p000.tl1;
import p000.u72;
import p000.w72;
import p000.x72;
import p000.y72;

/* renamed from: com.google.android.exoplayer2.source.m */
/* loaded from: classes.dex */
public final class C0707m implements MediaPeriod, ExtractorOutput, Loader.Callback, Loader.ReleaseCallback, SampleQueue.UpstreamFormatChangedListener {

    /* renamed from: M */
    public static final Map f11546M;

    /* renamed from: N */
    public static final Format f11547N;

    /* renamed from: A */
    public boolean f11548A;

    /* renamed from: C */
    public boolean f11550C;

    /* renamed from: D */
    public boolean f11551D;

    /* renamed from: E */
    public int f11552E;

    /* renamed from: F */
    public boolean f11553F;

    /* renamed from: G */
    public long f11554G;

    /* renamed from: I */
    public boolean f11556I;

    /* renamed from: J */
    public int f11557J;

    /* renamed from: K */
    public boolean f11558K;

    /* renamed from: L */
    public boolean f11559L;

    /* renamed from: a */
    public final Uri f11560a;

    /* renamed from: b */
    public final DataSource f11561b;

    /* renamed from: c */
    public final DrmSessionManager f11562c;

    /* renamed from: d */
    public final LoadErrorHandlingPolicy f11563d;

    /* renamed from: e */
    public final MediaSourceEventListener.EventDispatcher f11564e;

    /* renamed from: f */
    public final DrmSessionEventListener.EventDispatcher f11565f;

    /* renamed from: g */
    public final ProgressiveMediaSource f11566g;

    /* renamed from: h */
    public final Allocator f11567h;

    /* renamed from: i */
    public final String f11568i;

    /* renamed from: j */
    public final long f11569j;

    /* renamed from: l */
    public final ProgressiveMediaExtractor f11571l;

    /* renamed from: q */
    public MediaPeriod.Callback f11576q;

    /* renamed from: r */
    public IcyHeaders f11577r;

    /* renamed from: u */
    public boolean f11580u;

    /* renamed from: v */
    public boolean f11581v;

    /* renamed from: w */
    public boolean f11582w;

    /* renamed from: x */
    public y72 f11583x;

    /* renamed from: y */
    public SeekMap f11584y;

    /* renamed from: k */
    public final Loader f11570k = new Loader("ProgressiveMediaPeriod");

    /* renamed from: m */
    public final ConditionVariable f11572m = new ConditionVariable();

    /* renamed from: n */
    public final t72 f11573n = new t72(this, 0);

    /* renamed from: o */
    public final t72 f11574o = new t72(this, 1);

    /* renamed from: p */
    public final Handler f11575p = Util.createHandlerForCurrentLooper();

    /* renamed from: t */
    public x72[] f11579t = new x72[0];

    /* renamed from: s */
    public SampleQueue[] f11578s = new SampleQueue[0];

    /* renamed from: H */
    public long f11555H = C0643C.TIME_UNSET;

    /* renamed from: z */
    public long f11585z = C0643C.TIME_UNSET;

    /* renamed from: B */
    public int f11549B = 1;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_NAME, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
        f11546M = Collections.unmodifiableMap(hashMap);
        f11547N = new Format.Builder().setId("icy").setSampleMimeType(MimeTypes.APPLICATION_ICY).build();
    }

    public C0707m(Uri uri, DataSource dataSource, ProgressiveMediaExtractor progressiveMediaExtractor, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, ProgressiveMediaSource progressiveMediaSource, Allocator allocator, String str, int i) {
        this.f11560a = uri;
        this.f11561b = dataSource;
        this.f11562c = drmSessionManager;
        this.f11565f = eventDispatcher;
        this.f11563d = loadErrorHandlingPolicy;
        this.f11564e = eventDispatcher2;
        this.f11566g = progressiveMediaSource;
        this.f11567h = allocator;
        this.f11568i = str;
        this.f11569j = i;
        this.f11571l = progressiveMediaExtractor;
    }

    /* renamed from: a */
    public final void m2815a() {
        Assertions.checkState(this.f11581v);
        Assertions.checkNotNull(this.f11583x);
        Assertions.checkNotNull(this.f11584y);
    }

    /* renamed from: b */
    public final int m2816b() {
        int i = 0;
        for (SampleQueue sampleQueue : this.f11578s) {
            i += sampleQueue.getWriteIndex();
        }
        return i;
    }

    /* renamed from: c */
    public final long m2817c(boolean z) {
        long j = Long.MIN_VALUE;
        for (int i = 0; i < this.f11578s.length; i++) {
            if (z || ((y72) Assertions.checkNotNull(this.f11583x)).f28859c[i]) {
                j = Math.max(j, this.f11578s[i].getLargestQueuedTimestampUs());
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final boolean continueLoading(long j) {
        if (!this.f11558K) {
            Loader loader = this.f11570k;
            if (!loader.hasFatalError() && !this.f11556I) {
                if (!this.f11581v || this.f11552E != 0) {
                    boolean open = this.f11572m.open();
                    if (!loader.isLoading()) {
                        m2823i();
                        return true;
                    }
                    return open;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* renamed from: d */
    public final boolean m2818d() {
        if (this.f11555H != C0643C.TIME_UNSET) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final void discardBuffer(long j, boolean z) {
        m2815a();
        if (m2818d()) {
            return;
        }
        boolean[] zArr = this.f11583x.f28859c;
        int length = this.f11578s.length;
        for (int i = 0; i < length; i++) {
            this.f11578s[i].discardTo(j, z, zArr[i]);
        }
    }

    /* renamed from: e */
    public final void m2819e() {
        boolean z;
        Metadata copyWithAppendedEntries;
        if (!this.f11559L && !this.f11581v && this.f11580u && this.f11584y != null) {
            for (SampleQueue sampleQueue : this.f11578s) {
                if (sampleQueue.getUpstreamFormat() == null) {
                    return;
                }
            }
            this.f11572m.close();
            int length = this.f11578s.length;
            TrackGroup[] trackGroupArr = new TrackGroup[length];
            boolean[] zArr = new boolean[length];
            for (int i = 0; i < length; i++) {
                Format format = (Format) Assertions.checkNotNull(this.f11578s[i].getUpstreamFormat());
                String str = format.sampleMimeType;
                boolean isAudio = MimeTypes.isAudio(str);
                if (!isAudio && !MimeTypes.isVideo(str)) {
                    z = false;
                } else {
                    z = true;
                }
                zArr[i] = z;
                this.f11582w = z | this.f11582w;
                IcyHeaders icyHeaders = this.f11577r;
                if (icyHeaders != null) {
                    if (isAudio || this.f11579t[i].f28457b) {
                        Metadata metadata = format.metadata;
                        if (metadata == null) {
                            copyWithAppendedEntries = new Metadata(icyHeaders);
                        } else {
                            copyWithAppendedEntries = metadata.copyWithAppendedEntries(icyHeaders);
                        }
                        format = format.buildUpon().setMetadata(copyWithAppendedEntries).build();
                    }
                    if (isAudio && format.averageBitrate == -1 && format.peakBitrate == -1 && icyHeaders.bitrate != -1) {
                        format = format.buildUpon().setAverageBitrate(icyHeaders.bitrate).build();
                    }
                }
                trackGroupArr[i] = new TrackGroup(Integer.toString(i), format.copyWithCryptoType(this.f11562c.getCryptoType(format)));
            }
            this.f11583x = new y72(new TrackGroupArray(trackGroupArr), zArr);
            this.f11581v = true;
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.f11576q)).onPrepared(this);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public final void endTracks() {
        this.f11580u = true;
        this.f11575p.post(this.f11573n);
    }

    /* renamed from: f */
    public final void m2820f(int i) {
        m2815a();
        y72 y72Var = this.f11583x;
        boolean[] zArr = y72Var.f28860d;
        if (!zArr[i]) {
            Format format = y72Var.f28857a.get(i).getFormat(0);
            this.f11564e.downstreamFormatChanged(MimeTypes.getTrackType(format.sampleMimeType), format, 0, null, this.f11554G);
            zArr[i] = true;
        }
    }

    /* renamed from: g */
    public final void m2821g(int i) {
        m2815a();
        boolean[] zArr = this.f11583x.f28858b;
        if (this.f11556I && zArr[i]) {
            if (!this.f11578s[i].isReady(false)) {
                this.f11555H = 0L;
                this.f11556I = false;
                this.f11551D = true;
                this.f11554G = 0L;
                this.f11557J = 0;
                for (SampleQueue sampleQueue : this.f11578s) {
                    sampleQueue.reset();
                }
                ((MediaPeriod.Callback) Assertions.checkNotNull(this.f11576q)).onContinueLoadingRequested(this);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        m2815a();
        if (!this.f11584y.isSeekable()) {
            return 0L;
        }
        SeekMap.SeekPoints seekPoints = this.f11584y.getSeekPoints(j);
        return seekParameters.resolveSeekPositionUs(j, seekPoints.first.timeUs, seekPoints.second.timeUs);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final long getBufferedPositionUs() {
        long j;
        m2815a();
        if (this.f11558K || this.f11552E == 0) {
            return Long.MIN_VALUE;
        }
        if (m2818d()) {
            return this.f11555H;
        }
        if (this.f11582w) {
            int length = this.f11578s.length;
            j = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                y72 y72Var = this.f11583x;
                if (y72Var.f28858b[i] && y72Var.f28859c[i] && !this.f11578s[i].isLastSampleQueued()) {
                    j = Math.min(j, this.f11578s[i].getLargestQueuedTimestampUs());
                }
            }
        } else {
            j = Long.MAX_VALUE;
        }
        if (j == Long.MAX_VALUE) {
            j = m2817c(false);
        }
        if (j == Long.MIN_VALUE) {
            return this.f11554G;
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final long getNextLoadPositionUs() {
        return getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final /* synthetic */ List getStreamKeys(List list) {
        return tl1.m7499a(this, list);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final TrackGroupArray getTrackGroups() {
        m2815a();
        return this.f11583x.f28857a;
    }

    /* renamed from: h */
    public final SampleQueue m2822h(x72 x72Var) {
        int length = this.f11578s.length;
        for (int i = 0; i < length; i++) {
            if (x72Var.equals(this.f11579t[i])) {
                return this.f11578s[i];
            }
        }
        SampleQueue createWithDrm = SampleQueue.createWithDrm(this.f11567h, this.f11562c, this.f11565f);
        createWithDrm.setUpstreamFormatChangeListener(this);
        int i2 = length + 1;
        x72[] x72VarArr = (x72[]) Arrays.copyOf(this.f11579t, i2);
        x72VarArr[length] = x72Var;
        this.f11579t = (x72[]) Util.castNonNullTypeArray(x72VarArr);
        SampleQueue[] sampleQueueArr = (SampleQueue[]) Arrays.copyOf(this.f11578s, i2);
        sampleQueueArr[length] = createWithDrm;
        this.f11578s = (SampleQueue[]) Util.castNonNullTypeArray(sampleQueueArr);
        return createWithDrm;
    }

    /* renamed from: i */
    public final void m2823i() {
        u72 u72Var = new u72(this, this.f11560a, this.f11561b, this.f11571l, this, this.f11572m);
        if (this.f11581v) {
            Assertions.checkState(m2818d());
            long j = this.f11585z;
            if (j != C0643C.TIME_UNSET && this.f11555H > j) {
                this.f11558K = true;
                this.f11555H = C0643C.TIME_UNSET;
                return;
            }
            long j2 = ((SeekMap) Assertions.checkNotNull(this.f11584y)).getSeekPoints(this.f11555H).first.position;
            long j3 = this.f11555H;
            u72Var.f27135g.position = j2;
            u72Var.f27138j = j3;
            u72Var.f27137i = true;
            u72Var.f27141m = false;
            for (SampleQueue sampleQueue : this.f11578s) {
                sampleQueue.setStartTimeUs(this.f11555H);
            }
            this.f11555H = C0643C.TIME_UNSET;
        }
        this.f11557J = m2816b();
        this.f11564e.loadStarted(new LoadEventInfo(u72Var.f27129a, u72Var.f27139k, this.f11570k.startLoading(u72Var, this, this.f11563d.getMinimumLoadableRetryCount(this.f11549B))), 1, -1, null, 0, null, u72Var.f27138j, this.f11585z);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final boolean isLoading() {
        if (this.f11570k.isLoading() && this.f11572m.isOpen()) {
            return true;
        }
        return false;
    }

    /* renamed from: j */
    public final boolean m2824j() {
        if (!this.f11551D && !m2818d()) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final void maybeThrowPrepareError() {
        this.f11570k.maybeThrowError(this.f11563d.getMinimumLoadableRetryCount(this.f11549B));
        if (this.f11558K && !this.f11581v) {
            throw ParserException.createForMalformedContainer("Loading finished before preparation is complete.", null);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public final void onLoadCanceled(Loader.Loadable loadable, long j, long j2, boolean z) {
        u72 u72Var = (u72) loadable;
        StatsDataSource statsDataSource = u72Var.f27131c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(u72Var.f27129a, u72Var.f27139k, statsDataSource.getLastOpenedUri(), statsDataSource.getLastResponseHeaders(), j, j2, statsDataSource.getBytesRead());
        this.f11563d.onLoadTaskConcluded(u72Var.f27129a);
        this.f11564e.loadCanceled(loadEventInfo, 1, -1, null, 0, null, u72Var.f27138j, this.f11585z);
        if (!z) {
            for (SampleQueue sampleQueue : this.f11578s) {
                sampleQueue.reset();
            }
            if (this.f11552E > 0) {
                ((MediaPeriod.Callback) Assertions.checkNotNull(this.f11576q)).onContinueLoadingRequested(this);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public final void onLoadCompleted(Loader.Loadable loadable, long j, long j2) {
        SeekMap seekMap;
        long j3;
        u72 u72Var = (u72) loadable;
        if (this.f11585z == C0643C.TIME_UNSET && (seekMap = this.f11584y) != null) {
            boolean isSeekable = seekMap.isSeekable();
            long m2817c = m2817c(true);
            if (m2817c == Long.MIN_VALUE) {
                j3 = 0;
            } else {
                j3 = m2817c + 10000;
            }
            this.f11585z = j3;
            this.f11566g.onSourceInfoRefreshed(j3, isSeekable, this.f11548A);
        }
        StatsDataSource statsDataSource = u72Var.f27131c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(u72Var.f27129a, u72Var.f27139k, statsDataSource.getLastOpenedUri(), statsDataSource.getLastResponseHeaders(), j, j2, statsDataSource.getBytesRead());
        this.f11563d.onLoadTaskConcluded(u72Var.f27129a);
        this.f11564e.loadCompleted(loadEventInfo, 1, -1, null, 0, null, u72Var.f27138j, this.f11585z);
        this.f11558K = true;
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.f11576q)).onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public final Loader.LoadErrorAction onLoadError(Loader.Loadable loadable, long j, long j2, IOException iOException, int i) {
        boolean z;
        Loader.LoadErrorAction createRetryAction;
        SeekMap seekMap;
        u72 u72Var = (u72) loadable;
        StatsDataSource statsDataSource = u72Var.f27131c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(u72Var.f27129a, u72Var.f27139k, statsDataSource.getLastOpenedUri(), statsDataSource.getLastResponseHeaders(), j, j2, statsDataSource.getBytesRead());
        LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(1, -1, null, 0, null, Util.usToMs(u72Var.f27138j), Util.usToMs(this.f11585z)), iOException, i);
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f11563d;
        long retryDelayMsFor = loadErrorHandlingPolicy.getRetryDelayMsFor(loadErrorInfo);
        if (retryDelayMsFor == C0643C.TIME_UNSET) {
            createRetryAction = Loader.DONT_RETRY_FATAL;
        } else {
            int m2816b = m2816b();
            if (m2816b > this.f11557J) {
                z = true;
            } else {
                z = false;
            }
            if (!this.f11553F && ((seekMap = this.f11584y) == null || seekMap.getDurationUs() == C0643C.TIME_UNSET)) {
                if (this.f11581v && !m2824j()) {
                    this.f11556I = true;
                    createRetryAction = Loader.DONT_RETRY;
                } else {
                    this.f11551D = this.f11581v;
                    this.f11554G = 0L;
                    this.f11557J = 0;
                    for (SampleQueue sampleQueue : this.f11578s) {
                        sampleQueue.reset();
                    }
                    u72Var.f27135g.position = 0L;
                    u72Var.f27138j = 0L;
                    u72Var.f27137i = true;
                    u72Var.f27141m = false;
                }
            } else {
                this.f11557J = m2816b;
            }
            createRetryAction = Loader.createRetryAction(z, retryDelayMsFor);
        }
        Loader.LoadErrorAction loadErrorAction = createRetryAction;
        boolean isRetry = loadErrorAction.isRetry();
        this.f11564e.loadError(loadEventInfo, 1, -1, null, 0, null, u72Var.f27138j, this.f11585z, iOException, !isRetry);
        if (!isRetry) {
            loadErrorHandlingPolicy.onLoadTaskConcluded(u72Var.f27129a);
        }
        return loadErrorAction;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public final void onLoaderReleased() {
        for (SampleQueue sampleQueue : this.f11578s) {
            sampleQueue.release();
        }
        this.f11571l.release();
    }

    @Override // com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener
    public final void onUpstreamFormatChanged(Format format) {
        this.f11575p.post(this.f11573n);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final void prepare(MediaPeriod.Callback callback, long j) {
        this.f11576q = callback;
        this.f11572m.open();
        m2823i();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long readDiscontinuity() {
        if (this.f11551D) {
            if (this.f11558K || m2816b() > this.f11557J) {
                this.f11551D = false;
                return this.f11554G;
            }
            return C0643C.TIME_UNSET;
        }
        return C0643C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final void reevaluateBuffer(long j) {
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public final void seekMap(SeekMap seekMap) {
        this.f11575p.post(new RunnableC0583c7(27, this, seekMap));
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long seekToUs(long j) {
        m2815a();
        boolean[] zArr = this.f11583x.f28858b;
        if (!this.f11584y.isSeekable()) {
            j = 0;
        }
        int i = 0;
        this.f11551D = false;
        this.f11554G = j;
        if (m2818d()) {
            this.f11555H = j;
            return j;
        }
        if (this.f11549B != 7) {
            int length = this.f11578s.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (this.f11578s[i2].seekTo(j, false) || (!zArr[i2] && this.f11582w)) {
                }
            }
            return j;
        }
        this.f11556I = false;
        this.f11555H = j;
        this.f11558K = false;
        Loader loader = this.f11570k;
        if (loader.isLoading()) {
            SampleQueue[] sampleQueueArr = this.f11578s;
            int length2 = sampleQueueArr.length;
            while (i < length2) {
                sampleQueueArr[i].discardToEnd();
                i++;
            }
            loader.cancelLoading();
        } else {
            loader.clearFatalError();
            SampleQueue[] sampleQueueArr2 = this.f11578s;
            int length3 = sampleQueueArr2.length;
            while (i < length3) {
                sampleQueueArr2[i].reset();
                i++;
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        boolean z;
        ExoTrackSelection exoTrackSelection;
        boolean z2;
        boolean z3;
        m2815a();
        y72 y72Var = this.f11583x;
        TrackGroupArray trackGroupArray = y72Var.f28857a;
        boolean[] zArr3 = y72Var.f28859c;
        int i = this.f11552E;
        int i2 = 0;
        for (int i3 = 0; i3 < exoTrackSelectionArr.length; i3++) {
            SampleStream sampleStream = sampleStreamArr[i3];
            if (sampleStream != null && (exoTrackSelectionArr[i3] == null || !zArr[i3])) {
                int i4 = ((w72) sampleStream).f28088a;
                Assertions.checkState(zArr3[i4]);
                this.f11552E--;
                zArr3[i4] = false;
                sampleStreamArr[i3] = null;
            }
        }
        if (!this.f11550C ? j != 0 : i == 0) {
            z = true;
        } else {
            z = false;
        }
        for (int i5 = 0; i5 < exoTrackSelectionArr.length; i5++) {
            if (sampleStreamArr[i5] == null && (exoTrackSelection = exoTrackSelectionArr[i5]) != null) {
                if (exoTrackSelection.length() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Assertions.checkState(z2);
                if (exoTrackSelection.getIndexInTrackGroup(0) == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Assertions.checkState(z3);
                int indexOf = trackGroupArray.indexOf(exoTrackSelection.getTrackGroup());
                Assertions.checkState(!zArr3[indexOf]);
                this.f11552E++;
                zArr3[indexOf] = true;
                sampleStreamArr[i5] = new w72(this, indexOf);
                zArr2[i5] = true;
                if (!z) {
                    SampleQueue sampleQueue = this.f11578s[indexOf];
                    if (!sampleQueue.seekTo(j, true) && sampleQueue.getReadIndex() != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
            }
        }
        if (this.f11552E == 0) {
            this.f11556I = false;
            this.f11551D = false;
            Loader loader = this.f11570k;
            if (loader.isLoading()) {
                SampleQueue[] sampleQueueArr = this.f11578s;
                int length = sampleQueueArr.length;
                while (i2 < length) {
                    sampleQueueArr[i2].discardToEnd();
                    i2++;
                }
                loader.cancelLoading();
            } else {
                SampleQueue[] sampleQueueArr2 = this.f11578s;
                int length2 = sampleQueueArr2.length;
                while (i2 < length2) {
                    sampleQueueArr2[i2].reset();
                    i2++;
                }
            }
        } else if (z) {
            j = seekToUs(j);
            while (i2 < sampleStreamArr.length) {
                if (sampleStreamArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.f11550C = true;
        return j;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public final TrackOutput track(int i, int i2) {
        return m2822h(new x72(i, false));
    }
}
