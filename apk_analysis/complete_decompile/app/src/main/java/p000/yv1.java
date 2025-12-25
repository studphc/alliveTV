package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class yv1 extends AtomicInteger implements Disposable, Observer {
    private static final long serialVersionUID = 8443155186132538303L;

    /* renamed from: a */
    public final CompletableObserver f29140a;

    /* renamed from: c */
    public final Function f29142c;

    /* renamed from: d */
    public final boolean f29143d;

    /* renamed from: f */
    public Disposable f29145f;

    /* renamed from: g */
    public volatile boolean f29146g;

    /* renamed from: b */
    public final AtomicThrowable f29141b = new AtomicThrowable();

    /* renamed from: e */
    public final CompositeDisposable f29144e = new CompositeDisposable();

    public yv1(CompletableObserver completableObserver, Function function, boolean z) {
        this.f29140a = completableObserver;
        this.f29142c = function;
        this.f29143d = z;
        lazySet(1);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f29146g = true;
        this.f29145f.dispose();
        this.f29144e.dispose();
        this.f29141b.tryTerminateAndReport();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f29145f.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (decrementAndGet() == 0) {
            this.f29141b.tryTerminateConsumer(this.f29140a);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f29141b.tryAddThrowableOrReport(th)) {
            if (this.f29143d) {
                if (decrementAndGet() == 0) {
                    this.f29141b.tryTerminateConsumer(this.f29140a);
                }
            } else {
                this.f29146g = true;
                this.f29145f.dispose();
                this.f29144e.dispose();
                this.f29141b.tryTerminateConsumer(this.f29140a);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        try {
            Object apply = this.f29142c.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
            CompletableSource completableSource = (CompletableSource) apply;
            getAndIncrement();
            xv1 xv1Var = new xv1(this);
            if (!this.f29146g && this.f29144e.add(xv1Var)) {
                completableSource.subscribe(xv1Var);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f29145f.dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f29145f, disposable)) {
            this.f29145f = disposable;
            this.f29140a.onSubscribe(this);
        }
    }
}
