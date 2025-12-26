package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class lz1 extends AtomicReference implements Observer, Disposable, Runnable {
    private static final long serialVersionUID = 786994795061867455L;

    /* renamed from: a */
    public final SerializedObserver f22725a;

    /* renamed from: b */
    public final long f22726b;

    /* renamed from: c */
    public final TimeUnit f22727c;

    /* renamed from: d */
    public final Scheduler.Worker f22728d;

    /* renamed from: e */
    public Disposable f22729e;

    /* renamed from: f */
    public volatile boolean f22730f;

    public lz1(SerializedObserver serializedObserver, long j, TimeUnit timeUnit, Scheduler.Worker worker) {
        this.f22725a = serializedObserver;
        this.f22726b = j;
        this.f22727c = timeUnit;
        this.f22728d = worker;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f22729e.dispose();
        this.f22728d.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f22728d.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f22725a.onComplete();
        this.f22728d.dispose();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f22725a.onError(th);
        this.f22728d.dispose();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (!this.f22730f) {
            this.f22730f = true;
            this.f22725a.onNext(obj);
            Disposable disposable = (Disposable) get();
            if (disposable != null) {
                disposable.dispose();
            }
            DisposableHelper.replace(this, this.f22728d.schedule(this, this.f22726b, this.f22727c));
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f22729e, disposable)) {
            this.f22729e = disposable;
            this.f22725a.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22730f = false;
    }
}
