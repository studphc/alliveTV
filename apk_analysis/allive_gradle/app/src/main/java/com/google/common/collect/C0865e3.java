package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import p000.pr2;
import p000.xr2;

/* renamed from: com.google.common.collect.e3 */
/* loaded from: classes.dex */
public final class C0865e3 extends pr2 implements Table {
    /* JADX WARN: Type inference failed for: r3v0, types: [pr2, java.util.Set] */
    @Override // com.google.common.collect.Table
    public final Set cellSet() {
        ?? pr2Var;
        synchronized (this.f25273b) {
            pr2Var = new pr2(((Table) this.f25272a).cellSet(), this.f25273b);
        }
        return pr2Var;
    }

    @Override // com.google.common.collect.Table
    public final void clear() {
        synchronized (this.f25273b) {
            ((Table) this.f25272a).clear();
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [pr2, java.util.Map] */
    @Override // com.google.common.collect.Table
    public final Map column(Object obj) {
        ?? pr2Var;
        synchronized (this.f25273b) {
            pr2Var = new pr2(((Table) this.f25272a).column(obj), this.f25273b);
        }
        return pr2Var;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [pr2, java.util.Set] */
    @Override // com.google.common.collect.Table
    public final Set columnKeySet() {
        ?? pr2Var;
        synchronized (this.f25273b) {
            pr2Var = new pr2(((Table) this.f25272a).columnKeySet(), this.f25273b);
        }
        return pr2Var;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [pr2, java.util.Map] */
    @Override // com.google.common.collect.Table
    public final Map columnMap() {
        ?? pr2Var;
        synchronized (this.f25273b) {
            pr2Var = new pr2(Maps.transformValues(((Table) this.f25272a).columnMap(), new xr2(this, 1)), this.f25273b);
        }
        return pr2Var;
    }

    @Override // com.google.common.collect.Table
    public final boolean contains(Object obj, Object obj2) {
        boolean contains;
        synchronized (this.f25273b) {
            contains = ((Table) this.f25272a).contains(obj, obj2);
        }
        return contains;
    }

    @Override // com.google.common.collect.Table
    public final boolean containsColumn(Object obj) {
        boolean containsColumn;
        synchronized (this.f25273b) {
            containsColumn = ((Table) this.f25272a).containsColumn(obj);
        }
        return containsColumn;
    }

    @Override // com.google.common.collect.Table
    public final boolean containsRow(Object obj) {
        boolean containsRow;
        synchronized (this.f25273b) {
            containsRow = ((Table) this.f25272a).containsRow(obj);
        }
        return containsRow;
    }

    @Override // com.google.common.collect.Table
    public final boolean containsValue(Object obj) {
        boolean containsValue;
        synchronized (this.f25273b) {
            containsValue = ((Table) this.f25272a).containsValue(obj);
        }
        return containsValue;
    }

    @Override // com.google.common.collect.Table
    public final boolean equals(Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        synchronized (this.f25273b) {
            equals = ((Table) this.f25272a).equals(obj);
        }
        return equals;
    }

    @Override // com.google.common.collect.Table
    public final Object get(Object obj, Object obj2) {
        Object obj3;
        synchronized (this.f25273b) {
            obj3 = ((Table) this.f25272a).get(obj, obj2);
        }
        return obj3;
    }

    @Override // com.google.common.collect.Table
    public final int hashCode() {
        int hashCode;
        synchronized (this.f25273b) {
            hashCode = ((Table) this.f25272a).hashCode();
        }
        return hashCode;
    }

    @Override // com.google.common.collect.Table
    public final boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.f25273b) {
            isEmpty = ((Table) this.f25272a).isEmpty();
        }
        return isEmpty;
    }

    @Override // com.google.common.collect.Table
    public final Object put(Object obj, Object obj2, Object obj3) {
        Object put;
        synchronized (this.f25273b) {
            put = ((Table) this.f25272a).put(obj, obj2, obj3);
        }
        return put;
    }

    @Override // com.google.common.collect.Table
    public final void putAll(Table table) {
        synchronized (this.f25273b) {
            ((Table) this.f25272a).putAll(table);
        }
    }

    @Override // com.google.common.collect.Table
    public final Object remove(Object obj, Object obj2) {
        Object remove;
        synchronized (this.f25273b) {
            remove = ((Table) this.f25272a).remove(obj, obj2);
        }
        return remove;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [pr2, java.util.Map] */
    @Override // com.google.common.collect.Table
    public final Map row(Object obj) {
        ?? pr2Var;
        synchronized (this.f25273b) {
            pr2Var = new pr2(((Table) this.f25272a).row(obj), this.f25273b);
        }
        return pr2Var;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [pr2, java.util.Set] */
    @Override // com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public final Set rowKeySet() {
        ?? pr2Var;
        synchronized (this.f25273b) {
            pr2Var = new pr2(((Table) this.f25272a).rowKeySet(), this.f25273b);
        }
        return pr2Var;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [pr2, java.util.Map] */
    @Override // com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public final Map rowMap() {
        ?? pr2Var;
        synchronized (this.f25273b) {
            pr2Var = new pr2(Maps.transformValues(((Table) this.f25272a).rowMap(), new xr2(this, 0)), this.f25273b);
        }
        return pr2Var;
    }

    @Override // com.google.common.collect.Table
    public final int size() {
        int size;
        synchronized (this.f25273b) {
            size = ((Table) this.f25272a).size();
        }
        return size;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [pr2, java.util.Collection] */
    @Override // com.google.common.collect.Table
    public final Collection values() {
        ?? pr2Var;
        synchronized (this.f25273b) {
            pr2Var = new pr2(((Table) this.f25272a).values(), this.f25273b);
        }
        return pr2Var;
    }
}
