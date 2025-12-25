package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Consumer;
import p000.C2067zr;

/* loaded from: classes2.dex */
public final class CompletableDoOnEvent extends Completable {

    /* renamed from: a */
    public final CompletableSource f18665a;

    /* renamed from: b */
    public final Consumer f18666b;

    public CompletableDoOnEvent(CompletableSource completableSource, Consumer<? super Throwable> consumer) {
        this.f18665a = completableSource;
        this.f18666b = consumer;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f18665a.subscribe(new C2067zr(this, completableObserver, 1));
    }
}
