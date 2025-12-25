package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class fk2 extends AtomicReference implements SingleObserver, Disposable {
    private static final long serialVersionUID = -5331524057054083935L;

    /* renamed from: a */
    public final SingleObserver f17303a;

    /* renamed from: b */
    public final Consumer f17304b;

    /* renamed from: c */
    public final boolean f17305c;

    /* renamed from: d */
    public Disposable f17306d;

    public fk2(SingleObserver singleObserver, Object obj, boolean z, Consumer consumer) {
        super(obj);
        this.f17303a = singleObserver;
        this.f17305c = z;
        this.f17304b = consumer;
    }

    /* renamed from: a */
    public final void m4813a() {
        Object andSet = getAndSet(this);
        if (andSet != this) {
            try {
                this.f17304b.accept(andSet);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (this.f17305c) {
            m4813a();
            this.f17306d.dispose();
            this.f17306d = DisposableHelper.DISPOSED;
        } else {
            this.f17306d.dispose();
            this.f17306d = DisposableHelper.DISPOSED;
            m4813a();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f17306d.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        this.f17306d = DisposableHelper.DISPOSED;
        boolean z = this.f17305c;
        if (z) {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f17304b.accept(andSet);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    th = new CompositeException(th, th2);
                }
            } else {
                return;
            }
        }
        this.f17303a.onError(th);
        if (!z) {
            m4813a();
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f17306d, disposable)) {
            this.f17306d = disposable;
            this.f17303a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        this.f17306d = DisposableHelper.DISPOSED;
        SingleObserver singleObserver = this.f17303a;
        boolean z = this.f17305c;
        if (z) {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f17304b.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    singleObserver.onError(th);
                    return;
                }
            } else {
                return;
            }
        }
        singleObserver.onSuccess(obj);
        if (!z) {
            m4813a();
        }
    }
}
