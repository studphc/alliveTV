package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import p000.pi0;

/* loaded from: classes2.dex */
public final class FlowableSingleMaybe<T> extends Maybe<T> implements FuseToFlowable<T> {

    /* renamed from: a */
    public final Flowable f19014a;

    public FlowableSingleMaybe(Flowable<T> flowable) {
        this.f19014a = flowable;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToFlowable
    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableSingle(this.f19014a, null, false));
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f19014a.subscribe((FlowableSubscriber) new pi0(maybeObserver));
    }
}
