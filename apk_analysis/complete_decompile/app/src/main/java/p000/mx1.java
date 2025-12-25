package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableRefCount;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class mx1 extends AtomicBoolean implements Observer, Disposable {
    private static final long serialVersionUID = -7419642935409022375L;

    /* renamed from: a */
    public final Observer f23152a;

    /* renamed from: b */
    public final ObservableRefCount f23153b;

    /* renamed from: c */
    public final lx1 f23154c;

    /* renamed from: d */
    public Disposable f23155d;

    public mx1(Observer observer, ObservableRefCount observableRefCount, lx1 lx1Var) {
        this.f23152a = observer;
        this.f23153b = observableRefCount;
        this.f23154c = lx1Var;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f23155d.dispose();
        if (compareAndSet(false, true)) {
            ObservableRefCount observableRefCount = this.f23153b;
            lx1 lx1Var = this.f23154c;
            synchronized (observableRefCount) {
                try {
                    lx1 lx1Var2 = observableRefCount.f19524f;
                    if (lx1Var2 != null && lx1Var2 == lx1Var) {
                        long j = lx1Var.f22704c - 1;
                        lx1Var.f22704c = j;
                        if (j == 0 && lx1Var.f22705d) {
                            if (observableRefCount.f19521c == 0) {
                                observableRefCount.m5293e(lx1Var);
                            } else {
                                SequentialDisposable sequentialDisposable = new SequentialDisposable();
                                lx1Var.f22703b = sequentialDisposable;
                                sequentialDisposable.replace(observableRefCount.f19523e.scheduleDirect(lx1Var, observableRefCount.f19521c, observableRefCount.f19522d));
                            }
                        }
                    }
                } finally {
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f23155d.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (compareAndSet(false, true)) {
            this.f23153b.m5292d(this.f23154c);
            this.f23152a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (compareAndSet(false, true)) {
            this.f23153b.m5292d(this.f23154c);
            this.f23152a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f23152a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f23155d, disposable)) {
            this.f23155d = disposable;
            this.f23152a.onSubscribe(this);
        }
    }
}
