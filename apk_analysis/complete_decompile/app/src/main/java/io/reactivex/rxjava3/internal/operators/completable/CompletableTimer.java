package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import p000.RunnableC1281ht;

/* loaded from: classes2.dex */
public final class CompletableTimer extends Completable {

    /* renamed from: a */
    public final long f18712a;

    /* renamed from: b */
    public final TimeUnit f18713b;

    /* renamed from: c */
    public final Scheduler f18714c;

    public CompletableTimer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f18712a = j;
        this.f18713b = timeUnit;
        this.f18714c = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        RunnableC1281ht runnableC1281ht = new RunnableC1281ht(completableObserver);
        completableObserver.onSubscribe(runnableC1281ht);
        DisposableHelper.replace(runnableC1281ht, this.f18714c.scheduleDirect(runnableC1281ht, this.f18712a, this.f18713b));
    }
}
