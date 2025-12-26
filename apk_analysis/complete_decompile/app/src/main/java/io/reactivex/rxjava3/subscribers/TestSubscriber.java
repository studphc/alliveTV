package io.reactivex.rxjava3.subscribers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.observers.BaseTestConsumer;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p000.rs2;

/* loaded from: classes2.dex */
public class TestSubscriber<T> extends BaseTestConsumer<T, TestSubscriber<T>> implements FlowableSubscriber<T>, Subscription {

    /* renamed from: a */
    public final Subscriber f20161a;

    /* renamed from: b */
    public volatile boolean f20162b;

    /* renamed from: c */
    public final AtomicReference f20163c;

    /* renamed from: d */
    public final AtomicLong f20164d;

    public TestSubscriber() {
        this(rs2.f26124a, Long.MAX_VALUE);
    }

    @NonNull
    public static <T> TestSubscriber<T> create() {
        return new TestSubscriber<>();
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (!this.f20162b) {
            this.f20162b = true;
            SubscriptionHelper.cancel(this.f20163c);
        }
    }

    @Override // io.reactivex.rxjava3.observers.BaseTestConsumer, io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        cancel();
    }

    public final boolean hasSubscription() {
        if (this.f20163c.get() != null) {
            return true;
        }
        return false;
    }

    public final boolean isCancelled() {
        return this.f20162b;
    }

    @Override // io.reactivex.rxjava3.observers.BaseTestConsumer, io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f20162b;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.f20163c.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.lastThread = Thread.currentThread();
            this.completions++;
            this.f20161a.onComplete();
        } finally {
            this.done.countDown();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(@NonNull Throwable th) {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.f20163c.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.lastThread = Thread.currentThread();
            if (th == null) {
                this.errors.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.errors.add(th);
            }
            this.f20161a.onError(th);
            this.done.countDown();
        } catch (Throwable th2) {
            this.done.countDown();
            throw th2;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(@NonNull T t) {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.f20163c.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.lastThread = Thread.currentThread();
        this.values.add(t);
        if (t == null) {
            this.errors.add(new NullPointerException("onNext received a null value"));
        }
        this.f20161a.onNext(t);
    }

    public void onStart() {
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(@NonNull Subscription subscription) {
        this.lastThread = Thread.currentThread();
        if (subscription == null) {
            this.errors.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        AtomicReference atomicReference = this.f20163c;
        while (!atomicReference.compareAndSet(null, subscription)) {
            if (atomicReference.get() != null) {
                subscription.cancel();
                if (atomicReference.get() != SubscriptionHelper.CANCELLED) {
                    this.errors.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + subscription));
                    return;
                }
                return;
            }
        }
        this.f20161a.onSubscribe(subscription);
        long andSet = this.f20164d.getAndSet(0L);
        if (andSet != 0) {
            subscription.request(andSet);
        }
        onStart();
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        SubscriptionHelper.deferredRequest(this.f20163c, this.f20164d, j);
    }

    public final TestSubscriber<T> requestMore(long j) {
        request(j);
        return this;
    }

    public TestSubscriber(long j) {
        this(rs2.f26124a, j);
    }

    @NonNull
    public static <T> TestSubscriber<T> create(long j) {
        return new TestSubscriber<>(j);
    }

    @Override // io.reactivex.rxjava3.observers.BaseTestConsumer
    public final TestSubscriber<T> assertSubscribed() {
        if (this.f20163c.get() != null) {
            return this;
        }
        throw fail("Not subscribed!");
    }

    public TestSubscriber(@NonNull Subscriber<? super T> subscriber) {
        this(subscriber, Long.MAX_VALUE);
    }

    public static <T> TestSubscriber<T> create(@NonNull Subscriber<? super T> subscriber) {
        return new TestSubscriber<>(subscriber);
    }

    public TestSubscriber(@NonNull Subscriber<? super T> subscriber, long j) {
        if (j >= 0) {
            this.f20161a = subscriber;
            this.f20163c = new AtomicReference();
            this.f20164d = new AtomicLong(j);
            return;
        }
        throw new IllegalArgumentException("Negative initial request not allowed");
    }
}
