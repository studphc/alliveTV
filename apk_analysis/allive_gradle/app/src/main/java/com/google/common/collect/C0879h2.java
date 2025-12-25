package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Objects;

/* renamed from: com.google.common.collect.h2 */
/* loaded from: classes.dex */
public final class C0879h2 extends ImmutableList {

    /* renamed from: e */
    public static final C0879h2 f14840e = new C0879h2(0, new Object[0]);

    /* renamed from: c */
    public final transient Object[] f14841c;

    /* renamed from: d */
    public final transient int f14842d;

    public C0879h2(int i, Object[] objArr) {
        this.f14841c = objArr;
        this.f14842d = i;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    /* renamed from: a */
    public final int mo3896a(Object[] objArr, int i) {
        Object[] objArr2 = this.f14841c;
        int i2 = this.f14842d;
        System.arraycopy(objArr2, 0, objArr, i, i2);
        return i + i2;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: b */
    public final Object[] mo3897b() {
        return this.f14841c;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: c */
    public final int mo3898c() {
        return this.f14842d;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: d */
    public final int mo3899d() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return false;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Preconditions.checkElementIndex(i, this.f14842d);
        Object obj = this.f14841c[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f14842d;
    }
}
