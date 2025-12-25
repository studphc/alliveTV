package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* renamed from: com.google.common.collect.m2 */
/* loaded from: classes.dex */
public final class C0904m2 extends ImmutableSortedMultiset {

    /* renamed from: j */
    public static final long[] f14890j = {0};

    /* renamed from: k */
    public static final C0904m2 f14891k = new C0904m2(Ordering.natural());

    /* renamed from: f */
    public final transient C0909n2 f14892f;

    /* renamed from: g */
    public final transient long[] f14893g;

    /* renamed from: h */
    public final transient int f14894h;

    /* renamed from: i */
    public final transient int f14895i;

    public C0904m2(C0909n2 c0909n2, long[] jArr, int i, int i2) {
        this.f14892f = c0909n2;
        this.f14893g = jArr;
        this.f14894h = i;
        this.f14895i = i2;
    }

    @Override // com.google.common.collect.Multiset
    public final int count(Object obj) {
        int indexOf = this.f14892f.indexOf(obj);
        if (indexOf >= 0) {
            int i = this.f14894h + indexOf;
            long[] jArr = this.f14893g;
            return (int) (jArr[i + 1] - jArr[i]);
        }
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        if (this.f14894h > 0) {
            return true;
        }
        if (this.f14895i < this.f14893g.length - 1) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public final ImmutableSet elementSet() {
        return this.f14892f;
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return mo3962g(0);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    /* renamed from: g */
    public final Multiset.Entry mo3962g(int i) {
        E e = this.f14892f.asList().get(i);
        int i2 = this.f14894h + i;
        long[] jArr = this.f14893g;
        return Multisets.immutableEntry(e, (int) (jArr[i2 + 1] - jArr[i2]));
    }

    /* renamed from: j */
    public final C0904m2 m4135j(int i, int i2) {
        int i3 = this.f14895i;
        Preconditions.checkPositionIndexes(i, i2, i3);
        if (i == i2) {
            return ImmutableSortedMultiset.m4005i(comparator());
        }
        if (i == 0 && i2 == i3) {
            return this;
        }
        return new C0904m2(this.f14892f.m4136p(i, i2), this.f14893g, this.f14894h + i, i2 - i);
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return mo3962g(this.f14895i - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final int size() {
        int i = this.f14895i;
        int i2 = this.f14894h;
        long[] jArr = this.f14893g;
        return Ints.saturatedCast(jArr[i + i2] - jArr[i2]);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public final NavigableSet elementSet() {
        return this.f14892f;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public final ImmutableSortedMultiset headMultiset(Object obj, BoundType boundType) {
        return m4135j(0, this.f14892f.m4137q(obj, Preconditions.checkNotNull(boundType) == BoundType.CLOSED));
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public final ImmutableSortedMultiset tailMultiset(Object obj, BoundType boundType) {
        return m4135j(this.f14892f.m4138r(obj, Preconditions.checkNotNull(boundType) == BoundType.CLOSED), this.f14895i);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public final Set elementSet() {
        return this.f14892f;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public final SortedSet elementSet() {
        return this.f14892f;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public final ImmutableSortedSet elementSet() {
        return this.f14892f;
    }

    public C0904m2(Comparator comparator) {
        this.f14892f = ImmutableSortedSet.m4015l(comparator);
        this.f14893g = f14890j;
        this.f14894h = 0;
        this.f14895i = 0;
    }
}
