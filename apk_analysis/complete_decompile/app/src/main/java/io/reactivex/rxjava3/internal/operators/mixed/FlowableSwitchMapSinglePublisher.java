package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.zq0;

/* loaded from: classes2.dex */
public final class FlowableSwitchMapSinglePublisher<T, R> extends Flowable<R> {

    /* renamed from: b */
    public final Publisher f19284b;

    /* renamed from: c */
    public final Function f19285c;

    /* renamed from: d */
    public final boolean f19286d;

    public FlowableSwitchMapSinglePublisher(Publisher<T> publisher, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        this.f19284b = publisher;
        this.f19285c = function;
        this.f19286d = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f19284b.subscribe(new zq0(subscriber, this.f19285c, this.f19286d));
    }
}
