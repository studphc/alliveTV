package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class yz1 extends AtomicInteger implements Observer, Disposable, Runnable {
    private static final long serialVersionUID = -7481782523886138128L;

    /* renamed from: a */
    public final Observer f29196a;

    /* renamed from: b */
    public final long f29197b;

    /* renamed from: c */
    public final int f29198c;

    /* renamed from: d */
    public final AtomicBoolean f29199d = new AtomicBoolean();

    /* renamed from: e */
    public long f29200e;

    /* renamed from: f */
    public Disposable f29201f;

    /* renamed from: g */
    public UnicastSubject f29202g;

    public yz1(Observer observer, long j, int i) {
        this.f29196a = observer;
        this.f29197b = j;
        this.f29198c = i;
        lazySet(1);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (this.f29199d.compareAndSet(false, true)) {
            run();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f29199d.get();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        UnicastSubject unicastSubject = this.f29202g;
        if (unicastSubject != null) {
            this.f29202g = null;
            unicastSubject.onComplete();
        }
        this.f29196a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        UnicastSubject unicastSubject = this.f29202g;
        if (unicastSubject != null) {
            this.f29202g = null;
            unicastSubject.onError(th);
        }
        this.f29196a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        ux1 ux1Var;
        UnicastSubject unicastSubject = this.f29202g;
        if (unicastSubject == null && !this.f29199d.get()) {
            getAndIncrement();
            unicastSubject = UnicastSubject.create(this.f29198c, this);
            this.f29202g = unicastSubject;
            ux1Var = new ux1(unicastSubject);
            this.f29196a.onNext(ux1Var);
        } else {
            ux1Var = null;
        }
        if (unicastSubject != null) {
            unicastSubject.onNext(obj);
            long j = this.f29200e + 1;
            this.f29200e = j;
            if (j >= this.f29197b) {
                this.f29200e = 0L;
                this.f29202g = null;
                unicastSubject.onComplete();
            }
            if (ux1Var != null && ux1Var.m7788d()) {
                this.f29202g = null;
                unicastSubject.onComplete();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f29201f, disposable)) {
            this.f29201f = disposable;
            this.f29196a.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (decrementAndGet() == 0) {
            this.f29201f.dispose();
        }
    }
}
