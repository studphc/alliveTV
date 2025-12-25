package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import java.util.stream.Stream;
import p000.aj1;

/* loaded from: classes2.dex */
public final class SingleFlattenStreamAsObservable<T, R> extends Observable<R> {

    /* renamed from: a */
    public final Single f18582a;

    /* renamed from: b */
    public final Function f18583b;

    public SingleFlattenStreamAsObservable(Single<T> single, Function<? super T, ? extends Stream<? extends R>> function) {
        this.f18582a = single;
        this.f18583b = function;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(@NonNull Observer<? super R> observer) {
        this.f18582a.subscribe(new aj1(observer, this.f18583b));
    }
}
