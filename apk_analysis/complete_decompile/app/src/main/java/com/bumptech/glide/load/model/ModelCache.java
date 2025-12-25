package com.bumptech.glide.load.model;

import androidx.annotation.Nullable;
import com.bumptech.glide.util.LruCache;
import java.util.Queue;
import p000.ko1;
import p000.lo1;

/* loaded from: classes.dex */
public class ModelCache<A, B> {

    /* renamed from: a */
    public final ko1 f8799a;

    public ModelCache() {
        this(250L);
    }

    public void clear() {
        this.f8799a.clearMemory();
    }

    @Nullable
    public B get(A a, int i, int i2) {
        lo1 m5962a = lo1.m5962a(i, i2, a);
        B b = (B) this.f8799a.get(m5962a);
        Queue queue = lo1.f22596d;
        synchronized (queue) {
            queue.offer(m5962a);
        }
        return b;
    }

    public void put(A a, int i, int i2, B b) {
        this.f8799a.put(lo1.m5962a(i, i2, a), b);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bumptech.glide.util.LruCache, ko1] */
    public ModelCache(long j) {
        this.f8799a = new LruCache(j);
    }
}
