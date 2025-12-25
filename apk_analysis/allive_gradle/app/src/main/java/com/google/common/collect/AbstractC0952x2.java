package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import p000.iq1;
import p000.rv2;

/* renamed from: com.google.common.collect.x2 */
/* loaded from: classes.dex */
public abstract class AbstractC0952x2 extends iq1 implements SortedSet {

    /* renamed from: a */
    public final SortedMultiset f14991a;

    public AbstractC0952x2(SortedMultiset sortedMultiset) {
        this.f14991a = sortedMultiset;
    }

    @Override // java.util.SortedSet
    public Comparator<Object> comparator() {
        return this.f14991a.comparator();
    }

    @Override // p000.iq1
    /* renamed from: d */
    public final Multiset mo3860d() {
        return this.f14991a;
    }

    @Override // java.util.SortedSet
    public Object first() {
        Multiset.Entry firstEntry = this.f14991a.firstEntry();
        if (firstEntry != null) {
            return firstEntry.getElement();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.SortedSet
    public SortedSet<Object> headSet(Object obj) {
        return this.f14991a.headMultiset(obj, BoundType.OPEN).elementSet();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Object> iterator() {
        return new rv2(this.f14991a.entrySet().iterator());
    }

    @Override // java.util.SortedSet
    public Object last() {
        Multiset.Entry lastEntry = this.f14991a.lastEntry();
        if (lastEntry != null) {
            return lastEntry.getElement();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.SortedSet
    public SortedSet<Object> subSet(Object obj, Object obj2) {
        return this.f14991a.subMultiset(obj, BoundType.CLOSED, obj2, BoundType.OPEN).elementSet();
    }

    @Override // java.util.SortedSet
    public SortedSet<Object> tailSet(Object obj) {
        return this.f14991a.tailMultiset(obj, BoundType.CLOSED).elementSet();
    }
}
