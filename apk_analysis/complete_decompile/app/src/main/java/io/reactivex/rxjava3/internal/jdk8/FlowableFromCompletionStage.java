package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import p000.km0;

/* loaded from: classes2.dex */
public final class FlowableFromCompletionStage<T> extends Flowable<T> {

    /* renamed from: b */
    public final CompletionStage f18538b;

    public FlowableFromCompletionStage(CompletionStage<T> completionStage) {
        this.f18538b = completionStage;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [jm0, java.util.concurrent.atomic.AtomicReference] */
    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        ?? atomicReference = new AtomicReference();
        km0 km0Var = new km0(subscriber, atomicReference);
        atomicReference.lazySet(km0Var);
        subscriber.onSubscribe(km0Var);
        this.f18538b.whenComplete(atomicReference);
    }
}
