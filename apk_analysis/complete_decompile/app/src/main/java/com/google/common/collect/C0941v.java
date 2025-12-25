package com.google.common.collect;

import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Iterator;
import p000.m10;

/* renamed from: com.google.common.collect.v */
/* loaded from: classes.dex */
public final class C0941v extends AbstractC0844a2 {

    /* renamed from: a */
    public final /* synthetic */ C0945w f14975a;

    public C0941v(C0945w c0945w) {
        this.f14975a = c0945w;
    }

    @Override // com.google.common.collect.AbstractC0844a2
    /* renamed from: d */
    public final Multiset mo4081d() {
        return this.f14975a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return this.f14975a.mo3840d();
    }

    @Override // p000.oh2, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        return this.f14975a.f14980d.m6138j(new m10(1, Predicates.m3777in(collection)));
    }

    @Override // p000.oh2, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        return this.f14975a.f14980d.m6138j(new m10(1, Predicates.not(Predicates.m3777in(collection))));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f14975a.f14980d.keySet().size();
    }
}
