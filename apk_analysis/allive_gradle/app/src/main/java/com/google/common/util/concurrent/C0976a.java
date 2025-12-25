package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import p000.AbstractC1726qj;

/* renamed from: com.google.common.util.concurrent.a */
/* loaded from: classes2.dex */
public final class C0976a implements Supplier {

    /* renamed from: a */
    public final /* synthetic */ AbstractIdleService f15347a;

    public C0976a(AbstractIdleService abstractIdleService) {
        this.f15347a = abstractIdleService;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        AbstractIdleService abstractIdleService = this.f15347a;
        String serviceName = abstractIdleService.serviceName();
        String valueOf = String.valueOf(abstractIdleService.state());
        return AbstractC1726qj.m7059o(serviceName, " ", valueOf, valueOf.length() + AbstractC1726qj.m7052h(1, serviceName));
    }
}
