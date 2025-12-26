package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class nz1 implements Observer, Disposable {

    /* renamed from: a */
    public final Observer f23543a;

    /* renamed from: b */
    public final TimeUnit f23544b;

    /* renamed from: c */
    public final Scheduler f23545c;

    /* renamed from: d */
    public long f23546d;

    /* renamed from: e */
    public Disposable f23547e;

    public nz1(Observer observer, TimeUnit timeUnit, Scheduler scheduler) {
        this.f23543a = observer;
        this.f23545c = scheduler;
        this.f23544b = timeUnit;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f23547e.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f23547e.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f23543a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f23543a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        Scheduler scheduler = this.f23545c;
        TimeUnit timeUnit = this.f23544b;
        long now = scheduler.now(timeUnit);
        long j = this.f23546d;
        this.f23546d = now;
        this.f23543a.onNext(new Timed(obj, now - j, timeUnit));
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f23547e, disposable)) {
            this.f23547e = disposable;
            this.f23546d = this.f23545c.now(this.f23544b);
            this.f23543a.onSubscribe(this);
        }
    }
}
