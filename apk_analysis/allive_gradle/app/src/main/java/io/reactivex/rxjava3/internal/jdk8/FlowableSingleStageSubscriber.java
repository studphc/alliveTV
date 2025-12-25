package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;
import p000.oq0;

/* loaded from: classes2.dex */
public final class FlowableSingleStageSubscriber<T> extends oq0 {

    /* renamed from: c */
    public final boolean f18545c;

    /* renamed from: d */
    public final Object f18546d;

    public FlowableSingleStageSubscriber(boolean z, T t) {
        this.f18545c = z;
        this.f18546d = t;
    }

    @Override // p000.oq0
    public void afterSubscribe(Subscription subscription) {
        subscription.request(2L);
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
            } else if (this.f18545c) {
                complete(this.f18546d);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.f24863b != null) {
            this.f24863b = null;
            completeExceptionally(new IllegalArgumentException("Sequence contains more than one element!"));
        } else {
            this.f24863b = t;
        }
    }
}
