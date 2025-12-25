package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.Optional;

/* loaded from: classes2.dex */
public final class gi1 implements MaybeObserver, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f17709a;

    /* renamed from: b */
    public final MaybeObserver f17710b;

    /* renamed from: c */
    public final Function f17711c;

    /* renamed from: d */
    public Disposable f17712d;

    public /* synthetic */ gi1(int i, MaybeObserver maybeObserver, Function function) {
        this.f17709a = i;
        this.f17710b = maybeObserver;
        this.f17711c = function;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f17709a) {
            case 0:
                this.f17712d.dispose();
                return;
            case 1:
                Disposable disposable = this.f17712d;
                this.f17712d = DisposableHelper.DISPOSED;
                disposable.dispose();
                return;
            case 2:
                Disposable disposable2 = this.f17712d;
                this.f17712d = DisposableHelper.DISPOSED;
                disposable2.dispose();
                return;
            default:
                this.f17712d.dispose();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f17709a) {
            case 0:
                return this.f17712d.isDisposed();
            case 1:
                return this.f17712d.isDisposed();
            case 2:
                return this.f17712d.isDisposed();
            default:
                return this.f17712d.isDisposed();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        switch (this.f17709a) {
            case 0:
                this.f17710b.onComplete();
                return;
            case 1:
                this.f17710b.onComplete();
                return;
            case 2:
                this.f17710b.onComplete();
                return;
            default:
                this.f17710b.onComplete();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        MaybeObserver maybeObserver = this.f17710b;
        switch (this.f17709a) {
            case 0:
                maybeObserver.onError(th);
                return;
            case 1:
                maybeObserver.onError(th);
                return;
            case 2:
                maybeObserver.onError(th);
                return;
            default:
                try {
                    Object apply = this.f17711c.apply(th);
                    Objects.requireNonNull(apply, "The itemSupplier returned a null value");
                    maybeObserver.onSuccess(apply);
                    return;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    maybeObserver.onError(new CompositeException(th, th2));
                    return;
                }
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        switch (this.f17709a) {
            case 0:
                if (DisposableHelper.validate(this.f17712d, disposable)) {
                    this.f17712d = disposable;
                    this.f17710b.onSubscribe(this);
                    return;
                }
                return;
            case 1:
                if (DisposableHelper.validate(this.f17712d, disposable)) {
                    this.f17712d = disposable;
                    this.f17710b.onSubscribe(this);
                    return;
                }
                return;
            case 2:
                if (DisposableHelper.validate(this.f17712d, disposable)) {
                    this.f17712d = disposable;
                    this.f17710b.onSubscribe(this);
                    return;
                }
                return;
            default:
                if (DisposableHelper.validate(this.f17712d, disposable)) {
                    this.f17712d = disposable;
                    this.f17710b.onSubscribe(this);
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        boolean isPresent;
        Object obj2;
        switch (this.f17709a) {
            case 0:
                MaybeObserver maybeObserver = this.f17710b;
                try {
                    Object apply = this.f17711c.apply(obj);
                    Objects.requireNonNull(apply, "The selector returned a null Notification");
                    Notification notification = (Notification) apply;
                    if (notification.isOnNext()) {
                        maybeObserver.onSuccess(notification.getValue());
                        return;
                    } else if (notification.isOnComplete()) {
                        maybeObserver.onComplete();
                        return;
                    } else {
                        maybeObserver.onError(notification.getError());
                        return;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    maybeObserver.onError(th);
                    return;
                }
            case 1:
                MaybeObserver maybeObserver2 = this.f17710b;
                try {
                    Object apply2 = this.f17711c.apply(obj);
                    Objects.requireNonNull(apply2, "The mapper returned a null item");
                    maybeObserver2.onSuccess(apply2);
                    return;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    maybeObserver2.onError(th2);
                    return;
                }
            case 2:
                MaybeObserver maybeObserver3 = this.f17710b;
                try {
                    Object apply3 = this.f17711c.apply(obj);
                    Objects.requireNonNull(apply3, "The mapper returned a null item");
                    Optional m5540h = ki0.m5540h(apply3);
                    isPresent = m5540h.isPresent();
                    if (isPresent) {
                        obj2 = m5540h.get();
                        maybeObserver3.onSuccess(obj2);
                        return;
                    } else {
                        maybeObserver3.onComplete();
                        return;
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    maybeObserver3.onError(th3);
                    return;
                }
            default:
                this.f17710b.onSuccess(obj);
                return;
        }
    }
}
