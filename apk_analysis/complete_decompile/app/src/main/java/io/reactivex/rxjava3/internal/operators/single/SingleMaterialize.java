package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.internal.operators.mixed.MaterializeSingleObserver;

/* loaded from: classes2.dex */
public final class SingleMaterialize<T> extends Single<Notification<T>> {

    /* renamed from: a */
    public final Single f19789a;

    public SingleMaterialize(Single<T> single) {
        this.f19789a = single;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.f19789a.subscribe(new MaterializeSingleObserver(singleObserver));
    }
}
