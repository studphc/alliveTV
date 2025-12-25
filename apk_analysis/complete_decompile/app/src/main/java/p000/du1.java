package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/* loaded from: classes2.dex */
public final class du1 implements Observer, Disposable {

    /* renamed from: a */
    public final SingleObserver f16549a;

    /* renamed from: b */
    public final BiConsumer f16550b;

    /* renamed from: c */
    public final Function f16551c;

    /* renamed from: d */
    public Disposable f16552d;

    /* renamed from: e */
    public boolean f16553e;

    /* renamed from: f */
    public Object f16554f;

    public du1(SingleObserver singleObserver, Object obj, BiConsumer biConsumer, Function function) {
        this.f16549a = singleObserver;
        this.f16554f = obj;
        this.f16550b = biConsumer;
        this.f16551c = function;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f16552d.dispose();
        this.f16552d = DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f16552d == DisposableHelper.DISPOSED) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        Object apply;
        SingleObserver singleObserver = this.f16549a;
        if (this.f16553e) {
            return;
        }
        this.f16553e = true;
        this.f16552d = DisposableHelper.DISPOSED;
        Object obj = this.f16554f;
        this.f16554f = null;
        try {
            apply = this.f16551c.apply(obj);
            Objects.requireNonNull(apply, "The finisher returned a null value");
            singleObserver.onSuccess(apply);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            singleObserver.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f16553e) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f16553e = true;
        this.f16552d = DisposableHelper.DISPOSED;
        this.f16554f = null;
        this.f16549a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (!this.f16553e) {
            try {
                this.f16550b.accept(this.f16554f, obj);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f16552d.dispose();
                onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f16552d, disposable)) {
            this.f16552d = disposable;
            this.f16549a.onSubscribe(this);
        }
    }
}
