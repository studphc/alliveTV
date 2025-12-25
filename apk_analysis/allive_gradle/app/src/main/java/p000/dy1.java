package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class dy1 extends AtomicInteger implements Observer {
    private static final long serialVersionUID = -7098360935104053232L;

    /* renamed from: a */
    public final Observer f16610a;

    /* renamed from: b */
    public final SequentialDisposable f16611b;

    /* renamed from: c */
    public final ObservableSource f16612c;

    /* renamed from: d */
    public final BiPredicate f16613d;

    /* renamed from: e */
    public int f16614e;

    public dy1(Observer observer, BiPredicate biPredicate, SequentialDisposable sequentialDisposable, ObservableSource observableSource) {
        this.f16610a = observer;
        this.f16611b = sequentialDisposable;
        this.f16612c = observableSource;
        this.f16613d = biPredicate;
    }

    /* renamed from: a */
    public final void m4645a() {
        if (getAndIncrement() == 0) {
            int i = 1;
            while (!this.f16611b.isDisposed()) {
                this.f16612c.subscribe(this);
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f16610a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        Observer observer = this.f16610a;
        try {
            BiPredicate biPredicate = this.f16613d;
            int i = this.f16614e + 1;
            this.f16614e = i;
            if (!biPredicate.test(Integer.valueOf(i), th)) {
                observer.onError(th);
            } else {
                m4645a();
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            observer.onError(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f16610a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        this.f16611b.replace(disposable);
    }
}
