package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheSpan;
import com.google.android.exoplayer2.util.Log;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;
import p000.C1690pk;

/* loaded from: classes.dex */
public final class CachedRegionTracker implements Cache.Listener {
    public static final int CACHED_TO_END = -2;
    public static final int NOT_CACHED = -1;

    /* renamed from: a */
    public final Cache f12401a;

    /* renamed from: b */
    public final String f12402b;

    /* renamed from: c */
    public final ChunkIndex f12403c;

    /* renamed from: d */
    public final TreeSet f12404d = new TreeSet();

    /* renamed from: e */
    public final C1690pk f12405e = new C1690pk(0, 0);

    public CachedRegionTracker(Cache cache, String str, ChunkIndex chunkIndex) {
        this.f12401a = cache;
        this.f12402b = str;
        this.f12403c = chunkIndex;
        synchronized (this) {
            try {
                Iterator<CacheSpan> descendingIterator = cache.addListener(str, this).descendingIterator();
                while (descendingIterator.hasNext()) {
                    m2975a(descendingIterator.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: a */
    public final void m2975a(CacheSpan cacheSpan) {
        boolean z;
        long j = cacheSpan.position;
        C1690pk c1690pk = new C1690pk(j, cacheSpan.length + j);
        TreeSet treeSet = this.f12404d;
        C1690pk c1690pk2 = (C1690pk) treeSet.floor(c1690pk);
        C1690pk c1690pk3 = (C1690pk) treeSet.ceiling(c1690pk);
        if (c1690pk2 != null && c1690pk2.f25204b == c1690pk.f25203a) {
            z = true;
        } else {
            z = false;
        }
        if (c1690pk3 != null && c1690pk.f25204b == c1690pk3.f25203a) {
            if (z) {
                c1690pk2.f25204b = c1690pk3.f25204b;
                c1690pk2.f25205c = c1690pk3.f25205c;
            } else {
                c1690pk.f25204b = c1690pk3.f25204b;
                c1690pk.f25205c = c1690pk3.f25205c;
                treeSet.add(c1690pk);
            }
            treeSet.remove(c1690pk3);
            return;
        }
        ChunkIndex chunkIndex = this.f12403c;
        if (z) {
            c1690pk2.f25204b = c1690pk.f25204b;
            int i = c1690pk2.f25205c;
            while (i < chunkIndex.length - 1) {
                int i2 = i + 1;
                if (chunkIndex.offsets[i2] > c1690pk2.f25204b) {
                    break;
                } else {
                    i = i2;
                }
            }
            c1690pk2.f25205c = i;
            return;
        }
        int binarySearch = Arrays.binarySearch(chunkIndex.offsets, c1690pk.f25204b);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        c1690pk.f25205c = binarySearch;
        treeSet.add(c1690pk);
    }

    public synchronized int getRegionEndTimeMs(long j) {
        int i;
        C1690pk c1690pk = this.f12405e;
        c1690pk.f25203a = j;
        C1690pk c1690pk2 = (C1690pk) this.f12404d.floor(c1690pk);
        if (c1690pk2 != null) {
            long j2 = c1690pk2.f25204b;
            if (j <= j2 && (i = c1690pk2.f25205c) != -1) {
                ChunkIndex chunkIndex = this.f12403c;
                if (i == chunkIndex.length - 1) {
                    if (j2 == chunkIndex.offsets[i] + chunkIndex.sizes[i]) {
                        return -2;
                    }
                }
                return (int) ((chunkIndex.timesUs[i] + ((chunkIndex.durationsUs[i] * (j2 - chunkIndex.offsets[i])) / chunkIndex.sizes[i])) / 1000);
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public synchronized void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
        m2975a(cacheSpan);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public synchronized void onSpanRemoved(Cache cache, CacheSpan cacheSpan) {
        long j = cacheSpan.position;
        C1690pk c1690pk = new C1690pk(j, cacheSpan.length + j);
        C1690pk c1690pk2 = (C1690pk) this.f12404d.floor(c1690pk);
        if (c1690pk2 == null) {
            Log.m3023e("CachedRegionTracker", "Removed a span we were not aware of");
            return;
        }
        this.f12404d.remove(c1690pk2);
        long j2 = c1690pk2.f25203a;
        long j3 = c1690pk.f25203a;
        if (j2 < j3) {
            C1690pk c1690pk3 = new C1690pk(j2, j3);
            int binarySearch = Arrays.binarySearch(this.f12403c.offsets, j3);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            c1690pk3.f25205c = binarySearch;
            this.f12404d.add(c1690pk3);
        }
        long j4 = c1690pk2.f25204b;
        long j5 = c1690pk.f25204b;
        if (j4 > j5) {
            C1690pk c1690pk4 = new C1690pk(j5 + 1, j4);
            c1690pk4.f25205c = c1690pk2.f25205c;
            this.f12404d.add(c1690pk4);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
    }

    public void release() {
        this.f12401a.removeListener(this.f12402b, this);
    }
}
