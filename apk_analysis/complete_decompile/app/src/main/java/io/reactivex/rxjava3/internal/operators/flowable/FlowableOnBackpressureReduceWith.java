package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Supplier;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.io0;

/* loaded from: classes2.dex */
public final class FlowableOnBackpressureReduceWith<T, R> extends AbstractC1215g0 {

    /* renamed from: b */
    public final BiFunction f18949b;

    /* renamed from: c */
    public final Supplier f18950c;

    public FlowableOnBackpressureReduceWith(@NonNull Flowable<T> flowable, @NonNull Supplier<R> supplier, @NonNull BiFunction<R, ? super T, R> biFunction) {
        super(flowable);
        this.f18949b = biFunction;
        this.f18950c = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(@NonNull Subscriber<? super R> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new io0(subscriber, this.f18950c, this.f18949b));
    }
}
