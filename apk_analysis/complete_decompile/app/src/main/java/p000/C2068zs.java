package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.operators.completable.CompletablePeek;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;

/* renamed from: zs */
/* loaded from: classes2.dex */
public final class C2068zs implements CompletableObserver, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f29504a = 0;

    /* renamed from: b */
    public Disposable f29505b;

    /* renamed from: c */
    public final Object f29506c;

    /* renamed from: d */
    public final Object f29507d;

    public C2068zs(MaybeObserver maybeObserver, Function function) {
        this.f29506c = maybeObserver;
        this.f29507d = function;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f29504a) {
            case 0:
                this.f29505b.dispose();
                return;
            default:
                try {
                    ((CompletablePeek) this.f29507d).f18700g.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
                this.f29505b.dispose();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f29504a) {
            case 0:
                return this.f29505b.isDisposed();
            default:
                return this.f29505b.isDisposed();
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        switch (this.f29504a) {
            case 0:
                ((MaybeObserver) this.f29506c).onComplete();
                return;
            default:
                CompletableObserver completableObserver = (CompletableObserver) this.f29506c;
                CompletablePeek completablePeek = (CompletablePeek) this.f29507d;
                if (this.f29505b != DisposableHelper.DISPOSED) {
                    try {
                        completablePeek.f18697d.run();
                        completablePeek.f18698e.run();
                        completableObserver.onComplete();
                        try {
                            completablePeek.f18699f.run();
                            return;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            RxJavaPlugins.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        completableObserver.onError(th2);
                        return;
                    }
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        Object obj = this.f29506c;
        Object obj2 = this.f29507d;
        switch (this.f29504a) {
            case 0:
                MaybeObserver maybeObserver = (MaybeObserver) obj;
                try {
                    Object apply = ((Function) obj2).apply(th);
                    Objects.requireNonNull(apply, "The itemSupplier returned a null value");
                    maybeObserver.onSuccess(apply);
                    return;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    maybeObserver.onError(new CompositeException(th, th2));
                    return;
                }
            default:
                CompletablePeek completablePeek = (CompletablePeek) obj2;
                if (this.f29505b == DisposableHelper.DISPOSED) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                try {
                    completablePeek.f18696c.accept(th);
                    completablePeek.f18698e.run();
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    th = new CompositeException(th, th3);
                }
                ((CompletableObserver) obj).onError(th);
                try {
                    completablePeek.f18699f.run();
                    return;
                } catch (Throwable th4) {
                    Exceptions.throwIfFatal(th4);
                    RxJavaPlugins.onError(th4);
                    return;
                }
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        switch (this.f29504a) {
            case 0:
                if (DisposableHelper.validate(this.f29505b, disposable)) {
                    this.f29505b = disposable;
                    ((MaybeObserver) this.f29506c).onSubscribe(this);
                    return;
                }
                return;
            default:
                CompletableObserver completableObserver = (CompletableObserver) this.f29506c;
                try {
                    ((CompletablePeek) this.f29507d).f18695b.accept(disposable);
                    if (DisposableHelper.validate(this.f29505b, disposable)) {
                        this.f29505b = disposable;
                        completableObserver.onSubscribe(this);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    disposable.dispose();
                    this.f29505b = DisposableHelper.DISPOSED;
                    EmptyDisposable.error(th, completableObserver);
                    return;
                }
        }
    }

    public C2068zs(CompletablePeek completablePeek, CompletableObserver completableObserver) {
        this.f29507d = completablePeek;
        this.f29506c = completableObserver;
    }
}
