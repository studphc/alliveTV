package p000;

import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class dz1 extends AtomicInteger implements Observer, Disposable {

    /* renamed from: i */
    public static final cz1 f16619i = new cz1(null);
    private static final long serialVersionUID = -5402190102429853762L;

    /* renamed from: a */
    public final Observer f16620a;

    /* renamed from: b */
    public final Function f16621b;

    /* renamed from: c */
    public final boolean f16622c;

    /* renamed from: d */
    public final AtomicThrowable f16623d = new AtomicThrowable();

    /* renamed from: e */
    public final AtomicReference f16624e = new AtomicReference();

    /* renamed from: f */
    public Disposable f16625f;

    /* renamed from: g */
    public volatile boolean f16626g;

    /* renamed from: h */
    public volatile boolean f16627h;

    public dz1(Observer observer, Function function, boolean z) {
        this.f16620a = observer;
        this.f16621b = function;
        this.f16622c = z;
    }

    /* renamed from: a */
    public final void m4648a() {
        AtomicReference atomicReference = this.f16624e;
        cz1 cz1Var = f16619i;
        cz1 cz1Var2 = (cz1) atomicReference.getAndSet(cz1Var);
        if (cz1Var2 != null && cz1Var2 != cz1Var) {
            DisposableHelper.dispose(cz1Var2);
        }
    }

    /* renamed from: b */
    public final void m4649b() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        Observer<?> observer = this.f16620a;
        AtomicThrowable atomicThrowable = this.f16623d;
        AtomicReference atomicReference = this.f16624e;
        int i = 1;
        while (!this.f16627h) {
            if (atomicThrowable.get() != null && !this.f16622c) {
                atomicThrowable.tryTerminateConsumer(observer);
                return;
            }
            boolean z2 = this.f16626g;
            cz1 cz1Var = (cz1) atomicReference.get();
            if (cz1Var == null) {
                z = true;
            } else {
                z = false;
            }
            if (z2 && z) {
                atomicThrowable.tryTerminateConsumer(observer);
                return;
            }
            if (!z && cz1Var.f16186b != null) {
                while (!atomicReference.compareAndSet(cz1Var, null) && atomicReference.get() == cz1Var) {
                }
                observer.onNext(cz1Var.f16186b);
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
        this.f16627h = true;
        this.f16625f.dispose();
        m4648a();
        this.f16623d.tryTerminateAndReport();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f16627h;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f16626g = true;
        m4649b();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f16623d.tryAddThrowableOrReport(th)) {
            if (!this.f16622c) {
                m4648a();
            }
            this.f16626g = true;
            m4649b();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        cz1 cz1Var = f16619i;
        AtomicReference atomicReference = this.f16624e;
        cz1 cz1Var2 = (cz1) atomicReference.get();
        if (cz1Var2 != null) {
            DisposableHelper.dispose(cz1Var2);
        }
        try {
            Object apply = this.f16621b.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
            MaybeSource maybeSource = (MaybeSource) apply;
            cz1 cz1Var3 = new cz1(this);
            while (true) {
                cz1 cz1Var4 = (cz1) atomicReference.get();
                if (cz1Var4 == cz1Var) {
                    return;
                }
                while (!atomicReference.compareAndSet(cz1Var4, cz1Var3)) {
                    if (atomicReference.get() != cz1Var4) {
                        break;
                    }
                }
                maybeSource.subscribe(cz1Var3);
                return;
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f16625f.dispose();
            atomicReference.getAndSet(cz1Var);
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f16625f, disposable)) {
            this.f16625f = disposable;
            this.f16620a.onSubscribe(this);
        }
    }
}
