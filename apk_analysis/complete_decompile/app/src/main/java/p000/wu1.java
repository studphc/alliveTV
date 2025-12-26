package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class wu1 extends AtomicReference implements Observer, MaybeObserver, Disposable {
    private static final long serialVersionUID = -1953724749712440952L;

    /* renamed from: a */
    public final Observer f28335a;

    /* renamed from: b */
    public MaybeSource f28336b;

    /* renamed from: c */
    public boolean f28337c;

    public wu1(Observer observer, MaybeSource maybeSource) {
        this.f28335a = observer;
        this.f28336b = maybeSource;
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
        if (this.f28337c) {
            this.f28335a.onComplete();
            return;
        }
        this.f28337c = true;
        DisposableHelper.replace(this, null);
        MaybeSource maybeSource = this.f28336b;
        this.f28336b = null;
        maybeSource.subscribe(this);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f28335a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f28335a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable) && !this.f28337c) {
            this.f28335a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        Observer observer = this.f28335a;
        observer.onNext(obj);
        observer.onComplete();
    }
}
