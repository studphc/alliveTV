package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.operators.SimpleQueue;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class InnerQueuedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -5417183359794346637L;

    /* renamed from: a */
    public final InnerQueuedObserverSupport f18621a;

    /* renamed from: b */
    public final int f18622b;

    /* renamed from: c */
    public SimpleQueue f18623c;

    /* renamed from: d */
    public volatile boolean f18624d;

    /* renamed from: e */
    public int f18625e;

    public InnerQueuedObserver(InnerQueuedObserverSupport<T> innerQueuedObserverSupport, int i) {
        this.f18621a = innerQueuedObserverSupport;
        this.f18622b = i;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public boolean isDone() {
        return this.f18624d;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        this.f18621a.innerComplete(this);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable th) {
        this.f18621a.innerError(this, th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        int i = this.f18625e;
        InnerQueuedObserverSupport innerQueuedObserverSupport = this.f18621a;
        if (i == 0) {
            innerQueuedObserverSupport.innerNext(this, t);
        } else {
            innerQueuedObserverSupport.drain();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            if (disposable instanceof QueueDisposable) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(3);
                if (requestFusion == 1) {
                    this.f18625e = requestFusion;
                    this.f18623c = queueDisposable;
                    this.f18624d = true;
                    this.f18621a.innerComplete(this);
                    return;
                }
                if (requestFusion == 2) {
                    this.f18625e = requestFusion;
                    this.f18623c = queueDisposable;
                    return;
                }
            }
            this.f18623c = QueueDrainHelper.createQueue(-this.f18622b);
        }
    }

    public SimpleQueue<T> queue() {
        return this.f18623c;
    }

    public void setDone() {
        this.f18624d = true;
    }
}
