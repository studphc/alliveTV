package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.ResumeSingleObserver;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class qj2 extends AtomicReference implements SingleObserver, Disposable {
    private static final long serialVersionUID = -5314538511045349925L;

    /* renamed from: a */
    public final SingleObserver f25628a;

    /* renamed from: b */
    public final Function f25629b;

    public qj2(SingleObserver singleObserver, Function function) {
        this.f25628a = singleObserver;
        this.f25629b = function;
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
        SingleObserver singleObserver = this.f25628a;
        try {
            Object apply = this.f25629b.apply(th);
            Objects.requireNonNull(apply, "The nextFunction returned a null SingleSource.");
            ((SingleSource) apply).subscribe(new ResumeSingleObserver(this, singleObserver));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            singleObserver.onError(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.f25628a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        this.f25628a.onSuccess(obj);
    }
}
