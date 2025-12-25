package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Action;
import p000.wi2;

/* loaded from: classes2.dex */
public final class SingleDoFinally<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource f19741a;

    /* renamed from: b */
    public final Action f19742b;

    public SingleDoFinally(SingleSource<T> singleSource, Action action) {
        this.f19741a = singleSource;
        this.f19742b = action;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19741a.subscribe(new wi2(singleObserver, this.f19742b));
    }
}
