package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class zv1 extends AtomicReference implements MaybeObserver, Disposable {
    private static final long serialVersionUID = -502562646270949838L;

    /* renamed from: a */
    public final /* synthetic */ aw1 f29526a;

    public zv1(aw1 aw1Var) {
        this.f29526a = aw1Var;
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
        aw1 aw1Var = this.f29526a;
        aw1Var.f7765c.delete(this);
        int i = aw1Var.get();
        AtomicInteger atomicInteger = aw1Var.f7766d;
        if (i == 0) {
            boolean z = false;
            if (aw1Var.compareAndSet(0, 1)) {
                if (atomicInteger.decrementAndGet() == 0) {
                    z = true;
                }
                SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) aw1Var.f7769g.get();
                if (z && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                    aw1Var.f7767e.tryTerminateConsumer(aw1Var.f7763a);
                    return;
                } else {
                    if (aw1Var.decrementAndGet() != 0) {
                        aw1Var.m1973a();
                        return;
                    }
                    return;
                }
            }
        }
        atomicInteger.decrementAndGet();
        if (aw1Var.getAndIncrement() == 0) {
            aw1Var.m1973a();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        aw1 aw1Var = this.f29526a;
        CompositeDisposable compositeDisposable = aw1Var.f7765c;
        compositeDisposable.delete(this);
        if (aw1Var.f7767e.tryAddThrowableOrReport(th)) {
            if (!aw1Var.f7764b) {
                aw1Var.f7770h.dispose();
                compositeDisposable.dispose();
            }
            aw1Var.f7766d.decrementAndGet();
            if (aw1Var.getAndIncrement() == 0) {
                aw1Var.m1973a();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        aw1 aw1Var = this.f29526a;
        aw1Var.f7765c.delete(this);
        if (aw1Var.get() == 0) {
            boolean z = false;
            if (aw1Var.compareAndSet(0, 1)) {
                aw1Var.f7763a.onNext(obj);
                if (aw1Var.f7766d.decrementAndGet() == 0) {
                    z = true;
                }
                SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) aw1Var.f7769g.get();
                if (z && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                    aw1Var.f7767e.tryTerminateConsumer(aw1Var.f7763a);
                    return;
                }
                if (aw1Var.decrementAndGet() == 0) {
                    return;
                }
                aw1Var.m1973a();
            }
        }
        AtomicReference atomicReference = aw1Var.f7769g;
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
        aw1Var.f7766d.decrementAndGet();
        if (aw1Var.getAndIncrement() != 0) {
            return;
        }
        aw1Var.m1973a();
    }
}
