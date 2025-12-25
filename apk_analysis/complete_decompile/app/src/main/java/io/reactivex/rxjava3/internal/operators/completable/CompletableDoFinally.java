package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Action;
import p000.C1596ns;

/* loaded from: classes2.dex */
public final class CompletableDoFinally extends Completable {

    /* renamed from: a */
    public final CompletableSource f18663a;

    /* renamed from: b */
    public final Action f18664b;

    public CompletableDoFinally(CompletableSource completableSource, Action action) {
        this.f18663a = completableSource;
        this.f18664b = action;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f18663a.subscribe(new C1596ns(completableObserver, this.f18664b));
    }
}
