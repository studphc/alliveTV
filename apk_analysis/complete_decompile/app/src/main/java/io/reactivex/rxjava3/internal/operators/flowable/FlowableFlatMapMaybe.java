package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.bm0;

/* loaded from: classes2.dex */
public final class FlowableFlatMapMaybe<T, R> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Function f18850b;

    /* renamed from: c */
    public final boolean f18851c;

    /* renamed from: d */
    public final int f18852d;

    public FlowableFlatMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i) {
        super(flowable);
        this.f18850b = function;
        this.f18851c = z;
        this.f18852d = i;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new bm0(this.f18852d, this.f18850b, subscriber, this.f18851c));
    }
}
