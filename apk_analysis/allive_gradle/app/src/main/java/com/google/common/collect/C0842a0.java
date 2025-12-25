package com.google.common.collect;

import p000.AbstractC1726qj;

/* renamed from: com.google.common.collect.a0 */
/* loaded from: classes.dex */
public final class C0842a0 {

    /* renamed from: a */
    public final Object f14764a;

    /* renamed from: b */
    public final Object f14765b;

    /* renamed from: c */
    public final Object f14766c;

    public C0842a0(Object obj, Object obj2, Object obj3) {
        this.f14764a = obj;
        this.f14765b = obj2;
        this.f14766c = obj3;
    }

    /* renamed from: a */
    public final IllegalArgumentException m4080a() {
        Object obj = this.f14764a;
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(this.f14765b);
        String valueOf3 = String.valueOf(obj);
        String valueOf4 = String.valueOf(this.f14766c);
        StringBuilder m7062r = AbstractC1726qj.m7062r(valueOf4.length() + valueOf3.length() + valueOf2.length() + valueOf.length() + 39, "Multiple entries with same key: ", valueOf, "=", valueOf2);
        m7062r.append(" and ");
        m7062r.append(valueOf3);
        m7062r.append("=");
        m7062r.append(valueOf4);
        return new IllegalArgumentException(m7062r.toString());
    }
}
