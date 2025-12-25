package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.AbstractCache;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import p000.nb1;
import p000.ob1;

/* renamed from: com.google.common.cache.c */
/* loaded from: classes.dex */
public class C0838c implements Cache, Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    public final ConcurrentMapC0840e f14569a;

    public C0838c(ConcurrentMapC0840e concurrentMapC0840e) {
        this.f14569a = concurrentMapC0840e;
    }

    @Override // com.google.common.cache.Cache
    public final ConcurrentMap asMap() {
        return this.f14569a;
    }

    @Override // com.google.common.cache.Cache
    public final void cleanUp() {
        for (C0839d c0839d : this.f14569a.f14589c) {
            c0839d.m3816v(c0839d.f14570a.f14602p.read());
            c0839d.m3817w();
        }
    }

    @Override // com.google.common.cache.Cache
    public final Object get(Object obj, Callable callable) {
        Preconditions.checkNotNull(callable);
        return this.f14569a.m3825g(obj, new nb1(callable));
    }

    @Override // com.google.common.cache.Cache
    public final ImmutableMap getAllPresent(Iterable iterable) {
        ConcurrentMapC0840e concurrentMapC0840e = this.f14569a;
        concurrentMapC0840e.getClass();
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int i = 0;
        int i2 = 0;
        for (Object obj : iterable) {
            Object obj2 = concurrentMapC0840e.get(obj);
            if (obj2 == null) {
                i2++;
            } else {
                builder.put(obj, obj2);
                i++;
            }
        }
        AbstractCache.StatsCounter statsCounter = concurrentMapC0840e.f14604r;
        statsCounter.recordHits(i);
        statsCounter.recordMisses(i2);
        return builder.buildKeepingLast();
    }

    @Override // com.google.common.cache.Cache
    public final Object getIfPresent(Object obj) {
        ConcurrentMapC0840e concurrentMapC0840e = this.f14569a;
        concurrentMapC0840e.getClass();
        int m3826h = concurrentMapC0840e.m3826h(Preconditions.checkNotNull(obj));
        Object m3802h = concurrentMapC0840e.m3829k(m3826h).m3802h(obj, m3826h);
        AbstractCache.StatsCounter statsCounter = concurrentMapC0840e.f14604r;
        if (m3802h == null) {
            statsCounter.recordMisses(1);
        } else {
            statsCounter.recordHits(1);
        }
        return m3802h;
    }

    @Override // com.google.common.cache.Cache
    public final void invalidate(Object obj) {
        Preconditions.checkNotNull(obj);
        this.f14569a.remove(obj);
    }

    @Override // com.google.common.cache.Cache
    public final void invalidateAll(Iterable iterable) {
        ConcurrentMapC0840e concurrentMapC0840e = this.f14569a;
        concurrentMapC0840e.getClass();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            concurrentMapC0840e.remove(it.next());
        }
    }

    @Override // com.google.common.cache.Cache
    public final void put(Object obj, Object obj2) {
        this.f14569a.put(obj, obj2);
    }

    @Override // com.google.common.cache.Cache
    public final void putAll(Map map) {
        this.f14569a.putAll(map);
    }

    @Override // com.google.common.cache.Cache
    public final long size() {
        long j = 0;
        for (int i = 0; i < this.f14569a.f14589c.length; i++) {
            j += Math.max(0, r0[i].f14571b);
        }
        return j;
    }

    @Override // com.google.common.cache.Cache
    public final CacheStats stats() {
        AbstractCache.SimpleStatsCounter simpleStatsCounter = new AbstractCache.SimpleStatsCounter();
        ConcurrentMapC0840e concurrentMapC0840e = this.f14569a;
        simpleStatsCounter.incrementBy(concurrentMapC0840e.f14604r);
        for (C0839d c0839d : concurrentMapC0840e.f14589c) {
            simpleStatsCounter.incrementBy(c0839d.f14583n);
        }
        return simpleStatsCounter.snapshot();
    }

    public Object writeReplace() {
        return new ob1(this.f14569a);
    }

    @Override // com.google.common.cache.Cache
    public final void invalidateAll() {
        this.f14569a.clear();
    }
}
