package com.google.common.collect;

import java.util.Iterator;
import java.util.Set;
import p000.kq1;

/* renamed from: com.google.common.collect.p1 */
/* loaded from: classes.dex */
public final class C0918p1 extends kq1 {

    /* renamed from: c */
    public final /* synthetic */ Multiset f14937c;

    /* renamed from: d */
    public final /* synthetic */ Multiset f14938d;

    public C0918p1(Multiset multiset, Multiset multiset2) {
        this.f14937c = multiset;
        this.f14938d = multiset2;
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: a */
    public final Set mo3837a() {
        return Sets.union(this.f14937c.elementSet(), this.f14938d.elementSet());
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: c */
    public final Iterator mo3839c() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractC0856d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final boolean contains(Object obj) {
        if (!this.f14937c.contains(obj) && !this.f14938d.contains(obj)) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.collect.Multiset
    public final int count(Object obj) {
        return Math.max(this.f14937c.count(obj), this.f14938d.count(obj));
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: d */
    public final Iterator mo3840d() {
        return new C0913o1(this, this.f14937c.entrySet().iterator(), this.f14938d.entrySet().iterator());
    }

    @Override // com.google.common.collect.AbstractC0856d, java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        if (this.f14937c.isEmpty() && this.f14938d.isEmpty()) {
            return true;
        }
        return false;
    }
}
