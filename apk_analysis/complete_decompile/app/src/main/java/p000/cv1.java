package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class cv1 implements Observer, Disposable {

    /* renamed from: a */
    public final SerializedObserver f16123a;

    /* renamed from: b */
    public final Function f16124b;

    /* renamed from: c */
    public Disposable f16125c;

    /* renamed from: d */
    public final AtomicReference f16126d = new AtomicReference();

    /* renamed from: e */
    public volatile long f16127e;

    /* renamed from: f */
    public boolean f16128f;

    public cv1(SerializedObserver serializedObserver, Function function) {
        this.f16123a = serializedObserver;
        this.f16124b = function;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f16125c.dispose();
        DisposableHelper.dispose(this.f16126d);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f16125c.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (this.f16128f) {
            return;
        }
        this.f16128f = true;
        AtomicReference atomicReference = this.f16126d;
        Disposable disposable = (Disposable) atomicReference.get();
        if (disposable != DisposableHelper.DISPOSED) {
            bv1 bv1Var = (bv1) disposable;
            if (bv1Var != null) {
                bv1Var.m2167a();
            }
            DisposableHelper.dispose(atomicReference);
            this.f16123a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        DisposableHelper.dispose(this.f16126d);
        this.f16123a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f16128f) {
            return;
        }
        long j = this.f16127e + 1;
        this.f16127e = j;
        Disposable disposable = (Disposable) this.f16126d.get();
        if (disposable != null) {
            disposable.dispose();
        }
        try {
            Object apply = this.f16124b.apply(obj);
            Objects.requireNonNull(apply, "The ObservableSource supplied is null");
            ObservableSource observableSource = (ObservableSource) apply;
            bv1 bv1Var = new bv1(this, j, obj);
            AtomicReference atomicReference = this.f16126d;
            while (!atomicReference.compareAndSet(disposable, bv1Var)) {
                if (atomicReference.get() != disposable) {
                    return;
                }
            }
            observableSource.subscribe(bv1Var);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            dispose();
            this.f16123a.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f16125c, disposable)) {
            this.f16125c = disposable;
            this.f16123a.onSubscribe(this);
        }
    }
}
