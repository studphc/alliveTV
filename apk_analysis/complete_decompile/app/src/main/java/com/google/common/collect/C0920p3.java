package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* renamed from: com.google.common.collect.p3 */
/* loaded from: classes.dex */
public final class C0920p3 extends C0864e2 implements SortedMultiset {
    private static final long serialVersionUID = 0;

    /* renamed from: d */
    public transient C0920p3 f14939d;

    @Override // com.google.common.collect.SortedMultiset, p000.fl2
    public final Comparator comparator() {
        return ((SortedMultiset) this.f14811a).comparator();
    }

    @Override // com.google.common.collect.C0864e2, com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Multiset delegate() {
        return (SortedMultiset) this.f14811a;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.common.collect.e2, com.google.common.collect.SortedMultiset, com.google.common.collect.p3] */
    @Override // com.google.common.collect.SortedMultiset
    public final SortedMultiset descendingMultiset() {
        C0920p3 c0920p3 = this.f14939d;
        if (c0920p3 == null) {
            ?? c0864e2 = new C0864e2(((SortedMultiset) this.f14811a).descendingMultiset());
            c0864e2.f14939d = this;
            this.f14939d = c0864e2;
            return c0864e2;
        }
        return c0920p3;
    }

    @Override // com.google.common.collect.C0864e2
    /* renamed from: e */
    public final Set mo4088e() {
        return Sets.unmodifiableNavigableSet(((SortedMultiset) this.f14811a).elementSet());
    }

    @Override // com.google.common.collect.C0864e2, com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public final NavigableSet elementSet() {
        return (NavigableSet) super.elementSet();
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry firstEntry() {
        return ((SortedMultiset) this.f14811a).firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public final SortedMultiset headMultiset(Object obj, BoundType boundType) {
        return Multisets.unmodifiableSortedMultiset(((SortedMultiset) this.f14811a).headMultiset(obj, boundType));
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry lastEntry() {
        return ((SortedMultiset) this.f14811a).lastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    public final SortedMultiset subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return Multisets.unmodifiableSortedMultiset(((SortedMultiset) this.f14811a).subMultiset(obj, boundType, obj2, boundType2));
    }

    @Override // com.google.common.collect.SortedMultiset
    public final SortedMultiset tailMultiset(Object obj, BoundType boundType) {
        return Multisets.unmodifiableSortedMultiset(((SortedMultiset) this.f14811a).tailMultiset(obj, boundType));
    }

    @Override // com.google.common.collect.C0864e2, com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Object delegate() {
        return (SortedMultiset) this.f14811a;
    }

    @Override // com.google.common.collect.C0864e2, com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public final Set elementSet() {
        return (NavigableSet) super.elementSet();
    }

    @Override // com.google.common.collect.C0864e2, com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Collection delegate() {
        return (SortedMultiset) this.f14811a;
    }

    @Override // com.google.common.collect.C0864e2, com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public final SortedSet elementSet() {
        return (NavigableSet) super.elementSet();
    }
}
