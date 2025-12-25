package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.cache.b */
/* loaded from: classes.dex */
public final class C0608b implements DiskLruCacheFactory.CacheDirectoryGetter {

    /* renamed from: a */
    public final /* synthetic */ String f8741a;

    /* renamed from: b */
    public final /* synthetic */ String f8742b;

    public C0608b(String str, String str2) {
        this.f8741a = str;
        this.f8742b = str2;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
    public final File getCacheDirectory() {
        return new File(this.f8741a, this.f8742b);
    }
}
