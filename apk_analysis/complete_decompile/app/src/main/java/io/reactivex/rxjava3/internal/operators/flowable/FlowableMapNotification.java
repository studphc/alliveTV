package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.qn0;

/* loaded from: classes2.dex */
public final class FlowableMapNotification<T, R> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Function f18929b;

    /* renamed from: c */
    public final Function f18930c;

    /* renamed from: d */
    public final Supplier f18931d;

    public FlowableMapNotification(Flowable<T> flowable, Function<? super T, ? extends R> function, Function<? super Throwable, ? extends R> function2, Supplier<? extends R> supplier) {
        super(flowable);
        this.f18929b = function;
        this.f18930c = function2;
        this.f18931d = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new qn0(subscriber, this.f18929b, this.f18930c, this.f18931d));
    }
}
