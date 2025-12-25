package com.google.common.cache;

import com.google.common.cache.AbstractCache;

/* renamed from: com.google.common.cache.a */
/* loaded from: classes.dex */
public final class C0836a implements AbstractCache.StatsCounter {
    @Override // com.google.common.cache.AbstractCache.StatsCounter
    public final void recordEviction() {
    }

    @Override // com.google.common.cache.AbstractCache.StatsCounter
    public final void recordHits(int i) {
    }

    @Override // com.google.common.cache.AbstractCache.StatsCounter
    public final void recordLoadException(long j) {
    }

    @Override // com.google.common.cache.AbstractCache.StatsCounter
    public final void recordLoadSuccess(long j) {
    }

    @Override // com.google.common.cache.AbstractCache.StatsCounter
    public final void recordMisses(int i) {
    }

    @Override // com.google.common.cache.AbstractCache.StatsCounter
    public final CacheStats snapshot() {
        return CacheBuilder.f14522r;
    }
}
