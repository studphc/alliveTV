package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.dr0;

/* loaded from: classes2.dex */
public final class FlowableTakeLastTimed<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final long f19034b;

    /* renamed from: c */
    public final long f19035c;

    /* renamed from: d */
    public final TimeUnit f19036d;

    /* renamed from: e */
    public final Scheduler f19037e;

    /* renamed from: f */
    public final int f19038f;

    /* renamed from: g */
    public final boolean f19039g;

    public FlowableTakeLastTimed(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        super(flowable);
        this.f19034b = j;
        this.f19035c = j2;
        this.f19036d = timeUnit;
        this.f19037e = scheduler;
        this.f19038f = i;
        this.f19039g = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Flowable<Object> flowable = this.source;
        TimeUnit timeUnit = this.f19036d;
        Scheduler scheduler = this.f19037e;
        flowable.subscribe((FlowableSubscriber<? super Object>) new dr0(this.f19038f, this.f19034b, this.f19035c, scheduler, timeUnit, subscriber, this.f19039g));
    }
}
