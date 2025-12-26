package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import org.reactivestreams.Subscriber;
import p000.uo0;
import p000.vo0;

/* loaded from: classes2.dex */
public final class FlowableRangeLong extends Flowable<Long> {

    /* renamed from: b */
    public final long f18965b;

    /* renamed from: c */
    public final long f18966c;

    public FlowableRangeLong(long j, long j2) {
        this.f18965b = j;
        this.f18966c = j + j2;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe(new uo0((ConditionalSubscriber) subscriber, this.f18965b, this.f18966c));
        } else {
            subscriber.onSubscribe(new vo0(subscriber, this.f18965b, this.f18966c));
        }
    }
}
