package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import p000.ri1;

/* loaded from: classes2.dex */
public final class MaybeFlatMapIterableObservable<T, R> extends Observable<R> {

    /* renamed from: a */
    public final MaybeSource f19162a;

    /* renamed from: b */
    public final Function f19163b;

    public MaybeFlatMapIterableObservable(MaybeSource<T> maybeSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.f19162a = maybeSource;
        this.f19163b = function;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        this.f19162a.subscribe(new ri1(observer, this.f19163b));
    }
}
