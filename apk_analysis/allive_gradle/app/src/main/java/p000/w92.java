package p000;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.Collections2;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes.dex */
public final class w92 extends ContiguousSet {
    private static final long serialVersionUID = 0;

    /* renamed from: f */
    public final Range f28107f;

    public w92(Range range, DiscreteDomain discreteDomain) {
        super(discreteDomain);
        this.f28107f = range;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.f28107f.contains((Comparable) obj);
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        return Collections2.m3835b(this, collection);
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof w92) {
            w92 w92Var = (w92) obj;
            if (this.f14625e.equals(w92Var.f14625e)) {
                if (first().equals(w92Var.first()) && last().equals(w92Var.last())) {
                    return true;
                }
                return false;
            }
        }
        return super.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableSet
    /* renamed from: h */
    public final ImmutableList mo3978h() {
        if (this.f14625e.f14626a) {
            return new u92(this);
        }
        return super.mo3978h();
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return Sets.m4070b(this);
    }

    @Override // com.google.common.collect.ContiguousSet
    public final ContiguousSet intersection(ContiguousSet contiguousSet) {
        Preconditions.checkNotNull(contiguousSet);
        DiscreteDomain discreteDomain = contiguousSet.f14625e;
        DiscreteDomain discreteDomain2 = this.f14625e;
        Preconditions.checkArgument(discreteDomain2.equals(discreteDomain));
        if (contiguousSet.isEmpty()) {
            return contiguousSet;
        }
        Comparable comparable = (Comparable) Ordering.natural().max(first(), (Comparable) contiguousSet.first());
        Comparable comparable2 = (Comparable) Ordering.natural().min(last(), (Comparable) contiguousSet.last());
        if (comparable.compareTo(comparable2) <= 0) {
            return ContiguousSet.create(Range.closed(comparable, comparable2), discreteDomain2);
        }
        return new ContiguousSet(discreteDomain2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final ContiguousSet mo3843m(Comparable comparable, boolean z) {
        return m8013t(Range.upTo(comparable, BoundType.m3833a(z)));
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public final ContiguousSet mo3844n(Comparable comparable, boolean z, Comparable comparable2, boolean z2) {
        if (comparable.compareTo(comparable2) == 0 && !z && !z2) {
            return new ContiguousSet(this.f14625e);
        }
        return m8013t(Range.range(comparable, BoundType.m3833a(z), comparable2, BoundType.m3833a(z2)));
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public final ContiguousSet mo3845o(Comparable comparable, boolean z) {
        return m8013t(Range.downTo(comparable, BoundType.m3833a(z)));
    }

    @Override // com.google.common.collect.ContiguousSet
    public final Range range() {
        BoundType boundType = BoundType.CLOSED;
        return range(boundType, boundType);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final Comparable first() {
        Comparable mo6742i = this.f28107f.f14747a.mo6742i(this.f14625e);
        Objects.requireNonNull(mo6742i);
        return mo6742i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        long distance = this.f14625e.distance(first(), last());
        if (distance >= 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return ((int) distance) + 1;
    }

    /* renamed from: t */
    public final ContiguousSet m8013t(Range range) {
        Range range2 = this.f28107f;
        boolean isConnected = range2.isConnected(range);
        DiscreteDomain discreteDomain = this.f14625e;
        if (isConnected) {
            return ContiguousSet.create(range2.intersection(range), discreteDomain);
        }
        return new ContiguousSet(discreteDomain);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public final Comparable last() {
        Comparable mo6740g = this.f28107f.f14748b.mo6740g(this.f14625e);
        Objects.requireNonNull(mo6740g);
        return mo6740g;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public Object writeReplace() {
        return new v92(this.f28107f, this.f14625e);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final UnmodifiableIterator descendingIterator() {
        return new t92(this, last(), 1);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final UnmodifiableIterator iterator() {
        return new t92(this, first(), 0);
    }

    @Override // com.google.common.collect.ContiguousSet
    public final Range range(BoundType boundType, BoundType boundType2) {
        Range range = this.f28107f;
        AbstractC1814sx abstractC1814sx = range.f14747a;
        DiscreteDomain discreteDomain = this.f14625e;
        return new Range(abstractC1814sx.mo6745l(boundType, discreteDomain), range.f14748b.mo6746m(boundType2, discreteDomain));
    }
}
