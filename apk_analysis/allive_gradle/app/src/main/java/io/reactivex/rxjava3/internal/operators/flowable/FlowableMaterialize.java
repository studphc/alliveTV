package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;

/* loaded from: classes2.dex */
public final class FlowableMaterialize<T> extends AbstractC1215g0 {
    public FlowableMaterialize(Flowable<T> flowable) {
        super(flowable);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Notification<T>> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new SinglePostCompleteSubscriber(subscriber));
    }
}
