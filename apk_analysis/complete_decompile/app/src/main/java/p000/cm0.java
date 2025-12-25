package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class cm0 extends AtomicReference implements SingleObserver, Disposable {
    private static final long serialVersionUID = -502562646270949838L;

    /* renamed from: a */
    public final /* synthetic */ dm0 f8417a;

    public cm0(dm0 dm0Var) {
        this.f8417a = dm0Var;
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
        dm0 dm0Var = this.f8417a;
        CompositeDisposable compositeDisposable = dm0Var.f16420e;
        compositeDisposable.delete(this);
        if (dm0Var.f16422g.tryAddThrowableOrReport(th)) {
            if (!dm0Var.f16417b) {
                dm0Var.f16425j.cancel();
                compositeDisposable.dispose();
            } else if (dm0Var.f16418c != Integer.MAX_VALUE) {
                dm0Var.f16425j.request(1L);
            }
            dm0Var.f16421f.decrementAndGet();
            if (dm0Var.getAndIncrement() == 0) {
                dm0Var.m4591b();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        dm0 dm0Var = this.f8417a;
        dm0Var.f16420e.delete(this);
        if (dm0Var.get() == 0) {
            boolean z = false;
            if (dm0Var.compareAndSet(0, 1)) {
                if (dm0Var.f16421f.decrementAndGet() == 0) {
                    z = true;
                }
                if (dm0Var.f16419d.get() != 0) {
                    dm0Var.f16416a.onNext(obj);
                    SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) dm0Var.f16424i.get();
                    if (z && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                        dm0Var.f16422g.tryTerminateConsumer(dm0Var.f16416a);
                        return;
                    } else {
                        BackpressureHelper.produced(dm0Var.f16419d, 1L);
                        if (dm0Var.f16418c != Integer.MAX_VALUE) {
                            dm0Var.f16425j.request(1L);
                        }
                    }
                } else {
                    SpscLinkedArrayQueue m4592c = dm0Var.m4592c();
                    synchronized (m4592c) {
                        m4592c.offer(obj);
                    }
                }
                if (dm0Var.decrementAndGet() == 0) {
                    return;
                }
                dm0Var.m4591b();
            }
        }
        SpscLinkedArrayQueue m4592c2 = dm0Var.m4592c();
        synchronized (m4592c2) {
            m4592c2.offer(obj);
        }
        dm0Var.f16421f.decrementAndGet();
        if (dm0Var.getAndIncrement() != 0) {
            return;
        }
        dm0Var.m4591b();
    }
}
