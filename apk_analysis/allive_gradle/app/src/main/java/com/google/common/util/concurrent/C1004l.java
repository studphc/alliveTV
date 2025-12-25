package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service;
import p000.AbstractC1726qj;
import p000.v91;

/* renamed from: com.google.common.util.concurrent.l */
/* loaded from: classes2.dex */
public final class C1004l implements v91 {

    /* renamed from: a */
    public final /* synthetic */ Service.State f15400a;

    public C1004l(Service.State state) {
        this.f15400a = state;
    }

    @Override // p000.v91
    /* renamed from: a */
    public final void mo4346a(Object obj) {
        ((Service.Listener) obj).terminated(this.f15400a);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f15400a);
        return AbstractC1726qj.m7059o("terminated({from = ", valueOf, "})", valueOf.length() + 21);
    }
}
