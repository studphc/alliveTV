package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;

/* renamed from: com.google.common.util.concurrent.s */
/* loaded from: classes2.dex */
public final class C1018s extends Monitor.Guard {

    /* renamed from: e */
    public final /* synthetic */ AbstractService f15422e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1018s(AbstractService abstractService) {
        super(abstractService.f15272a);
        this.f15422e = abstractService;
    }

    @Override // com.google.common.util.concurrent.Monitor.Guard
    public final boolean isSatisfied() {
        if (this.f15422e.state().compareTo(Service.State.TERMINATED) >= 0) {
            return true;
        }
        return false;
    }
}
