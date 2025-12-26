package com.google.common.collect;

import com.google.common.math.IntMath;
import java.util.Iterator;
import java.util.Set;
import p000.kq1;

/* renamed from: com.google.common.collect.t1 */
/* loaded from: classes.dex */
public final class C0935t1 extends kq1 {

    /* renamed from: c */
    public final /* synthetic */ Multiset f14964c;

    /* renamed from: d */
    public final /* synthetic */ Multiset f14965d;

    public C0935t1(Multiset multiset, Multiset multiset2) {
        this.f14964c = multiset;
        this.f14965d = multiset2;
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: a */
    public final Set mo3837a() {
        return Sets.union(this.f14964c.elementSet(), this.f14965d.elementSet());
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: c */
    public final Iterator mo3839c() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractC0856d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final boolean contains(Object obj) {
        if (!this.f14964c.contains(obj) && !this.f14965d.contains(obj)) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.collect.Multiset
    public final int count(Object obj) {
        return this.f14965d.count(obj) + this.f14964c.count(obj);
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: d */
    public final Iterator mo3840d() {
        return new C0931s1(this, this.f14964c.entrySet().iterator(), this.f14965d.entrySet().iterator());
    }

    @Override // com.google.common.collect.AbstractC0856d, java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        if (this.f14964c.isEmpty() && this.f14965d.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // p000.kq1, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final int size() {
        return IntMath.saturatedAdd(this.f14964c.size(), this.f14965d.size());
    }
}
