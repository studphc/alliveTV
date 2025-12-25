package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;
import p000.C2042z2;
import p000.InterfaceC2005y2;
import p000.RunnableC1104d;
import p000.b01;
import p000.to1;

/* renamed from: com.google.common.util.concurrent.c */
/* loaded from: classes2.dex */
public final class CallableC0982c implements Callable {

    /* renamed from: a */
    public final RunnableC1104d f15355a;

    /* renamed from: b */
    public final to1 f15356b;

    /* renamed from: c */
    public final C2042z2 f15357c;

    /* renamed from: d */
    public final ReentrantLock f15358d = new ReentrantLock();

    /* renamed from: e */
    public C0985d f15359e;

    /* renamed from: f */
    public final /* synthetic */ AbstractScheduledService.CustomScheduler f15360f;

    public CallableC0982c(AbstractScheduledService.CustomScheduler customScheduler, C2042z2 c2042z2, to1 to1Var, RunnableC1104d runnableC1104d) {
        this.f15360f = customScheduler;
        this.f15355a = runnableC1104d;
        this.f15356b = to1Var;
        this.f15357c = c2042z2;
    }

    /* renamed from: a */
    public final InterfaceC2005y2 m4347a() {
        InterfaceC2005y2 interfaceC2005y2;
        C0985d c0985d;
        C2042z2 c2042z2 = this.f15357c;
        try {
            AbstractScheduledService.CustomScheduler.Schedule nextSchedule = this.f15360f.getNextSchedule();
            ReentrantLock reentrantLock = this.f15358d;
            reentrantLock.lock();
            try {
                C0985d c0985d2 = this.f15359e;
                to1 to1Var = this.f15356b;
                if (c0985d2 == null) {
                    C0985d c0985d3 = new C0985d(reentrantLock, to1Var.schedule(this, nextSchedule.f15262a, nextSchedule.f15263b));
                    this.f15359e = c0985d3;
                    c0985d = c0985d3;
                } else {
                    if (!c0985d2.f15364b.isCancelled()) {
                        this.f15359e.f15364b = to1Var.schedule(this, nextSchedule.f15262a, nextSchedule.f15263b);
                    }
                    c0985d = this.f15359e;
                }
                reentrantLock.unlock();
                th = null;
                interfaceC2005y2 = c0985d;
            } catch (Throwable th) {
                th = th;
                try {
                } finally {
                    reentrantLock.unlock();
                }
            }
            if (th != null) {
                c2042z2.notifyFailed(th);
            }
            return interfaceC2005y2;
        } catch (Throwable th2) {
            c2042z2.notifyFailed(th2);
            return new b01(2, Futures.immediateCancelledFuture());
        }
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        this.f15355a.run();
        m4347a();
        return null;
    }
}
