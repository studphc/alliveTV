package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class zi2 implements SingleObserver {

    /* renamed from: a */
    public final SingleObserver f29396a;

    /* renamed from: b */
    public final Consumer f29397b;

    /* renamed from: c */
    public boolean f29398c;

    public zi2(SingleObserver singleObserver, Consumer consumer) {
        this.f29396a = singleObserver;
        this.f29397b = consumer;
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        if (this.f29398c) {
            RxJavaPlugins.onError(th);
        } else {
            this.f29396a.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        SingleObserver singleObserver = this.f29396a;
        try {
            this.f29397b.accept(disposable);
            singleObserver.onSubscribe(disposable);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f29398c = true;
            disposable.dispose();
            EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        if (this.f29398c) {
            return;
        }
        this.f29396a.onSuccess(obj);
    }
}
