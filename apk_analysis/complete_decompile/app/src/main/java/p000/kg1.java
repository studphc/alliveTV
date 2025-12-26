package p000;

import com.google.common.collect.ForwardingMap;
import com.google.common.collect.Ordering;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public abstract class kg1 extends ForwardingMap implements NavigableMap {

    /* renamed from: a */
    public transient Ordering f20846a;

    /* renamed from: b */
    public transient C1290i1 f20847b;

    /* renamed from: c */
    public transient bh1 f20848c;

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<Object, Object> ceilingEntry(Object obj) {
        return mo3861e().floorEntry(obj);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Object ceilingKey(Object obj) {
        return mo3861e().floorKey(obj);
    }

    @Override // java.util.SortedMap
    public Comparator<Object> comparator() {
        Ordering ordering = this.f20846a;
        if (ordering == null) {
            Comparator comparator = mo3861e().comparator();
            if (comparator == null) {
                comparator = Ordering.natural();
            }
            Ordering reverse = Ordering.from(comparator).reverse();
            this.f20846a = reverse;
            return reverse;
        }
        return ordering;
    }

    @Override // java.util.NavigableMap
    public NavigableSet<Object> descendingKeySet() {
        return mo3861e().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<Object, Object> descendingMap() {
        return mo3861e();
    }

    /* renamed from: e */
    public abstract NavigableMap mo3861e();

    public abstract Iterator entryIterator();

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        C1290i1 c1290i1 = this.f20847b;
        if (c1290i1 == null) {
            C1290i1 c1290i12 = new C1290i1(this, 3);
            this.f20847b = c1290i12;
            return c1290i12;
        }
        return c1290i1;
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<Object, Object> firstEntry() {
        return mo3861e().lastEntry();
    }

    @Override // java.util.SortedMap
    public Object firstKey() {
        return mo3861e().lastKey();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<Object, Object> floorEntry(Object obj) {
        return mo3861e().ceilingEntry(obj);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Object floorKey(Object obj) {
        return mo3861e().ceilingKey(obj);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<Object, Object> headMap(Object obj, boolean z) {
        return mo3861e().tailMap(obj, z).descendingMap();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<Object, Object> higherEntry(Object obj) {
        return mo3861e().lowerEntry(obj);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Object higherKey(Object obj) {
        return mo3861e().lowerKey(obj);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<Object> keySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<Object, Object> lastEntry() {
        return mo3861e().firstEntry();
    }

    @Override // java.util.SortedMap
    public Object lastKey() {
        return mo3861e().firstKey();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<Object, Object> lowerEntry(Object obj) {
        return mo3861e().higherEntry(obj);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Object lowerKey(Object obj) {
        return mo3861e().higherKey(obj);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [zg1, java.util.NavigableSet<java.lang.Object>, bh1] */
    @Override // java.util.NavigableMap
    public NavigableSet<Object> navigableKeySet() {
        bh1 bh1Var = this.f20848c;
        if (bh1Var == null) {
            ?? zg1Var = new zg1(this);
            this.f20848c = zg1Var;
            return zg1Var;
        }
        return bh1Var;
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<Object, Object> pollFirstEntry() {
        return mo3861e().pollLastEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<Object, Object> pollLastEntry() {
        return mo3861e().pollFirstEntry();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<Object, Object> subMap(Object obj, boolean z, Object obj2, boolean z2) {
        return mo3861e().subMap(obj2, z2, obj, z).descendingMap();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<Object, Object> tailMap(Object obj, boolean z) {
        return mo3861e().headMap(obj, z).descendingMap();
    }

    @Override // com.google.common.collect.ForwardingObject, com.google.common.collect.Multiset
    public String toString() {
        return standardToString();
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public Collection<Object> values() {
        return new hh1(this);
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public final Map<Object, Object> delegate() {
        return mo3861e();
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<Object, Object> headMap(Object obj) {
        return headMap(obj, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<Object, Object> subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<Object, Object> tailMap(Object obj) {
        return tailMap(obj, true);
    }
}
