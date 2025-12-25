package p000;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ax1 extends AtomicInteger implements Observer, Disposable {
    private static final long serialVersionUID = -4592979584110982903L;

    /* renamed from: a */
    public final Observer f7779a;

    /* renamed from: b */
    public final AtomicReference f7780b = new AtomicReference();

    /* renamed from: c */
    public final zw1 f7781c = new zw1(this);

    /* renamed from: d */
    public final AtomicThrowable f7782d = new AtomicThrowable();

    /* renamed from: e */
    public volatile SpscLinkedArrayQueue f7783e;

    /* renamed from: f */
    public Object f7784f;

    /* renamed from: g */
    public volatile boolean f7785g;

    /* renamed from: h */
    public volatile boolean f7786h;

    /* renamed from: i */
    public volatile int f7787i;

    public ax1(Observer observer) {
        this.f7779a = observer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final void m1975a() {
        Object obj;
        boolean z;
        Observer<?> observer = this.f7779a;
        int i = 1;
        while (!this.f7785g) {
            if (this.f7782d.get() != null) {
                this.f7784f = null;
                this.f7783e = null;
                this.f7782d.tryTerminateConsumer(observer);
                return;
            }
            int i2 = this.f7787i;
            if (i2 == 1) {
                Object obj2 = this.f7784f;
                this.f7784f = null;
                this.f7787i = 2;
                observer.onNext(obj2);
                i2 = 2;
            }
            boolean z2 = this.f7786h;
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f7783e;
            if (spscLinkedArrayQueue != null) {
                obj = spscLinkedArrayQueue.poll();
            } else {
                obj = null;
            }
            if (obj == null) {
                z = true;
            } else {
                z = false;
            }
            if (z2 && z && i2 == 2) {
                this.f7783e = null;
                observer.onComplete();
                return;
            } else if (z) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                observer.onNext(obj);
            }
        }
        this.f7784f = null;
        this.f7783e = null;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f7785g = true;
        DisposableHelper.dispose(this.f7780b);
        DisposableHelper.dispose(this.f7781c);
        this.f7782d.tryTerminateAndReport();
        if (getAndIncrement() == 0) {
            this.f7783e = null;
            this.f7784f = null;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) this.f7780b.get());
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f7786h = true;
        if (getAndIncrement() == 0) {
            m1975a();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f7782d.tryAddThrowableOrReport(th)) {
            DisposableHelper.dispose(this.f7781c);
            if (getAndIncrement() == 0) {
                m1975a();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (compareAndSet(0, 1)) {
            this.f7779a.onNext(obj);
            if (decrementAndGet() == 0) {
                return;
            }
        } else {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f7783e;
            if (spscLinkedArrayQueue == null) {
                spscLinkedArrayQueue = new SpscLinkedArrayQueue(Observable.bufferSize());
                this.f7783e = spscLinkedArrayQueue;
            }
            spscLinkedArrayQueue.offer(obj);
            if (getAndIncrement() != 0) {
                return;
            }
        }
        m1975a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f7780b, disposable);
    }
}
