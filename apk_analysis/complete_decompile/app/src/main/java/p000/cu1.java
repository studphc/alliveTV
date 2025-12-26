package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/* loaded from: classes2.dex */
public final class cu1 extends DeferredScalarDisposable implements Observer {
    private static final long serialVersionUID = -229544830565448758L;

    /* renamed from: a */
    public final BiConsumer f16112a;

    /* renamed from: b */
    public final Function f16113b;

    /* renamed from: c */
    public Disposable f16114c;

    /* renamed from: d */
    public boolean f16115d;

    /* renamed from: e */
    public Object f16116e;

    public cu1(Observer observer, Object obj, BiConsumer biConsumer, Function function) {
        super(observer);
        this.f16116e = obj;
        this.f16112a = biConsumer;
        this.f16113b = function;
    }

    @Override // io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable, io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        super.dispose();
        this.f16114c.dispose();
    }

    @Override // io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable
    public final void onComplete() {
        Object apply;
        if (this.f16115d) {
            return;
        }
        this.f16115d = true;
        this.f16114c = DisposableHelper.DISPOSED;
        Object obj = this.f16116e;
        this.f16116e = null;
        try {
            apply = this.f16113b.apply(obj);
            Objects.requireNonNull(apply, "The finisher returned a null value");
            complete(apply);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable
    public final void onError(Throwable th) {
        if (this.f16115d) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f16115d = true;
        this.f16114c = DisposableHelper.DISPOSED;
        this.f16116e = null;
        this.downstream.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (!this.f16115d) {
            try {
                this.f16112a.accept(this.f16116e, obj);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f16114c.dispose();
                onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f16114c, disposable)) {
            this.f16114c = disposable;
            this.downstream.onSubscribe(this);
        }
    }
}
