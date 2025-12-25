package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSortedSet;
import com.google.errorprone.annotations.DoNotCall;
import java.lang.Comparable;
import java.util.NoSuchElementException;
import java.util.Objects;
import p000.i20;
import p000.w92;

@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {

    /* renamed from: e */
    public final DiscreteDomain f14625e;

    public ContiguousSet(DiscreteDomain discreteDomain) {
        super(Ordering.natural());
        this.f14625e = discreteDomain;
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public static <E> ImmutableSortedSet.Builder<E> builder() {
        throw new UnsupportedOperationException();
    }

    @Beta
    public static ContiguousSet<Integer> closed(int i, int i2) {
        return create(Range.closed(Integer.valueOf(i), Integer.valueOf(i2)), DiscreteDomain.integers());
    }

    @Beta
    public static ContiguousSet<Integer> closedOpen(int i, int i2) {
        return create(Range.closedOpen(Integer.valueOf(i), Integer.valueOf(i2)), DiscreteDomain.integers());
    }

    public static <C extends Comparable> ContiguousSet<C> create(Range<C> range, DiscreteDomain<C> discreteDomain) {
        Range<C> range2;
        Preconditions.checkNotNull(range);
        Preconditions.checkNotNull(discreteDomain);
        try {
            if (!range.hasLowerBound()) {
                range2 = range.intersection(Range.atLeast(discreteDomain.minValue()));
            } else {
                range2 = range;
            }
            if (!range.hasUpperBound()) {
                range2 = range2.intersection(Range.atMost(discreteDomain.maxValue()));
            }
            if (!range2.isEmpty()) {
                Comparable mo6742i = range.f14747a.mo6742i(discreteDomain);
                Objects.requireNonNull(mo6742i);
                Comparable mo6740g = range.f14748b.mo6740g(discreteDomain);
                Objects.requireNonNull(mo6740g);
                if (mo6742i.compareTo(mo6740g) <= 0) {
                    return new w92(range2, discreteDomain);
                }
            }
            return new ContiguousSet<>(discreteDomain);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet);

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: k */
    public ImmutableSortedSet mo3842k() {
        return new i20(this);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: p */
    public abstract ContiguousSet mo3843m(Comparable comparable, boolean z);

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: q */
    public abstract ContiguousSet mo3844n(Comparable comparable, boolean z, Comparable comparable2, boolean z2);

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: r */
    public abstract ContiguousSet mo3845o(Comparable comparable, boolean z);

    public abstract Range<C> range();

    public abstract Range<C> range(BoundType boundType, BoundType boundType2);

    @Override // java.util.AbstractCollection
    public String toString() {
        return range().toString();
    }

    @Beta
    public static ContiguousSet<Long> closed(long j, long j2) {
        return create(Range.closed(Long.valueOf(j), Long.valueOf(j2)), DiscreteDomain.longs());
    }

    @Beta
    public static ContiguousSet<Long> closedOpen(long j, long j2) {
        return create(Range.closedOpen(Long.valueOf(j), Long.valueOf(j2)), DiscreteDomain.longs());
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public ContiguousSet<C> headSet(C c) {
        return mo3843m((Comparable) Preconditions.checkNotNull(c), false);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public ContiguousSet<C> subSet(C c, C c2) {
        Preconditions.checkNotNull(c);
        Preconditions.checkNotNull(c2);
        Preconditions.checkArgument(comparator().compare(c, c2) <= 0);
        return mo3844n(c, true, c2, false);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public ContiguousSet<C> tailSet(C c) {
        return mo3845o((Comparable) Preconditions.checkNotNull(c), true);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public ContiguousSet<C> headSet(C c, boolean z) {
        return mo3843m((Comparable) Preconditions.checkNotNull(c), z);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public ContiguousSet<C> tailSet(C c, boolean z) {
        return mo3845o((Comparable) Preconditions.checkNotNull(c), z);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public ContiguousSet<C> subSet(C c, boolean z, C c2, boolean z2) {
        Preconditions.checkNotNull(c);
        Preconditions.checkNotNull(c2);
        Preconditions.checkArgument(comparator().compare(c, c2) <= 0);
        return mo3844n(c, z, c2, z2);
    }
}
