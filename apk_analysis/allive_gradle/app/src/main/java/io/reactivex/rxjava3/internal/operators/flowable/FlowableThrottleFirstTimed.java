package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.gr0;

/* loaded from: classes2.dex */
public final class FlowableThrottleFirstTimed<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final long f19045b;

    /* renamed from: c */
    public final TimeUnit f19046c;

    /* renamed from: d */
    public final Scheduler f19047d;

    public FlowableThrottleFirstTimed(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        super(flowable);
        this.f19045b = j;
        this.f19046c = timeUnit;
        this.f19047d = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new gr0(new SerializedSubscriber(subscriber), this.f19045b, this.f19046c, this.f19047d.createWorker()));
    }
}
