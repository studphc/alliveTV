package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import p000.g50;

/* loaded from: classes2.dex */
public final class SingleJust<T> extends Single<T> {

    /* renamed from: a */
    public final Object f19784a;

    public SingleJust(T t) {
        this.f19784a = t;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        singleObserver.onSubscribe(g50.m4919a());
        singleObserver.onSuccess((Object) this.f19784a);
    }
}
