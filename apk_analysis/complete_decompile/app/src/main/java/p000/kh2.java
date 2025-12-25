package p000;

import com.google.common.collect.ForwardingNavigableSet;
import com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public abstract class kh2 extends ForwardingNavigableSet {

    /* renamed from: a */
    public final ForwardingNavigableSet f20857a;

    public kh2(ForwardingNavigableSet forwardingNavigableSet) {
        this.f20857a = forwardingNavigableSet;
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
    @CheckForNull
    public Object ceiling(Object obj) {
        return this.f20857a.floor(obj);
    }

    @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
    public Comparator<Object> comparator() {
        Comparator<? super E> comparator = this.f20857a.comparator();
        if (comparator == 0) {
            return Ordering.natural().reverse();
        }
        return Ordering.from(comparator).reverse();
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
    public Iterator<Object> descendingIterator() {
        return this.f20857a.iterator();
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
    public NavigableSet<Object> descendingSet() {
        return this.f20857a;
    }

    @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
    public Object first() {
        return this.f20857a.last();
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
    @CheckForNull
    public Object floor(Object obj) {
        return this.f20857a.ceiling(obj);
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
    public NavigableSet<Object> headSet(Object obj, boolean z) {
        return this.f20857a.tailSet(obj, z).descendingSet();
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
    @CheckForNull
    public Object higher(Object obj) {
        return this.f20857a.lower(obj);
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable
    public Iterator<Object> iterator() {
        return this.f20857a.descendingIterator();
    }

    @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
    public Object last() {
        return this.f20857a.first();
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
    @CheckForNull
    public Object lower(Object obj) {
        return this.f20857a.higher(obj);
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
    @CheckForNull
    public Object pollFirst() {
        return this.f20857a.pollLast();
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
    @CheckForNull
    public Object pollLast() {
        return this.f20857a.pollFirst();
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
    public NavigableSet<Object> subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return this.f20857a.subSet(obj2, z2, obj, z).descendingSet();
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
    public NavigableSet<Object> tailSet(Object obj, boolean z) {
        return this.f20857a.headSet(obj, z).descendingSet();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public Object[] toArray() {
        return standardToArray();
    }

    @Override // com.google.common.collect.ForwardingObject, com.google.common.collect.Multiset
    public String toString() {
        return standardToString();
    }

    @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
    public SortedSet<Object> headSet(Object obj) {
        return standardHeadSet(obj);
    }

    @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
    public SortedSet<Object> subSet(Object obj, Object obj2) {
        return standardSubSet(obj, obj2);
    }

    @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
    public SortedSet<Object> tailSet(Object obj) {
        return standardTailSet(obj);
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) standardToArray(tArr);
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public NavigableSet<Object> delegate() {
        return this.f20857a;
    }
}
