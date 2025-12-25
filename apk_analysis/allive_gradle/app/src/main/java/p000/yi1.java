package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class yi1 extends AtomicReference implements MaybeObserver, Disposable {
    private static final long serialVersionUID = 4375739915521278546L;

    /* renamed from: a */
    public final MaybeObserver f28966a;

    /* renamed from: b */
    public final Function f28967b;

    /* renamed from: c */
    public Disposable f28968c;

    public yi1(MaybeObserver maybeObserver, Function function) {
        this.f28966a = maybeObserver;
        this.f28967b = function;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
        this.f28968c.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        this.f28966a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        this.f28966a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f28968c, disposable)) {
            this.f28968c = disposable;
            this.f28966a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        try {
            Object apply = this.f28967b.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
            MaybeSource maybeSource = (MaybeSource) apply;
            if (!isDisposed()) {
                maybeSource.subscribe(new si1(this, 1));
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f28966a.onError(th);
        }
    }
}
