package com.google.common.collect;

import java.util.Iterator;
import p000.kq1;

/* renamed from: com.google.common.collect.w1 */
/* loaded from: classes.dex */
public final class C0947w1 extends kq1 {

    /* renamed from: c */
    public final /* synthetic */ Multiset f14981c;

    /* renamed from: d */
    public final /* synthetic */ Multiset f14982d;

    public C0947w1(Multiset multiset, Multiset multiset2) {
        this.f14981c = multiset;
        this.f14982d = multiset2;
    }

    @Override // p000.kq1, com.google.common.collect.AbstractC0856d
    /* renamed from: b */
    public final int mo3838b() {
        return Iterators.size(mo3840d());
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: c */
    public final Iterator mo3839c() {
        return new C0939u1(this, this.f14981c.entrySet().iterator());
    }

    @Override // p000.kq1, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    public final int count(Object obj) {
        int count = this.f14981c.count(obj);
        if (count == 0) {
            return 0;
        }
        return Math.max(0, count - this.f14982d.count(obj));
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: d */
    public final Iterator mo3840d() {
        return new C0943v1(this, this.f14981c.entrySet().iterator());
    }
}
