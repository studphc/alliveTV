package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class bu1 implements Observer, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f8152a;

    /* renamed from: b */
    public Object f8153b;

    /* renamed from: c */
    public Object f8154c;

    /* renamed from: d */
    public Disposable f8155d;

    /* renamed from: e */
    public boolean f8156e;

    /* renamed from: f */
    public final Object f8157f;

    public /* synthetic */ bu1(Object obj, Object obj2, BiConsumer biConsumer, int i) {
        this.f8152a = i;
        this.f8157f = obj;
        this.f8153b = biConsumer;
        this.f8154c = obj2;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f8152a) {
            case 0:
                this.f8155d.dispose();
                return;
            case 1:
                this.f8155d.dispose();
                return;
            case 2:
                this.f8155d.dispose();
                return;
            case 3:
                this.f8155d.dispose();
                return;
            default:
                this.f8155d.dispose();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f8152a) {
            case 0:
                return this.f8155d.isDisposed();
            case 1:
                return this.f8155d.isDisposed();
            case 2:
                return this.f8155d.isDisposed();
            case 3:
                return this.f8155d.isDisposed();
            default:
                return this.f8155d.isDisposed();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        switch (this.f8152a) {
            case 0:
                if (!this.f8156e) {
                    this.f8156e = true;
                    Object obj = this.f8154c;
                    Observer observer = (Observer) this.f8157f;
                    observer.onNext(obj);
                    observer.onComplete();
                    return;
                }
                return;
            case 1:
                if (!this.f8156e) {
                    this.f8156e = true;
                    ((SingleObserver) this.f8157f).onSuccess(this.f8154c);
                    return;
                }
                return;
            case 2:
                if (!this.f8156e) {
                    this.f8156e = true;
                    Object obj2 = this.f8154c;
                    this.f8154c = null;
                    MaybeObserver maybeObserver = (MaybeObserver) this.f8157f;
                    if (obj2 != null) {
                        maybeObserver.onSuccess(obj2);
                        return;
                    } else {
                        maybeObserver.onComplete();
                        return;
                    }
                }
                return;
            case 3:
                if (!this.f8156e) {
                    this.f8156e = true;
                    Object obj3 = this.f8153b;
                    this.f8153b = null;
                    if (obj3 == null) {
                        obj3 = this.f8154c;
                    }
                    SingleObserver singleObserver = (SingleObserver) this.f8157f;
                    if (obj3 != null) {
                        singleObserver.onSuccess(obj3);
                        return;
                    } else {
                        singleObserver.onError(new NoSuchElementException());
                        return;
                    }
                }
                return;
            default:
                if (!this.f8156e) {
                    this.f8156e = true;
                    ((Observer) this.f8157f).onComplete();
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        switch (this.f8152a) {
            case 0:
                if (this.f8156e) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f8156e = true;
                    ((Observer) this.f8157f).onError(th);
                    return;
                }
            case 1:
                if (this.f8156e) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f8156e = true;
                    ((SingleObserver) this.f8157f).onError(th);
                    return;
                }
            case 2:
                if (this.f8156e) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                this.f8156e = true;
                this.f8154c = null;
                ((MaybeObserver) this.f8157f).onError(th);
                return;
            case 3:
                if (this.f8156e) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f8156e = true;
                    ((SingleObserver) this.f8157f).onError(th);
                    return;
                }
            default:
                if (this.f8156e) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f8156e = true;
                    ((Observer) this.f8157f).onError(th);
                    return;
                }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        switch (this.f8152a) {
            case 0:
                if (!this.f8156e) {
                    try {
                        ((BiConsumer) this.f8153b).accept(this.f8154c, obj);
                        return;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f8155d.dispose();
                        onError(th);
                        return;
                    }
                }
                return;
            case 1:
                if (!this.f8156e) {
                    try {
                        ((BiConsumer) this.f8153b).accept(this.f8154c, obj);
                        return;
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f8155d.dispose();
                        onError(th2);
                        return;
                    }
                }
                return;
            case 2:
                if (!this.f8156e) {
                    Object obj2 = this.f8154c;
                    if (obj2 == null) {
                        this.f8154c = obj;
                        return;
                    }
                    try {
                        Object apply = ((BiFunction) this.f8153b).apply(obj2, obj);
                        Objects.requireNonNull(apply, "The reducer returned a null value");
                        this.f8154c = apply;
                        return;
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        this.f8155d.dispose();
                        onError(th3);
                        return;
                    }
                }
                return;
            case 3:
                if (!this.f8156e) {
                    if (this.f8153b != null) {
                        this.f8156e = true;
                        this.f8155d.dispose();
                        ((SingleObserver) this.f8157f).onError(new IllegalArgumentException("Sequence contains more than one element!"));
                        return;
                    }
                    this.f8153b = obj;
                    return;
                }
                return;
            default:
                Observer observer = (Observer) this.f8157f;
                Iterator it = (Iterator) this.f8153b;
                if (!this.f8156e) {
                    try {
                        Object next = it.next();
                        Objects.requireNonNull(next, "The iterator returned a null value");
                        try {
                            Object apply2 = ((BiFunction) this.f8154c).apply(obj, next);
                            Objects.requireNonNull(apply2, "The zipper function returned a null value");
                            observer.onNext(apply2);
                            try {
                                if (!it.hasNext()) {
                                    this.f8156e = true;
                                    this.f8155d.dispose();
                                    observer.onComplete();
                                    return;
                                }
                                return;
                            } catch (Throwable th4) {
                                Exceptions.throwIfFatal(th4);
                                this.f8156e = true;
                                this.f8155d.dispose();
                                observer.onError(th4);
                                return;
                            }
                        } catch (Throwable th5) {
                            Exceptions.throwIfFatal(th5);
                            this.f8156e = true;
                            this.f8155d.dispose();
                            observer.onError(th5);
                            return;
                        }
                    } catch (Throwable th6) {
                        Exceptions.throwIfFatal(th6);
                        this.f8156e = true;
                        this.f8155d.dispose();
                        observer.onError(th6);
                        return;
                    }
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        switch (this.f8152a) {
            case 0:
                if (DisposableHelper.validate(this.f8155d, disposable)) {
                    this.f8155d = disposable;
                    ((Observer) this.f8157f).onSubscribe(this);
                    return;
                }
                return;
            case 1:
                if (DisposableHelper.validate(this.f8155d, disposable)) {
                    this.f8155d = disposable;
                    ((SingleObserver) this.f8157f).onSubscribe(this);
                    return;
                }
                return;
            case 2:
                if (DisposableHelper.validate(this.f8155d, disposable)) {
                    this.f8155d = disposable;
                    ((MaybeObserver) this.f8157f).onSubscribe(this);
                    return;
                }
                return;
            case 3:
                if (DisposableHelper.validate(this.f8155d, disposable)) {
                    this.f8155d = disposable;
                    ((SingleObserver) this.f8157f).onSubscribe(this);
                    return;
                }
                return;
            default:
                if (DisposableHelper.validate(this.f8155d, disposable)) {
                    this.f8155d = disposable;
                    ((Observer) this.f8157f).onSubscribe(this);
                    return;
                }
                return;
        }
    }

    public bu1(SingleObserver singleObserver, Object obj) {
        this.f8152a = 3;
        this.f8157f = singleObserver;
        this.f8154c = obj;
    }

    public bu1(MaybeObserver maybeObserver, BiFunction biFunction) {
        this.f8152a = 2;
        this.f8157f = maybeObserver;
        this.f8153b = biFunction;
    }

    public bu1(Observer observer, Iterator it, BiFunction biFunction) {
        this.f8152a = 4;
        this.f8157f = observer;
        this.f8153b = it;
        this.f8154c = biFunction;
    }
}
