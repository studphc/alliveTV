package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import p000.yi2;

/* loaded from: classes2.dex */
public final class SingleDoOnLifecycle<T> extends Single<T> {

    /* renamed from: a */
    public final Single f19749a;

    /* renamed from: b */
    public final Consumer f19750b;

    /* renamed from: c */
    public final Action f19751c;

    public SingleDoOnLifecycle(Single<T> single, Consumer<? super Disposable> consumer, Action action) {
        this.f19749a = single;
        this.f19750b = consumer;
        this.f19751c = action;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19749a.subscribe(new yi2(singleObserver, this.f19750b, this.f19751c));
    }
}
