package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;

/* renamed from: com.google.common.util.concurrent.e1 */
/* loaded from: classes2.dex */
public final class C0990e1 extends Monitor.Guard {

    /* renamed from: e */
    public final /* synthetic */ C0993f1 f15373e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0990e1(C0993f1 c0993f1) {
        super(c0993f1.f15379a);
        this.f15373e = c0993f1;
    }

    @Override // com.google.common.util.concurrent.Monitor.Guard
    public final boolean isSatisfied() {
        C0993f1 c0993f1 = this.f15373e;
        if (c0993f1.f15381c.count(Service.State.FAILED) + c0993f1.f15381c.count(Service.State.TERMINATED) == c0993f1.f15385g) {
            return true;
        }
        return false;
    }
}
