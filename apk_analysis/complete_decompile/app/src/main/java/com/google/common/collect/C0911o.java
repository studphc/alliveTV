package com.google.common.collect;

import java.util.ArrayList;

/* renamed from: com.google.common.collect.o */
/* loaded from: classes.dex */
public final class C0911o extends C0851c {

    /* renamed from: b */
    public final /* synthetic */ ConcurrentHashMultiset f14911b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0911o(ConcurrentHashMultiset concurrentHashMultiset) {
        super(concurrentHashMultiset);
        this.f14911b = concurrentHashMultiset;
    }

    @Override // com.google.common.collect.C0851c, com.google.common.collect.AbstractC0844a2
    /* renamed from: d */
    public final Multiset mo4081d() {
        return this.f14911b;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        AbstractC0856d abstractC0856d = this.f14782a;
        ArrayList newArrayListWithExpectedSize = Lists.newArrayListWithExpectedSize(abstractC0856d.mo3838b());
        Iterators.addAll(newArrayListWithExpectedSize, abstractC0856d.mo3840d());
        return newArrayListWithExpectedSize.toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        AbstractC0856d abstractC0856d = this.f14782a;
        ArrayList newArrayListWithExpectedSize = Lists.newArrayListWithExpectedSize(abstractC0856d.mo3838b());
        Iterators.addAll(newArrayListWithExpectedSize, abstractC0856d.mo3840d());
        return newArrayListWithExpectedSize.toArray(objArr);
    }
}
