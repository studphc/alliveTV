package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ni1 extends AtomicReference implements MaybeObserver {
    private static final long serialVersionUID = -2897979525538174559L;

    /* renamed from: a */
    public final MaybeObserver f23371a;

    /* renamed from: b */
    public final BiFunction f23372b;

    /* renamed from: c */
    public Object f23373c;

    public ni1(MaybeObserver maybeObserver, BiFunction biFunction) {
        this.f23371a = maybeObserver;
        this.f23372b = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        this.f23371a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        this.f23371a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        MaybeObserver maybeObserver = this.f23371a;
        Object obj2 = this.f23373c;
        this.f23373c = null;
        try {
            Object apply = this.f23372b.apply(obj2, obj);
            Objects.requireNonNull(apply, "The resultSelector returned a null value");
            maybeObserver.onSuccess(apply);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            maybeObserver.onError(th);
        }
    }
}
