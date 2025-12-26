package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.ir0;

/* loaded from: classes2.dex */
public final class FlowableTimeInterval<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Scheduler f19052b;

    /* renamed from: c */
    public final TimeUnit f19053c;

    public FlowableTimeInterval(Flowable<T> flowable, TimeUnit timeUnit, Scheduler scheduler) {
        super(flowable);
        this.f19052b = scheduler;
        this.f19053c = timeUnit;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Timed<T>> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new ir0(subscriber, this.f19053c, this.f19052b));
    }
}
