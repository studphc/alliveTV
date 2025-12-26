package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class xi2 extends AtomicReference implements SingleObserver, Disposable {
    private static final long serialVersionUID = -8583764624474935784L;

    /* renamed from: a */
    public final SingleObserver f28581a;

    /* renamed from: b */
    public Disposable f28582b;

    public xi2(SingleObserver singleObserver, Action action) {
        this.f28581a = singleObserver;
        lazySet(action);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        Action action = (Action) getAndSet(null);
        if (action != null) {
            try {
                action.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            this.f28582b.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f28582b.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        this.f28581a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f28582b, disposable)) {
            this.f28582b = disposable;
            this.f28581a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        this.f28581a.onSuccess(obj);
    }
}
