package com.bumptech.glide.load.engine.cache;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import p000.yd2;

/* loaded from: classes.dex */
public class SafeKeyGenerator {

    /* renamed from: a */
    public final LruCache f8738a = new LruCache(1000);

    /* renamed from: b */
    public final Pools.Pool f8739b = FactoryPools.threadSafe(10, new Object());

    public String getSafeKey(Key key) {
        String str;
        synchronized (this.f8738a) {
            str = (String) this.f8738a.get(key);
        }
        if (str == null) {
            Pools.Pool pool = this.f8739b;
            yd2 yd2Var = (yd2) Preconditions.checkNotNull(pool.acquire());
            try {
                key.updateDiskCacheKey(yd2Var.f28911a);
                String sha256BytesToHex = Util.sha256BytesToHex(yd2Var.f28911a.digest());
                pool.release(yd2Var);
                str = sha256BytesToHex;
            } catch (Throwable th) {
                pool.release(yd2Var);
                throw th;
            }
        }
        synchronized (this.f8738a) {
            this.f8738a.put(key, str);
        }
        return str;
    }
}
