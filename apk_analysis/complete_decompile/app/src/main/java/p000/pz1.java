package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class pz1 extends AtomicReference implements Observer, Disposable, rz1 {
    private static final long serialVersionUID = -7508389464265974549L;

    /* renamed from: a */
    public final Observer f25346a;

    /* renamed from: b */
    public final Function f25347b;

    /* renamed from: c */
    public final SequentialDisposable f25348c = new SequentialDisposable();

    /* renamed from: d */
    public final AtomicLong f25349d = new AtomicLong();

    /* renamed from: e */
    public final AtomicReference f25350e = new AtomicReference();

    /* renamed from: f */
    public ObservableSource f25351f;

    public pz1(ObservableSource observableSource, Observer observer, Function function) {
        this.f25346a = observer;
        this.f25347b = function;
        this.f25351f = observableSource;
    }

    @Override // p000.uz1
    /* renamed from: a */
    public final void mo6936a(long j) {
        if (this.f25349d.compareAndSet(j, Long.MAX_VALUE)) {
            DisposableHelper.dispose(this.f25350e);
            ObservableSource observableSource = this.f25351f;
            this.f25351f = null;
            observableSource.subscribe(new hx1(this.f25346a, this, 1));
        }
    }

    @Override // p000.rz1
    /* renamed from: b */
    public final void mo6937b(long j, Throwable th) {
        if (this.f25349d.compareAndSet(j, Long.MAX_VALUE)) {
            DisposableHelper.dispose(this);
            this.f25346a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f25350e);
        DisposableHelper.dispose(this);
        this.f25348c.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (this.f25349d.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            SequentialDisposable sequentialDisposable = this.f25348c;
            sequentialDisposable.dispose();
            this.f25346a.onComplete();
            sequentialDisposable.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f25349d.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            SequentialDisposable sequentialDisposable = this.f25348c;
            sequentialDisposable.dispose();
            this.f25346a.onError(th);
            sequentialDisposable.dispose();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        AtomicLong atomicLong = this.f25349d;
        long j = atomicLong.get();
        if (j != Long.MAX_VALUE) {
            long j2 = 1 + j;
            if (atomicLong.compareAndSet(j, j2)) {
                SequentialDisposable sequentialDisposable = this.f25348c;
                Disposable disposable = sequentialDisposable.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                Observer observer = this.f25346a;
                observer.onNext(obj);
                try {
                    Object apply = this.f25347b.apply(obj);
                    Objects.requireNonNull(apply, "The itemTimeoutIndicator returned a null ObservableSource.");
                    ObservableSource observableSource = (ObservableSource) apply;
                    oz1 oz1Var = new oz1(j2, this);
                    if (sequentialDisposable.replace(oz1Var)) {
                        observableSource.subscribe(oz1Var);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    ((Disposable) this.f25350e.get()).dispose();
                    atomicLong.getAndSet(Long.MAX_VALUE);
                    observer.onError(th);
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f25350e, disposable);
    }
}
