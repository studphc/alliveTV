package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class cw1 extends AtomicInteger implements Observer, Disposable {
    private static final long serialVersionUID = 8600231336733376951L;

    /* renamed from: a */
    public final Observer f16148a;

    /* renamed from: b */
    public final boolean f16149b;

    /* renamed from: f */
    public final Function f16153f;

    /* renamed from: h */
    public Disposable f16155h;

    /* renamed from: i */
    public volatile boolean f16156i;

    /* renamed from: c */
    public final CompositeDisposable f16150c = new CompositeDisposable();

    /* renamed from: e */
    public final AtomicThrowable f16152e = new AtomicThrowable();

    /* renamed from: d */
    public final AtomicInteger f16151d = new AtomicInteger(1);

    /* renamed from: g */
    public final AtomicReference f16154g = new AtomicReference();

    public cw1(Observer observer, Function function, boolean z) {
        this.f16148a = observer;
        this.f16153f = function;
        this.f16149b = z;
    }

    /* renamed from: a */
    public final void m4490a() {
        boolean z;
        Object obj;
        Observer<?> observer = this.f16148a;
        AtomicInteger atomicInteger = this.f16151d;
        AtomicReference atomicReference = this.f16154g;
        int i = 1;
        while (!this.f16156i) {
            if (!this.f16149b && this.f16152e.get() != null) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) this.f16154g.get();
                if (spscLinkedArrayQueue != null) {
                    spscLinkedArrayQueue.clear();
                }
                this.f16152e.tryTerminateConsumer(observer);
                return;
            }
            boolean z2 = false;
            if (atomicInteger.get() == 0) {
                z = true;
            } else {
                z = false;
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue2 = (SpscLinkedArrayQueue) atomicReference.get();
            if (spscLinkedArrayQueue2 != null) {
                obj = spscLinkedArrayQueue2.poll();
            } else {
                obj = null;
            }
            if (obj == null) {
                z2 = true;
            }
            if (z && z2) {
                this.f16152e.tryTerminateConsumer(this.f16148a);
                return;
            } else if (z2) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                observer.onNext(obj);
            }
        }
        SpscLinkedArrayQueue spscLinkedArrayQueue3 = (SpscLinkedArrayQueue) this.f16154g.get();
        if (spscLinkedArrayQueue3 != null) {
            spscLinkedArrayQueue3.clear();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f16156i = true;
        this.f16155h.dispose();
        this.f16150c.dispose();
        this.f16152e.tryTerminateAndReport();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f16156i;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f16151d.decrementAndGet();
        if (getAndIncrement() == 0) {
            m4490a();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f16151d.decrementAndGet();
        if (this.f16152e.tryAddThrowableOrReport(th)) {
            if (!this.f16149b) {
                this.f16150c.dispose();
            }
            if (getAndIncrement() == 0) {
                m4490a();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        try {
            Object apply = this.f16153f.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
            SingleSource singleSource = (SingleSource) apply;
            this.f16151d.getAndIncrement();
            bw1 bw1Var = new bw1(this);
            if (!this.f16156i && this.f16150c.add(bw1Var)) {
                singleSource.subscribe(bw1Var);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f16155h.dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f16155h, disposable)) {
            this.f16155h = disposable;
            this.f16148a.onSubscribe(this);
        }
    }
}
