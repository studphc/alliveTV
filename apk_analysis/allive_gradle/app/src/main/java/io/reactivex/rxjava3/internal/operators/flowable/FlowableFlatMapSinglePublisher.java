package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.dm0;

/* loaded from: classes2.dex */
public final class FlowableFlatMapSinglePublisher<T, R> extends Flowable<R> {

    /* renamed from: b */
    public final Publisher f18860b;

    /* renamed from: c */
    public final Function f18861c;

    /* renamed from: d */
    public final boolean f18862d;

    /* renamed from: e */
    public final int f18863e;

    public FlowableFlatMapSinglePublisher(Publisher<T> publisher, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z, int i) {
        this.f18860b = publisher;
        this.f18861c = function;
        this.f18862d = z;
        this.f18863e = i;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f18860b.subscribe(new dm0(this.f18863e, this.f18861c, subscriber, this.f18862d));
    }
}
