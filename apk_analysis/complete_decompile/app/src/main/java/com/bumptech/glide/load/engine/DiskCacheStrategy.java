package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import p000.s40;

/* loaded from: classes.dex */
public abstract class DiskCacheStrategy {
    public static final DiskCacheStrategy ALL = new s40(0);
    public static final DiskCacheStrategy NONE = new s40(1);
    public static final DiskCacheStrategy DATA = new s40(2);
    public static final DiskCacheStrategy RESOURCE = new s40(3);
    public static final DiskCacheStrategy AUTOMATIC = new s40(4);

    public abstract boolean decodeCachedData();

    public abstract boolean decodeCachedResource();

    public abstract boolean isDataCacheable(DataSource dataSource);

    public abstract boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy);
}
