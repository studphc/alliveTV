package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.cache.c */
/* loaded from: classes.dex */
public final class C0609c implements DiskLruCacheFactory.CacheDirectoryGetter {

    /* renamed from: a */
    public final /* synthetic */ Context f8743a;

    /* renamed from: b */
    public final /* synthetic */ String f8744b;

    public C0609c(Context context, String str) {
        this.f8743a = context;
        this.f8744b = str;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
    public final File getCacheDirectory() {
        File externalCacheDir = this.f8743a.getExternalCacheDir();
        if (externalCacheDir == null) {
            return null;
        }
        String str = this.f8744b;
        if (str != null) {
            return new File(externalCacheDir, str);
        }
        return externalCacheDir;
    }
}
