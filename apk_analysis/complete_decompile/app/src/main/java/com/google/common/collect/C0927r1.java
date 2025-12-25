package com.google.common.collect;

import java.util.Iterator;
import java.util.Set;
import p000.kq1;

/* renamed from: com.google.common.collect.r1 */
/* loaded from: classes.dex */
public final class C0927r1 extends kq1 {

    /* renamed from: c */
    public final /* synthetic */ Multiset f14946c;

    /* renamed from: d */
    public final /* synthetic */ Multiset f14947d;

    public C0927r1(Multiset multiset, Multiset multiset2) {
        this.f14946c = multiset;
        this.f14947d = multiset2;
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: a */
    public final Set mo3837a() {
        return Sets.intersection(this.f14946c.elementSet(), this.f14947d.elementSet());
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: c */
    public final Iterator mo3839c() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.Multiset
    public final int count(Object obj) {
        int count = this.f14946c.count(obj);
        if (count == 0) {
            return 0;
        }
        return Math.min(count, this.f14947d.count(obj));
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: d */
    public final Iterator mo3840d() {
        return new C0923q1(this, this.f14946c.entrySet().iterator());
    }
}
