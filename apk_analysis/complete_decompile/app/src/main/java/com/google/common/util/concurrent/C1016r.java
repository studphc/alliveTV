package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;

/* renamed from: com.google.common.util.concurrent.r */
/* loaded from: classes2.dex */
public final class C1016r extends Monitor.Guard {

    /* renamed from: e */
    public final /* synthetic */ AbstractService f15419e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1016r(AbstractService abstractService) {
        super(abstractService.f15272a);
        this.f15419e = abstractService;
    }

    @Override // com.google.common.util.concurrent.Monitor.Guard
    public final boolean isSatisfied() {
        if (this.f15419e.state().compareTo(Service.State.RUNNING) <= 0) {
            return true;
        }
        return false;
    }
}
