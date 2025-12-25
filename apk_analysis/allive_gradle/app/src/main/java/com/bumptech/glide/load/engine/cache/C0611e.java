package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.cache.e */
/* loaded from: classes.dex */
public final class C0611e implements DiskLruCacheFactory.CacheDirectoryGetter {

    /* renamed from: a */
    public final /* synthetic */ Context f8747a;

    /* renamed from: b */
    public final /* synthetic */ String f8748b;

    public C0611e(Context context, String str) {
        this.f8747a = context;
        this.f8748b = str;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
    public final File getCacheDirectory() {
        File cacheDir = this.f8747a.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = this.f8748b;
        if (str != null) {
            return new File(cacheDir, str);
        }
        return cacheDir;
    }
}
