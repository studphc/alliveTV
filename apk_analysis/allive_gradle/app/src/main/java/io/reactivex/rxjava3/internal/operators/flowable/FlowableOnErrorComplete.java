package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p000.AbstractC1215g0;

/* loaded from: classes2.dex */
public final class FlowableOnErrorComplete<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Predicate f18951b;

    /* loaded from: classes2.dex */
    public static final class OnErrorCompleteSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: a */
        public final Subscriber f18952a;

        /* renamed from: b */
        public final Predicate f18953b;

        /* renamed from: c */
        public Subscription f18954c;

        public OnErrorCompleteSubscriber(Subscriber<? super T> subscriber, Predicate<? super Throwable> predicate) {
            this.f18952a = subscriber;
            this.f18953b = predicate;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f18954c.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f18952a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Subscriber subscriber = this.f18952a;
            try {
                if (this.f18953b.test(th)) {
                    subscriber.onComplete();
                } else {
                    subscriber.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                subscriber.onError(new CompositeException(th, th2));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.f18952a.onNext(t);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f18954c, subscription)) {
                this.f18954c = subscription;
                this.f18952a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.f18954c.request(j);
        }
    }

    public FlowableOnErrorComplete(Flowable<T> flowable, Predicate<? super Throwable> predicate) {
        super(flowable);
        this.f18951b = predicate;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new OnErrorCompleteSubscriber(subscriber, this.f18951b));
    }
}
