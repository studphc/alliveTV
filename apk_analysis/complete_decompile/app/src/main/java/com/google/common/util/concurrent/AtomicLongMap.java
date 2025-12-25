package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import p000.n82;

@GwtCompatible
/* loaded from: classes2.dex */
public final class AtomicLongMap<K> implements Serializable {

    /* renamed from: a */
    public final ConcurrentHashMap f15281a;

    /* renamed from: b */
    public transient Map f15282b;

    public AtomicLongMap(ConcurrentHashMap concurrentHashMap) {
        this.f15281a = (ConcurrentHashMap) Preconditions.checkNotNull(concurrentHashMap);
    }

    public static <K> AtomicLongMap<K> create() {
        return new AtomicLongMap<>(new ConcurrentHashMap());
    }

    @CanIgnoreReturnValue
    public long addAndGet(K k, long j) {
        ConcurrentHashMap concurrentHashMap;
        AtomicLong atomicLong;
        long j2;
        long j3;
        do {
            concurrentHashMap = this.f15281a;
            atomicLong = (AtomicLong) concurrentHashMap.get(k);
            if (atomicLong == null && (atomicLong = (AtomicLong) concurrentHashMap.putIfAbsent(k, new AtomicLong(j))) == null) {
                return j;
            }
            do {
                j2 = atomicLong.get();
                if (j2 != 0) {
                    j3 = j2 + j;
                }
            } while (!atomicLong.compareAndSet(j2, j3));
            return j3;
        } while (!concurrentHashMap.replace(k, atomicLong, new AtomicLong(j)));
        return j;
    }

    public Map<K, Long> asMap() {
        Map<K, Long> map = this.f15282b;
        if (map == null) {
            Map<K, Long> unmodifiableMap = Collections.unmodifiableMap(Maps.transformValues(this.f15281a, new n82(2)));
            this.f15282b = unmodifiableMap;
            return unmodifiableMap;
        }
        return map;
    }

    public void clear() {
        this.f15281a.clear();
    }

    public boolean containsKey(Object obj) {
        return this.f15281a.containsKey(obj);
    }

    @CanIgnoreReturnValue
    public long decrementAndGet(K k) {
        return addAndGet(k, -1L);
    }

    public long get(K k) {
        AtomicLong atomicLong = (AtomicLong) this.f15281a.get(k);
        if (atomicLong == null) {
            return 0L;
        }
        return atomicLong.get();
    }

    @CanIgnoreReturnValue
    public long getAndAdd(K k, long j) {
        ConcurrentHashMap concurrentHashMap;
        AtomicLong atomicLong;
        long j2;
        do {
            concurrentHashMap = this.f15281a;
            atomicLong = (AtomicLong) concurrentHashMap.get(k);
            if (atomicLong == null && (atomicLong = (AtomicLong) concurrentHashMap.putIfAbsent(k, new AtomicLong(j))) == null) {
                return 0L;
            }
            do {
                j2 = atomicLong.get();
                if (j2 == 0) {
                }
            } while (!atomicLong.compareAndSet(j2, j2 + j));
            return j2;
        } while (!concurrentHashMap.replace(k, atomicLong, new AtomicLong(j)));
        return 0L;
    }

    @CanIgnoreReturnValue
    public long getAndDecrement(K k) {
        return getAndAdd(k, -1L);
    }

    @CanIgnoreReturnValue
    public long getAndIncrement(K k) {
        return getAndAdd(k, 1L);
    }

    @CanIgnoreReturnValue
    public long incrementAndGet(K k) {
        return addAndGet(k, 1L);
    }

    public boolean isEmpty() {
        return this.f15281a.isEmpty();
    }

    @CanIgnoreReturnValue
    public long put(K k, long j) {
        ConcurrentHashMap concurrentHashMap;
        AtomicLong atomicLong;
        long j2;
        do {
            concurrentHashMap = this.f15281a;
            atomicLong = (AtomicLong) concurrentHashMap.get(k);
            if (atomicLong == null && (atomicLong = (AtomicLong) concurrentHashMap.putIfAbsent(k, new AtomicLong(j))) == null) {
                return 0L;
            }
            do {
                j2 = atomicLong.get();
                if (j2 == 0) {
                }
            } while (!atomicLong.compareAndSet(j2, j));
            return j2;
        } while (!concurrentHashMap.replace(k, atomicLong, new AtomicLong(j)));
        return 0L;
    }

    public void putAll(Map<? extends K, ? extends Long> map) {
        for (Map.Entry<? extends K, ? extends Long> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue().longValue());
        }
    }

    @CanIgnoreReturnValue
    public long remove(K k) {
        long j;
        ConcurrentHashMap concurrentHashMap = this.f15281a;
        AtomicLong atomicLong = (AtomicLong) concurrentHashMap.get(k);
        if (atomicLong == null) {
            return 0L;
        }
        do {
            j = atomicLong.get();
            if (j == 0) {
                break;
            }
        } while (!atomicLong.compareAndSet(j, 0L));
        concurrentHashMap.remove(k, atomicLong);
        return j;
    }

    public void removeAllZeros() {
        Iterator it = this.f15281a.entrySet().iterator();
        while (it.hasNext()) {
            AtomicLong atomicLong = (AtomicLong) ((Map.Entry) it.next()).getValue();
            if (atomicLong != null && atomicLong.get() == 0) {
                it.remove();
            }
        }
    }

    @CanIgnoreReturnValue
    @Beta
    public boolean removeIfZero(K k) {
        ConcurrentHashMap concurrentHashMap = this.f15281a;
        AtomicLong atomicLong = (AtomicLong) concurrentHashMap.get(k);
        if (atomicLong == null) {
            return false;
        }
        long j = atomicLong.get();
        if (j != 0) {
            return false;
        }
        if (j != 0 && !atomicLong.compareAndSet(j, 0L)) {
            return false;
        }
        concurrentHashMap.remove(k, atomicLong);
        return true;
    }

    public int size() {
        return this.f15281a.size();
    }

    public long sum() {
        Iterator it = this.f15281a.values().iterator();
        long j = 0;
        while (it.hasNext()) {
            j += ((AtomicLong) it.next()).get();
        }
        return j;
    }

    public String toString() {
        return this.f15281a.toString();
    }

    public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> map) {
        AtomicLongMap<K> create = create();
        create.putAll(map);
        return create;
    }
}
