package com.google.common.collect;

import com.google.common.collect.Table;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p000.C0578c2;
import p000.rv2;

/* renamed from: com.google.common.collect.i */
/* loaded from: classes.dex */
public abstract class AbstractC0881i implements Table {

    /* renamed from: a */
    public transient Set f14845a;

    /* renamed from: b */
    public transient Collection f14846b;

    /* renamed from: a */
    public abstract Iterator mo3830a();

    /* renamed from: b */
    public Set mo4026b() {
        return new C0876h(this);
    }

    /* renamed from: c */
    public Collection mo4027c() {
        return new C0578c2(2, this);
    }

    @Override // com.google.common.collect.Table
    public Set cellSet() {
        Set set = this.f14845a;
        if (set == null) {
            Set mo4026b = mo4026b();
            this.f14845a = mo4026b;
            return mo4026b;
        }
        return set;
    }

    @Override // com.google.common.collect.Table
    public boolean contains(Object obj, Object obj2) {
        Map map = (Map) Maps.m4052h(rowMap(), obj);
        if (map != null && Maps.m4051g(map, obj2)) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.Table
    public boolean containsColumn(Object obj) {
        return Maps.m4051g(columnMap(), obj);
    }

    @Override // com.google.common.collect.Table
    public boolean containsRow(Object obj) {
        return Maps.m4051g(rowMap(), obj);
    }

    @Override // com.google.common.collect.Table
    public boolean containsValue(Object obj) {
        Iterator it = rowMap().values().iterator();
        while (it.hasNext()) {
            if (((Map) it.next()).containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public Iterator mo3832d() {
        return new rv2(cellSet().iterator());
    }

    @Override // com.google.common.collect.Table
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Table) {
            return cellSet().equals(((Table) obj).cellSet());
        }
        return false;
    }

    @Override // com.google.common.collect.Table
    public Object get(Object obj, Object obj2) {
        Map map = (Map) Maps.m4052h(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return Maps.m4052h(map, obj2);
    }

    @Override // com.google.common.collect.Table
    public int hashCode() {
        return cellSet().hashCode();
    }

    @Override // com.google.common.collect.Table
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.Table
    public void putAll(Table table) {
        for (Table.Cell cell : table.cellSet()) {
            put(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
        }
    }

    public String toString() {
        return rowMap().toString();
    }

    @Override // com.google.common.collect.Table
    public Collection values() {
        Collection collection = this.f14846b;
        if (collection == null) {
            Collection mo4027c = mo4027c();
            this.f14846b = mo4027c;
            return mo4027c;
        }
        return collection;
    }
}
