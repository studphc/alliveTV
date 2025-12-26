package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service;
import p000.AbstractC1726qj;
import p000.v91;

/* renamed from: com.google.common.util.concurrent.m */
/* loaded from: classes2.dex */
public final class C1006m implements v91 {

    /* renamed from: a */
    public final /* synthetic */ Service.State f15403a;

    public C1006m(Service.State state) {
        this.f15403a = state;
    }

    @Override // p000.v91
    /* renamed from: a */
    public final void mo4346a(Object obj) {
        ((Service.Listener) obj).stopping(this.f15403a);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f15403a);
        return AbstractC1726qj.m7059o("stopping({from = ", valueOf, "})", valueOf.length() + 19);
    }
}
