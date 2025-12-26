package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.schedulers.SchedulerWhen;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class me2 extends AtomicReference implements Disposable {
    public me2() {
        super(SchedulerWhen.f19868f);
    }

    /* renamed from: a */
    public abstract Disposable mo5441a(Scheduler.Worker worker, CompletableObserver completableObserver);

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        ((Disposable) getAndSet(SchedulerWhen.f19869g)).dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return ((Disposable) get()).isDisposed();
    }
}
