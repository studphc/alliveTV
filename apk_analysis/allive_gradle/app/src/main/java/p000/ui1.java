package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ui1 extends AtomicReference implements Observer, MaybeObserver, Disposable {
    private static final long serialVersionUID = -8948264376121066672L;

    /* renamed from: a */
    public final Observer f27287a;

    /* renamed from: b */
    public final Function f27288b;

    public ui1(Observer observer, Function function) {
        this.f27287a = observer;
        this.f27288b = function;
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
        this.f27287a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f27287a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f27287a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        try {
            Object apply = this.f27288b.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null Publisher");
            ObservableSource observableSource = (ObservableSource) apply;
            if (!isDisposed()) {
                observableSource.subscribe(this);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f27287a.onError(th);
        }
    }
}
