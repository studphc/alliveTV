package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class mz1 extends AtomicInteger implements Observer, Disposable, Runnable {
    private static final long serialVersionUID = -8296689127439125014L;

    /* renamed from: a */
    public final Observer f23169a;

    /* renamed from: b */
    public final long f23170b;

    /* renamed from: c */
    public final TimeUnit f23171c;

    /* renamed from: d */
    public final Scheduler.Worker f23172d;

    /* renamed from: e */
    public final boolean f23173e;

    /* renamed from: f */
    public final AtomicReference f23174f = new AtomicReference();

    /* renamed from: g */
    public Disposable f23175g;

    /* renamed from: h */
    public volatile boolean f23176h;

    /* renamed from: i */
    public Throwable f23177i;

    /* renamed from: j */
    public volatile boolean f23178j;

    /* renamed from: k */
    public volatile boolean f23179k;

    /* renamed from: l */
    public boolean f23180l;

    public mz1(Observer observer, long j, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
        this.f23169a = observer;
        this.f23170b = j;
        this.f23171c = timeUnit;
        this.f23172d = worker;
        this.f23173e = z;
    }

    /* renamed from: a */
    public final void m6263a() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        AtomicReference atomicReference = this.f23174f;
        Observer observer = this.f23169a;
        int i = 1;
        while (!this.f23178j) {
            boolean z2 = this.f23176h;
            if (z2 && this.f23177i != null) {
                atomicReference.lazySet(null);
                observer.onError(this.f23177i);
                this.f23172d.dispose();
                return;
            }
            if (atomicReference.get() == null) {
                z = true;
            } else {
                z = false;
            }
            if (z2) {
                Object andSet = atomicReference.getAndSet(null);
                if (!z && this.f23173e) {
                    observer.onNext(andSet);
                }
                observer.onComplete();
                this.f23172d.dispose();
                return;
            }
            if (z) {
                if (this.f23179k) {
                    this.f23180l = false;
                    this.f23179k = false;
                }
            } else if (!this.f23180l || this.f23179k) {
                observer.onNext(atomicReference.getAndSet(null));
                this.f23179k = false;
                this.f23180l = true;
                this.f23172d.schedule(this, this.f23170b, this.f23171c);
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
        atomicReference.lazySet(null);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f23178j = true;
        this.f23175g.dispose();
        this.f23172d.dispose();
        if (getAndIncrement() == 0) {
            this.f23174f.lazySet(null);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f23178j;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f23176h = true;
        m6263a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f23177i = th;
        this.f23176h = true;
        m6263a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f23174f.set(obj);
        m6263a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f23175g, disposable)) {
            this.f23175g = disposable;
            this.f23169a.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23179k = true;
        m6263a();
    }
}
