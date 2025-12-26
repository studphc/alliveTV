package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class bz1 implements Observer, Disposable {

    /* renamed from: h */
    public static final az1 f8202h = new az1(null);

    /* renamed from: a */
    public final CompletableObserver f8203a;

    /* renamed from: b */
    public final Function f8204b;

    /* renamed from: c */
    public final boolean f8205c;

    /* renamed from: d */
    public final AtomicThrowable f8206d = new AtomicThrowable();

    /* renamed from: e */
    public final AtomicReference f8207e = new AtomicReference();

    /* renamed from: f */
    public volatile boolean f8208f;

    /* renamed from: g */
    public Disposable f8209g;

    public bz1(CompletableObserver completableObserver, Function function, boolean z) {
        this.f8203a = completableObserver;
        this.f8204b = function;
        this.f8205c = z;
    }

    /* renamed from: a */
    public final void m2178a() {
        AtomicReference atomicReference = this.f8207e;
        az1 az1Var = f8202h;
        az1 az1Var2 = (az1) atomicReference.getAndSet(az1Var);
        if (az1Var2 != null && az1Var2 != az1Var) {
            DisposableHelper.dispose(az1Var2);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f8209g.dispose();
        m2178a();
        this.f8206d.tryTerminateAndReport();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f8207e.get() == f8202h) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f8208f = true;
        if (this.f8207e.get() == null) {
            this.f8206d.tryTerminateConsumer(this.f8203a);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        AtomicThrowable atomicThrowable = this.f8206d;
        if (atomicThrowable.tryAddThrowableOrReport(th)) {
            if (this.f8205c) {
                onComplete();
            } else {
                m2178a();
                atomicThrowable.tryTerminateConsumer(this.f8203a);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        try {
            Object apply = this.f8204b.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
            CompletableSource completableSource = (CompletableSource) apply;
            az1 az1Var = new az1(this);
            while (true) {
                AtomicReference atomicReference = this.f8207e;
                az1 az1Var2 = (az1) atomicReference.get();
                if (az1Var2 == f8202h) {
                    return;
                }
                while (!atomicReference.compareAndSet(az1Var2, az1Var)) {
                    if (atomicReference.get() != az1Var2) {
                        break;
                    }
                }
                if (az1Var2 != null) {
                    DisposableHelper.dispose(az1Var2);
                }
                completableSource.subscribe(az1Var);
                return;
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f8209g.dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f8209g, disposable)) {
            this.f8209g = disposable;
            this.f8203a.onSubscribe(this);
        }
    }
}
