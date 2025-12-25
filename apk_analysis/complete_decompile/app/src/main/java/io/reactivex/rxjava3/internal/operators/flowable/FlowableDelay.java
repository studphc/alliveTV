package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.bl0;

/* loaded from: classes2.dex */
public final class FlowableDelay<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final long f18807b;

    /* renamed from: c */
    public final TimeUnit f18808c;

    /* renamed from: d */
    public final Scheduler f18809d;

    /* renamed from: e */
    public final boolean f18810e;

    public FlowableDelay(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(flowable);
        this.f18807b = j;
        this.f18808c = timeUnit;
        this.f18809d = scheduler;
        this.f18810e = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Subscriber<? super T> serializedSubscriber;
        if (this.f18810e) {
            serializedSubscriber = subscriber;
        } else {
            serializedSubscriber = new SerializedSubscriber(subscriber);
        }
        Scheduler.Worker createWorker = this.f18809d.createWorker();
        this.source.subscribe((FlowableSubscriber<? super Object>) new bl0(serializedSubscriber, this.f18807b, this.f18808c, createWorker, this.f18810e));
    }
}
