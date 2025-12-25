package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import p000.vi2;

/* loaded from: classes2.dex */
public final class SingleHide<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource f19783a;

    public SingleHide(SingleSource<? extends T> singleSource) {
        this.f19783a = singleSource;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19783a.subscribe(new vi2(singleObserver));
    }
}
