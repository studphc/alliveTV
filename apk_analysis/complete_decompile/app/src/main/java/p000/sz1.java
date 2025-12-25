package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class sz1 extends AtomicReference implements Observer, Disposable, uz1 {
    private static final long serialVersionUID = 3764492702657003550L;

    /* renamed from: a */
    public final Observer f26632a;

    /* renamed from: b */
    public final long f26633b;

    /* renamed from: c */
    public final TimeUnit f26634c;

    /* renamed from: d */
    public final Scheduler.Worker f26635d;

    /* renamed from: e */
    public final SequentialDisposable f26636e = new SequentialDisposable();

    /* renamed from: f */
    public final AtomicLong f26637f = new AtomicLong();

    /* renamed from: g */
    public final AtomicReference f26638g = new AtomicReference();

    /* renamed from: h */
    public ObservableSource f26639h;

    public sz1(Observer observer, long j, TimeUnit timeUnit, Scheduler.Worker worker, ObservableSource observableSource) {
        this.f26632a = observer;
        this.f26633b = j;
        this.f26634c = timeUnit;
        this.f26635d = worker;
        this.f26639h = observableSource;
    }

    @Override // p000.uz1
    /* renamed from: a */
    public final void mo6936a(long j) {
        if (this.f26637f.compareAndSet(j, Long.MAX_VALUE)) {
            DisposableHelper.dispose(this.f26638g);
            ObservableSource observableSource = this.f26639h;
            this.f26639h = null;
            observableSource.subscribe(new hx1(this.f26632a, this, 1));
            this.f26635d.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f26638g);
        DisposableHelper.dispose(this);
        this.f26635d.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (this.f26637f.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.f26636e.dispose();
            this.f26632a.onComplete();
            this.f26635d.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f26637f.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.f26636e.dispose();
            this.f26632a.onError(th);
            this.f26635d.dispose();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        AtomicLong atomicLong = this.f26637f;
        long j = atomicLong.get();
        if (j != Long.MAX_VALUE) {
            long j2 = 1 + j;
            if (atomicLong.compareAndSet(j, j2)) {
                SequentialDisposable sequentialDisposable = this.f26636e;
                sequentialDisposable.get().dispose();
                this.f26632a.onNext(obj);
                sequentialDisposable.replace(this.f26635d.schedule(new pq0(j2, this), this.f26633b, this.f26634c));
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f26638g, disposable);
    }
}
