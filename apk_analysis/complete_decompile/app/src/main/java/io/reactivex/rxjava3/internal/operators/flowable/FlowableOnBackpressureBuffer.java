package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Action;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.bo0;

/* loaded from: classes2.dex */
public final class FlowableOnBackpressureBuffer<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final int f18940b;

    /* renamed from: c */
    public final boolean f18941c;

    /* renamed from: d */
    public final boolean f18942d;

    /* renamed from: e */
    public final Action f18943e;

    public FlowableOnBackpressureBuffer(Flowable<T> flowable, int i, boolean z, boolean z2, Action action) {
        super(flowable);
        this.f18940b = i;
        this.f18941c = z;
        this.f18942d = z2;
        this.f18943e = action;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new bo0(subscriber, this.f18940b, this.f18941c, this.f18942d, this.f18943e));
    }
}
