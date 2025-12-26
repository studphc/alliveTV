package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.hq0;

/* loaded from: classes2.dex */
public final class FlowableSingle<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Object f19012b;

    /* renamed from: c */
    public final boolean f19013c;

    public FlowableSingle(Flowable<T> flowable, T t, boolean z) {
        super(flowable);
        this.f19012b = t;
        this.f19013c = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new hq0(subscriber, this.f19012b, this.f19013c));
    }
}
