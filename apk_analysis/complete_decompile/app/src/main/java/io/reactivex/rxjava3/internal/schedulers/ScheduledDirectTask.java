package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import p000.AbstractC1965x;

/* loaded from: classes2.dex */
public final class ScheduledDirectTask extends AbstractC1965x implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectTask(Runnable runnable, boolean z) {
        super(runnable, z);
    }

    @Override // io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection
    public Runnable getWrappedRunnable() {
        return this.runnable;
    }

    @Override // p000.AbstractC1965x, java.util.concurrent.atomic.AtomicReference
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // java.util.concurrent.Callable
    public Void call() {
        this.runner = Thread.currentThread();
        try {
            try {
                this.runnable.run();
                return null;
            } finally {
                lazySet(AbstractC1965x.FINISHED);
                this.runner = null;
            }
        } catch (Throwable th) {
            RxJavaPlugins.onError(th);
            throw th;
        }
    }
}
