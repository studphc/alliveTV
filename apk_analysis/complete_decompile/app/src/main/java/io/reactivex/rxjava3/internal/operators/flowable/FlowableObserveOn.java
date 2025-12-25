package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.ao0;
import p000.zn0;

/* loaded from: classes2.dex */
public final class FlowableObserveOn<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Scheduler f18937b;

    /* renamed from: c */
    public final boolean f18938c;

    /* renamed from: d */
    public final int f18939d;

    public FlowableObserveOn(Flowable<T> flowable, Scheduler scheduler, boolean z, int i) {
        super(flowable);
        this.f18937b = scheduler;
        this.f18938c = z;
        this.f18939d = i;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.f18937b.createWorker();
        boolean z = subscriber instanceof ConditionalSubscriber;
        int i = this.f18939d;
        boolean z2 = this.f18938c;
        if (z) {
            this.source.subscribe((FlowableSubscriber<? super Object>) new zn0((ConditionalSubscriber) subscriber, createWorker, z2, i));
        } else {
            this.source.subscribe((FlowableSubscriber<? super Object>) new ao0(subscriber, createWorker, z2, i));
        }
    }
}
