package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import p000.rw1;

/* loaded from: classes2.dex */
public final class ObservableIntervalRange extends Observable<Long> {

    /* renamed from: a */
    public final Scheduler f19473a;

    /* renamed from: b */
    public final long f19474b;

    /* renamed from: c */
    public final long f19475c;

    /* renamed from: d */
    public final long f19476d;

    /* renamed from: e */
    public final long f19477e;

    /* renamed from: f */
    public final TimeUnit f19478f;

    public ObservableIntervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, Scheduler scheduler) {
        this.f19476d = j3;
        this.f19477e = j4;
        this.f19478f = timeUnit;
        this.f19473a = scheduler;
        this.f19474b = j;
        this.f19475c = j2;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Long> observer) {
        rw1 rw1Var = new rw1(observer, this.f19474b, this.f19475c);
        observer.onSubscribe(rw1Var);
        Scheduler scheduler = this.f19473a;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker createWorker = scheduler.createWorker();
            DisposableHelper.setOnce(rw1Var, createWorker);
            createWorker.schedulePeriodically(rw1Var, this.f19476d, this.f19477e, this.f19478f);
            return;
        }
        DisposableHelper.setOnce(rw1Var, scheduler.schedulePeriodicallyDirect(rw1Var, this.f19476d, this.f19477e, this.f19478f));
    }
}
