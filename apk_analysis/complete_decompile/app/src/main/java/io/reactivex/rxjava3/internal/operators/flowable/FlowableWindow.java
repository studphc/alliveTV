package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.vr0;
import p000.wr0;
import p000.xr0;

/* loaded from: classes2.dex */
public final class FlowableWindow<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final long f19072b;

    /* renamed from: c */
    public final long f19073c;

    /* renamed from: d */
    public final int f19074d;

    public FlowableWindow(Flowable<T> flowable, long j, long j2, int i) {
        super(flowable);
        this.f19072b = j;
        this.f19073c = j2;
        this.f19074d = i;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        long j = this.f19073c;
        long j2 = this.f19072b;
        if (j == j2) {
            this.source.subscribe((FlowableSubscriber<? super Object>) new vr0(subscriber, j2, this.f19074d));
            return;
        }
        if (j > j2) {
            this.source.subscribe((FlowableSubscriber<? super Object>) new xr0(subscriber, this.f19072b, this.f19073c, this.f19074d));
        } else {
            this.source.subscribe((FlowableSubscriber<? super Object>) new wr0(subscriber, this.f19072b, this.f19073c, this.f19074d));
        }
    }
}
