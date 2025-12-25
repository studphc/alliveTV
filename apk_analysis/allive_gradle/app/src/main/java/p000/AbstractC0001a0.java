package p000;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.observers.LambdaConsumerIntrospection;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: a0 */
/* loaded from: classes2.dex */
public abstract class AbstractC0001a0 extends AtomicReference implements Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = 8924480688481408726L;

    /* renamed from: a */
    public final AtomicReference f1a;

    /* renamed from: b */
    public final Consumer f2b;

    /* renamed from: c */
    public final Action f3c;

    public AbstractC0001a0(Action action, Consumer consumer, DisposableContainer disposableContainer) {
        this.f2b = consumer;
        this.f3c = action;
        this.f1a = new AtomicReference(disposableContainer);
    }

    /* renamed from: a */
    public final void m0a() {
        DisposableContainer disposableContainer = (DisposableContainer) this.f1a.getAndSet(null);
        if (disposableContainer != null) {
            disposableContainer.delete(this);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
        m0a();
    }

    @Override // io.reactivex.rxjava3.observers.LambdaConsumerIntrospection
    public final boolean hasCustomOnError() {
        if (this.f2b != Functions.ON_ERROR_MISSING) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public final void onComplete() {
        Object obj = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (obj != disposableHelper) {
            lazySet(disposableHelper);
            try {
                this.f3c.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
        m0a();
    }

    public final void onError(Throwable th) {
        Object obj = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (obj != disposableHelper) {
            lazySet(disposableHelper);
            try {
                this.f2b.accept(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(new CompositeException(th, th2));
            }
        } else {
            RxJavaPlugins.onError(th);
        }
        m0a();
    }

    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
