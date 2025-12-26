package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ServiceManager;
import p000.AbstractC1726qj;
import p000.v91;

/* renamed from: com.google.common.util.concurrent.c1 */
/* loaded from: classes2.dex */
public final class C0984c1 implements v91 {

    /* renamed from: a */
    public final /* synthetic */ Service f15362a;

    public C0984c1(Service service) {
        this.f15362a = service;
    }

    @Override // p000.v91
    /* renamed from: a */
    public final void mo4346a(Object obj) {
        ((ServiceManager.Listener) obj).failure(this.f15362a);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f15362a);
        return AbstractC1726qj.m7059o("failed({service=", valueOf, "})", valueOf.length() + 18);
    }
}
