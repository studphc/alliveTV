package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import p000.rl0;

/* loaded from: classes2.dex */
public final class FlowableElementAtMaybe<T> extends Maybe<T> implements FuseToFlowable<T> {

    /* renamed from: a */
    public final Flowable f18830a;

    /* renamed from: b */
    public final long f18831b;

    public FlowableElementAtMaybe(Flowable<T> flowable, long j) {
        this.f18830a = flowable;
        this.f18831b = j;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToFlowable
    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableElementAt(this.f18830a, this.f18831b, null, false));
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f18830a.subscribe((FlowableSubscriber) new rl0(maybeObserver, this.f18831b));
    }
}
