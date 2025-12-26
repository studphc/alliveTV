package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.functions.Supplier;
import p000.C2067zr;

/* loaded from: classes2.dex */
public final class CompletableToSingle<T> extends Single<T> {

    /* renamed from: a */
    public final CompletableSource f18717a;

    /* renamed from: b */
    public final Supplier f18718b;

    /* renamed from: c */
    public final Object f18719c;

    public CompletableToSingle(CompletableSource completableSource, Supplier<? extends T> supplier, T t) {
        this.f18717a = completableSource;
        this.f18719c = t;
        this.f18718b = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f18717a.subscribe(new C2067zr(this, singleObserver));
    }
}
