package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.yk0;

/* loaded from: classes2.dex */
public final class FlowableDebounceTimed<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final long f18803b;

    /* renamed from: c */
    public final TimeUnit f18804c;

    /* renamed from: d */
    public final Scheduler f18805d;

    public FlowableDebounceTimed(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        super(flowable);
        this.f18803b = j;
        this.f18804c = timeUnit;
        this.f18805d = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new yk0(new SerializedSubscriber(subscriber), this.f18803b, this.f18804c, this.f18805d.createWorker()));
    }
}
