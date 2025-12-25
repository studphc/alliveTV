package com.google.android.exoplayer2.upstream.cache;

import java.util.TreeSet;
import p000.C0556bg;

/* loaded from: classes.dex */
public final class LeastRecentlyUsedCacheEvictor implements CacheEvictor {

    /* renamed from: a */
    public final long f12638a;

    /* renamed from: b */
    public final TreeSet f12639b = new TreeSet(new C0556bg(13));

    /* renamed from: c */
    public long f12640c;

    public LeastRecentlyUsedCacheEvictor(long j) {
        this.f12638a = j;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public void onCacheInitialized() {
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
        TreeSet treeSet = this.f12639b;
        treeSet.add(cacheSpan);
        this.f12640c += cacheSpan.length;
        while (this.f12640c > this.f12638a && !treeSet.isEmpty()) {
            cache.removeSpan((CacheSpan) treeSet.first());
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanRemoved(Cache cache, CacheSpan cacheSpan) {
        this.f12639b.remove(cacheSpan);
        this.f12640c -= cacheSpan.length;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        onSpanRemoved(cache, cacheSpan);
        onSpanAdded(cache, cacheSpan2);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public void onStartFile(Cache cache, String str, long j, long j2) {
        if (j2 != -1) {
            while (this.f12640c + j2 > this.f12638a) {
                TreeSet treeSet = this.f12639b;
                if (!treeSet.isEmpty()) {
                    cache.removeSpan((CacheSpan) treeSet.first());
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public boolean requiresCacheSpanTouches() {
        return true;
    }
}
