package p000;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* loaded from: classes2.dex */
public final class ep2 implements Lock {

    /* renamed from: a */
    public final Lock f16944a;

    public ep2(Lock lock, fp2 fp2Var) {
        this.f16944a = lock;
    }

    @Override // java.util.concurrent.locks.Lock
    public final void lock() {
        this.f16944a.lock();
    }

    @Override // java.util.concurrent.locks.Lock
    public final void lockInterruptibly() {
        this.f16944a.lockInterruptibly();
    }

    @Override // java.util.concurrent.locks.Lock
    public final Condition newCondition() {
        return new dp2(this.f16944a.newCondition());
    }

    @Override // java.util.concurrent.locks.Lock
    public final boolean tryLock() {
        return this.f16944a.tryLock();
    }

    @Override // java.util.concurrent.locks.Lock
    public final void unlock() {
        this.f16944a.unlock();
    }

    @Override // java.util.concurrent.locks.Lock
    public final boolean tryLock(long j, TimeUnit timeUnit) {
        return this.f16944a.tryLock(j, timeUnit);
    }
}
