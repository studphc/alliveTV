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
public final class FlowableAnySingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {

    /* renamed from: a */
    public final Flowable f18736a;

    /* renamed from: b */
    public final Predicate f18737b;

    public FlowableAnySingle(Flowable<T> flowable, Predicate<? super T> predicate) {
        this.f18736a = flowable;
        this.f18737b = predicate;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToFlowable
    public Flowable<Boolean> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableAny(this.f18736a, this.f18737b));
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f18736a.subscribe((FlowableSubscriber) new pi0(singleObserver, this.f18737b, 1));
    }
}
