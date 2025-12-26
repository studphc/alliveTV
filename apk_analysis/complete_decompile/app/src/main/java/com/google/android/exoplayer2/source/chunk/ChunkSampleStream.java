package com.google.android.exoplayer2.source.chunk;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public class ChunkSampleStream<T extends ChunkSource> implements SampleStream, SequenceableLoader, Loader.Callback<Chunk>, Loader.ReleaseCallback {

    /* renamed from: a */
    public final int[] f11150a;

    /* renamed from: b */
    public final Format[] f11151b;

    /* renamed from: c */
    public final boolean[] f11152c;

    /* renamed from: d */
    public final ChunkSource f11153d;

    /* renamed from: e */
    public final SequenceableLoader.Callback f11154e;

    /* renamed from: f */
    public final MediaSourceEventListener.EventDispatcher f11155f;

    /* renamed from: g */
    public final LoadErrorHandlingPolicy f11156g;

    /* renamed from: h */
    public final Loader f11157h;

    /* renamed from: i */
    public final ChunkHolder f11158i;

    /* renamed from: j */
    public final ArrayList f11159j;

    /* renamed from: k */
    public final List f11160k;

    /* renamed from: l */
    public final SampleQueue f11161l;

    /* renamed from: m */
    public final SampleQueue[] f11162m;

    /* renamed from: n */
    public final BaseMediaChunkOutput f11163n;

    /* renamed from: o */
    public Chunk f11164o;

    /* renamed from: p */
    public Format f11165p;
    public final int primaryTrackType;

    /* renamed from: q */
    public ReleaseCallback f11166q;

    /* renamed from: r */
    public long f11167r;

    /* renamed from: s */
    public long f11168s;

    /* renamed from: t */
    public int f11169t;

    /* renamed from: u */
    public BaseMediaChunk f11170u;

    /* renamed from: v */
    public boolean f11171v;

    /* loaded from: classes.dex */
    public final class EmbeddedSampleStream implements SampleStream {

        /* renamed from: a */
        public final SampleQueue f11172a;

        /* renamed from: b */
        public final int f11173b;

        /* renamed from: c */
        public boolean f11174c;
        public final ChunkSampleStream<T> parent;

        public EmbeddedSampleStream(ChunkSampleStream<T> chunkSampleStream, SampleQueue sampleQueue, int i) {
            this.parent = chunkSampleStream;
            this.f11172a = sampleQueue;
            this.f11173b = i;
        }

        /* renamed from: a */
        public final void m2770a() {
            if (!this.f11174c) {
                ChunkSampleStream chunkSampleStream = ChunkSampleStream.this;
                MediaSourceEventListener.EventDispatcher eventDispatcher = chunkSampleStream.f11155f;
                int[] iArr = chunkSampleStream.f11150a;
                int i = this.f11173b;
                eventDispatcher.downstreamFormatChanged(iArr[i], chunkSampleStream.f11151b[i], 0, null, chunkSampleStream.f11168s);
                this.f11174c = true;
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            ChunkSampleStream chunkSampleStream = ChunkSampleStream.this;
            if (!chunkSampleStream.m2767d() && this.f11172a.isReady(chunkSampleStream.f11171v)) {
                return true;
            }
            return false;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() {
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
            ChunkSampleStream chunkSampleStream = ChunkSampleStream.this;
            if (chunkSampleStream.m2767d()) {
                return -3;
            }
            BaseMediaChunk baseMediaChunk = chunkSampleStream.f11170u;
            SampleQueue sampleQueue = this.f11172a;
            if (baseMediaChunk != null && baseMediaChunk.getFirstSampleIndex(this.f11173b + 1) <= sampleQueue.getReadIndex()) {
                return -3;
            }
            m2770a();
            return sampleQueue.read(formatHolder, decoderInputBuffer, i, chunkSampleStream.f11171v);
        }

        public void release() {
            ChunkSampleStream chunkSampleStream = ChunkSampleStream.this;
            boolean[] zArr = chunkSampleStream.f11152c;
            int i = this.f11173b;
            Assertions.checkState(zArr[i]);
            chunkSampleStream.f11152c[i] = false;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            ChunkSampleStream chunkSampleStream = ChunkSampleStream.this;
            if (chunkSampleStream.m2767d()) {
                return 0;
            }
            boolean z = chunkSampleStream.f11171v;
            SampleQueue sampleQueue = this.f11172a;
            int skipCount = sampleQueue.getSkipCount(j, z);
            BaseMediaChunk baseMediaChunk = chunkSampleStream.f11170u;
            if (baseMediaChunk != null) {
                skipCount = Math.min(skipCount, baseMediaChunk.getFirstSampleIndex(this.f11173b + 1) - sampleQueue.getReadIndex());
            }
            sampleQueue.skip(skipCount);
            if (skipCount > 0) {
                m2770a();
            }
            return skipCount;
        }
    }

    /* loaded from: classes.dex */
    public interface ReleaseCallback<T extends ChunkSource> {
        void onSampleStreamReleased(ChunkSampleStream<T> chunkSampleStream);
    }

    public ChunkSampleStream(int i, @Nullable int[] iArr, @Nullable Format[] formatArr, T t, SequenceableLoader.Callback<ChunkSampleStream<T>> callback, Allocator allocator, long j, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2) {
        this.primaryTrackType = i;
        int i2 = 0;
        iArr = iArr == null ? new int[0] : iArr;
        this.f11150a = iArr;
        this.f11151b = formatArr == null ? new Format[0] : formatArr;
        this.f11153d = t;
        this.f11154e = callback;
        this.f11155f = eventDispatcher2;
        this.f11156g = loadErrorHandlingPolicy;
        this.f11157h = new Loader("ChunkSampleStream");
        this.f11158i = new ChunkHolder();
        ArrayList arrayList = new ArrayList();
        this.f11159j = arrayList;
        this.f11160k = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.f11162m = new SampleQueue[length];
        this.f11152c = new boolean[length];
        int i3 = length + 1;
        int[] iArr2 = new int[i3];
        SampleQueue[] sampleQueueArr = new SampleQueue[i3];
        SampleQueue createWithDrm = SampleQueue.createWithDrm(allocator, drmSessionManager, eventDispatcher);
        this.f11161l = createWithDrm;
        iArr2[0] = i;
        sampleQueueArr[0] = createWithDrm;
        while (i2 < length) {
            SampleQueue createWithoutDrm = SampleQueue.createWithoutDrm(allocator);
            this.f11162m[i2] = createWithoutDrm;
            int i4 = i2 + 1;
            sampleQueueArr[i4] = createWithoutDrm;
            iArr2[i4] = this.f11150a[i2];
            i2 = i4;
        }
        this.f11163n = new BaseMediaChunkOutput(iArr2, sampleQueueArr);
        this.f11167r = j;
        this.f11168s = j;
    }

    /* renamed from: a */
    public final BaseMediaChunk m2764a(int i) {
        ArrayList arrayList = this.f11159j;
        BaseMediaChunk baseMediaChunk = (BaseMediaChunk) arrayList.get(i);
        Util.removeRange(arrayList, i, arrayList.size());
        this.f11169t = Math.max(this.f11169t, arrayList.size());
        int i2 = 0;
        this.f11161l.discardUpstreamSamples(baseMediaChunk.getFirstSampleIndex(0));
        while (true) {
            SampleQueue[] sampleQueueArr = this.f11162m;
            if (i2 < sampleQueueArr.length) {
                SampleQueue sampleQueue = sampleQueueArr[i2];
                i2++;
                sampleQueue.discardUpstreamSamples(baseMediaChunk.getFirstSampleIndex(i2));
            } else {
                return baseMediaChunk;
            }
        }
    }

    /* renamed from: b */
    public final BaseMediaChunk m2765b() {
        return (BaseMediaChunk) AbstractC1726qj.m7053i(this.f11159j, 1);
    }

    /* renamed from: c */
    public final boolean m2766c(int i) {
        int readIndex;
        BaseMediaChunk baseMediaChunk = (BaseMediaChunk) this.f11159j.get(i);
        if (this.f11161l.getReadIndex() > baseMediaChunk.getFirstSampleIndex(0)) {
            return true;
        }
        int i2 = 0;
        do {
            SampleQueue[] sampleQueueArr = this.f11162m;
            if (i2 >= sampleQueueArr.length) {
                return false;
            }
            readIndex = sampleQueueArr[i2].getReadIndex();
            i2++;
        } while (readIndex <= baseMediaChunk.getFirstSampleIndex(i2));
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        long j2;
        List<? extends MediaChunk> list;
        if (!this.f11171v) {
            Loader loader = this.f11157h;
            if (!loader.isLoading() && !loader.hasFatalError()) {
                boolean m2767d = m2767d();
                if (m2767d) {
                    list = Collections.emptyList();
                    j2 = this.f11167r;
                } else {
                    j2 = m2765b().endTimeUs;
                    list = this.f11160k;
                }
                this.f11153d.getNextChunk(j, j2, list, this.f11158i);
                ChunkHolder chunkHolder = this.f11158i;
                boolean z = chunkHolder.endOfStream;
                Chunk chunk = chunkHolder.chunk;
                chunkHolder.clear();
                if (z) {
                    this.f11167r = C0643C.TIME_UNSET;
                    this.f11171v = true;
                    return true;
                }
                if (chunk == null) {
                    return false;
                }
                this.f11164o = chunk;
                boolean z2 = chunk instanceof BaseMediaChunk;
                BaseMediaChunkOutput baseMediaChunkOutput = this.f11163n;
                if (z2) {
                    BaseMediaChunk baseMediaChunk = (BaseMediaChunk) chunk;
                    if (m2767d) {
                        long j3 = baseMediaChunk.startTimeUs;
                        long j4 = this.f11167r;
                        if (j3 != j4) {
                            this.f11161l.setStartTimeUs(j4);
                            for (SampleQueue sampleQueue : this.f11162m) {
                                sampleQueue.setStartTimeUs(this.f11167r);
                            }
                        }
                        this.f11167r = C0643C.TIME_UNSET;
                    }
                    baseMediaChunk.init(baseMediaChunkOutput);
                    this.f11159j.add(baseMediaChunk);
                } else if (chunk instanceof InitializationChunk) {
                    ((InitializationChunk) chunk).init(baseMediaChunkOutput);
                }
                this.f11155f.loadStarted(new LoadEventInfo(chunk.loadTaskId, chunk.dataSpec, loader.startLoading(chunk, this, this.f11156g.getMinimumLoadableRetryCount(chunk.type))), chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs);
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public final boolean m2767d() {
        if (this.f11167r != C0643C.TIME_UNSET) {
            return true;
        }
        return false;
    }

    public void discardBuffer(long j, boolean z) {
        if (m2767d()) {
            return;
        }
        SampleQueue sampleQueue = this.f11161l;
        int firstIndex = sampleQueue.getFirstIndex();
        sampleQueue.discardTo(j, z, true);
        int firstIndex2 = sampleQueue.getFirstIndex();
        if (firstIndex2 > firstIndex) {
            long firstTimestampUs = sampleQueue.getFirstTimestampUs();
            int i = 0;
            while (true) {
                SampleQueue[] sampleQueueArr = this.f11162m;
                if (i >= sampleQueueArr.length) {
                    break;
                }
                sampleQueueArr[i].discardTo(firstTimestampUs, z, this.f11152c[i]);
                i++;
            }
        }
        int min = Math.min(m2769f(firstIndex2, 0), this.f11169t);
        if (min > 0) {
            Util.removeRange(this.f11159j, 0, min);
            this.f11169t -= min;
        }
    }

    /* renamed from: e */
    public final void m2768e() {
        int m2769f = m2769f(this.f11161l.getReadIndex(), this.f11169t - 1);
        while (true) {
            int i = this.f11169t;
            if (i <= m2769f) {
                this.f11169t = i + 1;
                BaseMediaChunk baseMediaChunk = (BaseMediaChunk) this.f11159j.get(i);
                Format format = baseMediaChunk.trackFormat;
                if (!format.equals(this.f11165p)) {
                    this.f11155f.downstreamFormatChanged(this.primaryTrackType, format, baseMediaChunk.trackSelectionReason, baseMediaChunk.trackSelectionData, baseMediaChunk.startTimeUs);
                }
                this.f11165p = format;
            } else {
                return;
            }
        }
    }

    /* renamed from: f */
    public final int m2769f(int i, int i2) {
        ArrayList arrayList;
        do {
            i2++;
            arrayList = this.f11159j;
            if (i2 >= arrayList.size()) {
                return arrayList.size() - 1;
            }
        } while (((BaseMediaChunk) arrayList.get(i2)).getFirstSampleIndex(0) <= i);
        return i2 - 1;
    }

    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        return this.f11153d.getAdjustedSeekPositionUs(j, seekParameters);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        if (this.f11171v) {
            return Long.MIN_VALUE;
        }
        if (m2767d()) {
            return this.f11167r;
        }
        long j = this.f11168s;
        BaseMediaChunk m2765b = m2765b();
        if (!m2765b.isLoadCompleted()) {
            ArrayList arrayList = this.f11159j;
            if (arrayList.size() > 1) {
                m2765b = (BaseMediaChunk) AbstractC1726qj.m7053i(arrayList, 2);
            } else {
                m2765b = null;
            }
        }
        if (m2765b != null) {
            j = Math.max(j, m2765b.endTimeUs);
        }
        return Math.max(j, this.f11161l.getLargestQueuedTimestampUs());
    }

    public T getChunkSource() {
        return (T) this.f11153d;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        if (m2767d()) {
            return this.f11167r;
        }
        if (this.f11171v) {
            return Long.MIN_VALUE;
        }
        return m2765b().endTimeUs;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.f11157h.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        if (!m2767d() && this.f11161l.isReady(this.f11171v)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() {
        Loader loader = this.f11157h;
        loader.maybeThrowError();
        this.f11161l.maybeThrowError();
        if (!loader.isLoading()) {
            this.f11153d.maybeThrowError();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        this.f11161l.release();
        for (SampleQueue sampleQueue : this.f11162m) {
            sampleQueue.release();
        }
        this.f11153d.release();
        ReleaseCallback releaseCallback = this.f11166q;
        if (releaseCallback != null) {
            releaseCallback.onSampleStreamReleased(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
        if (m2767d()) {
            return -3;
        }
        BaseMediaChunk baseMediaChunk = this.f11170u;
        SampleQueue sampleQueue = this.f11161l;
        if (baseMediaChunk != null && baseMediaChunk.getFirstSampleIndex(0) <= sampleQueue.getReadIndex()) {
            return -3;
        }
        m2768e();
        return sampleQueue.read(formatHolder, decoderInputBuffer, i, this.f11171v);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        Loader loader = this.f11157h;
        if (!loader.hasFatalError() && !m2767d()) {
            boolean isLoading = loader.isLoading();
            List<? extends MediaChunk> list = this.f11160k;
            ChunkSource chunkSource = this.f11153d;
            ArrayList arrayList = this.f11159j;
            if (isLoading) {
                Chunk chunk = (Chunk) Assertions.checkNotNull(this.f11164o);
                boolean z = chunk instanceof BaseMediaChunk;
                if ((!z || !m2766c(arrayList.size() - 1)) && chunkSource.shouldCancelLoad(j, chunk, list)) {
                    loader.cancelLoading();
                    if (z) {
                        this.f11170u = (BaseMediaChunk) chunk;
                        return;
                    }
                    return;
                }
                return;
            }
            int preferredQueueSize = chunkSource.getPreferredQueueSize(j, list);
            if (preferredQueueSize < arrayList.size()) {
                Assertions.checkState(!loader.isLoading());
                int size = arrayList.size();
                while (true) {
                    if (preferredQueueSize < size) {
                        if (!m2766c(preferredQueueSize)) {
                            break;
                        } else {
                            preferredQueueSize++;
                        }
                    } else {
                        preferredQueueSize = -1;
                        break;
                    }
                }
                if (preferredQueueSize != -1) {
                    long j2 = m2765b().endTimeUs;
                    BaseMediaChunk m2764a = m2764a(preferredQueueSize);
                    if (arrayList.isEmpty()) {
                        this.f11167r = this.f11168s;
                    }
                    this.f11171v = false;
                    this.f11155f.upstreamDiscarded(this.primaryTrackType, m2764a.startTimeUs, j2);
                }
            }
        }
    }

    public void release() {
        release(null);
    }

    public void seekToUs(long j) {
        ArrayList arrayList;
        BaseMediaChunk baseMediaChunk;
        boolean z;
        boolean seekTo;
        this.f11168s = j;
        if (m2767d()) {
            this.f11167r = j;
            return;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            arrayList = this.f11159j;
            if (i2 >= arrayList.size()) {
                break;
            }
            baseMediaChunk = (BaseMediaChunk) arrayList.get(i2);
            long j2 = baseMediaChunk.startTimeUs;
            if (j2 == j && baseMediaChunk.clippedStartTimeUs == C0643C.TIME_UNSET) {
                break;
            } else if (j2 > j) {
                break;
            } else {
                i2++;
            }
        }
        baseMediaChunk = null;
        SampleQueue sampleQueue = this.f11161l;
        if (baseMediaChunk != null) {
            seekTo = sampleQueue.seekTo(baseMediaChunk.getFirstSampleIndex(0));
        } else {
            if (j < getNextLoadPositionUs()) {
                z = true;
            } else {
                z = false;
            }
            seekTo = sampleQueue.seekTo(j, z);
        }
        SampleQueue[] sampleQueueArr = this.f11162m;
        if (seekTo) {
            this.f11169t = m2769f(sampleQueue.getReadIndex(), 0);
            int length = sampleQueueArr.length;
            while (i < length) {
                sampleQueueArr[i].seekTo(j, true);
                i++;
            }
            return;
        }
        this.f11167r = j;
        this.f11171v = false;
        arrayList.clear();
        this.f11169t = 0;
        Loader loader = this.f11157h;
        if (loader.isLoading()) {
            sampleQueue.discardToEnd();
            int length2 = sampleQueueArr.length;
            while (i < length2) {
                sampleQueueArr[i].discardToEnd();
                i++;
            }
            loader.cancelLoading();
            return;
        }
        loader.clearFatalError();
        sampleQueue.reset();
        int length3 = sampleQueueArr.length;
        while (i < length3) {
            sampleQueueArr[i].reset();
            i++;
        }
    }

    public ChunkSampleStream<T>.EmbeddedSampleStream selectEmbeddedTrack(long j, int i) {
        int i2 = 0;
        while (true) {
            SampleQueue[] sampleQueueArr = this.f11162m;
            if (i2 < sampleQueueArr.length) {
                if (this.f11150a[i2] == i) {
                    boolean[] zArr = this.f11152c;
                    Assertions.checkState(!zArr[i2]);
                    zArr[i2] = true;
                    sampleQueueArr[i2].seekTo(j, true);
                    return new EmbeddedSampleStream(this, sampleQueueArr[i2], i2);
                }
                i2++;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long j) {
        if (m2767d()) {
            return 0;
        }
        boolean z = this.f11171v;
        SampleQueue sampleQueue = this.f11161l;
        int skipCount = sampleQueue.getSkipCount(j, z);
        BaseMediaChunk baseMediaChunk = this.f11170u;
        if (baseMediaChunk != null) {
            skipCount = Math.min(skipCount, baseMediaChunk.getFirstSampleIndex(0) - sampleQueue.getReadIndex());
        }
        sampleQueue.skip(skipCount);
        m2768e();
        return skipCount;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(Chunk chunk, long j, long j2, boolean z) {
        this.f11164o = null;
        this.f11170u = null;
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.loadTaskId, chunk.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), j, j2, chunk.bytesLoaded());
        this.f11156g.onLoadTaskConcluded(chunk.loadTaskId);
        this.f11155f.loadCanceled(loadEventInfo, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs);
        if (z) {
            return;
        }
        if (m2767d()) {
            this.f11161l.reset();
            for (SampleQueue sampleQueue : this.f11162m) {
                sampleQueue.reset();
            }
        } else if (chunk instanceof BaseMediaChunk) {
            ArrayList arrayList = this.f11159j;
            m2764a(arrayList.size() - 1);
            if (arrayList.isEmpty()) {
                this.f11167r = this.f11168s;
            }
        }
        this.f11154e.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(Chunk chunk, long j, long j2) {
        this.f11164o = null;
        this.f11153d.onChunkLoadCompleted(chunk);
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.loadTaskId, chunk.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), j, j2, chunk.bytesLoaded());
        this.f11156g.onLoadTaskConcluded(chunk.loadTaskId);
        this.f11155f.loadCompleted(loadEventInfo, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs);
        this.f11154e.onContinueLoadingRequested(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ee  */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Loader.LoadErrorAction onLoadError(Chunk chunk, long j, long j2, IOException iOException, int i) {
        Loader.LoadErrorAction loadErrorAction;
        boolean isRetry;
        long bytesLoaded = chunk.bytesLoaded();
        boolean z = chunk instanceof BaseMediaChunk;
        ArrayList arrayList = this.f11159j;
        int size = arrayList.size() - 1;
        boolean z2 = (bytesLoaded != 0 && z && m2766c(size)) ? false : true;
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.loadTaskId, chunk.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), j, j2, bytesLoaded);
        LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, Util.usToMs(chunk.startTimeUs), Util.usToMs(chunk.endTimeUs)), iOException, i);
        ChunkSource chunkSource = this.f11153d;
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f11156g;
        if (chunkSource.onChunkLoadError(chunk, z2, loadErrorInfo, loadErrorHandlingPolicy)) {
            if (z2) {
                loadErrorAction = Loader.DONT_RETRY;
                if (z) {
                    Assertions.checkState(m2764a(size) == chunk);
                    if (arrayList.isEmpty()) {
                        this.f11167r = this.f11168s;
                    }
                }
                if (loadErrorAction == null) {
                    long retryDelayMsFor = loadErrorHandlingPolicy.getRetryDelayMsFor(loadErrorInfo);
                    if (retryDelayMsFor != C0643C.TIME_UNSET) {
                        loadErrorAction = Loader.createRetryAction(false, retryDelayMsFor);
                    } else {
                        loadErrorAction = Loader.DONT_RETRY_FATAL;
                    }
                }
                isRetry = loadErrorAction.isRetry();
                this.f11155f.loadError(loadEventInfo, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, iOException, !isRetry);
                if (!isRetry) {
                    this.f11164o = null;
                    loadErrorHandlingPolicy.onLoadTaskConcluded(chunk.loadTaskId);
                    this.f11154e.onContinueLoadingRequested(this);
                }
                return loadErrorAction;
            }
            Log.m3027w("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
        }
        loadErrorAction = null;
        if (loadErrorAction == null) {
        }
        isRetry = loadErrorAction.isRetry();
        this.f11155f.loadError(loadEventInfo, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, iOException, !isRetry);
        if (!isRetry) {
        }
        return loadErrorAction;
    }

    public void release(@Nullable ReleaseCallback<T> releaseCallback) {
        this.f11166q = releaseCallback;
        this.f11161l.preRelease();
        for (SampleQueue sampleQueue : this.f11162m) {
            sampleQueue.preRelease();
        }
        this.f11157h.release(this);
    }
}
