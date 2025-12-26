package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.gs0;
import p000.hs0;
import p000.is0;

/* loaded from: classes2.dex */
public final class FlowableWindowTimed<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final long f19080b;

    /* renamed from: c */
    public final long f19081c;

    /* renamed from: d */
    public final TimeUnit f19082d;

    /* renamed from: e */
    public final Scheduler f19083e;

    /* renamed from: f */
    public final long f19084f;

    /* renamed from: g */
    public final int f19085g;

    /* renamed from: h */
    public final boolean f19086h;

    public FlowableWindowTimed(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, long j3, int i, boolean z) {
        super(flowable);
        this.f19080b = j;
        this.f19081c = j2;
        this.f19082d = timeUnit;
        this.f19083e = scheduler;
        this.f19084f = j3;
        this.f19085g = i;
        this.f19086h = z;
    }

    /* renamed from: e */
    public static String m5280e(long j) {
        return "Unable to emit the next window (#" + j + ") due to lack of requests. Please make sure the downstream is ready to consume windows.";
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        if (this.f19080b == this.f19081c) {
            if (this.f19084f == Long.MAX_VALUE) {
                this.source.subscribe((FlowableSubscriber<? super Object>) new hs0(subscriber, this.f19080b, this.f19082d, this.f19083e, this.f19085g));
                return;
            }
            Flowable<Object> flowable = this.source;
            Scheduler scheduler = this.f19083e;
            flowable.subscribe((FlowableSubscriber<? super Object>) new gs0(this.f19085g, this.f19080b, this.f19084f, scheduler, this.f19082d, subscriber, this.f19086h));
            return;
        }
        Flowable<Object> flowable2 = this.source;
        Scheduler.Worker createWorker = this.f19083e.createWorker();
        flowable2.subscribe((FlowableSubscriber<? super Object>) new is0(subscriber, this.f19080b, this.f19081c, this.f19082d, createWorker, this.f19085g));
    }
}
