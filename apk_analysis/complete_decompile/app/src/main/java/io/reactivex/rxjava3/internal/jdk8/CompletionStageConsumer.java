package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class CompletionStageConsumer<T> extends CompletableFuture<T> implements MaybeObserver<T>, SingleObserver<T>, CompletableObserver {

    /* renamed from: a */
    public final AtomicReference f18526a = new AtomicReference();

    /* renamed from: b */
    public final boolean f18527b;

    /* renamed from: c */
    public final Object f18528c;

    public CompletionStageConsumer(boolean z, T t) {
        this.f18527b = z;
        this.f18528c = t;
    }

    @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
    public boolean cancel(boolean z) {
        DisposableHelper.dispose(this.f18526a);
        return super.cancel(z);
    }

    @Override // java.util.concurrent.CompletableFuture
    public boolean complete(T t) {
        DisposableHelper.dispose(this.f18526a);
        return super.complete(t);
    }

    @Override // java.util.concurrent.CompletableFuture
    public boolean completeExceptionally(Throwable th) {
        DisposableHelper.dispose(this.f18526a);
        return super.completeExceptionally(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onComplete() {
        if (this.f18527b) {
            complete(this.f18528c);
        } else {
            completeExceptionally(new NoSuchElementException("The source was empty"));
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onError(Throwable th) {
        this.f18526a.lazySet(DisposableHelper.DISPOSED);
        if (!completeExceptionally(th)) {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onSubscribe(@NonNull Disposable disposable) {
        DisposableHelper.setOnce(this.f18526a, disposable);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onSuccess(@NonNull T t) {
        this.f18526a.lazySet(DisposableHelper.DISPOSED);
        complete(t);
    }
}
