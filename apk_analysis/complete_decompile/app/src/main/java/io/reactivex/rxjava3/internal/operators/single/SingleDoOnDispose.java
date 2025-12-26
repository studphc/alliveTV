package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Action;
import p000.xi2;

/* loaded from: classes2.dex */
public final class SingleDoOnDispose<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource f19743a;

    /* renamed from: b */
    public final Action f19744b;

    public SingleDoOnDispose(SingleSource<T> singleSource, Action action) {
        this.f19743a = singleSource;
        this.f19744b = action;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19743a.subscribe(new xi2(singleObserver, this.f19744b));
    }
}
