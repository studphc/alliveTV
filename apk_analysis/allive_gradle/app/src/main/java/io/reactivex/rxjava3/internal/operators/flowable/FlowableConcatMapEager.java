package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.yj0;

/* loaded from: classes2.dex */
public final class FlowableConcatMapEager<T, R> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Function f18783b;

    /* renamed from: c */
    public final int f18784c;

    /* renamed from: d */
    public final int f18785d;

    /* renamed from: e */
    public final ErrorMode f18786e;

    public FlowableConcatMapEager(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, ErrorMode errorMode) {
        super(flowable);
        this.f18783b = function;
        this.f18784c = i;
        this.f18785d = i2;
        this.f18786e = errorMode;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new yj0(subscriber, this.f18783b, this.f18784c, this.f18785d, this.f18786e));
    }
}
