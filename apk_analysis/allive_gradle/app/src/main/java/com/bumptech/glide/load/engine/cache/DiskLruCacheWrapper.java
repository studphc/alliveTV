package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import p000.C1540m9;
import p000.b01;
import p000.t40;

/* loaded from: classes.dex */
public class DiskLruCacheWrapper implements DiskCache {

    /* renamed from: f */
    public static DiskLruCacheWrapper f8718f;

    /* renamed from: b */
    public final File f8720b;

    /* renamed from: c */
    public final long f8721c;

    /* renamed from: e */
    public DiskLruCache f8723e;

    /* renamed from: d */
    public final C1540m9 f8722d = new C1540m9(8);

    /* renamed from: a */
    public final SafeKeyGenerator f8719a = new SafeKeyGenerator();

    @Deprecated
    public DiskLruCacheWrapper(File file, long j) {
        this.f8720b = file;
        this.f8721c = j;
    }

    public static DiskCache create(File file, long j) {
        return new DiskLruCacheWrapper(file, j);
    }

    @Deprecated
    public static synchronized DiskCache get(File file, long j) {
        DiskLruCacheWrapper diskLruCacheWrapper;
        synchronized (DiskLruCacheWrapper.class) {
            try {
                if (f8718f == null) {
                    f8718f = new DiskLruCacheWrapper(file, j);
                }
                diskLruCacheWrapper = f8718f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return diskLruCacheWrapper;
    }

    /* renamed from: a */
    public final synchronized DiskLruCache m2332a() {
        try {
            if (this.f8723e == null) {
                this.f8723e = DiskLruCache.open(this.f8720b, 1, 1, this.f8721c);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f8723e;
    }

    /* renamed from: b */
    public final synchronized void m2333b() {
        this.f8723e = null;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public synchronized void clear() {
        try {
            try {
                m2332a().delete();
            } catch (IOException e) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to clear disk cache or disk cache cleared externally", e);
                }
            }
        } finally {
            m2333b();
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(Key key) {
        try {
            m2332a().remove(this.f8719a.getSafeKey(key));
        } catch (IOException e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", e);
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void put(Key key, DiskCache.Writer writer) {
        t40 t40Var;
        DiskLruCache m2332a;
        String safeKey = this.f8719a.getSafeKey(key);
        C1540m9 c1540m9 = this.f8722d;
        synchronized (c1540m9) {
            try {
                t40Var = (t40) ((HashMap) c1540m9.f22854b).get(safeKey);
                if (t40Var == null) {
                    t40Var = ((b01) c1540m9.f22855c).m1998o();
                    ((HashMap) c1540m9.f22854b).put(safeKey, t40Var);
                }
                t40Var.f26689b++;
            } finally {
            }
        }
        t40Var.f26688a.lock();
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + safeKey + " for for Key: " + key);
            }
            try {
                m2332a = m2332a();
            } catch (IOException e) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
            }
            if (m2332a.get(safeKey) != null) {
                return;
            }
            DiskLruCache.Editor edit = m2332a.edit(safeKey);
            if (edit != null) {
                try {
                    if (writer.write(edit.getFile(0))) {
                        edit.commit();
                    }
                    edit.abortUnlessCommitted();
                    return;
                } catch (Throwable th) {
                    edit.abortUnlessCommitted();
                    throw th;
                }
            }
            throw new IllegalStateException("Had two simultaneous puts for: " + safeKey);
        } finally {
            this.f8722d.m6102l(safeKey);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public File get(Key key) {
        String safeKey = this.f8719a.getSafeKey(key);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + safeKey + " for for Key: " + key);
        }
        try {
            DiskLruCache.Value value = m2332a().get(safeKey);
            if (value != null) {
                return value.getFile(0);
            }
            return null;
        } catch (IOException e) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            return null;
        }
    }
}
