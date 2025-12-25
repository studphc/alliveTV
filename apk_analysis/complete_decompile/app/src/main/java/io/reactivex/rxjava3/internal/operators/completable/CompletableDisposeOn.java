package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Scheduler;
import p000.RunnableC1559ms;

/* loaded from: classes2.dex */
public final class CompletableDisposeOn extends Completable {

    /* renamed from: a */
    public final CompletableSource f18661a;

    /* renamed from: b */
    public final Scheduler f18662b;

    public CompletableDisposeOn(CompletableSource completableSource, Scheduler scheduler) {
        this.f18661a = completableSource;
        this.f18662b = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f18661a.subscribe(new RunnableC1559ms(completableObserver, this.f18662b));
    }
}
