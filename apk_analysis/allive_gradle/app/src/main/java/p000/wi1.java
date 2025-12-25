package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class wi1 extends AtomicReference implements MaybeObserver, Disposable {
    private static final long serialVersionUID = 4827726964688405508L;

    /* renamed from: a */
    public final MaybeObserver f28195a;

    /* renamed from: b */
    public final Function f28196b;

    public wi1(MaybeObserver maybeObserver, Function function) {
        this.f28195a = maybeObserver;
        this.f28196b = function;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        this.f28195a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        this.f28195a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.f28195a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        try {
            Object apply = this.f28196b.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
            SingleSource singleSource = (SingleSource) apply;
            if (!isDisposed()) {
                singleSource.subscribe(new xi1(0, this, this.f28195a));
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            onError(th);
        }
    }
}
