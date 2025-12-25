package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;
import p000.oq0;

/* loaded from: classes2.dex */
public final class FlowableFirstStageSubscriber<T> extends oq0 {

    /* renamed from: c */
    public final boolean f18533c;

    /* renamed from: d */
    public final Object f18534d;

    public FlowableFirstStageSubscriber(boolean z, T t) {
        this.f18533c = z;
        this.f18534d = t;
    }

    @Override // p000.oq0
    public void afterSubscribe(Subscription subscription) {
        subscription.request(1L);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        boolean isDone;
        isDone = isDone();
        if (!isDone) {
            clear();
            if (this.f18533c) {
                complete(this.f18534d);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        complete(t);
    }
}
