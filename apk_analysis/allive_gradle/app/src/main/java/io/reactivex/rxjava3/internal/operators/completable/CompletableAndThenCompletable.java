package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import p000.C0531as;

/* loaded from: classes2.dex */
public final class CompletableAndThenCompletable extends Completable {

    /* renamed from: a */
    public final CompletableSource f18641a;

    /* renamed from: b */
    public final CompletableSource f18642b;

    public CompletableAndThenCompletable(CompletableSource completableSource, CompletableSource completableSource2) {
        this.f18641a = completableSource;
        this.f18642b = completableSource2;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f18641a.subscribe(new C0531as(completableObserver, this.f18642b));
    }
}
