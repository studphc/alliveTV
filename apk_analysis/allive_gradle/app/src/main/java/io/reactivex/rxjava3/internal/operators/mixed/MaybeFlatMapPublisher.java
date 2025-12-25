package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.vi1;

/* loaded from: classes2.dex */
public final class MaybeFlatMapPublisher<T, R> extends Flowable<R> {

    /* renamed from: b */
    public final MaybeSource f19291b;

    /* renamed from: c */
    public final Function f19292c;

    public MaybeFlatMapPublisher(MaybeSource<T> maybeSource, Function<? super T, ? extends Publisher<? extends R>> function) {
        this.f19291b = maybeSource;
        this.f19292c = function;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f19291b.subscribe(new vi1(subscriber, this.f19292c));
    }
}
