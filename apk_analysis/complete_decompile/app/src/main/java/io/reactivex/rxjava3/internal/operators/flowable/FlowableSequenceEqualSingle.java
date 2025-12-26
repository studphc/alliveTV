package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import p000.gq0;

/* loaded from: classes2.dex */
public final class FlowableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {

    /* renamed from: a */
    public final Publisher f19008a;

    /* renamed from: b */
    public final Publisher f19009b;

    /* renamed from: c */
    public final BiPredicate f19010c;

    /* renamed from: d */
    public final int f19011d;

    public FlowableSequenceEqualSingle(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate, int i) {
        this.f19008a = publisher;
        this.f19009b = publisher2;
        this.f19010c = biPredicate;
        this.f19011d = i;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToFlowable
    public Flowable<Boolean> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableSequenceEqual(this.f19008a, this.f19009b, this.f19010c, this.f19011d));
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        gq0 gq0Var = new gq0(singleObserver, this.f19011d, this.f19010c);
        singleObserver.onSubscribe(gq0Var);
        this.f19008a.subscribe(gq0Var.f17794c);
        this.f19009b.subscribe(gq0Var.f17795d);
    }
}
