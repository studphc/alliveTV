package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Predicate;
import p000.C2067zr;

/* loaded from: classes2.dex */
public final class CompletableOnErrorComplete extends Completable {

    /* renamed from: a */
    public final CompletableSource f18690a;

    /* renamed from: b */
    public final Predicate f18691b;

    public CompletableOnErrorComplete(CompletableSource completableSource, Predicate<? super Throwable> predicate) {
        this.f18690a = completableSource;
        this.f18691b = predicate;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f18690a.subscribe(new C2067zr(this, completableObserver, 2));
    }
}
