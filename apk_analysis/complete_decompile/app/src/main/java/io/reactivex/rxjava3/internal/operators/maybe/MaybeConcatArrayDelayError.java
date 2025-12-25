package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeSource;
import org.reactivestreams.Subscriber;
import p000.vh1;

/* loaded from: classes2.dex */
public final class MaybeConcatArrayDelayError<T> extends Flowable<T> {

    /* renamed from: b */
    public final MaybeSource[] f19125b;

    public MaybeConcatArrayDelayError(MaybeSource<? extends T>[] maybeSourceArr) {
        this.f19125b = maybeSourceArr;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        vh1 vh1Var = new vh1(subscriber, this.f19125b);
        subscriber.onSubscribe(vh1Var);
        vh1Var.m7912a();
    }
}
