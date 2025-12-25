package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;

/* loaded from: classes2.dex */
public final class ty1 implements Observer {

    /* renamed from: a */
    public final ArrayCompositeDisposable f27025a;

    /* renamed from: b */
    public final uy1 f27026b;

    /* renamed from: c */
    public final SerializedObserver f27027c;

    /* renamed from: d */
    public Disposable f27028d;

    public ty1(ArrayCompositeDisposable arrayCompositeDisposable, uy1 uy1Var, SerializedObserver serializedObserver) {
        this.f27025a = arrayCompositeDisposable;
        this.f27026b = uy1Var;
        this.f27027c = serializedObserver;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f27026b.f27547d = true;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f27025a.dispose();
        this.f27027c.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f27028d.dispose();
        this.f27026b.f27547d = true;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f27028d, disposable)) {
            this.f27028d = disposable;
            this.f27025a.setResource(1, disposable);
        }
    }
}
