package com.google.common.collect;

/* renamed from: com.google.common.collect.t */
/* loaded from: classes.dex */
public final class C0933t extends AbstractC0955y1 {

    /* renamed from: a */
    public final /* synthetic */ int f14962a;

    /* renamed from: b */
    public final /* synthetic */ C0937u f14963b;

    public C0933t(C0937u c0937u, int i) {
        this.f14963b = c0937u;
        this.f14962a = i;
    }

    @Override // com.google.common.collect.Multiset.Entry
    public final int getCount() {
        return this.f14963b.f14968d.f14632e[this.f14962a];
    }

    @Override // com.google.common.collect.Multiset.Entry
    public final Object getElement() {
        return this.f14963b.f14968d.f14631d[this.f14962a];
    }
}
