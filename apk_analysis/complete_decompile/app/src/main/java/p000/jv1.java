package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class jv1 implements Observer, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f20646a = 1;

    /* renamed from: b */
    public Disposable f20647b;

    /* renamed from: c */
    public boolean f20648c;

    /* renamed from: d */
    public final Object f20649d;

    /* renamed from: e */
    public Object f20650e;

    public jv1(MaybeObserver maybeObserver) {
        this.f20649d = maybeObserver;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f20646a) {
            case 0:
                this.f20647b.dispose();
                return;
            default:
                this.f20647b.dispose();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f20646a) {
            case 0:
                return this.f20647b.isDisposed();
            default:
                return this.f20647b.isDisposed();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        switch (this.f20646a) {
            case 0:
                if (!this.f20648c) {
                    this.f20648c = true;
                    ((Observer) this.f20649d).onComplete();
                    return;
                }
                return;
            default:
                if (!this.f20648c) {
                    this.f20648c = true;
                    Object obj = this.f20650e;
                    this.f20650e = null;
                    MaybeObserver maybeObserver = (MaybeObserver) this.f20649d;
                    if (obj == null) {
                        maybeObserver.onComplete();
                        return;
                    } else {
                        maybeObserver.onSuccess(obj);
                        return;
                    }
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        switch (this.f20646a) {
            case 0:
                if (this.f20648c) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f20648c = true;
                    ((Observer) this.f20649d).onError(th);
                    return;
                }
            default:
                if (this.f20648c) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f20648c = true;
                    ((MaybeObserver) this.f20649d).onError(th);
                    return;
                }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        switch (this.f20646a) {
            case 0:
                if (this.f20648c) {
                    if (obj instanceof Notification) {
                        Notification notification = (Notification) obj;
                        if (notification.isOnError()) {
                            RxJavaPlugins.onError(notification.getError());
                            return;
                        }
                        return;
                    }
                    return;
                }
                try {
                    Object apply = ((Function) this.f20650e).apply(obj);
                    Objects.requireNonNull(apply, "The selector returned a null Notification");
                    Notification notification2 = (Notification) apply;
                    if (notification2.isOnError()) {
                        this.f20647b.dispose();
                        onError(notification2.getError());
                        return;
                    } else if (notification2.isOnComplete()) {
                        this.f20647b.dispose();
                        onComplete();
                        return;
                    } else {
                        ((Observer) this.f20649d).onNext(notification2.getValue());
                        return;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f20647b.dispose();
                    onError(th);
                    return;
                }
            default:
                if (!this.f20648c) {
                    if (this.f20650e != null) {
                        this.f20648c = true;
                        this.f20647b.dispose();
                        ((MaybeObserver) this.f20649d).onError(new IllegalArgumentException("Sequence contains more than one element!"));
                        return;
                    }
                    this.f20650e = obj;
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        switch (this.f20646a) {
            case 0:
                if (DisposableHelper.validate(this.f20647b, disposable)) {
                    this.f20647b = disposable;
                    ((Observer) this.f20649d).onSubscribe(this);
                    return;
                }
                return;
            default:
                if (DisposableHelper.validate(this.f20647b, disposable)) {
                    this.f20647b = disposable;
                    ((MaybeObserver) this.f20649d).onSubscribe(this);
                    return;
                }
                return;
        }
    }

    public jv1(Observer observer, Function function) {
        this.f20649d = observer;
        this.f20650e = function;
    }
}
