package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service;
import p000.AbstractC1726qj;
import p000.v91;

/* renamed from: com.google.common.util.concurrent.n */
/* loaded from: classes2.dex */
public final class C1008n implements v91 {

    /* renamed from: a */
    public final /* synthetic */ Service.State f15406a;

    /* renamed from: b */
    public final /* synthetic */ Throwable f15407b;

    public C1008n(Service.State state, Throwable th) {
        this.f15406a = state;
        this.f15407b = th;
    }

    @Override // p000.v91
    /* renamed from: a */
    public final void mo4346a(Object obj) {
        ((Service.Listener) obj).failed(this.f15406a, this.f15407b);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f15406a);
        String valueOf2 = String.valueOf(this.f15407b);
        StringBuilder m7062r = AbstractC1726qj.m7062r(valueOf2.length() + valueOf.length() + 27, "failed({from = ", valueOf, ", cause = ", valueOf2);
        m7062r.append("})");
        return m7062r.toString();
    }
}
