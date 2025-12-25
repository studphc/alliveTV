package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;
import p000.oq0;

/* loaded from: classes2.dex */
public final class FlowableLastStageSubscriber<T> extends oq0 {

    /* renamed from: c */
    public final boolean f18541c;

    /* renamed from: d */
    public final Object f18542d;

    public FlowableLastStageSubscriber(boolean z, T t) {
        this.f18541c = z;
        this.f18542d = t;
    }

    @Override // p000.oq0
    public void afterSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        boolean isDone;
        isDone = isDone();
        if (!isDone) {
            Object obj = this.f24863b;
            clear();
            if (obj != null) {
                complete(obj);
            } else if (this.f18541c) {
                complete(this.f18542d);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        this.f24863b = t;
    }
}
