package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ru1 extends AtomicReference implements Observer {
    private static final long serialVersionUID = -7449079488798789337L;

    /* renamed from: a */
    public final SerializedObserver f26153a;

    /* renamed from: b */
    public final su1 f26154b;

    public ru1(SerializedObserver serializedObserver, su1 su1Var) {
        this.f26153a = serializedObserver;
        this.f26154b = su1Var;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        su1 su1Var = this.f26154b;
        su1Var.f26565h = false;
        if (su1Var.getAndIncrement() == 0) {
            su1Var.f26562e.schedule(su1Var);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f26154b.dispose();
        this.f26153a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f26153a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this, disposable);
    }
}
