package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public abstract class ConcatMapXMainObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
    private static final long serialVersionUID = -3214213361171757852L;

    /* renamed from: a */
    public final AtomicThrowable f19234a = new AtomicThrowable();

    /* renamed from: b */
    public final int f19235b;

    /* renamed from: c */
    public final ErrorMode f19236c;

    /* renamed from: d */
    public SimpleQueue f19237d;

    /* renamed from: e */
    public Disposable f19238e;

    /* renamed from: f */
    public volatile boolean f19239f;

    /* renamed from: g */
    public volatile boolean f19240g;

    public ConcatMapXMainObserver(int i, ErrorMode errorMode) {
        this.f19236c = errorMode;
        this.f19235b = i;
    }

    /* renamed from: a */
    public void mo5286a() {
    }

    /* renamed from: b */
    public abstract void mo5287b();

    /* renamed from: c */
    public abstract void mo5288c();

    /* renamed from: d */
    public abstract void mo5289d();

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f19240g = true;
        this.f19238e.dispose();
        mo5287b();
        this.f19234a.tryTerminateAndReport();
        if (getAndIncrement() == 0) {
            this.f19237d.clear();
            mo5286a();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f19240g;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f19239f = true;
        mo5288c();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f19234a.tryAddThrowableOrReport(th)) {
            if (this.f19236c == ErrorMode.IMMEDIATE) {
                mo5287b();
            }
            this.f19239f = true;
            mo5288c();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(T t) {
        if (t != null) {
            this.f19237d.offer(t);
        }
        mo5288c();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f19238e, disposable)) {
            this.f19238e = disposable;
            if (disposable instanceof QueueDisposable) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(7);
                if (requestFusion == 1) {
                    this.f19237d = queueDisposable;
                    this.f19239f = true;
                    mo5289d();
                    mo5288c();
                    return;
                }
                if (requestFusion == 2) {
                    this.f19237d = queueDisposable;
                    mo5289d();
                    return;
                }
            }
            this.f19237d = new SpscLinkedArrayQueue(this.f19235b);
            mo5289d();
        }
    }
}
