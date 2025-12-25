package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.internal.operators.mixed.MaterializeSingleObserver;

/* loaded from: classes2.dex */
public final class MaybeMaterialize<T> extends Single<Notification<T>> {

    /* renamed from: a */
    public final Maybe f19184a;

    public MaybeMaterialize(Maybe<T> maybe) {
        this.f19184a = maybe;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.f19184a.subscribe(new MaterializeSingleObserver(singleObserver));
    }
}
