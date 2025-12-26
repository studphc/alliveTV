package com.google.common.collect;

import com.google.common.collect.Multiset;

/* renamed from: com.google.common.collect.q */
/* loaded from: classes.dex */
public final class C0921q extends ImmutableSortedMultiset {

    /* renamed from: f */
    public final transient ImmutableSortedMultiset f14940f;

    public C0921q(ImmutableSortedMultiset immutableSortedMultiset) {
        this.f14940f = immutableSortedMultiset;
    }

    @Override // com.google.common.collect.Multiset
    public final int count(Object obj) {
        return this.f14940f.count(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public final SortedMultiset descendingMultiset() {
        return this.f14940f;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return this.f14940f.mo7e();
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry firstEntry() {
        return this.f14940f.lastEntry();
    }

    @Override // com.google.common.collect.ImmutableMultiset
    /* renamed from: g */
    public final Multiset.Entry mo3962g(int i) {
        return (Multiset.Entry) this.f14940f.entrySet().asList().reverse().get(i);
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry lastEntry() {
        return this.f14940f.firstEntry();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final int size() {
        return this.f14940f.size();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public final ImmutableSortedMultiset descendingMultiset() {
        return this.f14940f;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public final ImmutableSortedMultiset headMultiset(Object obj, BoundType boundType) {
        return this.f14940f.tailMultiset((ImmutableSortedMultiset) obj, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public final ImmutableSortedMultiset tailMultiset(Object obj, BoundType boundType) {
        return this.f14940f.headMultiset((ImmutableSortedMultiset) obj, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public final ImmutableSortedSet elementSet() {
        return this.f14940f.elementSet().descendingSet();
    }
}
