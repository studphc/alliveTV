package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.bj0;
import p000.cj0;
import p000.ej0;

/* loaded from: classes2.dex */
public final class FlowableBufferTimed<T, U extends Collection<? super T>> extends AbstractC1215g0 {

    /* renamed from: b */
    public final long f18750b;

    /* renamed from: c */
    public final long f18751c;

    /* renamed from: d */
    public final TimeUnit f18752d;

    /* renamed from: e */
    public final Scheduler f18753e;

    /* renamed from: f */
    public final Supplier f18754f;

    /* renamed from: g */
    public final int f18755g;

    /* renamed from: h */
    public final boolean f18756h;

    public FlowableBufferTimed(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, Supplier<U> supplier, int i, boolean z) {
        super(flowable);
        this.f18750b = j;
        this.f18751c = j2;
        this.f18752d = timeUnit;
        this.f18753e = scheduler;
        this.f18754f = supplier;
        this.f18755g = i;
        this.f18756h = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super U> subscriber) {
        long j = this.f18750b;
        long j2 = this.f18751c;
        if (j == j2 && this.f18755g == Integer.MAX_VALUE) {
            this.source.subscribe((FlowableSubscriber<? super Object>) new cj0(new SerializedSubscriber(subscriber), this.f18754f, this.f18750b, this.f18752d, this.f18753e));
            return;
        }
        Scheduler.Worker createWorker = this.f18753e.createWorker();
        if (j == j2) {
            this.source.subscribe((FlowableSubscriber<? super Object>) new bj0(new SerializedSubscriber(subscriber), this.f18754f, this.f18750b, this.f18752d, this.f18755g, this.f18756h, createWorker));
            return;
        }
        this.source.subscribe((FlowableSubscriber<? super Object>) new ej0(new SerializedSubscriber(subscriber), this.f18754f, this.f18750b, this.f18751c, this.f18752d, createWorker));
    }
}
