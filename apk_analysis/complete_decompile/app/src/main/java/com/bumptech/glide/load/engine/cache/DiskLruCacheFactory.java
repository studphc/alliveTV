package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* loaded from: classes.dex */
public class DiskLruCacheFactory implements DiskCache.Factory {

    /* renamed from: a */
    public final long f8716a;

    /* renamed from: b */
    public final CacheDirectoryGetter f8717b;

    /* loaded from: classes.dex */
    public interface CacheDirectoryGetter {
        File getCacheDirectory();
    }

    public DiskLruCacheFactory(String str, long j) {
        this(new C0607a(str), j);
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
    public DiskCache build() {
        File cacheDirectory = this.f8717b.getCacheDirectory();
        if (cacheDirectory == null) {
            return null;
        }
        if (!cacheDirectory.isDirectory() && !cacheDirectory.mkdirs()) {
            return null;
        }
        return DiskLruCacheWrapper.create(cacheDirectory, this.f8716a);
    }

    public DiskLruCacheFactory(String str, String str2, long j) {
        this(new C0608b(str, str2), j);
    }

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter, long j) {
        this.f8716a = j;
        this.f8717b = cacheDirectoryGetter;
    }
}
