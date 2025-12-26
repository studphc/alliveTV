package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: es */
/* loaded from: classes2.dex */
public final class C1169es extends AtomicReference implements CompletableObserver {
    private static final long serialVersionUID = -5454794857847146511L;

    /* renamed from: a */
    public final C1206fs f16958a;

    public C1169es(C1206fs c1206fs) {
        this.f16958a = c1206fs;
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        C1206fs c1206fs = this.f16958a;
        c1206fs.f17391k = false;
        c1206fs.m4829a();
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        C1206fs c1206fs = this.f16958a;
        if (c1206fs.f17385e.compareAndSet(false, true)) {
            c1206fs.f17389i.cancel();
            c1206fs.f17381a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this, disposable);
    }
}
