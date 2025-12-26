package com.google.common.collect;

import p000.AbstractC0002a1;

/* renamed from: com.google.common.collect.j */
/* loaded from: classes.dex */
public final class C0886j extends AbstractC0002a1 {

    /* renamed from: c */
    public final /* synthetic */ ArrayTable f14855c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0886j(ArrayTable arrayTable, int i) {
        super(i, 0);
        this.f14855c = arrayTable;
    }

    @Override // p000.AbstractC0002a1
    /* renamed from: a */
    public final Object mo1a(int i) {
        ArrayTable arrayTable = this.f14855c;
        arrayTable.getClass();
        return new C0891k(arrayTable, i);
    }
}
