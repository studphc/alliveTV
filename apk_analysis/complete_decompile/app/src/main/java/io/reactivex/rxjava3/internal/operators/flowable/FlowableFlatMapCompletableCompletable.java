package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import p000.zl0;

/* loaded from: classes2.dex */
public final class FlowableFlatMapCompletableCompletable<T> extends Completable implements FuseToFlowable<T> {

    /* renamed from: a */
    public final Flowable f18846a;

    /* renamed from: b */
    public final Function f18847b;

    /* renamed from: c */
    public final int f18848c;

    /* renamed from: d */
    public final boolean f18849d;

    public FlowableFlatMapCompletableCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, boolean z, int i) {
        this.f18846a = flowable;
        this.f18847b = function;
        this.f18849d = z;
        this.f18848c = i;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToFlowable
    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableFlatMapCompletable(this.f18846a, this.f18847b, this.f18849d, this.f18848c));
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f18846a.subscribe((FlowableSubscriber) new zl0(completableObserver, this.f18847b, this.f18849d, this.f18848c));
    }
}
