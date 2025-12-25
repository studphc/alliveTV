package p000;

import com.google.common.collect.ForwardingSortedMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

/* loaded from: classes.dex */
public final class gh1 extends ForwardingSortedMap implements NavigableMap, Serializable {

    /* renamed from: a */
    public final NavigableMap f17695a;

    /* renamed from: b */
    public transient gh1 f17696b;

    public gh1(NavigableMap navigableMap) {
        this.f17695a = navigableMap;
    }

    @Override // java.util.NavigableMap
    public final Map.Entry ceilingEntry(Object obj) {
        return Maps.m4046b(this.f17695a.ceilingEntry(obj));
    }

    @Override // java.util.NavigableMap
    public final Object ceilingKey(Object obj) {
        return this.f17695a.ceilingKey(obj);
    }

    @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public final Object delegate() {
        return Collections.unmodifiableSortedMap(this.f17695a);
    }

    @Override // java.util.NavigableMap
    public final NavigableSet descendingKeySet() {
        return Sets.unmodifiableNavigableSet(this.f17695a.descendingKeySet());
    }

    @Override // java.util.NavigableMap
    public final NavigableMap descendingMap() {
        gh1 gh1Var = this.f17696b;
        if (gh1Var == null) {
            gh1 gh1Var2 = new gh1(this.f17695a.descendingMap(), this);
            this.f17696b = gh1Var2;
            return gh1Var2;
        }
        return gh1Var;
    }

    @Override // java.util.NavigableMap
    public final Map.Entry firstEntry() {
        return Maps.m4046b(this.f17695a.firstEntry());
    }

    @Override // java.util.NavigableMap
    public final Map.Entry floorEntry(Object obj) {
        return Maps.m4046b(this.f17695a.floorEntry(obj));
    }

    @Override // java.util.NavigableMap
    public final Object floorKey(Object obj) {
        return this.f17695a.floorKey(obj);
    }

    @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
    public final SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry higherEntry(Object obj) {
        return Maps.m4046b(this.f17695a.higherEntry(obj));
    }

    @Override // java.util.NavigableMap
    public final Object higherKey(Object obj) {
        return this.f17695a.higherKey(obj);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public final Set keySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lastEntry() {
        return Maps.m4046b(this.f17695a.lastEntry());
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lowerEntry(Object obj) {
        return Maps.m4046b(this.f17695a.lowerEntry(obj));
    }

    @Override // java.util.NavigableMap
    public final Object lowerKey(Object obj) {
        return this.f17695a.lowerKey(obj);
    }

    @Override // java.util.NavigableMap
    public final NavigableSet navigableKeySet() {
        return Sets.unmodifiableNavigableSet(this.f17695a.navigableKeySet());
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
    public final SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
    public final SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }

    @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public final Map delegate() {
        return Collections.unmodifiableSortedMap(this.f17695a);
    }

    @Override // java.util.NavigableMap
    public final NavigableMap headMap(Object obj, boolean z) {
        return Maps.unmodifiableNavigableMap(this.f17695a.headMap(obj, z));
    }

    @Override // java.util.NavigableMap
    public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
        return Maps.unmodifiableNavigableMap(this.f17695a.subMap(obj, z, obj2, z2));
    }

    @Override // java.util.NavigableMap
    public final NavigableMap tailMap(Object obj, boolean z) {
        return Maps.unmodifiableNavigableMap(this.f17695a.tailMap(obj, z));
    }

    public gh1(NavigableMap navigableMap, gh1 gh1Var) {
        this.f17695a = navigableMap;
        this.f17696b = gh1Var;
    }

    @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public final SortedMap delegate() {
        return Collections.unmodifiableSortedMap(this.f17695a);
    }
}
