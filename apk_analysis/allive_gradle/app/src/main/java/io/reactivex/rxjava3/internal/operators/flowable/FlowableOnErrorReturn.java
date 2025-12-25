package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.ko0;

/* loaded from: classes2.dex */
public final class FlowableOnErrorReturn<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Function f18956b;

    public FlowableOnErrorReturn(Flowable<T> flowable, Function<? super Throwable, ? extends T> function) {
        super(flowable);
        this.f18956b = function;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new ko0(subscriber, this.f18956b));
    }
}
