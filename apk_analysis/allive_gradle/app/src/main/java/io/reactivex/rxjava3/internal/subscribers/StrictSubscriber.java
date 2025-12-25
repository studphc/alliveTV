package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p000.ye0;

/* loaded from: classes2.dex */
public class StrictSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -4945028590049415624L;

    /* renamed from: a */
    public final Subscriber f19924a;

    /* renamed from: b */
    public final AtomicThrowable f19925b = new AtomicThrowable();

    /* renamed from: c */
    public final AtomicLong f19926c = new AtomicLong();

    /* renamed from: d */
    public final AtomicReference f19927d = new AtomicReference();

    /* renamed from: e */
    public final AtomicBoolean f19928e = new AtomicBoolean();

    /* renamed from: f */
    public volatile boolean f19929f;

    public StrictSubscriber(Subscriber<? super T> subscriber) {
        this.f19924a = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (!this.f19929f) {
            SubscriptionHelper.cancel(this.f19927d);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.f19929f = true;
        HalfSerializer.onComplete((Subscriber<?>) this.f19924a, this, this.f19925b);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.f19929f = true;
        HalfSerializer.onError((Subscriber<?>) this.f19924a, th, this, this.f19925b);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        HalfSerializer.onNext(this.f19924a, t, this, this.f19925b);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (this.f19928e.compareAndSet(false, true)) {
            this.f19924a.onSubscribe(this);
            SubscriptionHelper.deferredSetOnce(this.f19927d, this.f19926c, subscription);
        } else {
            subscription.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        if (j <= 0) {
            cancel();
            onError(new IllegalArgumentException(ye0.m8294n(j, "§3.9 violated: positive request amount required but it was ")));
        } else {
            SubscriptionHelper.deferredRequest(this.f19927d, this.f19926c, j);
        }
    }
}
