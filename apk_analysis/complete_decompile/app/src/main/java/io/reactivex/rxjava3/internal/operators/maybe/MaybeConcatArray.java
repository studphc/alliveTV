package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeSource;
import org.reactivestreams.Subscriber;
import p000.uh1;

/* loaded from: classes2.dex */
public final class MaybeConcatArray<T> extends Flowable<T> {

    /* renamed from: b */
    public final MaybeSource[] f19124b;

    public MaybeConcatArray(MaybeSource<? extends T>[] maybeSourceArr) {
        this.f19124b = maybeSourceArr;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        uh1 uh1Var = new uh1(subscriber, this.f19124b);
        subscriber.onSubscribe(uh1Var);
        uh1Var.m7705a();
    }
}
