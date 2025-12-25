package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;

/* renamed from: com.google.common.collect.w2 */
/* loaded from: classes.dex */
public final class C0948w2 extends ImmutableTable {

    /* renamed from: c */
    public final Object f14983c;

    /* renamed from: d */
    public final Object f14984d;

    /* renamed from: e */
    public final Object f14985e;

    public C0948w2(Object obj, Object obj2, Object obj3) {
        this.f14983c = Preconditions.checkNotNull(obj);
        this.f14984d = Preconditions.checkNotNull(obj2);
        this.f14985e = Preconditions.checkNotNull(obj3);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractC0881i
    /* renamed from: c */
    public final Collection mo4027c() {
        return ImmutableSet.m3972of(this.f14985e);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractC0881i
    /* renamed from: f */
    public final ImmutableSet mo4026b() {
        return ImmutableSet.m3972of(ImmutableTable.m4023e(this.f14983c, this.f14984d, this.f14985e));
    }

    @Override // com.google.common.collect.ImmutableTable
    /* renamed from: g */
    public final C0902m0 mo4029g() {
        return C0902m0.m4134a(this, new int[]{0}, new int[]{0});
    }

    @Override // com.google.common.collect.ImmutableTable
    /* renamed from: h */
    public final ImmutableCollection mo4027c() {
        return ImmutableSet.m3972of(this.f14985e);
    }

    @Override // com.google.common.collect.Table
    public final int size() {
        return 1;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public final ImmutableMap column(Object obj) {
        Preconditions.checkNotNull(obj);
        if (containsColumn(obj)) {
            return ImmutableMap.m3924of(this.f14983c, this.f14985e);
        }
        return ImmutableMap.m3923of();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public final ImmutableMap columnMap() {
        return ImmutableMap.m3924of(this.f14984d, ImmutableMap.m3924of(this.f14983c, this.f14985e));
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public final ImmutableMap rowMap() {
        return ImmutableMap.m3924of(this.f14983c, ImmutableMap.m3924of(this.f14984d, this.f14985e));
    }
}
