package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import p000.td1;
import p000.yd1;

@GwtCompatible
/* loaded from: classes.dex */
public abstract class AbstractCache<K, V> implements Cache<K, V> {

    /* loaded from: classes.dex */
    public static final class SimpleStatsCounter implements StatsCounter {

        /* renamed from: a */
        public final td1 f14515a = yd1.m8266a();

        /* renamed from: b */
        public final td1 f14516b = yd1.m8266a();

        /* renamed from: c */
        public final td1 f14517c = yd1.m8266a();

        /* renamed from: d */
        public final td1 f14518d = yd1.m8266a();

        /* renamed from: e */
        public final td1 f14519e = yd1.m8266a();

        /* renamed from: f */
        public final td1 f14520f = yd1.m8266a();

        /* renamed from: a */
        public static long m3788a(long j) {
            if (j >= 0) {
                return j;
            }
            return Long.MAX_VALUE;
        }

        public void incrementBy(StatsCounter statsCounter) {
            CacheStats snapshot = statsCounter.snapshot();
            this.f14515a.mo80c(snapshot.hitCount());
            this.f14516b.mo80c(snapshot.missCount());
            this.f14517c.mo80c(snapshot.loadSuccessCount());
            this.f14518d.mo80c(snapshot.loadExceptionCount());
            this.f14519e.mo80c(snapshot.totalLoadTime());
            this.f14520f.mo80c(snapshot.evictionCount());
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordEviction() {
            this.f14520f.mo78a();
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordHits(int i) {
            this.f14515a.mo80c(i);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadException(long j) {
            this.f14518d.mo78a();
            this.f14519e.mo80c(j);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadSuccess(long j) {
            this.f14517c.mo78a();
            this.f14519e.mo80c(j);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordMisses(int i) {
            this.f14516b.mo80c(i);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public CacheStats snapshot() {
            return new CacheStats(m3788a(this.f14515a.mo79b()), m3788a(this.f14516b.mo79b()), m3788a(this.f14517c.mo79b()), m3788a(this.f14518d.mo79b()), m3788a(this.f14519e.mo79b()), m3788a(this.f14520f.mo79b()));
        }
    }

    /* loaded from: classes.dex */
    public interface StatsCounter {
        void recordEviction();

        void recordHits(int i);

        void recordLoadException(long j);

        void recordLoadSuccess(long j);

        void recordMisses(int i);

        CacheStats snapshot();
    }

    @Override // com.google.common.cache.Cache
    public ConcurrentMap<K, V> asMap() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void cleanUp() {
    }

    @Override // com.google.common.cache.Cache
    public V get(K k, Callable<? extends V> callable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public ImmutableMap<K, V> getAllPresent(Iterable<? extends Object> iterable) {
        V ifPresent;
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        for (Object obj : iterable) {
            if (!newLinkedHashMap.containsKey(obj) && (ifPresent = getIfPresent(obj)) != null) {
                newLinkedHashMap.put(obj, ifPresent);
            }
        }
        return ImmutableMap.copyOf((Map) newLinkedHashMap);
    }

    @Override // com.google.common.cache.Cache
    public void invalidate(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll(Iterable<? extends Object> iterable) {
        Iterator<? extends Object> it = iterable.iterator();
        while (it.hasNext()) {
            invalidate(it.next());
        }
    }

    @Override // com.google.common.cache.Cache
    public void put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.cache.Cache
    public long size() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public CacheStats stats() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll() {
        throw new UnsupportedOperationException();
    }
}
