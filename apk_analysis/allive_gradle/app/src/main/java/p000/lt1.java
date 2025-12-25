package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class lt1 implements Observer, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f22661a;

    /* renamed from: b */
    public final SingleObserver f22662b;

    /* renamed from: c */
    public final Predicate f22663c;

    /* renamed from: d */
    public Disposable f22664d;

    /* renamed from: e */
    public boolean f22665e;

    public /* synthetic */ lt1(SingleObserver singleObserver, Predicate predicate, int i) {
        this.f22661a = i;
        this.f22662b = singleObserver;
        this.f22663c = predicate;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f22661a) {
            case 0:
                this.f22664d.dispose();
                return;
            default:
                this.f22664d.dispose();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f22661a) {
            case 0:
                return this.f22664d.isDisposed();
            default:
                return this.f22664d.isDisposed();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        switch (this.f22661a) {
            case 0:
                if (!this.f22665e) {
                    this.f22665e = true;
                    this.f22662b.onSuccess(Boolean.TRUE);
                    return;
                }
                return;
            default:
                if (!this.f22665e) {
                    this.f22665e = true;
                    this.f22662b.onSuccess(Boolean.FALSE);
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        switch (this.f22661a) {
            case 0:
                if (this.f22665e) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f22665e = true;
                    this.f22662b.onError(th);
                    return;
                }
            default:
                if (this.f22665e) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f22665e = true;
                    this.f22662b.onError(th);
                    return;
                }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        switch (this.f22661a) {
            case 0:
                if (!this.f22665e) {
                    try {
                        if (!this.f22663c.test(obj)) {
                            this.f22665e = true;
                            this.f22664d.dispose();
                            this.f22662b.onSuccess(Boolean.FALSE);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f22664d.dispose();
                        onError(th);
                        return;
                    }
                }
                return;
            default:
                if (!this.f22665e) {
                    try {
                        if (this.f22663c.test(obj)) {
                            this.f22665e = true;
                            this.f22664d.dispose();
                            this.f22662b.onSuccess(Boolean.TRUE);
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f22664d.dispose();
                        onError(th2);
                        return;
                    }
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        switch (this.f22661a) {
            case 0:
                if (DisposableHelper.validate(this.f22664d, disposable)) {
                    this.f22664d = disposable;
                    this.f22662b.onSubscribe(this);
                    return;
                }
                return;
            default:
                if (DisposableHelper.validate(this.f22664d, disposable)) {
                    this.f22664d = disposable;
                    this.f22662b.onSubscribe(this);
                    return;
                }
                return;
        }
    }
}
