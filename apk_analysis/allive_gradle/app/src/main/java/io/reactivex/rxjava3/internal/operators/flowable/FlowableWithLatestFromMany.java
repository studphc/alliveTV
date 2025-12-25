package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.ks0;
import p000.nj0;

/* loaded from: classes2.dex */
public final class FlowableWithLatestFromMany<T, R> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Publisher[] f19089b;

    /* renamed from: c */
    public final Iterable f19090c;

    /* renamed from: d */
    public final Function f19091d;

    public FlowableWithLatestFromMany(@NonNull Flowable<T> flowable, @NonNull Publisher<?>[] publisherArr, Function<? super Object[], R> function) {
        super(flowable);
        this.f19089b = publisherArr;
        this.f19090c = null;
        this.f19091d = function;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        int length;
        Publisher[] publisherArr = this.f19089b;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                length = 0;
                for (Publisher publisher : this.f19090c) {
                    if (length == publisherArr.length) {
                        publisherArr = (Publisher[]) Arrays.copyOf(publisherArr, (length >> 1) + length);
                    }
                    int i = length + 1;
                    publisherArr[length] = publisher;
                    length = i;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
                return;
            }
        } else {
            length = publisherArr.length;
        }
        if (length == 0) {
            new FlowableMap(this.source, new nj0(1, this)).subscribeActual(subscriber);
            return;
        }
        ks0 ks0Var = new ks0(subscriber, this.f19091d, length);
        subscriber.onSubscribe(ks0Var);
        AtomicReference atomicReference = ks0Var.f22182e;
        for (int i2 = 0; i2 < length && atomicReference.get() != SubscriptionHelper.CANCELLED; i2++) {
            publisherArr[i2].subscribe(ks0Var.f22180c[i2]);
        }
        this.source.subscribe((FlowableSubscriber<? super Object>) ks0Var);
    }

    public FlowableWithLatestFromMany(@NonNull Flowable<T> flowable, @NonNull Iterable<? extends Publisher<?>> iterable, @NonNull Function<? super Object[], R> function) {
        super(flowable);
        this.f19089b = null;
        this.f19090c = iterable;
        this.f19091d = function;
    }
}
