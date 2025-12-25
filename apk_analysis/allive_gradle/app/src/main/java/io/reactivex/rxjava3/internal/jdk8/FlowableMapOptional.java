package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import java.util.Optional;
import org.reactivestreams.Subscriber;
import p000.pn0;
import p000.tl0;

/* loaded from: classes2.dex */
public final class FlowableMapOptional<T, R> extends Flowable<R> {

    /* renamed from: b */
    public final Flowable f18543b;

    /* renamed from: c */
    public final Function f18544c;

    public FlowableMapOptional(Flowable<T> flowable, Function<? super T, Optional<? extends R>> function) {
        this.f18543b = flowable;
        this.f18544c = function;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        boolean z = subscriber instanceof ConditionalSubscriber;
        Function function = this.f18544c;
        Flowable flowable = this.f18543b;
        if (z) {
            flowable.subscribe((FlowableSubscriber) new pn0((ConditionalSubscriber) subscriber, function, 1));
        } else {
            flowable.subscribe((FlowableSubscriber) new tl0(subscriber, function, 1));
        }
    }
}
