package p000;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.BoundType;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import okhttp3.HttpUrl;

/* loaded from: classes.dex */
public final class r80 extends ContiguousSet {
    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public final ImmutableList asList() {
        return ImmutableList.m3902of();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final UnmodifiableIterator descendingIterator() {
        return z51.f29250d;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj instanceof Set) {
            return ((Set) obj).isEmpty();
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public final Object first() {
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final UnmodifiableIterator iterator() {
        return z51.f29250d;
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    /* renamed from: k */
    public final ImmutableSortedSet mo3842k() {
        return ImmutableSortedSet.m4015l(Ordering.natural().reverse());
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public final Object last() {
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    /* renamed from: m */
    public final ImmutableSortedSet mo3843m(Object obj, boolean z) {
        return this;
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    /* renamed from: n */
    public final ImmutableSortedSet mo3844n(Object obj, boolean z, Object obj2, boolean z2) {
        return this;
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    /* renamed from: o */
    public final ImmutableSortedSet mo3845o(Object obj, boolean z) {
        return this;
    }

    @Override // com.google.common.collect.ContiguousSet
    public final Range range() {
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 0;
    }

    @Override // com.google.common.collect.ContiguousSet, java.util.AbstractCollection
    public final String toString() {
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public Object writeReplace() {
        return new q80(this.f14625e);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final Iterator descendingIterator() {
        return z51.f29250d;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return z51.f29250d;
    }

    @Override // com.google.common.collect.ContiguousSet
    public final Range range(BoundType boundType, BoundType boundType2) {
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ContiguousSet
    public final ContiguousSet intersection(ContiguousSet contiguousSet) {
        return this;
    }

    @Override // com.google.common.collect.ContiguousSet
    /* renamed from: p */
    public final ContiguousSet mo3843m(Comparable comparable, boolean z) {
        return this;
    }

    @Override // com.google.common.collect.ContiguousSet
    /* renamed from: r */
    public final ContiguousSet mo3845o(Comparable comparable, boolean z) {
        return this;
    }

    @Override // com.google.common.collect.ContiguousSet
    /* renamed from: q */
    public final ContiguousSet mo3844n(Comparable comparable, boolean z, Comparable comparable2, boolean z2) {
        return this;
    }
}
