package com.google.common.collect;

import java.util.Iterator;

/* renamed from: com.google.common.collect.r */
/* loaded from: classes.dex */
public final class C0925r extends AbstractC0844a2 {

    /* renamed from: a */
    public final /* synthetic */ AbstractC0929s f14944a;

    public C0925r(AbstractC0929s abstractC0929s) {
        this.f14944a = abstractC0929s;
    }

    @Override // com.google.common.collect.AbstractC0844a2
    /* renamed from: d */
    public final Multiset mo4081d() {
        return this.f14944a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return this.f14944a.entryIterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f14944a.mo3862e().entrySet().size();
    }
}
