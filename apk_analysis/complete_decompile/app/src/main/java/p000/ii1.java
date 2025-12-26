package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ii1 extends AtomicInteger implements MaybeObserver, Disposable {
    private static final long serialVersionUID = 4109457741734051389L;

    /* renamed from: a */
    public final MaybeObserver f18421a;

    /* renamed from: b */
    public final Action f18422b;

    /* renamed from: c */
    public Disposable f18423c;

    public ii1(MaybeObserver maybeObserver, Action action) {
        this.f18421a = maybeObserver;
        this.f18422b = action;
    }

    /* renamed from: a */
    public final void m5245a() {
        if (compareAndSet(0, 1)) {
            try {
                this.f18422b.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f18423c.dispose();
        m5245a();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f18423c.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        this.f18421a.onComplete();
        m5245a();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        this.f18421a.onError(th);
        m5245a();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f18423c, disposable)) {
            this.f18423c = disposable;
            this.f18421a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        this.f18421a.onSuccess(obj);
        m5245a();
    }
}
