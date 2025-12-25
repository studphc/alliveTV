package p000;

import com.google.common.collect.C0855c3;
import com.google.common.collect.RowSortedTable;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

/* loaded from: classes.dex */
public class an2 extends C0855c3 implements RowSortedTable {
    private static final long serialVersionUID = 0;

    @Override // com.google.common.collect.C0855c3
    /* renamed from: g */
    public final Map mo116g() {
        return new zm2(this);
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public SortedSet rowKeySet() {
        return (SortedSet) rowMap().keySet();
    }

    @Override // com.google.common.collect.C0855c3, com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public SortedMap rowMap() {
        return (SortedMap) super.rowMap();
    }
}
