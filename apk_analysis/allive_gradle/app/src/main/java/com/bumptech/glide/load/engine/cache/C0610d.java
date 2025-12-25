package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.cache.d */
/* loaded from: classes.dex */
public final class C0610d implements DiskLruCacheFactory.CacheDirectoryGetter {

    /* renamed from: a */
    public final /* synthetic */ Context f8745a;

    /* renamed from: b */
    public final /* synthetic */ String f8746b;

    public C0610d(Context context, String str) {
        this.f8745a = context;
        this.f8746b = str;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
    public final File getCacheDirectory() {
        Context context = this.f8745a;
        File cacheDir = context.getCacheDir();
        String str = this.f8746b;
        if (cacheDir == null) {
            cacheDir = null;
        } else if (str != null) {
            cacheDir = new File(cacheDir, str);
        }
        if (cacheDir != null && cacheDir.exists()) {
            return cacheDir;
        }
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null && externalCacheDir.canWrite()) {
            if (str != null) {
                return new File(externalCacheDir, str);
            }
            return externalCacheDir;
        }
        return cacheDir;
    }
}
