package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.functions.BiFunction;
import org.reactivestreams.Publisher;
import p000.on0;

/* loaded from: classes2.dex */
public final class FlowableReduceSeedSingle<T, R> extends Single<R> {

    /* renamed from: a */
    public final Publisher f18970a;

    /* renamed from: b */
    public final Object f18971b;

    /* renamed from: c */
    public final BiFunction f18972c;

    public FlowableReduceSeedSingle(Publisher<T> publisher, R r, BiFunction<R, ? super T, R> biFunction) {
        this.f18970a = publisher;
        this.f18971b = r;
        this.f18972c = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f18970a.subscribe(new on0(singleObserver, this.f18972c, this.f18971b));
    }
}
