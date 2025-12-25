package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import org.reactivestreams.Subscriber;
import p000.ro0;
import p000.so0;

/* loaded from: classes2.dex */
public final class FlowableRange extends Flowable<Integer> {

    /* renamed from: b */
    public final int f18963b;

    /* renamed from: c */
    public final int f18964c;

    public FlowableRange(int i, int i2) {
        this.f18963b = i;
        this.f18964c = i + i2;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Integer> subscriber) {
        boolean z = subscriber instanceof ConditionalSubscriber;
        int i = this.f18964c;
        int i2 = this.f18963b;
        if (z) {
            subscriber.onSubscribe(new ro0((ConditionalSubscriber) subscriber, i2, i));
        } else {
            subscriber.onSubscribe(new so0(subscriber, i2, i));
        }
    }
}
