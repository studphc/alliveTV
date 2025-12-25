package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class tv1 extends AtomicReference implements Observer {
    private static final long serialVersionUID = -4606175640614850599L;

    /* renamed from: a */
    public final uv1 f26974a;

    /* renamed from: b */
    public volatile boolean f26975b;

    /* renamed from: c */
    public volatile SimpleQueue f26976c;

    /* renamed from: d */
    public int f26977d;

    public tv1(uv1 uv1Var) {
        this.f26974a = uv1Var;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f26975b = true;
        this.f26974a.m7773c();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f26974a.f27476h.tryAddThrowableOrReport(th)) {
            uv1 uv1Var = this.f26974a;
            if (!uv1Var.f27471c) {
                uv1Var.m7772b();
            }
            this.f26975b = true;
            this.f26974a.m7773c();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f26977d == 0) {
            uv1 uv1Var = this.f26974a;
            if (uv1Var.get() == 0 && uv1Var.compareAndSet(0, 1)) {
                uv1Var.f27469a.onNext(obj);
                if (uv1Var.decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimpleQueue simpleQueue = this.f26976c;
                if (simpleQueue == null) {
                    simpleQueue = new SpscLinkedArrayQueue(uv1Var.f27473e);
                    this.f26976c = simpleQueue;
                }
                simpleQueue.offer(obj);
                if (uv1Var.getAndIncrement() != 0) {
                    return;
                }
            }
            uv1Var.m7774d();
            return;
        }
        this.f26974a.m7773c();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable) && (disposable instanceof QueueDisposable)) {
            QueueDisposable queueDisposable = (QueueDisposable) disposable;
            int requestFusion = queueDisposable.requestFusion(7);
            if (requestFusion == 1) {
                this.f26977d = requestFusion;
                this.f26976c = queueDisposable;
                this.f26975b = true;
                this.f26974a.m7773c();
                return;
            }
            if (requestFusion == 2) {
                this.f26977d = requestFusion;
                this.f26976c = queueDisposable;
            }
        }
    }
}
