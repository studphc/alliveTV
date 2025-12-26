package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import java.util.stream.Stream;
import p000.aj1;

/* loaded from: classes2.dex */
public final class MaybeFlattenStreamAsObservable<T, R> extends Observable<R> {

    /* renamed from: a */
    public final Maybe f18549a;

    /* renamed from: b */
    public final Function f18550b;

    public MaybeFlattenStreamAsObservable(Maybe<T> maybe, Function<? super T, ? extends Stream<? extends R>> function) {
        this.f18549a = maybe;
        this.f18550b = function;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(@NonNull Observer<? super R> observer) {
        this.f18549a.subscribe(new aj1(observer, this.f18550b));
    }
}
