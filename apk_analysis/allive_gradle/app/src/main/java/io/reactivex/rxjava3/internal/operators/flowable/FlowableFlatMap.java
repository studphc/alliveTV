package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.vl0;

/* loaded from: classes2.dex */
public final class FlowableFlatMap<T, U> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Function f18839b;

    /* renamed from: c */
    public final boolean f18840c;

    /* renamed from: d */
    public final int f18841d;

    /* renamed from: e */
    public final int f18842e;

    public FlowableFlatMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
        super(flowable);
        this.f18839b = function;
        this.f18840c = z;
        this.f18841d = i;
        this.f18842e = i2;
    }

    public static <T, U> FlowableSubscriber<T> subscribe(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
        return new vl0(subscriber, function, z, i, i2);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super U> subscriber) {
        Flowable<Object> flowable = this.source;
        Function function = this.f18839b;
        if (FlowableScalarXMap.tryScalarXMapSubscribe(flowable, subscriber, function)) {
            return;
        }
        this.source.subscribe(subscribe(subscriber, function, this.f18840c, this.f18841d, this.f18842e));
    }
}
