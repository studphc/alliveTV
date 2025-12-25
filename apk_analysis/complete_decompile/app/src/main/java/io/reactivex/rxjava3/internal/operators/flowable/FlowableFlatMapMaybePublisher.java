package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.bm0;

/* loaded from: classes2.dex */
public final class FlowableFlatMapMaybePublisher<T, R> extends Flowable<R> {

    /* renamed from: b */
    public final Publisher f18853b;

    /* renamed from: c */
    public final Function f18854c;

    /* renamed from: d */
    public final boolean f18855d;

    /* renamed from: e */
    public final int f18856e;

    public FlowableFlatMapMaybePublisher(Publisher<T> publisher, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i) {
        this.f18853b = publisher;
        this.f18854c = function;
        this.f18855d = z;
        this.f18856e = i;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f18853b.subscribe(new bm0(this.f18856e, this.f18854c, subscriber, this.f18855d));
    }
}
