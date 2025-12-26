package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p000.ye0;

/* loaded from: classes2.dex */
public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, Disposable {

    /* renamed from: b */
    public static final Object f19863b = new Object();

    /* renamed from: c */
    public static final Object f19864c = new Object();

    /* renamed from: d */
    public static final Object f19865d = new Object();

    /* renamed from: e */
    public static final Object f19866e = new Object();
    private static final long serialVersionUID = -6120223772001106981L;

    /* renamed from: a */
    public final Runnable f19867a;

    public ScheduledRunnable(Runnable runnable, DisposableContainer disposableContainer) {
        super(3);
        this.f19867a = runnable;
        lazySet(0, disposableContainer);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        boolean z;
        while (true) {
            Object obj6 = get(1);
            obj = f19866e;
            if (obj6 == obj || obj6 == (obj4 = f19864c) || obj6 == (obj5 = f19865d)) {
                break;
            }
            if (get(2) != Thread.currentThread()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                obj4 = obj5;
            }
            if (compareAndSet(1, obj6, obj4)) {
                if (obj6 != null) {
                    ((Future) obj6).cancel(z);
                }
            }
        }
        do {
            obj2 = get(0);
            if (obj2 == obj || obj2 == (obj3 = f19863b) || obj2 == null) {
                return;
            }
        } while (!compareAndSet(0, obj2, obj3));
        ((DisposableContainer) obj2).delete(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        Object obj = get(0);
        if (obj != f19863b && obj != f19866e) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3 = f19865d;
        Object obj4 = f19864c;
        Object obj5 = f19863b;
        Object obj6 = f19866e;
        lazySet(2, Thread.currentThread());
        try {
            this.f19867a.run();
            Object obj7 = get(0);
            if (obj7 != obj5 && compareAndSet(0, obj7, obj6) && obj7 != null) {
                ((DisposableContainer) obj7).delete(this);
            }
            do {
                obj2 = get(1);
                if (obj2 == obj4 || obj2 == obj3) {
                    break;
                }
            } while (!compareAndSet(1, obj2, obj6));
            lazySet(2, null);
        } catch (Throwable th) {
            try {
                RxJavaPlugins.onError(th);
                throw th;
            } catch (Throwable th2) {
                Object obj8 = get(0);
                if (obj8 != obj5 && compareAndSet(0, obj8, obj6) && obj8 != null) {
                    ((DisposableContainer) obj8).delete(this);
                }
                do {
                    obj = get(1);
                    if (obj == obj4 || obj == obj3) {
                        break;
                    }
                } while (!compareAndSet(1, obj, obj6));
                lazySet(2, null);
                throw th2;
            }
        }
    }

    public void setFuture(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == f19866e) {
                return;
            }
            if (obj == f19864c) {
                future.cancel(false);
                return;
            } else if (obj == f19865d) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    public String toString() {
        String str;
        Object obj = get(1);
        if (obj == f19866e) {
            str = "Finished";
        } else if (obj == f19864c) {
            str = "Disposed(Sync)";
        } else if (obj == f19865d) {
            str = "Disposed(Async)";
        } else {
            Object obj2 = get(2);
            if (obj2 == null) {
                str = "Waiting";
            } else {
                str = "Running on " + obj2;
            }
        }
        return ye0.m8296p("ScheduledRunnable[", str, "]");
    }
}
