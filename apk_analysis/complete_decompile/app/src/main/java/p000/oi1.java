package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class oi1 implements MaybeObserver, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f23814a = 1;

    /* renamed from: b */
    public final Object f23815b;

    /* renamed from: c */
    public Object f23816c;

    public oi1(CompletableObserver completableObserver) {
        this.f23815b = completableObserver;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f23814a) {
            case 0:
                DisposableHelper.dispose((ni1) this.f23816c);
                return;
            default:
                ((Disposable) this.f23816c).dispose();
                this.f23816c = DisposableHelper.DISPOSED;
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f23814a) {
            case 0:
                return DisposableHelper.isDisposed((Disposable) ((ni1) this.f23816c).get());
            default:
                return ((Disposable) this.f23816c).isDisposed();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        switch (this.f23814a) {
            case 0:
                ((ni1) this.f23816c).f23371a.onComplete();
                return;
            default:
                this.f23816c = DisposableHelper.DISPOSED;
                ((CompletableObserver) this.f23815b).onComplete();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        switch (this.f23814a) {
            case 0:
                ((ni1) this.f23816c).f23371a.onError(th);
                return;
            default:
                this.f23816c = DisposableHelper.DISPOSED;
                ((CompletableObserver) this.f23815b).onError(th);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        switch (this.f23814a) {
            case 0:
                ni1 ni1Var = (ni1) this.f23816c;
                if (DisposableHelper.setOnce(ni1Var, disposable)) {
                    ni1Var.f23371a.onSubscribe(this);
                    return;
                }
                return;
            default:
                if (DisposableHelper.validate((Disposable) this.f23816c, disposable)) {
                    this.f23816c = disposable;
                    ((CompletableObserver) this.f23815b).onSubscribe(this);
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        switch (this.f23814a) {
            case 0:
                ni1 ni1Var = (ni1) this.f23816c;
                try {
                    Object apply = ((Function) this.f23815b).apply(obj);
                    Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                    MaybeSource maybeSource = (MaybeSource) apply;
                    if (DisposableHelper.replace(ni1Var, null)) {
                        ni1Var.f23373c = obj;
                        maybeSource.subscribe(ni1Var);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    ni1Var.f23371a.onError(th);
                    return;
                }
            default:
                this.f23816c = DisposableHelper.DISPOSED;
                ((CompletableObserver) this.f23815b).onComplete();
                return;
        }
    }

    public oi1(MaybeObserver maybeObserver, Function function, BiFunction biFunction) {
        this.f23816c = new ni1(maybeObserver, biFunction);
        this.f23815b = function;
    }
}
