package p000;

import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observer;
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
public final class aw1 extends AtomicInteger implements Observer, Disposable {
    private static final long serialVersionUID = 8600231336733376951L;

    /* renamed from: a */
    public final Observer f7763a;

    /* renamed from: b */
    public final boolean f7764b;

    /* renamed from: f */
    public final Function f7768f;

    /* renamed from: h */
    public Disposable f7770h;

    /* renamed from: i */
    public volatile boolean f7771i;

    /* renamed from: c */
    public final CompositeDisposable f7765c = new CompositeDisposable();

    /* renamed from: e */
    public final AtomicThrowable f7767e = new AtomicThrowable();

    /* renamed from: d */
    public final AtomicInteger f7766d = new AtomicInteger(1);

    /* renamed from: g */
    public final AtomicReference f7769g = new AtomicReference();

    public aw1(Observer observer, Function function, boolean z) {
        this.f7763a = observer;
        this.f7768f = function;
        this.f7764b = z;
    }

    /* renamed from: a */
    public final void m1973a() {
        boolean z;
        Object obj;
        Observer<?> observer = this.f7763a;
        AtomicInteger atomicInteger = this.f7766d;
        AtomicReference atomicReference = this.f7769g;
        int i = 1;
        while (!this.f7771i) {
            if (!this.f7764b && this.f7767e.get() != null) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) this.f7769g.get();
                if (spscLinkedArrayQueue != null) {
                    spscLinkedArrayQueue.clear();
                }
                this.f7767e.tryTerminateConsumer(observer);
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
                this.f7767e.tryTerminateConsumer(observer);
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
        SpscLinkedArrayQueue spscLinkedArrayQueue3 = (SpscLinkedArrayQueue) this.f7769g.get();
        if (spscLinkedArrayQueue3 != null) {
            spscLinkedArrayQueue3.clear();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f7771i = true;
        this.f7770h.dispose();
        this.f7765c.dispose();
        this.f7767e.tryTerminateAndReport();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f7771i;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f7766d.decrementAndGet();
        if (getAndIncrement() == 0) {
            m1973a();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f7766d.decrementAndGet();
        if (this.f7767e.tryAddThrowableOrReport(th)) {
            if (!this.f7764b) {
                this.f7765c.dispose();
            }
            if (getAndIncrement() == 0) {
                m1973a();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        try {
            Object apply = this.f7768f.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
            MaybeSource maybeSource = (MaybeSource) apply;
            this.f7766d.getAndIncrement();
            zv1 zv1Var = new zv1(this);
            if (!this.f7771i && this.f7765c.add(zv1Var)) {
                maybeSource.subscribe(zv1Var);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f7770h.dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f7770h, disposable)) {
            this.f7770h = disposable;
            this.f7763a.onSubscribe(this);
        }
    }
}
