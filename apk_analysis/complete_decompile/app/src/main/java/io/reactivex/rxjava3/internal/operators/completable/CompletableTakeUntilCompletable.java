package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import p000.C1170et;

/* loaded from: classes2.dex */
public final class CompletableTakeUntilCompletable extends Completable {

    /* renamed from: a */
    public final Completable f18705a;

    /* renamed from: b */
    public final CompletableSource f18706b;

    public CompletableTakeUntilCompletable(Completable completable, CompletableSource completableSource) {
        this.f18705a = completable;
        this.f18706b = completableSource;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        C1170et c1170et = new C1170et(completableObserver);
        completableObserver.onSubscribe(c1170et);
        this.f18706b.subscribe(c1170et.f16975b);
        this.f18705a.subscribe(c1170et);
    }
}
