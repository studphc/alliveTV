package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class hy1 extends jy1 {
    private static final long serialVersionUID = -7139995637533111443L;

    /* renamed from: g */
    public final AtomicInteger f18216g;

    public hy1(SerializedObserver serializedObserver, long j, TimeUnit timeUnit, Scheduler scheduler) {
        super(serializedObserver, j, timeUnit, scheduler);
        this.f18216g = new AtomicInteger(1);
    }

    @Override // p000.jy1
    /* renamed from: a */
    public final void mo5141a() {
        Object andSet = getAndSet(null);
        SerializedObserver serializedObserver = this.f20681a;
        if (andSet != null) {
            serializedObserver.onNext(andSet);
        }
        if (this.f18216g.decrementAndGet() == 0) {
            serializedObserver.onComplete();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicInteger atomicInteger = this.f18216g;
        if (atomicInteger.incrementAndGet() == 2) {
            Object andSet = getAndSet(null);
            SerializedObserver serializedObserver = this.f20681a;
            if (andSet != null) {
                serializedObserver.onNext(andSet);
            }
            if (atomicInteger.decrementAndGet() == 0) {
                serializedObserver.onComplete();
            }
        }
    }
}
