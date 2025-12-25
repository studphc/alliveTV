package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Table;

/* renamed from: com.google.common.collect.i3 */
/* loaded from: classes.dex */
public final class C0885i3 implements Function {
    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        Table.Cell cell = (Table.Cell) obj;
        return Tables.immutableCell(cell.getColumnKey(), cell.getRowKey(), cell.getValue());
    }
}
