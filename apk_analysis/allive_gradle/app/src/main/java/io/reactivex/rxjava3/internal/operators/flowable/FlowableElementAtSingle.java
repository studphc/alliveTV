package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import p000.sl0;

/* loaded from: classes2.dex */
public final class FlowableElementAtSingle<T> extends Single<T> implements FuseToFlowable<T> {

    /* renamed from: a */
    public final Flowable f18834a;

    /* renamed from: b */
    public final long f18835b;

    /* renamed from: c */
    public final Object f18836c;

    public FlowableElementAtSingle(Flowable<T> flowable, long j, T t) {
        this.f18834a = flowable;
        this.f18835b = j;
        this.f18836c = t;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToFlowable
    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableElementAt(this.f18834a, this.f18835b, this.f18836c, true));
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f18834a.subscribe((FlowableSubscriber) new sl0(singleObserver, this.f18835b, this.f18836c));
    }
}
