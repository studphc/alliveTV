package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import org.reactivestreams.Subscriber;
import p000.gm0;
import p000.hm0;

/* loaded from: classes2.dex */
public final class FlowableFromArray<T> extends Flowable<T> {

    /* renamed from: b */
    public final Object[] f18867b;

    public FlowableFromArray(T[] tArr) {
        this.f18867b = tArr;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        boolean z = subscriber instanceof ConditionalSubscriber;
        Object[] objArr = this.f18867b;
        if (z) {
            subscriber.onSubscribe(new gm0((ConditionalSubscriber) subscriber, objArr));
        } else {
            subscriber.onSubscribe(new hm0(subscriber, objArr));
        }
    }
}
