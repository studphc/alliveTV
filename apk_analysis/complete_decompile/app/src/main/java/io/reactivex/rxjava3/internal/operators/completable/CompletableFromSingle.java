package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.SingleSource;
import p000.C1772rs;

/* loaded from: classes2.dex */
public final class CompletableFromSingle<T> extends Completable {

    /* renamed from: a */
    public final SingleSource f18674a;

    public CompletableFromSingle(SingleSource<T> singleSource) {
        this.f18674a = singleSource;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f18674a.subscribe(new C1772rs(0, completableObserver));
    }
}
