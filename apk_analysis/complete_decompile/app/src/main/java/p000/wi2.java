package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class wi2 extends AtomicInteger implements SingleObserver, Disposable {
    private static final long serialVersionUID = 4109457741734051389L;

    /* renamed from: a */
    public final SingleObserver f28197a;

    /* renamed from: b */
    public final Action f28198b;

    /* renamed from: c */
    public Disposable f28199c;

    public wi2(SingleObserver singleObserver, Action action) {
        this.f28197a = singleObserver;
        this.f28198b = action;
    }

    /* renamed from: a */
    public final void m8060a() {
        if (compareAndSet(0, 1)) {
            try {
                this.f28198b.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f28199c.dispose();
        m8060a();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f28199c.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        this.f28197a.onError(th);
        m8060a();
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f28199c, disposable)) {
            this.f28199c = disposable;
            this.f28197a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        this.f28197a.onSuccess(obj);
        m8060a();
    }
}
