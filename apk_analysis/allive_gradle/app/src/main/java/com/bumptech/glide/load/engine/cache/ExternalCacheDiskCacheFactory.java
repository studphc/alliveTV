package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;

@Deprecated
/* loaded from: classes.dex */
public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public ExternalCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, DiskCache.Factory.DEFAULT_DISK_CACHE_SIZE);
    }

    public ExternalCacheDiskCacheFactory(Context context, int i) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, i);
    }

    public ExternalCacheDiskCacheFactory(Context context, String str, int i) {
        super(new C0609c(context, str), i);
    }
}
