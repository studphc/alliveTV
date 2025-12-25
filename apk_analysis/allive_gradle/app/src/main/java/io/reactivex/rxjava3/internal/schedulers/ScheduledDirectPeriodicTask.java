package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import p000.AbstractC1965x;

/* loaded from: classes2.dex */
public final class ScheduledDirectPeriodicTask extends AbstractC1965x implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectPeriodicTask(Runnable runnable, boolean z) {
        super(runnable, z);
    }

    @Override // io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection
    public Runnable getWrappedRunnable() {
        return this.runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
            this.runner = null;
        } catch (Throwable th) {
            dispose();
            this.runner = null;
            RxJavaPlugins.onError(th);
            throw th;
        }
    }

    @Override // p000.AbstractC1965x, java.util.concurrent.atomic.AtomicReference
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
