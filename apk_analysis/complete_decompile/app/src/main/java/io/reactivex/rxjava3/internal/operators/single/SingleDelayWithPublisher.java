package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import org.reactivestreams.Publisher;
import p000.si2;

/* loaded from: classes2.dex */
public final class SingleDelayWithPublisher<T, U> extends Single<T> {

    /* renamed from: a */
    public final SingleSource f19730a;

    /* renamed from: b */
    public final Publisher f19731b;

    public SingleDelayWithPublisher(SingleSource<T> singleSource, Publisher<U> publisher) {
        this.f19730a = singleSource;
        this.f19731b = publisher;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19731b.subscribe(new si2(singleObserver, this.f19730a));
    }
}
