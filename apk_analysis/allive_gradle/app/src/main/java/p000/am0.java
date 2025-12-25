package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class am0 extends AtomicReference implements MaybeObserver, Disposable {
    private static final long serialVersionUID = -502562646270949838L;

    /* renamed from: a */
    public final /* synthetic */ bm0 f257a;

    public am0(bm0 bm0Var) {
        this.f257a = bm0Var;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        bm0 bm0Var = this.f257a;
        bm0Var.f8077e.delete(this);
        int i = bm0Var.get();
        AtomicInteger atomicInteger = bm0Var.f8078f;
        int i2 = bm0Var.f8075c;
        if (i == 0) {
            boolean z = false;
            if (bm0Var.compareAndSet(0, 1)) {
                if (atomicInteger.decrementAndGet() == 0) {
                    z = true;
                }
                SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) bm0Var.f8081i.get();
                if (z && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                    bm0Var.f8079g.tryTerminateConsumer(bm0Var.f8073a);
                    return;
                }
                if (i2 != Integer.MAX_VALUE) {
                    bm0Var.f8082j.request(1L);
                }
                if (bm0Var.decrementAndGet() != 0) {
                    bm0Var.m2107b();
                    return;
                }
                return;
            }
        }
        atomicInteger.decrementAndGet();
        if (i2 != Integer.MAX_VALUE) {
            bm0Var.f8082j.request(1L);
        }
        if (bm0Var.getAndIncrement() == 0) {
            bm0Var.m2107b();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        bm0 bm0Var = this.f257a;
        CompositeDisposable compositeDisposable = bm0Var.f8077e;
        compositeDisposable.delete(this);
        if (bm0Var.f8079g.tryAddThrowableOrReport(th)) {
            if (!bm0Var.f8074b) {
                bm0Var.f8082j.cancel();
                compositeDisposable.dispose();
            } else if (bm0Var.f8075c != Integer.MAX_VALUE) {
                bm0Var.f8082j.request(1L);
            }
            bm0Var.f8078f.decrementAndGet();
            if (bm0Var.getAndIncrement() == 0) {
                bm0Var.m2107b();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        bm0 bm0Var = this.f257a;
        bm0Var.f8077e.delete(this);
        if (bm0Var.get() == 0) {
            boolean z = false;
            if (bm0Var.compareAndSet(0, 1)) {
                if (bm0Var.f8078f.decrementAndGet() == 0) {
                    z = true;
                }
                if (bm0Var.f8076d.get() != 0) {
                    bm0Var.f8073a.onNext(obj);
                    SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) bm0Var.f8081i.get();
                    if (z && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                        bm0Var.f8079g.tryTerminateConsumer(bm0Var.f8073a);
                        return;
                    } else {
                        BackpressureHelper.produced(bm0Var.f8076d, 1L);
                        if (bm0Var.f8075c != Integer.MAX_VALUE) {
                            bm0Var.f8082j.request(1L);
                        }
                    }
                } else {
                    SpscLinkedArrayQueue m2108c = bm0Var.m2108c();
                    synchronized (m2108c) {
                        m2108c.offer(obj);
                    }
                }
                if (bm0Var.decrementAndGet() == 0) {
                    return;
                }
                bm0Var.m2107b();
            }
        }
        SpscLinkedArrayQueue m2108c2 = bm0Var.m2108c();
        synchronized (m2108c2) {
            m2108c2.offer(obj);
        }
        bm0Var.f8078f.decrementAndGet();
        if (bm0Var.getAndIncrement() != 0) {
            return;
        }
        bm0Var.m2107b();
    }
}
