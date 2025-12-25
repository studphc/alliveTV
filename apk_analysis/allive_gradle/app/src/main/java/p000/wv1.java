package p000;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class wv1 extends BasicIntQueueDisposable implements Observer {
    private static final long serialVersionUID = 8443155186132538303L;

    /* renamed from: a */
    public final Observer f28346a;

    /* renamed from: c */
    public final Function f28348c;

    /* renamed from: d */
    public final boolean f28349d;

    /* renamed from: f */
    public Disposable f28351f;

    /* renamed from: g */
    public volatile boolean f28352g;

    /* renamed from: b */
    public final AtomicThrowable f28347b = new AtomicThrowable();

    /* renamed from: e */
    public final CompositeDisposable f28350e = new CompositeDisposable();

    public wv1(Observer observer, Function function, boolean z) {
        this.f28346a = observer;
        this.f28348c = function;
        this.f28349d = z;
        lazySet(1);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f28352g = true;
        this.f28351f.dispose();
        this.f28350e.dispose();
        this.f28347b.tryTerminateAndReport();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f28351f.isDisposed();
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        return true;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (decrementAndGet() == 0) {
            this.f28347b.tryTerminateConsumer(this.f28346a);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f28347b.tryAddThrowableOrReport(th)) {
            if (this.f28349d) {
                if (decrementAndGet() == 0) {
                    this.f28347b.tryTerminateConsumer(this.f28346a);
                }
            } else {
                this.f28352g = true;
                this.f28351f.dispose();
                this.f28350e.dispose();
                this.f28347b.tryTerminateConsumer(this.f28346a);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        try {
            Object apply = this.f28348c.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
            CompletableSource completableSource = (CompletableSource) apply;
            getAndIncrement();
            vv1 vv1Var = new vv1(this);
            if (!this.f28352g && this.f28350e.add(vv1Var)) {
                completableSource.subscribe(vv1Var);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f28351f.dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f28351f, disposable)) {
            this.f28351f = disposable;
            this.f28346a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        return null;
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        return i & 2;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
    }
}
