package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class pv1 implements Observer, Disposable {

    /* renamed from: a */
    public final Observer f25312a;

    /* renamed from: b */
    public final Consumer f25313b;

    /* renamed from: c */
    public final Consumer f25314c;

    /* renamed from: d */
    public final Action f25315d;

    /* renamed from: e */
    public final Action f25316e;

    /* renamed from: f */
    public Disposable f25317f;

    /* renamed from: g */
    public boolean f25318g;

    public pv1(Observer observer, Consumer consumer, Consumer consumer2, Action action, Action action2) {
        this.f25312a = observer;
        this.f25313b = consumer;
        this.f25314c = consumer2;
        this.f25315d = action;
        this.f25316e = action2;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f25317f.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f25317f.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (this.f25318g) {
            return;
        }
        try {
            this.f25315d.run();
            this.f25318g = true;
            this.f25312a.onComplete();
            try {
                this.f25316e.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            onError(th2);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f25318g) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f25318g = true;
        try {
            this.f25314c.accept(th);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            th = new CompositeException(th, th2);
        }
        this.f25312a.onError(th);
        try {
            this.f25316e.run();
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            RxJavaPlugins.onError(th3);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f25318g) {
            return;
        }
        try {
            this.f25313b.accept(obj);
            this.f25312a.onNext(obj);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f25317f.dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f25317f, disposable)) {
            this.f25317f = disposable;
            this.f25312a.onSubscribe(this);
        }
    }
}
