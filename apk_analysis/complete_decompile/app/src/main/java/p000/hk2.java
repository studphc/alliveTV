package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class hk2 extends AtomicReference implements SingleObserver {
    private static final long serialVersionUID = 3323743579927613702L;

    /* renamed from: a */
    public final gk2 f18088a;

    /* renamed from: b */
    public final int f18089b;

    public hk2(gk2 gk2Var, int i) {
        this.f18088a = gk2Var;
        this.f18089b = i;
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        this.f18088a.m4954a(th, this.f18089b);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        gk2 gk2Var = this.f18088a;
        SingleObserver singleObserver = gk2Var.f17742a;
        Object[] objArr = gk2Var.f17745d;
        if (objArr != null) {
            objArr[this.f18089b] = obj;
        }
        if (gk2Var.decrementAndGet() == 0) {
            try {
                Object apply = gk2Var.f17743b.apply(objArr);
                Objects.requireNonNull(apply, "The zipper returned a null value");
                gk2Var.f17745d = null;
                singleObserver.onSuccess(apply);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                gk2Var.f17745d = null;
                singleObserver.onError(th);
            }
        }
    }
}
