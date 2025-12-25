package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class mi1 implements SingleObserver, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f22945a;

    /* renamed from: b */
    public Disposable f22946b;

    /* renamed from: c */
    public final Object f22947c;

    /* renamed from: d */
    public final Object f22948d;

    public /* synthetic */ mi1(int i, Object obj, Object obj2) {
        this.f22945a = i;
        this.f22947c = obj;
        this.f22948d = obj2;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f22945a) {
            case 0:
                Disposable disposable = this.f22946b;
                this.f22946b = DisposableHelper.DISPOSED;
                disposable.dispose();
                return;
            case 1:
                this.f22946b.dispose();
                return;
            default:
                this.f22946b.dispose();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f22945a) {
            case 0:
                return this.f22946b.isDisposed();
            case 1:
                return this.f22946b.isDisposed();
            default:
                return this.f22946b.isDisposed();
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        switch (this.f22945a) {
            case 0:
                ((MaybeObserver) this.f22947c).onError(th);
                return;
            case 1:
                ((SingleObserver) this.f22947c).onError(th);
                return;
            default:
                ((SingleObserver) this.f22947c).onError(th);
                try {
                    ((Action) this.f22948d).run();
                    return;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                    return;
                }
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        switch (this.f22945a) {
            case 0:
                if (DisposableHelper.validate(this.f22946b, disposable)) {
                    this.f22946b = disposable;
                    ((MaybeObserver) this.f22947c).onSubscribe(this);
                    return;
                }
                return;
            case 1:
                if (DisposableHelper.validate(this.f22946b, disposable)) {
                    this.f22946b = disposable;
                    ((SingleObserver) this.f22947c).onSubscribe(this);
                    return;
                }
                return;
            default:
                if (DisposableHelper.validate(this.f22946b, disposable)) {
                    this.f22946b = disposable;
                    ((SingleObserver) this.f22947c).onSubscribe(this);
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        switch (this.f22945a) {
            case 0:
                MaybeObserver maybeObserver = (MaybeObserver) this.f22947c;
                try {
                    if (((Predicate) this.f22948d).test(obj)) {
                        maybeObserver.onSuccess(obj);
                        return;
                    } else {
                        maybeObserver.onComplete();
                        return;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    maybeObserver.onError(th);
                    return;
                }
            case 1:
                ((SingleObserver) this.f22947c).onSuccess(obj);
                try {
                    ((Consumer) this.f22948d).accept(obj);
                    return;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                    return;
                }
            default:
                ((SingleObserver) this.f22947c).onSuccess(obj);
                try {
                    ((Action) this.f22948d).run();
                    return;
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    RxJavaPlugins.onError(th3);
                    return;
                }
        }
    }
}
