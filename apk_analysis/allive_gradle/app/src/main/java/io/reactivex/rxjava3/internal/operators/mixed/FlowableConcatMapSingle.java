package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import org.reactivestreams.Subscriber;
import p000.gk0;

/* loaded from: classes2.dex */
public final class FlowableConcatMapSingle<T, R> extends Flowable<R> {

    /* renamed from: b */
    public final Flowable f19261b;

    /* renamed from: c */
    public final Function f19262c;

    /* renamed from: d */
    public final ErrorMode f19263d;

    /* renamed from: e */
    public final int f19264e;

    public FlowableConcatMapSingle(Flowable<T> flowable, Function<? super T, ? extends SingleSource<? extends R>> function, ErrorMode errorMode, int i) {
        this.f19261b = flowable;
        this.f19262c = function;
        this.f19263d = errorMode;
        this.f19264e = i;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f19261b.subscribe((FlowableSubscriber) new gk0(subscriber, this.f19262c, this.f19264e, this.f19263d));
    }
}
