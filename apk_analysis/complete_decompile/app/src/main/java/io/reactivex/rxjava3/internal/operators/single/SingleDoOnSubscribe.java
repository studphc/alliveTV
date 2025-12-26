package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import p000.zi2;

/* loaded from: classes2.dex */
public final class SingleDoOnSubscribe<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource f19752a;

    /* renamed from: b */
    public final Consumer f19753b;

    public SingleDoOnSubscribe(SingleSource<T> singleSource, Consumer<? super Disposable> consumer) {
        this.f19752a = singleSource;
        this.f19753b = consumer;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19752a.subscribe(new zi2(singleObserver, this.f19753b));
    }
}
