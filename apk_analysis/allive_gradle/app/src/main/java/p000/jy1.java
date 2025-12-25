package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class jy1 extends AtomicReference implements Observer, Disposable, Runnable {
    private static final long serialVersionUID = -3517602651313910099L;

    /* renamed from: a */
    public final SerializedObserver f20681a;

    /* renamed from: b */
    public final long f20682b;

    /* renamed from: c */
    public final TimeUnit f20683c;

    /* renamed from: d */
    public final Scheduler f20684d;

    /* renamed from: e */
    public final AtomicReference f20685e = new AtomicReference();

    /* renamed from: f */
    public Disposable f20686f;

    public jy1(SerializedObserver serializedObserver, long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f20681a = serializedObserver;
        this.f20682b = j;
        this.f20683c = timeUnit;
        this.f20684d = scheduler;
    }

    /* renamed from: a */
    public abstract void mo5141a();

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f20685e);
        this.f20686f.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f20686f.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        DisposableHelper.dispose(this.f20685e);
        mo5141a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        DisposableHelper.dispose(this.f20685e);
        this.f20681a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        lazySet(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f20686f, disposable)) {
            this.f20686f = disposable;
            this.f20681a.onSubscribe(this);
            TimeUnit timeUnit = this.f20683c;
            Scheduler scheduler = this.f20684d;
            long j = this.f20682b;
            DisposableHelper.replace(this.f20685e, scheduler.schedulePeriodicallyDirect(this, j, j, timeUnit));
        }
    }
}
