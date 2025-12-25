package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.functions.Function;
import java.util.stream.Stream;
import org.reactivestreams.Subscriber;
import p000.zi1;

/* loaded from: classes2.dex */
public final class MaybeFlattenStreamAsFlowable<T, R> extends Flowable<R> {

    /* renamed from: b */
    public final Maybe f18547b;

    /* renamed from: c */
    public final Function f18548c;

    public MaybeFlattenStreamAsFlowable(Maybe<T> maybe, Function<? super T, ? extends Stream<? extends R>> function) {
        this.f18547b = maybe;
        this.f18548c = function;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(@NonNull Subscriber<? super R> subscriber) {
        this.f18547b.subscribe(new zi1(subscriber, this.f18548c));
    }
}
