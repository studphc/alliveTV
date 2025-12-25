package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Scheduler;
import p000.RunnableC2031ys;

/* loaded from: classes2.dex */
public final class CompletableObserveOn extends Completable {

    /* renamed from: a */
    public final CompletableSource f18688a;

    /* renamed from: b */
    public final Scheduler f18689b;

    public CompletableObserveOn(CompletableSource completableSource, Scheduler scheduler) {
        this.f18688a = completableSource;
        this.f18689b = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f18688a.subscribe(new RunnableC2031ys(completableObserver, this.f18689b));
    }
}
