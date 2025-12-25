package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.en2;
import p000.ez0;
import p000.ig1;
import p000.p63;

@GwtCompatible(serializable = true)
/* loaded from: classes.dex */
public class HashBasedTable<R, C, V> extends C0855c3 {
    private static final long serialVersionUID = 0;

    public static <R, C, V> HashBasedTable<R, C, V> create() {
        return (HashBasedTable<R, C, V>) new C0855c3(new LinkedHashMap(), new ez0(0));
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.Table
    public Map column(Object obj) {
        return new ig1(this, obj);
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.contains(obj, obj2);
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsColumn(@CheckForNull Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsRow(@CheckForNull Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsValue(@CheckForNull Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    @CheckForNull
    public /* bridge */ /* synthetic */ Object get(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public boolean isEmpty() {
        return this.f14788c.isEmpty();
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.Table
    @CanIgnoreReturnValue
    @CheckForNull
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2, Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ void putAll(Table table) {
        super.putAll(table);
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.Table
    @CanIgnoreReturnValue
    @CheckForNull
    public /* bridge */ /* synthetic */ Object remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.Table
    public Map row(Object obj) {
        return new en2(this, obj);
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public /* bridge */ /* synthetic */ Map rowMap() {
        return super.rowMap();
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.AbstractC0881i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <R, C, V> HashBasedTable<R, C, V> create(int i, int i2) {
        p63.m6869m(i2, "expectedCellsPerRow");
        return (HashBasedTable<R, C, V>) new C0855c3(Maps.newLinkedHashMapWithExpectedSize(i), new ez0(i2));
    }

    public static <R, C, V> HashBasedTable<R, C, V> create(Table<? extends R, ? extends C, ? extends V> table) {
        HashBasedTable<R, C, V> create = create();
        create.putAll(table);
        return create;
    }
}
