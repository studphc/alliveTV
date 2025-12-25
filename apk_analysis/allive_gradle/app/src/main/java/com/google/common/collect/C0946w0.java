package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedMap;

/* renamed from: com.google.common.collect.w0 */
/* loaded from: classes.dex */
public class C0946w0 extends C0938u0 implements SortedMap {
    /* renamed from: c */
    public SortedMap mo4166c() {
        return (SortedMap) this.f14969a;
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return mo4166c().comparator();
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return mo4166c().firstKey();
    }

    public SortedMap headMap(Object obj) {
        return Maps.transformEntries(mo4166c().headMap(obj), this.f14970b);
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return mo4166c().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return Maps.transformEntries(mo4166c().subMap(obj, obj2), this.f14970b);
    }

    public SortedMap tailMap(Object obj) {
        return Maps.transformEntries(mo4166c().tailMap(obj), this.f14970b);
    }
}
