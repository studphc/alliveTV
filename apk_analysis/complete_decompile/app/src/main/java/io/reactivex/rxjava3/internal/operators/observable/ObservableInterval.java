package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import p000.qw1;

/* loaded from: classes2.dex */
public final class ObservableInterval extends Observable<Long> {

    /* renamed from: a */
    public final Scheduler f19469a;

    /* renamed from: b */
    public final long f19470b;

    /* renamed from: c */
    public final long f19471c;

    /* renamed from: d */
    public final TimeUnit f19472d;

    public ObservableInterval(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.f19470b = j;
        this.f19471c = j2;
        this.f19472d = timeUnit;
        this.f19469a = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Long> observer) {
        qw1 qw1Var = new qw1(observer);
        observer.onSubscribe(qw1Var);
        Scheduler scheduler = this.f19469a;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker createWorker = scheduler.createWorker();
            DisposableHelper.setOnce(qw1Var, createWorker);
            createWorker.schedulePeriodically(qw1Var, this.f19470b, this.f19471c, this.f19472d);
            return;
        }
        DisposableHelper.setOnce(qw1Var, scheduler.schedulePeriodicallyDirect(qw1Var, this.f19470b, this.f19471c, this.f19472d));
    }
}
