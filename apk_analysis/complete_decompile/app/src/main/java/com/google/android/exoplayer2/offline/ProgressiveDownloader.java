package com.google.android.exoplayer2.offline;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheWriter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import p000.C1294i5;
import p000.ExecutorC0582c6;

/* loaded from: classes.dex */
public final class ProgressiveDownloader implements Downloader {

    /* renamed from: a */
    public final Executor f10832a;

    /* renamed from: b */
    public final DataSpec f10833b;

    /* renamed from: c */
    public final CacheDataSource f10834c;

    /* renamed from: d */
    public final CacheWriter f10835d;

    /* renamed from: e */
    public final PriorityTaskManager f10836e;

    /* renamed from: f */
    public Downloader.ProgressListener f10837f;

    /* renamed from: g */
    public volatile C0683d f10838g;

    /* renamed from: h */
    public volatile boolean f10839h;

    public ProgressiveDownloader(MediaItem mediaItem, CacheDataSource.Factory factory) {
        this(mediaItem, factory, new ExecutorC0582c6(0));
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public void cancel() {
        this.f10839h = true;
        C0683d c0683d = this.f10838g;
        if (c0683d != null) {
            c0683d.cancel(true);
        }
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public void download(@Nullable Downloader.ProgressListener progressListener) {
        this.f10837f = progressListener;
        this.f10838g = new C0683d(this);
        PriorityTaskManager priorityTaskManager = this.f10836e;
        if (priorityTaskManager != null) {
            priorityTaskManager.add(-1000);
        }
        boolean z = false;
        while (!z) {
            try {
                if (this.f10839h) {
                    break;
                }
                PriorityTaskManager priorityTaskManager2 = this.f10836e;
                if (priorityTaskManager2 != null) {
                    priorityTaskManager2.proceed(-1000);
                }
                this.f10832a.execute(this.f10838g);
                try {
                    this.f10838g.get();
                    z = true;
                } catch (ExecutionException e) {
                    Throwable th = (Throwable) Assertions.checkNotNull(e.getCause());
                    if (!(th instanceof PriorityTaskManager.PriorityTooLowException)) {
                        if (!(th instanceof IOException)) {
                            Util.sneakyThrow(th);
                        } else {
                            throw ((IOException) th);
                        }
                    }
                }
            } catch (Throwable th2) {
                this.f10838g.blockUntilFinished();
                PriorityTaskManager priorityTaskManager3 = this.f10836e;
                if (priorityTaskManager3 != null) {
                    priorityTaskManager3.remove(-1000);
                }
                throw th2;
            }
        }
        this.f10838g.blockUntilFinished();
        PriorityTaskManager priorityTaskManager4 = this.f10836e;
        if (priorityTaskManager4 != null) {
            priorityTaskManager4.remove(-1000);
        }
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public void remove() {
        CacheDataSource cacheDataSource = this.f10834c;
        cacheDataSource.getCache().removeResource(cacheDataSource.getCacheKeyFactory().buildCacheKey(this.f10833b));
    }

    public ProgressiveDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, Executor executor) {
        this.f10832a = (Executor) Assertions.checkNotNull(executor);
        Assertions.checkNotNull(mediaItem.localConfiguration);
        DataSpec build = new DataSpec.Builder().setUri(mediaItem.localConfiguration.uri).setKey(mediaItem.localConfiguration.customCacheKey).setFlags(4).build();
        this.f10833b = build;
        CacheDataSource createDataSourceForDownloading = factory.createDataSourceForDownloading();
        this.f10834c = createDataSourceForDownloading;
        this.f10835d = new CacheWriter(createDataSourceForDownloading, build, null, new C1294i5(16, this));
        this.f10836e = factory.getUpstreamPriorityTaskManager();
    }
}
