package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ti1 extends AtomicReference implements MaybeObserver, Disposable {
    private static final long serialVersionUID = 4375739915521278546L;

    /* renamed from: a */
    public final MaybeObserver f26825a;

    /* renamed from: b */
    public final Function f26826b;

    /* renamed from: c */
    public final Function f26827c;

    /* renamed from: d */
    public final Supplier f26828d;

    /* renamed from: e */
    public Disposable f26829e;

    public ti1(MaybeObserver maybeObserver, Function function, Function function2, Supplier supplier) {
        this.f26825a = maybeObserver;
        this.f26826b = function;
        this.f26827c = function2;
        this.f26828d = supplier;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
        this.f26829e.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        try {
            Object obj = this.f26828d.get();
            Objects.requireNonNull(obj, "The onCompleteSupplier returned a null MaybeSource");
            MaybeSource maybeSource = (MaybeSource) obj;
            if (!isDisposed()) {
                maybeSource.subscribe(new si1(this, 0));
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f26825a.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        try {
            Object apply = this.f26827c.apply(th);
            Objects.requireNonNull(apply, "The onErrorMapper returned a null MaybeSource");
            MaybeSource maybeSource = (MaybeSource) apply;
            if (!isDisposed()) {
                maybeSource.subscribe(new si1(this, 0));
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            this.f26825a.onError(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f26829e, disposable)) {
            this.f26829e = disposable;
            this.f26825a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        try {
            Object apply = this.f26826b.apply(obj);
            Objects.requireNonNull(apply, "The onSuccessMapper returned a null MaybeSource");
            MaybeSource maybeSource = (MaybeSource) apply;
            if (!isDisposed()) {
                maybeSource.subscribe(new si1(this, 0));
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f26825a.onError(th);
        }
    }
}
