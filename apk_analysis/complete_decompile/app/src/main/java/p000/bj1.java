package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class bj1 implements SingleObserver, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f8043a = 0;

    /* renamed from: b */
    public final Object f8044b;

    /* renamed from: c */
    public Object f8045c;

    public bj1(MaybeObserver maybeObserver) {
        this.f8044b = maybeObserver;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f8043a) {
            case 0:
                ((Disposable) this.f8045c).dispose();
                this.f8045c = DisposableHelper.DISPOSED;
                return;
            default:
                DisposableHelper.dispose((dj2) this.f8045c);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f8043a) {
            case 0:
                return ((Disposable) this.f8045c).isDisposed();
            default:
                return DisposableHelper.isDisposed((Disposable) ((dj2) this.f8045c).get());
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        switch (this.f8043a) {
            case 0:
                this.f8045c = DisposableHelper.DISPOSED;
                ((MaybeObserver) this.f8044b).onError(th);
                return;
            default:
                ((dj2) this.f8045c).f16394a.onError(th);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        switch (this.f8043a) {
            case 0:
                if (DisposableHelper.validate((Disposable) this.f8045c, disposable)) {
                    this.f8045c = disposable;
                    ((MaybeObserver) this.f8044b).onSubscribe(this);
                    return;
                }
                return;
            default:
                dj2 dj2Var = (dj2) this.f8045c;
                if (DisposableHelper.setOnce(dj2Var, disposable)) {
                    dj2Var.f16394a.onSubscribe(this);
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        switch (this.f8043a) {
            case 0:
                this.f8045c = DisposableHelper.DISPOSED;
                ((MaybeObserver) this.f8044b).onSuccess(obj);
                return;
            default:
                dj2 dj2Var = (dj2) this.f8045c;
                try {
                    Object apply = ((Function) this.f8044b).apply(obj);
                    Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                    SingleSource singleSource = (SingleSource) apply;
                    if (DisposableHelper.replace(dj2Var, null)) {
                        dj2Var.f16396c = obj;
                        singleSource.subscribe(dj2Var);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    dj2Var.f16394a.onError(th);
                    return;
                }
        }
    }

    public bj1(SingleObserver singleObserver, Function function, BiFunction biFunction) {
        this.f8045c = new dj2(singleObserver, biFunction);
        this.f8044b = function;
    }
}
