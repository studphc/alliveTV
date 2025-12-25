package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;
import java.util.concurrent.TimeUnit;
import p000.C2042z2;
import p000.InterfaceC2005y2;
import p000.RunnableC1104d;
import p000.b01;
import p000.to1;

/* renamed from: com.google.common.util.concurrent.e */
/* loaded from: classes2.dex */
public final class C0988e extends AbstractScheduledService.Scheduler {

    /* renamed from: a */
    public final /* synthetic */ long f15368a;

    /* renamed from: b */
    public final /* synthetic */ long f15369b;

    /* renamed from: c */
    public final /* synthetic */ TimeUnit f15370c;

    public C0988e(long j, long j2, TimeUnit timeUnit) {
        this.f15368a = j;
        this.f15369b = j2;
        this.f15370c = timeUnit;
    }

    @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
    /* renamed from: a */
    public final InterfaceC2005y2 mo4314a(C2042z2 c2042z2, to1 to1Var, RunnableC1104d runnableC1104d) {
        return new b01(2, to1Var.scheduleWithFixedDelay(runnableC1104d, this.f15368a, this.f15369b, this.f15370c));
    }
}
