package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import p000.C1243gs;

/* loaded from: classes2.dex */
public final class CompletableConcatArray extends Completable {

    /* renamed from: a */
    public final CompletableSource[] f18651a;

    public CompletableConcatArray(CompletableSource[] completableSourceArr) {
        this.f18651a = completableSourceArr;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        C1243gs c1243gs = new C1243gs(completableObserver, this.f18651a);
        completableObserver.onSubscribe(c1243gs.f17817d);
        c1243gs.m4984a();
    }
}
