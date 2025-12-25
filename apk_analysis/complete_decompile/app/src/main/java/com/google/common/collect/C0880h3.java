package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p000.es2;

/* renamed from: com.google.common.collect.h3 */
/* loaded from: classes.dex */
public final class C0880h3 extends AbstractC0881i {

    /* renamed from: c */
    public final Table f14843c;

    /* renamed from: d */
    public final Function f14844d;

    public C0880h3(Table table, Function function) {
        this.f14843c = (Table) Preconditions.checkNotNull(table);
        this.f14844d = (Function) Preconditions.checkNotNull(function);
    }

    @Override // com.google.common.collect.AbstractC0881i
    /* renamed from: a */
    public final Iterator mo3830a() {
        return Iterators.transform(this.f14843c.cellSet().iterator(), new C0875g3(this));
    }

    @Override // com.google.common.collect.AbstractC0881i
    /* renamed from: c */
    public final Collection mo4027c() {
        return Collections2.transform(this.f14843c.values(), this.f14844d);
    }

    @Override // com.google.common.collect.Table
    public final void clear() {
        this.f14843c.clear();
    }

    @Override // com.google.common.collect.Table
    public final Map column(Object obj) {
        return Maps.transformValues(this.f14843c.column(obj), this.f14844d);
    }

    @Override // com.google.common.collect.Table
    public final Set columnKeySet() {
        return this.f14843c.columnKeySet();
    }

    @Override // com.google.common.collect.Table
    public final Map columnMap() {
        return Maps.transformValues(this.f14843c.columnMap(), new es2(this, 1));
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public final boolean contains(Object obj, Object obj2) {
        return this.f14843c.contains(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public final Object get(Object obj, Object obj2) {
        Table table = this.f14843c;
        if (table.contains(obj, obj2)) {
            return this.f14844d.apply(table.get(obj, obj2));
        }
        return null;
    }

    @Override // com.google.common.collect.Table
    public final Object put(Object obj, Object obj2, Object obj3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public final void putAll(Table table) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public final Object remove(Object obj, Object obj2) {
        Table table = this.f14843c;
        if (table.contains(obj, obj2)) {
            return this.f14844d.apply(table.remove(obj, obj2));
        }
        return null;
    }

    @Override // com.google.common.collect.Table
    public final Map row(Object obj) {
        return Maps.transformValues(this.f14843c.row(obj), this.f14844d);
    }

    @Override // com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public final Set rowKeySet() {
        return this.f14843c.rowKeySet();
    }

    @Override // com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public final Map rowMap() {
        return Maps.transformValues(this.f14843c.rowMap(), new es2(this, 0));
    }

    @Override // com.google.common.collect.Table
    public final int size() {
        return this.f14843c.size();
    }
}
