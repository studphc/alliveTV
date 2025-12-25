package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class wz1 extends AtomicBoolean implements Observer, Disposable {
    private static final long serialVersionUID = 1015244841293359600L;

    /* renamed from: a */
    public final Observer f28405a;

    /* renamed from: b */
    public final Scheduler f28406b;

    /* renamed from: c */
    public Disposable f28407c;

    public wz1(Observer observer, Scheduler scheduler) {
        this.f28405a = observer;
        this.f28406b = scheduler;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (compareAndSet(false, true)) {
            this.f28406b.scheduleDirect(new sn1(2, this));
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return get();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (!get()) {
            this.f28405a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (get()) {
            RxJavaPlugins.onError(th);
        } else {
            this.f28405a.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (!get()) {
            this.f28405a.onNext(obj);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f28407c, disposable)) {
            this.f28407c = disposable;
            this.f28405a.onSubscribe(this);
        }
    }
}
