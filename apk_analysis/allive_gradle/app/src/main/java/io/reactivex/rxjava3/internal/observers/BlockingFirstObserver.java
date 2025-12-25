package io.reactivex.rxjava3.internal.observers;

/* loaded from: classes2.dex */
public final class BlockingFirstObserver<T> extends BlockingBaseObserver<T> {
    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable th) {
        if (this.f18589a == null) {
            this.f18590b = th;
        }
        countDown();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        if (this.f18589a == null) {
            this.f18589a = t;
            this.f18591c.dispose();
            countDown();
        }
    }
}
