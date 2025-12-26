package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class yj0 extends AtomicInteger implements FlowableSubscriber, Subscription, InnerQueuedSubscriberSupport {
    private static final long serialVersionUID = -4255299542215038287L;

    /* renamed from: a */
    public final Subscriber f28974a;

    /* renamed from: b */
    public final Function f28975b;

    /* renamed from: c */
    public final int f28976c;

    /* renamed from: d */
    public final int f28977d;

    /* renamed from: e */
    public final ErrorMode f28978e;

    /* renamed from: f */
    public final AtomicThrowable f28979f = new AtomicThrowable();

    /* renamed from: g */
    public final AtomicLong f28980g = new AtomicLong();

    /* renamed from: h */
    public final SpscLinkedArrayQueue f28981h;

    /* renamed from: i */
    public Subscription f28982i;

    /* renamed from: j */
    public volatile boolean f28983j;

    /* renamed from: k */
    public volatile boolean f28984k;

    /* renamed from: l */
    public volatile InnerQueuedSubscriber f28985l;

    public yj0(Subscriber subscriber, Function function, int i, int i2, ErrorMode errorMode) {
        this.f28974a = subscriber;
        this.f28975b = function;
        this.f28976c = i;
        this.f28977d = i2;
        this.f28978e = errorMode;
        this.f28981h = new SpscLinkedArrayQueue(Math.min(i2, i));
    }

    /* renamed from: a */
    public final void m8307a() {
        InnerQueuedSubscriber innerQueuedSubscriber = this.f28985l;
        this.f28985l = null;
        if (innerQueuedSubscriber != null) {
            innerQueuedSubscriber.cancel();
        }
        while (true) {
            InnerQueuedSubscriber innerQueuedSubscriber2 = (InnerQueuedSubscriber) this.f28981h.poll();
            if (innerQueuedSubscriber2 != null) {
                innerQueuedSubscriber2.cancel();
            } else {
                return;
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (this.f28983j) {
            return;
        }
        this.f28983j = true;
        this.f28982i.cancel();
        this.f28979f.tryTerminateAndReport();
        if (getAndIncrement() != 0) {
            return;
        }
        do {
            m8307a();
        } while (decrementAndGet() != 0);
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriberSupport
    public final void drain() {
        InnerQueuedSubscriber innerQueuedSubscriber;
        int i;
        boolean z;
        long j;
        long j2;
        SimpleQueue queue;
        boolean z2;
        if (getAndIncrement() != 0) {
            return;
        }
        InnerQueuedSubscriber innerQueuedSubscriber2 = this.f28985l;
        Subscriber subscriber = this.f28974a;
        ErrorMode errorMode = this.f28978e;
        int i2 = 1;
        while (true) {
            long j3 = this.f28980g.get();
            if (innerQueuedSubscriber2 == null) {
                if (errorMode != ErrorMode.END && this.f28979f.get() != null) {
                    m8307a();
                    this.f28979f.tryTerminateConsumer(this.f28974a);
                    return;
                }
                boolean z3 = this.f28984k;
                innerQueuedSubscriber = (InnerQueuedSubscriber) this.f28981h.poll();
                if (z3 && innerQueuedSubscriber == null) {
                    this.f28979f.tryTerminateConsumer(this.f28974a);
                    return;
                } else if (innerQueuedSubscriber != null) {
                    this.f28985l = innerQueuedSubscriber;
                }
            } else {
                innerQueuedSubscriber = innerQueuedSubscriber2;
            }
            if (innerQueuedSubscriber != null && (queue = innerQueuedSubscriber.queue()) != null) {
                j2 = 0;
                while (true) {
                    i = i2;
                    if (j2 == j3) {
                        break;
                    }
                    if (this.f28983j) {
                        m8307a();
                        return;
                    }
                    if (errorMode == ErrorMode.IMMEDIATE && this.f28979f.get() != null) {
                        this.f28985l = null;
                        innerQueuedSubscriber.cancel();
                        m8307a();
                        this.f28979f.tryTerminateConsumer(this.f28974a);
                        return;
                    }
                    boolean isDone = innerQueuedSubscriber.isDone();
                    try {
                        Object poll = queue.poll();
                        if (poll == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (isDone && z2) {
                            this.f28985l = null;
                            this.f28982i.request(1L);
                            innerQueuedSubscriber = null;
                            z = true;
                            break;
                        }
                        if (z2) {
                            break;
                        }
                        subscriber.onNext(poll);
                        j2++;
                        innerQueuedSubscriber.request(1L);
                        i2 = i;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f28985l = null;
                        innerQueuedSubscriber.cancel();
                        m8307a();
                        subscriber.onError(th);
                        return;
                    }
                }
                z = false;
                if (j2 == j3) {
                    if (this.f28983j) {
                        m8307a();
                        return;
                    }
                    if (errorMode == ErrorMode.IMMEDIATE && this.f28979f.get() != null) {
                        this.f28985l = null;
                        innerQueuedSubscriber.cancel();
                        m8307a();
                        this.f28979f.tryTerminateConsumer(this.f28974a);
                        return;
                    }
                    boolean isDone2 = innerQueuedSubscriber.isDone();
                    boolean isEmpty = queue.isEmpty();
                    if (isDone2 && isEmpty) {
                        this.f28985l = null;
                        this.f28982i.request(1L);
                        innerQueuedSubscriber = null;
                        z = true;
                    }
                }
                j = 0;
            } else {
                i = i2;
                z = false;
                j = 0;
                j2 = 0;
            }
            if (j2 != j && j3 != Long.MAX_VALUE) {
                this.f28980g.addAndGet(-j2);
            }
            if (z) {
                innerQueuedSubscriber2 = innerQueuedSubscriber;
                i2 = i;
            } else {
                i2 = addAndGet(-i);
                if (i2 == 0) {
                    return;
                } else {
                    innerQueuedSubscriber2 = innerQueuedSubscriber;
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriberSupport
    public final void innerComplete(InnerQueuedSubscriber innerQueuedSubscriber) {
        innerQueuedSubscriber.setDone();
        drain();
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriberSupport
    public final void innerError(InnerQueuedSubscriber innerQueuedSubscriber, Throwable th) {
        if (this.f28979f.tryAddThrowableOrReport(th)) {
            innerQueuedSubscriber.setDone();
            if (this.f28978e != ErrorMode.END) {
                this.f28982i.cancel();
            }
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriberSupport
    public final void innerNext(InnerQueuedSubscriber innerQueuedSubscriber, Object obj) {
        if (innerQueuedSubscriber.queue().offer(obj)) {
            drain();
        } else {
            innerQueuedSubscriber.cancel();
            innerError(innerQueuedSubscriber, new MissingBackpressureException());
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f28984k = true;
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f28979f.tryAddThrowableOrReport(th)) {
            this.f28984k = true;
            drain();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        try {
            Object apply = this.f28975b.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null Publisher");
            Publisher publisher = (Publisher) apply;
            InnerQueuedSubscriber innerQueuedSubscriber = new InnerQueuedSubscriber(this, this.f28977d);
            if (this.f28983j) {
                return;
            }
            this.f28981h.offer(innerQueuedSubscriber);
            publisher.subscribe(innerQueuedSubscriber);
            if (this.f28983j) {
                innerQueuedSubscriber.cancel();
                if (getAndIncrement() != 0) {
                    return;
                }
                do {
                    m8307a();
                } while (decrementAndGet() != 0);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f28982i.cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        long j;
        if (SubscriptionHelper.validate(this.f28982i, subscription)) {
            this.f28982i = subscription;
            this.f28974a.onSubscribe(this);
            int i = this.f28976c;
            if (i == Integer.MAX_VALUE) {
                j = Long.MAX_VALUE;
            } else {
                j = i;
            }
            subscription.request(j);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f28980g, j);
            drain();
        }
    }
}
