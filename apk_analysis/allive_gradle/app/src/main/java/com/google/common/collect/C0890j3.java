package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.common.collect.j3 */
/* loaded from: classes.dex */
public final class C0890j3 extends AbstractC0881i {

    /* renamed from: d */
    public static final C0885i3 f14858d = new Object();

    /* renamed from: c */
    public final Table f14859c;

    public C0890j3(Table table) {
        this.f14859c = (Table) Preconditions.checkNotNull(table);
    }

    @Override // com.google.common.collect.AbstractC0881i
    /* renamed from: a */
    public final Iterator mo3830a() {
        return Iterators.transform(this.f14859c.cellSet().iterator(), f14858d);
    }

    @Override // com.google.common.collect.Table
    public final void clear() {
        this.f14859c.clear();
    }

    @Override // com.google.common.collect.Table
    public final Map column(Object obj) {
        return this.f14859c.row(obj);
    }

    @Override // com.google.common.collect.Table
    public final Set columnKeySet() {
        return this.f14859c.rowKeySet();
    }

    @Override // com.google.common.collect.Table
    public final Map columnMap() {
        return this.f14859c.rowMap();
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public final boolean contains(Object obj, Object obj2) {
        return this.f14859c.contains(obj2, obj);
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public final boolean containsColumn(Object obj) {
        return this.f14859c.containsRow(obj);
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public final boolean containsRow(Object obj) {
        return this.f14859c.containsColumn(obj);
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public final boolean containsValue(Object obj) {
        return this.f14859c.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public final Object get(Object obj, Object obj2) {
        return this.f14859c.get(obj2, obj);
    }

    @Override // com.google.common.collect.Table
    public final Object put(Object obj, Object obj2, Object obj3) {
        return this.f14859c.put(obj2, obj, obj3);
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public final void putAll(Table table) {
        this.f14859c.putAll(Tables.transpose(table));
    }

    @Override // com.google.common.collect.Table
    public final Object remove(Object obj, Object obj2) {
        return this.f14859c.remove(obj2, obj);
    }

    @Override // com.google.common.collect.Table
    public final Map row(Object obj) {
        return this.f14859c.column(obj);
    }

    @Override // com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public final Set rowKeySet() {
        return this.f14859c.columnKeySet();
    }

    @Override // com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public final Map rowMap() {
        return this.f14859c.columnMap();
    }

    @Override // com.google.common.collect.Table
    public final int size() {
        return this.f14859c.size();
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public final Collection values() {
        return this.f14859c.values();
    }
}
