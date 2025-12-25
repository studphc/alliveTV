package io.reactivex.rxjava3.internal.subscribers;

/* loaded from: classes2.dex */
public final class BlockingLastSubscriber<T> extends BlockingBaseSubscriber<T> {
    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.f19890a = null;
        this.f19891b = th;
        countDown();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        this.f19890a = t;
    }
}
