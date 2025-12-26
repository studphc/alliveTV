package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import p000.rr0;

/* loaded from: classes2.dex */
public final class FlowableTimer extends Flowable<Long> {

    /* renamed from: b */
    public final Scheduler f19061b;

    /* renamed from: c */
    public final long f19062c;

    /* renamed from: d */
    public final TimeUnit f19063d;

    public FlowableTimer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f19062c = j;
        this.f19063d = timeUnit;
        this.f19061b = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        rr0 rr0Var = new rr0(subscriber);
        subscriber.onSubscribe(rr0Var);
        DisposableHelper.trySet(rr0Var, this.f19061b.scheduleDirect(rr0Var, this.f19062c, this.f19063d));
    }
}
