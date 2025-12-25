package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Table;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* renamed from: com.google.common.collect.a3 */
/* loaded from: classes.dex */
public final class C0845a3 extends AbstractC0919p2 {

    /* renamed from: g */
    public static final C0845a3 f14768g = new C0845a3(ImmutableList.m3902of(), ImmutableSet.m3971of(), ImmutableSet.m3971of());

    /* renamed from: c */
    public final ImmutableMap f14769c;

    /* renamed from: d */
    public final ImmutableMap f14770d;

    /* renamed from: e */
    public final int[] f14771e;

    /* renamed from: f */
    public final int[] f14772f;

    /* JADX WARN: Multi-variable type inference failed */
    public C0845a3(ImmutableList immutableList, ImmutableSet immutableSet, ImmutableSet immutableSet2) {
        ImmutableMap m4049e = Maps.m4049e(immutableSet);
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        UnmodifiableIterator it = immutableSet.iterator();
        while (it.hasNext()) {
            newLinkedHashMap.put(it.next(), new LinkedHashMap());
        }
        LinkedHashMap newLinkedHashMap2 = Maps.newLinkedHashMap();
        UnmodifiableIterator it2 = immutableSet2.iterator();
        while (it2.hasNext()) {
            newLinkedHashMap2.put(it2.next(), new LinkedHashMap());
        }
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i = 0; i < immutableList.size(); i++) {
            Table.Cell cell = (Table.Cell) immutableList.get(i);
            Object rowKey = cell.getRowKey();
            Object columnKey = cell.getColumnKey();
            Object value = cell.getValue();
            Integer num = (Integer) m4049e.get(rowKey);
            Objects.requireNonNull(num);
            iArr[i] = num.intValue();
            Map map = (Map) newLinkedHashMap.get(rowKey);
            Objects.requireNonNull(map);
            iArr2[i] = map.size();
            AbstractC0919p2.m4156i(rowKey, columnKey, map.put(columnKey, value), value);
            Map map2 = (Map) newLinkedHashMap2.get(columnKey);
            Objects.requireNonNull(map2);
            map2.put(rowKey, value);
        }
        this.f14771e = iArr;
        this.f14772f = iArr2;
        ImmutableMap.Builder builder = new ImmutableMap.Builder(newLinkedHashMap.size());
        for (Map.Entry entry : newLinkedHashMap.entrySet()) {
            builder.put(entry.getKey(), ImmutableMap.copyOf((Map) entry.getValue()));
        }
        this.f14769c = builder.buildOrThrow();
        ImmutableMap.Builder builder2 = new ImmutableMap.Builder(newLinkedHashMap2.size());
        for (Map.Entry entry2 : newLinkedHashMap2.entrySet()) {
            builder2.put(entry2.getKey(), ImmutableMap.copyOf((Map) entry2.getValue()));
        }
        this.f14770d = builder2.buildOrThrow();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public final ImmutableMap columnMap() {
        return ImmutableMap.copyOf((Map) this.f14770d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableTable
    /* renamed from: g */
    public final C0902m0 mo4029g() {
        ImmutableMap m4049e = Maps.m4049e(columnKeySet());
        int[] iArr = new int[cellSet().size()];
        UnmodifiableIterator it = cellSet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Integer num = (Integer) m4049e.get(((Table.Cell) it.next()).getColumnKey());
            Objects.requireNonNull(num);
            iArr[i] = num.intValue();
            i++;
        }
        return C0902m0.m4134a(this, this.f14771e, iArr);
    }

    @Override // com.google.common.collect.AbstractC0919p2
    /* renamed from: k */
    public final Table.Cell mo4082k(int i) {
        Map.Entry entry = (Map.Entry) this.f14769c.entrySet().asList().get(this.f14771e[i]);
        ImmutableMap immutableMap = (ImmutableMap) entry.getValue();
        Map.Entry entry2 = (Map.Entry) immutableMap.entrySet().asList().get(this.f14772f[i]);
        return ImmutableTable.m4023e(entry.getKey(), entry2.getKey(), entry2.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractC0919p2
    /* renamed from: l */
    public final Object mo4083l(int i) {
        ImmutableMap immutableMap = (ImmutableMap) this.f14769c.values().asList().get(this.f14771e[i]);
        return immutableMap.values().asList().get(this.f14772f[i]);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public final ImmutableMap rowMap() {
        return ImmutableMap.copyOf((Map) this.f14769c);
    }

    @Override // com.google.common.collect.Table
    public final int size() {
        return this.f14771e.length;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public final Map columnMap() {
        return ImmutableMap.copyOf((Map) this.f14770d);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public final Map rowMap() {
        return ImmutableMap.copyOf((Map) this.f14769c);
    }
}
