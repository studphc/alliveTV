package p000;

import com.google.common.collect.BoundType;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class u31 extends ImmutableSortedSet {

    /* renamed from: e */
    public final DiscreteDomain f27080e;

    /* renamed from: f */
    public transient Integer f27081f;

    /* renamed from: g */
    public final /* synthetic */ ImmutableRangeSet f27082g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u31(ImmutableRangeSet immutableRangeSet, DiscreteDomain discreteDomain) {
        super(Ordering.natural());
        this.f27082g = immutableRangeSet;
        this.f27080e = discreteDomain;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.f27082g.contains((Comparable) obj);
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final UnmodifiableIterator descendingIterator() {
        return new t31(this, 1);
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return this.f27082g.f14692a.mo7e();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final UnmodifiableIterator iterator() {
        return new t31(this, 0);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: k */
    public final ImmutableSortedSet mo3842k() {
        return new i20(this);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: m */
    public final ImmutableSortedSet mo3843m(Object obj, boolean z) {
        return this.f27082g.subRangeSet(Range.upTo((Comparable) obj, BoundType.m3833a(z))).asSet(this.f27080e);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: n */
    public final ImmutableSortedSet mo3844n(Object obj, boolean z, Object obj2, boolean z2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        if (!z && !z2) {
            Range range = Range.f14746c;
            if (comparable.compareTo(comparable2) == 0) {
                return ImmutableSortedSet.m4016of();
            }
        }
        return this.f27082g.subRangeSet(Range.range(comparable, BoundType.m3833a(z), comparable2, BoundType.m3833a(z2))).asSet(this.f27080e);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: o */
    public final ImmutableSortedSet mo3845o(Object obj, boolean z) {
        return this.f27082g.subRangeSet(Range.downTo((Comparable) obj, BoundType.m3833a(z))).asSet(this.f27080e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        Integer num = this.f27081f;
        if (num == null) {
            UnmodifiableIterator it = this.f27082g.f14692a.iterator();
            long j = 0;
            while (it.hasNext()) {
                j += ContiguousSet.create((Range) it.next(), this.f27080e).size();
                if (j >= 2147483647L) {
                    break;
                }
            }
            num = Integer.valueOf(Ints.saturatedCast(j));
            this.f27081f = num;
        }
        return num.intValue();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return this.f27082g.f14692a.toString();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new v31(this.f27082g.f14692a, this.f27080e);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public final Iterator descendingIterator() {
        return new t31(this, 1);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new t31(this, 0);
    }
}
