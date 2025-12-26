package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Subscriber;
import p000.qi1;

/* loaded from: classes2.dex */
public final class MaybeFlatMapIterableFlowable<T, R> extends Flowable<R> {

    /* renamed from: b */
    public final MaybeSource f19160b;

    /* renamed from: c */
    public final Function f19161c;

    public MaybeFlatMapIterableFlowable(MaybeSource<T> maybeSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.f19160b = maybeSource;
        this.f19161c = function;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f19160b.subscribe(new qi1(subscriber, this.f19161c));
    }
}
