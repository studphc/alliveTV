package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableAutoConnect<T> extends Flowable<T> {

    /* renamed from: b */
    public final ConnectableFlowable f18738b;

    /* renamed from: c */
    public final int f18739c;

    /* renamed from: d */
    public final Consumer f18740d;

    /* renamed from: e */
    public final AtomicInteger f18741e = new AtomicInteger();

    public FlowableAutoConnect(ConnectableFlowable<? extends T> connectableFlowable, int i, Consumer<? super Disposable> consumer) {
        this.f18738b = connectableFlowable;
        this.f18739c = i;
        this.f18740d = consumer;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        ConnectableFlowable connectableFlowable = this.f18738b;
        connectableFlowable.subscribe(subscriber);
        if (this.f18741e.incrementAndGet() == this.f18739c) {
            connectableFlowable.connect(this.f18740d);
        }
    }
}
