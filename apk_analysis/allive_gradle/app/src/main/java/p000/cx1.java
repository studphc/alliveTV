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
public final class cx1 extends AtomicInteger implements Observer, Disposable {
    private static final long serialVersionUID = -4592979584110982903L;

    /* renamed from: a */
    public final Observer f16164a;

    /* renamed from: b */
    public final AtomicReference f16165b = new AtomicReference();

    /* renamed from: c */
    public final bx1 f16166c = new bx1(this);

    /* renamed from: d */
    public final AtomicThrowable f16167d = new AtomicThrowable();

    /* renamed from: e */
    public volatile SpscLinkedArrayQueue f16168e;

    /* renamed from: f */
    public Object f16169f;

    /* renamed from: g */
    public volatile boolean f16170g;

    /* renamed from: h */
    public volatile boolean f16171h;

    /* renamed from: i */
    public volatile int f16172i;

    public cx1(Observer observer) {
        this.f16164a = observer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final void m4502a() {
        Object obj;
        boolean z;
        Observer<?> observer = this.f16164a;
        int i = 1;
        while (!this.f16170g) {
            if (this.f16167d.get() != null) {
                this.f16169f = null;
                this.f16168e = null;
                this.f16167d.tryTerminateConsumer(observer);
                return;
            }
            int i2 = this.f16172i;
            if (i2 == 1) {
                Object obj2 = this.f16169f;
                this.f16169f = null;
                this.f16172i = 2;
                observer.onNext(obj2);
                i2 = 2;
            }
            boolean z2 = this.f16171h;
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f16168e;
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
                this.f16168e = null;
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
        this.f16169f = null;
        this.f16168e = null;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f16170g = true;
        DisposableHelper.dispose(this.f16165b);
        DisposableHelper.dispose(this.f16166c);
        this.f16167d.tryTerminateAndReport();
        if (getAndIncrement() == 0) {
            this.f16168e = null;
            this.f16169f = null;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) this.f16165b.get());
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f16171h = true;
        if (getAndIncrement() == 0) {
            m4502a();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f16167d.tryAddThrowableOrReport(th)) {
            DisposableHelper.dispose(this.f16166c);
            if (getAndIncrement() == 0) {
                m4502a();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (compareAndSet(0, 1)) {
            this.f16164a.onNext(obj);
            if (decrementAndGet() == 0) {
                return;
            }
        } else {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f16168e;
            if (spscLinkedArrayQueue == null) {
                spscLinkedArrayQueue = new SpscLinkedArrayQueue(Observable.bufferSize());
                this.f16168e = spscLinkedArrayQueue;
            }
            spscLinkedArrayQueue.offer(obj);
            if (getAndIncrement() != 0) {
                return;
            }
        }
        m4502a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f16165b, disposable);
    }
}
