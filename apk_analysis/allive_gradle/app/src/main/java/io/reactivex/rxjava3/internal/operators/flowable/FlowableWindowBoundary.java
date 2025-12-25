package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.zr0;

/* loaded from: classes2.dex */
public final class FlowableWindowBoundary<T, B> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Publisher f19075b;

    /* renamed from: c */
    public final int f19076c;

    public FlowableWindowBoundary(Flowable<T> flowable, Publisher<B> publisher, int i) {
        super(flowable);
        this.f19075b = publisher;
        this.f19076c = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        zr0 zr0Var = new zr0(subscriber, this.f19076c);
        subscriber.onSubscribe(zr0Var);
        zr0Var.f29497f.offer(zr0.f29491m);
        zr0Var.m8426a();
        this.f19075b.subscribe(zr0Var.f29494c);
        this.source.subscribe((FlowableSubscriber<? super Object>) zr0Var);
    }
}
