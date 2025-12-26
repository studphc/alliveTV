package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class sp0 extends AtomicInteger implements FlowableSubscriber {
    private static final long serialVersionUID = -7098360935104053232L;

    /* renamed from: a */
    public final Subscriber f26513a;

    /* renamed from: b */
    public final SubscriptionArbiter f26514b;

    /* renamed from: c */
    public final Publisher f26515c;

    /* renamed from: d */
    public final Predicate f26516d;

    /* renamed from: e */
    public long f26517e;

    /* renamed from: f */
    public long f26518f;

    public sp0(Subscriber subscriber, long j, Predicate predicate, SubscriptionArbiter subscriptionArbiter, Publisher publisher) {
        this.f26513a = subscriber;
        this.f26514b = subscriptionArbiter;
        this.f26515c = publisher;
        this.f26516d = predicate;
        this.f26517e = j;
    }

    /* renamed from: a */
    public final void m7396a() {
        if (getAndIncrement() == 0) {
            int i = 1;
            do {
                SubscriptionArbiter subscriptionArbiter = this.f26514b;
                if (subscriptionArbiter.isCancelled()) {
                    return;
                }
                long j = this.f26518f;
                if (j != 0) {
                    this.f26518f = 0L;
                    subscriptionArbiter.produced(j);
                }
                this.f26515c.subscribe(this);
                i = addAndGet(-i);
            } while (i != 0);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f26513a.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        long j = this.f26517e;
        if (j != Long.MAX_VALUE) {
            this.f26517e = j - 1;
        }
        Subscriber subscriber = this.f26513a;
        if (j == 0) {
            subscriber.onError(th);
            return;
        }
        try {
            if (!this.f26516d.test(th)) {
                subscriber.onError(th);
            } else {
                m7396a();
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            subscriber.onError(new CompositeException(th, th2));
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f26518f++;
        this.f26513a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        this.f26514b.setSubscription(subscription);
    }
}
