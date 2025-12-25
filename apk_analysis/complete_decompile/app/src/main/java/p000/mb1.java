package p000;

import com.google.common.base.Preconditions;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.C0838c;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.ConcurrentMapC0840e;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public final class mb1 extends C0838c implements LoadingCache {
    private static final long serialVersionUID = 1;

    @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
    public final Object apply(Object obj) {
        return getUnchecked(obj);
    }

    @Override // com.google.common.cache.LoadingCache
    public final Object get(Object obj) {
        ConcurrentMapC0840e concurrentMapC0840e = this.f14569a;
        return concurrentMapC0840e.m3825g(obj, concurrentMapC0840e.f14605s);
    }

    @Override // com.google.common.cache.LoadingCache
    public final ImmutableMap getAll(Iterable iterable) {
        ConcurrentMapC0840e concurrentMapC0840e = this.f14569a;
        CacheLoader cacheLoader = concurrentMapC0840e.f14605s;
        AbstractCache.StatsCounter statsCounter = concurrentMapC0840e.f14604r;
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        LinkedHashSet newLinkedHashSet = Sets.newLinkedHashSet();
        int i = 0;
        int i2 = 0;
        for (Object obj : iterable) {
            Object obj2 = concurrentMapC0840e.get(obj);
            if (!newLinkedHashMap.containsKey(obj)) {
                newLinkedHashMap.put(obj, obj2);
                if (obj2 == null) {
                    i2++;
                    newLinkedHashSet.add(obj);
                } else {
                    i++;
                }
            }
        }
        try {
            if (!newLinkedHashSet.isEmpty()) {
                try {
                    Map m3828j = concurrentMapC0840e.m3828j(Collections.unmodifiableSet(newLinkedHashSet), cacheLoader);
                    for (Object obj3 : newLinkedHashSet) {
                        Object obj4 = m3828j.get(obj3);
                        if (obj4 != null) {
                            newLinkedHashMap.put(obj3, obj4);
                        } else {
                            String valueOf = String.valueOf(obj3);
                            StringBuilder sb = new StringBuilder(valueOf.length() + 37);
                            sb.append("loadAll failed to return a value for ");
                            sb.append(valueOf);
                            throw new CacheLoader.InvalidCacheLoadException(sb.toString());
                        }
                    }
                } catch (CacheLoader.UnsupportedLoadingOperationException unused) {
                    for (Object obj5 : newLinkedHashSet) {
                        i2--;
                        newLinkedHashMap.put(obj5, concurrentMapC0840e.m3825g(obj5, cacheLoader));
                    }
                }
            }
            ImmutableMap copyOf = ImmutableMap.copyOf((Map) newLinkedHashMap);
            statsCounter.recordHits(i);
            statsCounter.recordMisses(i2);
            return copyOf;
        } catch (Throwable th) {
            statsCounter.recordHits(i);
            statsCounter.recordMisses(i2);
            throw th;
        }
    }

    @Override // com.google.common.cache.LoadingCache
    public final Object getUnchecked(Object obj) {
        try {
            return get(obj);
        } catch (ExecutionException e) {
            throw new UncheckedExecutionException(e.getCause());
        }
    }

    @Override // com.google.common.cache.LoadingCache
    public final void refresh(Object obj) {
        ConcurrentMapC0840e concurrentMapC0840e = this.f14569a;
        concurrentMapC0840e.getClass();
        int m3826h = concurrentMapC0840e.m3826h(Preconditions.checkNotNull(obj));
        concurrentMapC0840e.m3829k(m3826h).m3811q(obj, m3826h, concurrentMapC0840e.f14605s, false);
    }

    @Override // com.google.common.cache.C0838c
    public Object writeReplace() {
        return new ob1(this.f14569a);
    }
}
