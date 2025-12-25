package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class dj2 extends AtomicReference implements SingleObserver {
    private static final long serialVersionUID = -2897979525538174559L;

    /* renamed from: a */
    public final SingleObserver f16394a;

    /* renamed from: b */
    public final BiFunction f16395b;

    /* renamed from: c */
    public Object f16396c;

    public dj2(SingleObserver singleObserver, BiFunction biFunction) {
        this.f16394a = singleObserver;
        this.f16395b = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        this.f16394a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        SingleObserver singleObserver = this.f16394a;
        Object obj2 = this.f16396c;
        this.f16396c = null;
        try {
            Object apply = this.f16395b.apply(obj2, obj);
            Objects.requireNonNull(apply, "The resultSelector returned a null value");
            singleObserver.onSuccess(apply);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            singleObserver.onError(th);
        }
    }
}
