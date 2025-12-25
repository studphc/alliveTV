package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.util.pool.FactoryPools;

/* renamed from: com.bumptech.glide.util.pool.d */
/* loaded from: classes.dex */
public final class C0642d implements Pools.Pool {

    /* renamed from: a */
    public final FactoryPools.Factory f9186a;

    /* renamed from: b */
    public final FactoryPools.Resetter f9187b;

    /* renamed from: c */
    public final Pools.SimplePool f9188c;

    public C0642d(Pools.SimplePool simplePool, FactoryPools.Factory factory, FactoryPools.Resetter resetter) {
        this.f9188c = simplePool;
        this.f9186a = factory;
        this.f9187b = resetter;
    }

    @Override // androidx.core.util.Pools.Pool
    public final Object acquire() {
        Object acquire = this.f9188c.acquire();
        if (acquire == null) {
            acquire = this.f9186a.create();
            if (Log.isLoggable("FactoryPools", 2)) {
                Log.v("FactoryPools", "Created new " + acquire.getClass());
            }
        }
        if (acquire instanceof FactoryPools.Poolable) {
            ((FactoryPools.Poolable) acquire).getVerifier().mo2400a(false);
        }
        return acquire;
    }

    @Override // androidx.core.util.Pools.Pool
    public final boolean release(Object obj) {
        if (obj instanceof FactoryPools.Poolable) {
            ((FactoryPools.Poolable) obj).getVerifier().mo2400a(true);
        }
        this.f9187b.reset(obj);
        return this.f9188c.release(obj);
    }
}
