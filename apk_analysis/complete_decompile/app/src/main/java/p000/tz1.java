package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class tz1 extends AtomicLong implements Observer, Disposable, uz1 {
    private static final long serialVersionUID = 3764492702657003550L;

    /* renamed from: a */
    public final Observer f27038a;

    /* renamed from: b */
    public final long f27039b;

    /* renamed from: c */
    public final TimeUnit f27040c;

    /* renamed from: d */
    public final Scheduler.Worker f27041d;

    /* renamed from: e */
    public final SequentialDisposable f27042e = new SequentialDisposable();

    /* renamed from: f */
    public final AtomicReference f27043f = new AtomicReference();

    public tz1(Observer observer, long j, TimeUnit timeUnit, Scheduler.Worker worker) {
        this.f27038a = observer;
        this.f27039b = j;
        this.f27040c = timeUnit;
        this.f27041d = worker;
    }

    @Override // p000.uz1
    /* renamed from: a */
    public final void mo6936a(long j) {
        if (compareAndSet(j, Long.MAX_VALUE)) {
            DisposableHelper.dispose(this.f27043f);
            this.f27038a.onError(new TimeoutException(ExceptionHelper.timeoutMessage(this.f27039b, this.f27040c)));
            this.f27041d.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f27043f);
        this.f27041d.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) this.f27043f.get());
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.f27042e.dispose();
            this.f27038a.onComplete();
            this.f27041d.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.f27042e.dispose();
            this.f27038a.onError(th);
            this.f27041d.dispose();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        long j = get();
        if (j != Long.MAX_VALUE) {
            long j2 = 1 + j;
            if (compareAndSet(j, j2)) {
                SequentialDisposable sequentialDisposable = this.f27042e;
                sequentialDisposable.get().dispose();
                this.f27038a.onNext(obj);
                sequentialDisposable.replace(this.f27041d.schedule(new pq0(j2, this), this.f27039b, this.f27040c));
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f27043f, disposable);
    }
}
