package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;

/* loaded from: classes2.dex */
public final class uy1 implements Observer {

    /* renamed from: a */
    public final SerializedObserver f27544a;

    /* renamed from: b */
    public final ArrayCompositeDisposable f27545b;

    /* renamed from: c */
    public Disposable f27546c;

    /* renamed from: d */
    public volatile boolean f27547d;

    /* renamed from: e */
    public boolean f27548e;

    public uy1(SerializedObserver serializedObserver, ArrayCompositeDisposable arrayCompositeDisposable) {
        this.f27544a = serializedObserver;
        this.f27545b = arrayCompositeDisposable;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f27545b.dispose();
        this.f27544a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f27545b.dispose();
        this.f27544a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f27548e) {
            this.f27544a.onNext(obj);
        } else if (this.f27547d) {
            this.f27548e = true;
            this.f27544a.onNext(obj);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f27546c, disposable)) {
            this.f27546c = disposable;
            this.f27545b.setResource(0, disposable);
        }
    }
}
