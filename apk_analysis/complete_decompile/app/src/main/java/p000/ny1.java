package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ny1 implements Observer, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f23531a = 0;

    /* renamed from: b */
    public final Observer f23532b;

    /* renamed from: c */
    public final BiFunction f23533c;

    /* renamed from: d */
    public Object f23534d;

    /* renamed from: e */
    public Disposable f23535e;

    /* renamed from: f */
    public boolean f23536f;

    public ny1(Observer observer, BiFunction biFunction) {
        this.f23532b = observer;
        this.f23533c = biFunction;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f23531a) {
            case 0:
                this.f23535e.dispose();
                return;
            default:
                this.f23535e.dispose();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f23531a) {
            case 0:
                return this.f23535e.isDisposed();
            default:
                return this.f23535e.isDisposed();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        switch (this.f23531a) {
            case 0:
                if (!this.f23536f) {
                    this.f23536f = true;
                    this.f23532b.onComplete();
                    return;
                }
                return;
            default:
                if (!this.f23536f) {
                    this.f23536f = true;
                    this.f23532b.onComplete();
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        switch (this.f23531a) {
            case 0:
                if (this.f23536f) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f23536f = true;
                    this.f23532b.onError(th);
                    return;
                }
            default:
                if (this.f23536f) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f23536f = true;
                    this.f23532b.onError(th);
                    return;
                }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        switch (this.f23531a) {
            case 0:
                if (!this.f23536f) {
                    Object obj2 = this.f23534d;
                    Observer observer = this.f23532b;
                    if (obj2 == null) {
                        this.f23534d = obj;
                        observer.onNext(obj);
                        return;
                    }
                    try {
                        Object apply = this.f23533c.apply(obj2, obj);
                        Objects.requireNonNull(apply, "The value returned by the accumulator is null");
                        this.f23534d = apply;
                        observer.onNext(apply);
                        return;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f23535e.dispose();
                        onError(th);
                        return;
                    }
                }
                return;
            default:
                if (!this.f23536f) {
                    try {
                        Object apply2 = this.f23533c.apply(this.f23534d, obj);
                        Objects.requireNonNull(apply2, "The accumulator returned a null value");
                        this.f23534d = apply2;
                        this.f23532b.onNext(apply2);
                        return;
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f23535e.dispose();
                        onError(th2);
                        return;
                    }
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        switch (this.f23531a) {
            case 0:
                if (DisposableHelper.validate(this.f23535e, disposable)) {
                    this.f23535e = disposable;
                    this.f23532b.onSubscribe(this);
                    return;
                }
                return;
            default:
                if (DisposableHelper.validate(this.f23535e, disposable)) {
                    this.f23535e = disposable;
                    Observer observer = this.f23532b;
                    observer.onSubscribe(this);
                    observer.onNext(this.f23534d);
                    return;
                }
                return;
        }
    }

    public ny1(Observer observer, BiFunction biFunction, Object obj) {
        this.f23532b = observer;
        this.f23533c = biFunction;
        this.f23534d = obj;
    }
}
