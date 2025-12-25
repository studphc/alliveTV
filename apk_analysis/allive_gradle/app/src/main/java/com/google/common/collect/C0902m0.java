package com.google.common.collect;

import java.io.Serializable;

/* renamed from: com.google.common.collect.m0 */
/* loaded from: classes.dex */
public final class C0902m0 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Object[] f14884a;

    /* renamed from: b */
    public final Object[] f14885b;

    /* renamed from: c */
    public final Object[] f14886c;

    /* renamed from: d */
    public final int[] f14887d;

    /* renamed from: e */
    public final int[] f14888e;

    public C0902m0(Object[] objArr, Object[] objArr2, Object[] objArr3, int[] iArr, int[] iArr2) {
        this.f14884a = objArr;
        this.f14885b = objArr2;
        this.f14886c = objArr3;
        this.f14887d = iArr;
        this.f14888e = iArr2;
    }

    /* renamed from: a */
    public static C0902m0 m4134a(ImmutableTable immutableTable, int[] iArr, int[] iArr2) {
        return new C0902m0(immutableTable.rowKeySet().toArray(), immutableTable.columnKeySet().toArray(), immutableTable.values().toArray(), iArr, iArr2);
    }

    public Object readResolve() {
        Object[] objArr = this.f14886c;
        if (objArr.length == 0) {
            return ImmutableTable.m4024of();
        }
        int length = objArr.length;
        Object[] objArr2 = this.f14885b;
        Object[] objArr3 = this.f14884a;
        if (length == 1) {
            return ImmutableTable.m4025of(objArr3[0], objArr2[0], objArr[0]);
        }
        AbstractC0957z abstractC0957z = new AbstractC0957z(objArr.length);
        for (int i = 0; i < objArr.length; i++) {
            abstractC0957z.add((AbstractC0957z) ImmutableTable.m4023e(objArr3[this.f14887d[i]], objArr2[this.f14888e[i]], objArr[i]));
        }
        return AbstractC0919p2.m4157j(abstractC0957z.build(), ImmutableSet.copyOf(objArr3), ImmutableSet.copyOf(objArr2));
    }
}
