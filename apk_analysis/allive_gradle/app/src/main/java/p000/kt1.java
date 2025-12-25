package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class kt1 implements Observer, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f22191a;

    /* renamed from: b */
    public final Observer f22192b;

    /* renamed from: c */
    public final Predicate f22193c;

    /* renamed from: d */
    public Disposable f22194d;

    /* renamed from: e */
    public boolean f22195e;

    public /* synthetic */ kt1(Observer observer, Predicate predicate, int i) {
        this.f22191a = i;
        this.f22192b = observer;
        this.f22193c = predicate;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f22191a) {
            case 0:
                this.f22194d.dispose();
                return;
            case 1:
                this.f22194d.dispose();
                return;
            case 2:
                this.f22194d.dispose();
                return;
            case 3:
                this.f22194d.dispose();
                return;
            default:
                this.f22194d.dispose();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f22191a) {
            case 0:
                return this.f22194d.isDisposed();
            case 1:
                return this.f22194d.isDisposed();
            case 2:
                return this.f22194d.isDisposed();
            case 3:
                return this.f22194d.isDisposed();
            default:
                return this.f22194d.isDisposed();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        switch (this.f22191a) {
            case 0:
                if (!this.f22195e) {
                    this.f22195e = true;
                    Boolean bool = Boolean.TRUE;
                    Observer observer = this.f22192b;
                    observer.onNext(bool);
                    observer.onComplete();
                    return;
                }
                return;
            case 1:
                if (!this.f22195e) {
                    this.f22195e = true;
                    Boolean bool2 = Boolean.FALSE;
                    Observer observer2 = this.f22192b;
                    observer2.onNext(bool2);
                    observer2.onComplete();
                    return;
                }
                return;
            case 2:
                this.f22192b.onComplete();
                return;
            case 3:
                if (!this.f22195e) {
                    this.f22195e = true;
                    this.f22192b.onComplete();
                    return;
                }
                return;
            default:
                if (!this.f22195e) {
                    this.f22195e = true;
                    this.f22192b.onComplete();
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        switch (this.f22191a) {
            case 0:
                if (this.f22195e) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f22195e = true;
                    this.f22192b.onError(th);
                    return;
                }
            case 1:
                if (this.f22195e) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f22195e = true;
                    this.f22192b.onError(th);
                    return;
                }
            case 2:
                this.f22192b.onError(th);
                return;
            case 3:
                if (!this.f22195e) {
                    this.f22195e = true;
                    this.f22192b.onError(th);
                    return;
                } else {
                    RxJavaPlugins.onError(th);
                    return;
                }
            default:
                if (this.f22195e) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f22195e = true;
                    this.f22192b.onError(th);
                    return;
                }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        switch (this.f22191a) {
            case 0:
                if (!this.f22195e) {
                    try {
                        if (!this.f22193c.test(obj)) {
                            this.f22195e = true;
                            this.f22194d.dispose();
                            Boolean bool = Boolean.FALSE;
                            Observer observer = this.f22192b;
                            observer.onNext(bool);
                            observer.onComplete();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f22194d.dispose();
                        onError(th);
                        return;
                    }
                }
                return;
            case 1:
                if (!this.f22195e) {
                    try {
                        if (this.f22193c.test(obj)) {
                            this.f22195e = true;
                            this.f22194d.dispose();
                            Boolean bool2 = Boolean.TRUE;
                            Observer observer2 = this.f22192b;
                            observer2.onNext(bool2);
                            observer2.onComplete();
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f22194d.dispose();
                        onError(th2);
                        return;
                    }
                }
                return;
            case 2:
                boolean z = this.f22195e;
                Observer observer3 = this.f22192b;
                if (z) {
                    observer3.onNext(obj);
                    return;
                }
                try {
                    if (!this.f22193c.test(obj)) {
                        this.f22195e = true;
                        observer3.onNext(obj);
                        return;
                    }
                    return;
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.f22194d.dispose();
                    observer3.onError(th3);
                    return;
                }
            case 3:
                if (!this.f22195e) {
                    Observer observer4 = this.f22192b;
                    observer4.onNext(obj);
                    try {
                        if (this.f22193c.test(obj)) {
                            this.f22195e = true;
                            this.f22194d.dispose();
                            observer4.onComplete();
                            return;
                        }
                        return;
                    } catch (Throwable th4) {
                        Exceptions.throwIfFatal(th4);
                        this.f22194d.dispose();
                        onError(th4);
                        return;
                    }
                }
                return;
            default:
                if (!this.f22195e) {
                    try {
                        boolean test = this.f22193c.test(obj);
                        Observer observer5 = this.f22192b;
                        if (!test) {
                            this.f22195e = true;
                            this.f22194d.dispose();
                            observer5.onComplete();
                            return;
                        }
                        observer5.onNext(obj);
                        return;
                    } catch (Throwable th5) {
                        Exceptions.throwIfFatal(th5);
                        this.f22194d.dispose();
                        onError(th5);
                        return;
                    }
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        switch (this.f22191a) {
            case 0:
                if (DisposableHelper.validate(this.f22194d, disposable)) {
                    this.f22194d = disposable;
                    this.f22192b.onSubscribe(this);
                    return;
                }
                return;
            case 1:
                if (DisposableHelper.validate(this.f22194d, disposable)) {
                    this.f22194d = disposable;
                    this.f22192b.onSubscribe(this);
                    return;
                }
                return;
            case 2:
                if (DisposableHelper.validate(this.f22194d, disposable)) {
                    this.f22194d = disposable;
                    this.f22192b.onSubscribe(this);
                    return;
                }
                return;
            case 3:
                if (DisposableHelper.validate(this.f22194d, disposable)) {
                    this.f22194d = disposable;
                    this.f22192b.onSubscribe(this);
                    return;
                }
                return;
            default:
                if (DisposableHelper.validate(this.f22194d, disposable)) {
                    this.f22194d = disposable;
                    this.f22192b.onSubscribe(this);
                    return;
                }
                return;
        }
    }
}
