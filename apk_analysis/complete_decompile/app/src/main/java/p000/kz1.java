package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class kz1 extends AtomicInteger implements Observer, Disposable {
    private static final long serialVersionUID = 1418547743690811973L;

    /* renamed from: a */
    public final Observer f22254a;

    /* renamed from: b */
    public final AtomicReference f22255b = new AtomicReference();

    /* renamed from: c */
    public final jz1 f22256c = new jz1(this);

    /* renamed from: d */
    public final AtomicThrowable f22257d = new AtomicThrowable();

    public kz1(Observer observer) {
        this.f22254a = observer;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f22255b);
        DisposableHelper.dispose(this.f22256c);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) this.f22255b.get());
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        DisposableHelper.dispose(this.f22256c);
        HalfSerializer.onComplete((Observer<?>) this.f22254a, this, this.f22257d);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        DisposableHelper.dispose(this.f22256c);
        HalfSerializer.onError((Observer<?>) this.f22254a, th, this, this.f22257d);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        HalfSerializer.onNext((Observer<? super Object>) this.f22254a, obj, this, this.f22257d);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f22255b, disposable);
    }
}
