package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Scheduler;
import p000.RunnableC1097ct;

/* loaded from: classes2.dex */
public final class CompletableSubscribeOn extends Completable {

    /* renamed from: a */
    public final CompletableSource f18703a;

    /* renamed from: b */
    public final Scheduler f18704b;

    public CompletableSubscribeOn(CompletableSource completableSource, Scheduler scheduler) {
        this.f18703a = completableSource;
        this.f18704b = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        RunnableC1097ct runnableC1097ct = new RunnableC1097ct(completableObserver, this.f18703a);
        completableObserver.onSubscribe(runnableC1097ct);
        runnableC1097ct.f16101b.replace(this.f18704b.scheduleDirect(runnableC1097ct));
    }
}
