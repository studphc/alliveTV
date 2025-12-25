package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import p000.lk0;

/* loaded from: classes2.dex */
public final class FlowableCountSingle<T> extends Single<Long> implements FuseToFlowable<Long> {

    /* renamed from: a */
    public final Flowable f18799a;

    public FlowableCountSingle(Flowable<T> flowable) {
        this.f18799a = flowable;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToFlowable
    public Flowable<Long> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableCount(this.f18799a));
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super Long> singleObserver) {
        this.f18799a.subscribe((FlowableSubscriber) new lk0(singleObserver));
    }
}
