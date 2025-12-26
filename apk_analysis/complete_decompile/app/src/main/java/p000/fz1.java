package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class fz1 extends AtomicInteger implements Observer, Disposable {

    /* renamed from: i */
    public static final ez1 f17485i = new ez1(null);
    private static final long serialVersionUID = -5402190102429853762L;

    /* renamed from: a */
    public final Observer f17486a;

    /* renamed from: b */
    public final Function f17487b;

    /* renamed from: c */
    public final boolean f17488c;

    /* renamed from: d */
    public final AtomicThrowable f17489d = new AtomicThrowable();

    /* renamed from: e */
    public final AtomicReference f17490e = new AtomicReference();

    /* renamed from: f */
    public Disposable f17491f;

    /* renamed from: g */
    public volatile boolean f17492g;

    /* renamed from: h */
    public volatile boolean f17493h;

    public fz1(Observer observer, Function function, boolean z) {
        this.f17486a = observer;
        this.f17487b = function;
        this.f17488c = z;
    }

    /* renamed from: a */
    public final void m4891a() {
        AtomicReference atomicReference = this.f17490e;
        ez1 ez1Var = f17485i;
        ez1 ez1Var2 = (ez1) atomicReference.getAndSet(ez1Var);
        if (ez1Var2 != null && ez1Var2 != ez1Var) {
            DisposableHelper.dispose(ez1Var2);
        }
    }

    /* renamed from: b */
    public final void m4892b() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        Observer<?> observer = this.f17486a;
        AtomicThrowable atomicThrowable = this.f17489d;
        AtomicReference atomicReference = this.f17490e;
        int i = 1;
        while (!this.f17493h) {
            if (atomicThrowable.get() != null && !this.f17488c) {
                atomicThrowable.tryTerminateConsumer(observer);
                return;
            }
            boolean z2 = this.f17492g;
            ez1 ez1Var = (ez1) atomicReference.get();
            if (ez1Var == null) {
                z = true;
            } else {
                z = false;
            }
            if (z2 && z) {
                atomicThrowable.tryTerminateConsumer(observer);
                return;
            }
            if (!z && ez1Var.f17047b != null) {
                while (!atomicReference.compareAndSet(ez1Var, null) && atomicReference.get() == ez1Var) {
                }
                observer.onNext(ez1Var.f17047b);
            } else {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f17493h = true;
        this.f17491f.dispose();
        m4891a();
        this.f17489d.tryTerminateAndReport();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f17493h;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f17492g = true;
        m4892b();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f17489d.tryAddThrowableOrReport(th)) {
            if (!this.f17488c) {
                m4891a();
            }
            this.f17492g = true;
            m4892b();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        ez1 ez1Var = f17485i;
        AtomicReference atomicReference = this.f17490e;
        ez1 ez1Var2 = (ez1) atomicReference.get();
        if (ez1Var2 != null) {
            DisposableHelper.dispose(ez1Var2);
        }
        try {
            Object apply = this.f17487b.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
            SingleSource singleSource = (SingleSource) apply;
            ez1 ez1Var3 = new ez1(this);
            while (true) {
                ez1 ez1Var4 = (ez1) atomicReference.get();
                if (ez1Var4 == ez1Var) {
                    return;
                }
                while (!atomicReference.compareAndSet(ez1Var4, ez1Var3)) {
                    if (atomicReference.get() != ez1Var4) {
                        break;
                    }
                }
                singleSource.subscribe(ez1Var3);
                return;
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f17491f.dispose();
            atomicReference.getAndSet(ez1Var);
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f17491f, disposable)) {
            this.f17491f = disposable;
            this.f17486a.onSubscribe(this);
        }
    }
}
