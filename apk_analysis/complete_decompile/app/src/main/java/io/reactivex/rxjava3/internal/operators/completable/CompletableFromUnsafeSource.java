package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;

/* loaded from: classes2.dex */
public final class CompletableFromUnsafeSource extends Completable {

    /* renamed from: a */
    public final CompletableSource f18676a;

    public CompletableFromUnsafeSource(CompletableSource completableSource) {
        this.f18676a = completableSource;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f18676a.subscribe(completableObserver);
    }
}
