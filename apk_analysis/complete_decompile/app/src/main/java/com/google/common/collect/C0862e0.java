package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Multiset;
import p000.h41;
import p000.m31;

/* renamed from: com.google.common.collect.e0 */
/* loaded from: classes.dex */
public final class C0862e0 extends h41 {
    private static final long serialVersionUID = 0;

    /* renamed from: c */
    public final /* synthetic */ ImmutableMultiset f14808c;

    public C0862e0(ImmutableMultiset immutableMultiset) {
        this.f14808c = immutableMultiset;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (!(obj instanceof Multiset.Entry)) {
            return false;
        }
        Multiset.Entry entry = (Multiset.Entry) obj;
        if (entry.getCount() <= 0 || this.f14808c.count(entry.getElement()) != entry.getCount()) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return this.f14808c.mo7e();
    }

    @Override // p000.h41
    public final Object get(int i) {
        return this.f14808c.mo3962g(i);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f14808c.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f14808c.elementSet().size();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public Object writeReplace() {
        return new m31(this.f14808c);
    }
}
