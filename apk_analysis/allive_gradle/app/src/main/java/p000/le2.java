package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class le2 extends Scheduler.Worker {

    /* renamed from: a */
    public final AtomicBoolean f22482a = new AtomicBoolean();

    /* renamed from: b */
    public final FlowableProcessor f22483b;

    /* renamed from: c */
    public final Scheduler.Worker f22484c;

    public le2(FlowableProcessor flowableProcessor, Scheduler.Worker worker) {
        this.f22483b = flowableProcessor;
        this.f22484c = worker;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (this.f22482a.compareAndSet(false, true)) {
            this.f22483b.onComplete();
            this.f22484c.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f22482a.get();
    }

    @Override // io.reactivex.rxjava3.core.Scheduler.Worker
    public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        je2 je2Var = new je2(runnable, j, timeUnit);
        this.f22483b.onNext(je2Var);
        return je2Var;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler.Worker
    public final Disposable schedule(Runnable runnable) {
        ke2 ke2Var = new ke2(runnable);
        this.f22483b.onNext(ke2Var);
        return ke2Var;
    }
}
