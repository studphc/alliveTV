package p000;

import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

/* loaded from: classes.dex */
public final class nr2 extends ur2 implements NavigableMap {
    private static final long serialVersionUID = 0;

    /* renamed from: f */
    public transient or2 f23467f;

    /* renamed from: g */
    public transient nr2 f23468g;

    /* renamed from: h */
    public transient or2 f23469h;

    @Override // java.util.NavigableMap
    public final Map.Entry ceilingEntry(Object obj) {
        ir2 m8358e;
        synchronized (this.f25273b) {
            m8358e = yy2.m8358e(mo4828e().ceilingEntry(obj), this.f25273b);
        }
        return m8358e;
    }

    @Override // java.util.NavigableMap
    public final Object ceilingKey(Object obj) {
        Object ceilingKey;
        synchronized (this.f25273b) {
            ceilingKey = mo4828e().ceilingKey(obj);
        }
        return ceilingKey;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [pr2, java.util.NavigableSet, or2] */
    @Override // java.util.NavigableMap
    public final NavigableSet descendingKeySet() {
        synchronized (this.f25273b) {
            try {
                or2 or2Var = this.f23467f;
                if (or2Var == null) {
                    ?? pr2Var = new pr2(mo4828e().descendingKeySet(), this.f25273b);
                    this.f23467f = pr2Var;
                    return pr2Var;
                }
                return or2Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [pr2, java.util.NavigableMap, nr2] */
    @Override // java.util.NavigableMap
    public final NavigableMap descendingMap() {
        synchronized (this.f25273b) {
            try {
                nr2 nr2Var = this.f23468g;
                if (nr2Var == null) {
                    ?? pr2Var = new pr2(mo4828e().descendingMap(), this.f25273b);
                    this.f23468g = pr2Var;
                    return pr2Var;
                }
                return nr2Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p000.lr2
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final NavigableMap mo4828e() {
        return (NavigableMap) ((SortedMap) ((Map) this.f25272a));
    }

    @Override // java.util.NavigableMap
    public final Map.Entry firstEntry() {
        ir2 m8358e;
        synchronized (this.f25273b) {
            m8358e = yy2.m8358e(mo4828e().firstEntry(), this.f25273b);
        }
        return m8358e;
    }

    @Override // java.util.NavigableMap
    public final Map.Entry floorEntry(Object obj) {
        ir2 m8358e;
        synchronized (this.f25273b) {
            m8358e = yy2.m8358e(mo4828e().floorEntry(obj), this.f25273b);
        }
        return m8358e;
    }

    @Override // java.util.NavigableMap
    public final Object floorKey(Object obj) {
        Object floorKey;
        synchronized (this.f25273b) {
            floorKey = mo4828e().floorKey(obj);
        }
        return floorKey;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [pr2, java.util.NavigableMap] */
    @Override // java.util.NavigableMap
    public final NavigableMap headMap(Object obj, boolean z) {
        ?? pr2Var;
        synchronized (this.f25273b) {
            pr2Var = new pr2(mo4828e().headMap(obj, z), this.f25273b);
        }
        return pr2Var;
    }

    @Override // java.util.NavigableMap
    public final Map.Entry higherEntry(Object obj) {
        ir2 m8358e;
        synchronized (this.f25273b) {
            m8358e = yy2.m8358e(mo4828e().higherEntry(obj), this.f25273b);
        }
        return m8358e;
    }

    @Override // java.util.NavigableMap
    public final Object higherKey(Object obj) {
        Object higherKey;
        synchronized (this.f25273b) {
            higherKey = mo4828e().higherKey(obj);
        }
        return higherKey;
    }

    @Override // p000.lr2, java.util.Map
    public final Set keySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lastEntry() {
        ir2 m8358e;
        synchronized (this.f25273b) {
            m8358e = yy2.m8358e(mo4828e().lastEntry(), this.f25273b);
        }
        return m8358e;
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lowerEntry(Object obj) {
        ir2 m8358e;
        synchronized (this.f25273b) {
            m8358e = yy2.m8358e(mo4828e().lowerEntry(obj), this.f25273b);
        }
        return m8358e;
    }

    @Override // java.util.NavigableMap
    public final Object lowerKey(Object obj) {
        Object lowerKey;
        synchronized (this.f25273b) {
            lowerKey = mo4828e().lowerKey(obj);
        }
        return lowerKey;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [pr2, java.util.NavigableSet, or2] */
    @Override // java.util.NavigableMap
    public final NavigableSet navigableKeySet() {
        synchronized (this.f25273b) {
            try {
                or2 or2Var = this.f23469h;
                if (or2Var == null) {
                    ?? pr2Var = new pr2(mo4828e().navigableKeySet(), this.f25273b);
                    this.f23469h = pr2Var;
                    return pr2Var;
                }
                return or2Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollFirstEntry() {
        ir2 m8358e;
        synchronized (this.f25273b) {
            m8358e = yy2.m8358e(mo4828e().pollFirstEntry(), this.f25273b);
        }
        return m8358e;
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollLastEntry() {
        ir2 m8358e;
        synchronized (this.f25273b) {
            m8358e = yy2.m8358e(mo4828e().pollLastEntry(), this.f25273b);
        }
        return m8358e;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [pr2, java.util.NavigableMap] */
    @Override // java.util.NavigableMap
    public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
        ?? pr2Var;
        synchronized (this.f25273b) {
            pr2Var = new pr2(mo4828e().subMap(obj, z, obj2, z2), this.f25273b);
        }
        return pr2Var;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [pr2, java.util.NavigableMap] */
    @Override // java.util.NavigableMap
    public final NavigableMap tailMap(Object obj, boolean z) {
        ?? pr2Var;
        synchronized (this.f25273b) {
            pr2Var = new pr2(mo4828e().tailMap(obj, z), this.f25273b);
        }
        return pr2Var;
    }

    @Override // java.util.SortedMap, java.util.NavigableMap
    public final SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    @Override // java.util.SortedMap, java.util.NavigableMap
    public final SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    @Override // java.util.SortedMap, java.util.NavigableMap
    public final SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }
}
