package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class hj1 extends AtomicReference implements MaybeObserver, Disposable {
    private static final long serialVersionUID = 2026620218879969836L;

    /* renamed from: a */
    public final MaybeObserver f18076a;

    /* renamed from: b */
    public final Function f18077b;

    public hj1(MaybeObserver maybeObserver, Function function) {
        this.f18076a = maybeObserver;
        this.f18077b = function;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        this.f18076a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        MaybeObserver maybeObserver = this.f18076a;
        try {
            Object apply = this.f18077b.apply(th);
            Objects.requireNonNull(apply, "The resumeFunction returned a null MaybeSource");
            MaybeSource maybeSource = (MaybeSource) apply;
            DisposableHelper.replace(this, null);
            maybeSource.subscribe(new ei1(maybeObserver, this, 2));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            maybeObserver.onError(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.f18076a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        this.f18076a.onSuccess(obj);
    }
}
