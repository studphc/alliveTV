package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.BiFunction;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.ho0;

/* loaded from: classes2.dex */
public final class FlowableOnBackpressureReduce<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final BiFunction f18948b;

    public FlowableOnBackpressureReduce(@NonNull Flowable<T> flowable, @NonNull BiFunction<T, T, T> biFunction) {
        super(flowable);
        this.f18948b = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(@NonNull Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new ho0(subscriber, this.f18948b));
    }
}
