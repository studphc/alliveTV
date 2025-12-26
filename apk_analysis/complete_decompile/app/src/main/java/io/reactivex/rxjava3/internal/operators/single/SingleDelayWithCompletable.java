package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import p000.qi2;

/* loaded from: classes2.dex */
public final class SingleDelayWithCompletable<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource f19726a;

    /* renamed from: b */
    public final CompletableSource f19727b;

    public SingleDelayWithCompletable(SingleSource<T> singleSource, CompletableSource completableSource) {
        this.f19726a = singleSource;
        this.f19727b = completableSource;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19727b.subscribe(new qi2(singleObserver, this.f19726a));
    }
}
