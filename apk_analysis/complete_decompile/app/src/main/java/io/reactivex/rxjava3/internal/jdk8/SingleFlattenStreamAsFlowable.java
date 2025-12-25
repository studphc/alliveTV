package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import java.util.stream.Stream;
import org.reactivestreams.Subscriber;
import p000.zi1;

/* loaded from: classes2.dex */
public final class SingleFlattenStreamAsFlowable<T, R> extends Flowable<R> {

    /* renamed from: b */
    public final Single f18580b;

    /* renamed from: c */
    public final Function f18581c;

    public SingleFlattenStreamAsFlowable(Single<T> single, Function<? super T, ? extends Stream<? extends R>> function) {
        this.f18580b = single;
        this.f18581c = function;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(@NonNull Subscriber<? super R> subscriber) {
        this.f18580b.subscribe(new zi1(subscriber, this.f18581c));
    }
}
