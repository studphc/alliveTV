package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class qj1 implements MaybeObserver, Disposable {

    /* renamed from: a */
    public final MaybeObserver f25623a;

    /* renamed from: b */
    public final TimeUnit f25624b;

    /* renamed from: c */
    public final Scheduler f25625c;

    /* renamed from: d */
    public final long f25626d;

    /* renamed from: e */
    public Disposable f25627e;

    public qj1(MaybeObserver maybeObserver, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        long j;
        this.f25623a = maybeObserver;
        this.f25624b = timeUnit;
        this.f25625c = scheduler;
        if (z) {
            j = scheduler.now(timeUnit);
        } else {
            j = 0;
        }
        this.f25626d = j;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f25627e.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f25627e.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        this.f25623a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        this.f25623a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f25627e, disposable)) {
            this.f25627e = disposable;
            this.f25623a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        Scheduler scheduler = this.f25625c;
        TimeUnit timeUnit = this.f25624b;
        this.f25623a.onSuccess(new Timed(obj, scheduler.now(timeUnit) - this.f25626d, timeUnit));
    }
}
