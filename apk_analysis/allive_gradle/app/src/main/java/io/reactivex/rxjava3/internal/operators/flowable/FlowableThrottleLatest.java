package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.hr0;

/* loaded from: classes2.dex */
public final class FlowableThrottleLatest<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final long f19048b;

    /* renamed from: c */
    public final TimeUnit f19049c;

    /* renamed from: d */
    public final Scheduler f19050d;

    /* renamed from: e */
    public final boolean f19051e;

    public FlowableThrottleLatest(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(flowable);
        this.f19048b = j;
        this.f19049c = timeUnit;
        this.f19050d = scheduler;
        this.f19051e = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new hr0(subscriber, this.f19048b, this.f19049c, this.f19050d.createWorker(), this.f19051e));
    }
}
