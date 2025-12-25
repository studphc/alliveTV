package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;

/* renamed from: com.google.common.collect.v0 */
/* loaded from: classes.dex */
public final class C0942v0 extends C0946w0 implements NavigableMap {
    @Override // java.util.NavigableMap
    public final Map.Entry ceilingEntry(Object obj) {
        return m4168f(mo4166c().ceilingEntry(obj));
    }

    @Override // java.util.NavigableMap
    public final Object ceilingKey(Object obj) {
        return mo4166c().ceilingKey(obj);
    }

    @Override // java.util.NavigableMap
    public final NavigableSet descendingKeySet() {
        return mo4166c().descendingKeySet();
    }

    @Override // java.util.NavigableMap
    public final NavigableMap descendingMap() {
        return Maps.transformEntries(mo4166c().descendingMap(), this.f14970b);
    }

    @Override // com.google.common.collect.C0946w0
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final NavigableMap mo4166c() {
        return (NavigableMap) ((SortedMap) this.f14969a);
    }

    /* renamed from: f */
    public final C0917p0 m4168f(Map.Entry entry) {
        if (entry == null) {
            return null;
        }
        Maps.EntryTransformer entryTransformer = this.f14970b;
        Preconditions.checkNotNull(entryTransformer);
        Preconditions.checkNotNull(entry);
        return new C0917p0(entry, entryTransformer);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry firstEntry() {
        return m4168f(mo4166c().firstEntry());
    }

    @Override // java.util.NavigableMap
    public final Map.Entry floorEntry(Object obj) {
        return m4168f(mo4166c().floorEntry(obj));
    }

    @Override // java.util.NavigableMap
    public final Object floorKey(Object obj) {
        return mo4166c().floorKey(obj);
    }

    @Override // com.google.common.collect.C0946w0, java.util.SortedMap, java.util.NavigableMap
    public final SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry higherEntry(Object obj) {
        return m4168f(mo4166c().higherEntry(obj));
    }

    @Override // java.util.NavigableMap
    public final Object higherKey(Object obj) {
        return mo4166c().higherKey(obj);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lastEntry() {
        return m4168f(mo4166c().lastEntry());
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lowerEntry(Object obj) {
        return m4168f(mo4166c().lowerEntry(obj));
    }

    @Override // java.util.NavigableMap
    public final Object lowerKey(Object obj) {
        return mo4166c().lowerKey(obj);
    }

    @Override // java.util.NavigableMap
    public final NavigableSet navigableKeySet() {
        return mo4166c().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollFirstEntry() {
        return m4168f(mo4166c().pollFirstEntry());
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollLastEntry() {
        return m4168f(mo4166c().pollLastEntry());
    }

    @Override // java.util.NavigableMap
    public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
        return Maps.transformEntries(mo4166c().subMap(obj, z, obj2, z2), this.f14970b);
    }

    @Override // com.google.common.collect.C0946w0, java.util.SortedMap, java.util.NavigableMap
    public final SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }

    @Override // java.util.NavigableMap
    public final NavigableMap headMap(Object obj, boolean z) {
        return Maps.transformEntries(mo4166c().headMap(obj, z), this.f14970b);
    }

    @Override // java.util.NavigableMap
    public final NavigableMap tailMap(Object obj, boolean z) {
        return Maps.transformEntries(mo4166c().tailMap(obj, z), this.f14970b);
    }

    @Override // com.google.common.collect.C0946w0, java.util.SortedMap, java.util.NavigableMap
    public final SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }
}
