package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.kj2;

/* loaded from: classes2.dex */
public final class SingleFlatMapPublisher<T, R> extends Flowable<R> {

    /* renamed from: b */
    public final SingleSource f19777b;

    /* renamed from: c */
    public final Function f19778c;

    public SingleFlatMapPublisher(SingleSource<T> singleSource, Function<? super T, ? extends Publisher<? extends R>> function) {
        this.f19777b = singleSource;
        this.f19778c = function;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f19777b.subscribe(new kj2(subscriber, this.f19778c));
    }
}
