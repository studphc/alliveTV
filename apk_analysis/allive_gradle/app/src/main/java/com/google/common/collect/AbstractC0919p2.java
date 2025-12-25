package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Table;
import p000.ca2;

/* renamed from: com.google.common.collect.p2 */
/* loaded from: classes.dex */
public abstract class AbstractC0919p2 extends ImmutableTable {
    /* renamed from: i */
    public static void m4156i(Object obj, Object obj2, Object obj3, Object obj4) {
        boolean z;
        if (obj3 == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Duplicate key: (row=%s, column=%s), values: [%s, %s].", obj, obj2, obj4, obj3);
    }

    /* renamed from: j */
    public static AbstractC0919p2 m4157j(ImmutableList immutableList, ImmutableSet immutableSet, ImmutableSet immutableSet2) {
        if (immutableList.size() > (immutableSet.size() * immutableSet2.size()) / 2) {
            return new C0916p(immutableList, immutableSet, immutableSet2);
        }
        return new C0845a3(immutableList, immutableSet, immutableSet2);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractC0881i
    /* renamed from: f */
    public final ImmutableSet mo4026b() {
        if (isEmpty()) {
            return ImmutableSet.m3971of();
        }
        return new C0914o2(this);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractC0881i
    /* renamed from: h */
    public final ImmutableCollection mo4027c() {
        if (isEmpty()) {
            return ImmutableList.m3902of();
        }
        return new ca2(this);
    }

    /* renamed from: k */
    public abstract Table.Cell mo4082k(int i);

    /* renamed from: l */
    public abstract Object mo4083l(int i);
}
