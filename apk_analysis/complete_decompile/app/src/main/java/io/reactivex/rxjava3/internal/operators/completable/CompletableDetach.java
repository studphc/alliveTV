package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import p000.C1522ls;

/* loaded from: classes2.dex */
public final class CompletableDetach extends Completable {

    /* renamed from: a */
    public final CompletableSource f18660a;

    public CompletableDetach(CompletableSource completableSource) {
        this.f18660a = completableSource;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        C1522ls c1522ls = new C1522ls();
        c1522ls.f22652b = completableObserver;
        this.f18660a.subscribe(c1522ls);
    }
}
