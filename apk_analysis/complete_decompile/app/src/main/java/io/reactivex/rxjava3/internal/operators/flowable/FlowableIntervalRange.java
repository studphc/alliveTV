package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import p000.ln0;

/* loaded from: classes2.dex */
public final class FlowableIntervalRange extends Flowable<Long> {

    /* renamed from: b */
    public final Scheduler f18913b;

    /* renamed from: c */
    public final long f18914c;

    /* renamed from: d */
    public final long f18915d;

    /* renamed from: e */
    public final long f18916e;

    /* renamed from: f */
    public final long f18917f;

    /* renamed from: g */
    public final TimeUnit f18918g;

    public FlowableIntervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, Scheduler scheduler) {
        this.f18916e = j3;
        this.f18917f = j4;
        this.f18918g = timeUnit;
        this.f18913b = scheduler;
        this.f18914c = j;
        this.f18915d = j2;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        ln0 ln0Var = new ln0(subscriber, this.f18914c, this.f18915d);
        subscriber.onSubscribe(ln0Var);
        Scheduler scheduler = this.f18913b;
        boolean z = scheduler instanceof TrampolineScheduler;
        AtomicReference atomicReference = ln0Var.f22585d;
        if (z) {
            Scheduler.Worker createWorker = scheduler.createWorker();
            DisposableHelper.setOnce(atomicReference, createWorker);
            createWorker.schedulePeriodically(ln0Var, this.f18916e, this.f18917f, this.f18918g);
            return;
        }
        DisposableHelper.setOnce(atomicReference, scheduler.schedulePeriodicallyDirect(ln0Var, this.f18916e, this.f18917f, this.f18918g));
    }
}
