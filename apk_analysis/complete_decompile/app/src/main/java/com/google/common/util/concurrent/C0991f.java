package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;
import java.util.concurrent.TimeUnit;
import p000.C2042z2;
import p000.InterfaceC2005y2;
import p000.RunnableC1104d;
import p000.b01;
import p000.to1;

/* renamed from: com.google.common.util.concurrent.f */
/* loaded from: classes2.dex */
public final class C0991f extends AbstractScheduledService.Scheduler {

    /* renamed from: a */
    public final /* synthetic */ long f15374a;

    /* renamed from: b */
    public final /* synthetic */ long f15375b;

    /* renamed from: c */
    public final /* synthetic */ TimeUnit f15376c;

    public C0991f(long j, long j2, TimeUnit timeUnit) {
        this.f15374a = j;
        this.f15375b = j2;
        this.f15376c = timeUnit;
    }

    @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
    /* renamed from: a */
    public final InterfaceC2005y2 mo4314a(C2042z2 c2042z2, to1 to1Var, RunnableC1104d runnableC1104d) {
        return new b01(2, to1Var.scheduleAtFixedRate(runnableC1104d, this.f15374a, this.f15375b, this.f15376c));
    }
}
