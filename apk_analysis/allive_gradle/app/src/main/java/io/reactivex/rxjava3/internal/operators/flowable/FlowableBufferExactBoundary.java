package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.Collection;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.aj0;

/* loaded from: classes2.dex */
public final class FlowableBufferExactBoundary<T, U extends Collection<? super T>, B> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Publisher f18748b;

    /* renamed from: c */
    public final Supplier f18749c;

    public FlowableBufferExactBoundary(Flowable<T> flowable, Publisher<B> publisher, Supplier<U> supplier) {
        super(flowable);
        this.f18748b = publisher;
        this.f18749c = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super U> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new aj0(new SerializedSubscriber(subscriber), this.f18749c, this.f18748b));
    }
}
