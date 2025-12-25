package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import p000.ij0;

/* loaded from: classes2.dex */
public final class FlowableSingleSingle<T> extends Single<T> implements FuseToFlowable<T> {

    /* renamed from: a */
    public final Flowable f19015a;

    /* renamed from: b */
    public final Object f19016b;

    public FlowableSingleSingle(Flowable<T> flowable, T t) {
        this.f19015a = flowable;
        this.f19016b = t;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToFlowable
    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableSingle(this.f19015a, this.f19016b, true));
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19015a.subscribe((FlowableSubscriber) new ij0(singleObserver, this.f19016b));
    }
}
