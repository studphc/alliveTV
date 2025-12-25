package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import org.reactivestreams.Publisher;
import p000.lj2;

/* loaded from: classes2.dex */
public final class SingleFromPublisher<T> extends Single<T> {

    /* renamed from: a */
    public final Publisher f19780a;

    public SingleFromPublisher(Publisher<? extends T> publisher) {
        this.f19780a = publisher;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19780a.subscribe(new lj2(singleObserver));
    }
}
