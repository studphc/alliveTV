package io.reactivex.rxjava3.internal.observers;

/* loaded from: classes2.dex */
public final class BlockingLastObserver<T> extends BlockingBaseObserver<T> {
    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable th) {
        this.f18589a = null;
        this.f18590b = th;
        countDown();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        this.f18589a = t;
    }
}
