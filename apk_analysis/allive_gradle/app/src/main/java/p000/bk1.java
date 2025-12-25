package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class bk1 extends AtomicReference implements MaybeObserver, Disposable {
    private static final long serialVersionUID = -674404550052917487L;

    /* renamed from: a */
    public final MaybeObserver f8053a;

    /* renamed from: b */
    public final Consumer f8054b;

    /* renamed from: c */
    public final boolean f8055c;

    /* renamed from: d */
    public Disposable f8056d;

    public bk1(MaybeObserver maybeObserver, Object obj, Consumer consumer, boolean z) {
        super(obj);
        this.f8053a = maybeObserver;
        this.f8054b = consumer;
        this.f8055c = z;
    }

    /* renamed from: a */
    public final void m2103a() {
        Object andSet = getAndSet(this);
        if (andSet != this) {
            try {
                this.f8054b.accept(andSet);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (this.f8055c) {
            m2103a();
            this.f8056d.dispose();
            this.f8056d = DisposableHelper.DISPOSED;
        } else {
            this.f8056d.dispose();
            this.f8056d = DisposableHelper.DISPOSED;
            m2103a();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f8056d.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        this.f8056d = DisposableHelper.DISPOSED;
        MaybeObserver maybeObserver = this.f8053a;
        boolean z = this.f8055c;
        if (z) {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f8054b.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    maybeObserver.onError(th);
                    return;
                }
            } else {
                return;
            }
        }
        maybeObserver.onComplete();
        if (!z) {
            m2103a();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        this.f8056d = DisposableHelper.DISPOSED;
        boolean z = this.f8055c;
        if (z) {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f8054b.accept(andSet);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    th = new CompositeException(th, th2);
                }
            } else {
                return;
            }
        }
        this.f8053a.onError(th);
        if (!z) {
            m2103a();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f8056d, disposable)) {
            this.f8056d = disposable;
            this.f8053a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        this.f8056d = DisposableHelper.DISPOSED;
        MaybeObserver maybeObserver = this.f8053a;
        boolean z = this.f8055c;
        if (z) {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f8054b.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    maybeObserver.onError(th);
                    return;
                }
            } else {
                return;
            }
        }
        maybeObserver.onSuccess(obj);
        if (!z) {
            m2103a();
        }
    }
}
