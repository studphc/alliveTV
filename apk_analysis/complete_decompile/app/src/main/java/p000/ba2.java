package p000;

import com.google.common.collect.C0894k2;

/* loaded from: classes.dex */
public final class ba2 extends h41 {

    /* renamed from: c */
    public final /* synthetic */ C0894k2 f7942c;

    public ba2(C0894k2 c0894k2) {
        this.f7942c = c0894k2;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f7942c.contains(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return true;
    }

    @Override // p000.h41
    public final Object get(int i) {
        return this.f7942c.f14867e.m4093e(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f7942c.f14867e.f14821c;
    }
}
