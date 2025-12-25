package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;

/* renamed from: com.google.common.util.concurrent.q */
/* loaded from: classes2.dex */
public final class C1014q extends Monitor.Guard {

    /* renamed from: e */
    public final /* synthetic */ AbstractService f15416e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1014q(AbstractService abstractService) {
        super(abstractService.f15272a);
        this.f15416e = abstractService;
    }

    @Override // com.google.common.util.concurrent.Monitor.Guard
    public final boolean isSatisfied() {
        if (this.f15416e.state() == Service.State.NEW) {
            return true;
        }
        return false;
    }
}
