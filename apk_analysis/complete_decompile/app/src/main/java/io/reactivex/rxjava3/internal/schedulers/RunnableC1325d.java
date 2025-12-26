package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler;

/* renamed from: io.reactivex.rxjava3.internal.schedulers.d */
/* loaded from: classes2.dex */
public final class RunnableC1325d implements Runnable {

    /* renamed from: a */
    public final SequentialDisposable f19885a;

    /* renamed from: b */
    public final Runnable f19886b;

    /* renamed from: c */
    public final /* synthetic */ ExecutorScheduler.ExecutorWorker f19887c;

    public RunnableC1325d(ExecutorScheduler.ExecutorWorker executorWorker, SequentialDisposable sequentialDisposable, Runnable runnable) {
        this.f19887c = executorWorker;
        this.f19885a = sequentialDisposable;
        this.f19886b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f19885a.replace(this.f19887c.schedule(this.f19886b));
    }
}
