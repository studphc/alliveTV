package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import p000.ij0;

/* loaded from: classes2.dex */
public final class FlowableReduceMaybe<T> extends Maybe<T> implements HasUpstreamPublisher<T>, FuseToFlowable<T> {

    /* renamed from: a */
    public final Flowable f18968a;

    /* renamed from: b */
    public final BiFunction f18969b;

    public FlowableReduceMaybe(Flowable<T> flowable, BiFunction<T, T, T> biFunction) {
        this.f18968a = flowable;
        this.f18969b = biFunction;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToFlowable
    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableReduce(this.f18968a, this.f18969b));
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher
    public Publisher<T> source() {
        return this.f18968a;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f18968a.subscribe((FlowableSubscriber) new ij0(maybeObserver, this.f18969b));
    }
}
