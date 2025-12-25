package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.hl0;
import p000.il0;

/* loaded from: classes2.dex */
public final class FlowableDistinctUntilChanged<T, K> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Function f18816b;

    /* renamed from: c */
    public final BiPredicate f18817c;

    public FlowableDistinctUntilChanged(Flowable<T> flowable, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(flowable);
        this.f18816b = function;
        this.f18817c = biPredicate;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        boolean z = subscriber instanceof ConditionalSubscriber;
        BiPredicate biPredicate = this.f18817c;
        Function function = this.f18816b;
        if (z) {
            this.source.subscribe((FlowableSubscriber<? super Object>) new hl0((ConditionalSubscriber) subscriber, function, biPredicate));
        } else {
            this.source.subscribe((FlowableSubscriber<? super Object>) new il0(subscriber, function, biPredicate));
        }
    }
}
