package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Consumer;
import p000.xi1;

/* loaded from: classes2.dex */
public final class SingleDoOnSuccess<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource f19754a;

    /* renamed from: b */
    public final Consumer f19755b;

    public SingleDoOnSuccess(SingleSource<T> singleSource, Consumer<? super T> consumer) {
        this.f19754a = singleSource;
        this.f19755b = consumer;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19754a.subscribe(new xi1(this, singleObserver, 5));
    }
}
