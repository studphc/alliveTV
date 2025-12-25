package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ey1 extends AtomicInteger implements Observer {
    private static final long serialVersionUID = -7098360935104053232L;

    /* renamed from: a */
    public final Observer f17035a;

    /* renamed from: b */
    public final SequentialDisposable f17036b;

    /* renamed from: c */
    public final ObservableSource f17037c;

    /* renamed from: d */
    public final Predicate f17038d;

    /* renamed from: e */
    public long f17039e;

    public ey1(Observer observer, long j, Predicate predicate, SequentialDisposable sequentialDisposable, ObservableSource observableSource) {
        this.f17035a = observer;
        this.f17036b = sequentialDisposable;
        this.f17037c = observableSource;
        this.f17038d = predicate;
        this.f17039e = j;
    }

    /* renamed from: a */
    public final void m4761a() {
        if (getAndIncrement() == 0) {
            int i = 1;
            while (!this.f17036b.isDisposed()) {
                this.f17037c.subscribe(this);
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f17035a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        long j = this.f17039e;
        if (j != Long.MAX_VALUE) {
            this.f17039e = j - 1;
        }
        Observer observer = this.f17035a;
        if (j == 0) {
            observer.onError(th);
            return;
        }
        try {
            if (!this.f17038d.test(th)) {
                observer.onError(th);
            } else {
                m4761a();
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            observer.onError(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f17035a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        this.f17036b.replace(disposable);
    }
}
