package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class xz1 extends AtomicBoolean implements Observer, Disposable {
    private static final long serialVersionUID = 5904473792286235046L;

    /* renamed from: a */
    public final Observer f28772a;

    /* renamed from: b */
    public final Object f28773b;

    /* renamed from: c */
    public final Consumer f28774c;

    /* renamed from: d */
    public final boolean f28775d;

    /* renamed from: e */
    public Disposable f28776e;

    public xz1(Observer observer, Object obj, Consumer consumer, boolean z) {
        this.f28772a = observer;
        this.f28773b = obj;
        this.f28774c = consumer;
        this.f28775d = z;
    }

    /* renamed from: a */
    public final void m8206a() {
        if (compareAndSet(false, true)) {
            try {
                this.f28774c.accept(this.f28773b);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (this.f28775d) {
            m8206a();
            this.f28776e.dispose();
            this.f28776e = DisposableHelper.DISPOSED;
        } else {
            this.f28776e.dispose();
            this.f28776e = DisposableHelper.DISPOSED;
            m8206a();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return get();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        boolean z = this.f28775d;
        Observer observer = this.f28772a;
        if (z) {
            if (compareAndSet(false, true)) {
                try {
                    this.f28774c.accept(this.f28773b);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    observer.onError(th);
                    return;
                }
            }
            observer.onComplete();
            return;
        }
        observer.onComplete();
        m8206a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        boolean z = this.f28775d;
        Observer observer = this.f28772a;
        if (z) {
            if (compareAndSet(false, true)) {
                try {
                    this.f28774c.accept(this.f28773b);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    th = new CompositeException(th, th2);
                }
            }
            observer.onError(th);
            return;
        }
        observer.onError(th);
        m8206a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f28772a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f28776e, disposable)) {
            this.f28776e = disposable;
            this.f28772a.onSubscribe(this);
        }
    }
}
