package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import p000.vj2;

/* loaded from: classes2.dex */
public final class SingleSubscribeOn<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource f19799a;

    /* renamed from: b */
    public final Scheduler f19800b;

    public SingleSubscribeOn(SingleSource<? extends T> singleSource, Scheduler scheduler) {
        this.f19799a = singleSource;
        this.f19800b = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        vj2 vj2Var = new vj2(singleObserver, this.f19799a);
        singleObserver.onSubscribe(vj2Var);
        vj2Var.f27820b.replace(this.f19800b.scheduleDirect(vj2Var));
    }
}
