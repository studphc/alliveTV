package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class vu1 extends AtomicReference implements Observer, CompletableObserver, Disposable {
    private static final long serialVersionUID = -1953724749712440952L;

    /* renamed from: a */
    public final Observer f27972a;

    /* renamed from: b */
    public CompletableSource f27973b;

    /* renamed from: c */
    public boolean f27974c;

    public vu1(Observer observer, CompletableSource completableSource) {
        this.f27972a = observer;
        this.f27973b = completableSource;
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
        if (this.f27974c) {
            this.f27972a.onComplete();
            return;
        }
        this.f27974c = true;
        DisposableHelper.replace(this, null);
        CompletableSource completableSource = this.f27973b;
        this.f27973b = null;
        completableSource.subscribe(this);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f27972a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f27972a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable) && !this.f27974c) {
            this.f27972a.onSubscribe(this);
        }
    }
}
