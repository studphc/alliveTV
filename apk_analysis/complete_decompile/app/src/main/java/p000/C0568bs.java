package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: bs */
/* loaded from: classes2.dex */
public final class C0568bs extends AtomicReference implements Observer, CompletableObserver, Disposable {
    private static final long serialVersionUID = -8948264376121066672L;

    /* renamed from: a */
    public final Observer f8145a;

    /* renamed from: b */
    public ObservableSource f8146b;

    public C0568bs(ObservableSource observableSource, Observer observer) {
        this.f8146b = observableSource;
        this.f8145a = observer;
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
        ObservableSource observableSource = this.f8146b;
        if (observableSource == null) {
            this.f8145a.onComplete();
        } else {
            this.f8146b = null;
            observableSource.subscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f8145a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f8145a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this, disposable);
    }
}
