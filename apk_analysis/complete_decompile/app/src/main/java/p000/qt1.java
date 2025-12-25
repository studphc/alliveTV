package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class qt1 extends AtomicReference implements Observer, Disposable {
    private static final long serialVersionUID = -8498650778633225126L;

    /* renamed from: a */
    public final rt1 f25744a;

    public qt1(rt1 rt1Var) {
        this.f25744a = rt1Var;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (get() == DisposableHelper.DISPOSED) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
        rt1 rt1Var = this.f25744a;
        rt1Var.f26133e.delete(this);
        if (rt1Var.f26133e.size() == 0) {
            DisposableHelper.dispose(rt1Var.f26134f);
            rt1Var.f26136h = true;
            rt1Var.m7301b();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        rt1 rt1Var = this.f25744a;
        DisposableHelper.dispose(rt1Var.f26134f);
        rt1Var.f26133e.delete(this);
        rt1Var.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        rt1 rt1Var = this.f25744a;
        rt1Var.getClass();
        try {
            Object obj2 = rt1Var.f26130b.get();
            Objects.requireNonNull(obj2, "The bufferSupplier returned a null Collection");
            Collection collection = (Collection) obj2;
            Object apply = rt1Var.f26132d.apply(obj);
            Objects.requireNonNull(apply, "The bufferClose returned a null ObservableSource");
            ObservableSource observableSource = (ObservableSource) apply;
            long j = rt1Var.f26139k;
            rt1Var.f26139k = 1 + j;
            synchronized (rt1Var) {
                try {
                    LinkedHashMap linkedHashMap = rt1Var.f26140l;
                    if (linkedHashMap != null) {
                        linkedHashMap.put(Long.valueOf(j), collection);
                        st1 st1Var = new st1(rt1Var, j);
                        rt1Var.f26133e.add(st1Var);
                        observableSource.subscribe(st1Var);
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            DisposableHelper.dispose(rt1Var.f26134f);
            rt1Var.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
