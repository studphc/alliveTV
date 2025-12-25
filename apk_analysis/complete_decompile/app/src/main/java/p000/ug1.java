package p000;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class ug1 extends AbstractC1254h2 {

    /* renamed from: a */
    public final NavigableMap f27256a;

    /* renamed from: b */
    public final Predicate f27257b;

    /* renamed from: c */
    public final sg1 f27258c;

    public ug1(NavigableMap navigableMap, Predicate predicate) {
        this.f27256a = (NavigableMap) Preconditions.checkNotNull(navigableMap);
        this.f27257b = predicate;
        this.f27258c = new sg1(navigableMap, predicate);
    }

    @Override // p000.yg1
    /* renamed from: a */
    public final Iterator mo84a() {
        return Iterators.filter(this.f27256a.entrySet().iterator(), this.f27257b);
    }

    @Override // p000.AbstractC1254h2
    /* renamed from: c */
    public final Iterator mo85c() {
        return Iterators.filter(this.f27256a.descendingMap().entrySet().iterator(), this.f27257b);
    }

    @Override // p000.yg1, java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f27258c.clear();
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return this.f27256a.comparator();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return this.f27258c.containsKey(obj);
    }

    @Override // p000.AbstractC1254h2, java.util.NavigableMap
    public final NavigableMap descendingMap() {
        return Maps.filterEntries(this.f27256a.descendingMap(), this.f27257b);
    }

    @Override // p000.yg1, java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public final Set entrySet() {
        return this.f27258c.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        return this.f27258c.get(obj);
    }

    @Override // java.util.NavigableMap
    public final NavigableMap headMap(Object obj, boolean z) {
        return Maps.filterEntries(this.f27256a.headMap(obj, z), this.f27257b);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return !Iterables.any(this.f27256a.entrySet(), this.f27257b);
    }

    @Override // p000.AbstractC1254h2, java.util.NavigableMap
    public final NavigableSet navigableKeySet() {
        return new tg1(this, this);
    }

    @Override // p000.AbstractC1254h2, java.util.NavigableMap
    public final Map.Entry pollFirstEntry() {
        return (Map.Entry) Iterables.m4031a(this.f27256a.entrySet(), this.f27257b);
    }

    @Override // p000.AbstractC1254h2, java.util.NavigableMap
    public final Map.Entry pollLastEntry() {
        return (Map.Entry) Iterables.m4031a(this.f27256a.descendingMap().entrySet(), this.f27257b);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        return this.f27258c.put(obj, obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        this.f27258c.putAll(map);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        return this.f27258c.remove(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f27258c.size();
    }

    @Override // java.util.NavigableMap
    public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
        return Maps.filterEntries(this.f27256a.subMap(obj, z, obj2, z2), this.f27257b);
    }

    @Override // java.util.NavigableMap
    public final NavigableMap tailMap(Object obj, boolean z) {
        return Maps.filterEntries(this.f27256a.tailMap(obj, z), this.f27257b);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public final Collection values() {
        return new xg1(this, this.f27256a, this.f27257b);
    }
}
