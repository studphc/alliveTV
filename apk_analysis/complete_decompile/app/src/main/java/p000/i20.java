package p000;

import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.NavigableSet;

/* loaded from: classes.dex */
public final class i20 extends ImmutableSortedSet {

    /* renamed from: e */
    public final ImmutableSortedSet f18269e;

    public i20(ImmutableSortedSet immutableSortedSet) {
        super(Ordering.from(immutableSortedSet.comparator()).reverse());
        this.f18269e = immutableSortedSet;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final Object ceiling(Object obj) {
        return this.f18269e.floor(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f18269e.contains(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final UnmodifiableIterator descendingIterator() {
        return this.f18269e.iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final NavigableSet descendingSet() {
        return this.f18269e;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return this.f18269e.mo7e();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final Object floor(Object obj) {
        return this.f18269e.ceiling(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final Object higher(Object obj) {
        return this.f18269e.lower(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final UnmodifiableIterator iterator() {
        return this.f18269e.descendingIterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: k */
    public final ImmutableSortedSet mo3842k() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final Object lower(Object obj) {
        return this.f18269e.higher(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: m */
    public final ImmutableSortedSet mo3843m(Object obj, boolean z) {
        return this.f18269e.tailSet((ImmutableSortedSet) obj, z).descendingSet();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: n */
    public final ImmutableSortedSet mo3844n(Object obj, boolean z, Object obj2, boolean z2) {
        return this.f18269e.subSet((boolean) obj2, z2, (boolean) obj, z).descendingSet();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: o */
    public final ImmutableSortedSet mo3845o(Object obj, boolean z) {
        return this.f18269e.headSet((ImmutableSortedSet) obj, z).descendingSet();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f18269e.size();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final Iterator descendingIterator() {
        return this.f18269e.iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final ImmutableSortedSet descendingSet() {
        return this.f18269e;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return this.f18269e.descendingIterator();
    }
}
