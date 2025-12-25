package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.tq0;

/* loaded from: classes2.dex */
public final class FlowableSwitchMap<T, R> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Function f19029b;

    /* renamed from: c */
    public final int f19030c;

    /* renamed from: d */
    public final boolean f19031d;

    public FlowableSwitchMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, boolean z) {
        super(flowable);
        this.f19029b = function;
        this.f19030c = i;
        this.f19031d = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        Flowable<Object> flowable = this.source;
        Function function = this.f19029b;
        if (FlowableScalarXMap.tryScalarXMapSubscribe(flowable, subscriber, function)) {
            return;
        }
        this.source.subscribe((FlowableSubscriber<? super Object>) new tq0(this.f19030c, function, subscriber, this.f19031d));
    }
}
