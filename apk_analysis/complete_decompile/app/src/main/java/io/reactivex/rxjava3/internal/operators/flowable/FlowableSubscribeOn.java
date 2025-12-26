package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.qq0;

/* loaded from: classes2.dex */
public final class FlowableSubscribeOn<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Scheduler f19026b;

    /* renamed from: c */
    public final boolean f19027c;

    public FlowableSubscribeOn(Flowable<T> flowable, Scheduler scheduler, boolean z) {
        super(flowable);
        this.f19026b = scheduler;
        this.f19027c = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.f19026b.createWorker();
        qq0 qq0Var = new qq0(subscriber, createWorker, this.source, this.f19027c);
        subscriber.onSubscribe(qq0Var);
        createWorker.schedule(qq0Var);
    }
}
