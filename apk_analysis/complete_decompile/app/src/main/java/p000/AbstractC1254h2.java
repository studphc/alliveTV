package p000;

import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;

/* renamed from: h2 */
/* loaded from: classes.dex */
public abstract class AbstractC1254h2 extends yg1 implements NavigableMap {
    /* renamed from: c */
    public abstract Iterator mo85c();

    @Override // java.util.NavigableMap
    public final Map.Entry ceilingEntry(Object obj) {
        return tailMap(obj, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public final Object ceilingKey(Object obj) {
        return Maps.m4050f(ceilingEntry(obj));
    }

    @Override // java.util.NavigableMap
    public final NavigableSet descendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    public NavigableMap descendingMap() {
        return new C1217g2(this);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry firstEntry() {
        return (Map.Entry) Iterators.getNext(mo84a(), null);
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        Map.Entry firstEntry = firstEntry();
        if (firstEntry != null) {
            return firstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry floorEntry(Object obj) {
        return headMap(obj, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public final Object floorKey(Object obj) {
        return Maps.m4050f(floorEntry(obj));
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry higherEntry(Object obj) {
        return tailMap(obj, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public final Object higherKey(Object obj) {
        return Maps.m4050f(higherEntry(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public final Set keySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lastEntry() {
        return (Map.Entry) Iterators.getNext(mo85c(), null);
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        Map.Entry lastEntry = lastEntry();
        if (lastEntry != null) {
            return lastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lowerEntry(Object obj) {
        return headMap(obj, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public final Object lowerKey(Object obj) {
        return Maps.m4050f(lowerEntry(obj));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [zg1, java.util.NavigableSet] */
    public NavigableSet navigableKeySet() {
        return new zg1(this);
    }

    @Override // java.util.NavigableMap
    public Map.Entry pollFirstEntry() {
        return (Map.Entry) Iterators.m4035c(mo84a());
    }

    @Override // java.util.NavigableMap
    public Map.Entry pollLastEntry() {
        return (Map.Entry) Iterators.m4035c(mo85c());
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }
}
