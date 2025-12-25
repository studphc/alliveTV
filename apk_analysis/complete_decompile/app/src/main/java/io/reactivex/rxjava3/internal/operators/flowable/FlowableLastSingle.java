package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import org.reactivestreams.Publisher;
import p000.on0;

/* loaded from: classes2.dex */
public final class FlowableLastSingle<T> extends Single<T> {

    /* renamed from: a */
    public final Publisher f18925a;

    /* renamed from: b */
    public final Object f18926b;

    public FlowableLastSingle(Publisher<T> publisher, T t) {
        this.f18925a = publisher;
        this.f18926b = t;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f18925a.subscribe(new on0(singleObserver, this.f18926b));
    }
}
