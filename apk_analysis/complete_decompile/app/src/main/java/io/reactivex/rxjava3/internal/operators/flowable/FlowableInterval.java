package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import p000.kn0;

/* loaded from: classes2.dex */
public final class FlowableInterval extends Flowable<Long> {

    /* renamed from: b */
    public final Scheduler f18909b;

    /* renamed from: c */
    public final long f18910c;

    /* renamed from: d */
    public final long f18911d;

    /* renamed from: e */
    public final TimeUnit f18912e;

    public FlowableInterval(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.f18910c = j;
        this.f18911d = j2;
        this.f18912e = timeUnit;
        this.f18909b = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        kn0 kn0Var = new kn0(subscriber);
        subscriber.onSubscribe(kn0Var);
        Scheduler scheduler = this.f18909b;
        boolean z = scheduler instanceof TrampolineScheduler;
        AtomicReference atomicReference = kn0Var.f20913c;
        if (z) {
            Scheduler.Worker createWorker = scheduler.createWorker();
            DisposableHelper.setOnce(atomicReference, createWorker);
            createWorker.schedulePeriodically(kn0Var, this.f18910c, this.f18911d, this.f18912e);
            return;
        }
        DisposableHelper.setOnce(atomicReference, scheduler.schedulePeriodicallyDirect(kn0Var, this.f18910c, this.f18911d, this.f18912e));
    }
}
