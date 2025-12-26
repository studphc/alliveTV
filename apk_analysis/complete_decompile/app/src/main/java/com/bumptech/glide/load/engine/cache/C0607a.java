package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.cache.a */
/* loaded from: classes.dex */
public final class C0607a implements DiskLruCacheFactory.CacheDirectoryGetter {

    /* renamed from: a */
    public final /* synthetic */ String f8740a;

    public C0607a(String str) {
        this.f8740a = str;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
    public final File getCacheDirectory() {
        return new File(this.f8740a);
    }
}
