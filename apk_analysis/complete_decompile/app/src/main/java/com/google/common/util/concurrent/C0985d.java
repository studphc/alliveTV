package com.google.common.util.concurrent;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.locks.ReentrantLock;
import p000.InterfaceC2005y2;

/* renamed from: com.google.common.util.concurrent.d */
/* loaded from: classes2.dex */
public final class C0985d implements InterfaceC2005y2 {

    /* renamed from: a */
    public final ReentrantLock f15363a;

    /* renamed from: b */
    public ScheduledFuture f15364b;

    public C0985d(ReentrantLock reentrantLock, ScheduledFuture scheduledFuture) {
        this.f15363a = reentrantLock;
        this.f15364b = scheduledFuture;
    }

    @Override // p000.InterfaceC2005y2
    public final void cancel() {
        ReentrantLock reentrantLock = this.f15363a;
        reentrantLock.lock();
        try {
            this.f15364b.cancel(false);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // p000.InterfaceC2005y2
    public final boolean isCancelled() {
        ReentrantLock reentrantLock = this.f15363a;
        reentrantLock.lock();
        try {
            return this.f15364b.isCancelled();
        } finally {
            reentrantLock.unlock();
        }
    }
}
