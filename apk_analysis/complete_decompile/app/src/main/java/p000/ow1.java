package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ow1 extends AtomicReference implements Observer, Disposable {
    private static final long serialVersionUID = 1883890389173668373L;

    /* renamed from: a */
    public final AtomicInteger f24936a;

    /* renamed from: b */
    public final boolean f24937b;

    /* JADX WARN: Multi-variable type inference failed */
    public ow1(mw1 mw1Var, boolean z) {
        this.f24936a = (AtomicInteger) mw1Var;
        this.f24937b = z;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.atomic.AtomicInteger, mw1] */
    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f24936a.mo5991d(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.atomic.AtomicInteger, mw1] */
    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f24936a.mo5988a(th);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.atomic.AtomicInteger, mw1] */
    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f24936a.mo5990c(obj, this.f24937b);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
