package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import p000.ba2;
import p000.gt1;

/* renamed from: com.google.common.collect.k2 */
/* loaded from: classes.dex */
public final class C0894k2 extends ImmutableMultiset {

    /* renamed from: h */
    public static final C0894k2 f14866h = new C0894k2(new C0869f2());

    /* renamed from: e */
    public final transient C0869f2 f14867e;

    /* renamed from: f */
    public final transient int f14868f;

    /* renamed from: g */
    public transient ba2 f14869g;

    public C0894k2(C0869f2 c0869f2) {
        this.f14867e = c0869f2;
        long j = 0;
        for (int i = 0; i < c0869f2.f14821c; i++) {
            j += c0869f2.m4094f(i);
        }
        this.f14868f = Ints.saturatedCast(j);
    }

    @Override // com.google.common.collect.Multiset
    public final int count(Object obj) {
        return this.f14867e.m4092d(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMultiset
    /* renamed from: g */
    public final Multiset.Entry mo3962g(int i) {
        C0869f2 c0869f2 = this.f14867e;
        Preconditions.checkElementIndex(i, c0869f2.f14821c);
        return new gt1(c0869f2, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final int size() {
        return this.f14868f;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public Object writeReplace() {
        return new C0889j2(this);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public final ImmutableSet elementSet() {
        ba2 ba2Var = this.f14869g;
        if (ba2Var != null) {
            return ba2Var;
        }
        ba2 ba2Var2 = new ba2(this);
        this.f14869g = ba2Var2;
        return ba2Var2;
    }
}
