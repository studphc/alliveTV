package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FutureSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T>, Future<T>, Subscription {

    /* renamed from: a */
    public Object f19908a;

    /* renamed from: b */
    public Throwable f19909b;

    /* renamed from: c */
    public final AtomicReference f19910c;

    public FutureSubscriber() {
        super(1);
        this.f19910c = new AtomicReference();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // java.util.concurrent.Future
    public T get() {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            await();
        }
        if (!isCancelled()) {
            Throwable th = this.f19909b;
            if (th == null) {
                return (T) this.f19908a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        if (this.f19910c.get() == SubscriptionHelper.CANCELLED) {
            return true;
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        if (getCount() == 0) {
            return true;
        }
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f19908a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        AtomicReference atomicReference = this.f19910c;
        Subscription subscription = (Subscription) atomicReference.get();
        if (subscription == this || subscription == SubscriptionHelper.CANCELLED) {
            return;
        }
        while (!atomicReference.compareAndSet(subscription, this)) {
            if (atomicReference.get() != subscription) {
                return;
            }
        }
        countDown();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        if (r0.get() == r1) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0018, code lost:
    
        r3.f19909b = r4;
        countDown();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
    
        if (r1 != io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper.CANCELLED) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
    
        if (r0.compareAndSet(r1, r3) == false) goto L12;
     */
    @Override // org.reactivestreams.Subscriber
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onError(Throwable th) {
        if (this.f19909b == null) {
            AtomicReference atomicReference = this.f19910c;
            Subscription subscription = (Subscription) atomicReference.get();
            if (subscription != this) {
            }
        }
        RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.f19908a != null) {
            ((Subscription) this.f19910c.get()).cancel();
            onError(new IndexOutOfBoundsException("More than one element received"));
        } else {
            this.f19908a = t;
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this.f19910c, subscription, Long.MAX_VALUE);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        SubscriptionHelper subscriptionHelper;
        while (true) {
            AtomicReference atomicReference = this.f19910c;
            Subscription subscription = (Subscription) atomicReference.get();
            if (subscription == this || subscription == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
                return false;
            }
            while (!atomicReference.compareAndSet(subscription, subscriptionHelper)) {
                if (atomicReference.get() != subscription) {
                    break;
                }
            }
            if (subscription != null) {
                subscription.cancel();
            }
            countDown();
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public T get(long j, @NonNull TimeUnit timeUnit) {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            if (!await(j, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.timeoutMessage(j, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th = this.f19909b;
            if (th == null) {
                return (T) this.f19908a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
