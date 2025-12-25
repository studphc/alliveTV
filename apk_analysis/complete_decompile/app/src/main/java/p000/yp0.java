package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class yp0 extends aq0 {
    private static final long serialVersionUID = -7139995637533111443L;

    /* renamed from: h */
    public final AtomicInteger f29057h;

    public yp0(SerializedSubscriber serializedSubscriber, long j, TimeUnit timeUnit, Scheduler scheduler) {
        super(serializedSubscriber, j, timeUnit, scheduler);
        this.f29057h = new AtomicInteger(1);
    }

    @Override // p000.aq0
    /* renamed from: a */
    public final void mo1958a() {
        m1959b();
        if (this.f29057h.decrementAndGet() == 0) {
            this.f7702a.onComplete();
        }
    }

    @Override // p000.aq0, java.lang.Runnable
    public final void run() {
        AtomicInteger atomicInteger = this.f29057h;
        if (atomicInteger.incrementAndGet() == 2) {
            m1959b();
            if (atomicInteger.decrementAndGet() == 0) {
                this.f7702a.onComplete();
            }
        }
    }
}
