package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Subscriber;
import p000.fj2;

/* loaded from: classes2.dex */
public final class SingleFlatMapIterableFlowable<T, R> extends Flowable<R> {

    /* renamed from: b */
    public final SingleSource f19768b;

    /* renamed from: c */
    public final Function f19769c;

    public SingleFlatMapIterableFlowable(SingleSource<T> singleSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.f19768b = singleSource;
        this.f19769c = function;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f19768b.subscribe(new fj2(subscriber, this.f19769c));
    }
}
