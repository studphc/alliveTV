package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Table;
import java.util.Map;
import p000.ds2;
import p000.n82;
import p000.pr2;

@GwtCompatible
/* loaded from: classes.dex */
public final class Tables {

    /* renamed from: a */
    public static final n82 f14749a = new n82(7);

    public static <R, C, V> Table.Cell<R, C, V> immutableCell(R r, C c, V v) {
        return new ds2(r, c, v);
    }

    @Beta
    public static <R, C, V> Table<R, C, V> newCustomTable(Map<R, Map<C, V>> map, Supplier<? extends Map<C, V>> supplier) {
        Preconditions.checkArgument(map.isEmpty());
        Preconditions.checkNotNull(supplier);
        return new C0855c3(map, supplier);
    }

    public static <R, C, V> Table<R, C, V> synchronizedTable(Table<R, C, V> table) {
        return (Table<R, C, V>) new pr2(table, null);
    }

    @Beta
    public static <R, C, V1, V2> Table<R, C, V2> transformValues(Table<R, C, V1> table, Function<? super V1, V2> function) {
        return new C0880h3(table, function);
    }

    public static <R, C, V> Table<C, R, V> transpose(Table<R, C, V> table) {
        if (table instanceof C0890j3) {
            return ((C0890j3) table).f14859c;
        }
        return new C0890j3(table);
    }

    @Beta
    public static <R, C, V> RowSortedTable<R, C, V> unmodifiableRowSortedTable(RowSortedTable<R, ? extends C, ? extends V> rowSortedTable) {
        return (RowSortedTable<R, C, V>) new C0895k3(rowSortedTable);
    }

    public static <R, C, V> Table<R, C, V> unmodifiableTable(Table<? extends R, ? extends C, ? extends V> table) {
        return new C0895k3(table);
    }
}
