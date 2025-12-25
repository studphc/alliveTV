package com.google.common.collect;

import p000.o63;

/* renamed from: com.google.common.collect.l2 */
/* loaded from: classes.dex */
public final class C0899l2 extends ImmutableSet {

    /* renamed from: h */
    public static final Object[] f14874h;

    /* renamed from: i */
    public static final C0899l2 f14875i;

    /* renamed from: c */
    public final transient Object[] f14876c;

    /* renamed from: d */
    public final transient int f14877d;

    /* renamed from: e */
    public final transient Object[] f14878e;

    /* renamed from: f */
    public final transient int f14879f;

    /* renamed from: g */
    public final transient int f14880g;

    static {
        Object[] objArr = new Object[0];
        f14874h = objArr;
        f14875i = new C0899l2(objArr, objArr, 0, 0, 0);
    }

    public C0899l2(Object[] objArr, Object[] objArr2, int i, int i2, int i3) {
        this.f14876c = objArr;
        this.f14877d = i;
        this.f14878e = objArr2;
        this.f14879f = i2;
        this.f14880g = i3;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: a */
    public final int mo3896a(Object[] objArr, int i) {
        Object[] objArr2 = this.f14876c;
        int i2 = this.f14880g;
        System.arraycopy(objArr2, 0, objArr, i, i2);
        return i + i2;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: b */
    public final Object[] mo3897b() {
        return this.f14876c;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: c */
    public final int mo3898c() {
        return this.f14880g;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.f14878e;
            if (objArr.length != 0) {
                int m6454N = o63.m6454N(obj);
                while (true) {
                    int i = m6454N & this.f14879f;
                    Object obj2 = objArr[i];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    m6454N = i + 1;
                }
            }
        }
        return false;
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

    @Override // com.google.common.collect.ImmutableSet
    /* renamed from: h */
    public final ImmutableList mo3978h() {
        return ImmutableList.m3901f(this.f14880g, this.f14876c);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f14877d;
    }

    @Override // com.google.common.collect.ImmutableSet
    /* renamed from: i */
    public final boolean mo8i() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f14880g;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final UnmodifiableIterator iterator() {
        return asList().iterator();
    }
}
