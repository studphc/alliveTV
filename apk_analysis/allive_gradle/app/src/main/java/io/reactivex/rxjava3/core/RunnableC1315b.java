package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection;

/* renamed from: io.reactivex.rxjava3.core.b */
/* loaded from: classes2.dex */
public final class RunnableC1315b implements Disposable, Runnable, SchedulerRunnableIntrospection {

    /* renamed from: a */
    public final Runnable f18496a;

    /* renamed from: b */
    public final Scheduler.Worker f18497b;

    /* renamed from: c */
    public volatile boolean f18498c;

    public RunnableC1315b(Runnable runnable, Scheduler.Worker worker) {
        this.f18496a = runnable;
        this.f18497b = worker;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f18498c = true;
        this.f18497b.dispose();
    }

    @Override // io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection
    public final Runnable getWrappedRunnable() {
        return this.f18496a;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f18498c;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.f18498c) {
            try {
                this.f18496a.run();
            } catch (Throwable th) {
                dispose();
                RxJavaPlugins.onError(th);
                throw th;
            }
        }
    }
}
