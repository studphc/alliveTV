package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class yj2 implements SingleObserver, Disposable {

    /* renamed from: a */
    public final SingleObserver f28987a;

    /* renamed from: b */
    public final TimeUnit f28988b;

    /* renamed from: c */
    public final Scheduler f28989c;

    /* renamed from: d */
    public final long f28990d;

    /* renamed from: e */
    public Disposable f28991e;

    public yj2(SingleObserver singleObserver, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        long j;
        this.f28987a = singleObserver;
        this.f28988b = timeUnit;
        this.f28989c = scheduler;
        if (z) {
            j = scheduler.now(timeUnit);
        } else {
            j = 0;
        }
        this.f28990d = j;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f28991e.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f28991e.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        this.f28987a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f28991e, disposable)) {
            this.f28991e = disposable;
            this.f28987a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        Scheduler scheduler = this.f28989c;
        TimeUnit timeUnit = this.f28988b;
        this.f28987a.onSuccess(new Timed(obj, scheduler.now(timeUnit) - this.f28990d, timeUnit));
    }
}
