package p000;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public class bh1 extends dh1 implements NavigableSet {
    @Override // java.util.NavigableSet
    @CheckForNull
    public Object ceiling(Object obj) {
        return ((NavigableMap) this.f29371a).ceilingKey(obj);
    }

    @Override // p000.dh1, p000.zg1
    /* renamed from: d */
    public final Map mo2097d() {
        return (NavigableMap) this.f29371a;
    }

    @Override // java.util.NavigableSet
    public Iterator<Object> descendingIterator() {
        return descendingSet().iterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<Object> descendingSet() {
        return ((NavigableMap) this.f29371a).descendingKeySet();
    }

    @Override // p000.dh1
    /* renamed from: e */
    public final SortedMap mo2097d() {
        return (NavigableMap) this.f29371a;
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public Object floor(Object obj) {
        return ((NavigableMap) this.f29371a).floorKey(obj);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<Object> headSet(Object obj, boolean z) {
        return ((NavigableMap) this.f29371a).headMap(obj, z).navigableKeySet();
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public Object higher(Object obj) {
        return ((NavigableMap) this.f29371a).higherKey(obj);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public Object lower(Object obj) {
        return ((NavigableMap) this.f29371a).lowerKey(obj);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public Object pollFirst() {
        return Maps.m4050f(((NavigableMap) this.f29371a).pollFirstEntry());
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public Object pollLast() {
        return Maps.m4050f(((NavigableMap) this.f29371a).pollLastEntry());
    }

    @Override // java.util.NavigableSet
    public NavigableSet<Object> subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return ((NavigableMap) this.f29371a).subMap(obj, z, obj2, z2).navigableKeySet();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<Object> tailSet(Object obj, boolean z) {
        return ((NavigableMap) this.f29371a).tailMap(obj, z).navigableKeySet();
    }

    @Override // p000.dh1, java.util.SortedSet, java.util.NavigableSet
    public SortedSet<Object> headSet(Object obj) {
        return headSet(obj, false);
    }

    @Override // p000.dh1, java.util.SortedSet, java.util.NavigableSet
    public SortedSet<Object> subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    @Override // p000.dh1, java.util.SortedSet, java.util.NavigableSet
    public SortedSet<Object> tailSet(Object obj) {
        return tailSet(obj, true);
    }
}
