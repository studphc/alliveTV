package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class oz1 extends AtomicReference implements Observer, Disposable {
    private static final long serialVersionUID = 8708641127342403073L;

    /* renamed from: a */
    public final Object f24966a;

    /* renamed from: b */
    public final long f24967b;

    public oz1(long j, rz1 rz1Var) {
        this.f24967b = j;
        this.f24966a = rz1Var;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, uz1] */
    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        Object obj = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (obj != disposableHelper) {
            lazySet(disposableHelper);
            this.f24966a.mo6936a(this.f24967b);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [rz1, java.lang.Object] */
    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        Object obj = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (obj != disposableHelper) {
            lazySet(disposableHelper);
            this.f24966a.mo6937b(this.f24967b, th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, uz1] */
    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        Disposable disposable = (Disposable) get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            disposable.dispose();
            lazySet(disposableHelper);
            this.f24966a.mo6936a(this.f24967b);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
