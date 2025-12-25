package com.google.android.exoplayer2.offline;

import android.util.SparseArray;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.dash.offline.DashDownloader;
import com.google.android.exoplayer2.source.hls.offline.HlsDownloader;
import com.google.android.exoplayer2.source.smoothstreaming.offline.SsDownloader;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
import p000.ExecutorC0582c6;
import p000.ye0;

/* loaded from: classes.dex */
public class DefaultDownloaderFactory implements DownloaderFactory {

    /* renamed from: c */
    public static final SparseArray f10777c;

    /* renamed from: a */
    public final CacheDataSource.Factory f10778a;

    /* renamed from: b */
    public final Executor f10779b;

    static {
        SparseArray sparseArray = new SparseArray();
        try {
            sparseArray.put(0, m2702a(DashDownloader.class));
        } catch (ClassNotFoundException unused) {
        }
        try {
            sparseArray.put(2, m2702a(HlsDownloader.class));
        } catch (ClassNotFoundException unused2) {
        }
        try {
            sparseArray.put(1, m2702a(SsDownloader.class));
        } catch (ClassNotFoundException unused3) {
        }
        f10777c = sparseArray;
    }

    @Deprecated
    public DefaultDownloaderFactory(CacheDataSource.Factory factory) {
        this(factory, new ExecutorC0582c6(0));
    }

    /* renamed from: a */
    public static Constructor m2702a(Class cls) {
        try {
            return cls.asSubclass(Downloader.class).getConstructor(MediaItem.class, CacheDataSource.Factory.class, Executor.class);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Downloader constructor missing", e);
        }
    }

    @Override // com.google.android.exoplayer2.offline.DownloaderFactory
    public Downloader createDownloader(DownloadRequest downloadRequest) {
        int inferContentTypeForUriAndMimeType = Util.inferContentTypeForUriAndMimeType(downloadRequest.uri, downloadRequest.mimeType);
        Executor executor = this.f10779b;
        CacheDataSource.Factory factory = this.f10778a;
        if (inferContentTypeForUriAndMimeType != 0 && inferContentTypeForUriAndMimeType != 1 && inferContentTypeForUriAndMimeType != 2) {
            if (inferContentTypeForUriAndMimeType == 4) {
                return new ProgressiveDownloader(new MediaItem.Builder().setUri(downloadRequest.uri).setCustomCacheKey(downloadRequest.customCacheKey).build(), factory, executor);
            }
            throw new IllegalArgumentException(ye0.m8291k(inferContentTypeForUriAndMimeType, "Unsupported type: "));
        }
        Constructor constructor = (Constructor) f10777c.get(inferContentTypeForUriAndMimeType);
        if (constructor != null) {
            try {
                return (Downloader) constructor.newInstance(new MediaItem.Builder().setUri(downloadRequest.uri).setStreamKeys(downloadRequest.streamKeys).setCustomCacheKey(downloadRequest.customCacheKey).build(), factory, executor);
            } catch (Exception unused) {
                throw new IllegalStateException(ye0.m8291k(inferContentTypeForUriAndMimeType, "Failed to instantiate downloader for content type "));
            }
        }
        throw new IllegalStateException(ye0.m8291k(inferContentTypeForUriAndMimeType, "Module missing for content type "));
    }

    public DefaultDownloaderFactory(CacheDataSource.Factory factory, Executor executor) {
        this.f10778a = (CacheDataSource.Factory) Assertions.checkNotNull(factory);
        this.f10779b = (Executor) Assertions.checkNotNull(executor);
    }
}
