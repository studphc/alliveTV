package com.google.common.collect;

import com.google.common.collect.Table;
import p000.h41;

/* renamed from: com.google.common.collect.o2 */
/* loaded from: classes.dex */
public final class C0914o2 extends h41 {

    /* renamed from: c */
    public final /* synthetic */ AbstractC0919p2 f14916c;

    public C0914o2(AbstractC0919p2 abstractC0919p2) {
        this.f14916c = abstractC0919p2;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (!(obj instanceof Table.Cell)) {
            return false;
        }
        Table.Cell cell = (Table.Cell) obj;
        Object obj2 = this.f14916c.get(cell.getRowKey(), cell.getColumnKey());
        if (obj2 == null || !obj2.equals(cell.getValue())) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return false;
    }

    @Override // p000.h41
    public final Object get(int i) {
        return this.f14916c.mo4082k(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f14916c.size();
    }
}
