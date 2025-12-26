package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ww1 implements Observer, Disposable {

    /* renamed from: a */
    public final Observer f28368a;

    /* renamed from: b */
    public final Function f28369b;

    /* renamed from: c */
    public final Function f28370c;

    /* renamed from: d */
    public final Supplier f28371d;

    /* renamed from: e */
    public Disposable f28372e;

    public ww1(Observer observer, Function function, Function function2, Supplier supplier) {
        this.f28368a = observer;
        this.f28369b = function;
        this.f28370c = function2;
        this.f28371d = supplier;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f28372e.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f28372e.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        Observer observer = this.f28368a;
        try {
            Object obj = this.f28371d.get();
            Objects.requireNonNull(obj, "The onComplete ObservableSource returned is null");
            observer.onNext((ObservableSource) obj);
            observer.onComplete();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            observer.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        Observer observer = this.f28368a;
        try {
            Object apply = this.f28370c.apply(th);
            Objects.requireNonNull(apply, "The onError ObservableSource returned is null");
            observer.onNext((ObservableSource) apply);
            observer.onComplete();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            observer.onError(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        Observer observer = this.f28368a;
        try {
            Object apply = this.f28369b.apply(obj);
            Objects.requireNonNull(apply, "The onNext ObservableSource returned is null");
            observer.onNext((ObservableSource) apply);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            observer.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f28372e, disposable)) {
            this.f28372e = disposable;
            this.f28368a.onSubscribe(this);
        }
    }
}
