package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ej2 extends AtomicReference implements SingleObserver, CompletableObserver, Disposable {
    private static final long serialVersionUID = -2177128922851101253L;

    /* renamed from: a */
    public final CompletableObserver f16851a;

    /* renamed from: b */
    public final Function f16852b;

    public ej2(CompletableObserver completableObserver, Function function) {
        this.f16851a = completableObserver;
        this.f16852b = function;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        this.f16851a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        this.f16851a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        try {
            Object apply = this.f16852b.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
            CompletableSource completableSource = (CompletableSource) apply;
            if (!isDisposed()) {
                completableSource.subscribe(this);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            onError(th);
        }
    }
}
