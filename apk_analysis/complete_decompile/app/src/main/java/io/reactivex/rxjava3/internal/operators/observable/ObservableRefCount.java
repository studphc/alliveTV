package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import java.util.concurrent.TimeUnit;
import p000.lx1;
import p000.mx1;

/* loaded from: classes2.dex */
public final class ObservableRefCount<T> extends Observable<T> {

    /* renamed from: a */
    public final ConnectableObservable f19519a;

    /* renamed from: b */
    public final int f19520b;

    /* renamed from: c */
    public final long f19521c;

    /* renamed from: d */
    public final TimeUnit f19522d;

    /* renamed from: e */
    public final Scheduler f19523e;

    /* renamed from: f */
    public lx1 f19524f;

    public ObservableRefCount(ConnectableObservable<T> connectableObservable) {
        this(connectableObservable, 1, 0L, TimeUnit.NANOSECONDS, null);
    }

    /* renamed from: d */
    public final void m5292d(lx1 lx1Var) {
        synchronized (this) {
            try {
                if (this.f19524f == lx1Var) {
                    SequentialDisposable sequentialDisposable = lx1Var.f22703b;
                    if (sequentialDisposable != null) {
                        sequentialDisposable.dispose();
                        lx1Var.f22703b = null;
                    }
                    long j = lx1Var.f22704c - 1;
                    lx1Var.f22704c = j;
                    if (j == 0) {
                        this.f19524f = null;
                        this.f19519a.reset();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: e */
    public final void m5293e(lx1 lx1Var) {
        synchronized (this) {
            try {
                if (lx1Var.f22704c == 0 && lx1Var == this.f19524f) {
                    this.f19524f = null;
                    Disposable disposable = (Disposable) lx1Var.get();
                    DisposableHelper.dispose(lx1Var);
                    if (disposable == null) {
                        lx1Var.f22706e = true;
                    } else {
                        this.f19519a.reset();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        lx1 lx1Var;
        boolean z;
        SequentialDisposable sequentialDisposable;
        synchronized (this) {
            try {
                lx1Var = this.f19524f;
                if (lx1Var == null) {
                    lx1Var = new lx1(this);
                    this.f19524f = lx1Var;
                }
                long j = lx1Var.f22704c;
                if (j == 0 && (sequentialDisposable = lx1Var.f22703b) != null) {
                    sequentialDisposable.dispose();
                }
                long j2 = j + 1;
                lx1Var.f22704c = j2;
                if (!lx1Var.f22705d && j2 == this.f19520b) {
                    z = true;
                    lx1Var.f22705d = true;
                } else {
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f19519a.subscribe(new mx1(observer, this, lx1Var));
        if (z) {
            this.f19519a.connect(lx1Var);
        }
    }

    public ObservableRefCount(ConnectableObservable<T> connectableObservable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f19519a = connectableObservable;
        this.f19520b = i;
        this.f19521c = j;
        this.f19522d = timeUnit;
        this.f19523e = scheduler;
    }
}
