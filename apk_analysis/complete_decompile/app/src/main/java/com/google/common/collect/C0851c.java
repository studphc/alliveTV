package com.google.common.collect;

import java.util.Iterator;

/* renamed from: com.google.common.collect.c */
/* loaded from: classes.dex */
public class C0851c extends AbstractC0844a2 {

    /* renamed from: a */
    public final /* synthetic */ AbstractC0856d f14782a;

    public C0851c(AbstractC0856d abstractC0856d) {
        this.f14782a = abstractC0856d;
    }

    @Override // com.google.common.collect.AbstractC0844a2
    /* renamed from: d */
    public Multiset mo4081d() {
        return this.f14782a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return this.f14782a.mo3840d();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f14782a.mo3838b();
    }
}
