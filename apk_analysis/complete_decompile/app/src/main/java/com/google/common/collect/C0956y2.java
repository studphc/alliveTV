package com.google.common.collect;

import java.util.Iterator;
import java.util.NavigableSet;
import javax.annotation.CheckForNull;

/* renamed from: com.google.common.collect.y2 */
/* loaded from: classes.dex */
public class C0956y2 extends AbstractC0952x2 implements NavigableSet {
    @Override // java.util.NavigableSet
    @CheckForNull
    public Object ceiling(Object obj) {
        return AbstractC0960z2.m4170a(this.f14991a.tailMultiset(obj, BoundType.CLOSED).firstEntry());
    }

    @Override // java.util.NavigableSet
    public Iterator<Object> descendingIterator() {
        return descendingSet().iterator();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.collect.x2, java.util.NavigableSet<java.lang.Object>] */
    @Override // java.util.NavigableSet
    public NavigableSet<Object> descendingSet() {
        return new AbstractC0952x2(this.f14991a.descendingMultiset());
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public Object floor(Object obj) {
        return AbstractC0960z2.m4170a(this.f14991a.headMultiset(obj, BoundType.CLOSED).lastEntry());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.collect.x2, java.util.NavigableSet<java.lang.Object>] */
    @Override // java.util.NavigableSet
    public NavigableSet<Object> headSet(Object obj, boolean z) {
        return new AbstractC0952x2(this.f14991a.headMultiset(obj, BoundType.m3833a(z)));
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public Object higher(Object obj) {
        return AbstractC0960z2.m4170a(this.f14991a.tailMultiset(obj, BoundType.OPEN).firstEntry());
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public Object lower(Object obj) {
        return AbstractC0960z2.m4170a(this.f14991a.headMultiset(obj, BoundType.OPEN).lastEntry());
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public Object pollFirst() {
        return AbstractC0960z2.m4170a(this.f14991a.pollFirstEntry());
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public Object pollLast() {
        return AbstractC0960z2.m4170a(this.f14991a.pollLastEntry());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.collect.x2, java.util.NavigableSet<java.lang.Object>] */
    @Override // java.util.NavigableSet
    public NavigableSet<Object> subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return new AbstractC0952x2(this.f14991a.subMultiset(obj, BoundType.m3833a(z), obj2, BoundType.m3833a(z2)));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.collect.x2, java.util.NavigableSet<java.lang.Object>] */
    @Override // java.util.NavigableSet
    public NavigableSet<Object> tailSet(Object obj, boolean z) {
        return new AbstractC0952x2(this.f14991a.tailMultiset(obj, BoundType.m3833a(z)));
    }
}
