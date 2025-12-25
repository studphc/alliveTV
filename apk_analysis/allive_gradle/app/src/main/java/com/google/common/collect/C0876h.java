package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Table;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.common.collect.h */
/* loaded from: classes.dex */
public final class C0876h extends AbstractSet {

    /* renamed from: a */
    public final /* synthetic */ AbstractC0881i f14837a;

    public C0876h(AbstractC0881i abstractC0881i) {
        this.f14837a = abstractC0881i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f14837a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (!(obj instanceof Table.Cell)) {
            return false;
        }
        Table.Cell cell = (Table.Cell) obj;
        Map map = (Map) Maps.m4052h(this.f14837a.rowMap(), cell.getRowKey());
        if (map == null || !Collections2.m3836c(map.entrySet(), Maps.immutableEntry(cell.getColumnKey(), cell.getValue()))) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return this.f14837a.mo3830a();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        boolean z;
        if (!(obj instanceof Table.Cell)) {
            return false;
        }
        Table.Cell cell = (Table.Cell) obj;
        Map map = (Map) Maps.m4052h(this.f14837a.rowMap(), cell.getRowKey());
        if (map == null) {
            return false;
        }
        Set entrySet = map.entrySet();
        Map.Entry immutableEntry = Maps.immutableEntry(cell.getColumnKey(), cell.getValue());
        Preconditions.checkNotNull(entrySet);
        try {
            z = entrySet.remove(immutableEntry);
        } catch (ClassCastException | NullPointerException unused) {
            z = false;
        }
        if (!z) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f14837a.size();
    }
}
