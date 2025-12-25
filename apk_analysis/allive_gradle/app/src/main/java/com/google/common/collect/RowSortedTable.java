package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
/* loaded from: classes.dex */
public interface RowSortedTable<R, C, V> extends Table<R, C, V> {
    @Override // 
    /* bridge */ /* synthetic */ Set rowKeySet();

    @Override // com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    SortedSet<R> rowKeySet();

    @Override // 
    /* bridge */ /* synthetic */ Map rowMap();

    @Override // com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    SortedMap<R, Map<C, V>> rowMap();
}
