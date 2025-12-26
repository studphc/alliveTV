package com.bumptech.glide.disklrucache;

import com.bumptech.glide.disklrucache.DiskLruCache;
import java.io.File;

/* renamed from: com.bumptech.glide.disklrucache.a */
/* loaded from: classes.dex */
public final class C0604a {

    /* renamed from: a */
    public final String f8567a;

    /* renamed from: b */
    public final long[] f8568b;

    /* renamed from: c */
    public final File[] f8569c;

    /* renamed from: d */
    public final File[] f8570d;

    /* renamed from: e */
    public boolean f8571e;

    /* renamed from: f */
    public DiskLruCache.Editor f8572f;

    /* renamed from: g */
    public long f8573g;

    /* renamed from: h */
    public final /* synthetic */ DiskLruCache f8574h;

    public C0604a(DiskLruCache diskLruCache, String str) {
        this.f8574h = diskLruCache;
        this.f8567a = str;
        int i = diskLruCache.f8550g;
        this.f8568b = new long[i];
        this.f8569c = new File[i];
        this.f8570d = new File[i];
        StringBuilder sb = new StringBuilder(str);
        sb.append('.');
        int length = sb.length();
        for (int i2 = 0; i2 < diskLruCache.f8550g; i2++) {
            sb.append(i2);
            File[] fileArr = this.f8569c;
            String sb2 = sb.toString();
            File file = diskLruCache.f8544a;
            fileArr[i2] = new File(file, sb2);
            sb.append(".tmp");
            this.f8570d[i2] = new File(file, sb.toString());
            sb.setLength(length);
        }
    }

    /* renamed from: a */
    public final String m2299a() {
        StringBuilder sb = new StringBuilder();
        for (long j : this.f8568b) {
            sb.append(' ');
            sb.append(j);
        }
        return sb.toString();
    }
}
