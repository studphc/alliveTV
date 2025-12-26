package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.oj0;

/* loaded from: classes2.dex */
public final class FlowableConcatArray<T> extends Flowable<T> {

    /* renamed from: b */
    public final Publisher[] f18778b;

    /* renamed from: c */
    public final boolean f18779c;

    public FlowableConcatArray(Publisher<? extends T>[] publisherArr, boolean z) {
        this.f18778b = publisherArr;
        this.f18779c = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        oj0 oj0Var = new oj0(this.f18778b, this.f18779c, subscriber);
        subscriber.onSubscribe(oj0Var);
        oj0Var.onComplete();
    }
}
