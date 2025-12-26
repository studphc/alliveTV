package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import p000.C1522ls;

/* loaded from: classes2.dex */
public final class CompletableHide extends Completable {

    /* renamed from: a */
    public final CompletableSource f18677a;

    public CompletableHide(CompletableSource completableSource) {
        this.f18677a = completableSource;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f18677a.subscribe(new C1522ls(1, completableObserver));
    }
}
