package com.google.common.collect;

/* renamed from: com.google.common.collect.k */
/* loaded from: classes.dex */
public final class C0891k extends AbstractC0870f3 {

    /* renamed from: a */
    public final int f14860a;

    /* renamed from: b */
    public final int f14861b;

    /* renamed from: c */
    public final /* synthetic */ ArrayTable f14862c;

    public C0891k(ArrayTable arrayTable, int i) {
        this.f14862c = arrayTable;
        this.f14860a = i / arrayTable.f14614d.size();
        this.f14861b = i % arrayTable.f14614d.size();
    }

    @Override // com.google.common.collect.Table.Cell
    public final Object getColumnKey() {
        return this.f14862c.f14614d.get(this.f14861b);
    }

    @Override // com.google.common.collect.Table.Cell
    public final Object getRowKey() {
        return this.f14862c.f14613c.get(this.f14860a);
    }

    @Override // com.google.common.collect.Table.Cell
    public final Object getValue() {
        return this.f14862c.m3831at(this.f14860a, this.f14861b);
    }
}
