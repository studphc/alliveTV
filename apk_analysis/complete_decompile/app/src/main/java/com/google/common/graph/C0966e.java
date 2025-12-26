package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p000.f40;
import p000.mx0;

/* renamed from: com.google.common.graph.e */
/* loaded from: classes2.dex */
public final class C0966e implements mx0 {

    /* renamed from: a */
    public final Map f15052a;

    public C0966e(Map map) {
        this.f15052a = (Map) Preconditions.checkNotNull(map);
    }

    @Override // p000.mx0
    /* renamed from: a */
    public final Set mo4179a() {
        return Collections.unmodifiableSet(this.f15052a.keySet());
    }

    @Override // p000.mx0
    /* renamed from: b */
    public final Set mo4180b() {
        return mo4179a();
    }

    @Override // p000.mx0
    /* renamed from: c */
    public final Set mo4181c() {
        return mo4179a();
    }

    @Override // p000.mx0
    /* renamed from: d */
    public final Object mo4182d(Object obj) {
        return this.f15052a.remove(obj);
    }

    @Override // p000.mx0
    /* renamed from: e */
    public final Object mo4183e(Object obj) {
        return this.f15052a.get(obj);
    }

    @Override // p000.mx0
    /* renamed from: f */
    public final void mo4184f(Object obj) {
        mo4182d(obj);
    }

    @Override // p000.mx0
    /* renamed from: g */
    public final Iterator mo4185g(Object obj) {
        return Iterators.transform(this.f15052a.keySet().iterator(), new f40(3, obj));
    }

    @Override // p000.mx0
    /* renamed from: h */
    public final Object mo4186h(Object obj, Object obj2) {
        return this.f15052a.put(obj, obj2);
    }

    @Override // p000.mx0
    /* renamed from: i */
    public final void mo4187i(Object obj, Object obj2) {
        mo4186h(obj, obj2);
    }
}
