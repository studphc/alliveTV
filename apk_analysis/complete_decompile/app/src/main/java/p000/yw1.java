package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class yw1 extends AtomicInteger implements Observer, Disposable {
    private static final long serialVersionUID = -4592979584110982903L;

    /* renamed from: a */
    public final Observer f29150a;

    /* renamed from: b */
    public final AtomicReference f29151b = new AtomicReference();

    /* renamed from: c */
    public final xw1 f29152c = new xw1(this);

    /* renamed from: d */
    public final AtomicThrowable f29153d = new AtomicThrowable();

    /* renamed from: e */
    public volatile boolean f29154e;

    /* renamed from: f */
    public volatile boolean f29155f;

    public yw1(Observer observer) {
        this.f29150a = observer;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f29151b);
        DisposableHelper.dispose(this.f29152c);
        this.f29153d.tryTerminateAndReport();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) this.f29151b.get());
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f29154e = true;
        if (this.f29155f) {
            HalfSerializer.onComplete((Observer<?>) this.f29150a, this, this.f29153d);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        DisposableHelper.dispose(this.f29152c);
        HalfSerializer.onError((Observer<?>) this.f29150a, th, this, this.f29153d);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        HalfSerializer.onNext((Observer<? super Object>) this.f29150a, obj, this, this.f29153d);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f29151b, disposable);
    }
}
