package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.dm0;

/* loaded from: classes2.dex */
public final class FlowableFlatMapSingle<T, R> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Function f18857b;

    /* renamed from: c */
    public final boolean f18858c;

    /* renamed from: d */
    public final int f18859d;

    public FlowableFlatMapSingle(Flowable<T> flowable, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z, int i) {
        super(flowable);
        this.f18857b = function;
        this.f18858c = z;
        this.f18859d = i;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new dm0(this.f18859d, this.f18857b, subscriber, this.f18858c));
    }
}
