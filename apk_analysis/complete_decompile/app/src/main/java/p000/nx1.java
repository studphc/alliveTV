package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class nx1 extends AtomicInteger implements Observer {
    private static final long serialVersionUID = -7098360935104053232L;

    /* renamed from: a */
    public final Observer f23522a;

    /* renamed from: b */
    public final SequentialDisposable f23523b;

    /* renamed from: c */
    public final ObservableSource f23524c;

    /* renamed from: d */
    public long f23525d;

    public nx1(Observer observer, long j, SequentialDisposable sequentialDisposable, ObservableSource observableSource) {
        this.f23522a = observer;
        this.f23523b = sequentialDisposable;
        this.f23524c = observableSource;
        this.f23525d = j;
    }

    /* renamed from: a */
    public final void m6399a() {
        if (getAndIncrement() == 0) {
            int i = 1;
            while (!this.f23523b.isDisposed()) {
                this.f23524c.subscribe(this);
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        long j = this.f23525d;
        if (j != Long.MAX_VALUE) {
            this.f23525d = j - 1;
        }
        if (j != 0) {
            m6399a();
        } else {
            this.f23522a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f23522a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f23522a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        this.f23523b.replace(disposable);
    }
}
