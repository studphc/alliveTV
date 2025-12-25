package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Action;
import p000.mi1;

/* loaded from: classes2.dex */
public final class SingleDoAfterTerminate<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource f19739a;

    /* renamed from: b */
    public final Action f19740b;

    public SingleDoAfterTerminate(SingleSource<T> singleSource, Action action) {
        this.f19739a = singleSource;
        this.f19740b = action;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19739a.subscribe(new mi1(2, singleObserver, this.f19740b));
    }
}
