package com.google.common.util.concurrent;

import com.google.common.collect.Multiset;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;

/* renamed from: com.google.common.util.concurrent.d1 */
/* loaded from: classes2.dex */
public final class C0987d1 extends Monitor.Guard {

    /* renamed from: e */
    public final /* synthetic */ C0993f1 f15367e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0987d1(C0993f1 c0993f1) {
        super(c0993f1.f15379a);
        this.f15367e = c0993f1;
    }

    @Override // com.google.common.util.concurrent.Monitor.Guard
    public final boolean isSatisfied() {
        C0993f1 c0993f1 = this.f15367e;
        if (c0993f1.f15381c.count(Service.State.RUNNING) != c0993f1.f15385g) {
            Service.State state = Service.State.STOPPING;
            Multiset multiset = c0993f1.f15381c;
            if (!multiset.contains(state) && !multiset.contains(Service.State.TERMINATED) && !multiset.contains(Service.State.FAILED)) {
                return false;
            }
        }
        return true;
    }
}
