package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class cj2 extends AtomicReference implements SingleObserver, Disposable {
    private static final long serialVersionUID = 3258103020495908596L;

    /* renamed from: a */
    public final SingleObserver f8387a;

    /* renamed from: b */
    public final Function f8388b;

    public cj2(SingleObserver singleObserver, Function function) {
        this.f8387a = singleObserver;
        this.f8388b = function;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        this.f8387a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.f8387a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        SingleObserver singleObserver = this.f8387a;
        try {
            Object apply = this.f8388b.apply(obj);
            Objects.requireNonNull(apply, "The single returned by the mapper is null");
            SingleSource singleSource = (SingleSource) apply;
            if (!isDisposed()) {
                singleSource.subscribe(new xi1(7, this, singleObserver));
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            singleObserver.onError(th);
        }
    }
}
