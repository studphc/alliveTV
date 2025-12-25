package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class iu1 extends AtomicReference implements Observer {
    private static final long serialVersionUID = -7449079488798789337L;

    /* renamed from: a */
    public final SerializedObserver f20268a;

    /* renamed from: b */
    public final ju1 f20269b;

    public iu1(SerializedObserver serializedObserver, ju1 ju1Var) {
        this.f20268a = serializedObserver;
        this.f20269b = ju1Var;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        ju1 ju1Var = this.f20269b;
        ju1Var.f20637g = false;
        ju1Var.m5462a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f20269b.dispose();
        this.f20268a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f20268a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this, disposable);
    }
}
