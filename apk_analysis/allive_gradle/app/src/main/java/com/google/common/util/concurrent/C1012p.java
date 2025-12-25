package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;

/* renamed from: com.google.common.util.concurrent.p */
/* loaded from: classes2.dex */
public final class C1012p extends Monitor.Guard {

    /* renamed from: e */
    public final /* synthetic */ AbstractService f15413e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1012p(AbstractService abstractService) {
        super(abstractService.f15272a);
        this.f15413e = abstractService;
    }

    @Override // com.google.common.util.concurrent.Monitor.Guard
    public final boolean isSatisfied() {
        if (this.f15413e.state().compareTo(Service.State.RUNNING) >= 0) {
            return true;
        }
        return false;
    }
}
