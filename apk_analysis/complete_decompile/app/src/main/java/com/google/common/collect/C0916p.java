package com.google.common.collect;

import com.google.common.collect.Table;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.Objects;
import p000.f20;

/* renamed from: com.google.common.collect.p */
/* loaded from: classes.dex */
public final class C0916p extends AbstractC0919p2 {

    /* renamed from: c */
    public final ImmutableMap f14926c;

    /* renamed from: d */
    public final ImmutableMap f14927d;

    /* renamed from: e */
    public final f20 f14928e;

    /* renamed from: f */
    public final f20 f14929f;

    /* renamed from: g */
    public final int[] f14930g;

    /* renamed from: h */
    public final int[] f14931h;

    /* renamed from: i */
    public final Object[][] f14932i;

    /* renamed from: j */
    public final int[] f14933j;

    /* renamed from: k */
    public final int[] f14934k;

    public C0916p(ImmutableList immutableList, ImmutableSet immutableSet, ImmutableSet immutableSet2) {
        this.f14932i = (Object[][]) Array.newInstance((Class<?>) Object.class, immutableSet.size(), immutableSet2.size());
        ImmutableMap m4049e = Maps.m4049e(immutableSet);
        this.f14926c = m4049e;
        ImmutableMap m4049e2 = Maps.m4049e(immutableSet2);
        this.f14927d = m4049e2;
        this.f14930g = new int[m4049e.size()];
        this.f14931h = new int[m4049e2.size()];
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i = 0; i < immutableList.size(); i++) {
            Table.Cell cell = (Table.Cell) immutableList.get(i);
            Object rowKey = cell.getRowKey();
            Object columnKey = cell.getColumnKey();
            Integer num = (Integer) this.f14926c.get(rowKey);
            Objects.requireNonNull(num);
            int intValue = num.intValue();
            Integer num2 = (Integer) this.f14927d.get(columnKey);
            Objects.requireNonNull(num2);
            int intValue2 = num2.intValue();
            AbstractC0919p2.m4156i(rowKey, columnKey, this.f14932i[intValue][intValue2], cell.getValue());
            this.f14932i[intValue][intValue2] = cell.getValue();
            int[] iArr3 = this.f14930g;
            iArr3[intValue] = iArr3[intValue] + 1;
            int[] iArr4 = this.f14931h;
            iArr4[intValue2] = iArr4[intValue2] + 1;
            iArr[i] = intValue;
            iArr2[i] = intValue2;
        }
        this.f14933j = iArr;
        this.f14934k = iArr2;
        this.f14928e = new f20(this, 1);
        this.f14929f = new f20(this, 0);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public final ImmutableMap columnMap() {
        return ImmutableMap.copyOf((Map) this.f14929f);
    }

    @Override // com.google.common.collect.ImmutableTable
    /* renamed from: g */
    public final C0902m0 mo4029g() {
        return C0902m0.m4134a(this, this.f14933j, this.f14934k);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public final Object get(Object obj, Object obj2) {
        Integer num = (Integer) this.f14926c.get(obj);
        Integer num2 = (Integer) this.f14927d.get(obj2);
        if (num != null && num2 != null) {
            return this.f14932i[num.intValue()][num2.intValue()];
        }
        return null;
    }

    @Override // com.google.common.collect.AbstractC0919p2
    /* renamed from: k */
    public final Table.Cell mo4082k(int i) {
        int i2 = this.f14933j[i];
        int i3 = this.f14934k[i];
        E e = rowKeySet().asList().get(i2);
        E e2 = columnKeySet().asList().get(i3);
        Object obj = this.f14932i[i2][i3];
        Objects.requireNonNull(obj);
        return ImmutableTable.m4023e(e, e2, obj);
    }

    @Override // com.google.common.collect.AbstractC0919p2
    /* renamed from: l */
    public final Object mo4083l(int i) {
        Object obj = this.f14932i[this.f14933j[i]][this.f14934k[i]];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public final ImmutableMap rowMap() {
        return ImmutableMap.copyOf((Map) this.f14928e);
    }

    @Override // com.google.common.collect.Table
    public final int size() {
        return this.f14933j.length;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public final Map columnMap() {
        return ImmutableMap.copyOf((Map) this.f14929f);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public final Map rowMap() {
        return ImmutableMap.copyOf((Map) this.f14928e);
    }
}
