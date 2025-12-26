package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;
import p000.C2042z2;

/* renamed from: com.google.common.util.concurrent.h */
/* loaded from: classes2.dex */
public final class RunnableC0996h implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C2042z2 f15392a;

    public RunnableC0996h(C2042z2 c2042z2) {
        this.f15392a = c2042z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2042z2 c2042z2;
        this.f15392a.f29223r.lock();
        try {
            this.f15392a.f29225t.startUp();
            C2042z2 c2042z22 = this.f15392a;
            AbstractScheduledService.Scheduler scheduler = c2042z22.f29225t.scheduler();
            C2042z2 c2042z23 = this.f15392a;
            c2042z22.f29221p = scheduler.mo4314a(c2042z23.f29225t.f15261a, c2042z23.f29222q, this.f15392a.f29224s);
            this.f15392a.notifyStarted();
            c2042z2 = this.f15392a;
        } catch (Throwable th) {
            try {
                this.f15392a.notifyFailed(th);
                if (this.f15392a.f29221p != null) {
                    this.f15392a.f29221p.cancel();
                }
                c2042z2 = this.f15392a;
            } catch (Throwable th2) {
                this.f15392a.f29223r.unlock();
                throw th2;
            }
        }
        c2042z2.f29223r.unlock();
    }
}
