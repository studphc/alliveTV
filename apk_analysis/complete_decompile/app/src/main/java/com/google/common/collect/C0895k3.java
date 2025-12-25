package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.common.collect.k3 */
/* loaded from: classes.dex */
public class C0895k3 extends ForwardingTable implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Table f14870a;

    public C0895k3(Table table) {
        this.f14870a = (Table) Preconditions.checkNotNull(table);
    }

    @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
    public final Set cellSet() {
        return Collections.unmodifiableSet(super.cellSet());
    }

    @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
    public final Map column(Object obj) {
        return Collections.unmodifiableMap(super.column(obj));
    }

    @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
    public final Set columnKeySet() {
        return Collections.unmodifiableSet(super.columnKeySet());
    }

    @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
    public final Map columnMap() {
        return Collections.unmodifiableMap(Maps.transformValues(super.columnMap(), Tables.f14749a));
    }

    @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
    public final Object put(Object obj, Object obj2, Object obj3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
    public final void putAll(Table table) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
    public final Object remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
    public final Map row(Object obj) {
        return Collections.unmodifiableMap(super.row(obj));
    }

    @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public Set rowKeySet() {
        return Collections.unmodifiableSet(super.rowKeySet());
    }

    @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public Map rowMap() {
        return Collections.unmodifiableMap(Maps.transformValues(super.rowMap(), Tables.f14749a));
    }

    @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
    public final Collection values() {
        return Collections.unmodifiableCollection(super.values());
    }

    @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.ForwardingObject
    public Table delegate() {
        return this.f14870a;
    }
}
