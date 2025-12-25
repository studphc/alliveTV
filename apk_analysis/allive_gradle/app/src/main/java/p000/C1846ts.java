package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ts */
/* loaded from: classes2.dex */
public final class C1846ts extends AtomicReference implements CompletableObserver, Disposable {
    private static final long serialVersionUID = 251330541679988317L;

    /* renamed from: a */
    public final /* synthetic */ C1883us f26948a;

    public C1846ts(C1883us c1883us) {
        this.f26948a = c1883us;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        C1883us c1883us = this.f26948a;
        c1883us.f27424e.delete(this);
        if (c1883us.decrementAndGet() == 0) {
            c1883us.f27423d.tryTerminateConsumer(c1883us.f27420a);
        } else if (c1883us.f27421b != Integer.MAX_VALUE) {
            c1883us.f27425f.request(1L);
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        C1883us c1883us = this.f26948a;
        CompositeDisposable compositeDisposable = c1883us.f27424e;
        compositeDisposable.delete(this);
        boolean z = c1883us.f27422c;
        CompletableObserver completableObserver = c1883us.f27420a;
        AtomicThrowable atomicThrowable = c1883us.f27423d;
        if (!z) {
            c1883us.f27425f.cancel();
            compositeDisposable.dispose();
            if (atomicThrowable.tryAddThrowableOrReport(th) && c1883us.getAndSet(0) > 0) {
                atomicThrowable.tryTerminateConsumer(completableObserver);
                return;
            }
            return;
        }
        if (atomicThrowable.tryAddThrowableOrReport(th)) {
            if (c1883us.decrementAndGet() == 0) {
                atomicThrowable.tryTerminateConsumer(completableObserver);
            } else if (c1883us.f27421b != Integer.MAX_VALUE) {
                c1883us.f27425f.request(1L);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
