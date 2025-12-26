package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.schedulers.NewThreadWorker;
import io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection;

/* renamed from: io.reactivex.rxjava3.core.a */
/* loaded from: classes2.dex */
public final class RunnableC1314a implements Disposable, Runnable, SchedulerRunnableIntrospection {

    /* renamed from: a */
    public final Runnable f18493a;

    /* renamed from: b */
    public final Scheduler.Worker f18494b;

    /* renamed from: c */
    public Thread f18495c;

    public RunnableC1314a(Runnable runnable, Scheduler.Worker worker) {
        this.f18493a = runnable;
        this.f18494b = worker;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        Thread thread = this.f18495c;
        Thread currentThread = Thread.currentThread();
        Scheduler.Worker worker = this.f18494b;
        if (thread == currentThread && (worker instanceof NewThreadWorker)) {
            ((NewThreadWorker) worker).shutdown();
        } else {
            worker.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection
    public final Runnable getWrappedRunnable() {
        return this.f18493a;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f18494b.isDisposed();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f18495c = Thread.currentThread();
        try {
            this.f18493a.run();
        } finally {
        }
    }
}
