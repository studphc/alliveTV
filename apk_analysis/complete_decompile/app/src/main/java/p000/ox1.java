package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ox1 extends AtomicInteger implements Observer {
    private static final long serialVersionUID = -7098360935104053232L;

    /* renamed from: a */
    public final Observer f24944a;

    /* renamed from: b */
    public final SequentialDisposable f24945b;

    /* renamed from: c */
    public final ObservableSource f24946c;

    /* renamed from: d */
    public final BooleanSupplier f24947d;

    public ox1(Observer observer, BooleanSupplier booleanSupplier, SequentialDisposable sequentialDisposable, ObservableSource observableSource) {
        this.f24944a = observer;
        this.f24945b = sequentialDisposable;
        this.f24946c = observableSource;
        this.f24947d = booleanSupplier;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        Observer observer = this.f24944a;
        try {
            if (this.f24947d.getAsBoolean()) {
                observer.onComplete();
            } else if (getAndIncrement() == 0) {
                int i = 1;
                do {
                    this.f24946c.subscribe(this);
                    i = addAndGet(-i);
                } while (i != 0);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            observer.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f24944a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f24944a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        this.f24945b.replace(disposable);
    }
}
