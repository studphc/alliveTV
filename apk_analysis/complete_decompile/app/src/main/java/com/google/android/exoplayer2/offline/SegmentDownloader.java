package com.google.android.exoplayer2.offline;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import p000.AbstractC1997xv;
import p000.wf2;

/* loaded from: classes.dex */
public abstract class SegmentDownloader<M extends FilterableManifest<M>> implements Downloader {

    /* renamed from: a */
    public final DataSpec f10840a;

    /* renamed from: b */
    public final ParsingLoadable.Parser f10841b;

    /* renamed from: c */
    public final ArrayList f10842c;

    /* renamed from: d */
    public final CacheDataSource.Factory f10843d;

    /* renamed from: e */
    public final Cache f10844e;

    /* renamed from: f */
    public final CacheKeyFactory f10845f;

    /* renamed from: g */
    public final PriorityTaskManager f10846g;

    /* renamed from: h */
    public final Executor f10847h;

    /* renamed from: i */
    public final ArrayList f10848i;

    /* renamed from: j */
    public volatile boolean f10849j;

    /* loaded from: classes.dex */
    public static class Segment implements Comparable<Segment> {
        public final DataSpec dataSpec;
        public final long startTimeUs;

        public Segment(long j, DataSpec dataSpec) {
            this.startTimeUs = j;
            this.dataSpec = dataSpec;
        }

        @Override // java.lang.Comparable
        public int compareTo(Segment segment) {
            return Util.compareLong(this.startTimeUs, segment.startTimeUs);
        }
    }

    public SegmentDownloader(MediaItem mediaItem, ParsingLoadable.Parser<M> parser, CacheDataSource.Factory factory, Executor executor) {
        Assertions.checkNotNull(mediaItem.localConfiguration);
        this.f10840a = getCompressibleDataSpec(mediaItem.localConfiguration.uri);
        this.f10841b = parser;
        this.f10842c = new ArrayList(mediaItem.localConfiguration.streamKeys);
        this.f10843d = factory;
        this.f10847h = executor;
        this.f10844e = (Cache) Assertions.checkNotNull(factory.getCache());
        this.f10845f = factory.getCacheKeyFactory();
        this.f10846g = factory.getUpstreamPriorityTaskManager();
        this.f10848i = new ArrayList();
    }

    /* renamed from: b */
    public static void m2716b(List list, CacheKeyFactory cacheKeyFactory) {
        Segment segment;
        long j;
        HashMap hashMap = new HashMap();
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Segment segment2 = (Segment) list.get(i2);
            String buildCacheKey = cacheKeyFactory.buildCacheKey(segment2.dataSpec);
            Integer num = (Integer) hashMap.get(buildCacheKey);
            if (num == null) {
                segment = null;
            } else {
                segment = (Segment) list.get(num.intValue());
            }
            if (segment != null && segment2.startTimeUs <= segment.startTimeUs + 20000000) {
                DataSpec dataSpec = segment.dataSpec;
                DataSpec dataSpec2 = segment2.dataSpec;
                if (dataSpec.uri.equals(dataSpec2.uri)) {
                    long j2 = dataSpec.length;
                    if (j2 != -1 && dataSpec.position + j2 == dataSpec2.position && Util.areEqual(dataSpec.key, dataSpec2.key) && dataSpec.flags == dataSpec2.flags && dataSpec.httpMethod == dataSpec2.httpMethod && dataSpec.httpRequestHeaders.equals(dataSpec2.httpRequestHeaders)) {
                        long j3 = segment2.dataSpec.length;
                        if (j3 == -1) {
                            j = -1;
                        } else {
                            j = segment.dataSpec.length + j3;
                        }
                        list.set(((Integer) Assertions.checkNotNull(num)).intValue(), new Segment(segment.startTimeUs, segment.dataSpec.subrange(0L, j)));
                    }
                }
            }
            hashMap.put(buildCacheKey, Integer.valueOf(i));
            list.set(i, segment2);
            i++;
        }
        Util.removeRange(list, i, list.size());
    }

    public static DataSpec getCompressibleDataSpec(Uri uri) {
        return new DataSpec.Builder().setUri(uri).setFlags(1).build();
    }

    /* renamed from: a */
    public final void m2717a(RunnableFutureTask runnableFutureTask) {
        synchronized (this.f10848i) {
            try {
                if (!this.f10849j) {
                    this.f10848i.add(runnableFutureTask);
                } else {
                    throw new InterruptedException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: c */
    public final void m2718c(int i) {
        synchronized (this.f10848i) {
            this.f10848i.remove(i);
        }
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public void cancel() {
        synchronized (this.f10848i) {
            try {
                this.f10849j = true;
                for (int i = 0; i < this.f10848i.size(); i++) {
                    ((RunnableFutureTask) this.f10848i.get(i)).cancel(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: d */
    public final void m2719d(RunnableFutureTask runnableFutureTask) {
        synchronized (this.f10848i) {
            this.f10848i.remove(runnableFutureTask);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01ad A[LOOP:1: B:37:0x01a5->B:39:0x01ad, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01c6 A[LOOP:2: B:42:0x01c4->B:43:0x01c6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01db  */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.exoplayer2.offline.SegmentDownloader] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.google.android.exoplayer2.offline.SegmentDownloader] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v28 */
    @Override // com.google.android.exoplayer2.offline.Downloader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void download(@Nullable Downloader.ProgressListener progressListener) {
        SegmentDownloader<M> segmentDownloader;
        int i;
        int size;
        PriorityTaskManager priorityTaskManager;
        C0684e c0684e;
        CacheDataSource createDataSourceForDownloading;
        byte[] bArr;
        ?? r1 = this;
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayDeque arrayDeque2 = new ArrayDeque();
        PriorityTaskManager priorityTaskManager2 = r1.f10846g;
        if (priorityTaskManager2 != null) {
            priorityTaskManager2.add(-1000);
        }
        try {
            CacheDataSource createDataSourceForDownloading2 = r1.f10843d.createDataSourceForDownloading();
            FilterableManifest manifest = r1.getManifest(createDataSourceForDownloading2, r1.f10840a, false);
            if (!r1.f10842c.isEmpty()) {
                manifest = (FilterableManifest) manifest.copy(r1.f10842c);
            }
            List<Segment> segments = r1.getSegments(createDataSourceForDownloading2, manifest, false);
            Collections.sort(segments);
            m2716b(segments, r1.f10845f);
            int size2 = segments.size();
            int size3 = segments.size() - 1;
            int i2 = 0;
            long j = 0;
            long j2 = 0;
            r1 = r1;
            while (size3 >= 0) {
                try {
                    DataSpec dataSpec = segments.get(size3).dataSpec;
                    String buildCacheKey = r1.f10845f.buildCacheKey(dataSpec);
                    long j3 = dataSpec.length;
                    if (j3 == -1) {
                        long m8193a = AbstractC1997xv.m8193a(r1.f10844e.getContentMetadata(buildCacheKey));
                        if (m8193a != -1) {
                            j3 = m8193a - dataSpec.position;
                        }
                    }
                    ArrayDeque arrayDeque3 = arrayDeque;
                    long cachedBytes = r1.f10844e.getCachedBytes(buildCacheKey, dataSpec.position, j3);
                    j2 += cachedBytes;
                    if (j3 != -1) {
                        if (j3 == cachedBytes) {
                            i2++;
                            segments.remove(size3);
                        }
                        if (j != -1) {
                            j += j3;
                        }
                    } else {
                        j = -1;
                    }
                    size3--;
                    r1 = this;
                    arrayDeque = arrayDeque3;
                } catch (Throwable th) {
                    th = th;
                    segmentDownloader = this;
                    for (i = 0; i < segmentDownloader.f10848i.size(); i++) {
                        ((RunnableFutureTask) segmentDownloader.f10848i.get(i)).cancel(true);
                    }
                    for (size = segmentDownloader.f10848i.size() - 1; size >= 0; size--) {
                        ((RunnableFutureTask) segmentDownloader.f10848i.get(size)).blockUntilFinished();
                        segmentDownloader.m2718c(size);
                    }
                    priorityTaskManager = segmentDownloader.f10846g;
                    if (priorityTaskManager != null) {
                        priorityTaskManager.remove(-1000);
                    }
                    throw th;
                }
            }
            ArrayDeque arrayDeque4 = arrayDeque;
            if (progressListener != null) {
                c0684e = new C0684e(progressListener, j, size2, j2, i2);
            } else {
                c0684e = null;
            }
            arrayDeque4.addAll(segments);
            segmentDownloader = this;
            while (!segmentDownloader.f10849j && !arrayDeque4.isEmpty()) {
                try {
                    PriorityTaskManager priorityTaskManager3 = segmentDownloader.f10846g;
                    if (priorityTaskManager3 != null) {
                        priorityTaskManager3.proceed(-1000);
                    }
                    if (!arrayDeque2.isEmpty()) {
                        C0685f c0685f = (C0685f) arrayDeque2.removeFirst();
                        createDataSourceForDownloading = c0685f.f10883i;
                        bArr = c0685f.f10885k;
                    } else {
                        createDataSourceForDownloading = segmentDownloader.f10843d.createDataSourceForDownloading();
                        bArr = new byte[131072];
                    }
                    C0685f c0685f2 = new C0685f((Segment) arrayDeque4.removeFirst(), createDataSourceForDownloading, c0684e, bArr);
                    segmentDownloader.m2717a(c0685f2);
                    segmentDownloader.f10847h.execute(c0685f2);
                    for (int size4 = segmentDownloader.f10848i.size() - 1; size4 >= 0; size4--) {
                        C0685f c0685f3 = (C0685f) segmentDownloader.f10848i.get(size4);
                        if (arrayDeque4.isEmpty() || c0685f3.isDone()) {
                            try {
                                c0685f3.get();
                                segmentDownloader.m2718c(size4);
                                arrayDeque2.addLast(c0685f3);
                            } catch (ExecutionException e) {
                                Throwable th2 = (Throwable) Assertions.checkNotNull(e.getCause());
                                if (th2 instanceof PriorityTaskManager.PriorityTooLowException) {
                                    arrayDeque4.addFirst(c0685f3.f10882h);
                                    segmentDownloader.m2718c(size4);
                                    arrayDeque2.addLast(c0685f3);
                                } else if (!(th2 instanceof IOException)) {
                                    Util.sneakyThrow(th2);
                                } else {
                                    throw ((IOException) th2);
                                }
                            }
                        }
                    }
                    c0685f2.blockUntilStarted();
                } catch (Throwable th3) {
                    th = th3;
                    while (i < segmentDownloader.f10848i.size()) {
                    }
                    while (size >= 0) {
                    }
                    priorityTaskManager = segmentDownloader.f10846g;
                    if (priorityTaskManager != null) {
                    }
                    throw th;
                }
            }
            for (int i3 = 0; i3 < segmentDownloader.f10848i.size(); i3++) {
                ((RunnableFutureTask) segmentDownloader.f10848i.get(i3)).cancel(true);
            }
            for (int size5 = segmentDownloader.f10848i.size() - 1; size5 >= 0; size5--) {
                ((RunnableFutureTask) segmentDownloader.f10848i.get(size5)).blockUntilFinished();
                segmentDownloader.m2718c(size5);
            }
            PriorityTaskManager priorityTaskManager4 = segmentDownloader.f10846g;
            if (priorityTaskManager4 != null) {
                priorityTaskManager4.remove(-1000);
            }
        } catch (Throwable th4) {
            th = th4;
            segmentDownloader = r1;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(5:27|28|29|(2:34|(2:36|37)(3:38|39|40))(2:31|32)|33) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0042, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0043, code lost:
    
        r0 = (java.lang.Throwable) com.google.android.exoplayer2.util.Assertions.checkNotNull(r4.getCause());
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004f, code lost:
    
        if ((r0 instanceof com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0054, code lost:
    
        if ((r0 instanceof java.io.IOException) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0056, code lost:
    
        com.google.android.exoplayer2.util.Util.sneakyThrow(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0062, code lost:
    
        throw ((java.io.IOException) r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0040, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0063, code lost:
    
        r3.blockUntilFinished();
        m2719d(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0069, code lost:
    
        throw r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> T execute(RunnableFutureTask<T, ?> runnableFutureTask, boolean z) {
        if (z) {
            runnableFutureTask.run();
            try {
                return runnableFutureTask.get();
            } catch (ExecutionException e) {
                Throwable th = (Throwable) Assertions.checkNotNull(e.getCause());
                if (!(th instanceof IOException)) {
                    Util.sneakyThrow(e);
                } else {
                    throw ((IOException) th);
                }
            }
        }
        while (!this.f10849j) {
            PriorityTaskManager priorityTaskManager = this.f10846g;
            if (priorityTaskManager != null) {
                priorityTaskManager.proceed(-1000);
            }
            m2717a(runnableFutureTask);
            this.f10847h.execute(runnableFutureTask);
            return runnableFutureTask.get();
        }
        throw new InterruptedException();
    }

    public final M getManifest(DataSource dataSource, DataSpec dataSpec, boolean z) {
        return (M) execute(new wf2(this, dataSource, dataSpec), z);
    }

    public abstract List<Segment> getSegments(DataSource dataSource, M m, boolean z);

    @Override // com.google.android.exoplayer2.offline.Downloader
    public final void remove() {
        CacheKeyFactory cacheKeyFactory = this.f10845f;
        Cache cache = this.f10844e;
        DataSpec dataSpec = this.f10840a;
        CacheDataSource createDataSourceForRemovingDownload = this.f10843d.createDataSourceForRemovingDownload();
        try {
            try {
                List<Segment> segments = getSegments(createDataSourceForRemovingDownload, getManifest(createDataSourceForRemovingDownload, dataSpec, true), true);
                for (int i = 0; i < segments.size(); i++) {
                    cache.removeResource(cacheKeyFactory.buildCacheKey(segments.get(i).dataSpec));
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (Exception unused2) {
            }
        } finally {
            cache.removeResource(cacheKeyFactory.buildCacheKey(dataSpec));
        }
    }
}
