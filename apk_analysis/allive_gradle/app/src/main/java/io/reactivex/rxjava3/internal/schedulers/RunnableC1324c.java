package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: io.reactivex.rxjava3.internal.schedulers.c */
/* loaded from: classes2.dex */
public final class RunnableC1324c extends AtomicInteger implements Runnable, Disposable {
    private static final long serialVersionUID = -3603436687413320876L;

    /* renamed from: a */
    public final Runnable f19882a;

    /* renamed from: b */
    public final DisposableContainer f19883b;

    /* renamed from: c */
    public volatile Thread f19884c;

    public RunnableC1324c(Runnable runnable, DisposableContainer disposableContainer) {
        this.f19882a = runnable;
        this.f19883b = disposableContainer;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        while (true) {
            int i = get();
            if (i < 2) {
                if (i == 0) {
                    if (compareAndSet(0, 4)) {
                        DisposableContainer disposableContainer = this.f19883b;
                        if (disposableContainer != null) {
                            disposableContainer.delete(this);
                            return;
                        }
                        return;
                    }
                } else if (compareAndSet(1, 3)) {
                    Thread thread = this.f19884c;
                    if (thread != null) {
                        thread.interrupt();
                        this.f19884c = null;
                    }
                    set(4);
                    DisposableContainer disposableContainer2 = this.f19883b;
                    if (disposableContainer2 != null) {
                        disposableContainer2.delete(this);
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (get() >= 2) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (get() == 0) {
            this.f19884c = Thread.currentThread();
            if (compareAndSet(0, 1)) {
                try {
                    this.f19882a.run();
                    this.f19884c = null;
                    if (compareAndSet(1, 2)) {
                        DisposableContainer disposableContainer = this.f19883b;
                        if (disposableContainer != null) {
                            disposableContainer.delete(this);
                            return;
                        }
                        return;
                    }
                    while (get() == 3) {
                        Thread.yield();
                    }
                    Thread.interrupted();
                    return;
                } catch (Throwable th) {
                    try {
                        RxJavaPlugins.onError(th);
                        throw th;
                    } catch (Throwable th2) {
                        this.f19884c = null;
                        if (!compareAndSet(1, 2)) {
                            while (get() == 3) {
                                Thread.yield();
                            }
                            Thread.interrupted();
                        } else {
                            DisposableContainer disposableContainer2 = this.f19883b;
                            if (disposableContainer2 != null) {
                                disposableContainer2.delete(this);
                            }
                        }
                        throw th2;
                    }
                }
            }
            this.f19884c = null;
        }
    }
}
