package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import p000.AbstractC1726qj;
import p000.C2042z2;

/* renamed from: com.google.common.util.concurrent.g */
/* loaded from: classes2.dex */
public final class C0994g implements Supplier {

    /* renamed from: a */
    public final /* synthetic */ C2042z2 f15389a;

    public C0994g(C2042z2 c2042z2) {
        this.f15389a = c2042z2;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        C2042z2 c2042z2 = this.f15389a;
        String serviceName = c2042z2.f29225t.serviceName();
        String valueOf = String.valueOf(c2042z2.state());
        return AbstractC1726qj.m7059o(serviceName, " ", valueOf, valueOf.length() + AbstractC1726qj.m7052h(1, serviceName));
    }
}
