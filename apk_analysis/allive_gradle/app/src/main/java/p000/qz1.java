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
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class qz1 extends AtomicLong implements Observer, Disposable, rz1 {
    private static final long serialVersionUID = 3764492702657003550L;

    /* renamed from: a */
    public final Observer f25812a;

    /* renamed from: b */
    public final Function f25813b;

    /* renamed from: c */
    public final SequentialDisposable f25814c = new SequentialDisposable();

    /* renamed from: d */
    public final AtomicReference f25815d = new AtomicReference();

    public qz1(Observer observer, Function function) {
        this.f25812a = observer;
        this.f25813b = function;
    }

    @Override // p000.uz1
    /* renamed from: a */
    public final void mo6936a(long j) {
        if (compareAndSet(j, Long.MAX_VALUE)) {
            DisposableHelper.dispose(this.f25815d);
            this.f25812a.onError(new TimeoutException());
        }
    }

    @Override // p000.rz1
    /* renamed from: b */
    public final void mo6937b(long j, Throwable th) {
        if (compareAndSet(j, Long.MAX_VALUE)) {
            DisposableHelper.dispose(this.f25815d);
            this.f25812a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f25815d);
        this.f25814c.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) this.f25815d.get());
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.f25814c.dispose();
            this.f25812a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.f25814c.dispose();
            this.f25812a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        long j = get();
        if (j != Long.MAX_VALUE) {
            long j2 = 1 + j;
            if (compareAndSet(j, j2)) {
                SequentialDisposable sequentialDisposable = this.f25814c;
                Disposable disposable = sequentialDisposable.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                Observer observer = this.f25812a;
                observer.onNext(obj);
                try {
                    Object apply = this.f25813b.apply(obj);
                    Objects.requireNonNull(apply, "The itemTimeoutIndicator returned a null ObservableSource.");
                    ObservableSource observableSource = (ObservableSource) apply;
                    oz1 oz1Var = new oz1(j2, this);
                    if (sequentialDisposable.replace(oz1Var)) {
                        observableSource.subscribe(oz1Var);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    ((Disposable) this.f25815d.get()).dispose();
                    getAndSet(Long.MAX_VALUE);
                    observer.onError(th);
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f25815d, disposable);
    }
}
