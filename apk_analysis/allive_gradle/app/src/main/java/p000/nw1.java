package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class nw1 extends AtomicReference implements Observer, Disposable {
    private static final long serialVersionUID = 1883890389173668373L;

    /* renamed from: a */
    public final AtomicInteger f23513a;

    /* renamed from: b */
    public final boolean f23514b;

    /* renamed from: c */
    public final int f23515c;

    /* JADX WARN: Multi-variable type inference failed */
    public nw1(mw1 mw1Var, boolean z, int i) {
        this.f23513a = (AtomicInteger) mw1Var;
        this.f23514b = z;
        this.f23515c = i;
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
        this.f23513a.mo5992e(this.f23514b, this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.atomic.AtomicInteger, mw1] */
    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f23513a.mo5989b(th);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.concurrent.atomic.AtomicInteger, mw1] */
    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (DisposableHelper.dispose(this)) {
            this.f23513a.mo5992e(this.f23514b, this);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
