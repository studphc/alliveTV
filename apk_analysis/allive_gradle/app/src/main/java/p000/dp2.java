package p000;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/* loaded from: classes2.dex */
public final class dp2 implements Condition {

    /* renamed from: a */
    public final Condition f16481a;

    public dp2(Condition condition) {
        this.f16481a = condition;
    }

    @Override // java.util.concurrent.locks.Condition
    public final void await() {
        this.f16481a.await();
    }

    @Override // java.util.concurrent.locks.Condition
    public final long awaitNanos(long j) {
        return this.f16481a.awaitNanos(j);
    }

    @Override // java.util.concurrent.locks.Condition
    public final void awaitUninterruptibly() {
        this.f16481a.awaitUninterruptibly();
    }

    @Override // java.util.concurrent.locks.Condition
    public final boolean awaitUntil(Date date) {
        return this.f16481a.awaitUntil(date);
    }

    @Override // java.util.concurrent.locks.Condition
    public final void signal() {
        this.f16481a.signal();
    }

    @Override // java.util.concurrent.locks.Condition
    public final void signalAll() {
        this.f16481a.signalAll();
    }

    @Override // java.util.concurrent.locks.Condition
    public final boolean await(long j, TimeUnit timeUnit) {
        return this.f16481a.await(j, timeUnit);
    }
}
