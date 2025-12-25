package com.google.common.collect;

import p000.aa2;
import p000.y92;
import p000.z92;

/* renamed from: com.google.common.collect.g2 */
/* loaded from: classes.dex */
public final class C0874g2 extends ImmutableBiMap {

    /* renamed from: k */
    public static final C0874g2 f14830k = new C0874g2();

    /* renamed from: f */
    public final transient Object f14831f;

    /* renamed from: g */
    public final transient Object[] f14832g;

    /* renamed from: h */
    public final transient int f14833h;

    /* renamed from: i */
    public final transient int f14834i;

    /* renamed from: j */
    public final transient C0874g2 f14835j;

    public C0874g2() {
        this.f14831f = null;
        this.f14832g = new Object[0];
        this.f14833h = 0;
        this.f14834i = 0;
        this.f14835j = this;
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: a */
    public final ImmutableSet mo3934a() {
        return new y92(this, this.f14832g, this.f14833h, this.f14834i);
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: c */
    public final ImmutableSet mo3935c() {
        return new z92(this, new aa2(this.f14833h, this.f14834i, this.f14832g));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public final Object get(Object obj) {
        Object m4119l = C0884i2.m4119l(this.f14831f, this.f14832g, this.f14834i, this.f14833h, obj);
        if (m4119l == null) {
            return null;
        }
        return m4119l;
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: h */
    public final boolean mo3937h() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.BiMap
    public final BiMap inverse() {
        return this.f14835j;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f14834i;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.BiMap
    public final ImmutableBiMap inverse() {
        return this.f14835j;
    }

    public C0874g2(int i, Object[] objArr) {
        this.f14832g = objArr;
        this.f14834i = i;
        this.f14833h = 0;
        int m3969f = i >= 2 ? ImmutableSet.m3969f(i) : 0;
        Object m4118k = C0884i2.m4118k(objArr, i, m3969f, 0);
        if (!(m4118k instanceof Object[])) {
            this.f14831f = m4118k;
            Object m4118k2 = C0884i2.m4118k(objArr, i, m3969f, 1);
            if (!(m4118k2 instanceof Object[])) {
                this.f14835j = new C0874g2(m4118k2, objArr, i, this);
                return;
            }
            throw ((C0842a0) ((Object[]) m4118k2)[2]).m4080a();
        }
        throw ((C0842a0) ((Object[]) m4118k)[2]).m4080a();
    }

    public C0874g2(Object obj, Object[] objArr, int i, C0874g2 c0874g2) {
        this.f14831f = obj;
        this.f14832g = objArr;
        this.f14833h = 1;
        this.f14834i = i;
        this.f14835j = c0874g2;
    }
}
