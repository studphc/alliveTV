package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.internal.operators.mixed.MaterializeSingleObserver;

/* loaded from: classes2.dex */
public final class CompletableMaterialize<T> extends Single<Notification<T>> {

    /* renamed from: a */
    public final Completable f18680a;

    public CompletableMaterialize(Completable completable) {
        this.f18680a = completable;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.f18680a.subscribe(new MaterializeSingleObserver(singleObserver));
    }
}
