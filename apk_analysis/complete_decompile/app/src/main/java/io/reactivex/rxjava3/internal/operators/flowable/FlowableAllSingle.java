package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import p000.pi0;

/* loaded from: classes2.dex */
public final class FlowableAllSingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {

    /* renamed from: a */
    public final Flowable f18731a;

    /* renamed from: b */
    public final Predicate f18732b;

    public FlowableAllSingle(Flowable<T> flowable, Predicate<? super T> predicate) {
        this.f18731a = flowable;
        this.f18732b = predicate;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToFlowable
    public Flowable<Boolean> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableAll(this.f18731a, this.f18732b));
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f18731a.subscribe((FlowableSubscriber) new pi0(singleObserver, this.f18732b, 0));
    }
}
