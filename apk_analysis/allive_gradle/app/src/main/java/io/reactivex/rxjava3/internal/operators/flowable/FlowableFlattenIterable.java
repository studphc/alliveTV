package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.fm0;

/* loaded from: classes2.dex */
public final class FlowableFlattenIterable<T, R> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Function f18864b;

    /* renamed from: c */
    public final int f18865c;

    public FlowableFlattenIterable(Flowable<T> flowable, Function<? super T, ? extends Iterable<? extends R>> function, int i) {
        super(flowable);
        this.f18864b = function;
        this.f18865c = i;
    }

    public static <T, R> Subscriber<T> subscribe(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function, int i) {
        return new fm0(subscriber, function, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        Flowable<Object> flowable = this.source;
        boolean z = flowable instanceof Supplier;
        Function function = this.f18864b;
        if (z) {
            try {
                Object obj = ((Supplier) flowable).get();
                if (obj == null) {
                    EmptySubscription.complete(subscriber);
                    return;
                }
                try {
                    FlowableFromIterable.subscribe(subscriber, ((Iterable) function.apply(obj)).iterator());
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptySubscription.error(th, subscriber);
                    return;
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptySubscription.error(th2, subscriber);
                return;
            }
        }
        flowable.subscribe((FlowableSubscriber<? super Object>) new fm0(subscriber, function, this.f18865c));
    }
}
