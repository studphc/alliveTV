package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.aq0;
import p000.yp0;

/* loaded from: classes2.dex */
public final class FlowableSampleTimed<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final long f18997b;

    /* renamed from: c */
    public final TimeUnit f18998c;

    /* renamed from: d */
    public final Scheduler f18999d;

    /* renamed from: e */
    public final boolean f19000e;

    public FlowableSampleTimed(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(flowable);
        this.f18997b = j;
        this.f18998c = timeUnit;
        this.f18999d = scheduler;
        this.f19000e = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.f19000e) {
            this.source.subscribe((FlowableSubscriber<? super Object>) new yp0(serializedSubscriber, this.f18997b, this.f18998c, this.f18999d));
        } else {
            this.source.subscribe((FlowableSubscriber<? super Object>) new aq0(serializedSubscriber, this.f18997b, this.f18998c, this.f18999d));
        }
    }
}
