package p000;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class bw1 extends AtomicReference implements SingleObserver, Disposable {
    private static final long serialVersionUID = -502562646270949838L;

    /* renamed from: a */
    public final /* synthetic */ cw1 f8169a;

    public bw1(cw1 cw1Var) {
        this.f8169a = cw1Var;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        cw1 cw1Var = this.f8169a;
        CompositeDisposable compositeDisposable = cw1Var.f16150c;
        compositeDisposable.delete(this);
        if (cw1Var.f16152e.tryAddThrowableOrReport(th)) {
            if (!cw1Var.f16149b) {
                cw1Var.f16155h.dispose();
                compositeDisposable.dispose();
            }
            cw1Var.f16151d.decrementAndGet();
            if (cw1Var.getAndIncrement() == 0) {
                cw1Var.m4490a();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        cw1 cw1Var = this.f8169a;
        cw1Var.f16150c.delete(this);
        if (cw1Var.get() == 0) {
            boolean z = false;
            if (cw1Var.compareAndSet(0, 1)) {
                cw1Var.f16148a.onNext(obj);
                if (cw1Var.f16151d.decrementAndGet() == 0) {
                    z = true;
                }
                SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) cw1Var.f16154g.get();
                if (z && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                    cw1Var.f16152e.tryTerminateConsumer(cw1Var.f16148a);
                    return;
                }
                if (cw1Var.decrementAndGet() == 0) {
                    return;
                }
                cw1Var.m4490a();
            }
        }
        AtomicReference atomicReference = cw1Var.f16154g;
        SpscLinkedArrayQueue spscLinkedArrayQueue2 = (SpscLinkedArrayQueue) atomicReference.get();
        if (spscLinkedArrayQueue2 == null) {
            spscLinkedArrayQueue2 = new SpscLinkedArrayQueue(Observable.bufferSize());
            while (true) {
                if (atomicReference.compareAndSet(null, spscLinkedArrayQueue2)) {
                    break;
                } else if (atomicReference.get() != null) {
                    spscLinkedArrayQueue2 = (SpscLinkedArrayQueue) atomicReference.get();
                    break;
                }
            }
        }
        SpscLinkedArrayQueue spscLinkedArrayQueue3 = spscLinkedArrayQueue2;
        synchronized (spscLinkedArrayQueue3) {
            spscLinkedArrayQueue3.offer(obj);
        }
        cw1Var.f16151d.decrementAndGet();
        if (cw1Var.getAndIncrement() != 0) {
            return;
        }
        cw1Var.m4490a();
    }
}
