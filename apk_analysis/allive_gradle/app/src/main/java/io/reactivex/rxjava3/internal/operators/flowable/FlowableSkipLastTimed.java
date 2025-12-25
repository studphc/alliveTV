package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.kq0;

/* loaded from: classes2.dex */
public final class FlowableSkipLastTimed<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final long f19019b;

    /* renamed from: c */
    public final TimeUnit f19020c;

    /* renamed from: d */
    public final Scheduler f19021d;

    /* renamed from: e */
    public final int f19022e;

    /* renamed from: f */
    public final boolean f19023f;

    public FlowableSkipLastTimed(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        super(flowable);
        this.f19019b = j;
        this.f19020c = timeUnit;
        this.f19021d = scheduler;
        this.f19022e = i;
        this.f19023f = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new kq0(subscriber, this.f19019b, this.f19020c, this.f19021d, this.f19022e, this.f19023f));
    }
}
