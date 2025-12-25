package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.ql0;

/* loaded from: classes2.dex */
public final class FlowableElementAt<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final long f18827b;

    /* renamed from: c */
    public final Object f18828c;

    /* renamed from: d */
    public final boolean f18829d;

    public FlowableElementAt(Flowable<T> flowable, long j, T t, boolean z) {
        super(flowable);
        this.f18827b = j;
        this.f18828c = t;
        this.f18829d = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new ql0(subscriber, this.f18827b, this.f18828c, this.f18829d));
    }
}
