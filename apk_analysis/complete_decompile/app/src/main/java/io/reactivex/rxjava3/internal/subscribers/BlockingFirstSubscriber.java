package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class BlockingFirstSubscriber<T> extends BlockingBaseSubscriber<T> {
    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f19890a == null) {
            this.f19891b = th;
        } else {
            RxJavaPlugins.onError(th);
        }
        countDown();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.f19890a == null) {
            this.f19890a = t;
            this.f19892c.cancel();
            countDown();
        }
    }
}
