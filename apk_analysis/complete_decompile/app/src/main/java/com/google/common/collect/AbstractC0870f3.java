package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.Table;
import p000.AbstractC1726qj;

/* renamed from: com.google.common.collect.f3 */
/* loaded from: classes.dex */
public abstract class AbstractC0870f3 implements Table.Cell {
    @Override // com.google.common.collect.Table.Cell
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Table.Cell)) {
            return false;
        }
        Table.Cell cell = (Table.Cell) obj;
        if (Objects.equal(getRowKey(), cell.getRowKey()) && Objects.equal(getColumnKey(), cell.getColumnKey()) && Objects.equal(getValue(), cell.getValue())) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.Table.Cell
    public final int hashCode() {
        return Objects.hashCode(getRowKey(), getColumnKey(), getValue());
    }

    public final String toString() {
        String valueOf = String.valueOf(getRowKey());
        String valueOf2 = String.valueOf(getColumnKey());
        String valueOf3 = String.valueOf(getValue());
        return AbstractC1726qj.m7061q(AbstractC1726qj.m7062r(valueOf3.length() + valueOf2.length() + valueOf.length() + 4, "(", valueOf, ",", valueOf2), ")=", valueOf3);
    }
}
