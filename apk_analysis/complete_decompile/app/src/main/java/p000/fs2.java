package p000;

import com.google.common.base.Function;
import com.google.common.collect.C0895k3;
import com.google.common.collect.Maps;
import com.google.common.collect.RowSortedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import java.util.Collections;
import java.util.SortedMap;
import java.util.SortedSet;

/* loaded from: classes.dex */
public final class fs2 extends C0895k3 implements RowSortedTable {
    private static final long serialVersionUID = 0;

    @Override // com.google.common.collect.C0895k3, com.google.common.collect.ForwardingTable, com.google.common.collect.ForwardingObject
    public final Table delegate() {
        return (RowSortedTable) this.f14870a;
    }

    @Override // com.google.common.collect.C0895k3, com.google.common.collect.ForwardingTable, com.google.common.collect.ForwardingObject
    public final Object delegate() {
        return (RowSortedTable) this.f14870a;
    }

    @Override // com.google.common.collect.C0895k3, com.google.common.collect.ForwardingTable, com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public final SortedSet rowKeySet() {
        return Collections.unmodifiableSortedSet(((RowSortedTable) this.f14870a).rowKeySet());
    }

    @Override // com.google.common.collect.C0895k3, com.google.common.collect.ForwardingTable, com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public final SortedMap rowMap() {
        return Collections.unmodifiableSortedMap(Maps.transformValues(((RowSortedTable) this.f14870a).rowMap(), (Function) Tables.f14749a));
    }
}
