package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybePeek;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;

/* loaded from: classes2.dex */
public final class bi1 implements MaybeObserver, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f8023a;

    /* renamed from: b */
    public Disposable f8024b;

    /* renamed from: c */
    public final Object f8025c;

    /* renamed from: d */
    public final Object f8026d;

    public /* synthetic */ bi1(int i, MaybeObserver maybeObserver, Object obj) {
        this.f8023a = i;
        this.f8025c = maybeObserver;
        this.f8026d = obj;
    }

    /* renamed from: a */
    public void m2100a() {
        try {
            ((MaybePeek) this.f8026d).f19197e.run();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
    }

    /* renamed from: b */
    public void m2101b(Throwable th) {
        try {
            ((MaybePeek) this.f8026d).f19195c.accept(th);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            th = new CompositeException(th, th2);
        }
        this.f8024b = DisposableHelper.DISPOSED;
        ((MaybeObserver) this.f8025c).onError(th);
        m2100a();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f8023a) {
            case 0:
                this.f8024b.dispose();
                this.f8024b = DisposableHelper.DISPOSED;
                SubscriptionHelper.cancel((ci1) this.f8025c);
                return;
            case 1:
                this.f8024b.dispose();
                return;
            case 2:
                this.f8024b.dispose();
                this.f8024b = DisposableHelper.DISPOSED;
                return;
            case 3:
                Disposable disposable = this.f8024b;
                this.f8024b = DisposableHelper.DISPOSED;
                disposable.dispose();
                return;
            default:
                try {
                    ((MaybePeek) this.f8026d).f19198f.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
                this.f8024b.dispose();
                this.f8024b = DisposableHelper.DISPOSED;
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f8023a) {
            case 0:
                if (((ci1) this.f8025c).get() == SubscriptionHelper.CANCELLED) {
                    return true;
                }
                return false;
            case 1:
                return this.f8024b.isDisposed();
            case 2:
                return this.f8024b.isDisposed();
            case 3:
                return this.f8024b.isDisposed();
            default:
                return this.f8024b.isDisposed();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        switch (this.f8023a) {
            case 0:
                this.f8024b = DisposableHelper.DISPOSED;
                ((Publisher) this.f8026d).subscribe((ci1) this.f8025c);
                return;
            case 1:
                ((MaybeObserver) this.f8025c).onComplete();
                return;
            case 2:
                MaybeObserver maybeObserver = (MaybeObserver) this.f8025c;
                this.f8024b = DisposableHelper.DISPOSED;
                try {
                    ((BiConsumer) this.f8026d).accept(null, null);
                    maybeObserver.onComplete();
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    maybeObserver.onError(th);
                    return;
                }
            case 3:
                ((MaybeObserver) this.f8025c).onComplete();
                return;
            default:
                Disposable disposable = this.f8024b;
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (disposable != disposableHelper) {
                    try {
                        ((MaybePeek) this.f8026d).f19196d.run();
                        this.f8024b = disposableHelper;
                        ((MaybeObserver) this.f8025c).onComplete();
                        m2100a();
                        return;
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        m2101b(th2);
                        return;
                    }
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        Object obj = this.f8026d;
        Object obj2 = this.f8025c;
        switch (this.f8023a) {
            case 0:
                this.f8024b = DisposableHelper.DISPOSED;
                ci1 ci1Var = (ci1) obj2;
                ci1Var.f8375c = th;
                ((Publisher) obj).subscribe(ci1Var);
                return;
            case 1:
                ((MaybeObserver) obj2).onError(th);
                return;
            case 2:
                this.f8024b = DisposableHelper.DISPOSED;
                try {
                    ((BiConsumer) obj).accept(null, th);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    th = new CompositeException(th, th2);
                }
                ((MaybeObserver) obj2).onError(th);
                return;
            case 3:
                ((MaybeObserver) obj2).onError(th);
                return;
            default:
                if (this.f8024b == DisposableHelper.DISPOSED) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    m2101b(th);
                    return;
                }
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        switch (this.f8023a) {
            case 0:
                if (DisposableHelper.validate(this.f8024b, disposable)) {
                    this.f8024b = disposable;
                    ((ci1) this.f8025c).f8373a.onSubscribe(this);
                    return;
                }
                return;
            case 1:
                if (DisposableHelper.validate(this.f8024b, disposable)) {
                    this.f8024b = disposable;
                    ((MaybeObserver) this.f8025c).onSubscribe(this);
                    return;
                }
                return;
            case 2:
                if (DisposableHelper.validate(this.f8024b, disposable)) {
                    this.f8024b = disposable;
                    ((MaybeObserver) this.f8025c).onSubscribe(this);
                    return;
                }
                return;
            case 3:
                if (DisposableHelper.validate(this.f8024b, disposable)) {
                    this.f8024b = disposable;
                    ((MaybeObserver) this.f8025c).onSubscribe(this);
                    return;
                }
                return;
            default:
                MaybeObserver maybeObserver = (MaybeObserver) this.f8025c;
                if (DisposableHelper.validate(this.f8024b, disposable)) {
                    try {
                        ((MaybePeek) this.f8026d).f19193a.accept(disposable);
                        this.f8024b = disposable;
                        maybeObserver.onSubscribe(this);
                        return;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        disposable.dispose();
                        this.f8024b = DisposableHelper.DISPOSED;
                        EmptyDisposable.error(th, (MaybeObserver<?>) maybeObserver);
                        return;
                    }
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        switch (this.f8023a) {
            case 0:
                this.f8024b = DisposableHelper.DISPOSED;
                ci1 ci1Var = (ci1) this.f8025c;
                ci1Var.f8374b = obj;
                ((Publisher) this.f8026d).subscribe(ci1Var);
                return;
            case 1:
                ((MaybeObserver) this.f8025c).onSuccess(obj);
                try {
                    ((Consumer) this.f8026d).accept(obj);
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                    return;
                }
            case 2:
                MaybeObserver maybeObserver = (MaybeObserver) this.f8025c;
                this.f8024b = DisposableHelper.DISPOSED;
                try {
                    ((BiConsumer) this.f8026d).accept(obj, null);
                    maybeObserver.onSuccess(obj);
                    return;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    maybeObserver.onError(th2);
                    return;
                }
            case 3:
                MaybeObserver maybeObserver2 = (MaybeObserver) this.f8025c;
                try {
                    if (((Predicate) this.f8026d).test(obj)) {
                        maybeObserver2.onSuccess(obj);
                        return;
                    } else {
                        maybeObserver2.onComplete();
                        return;
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    maybeObserver2.onError(th3);
                    return;
                }
            default:
                Disposable disposable = this.f8024b;
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (disposable != disposableHelper) {
                    try {
                        ((MaybePeek) this.f8026d).f19194b.accept(obj);
                        this.f8024b = disposableHelper;
                        ((MaybeObserver) this.f8025c).onSuccess(obj);
                        m2100a();
                        return;
                    } catch (Throwable th4) {
                        Exceptions.throwIfFatal(th4);
                        m2101b(th4);
                        return;
                    }
                }
                return;
        }
    }

    public bi1(MaybeObserver maybeObserver, Publisher publisher) {
        this.f8023a = 0;
        this.f8025c = new ci1(maybeObserver);
        this.f8026d = publisher;
    }
}
