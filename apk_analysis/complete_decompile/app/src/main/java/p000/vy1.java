package p000;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class vy1 extends CompletableFuture implements Observer {

    /* renamed from: a */
    public final AtomicReference f28011a = new AtomicReference();

    /* renamed from: b */
    public Object f28012b;

    @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        disposeUpstream();
        return super.cancel(z);
    }

    public final void clear() {
        this.f28012b = null;
        this.f28011a.lazySet(DisposableHelper.DISPOSED);
    }

    @Override // java.util.concurrent.CompletableFuture
    public final boolean complete(Object obj) {
        disposeUpstream();
        return super.complete(obj);
    }

    @Override // java.util.concurrent.CompletableFuture
    public final boolean completeExceptionally(Throwable th) {
        disposeUpstream();
        return super.completeExceptionally(th);
    }

    public final void disposeUpstream() {
        DisposableHelper.dispose(this.f28011a);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        clear();
        if (!completeExceptionally(th)) {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(@NonNull Disposable disposable) {
        DisposableHelper.setOnce(this.f28011a, disposable);
    }
}
