package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import org.reactivestreams.Publisher;
import p000.wj2;

/* loaded from: classes2.dex */
public final class SingleTakeUntil<T, U> extends Single<T> {

    /* renamed from: a */
    public final SingleSource f19801a;

    /* renamed from: b */
    public final Publisher f19802b;

    public SingleTakeUntil(SingleSource<T> singleSource, Publisher<U> publisher) {
        this.f19801a = singleSource;
        this.f19802b = publisher;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        wj2 wj2Var = new wj2(singleObserver);
        singleObserver.onSubscribe(wj2Var);
        this.f19802b.subscribe(wj2Var.f28205b);
        this.f19801a.subscribe(wj2Var);
    }
}
