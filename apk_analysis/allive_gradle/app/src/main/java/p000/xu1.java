package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class xu1 extends AtomicReference implements Observer, SingleObserver, Disposable {
    private static final long serialVersionUID = -1953724749712440952L;

    /* renamed from: a */
    public final Observer f28739a;

    /* renamed from: b */
    public SingleSource f28740b;

    /* renamed from: c */
    public boolean f28741c;

    public xu1(Observer observer, SingleSource singleSource) {
        this.f28739a = observer;
        this.f28740b = singleSource;
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
        this.f28741c = true;
        DisposableHelper.replace(this, null);
        SingleSource singleSource = this.f28740b;
        this.f28740b = null;
        singleSource.subscribe(this);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f28739a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f28739a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable) && !this.f28741c) {
            this.f28739a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        Observer observer = this.f28739a;
        observer.onNext(obj);
        observer.onComplete();
    }
}
