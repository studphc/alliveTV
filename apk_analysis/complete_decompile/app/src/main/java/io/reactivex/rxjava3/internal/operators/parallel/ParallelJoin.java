package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;
import p000.n22;

/* loaded from: classes2.dex */
public final class ParallelJoin<T> extends Flowable<T> {

    /* renamed from: b */
    public final ParallelFlowable f19680b;

    /* renamed from: c */
    public final int f19681c;

    /* renamed from: d */
    public final boolean f19682d;

    public ParallelJoin(ParallelFlowable<? extends T> parallelFlowable, int i, boolean z) {
        this.f19680b = parallelFlowable;
        this.f19681c = i;
        this.f19682d = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        n22 n22Var;
        boolean z = this.f19682d;
        int i = this.f19681c;
        ParallelFlowable parallelFlowable = this.f19680b;
        if (z) {
            n22Var = new n22(subscriber, parallelFlowable.parallelism(), i);
        } else {
            n22Var = new n22(subscriber, parallelFlowable.parallelism(), i);
        }
        subscriber.onSubscribe(n22Var);
        parallelFlowable.subscribe(n22Var.f23202b);
    }
}
