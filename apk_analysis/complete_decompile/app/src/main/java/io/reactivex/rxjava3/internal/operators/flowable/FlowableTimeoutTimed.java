package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.or0;
import p000.pq0;
import p000.pr0;

/* loaded from: classes2.dex */
public final class FlowableTimeoutTimed<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final long f19057b;

    /* renamed from: c */
    public final TimeUnit f19058c;

    /* renamed from: d */
    public final Scheduler f19059d;

    /* renamed from: e */
    public final Publisher f19060e;

    public FlowableTimeoutTimed(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, Publisher<? extends T> publisher) {
        super(flowable);
        this.f19057b = j;
        this.f19058c = timeUnit;
        this.f19059d = scheduler;
        this.f19060e = publisher;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Publisher publisher = this.f19060e;
        Scheduler scheduler = this.f19059d;
        if (publisher == null) {
            pr0 pr0Var = new pr0(subscriber, this.f19057b, this.f19058c, scheduler.createWorker());
            subscriber.onSubscribe(pr0Var);
            pr0Var.f25269e.replace(pr0Var.f25268d.schedule(new pq0(0L, pr0Var), pr0Var.f25266b, pr0Var.f25267c));
            this.source.subscribe((FlowableSubscriber<? super Object>) pr0Var);
            return;
        }
        or0 or0Var = new or0(subscriber, this.f19057b, this.f19058c, scheduler.createWorker(), this.f19060e);
        subscriber.onSubscribe(or0Var);
        or0Var.f24875l.replace(or0Var.f24874k.schedule(new pq0(0L, or0Var), or0Var.f24872i, or0Var.f24873j));
        this.source.subscribe((FlowableSubscriber<? super Object>) or0Var);
    }
}
