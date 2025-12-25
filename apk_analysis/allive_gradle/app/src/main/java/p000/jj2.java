package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class jj2 extends AtomicReference implements Observer, SingleObserver, Disposable {
    private static final long serialVersionUID = -8948264376121066672L;

    /* renamed from: a */
    public final Observer f20524a;

    /* renamed from: b */
    public final Function f20525b;

    public jj2(Observer observer, Function function) {
        this.f20524a = observer;
        this.f20525b = function;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f20524a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f20524a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f20524a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        try {
            Object apply = this.f20525b.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null Publisher");
            ObservableSource observableSource = (ObservableSource) apply;
            if (!isDisposed()) {
                observableSource.subscribe(this);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f20524a.onError(th);
        }
    }
}
