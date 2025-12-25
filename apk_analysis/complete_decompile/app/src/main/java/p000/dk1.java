package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class dk1 extends AtomicReference implements MaybeObserver {
    private static final long serialVersionUID = 3323743579927613702L;

    /* renamed from: a */
    public final ck1 f16399a;

    /* renamed from: b */
    public final int f16400b;

    public dk1(ck1 ck1Var, int i) {
        this.f16399a = ck1Var;
        this.f16400b = i;
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        ck1 ck1Var = this.f16399a;
        if (ck1Var.getAndSet(0) > 0) {
            ck1Var.m2263a(this.f16400b);
            ck1Var.f8406d = null;
            ck1Var.f8403a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        ck1 ck1Var = this.f16399a;
        if (ck1Var.getAndSet(0) > 0) {
            ck1Var.m2263a(this.f16400b);
            ck1Var.f8406d = null;
            ck1Var.f8403a.onError(th);
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        ck1 ck1Var = this.f16399a;
        MaybeObserver maybeObserver = ck1Var.f8403a;
        Object[] objArr = ck1Var.f8406d;
        if (objArr != null) {
            objArr[this.f16400b] = obj;
        }
        if (ck1Var.decrementAndGet() == 0) {
            try {
                Object apply = ck1Var.f8404b.apply(objArr);
                Objects.requireNonNull(apply, "The zipper returned a null value");
                ck1Var.f8406d = null;
                maybeObserver.onSuccess(apply);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                ck1Var.f8406d = null;
                maybeObserver.onError(th);
            }
        }
    }
}
