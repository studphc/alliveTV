package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Table;

/* renamed from: com.google.common.collect.g3 */
/* loaded from: classes.dex */
public final class C0875g3 implements Function {

    /* renamed from: a */
    public final /* synthetic */ C0880h3 f14836a;

    public C0875g3(C0880h3 c0880h3) {
        this.f14836a = c0880h3;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        Table.Cell cell = (Table.Cell) obj;
        return Tables.immutableCell(cell.getRowKey(), cell.getColumnKey(), this.f14836a.f14844d.apply(cell.getValue()));
    }
}
