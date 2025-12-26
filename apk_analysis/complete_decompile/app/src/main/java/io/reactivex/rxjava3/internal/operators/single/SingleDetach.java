package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import p000.vi2;

/* loaded from: classes2.dex */
public final class SingleDetach<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource f19736a;

    public SingleDetach(SingleSource<T> singleSource) {
        this.f19736a = singleSource;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        vi2 vi2Var = new vi2();
        vi2Var.f27811b = singleObserver;
        this.f19736a.subscribe(vi2Var);
    }
}
