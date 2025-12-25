package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ap0 extends AtomicInteger implements FlowableSubscriber {
    private static final long serialVersionUID = -7098360935104053232L;

    /* renamed from: a */
    public final Subscriber f7691a;

    /* renamed from: b */
    public final SubscriptionArbiter f7692b;

    /* renamed from: c */
    public final Publisher f7693c;

    /* renamed from: d */
    public final BooleanSupplier f7694d;

    /* renamed from: e */
    public long f7695e;

    public ap0(Subscriber subscriber, BooleanSupplier booleanSupplier, SubscriptionArbiter subscriptionArbiter, Publisher publisher) {
        this.f7691a = subscriber;
        this.f7692b = subscriptionArbiter;
        this.f7693c = publisher;
        this.f7694d = booleanSupplier;
    }

    /* renamed from: a */
    public final void m1956a() {
        if (getAndIncrement() == 0) {
            int i = 1;
            do {
                SubscriptionArbiter subscriptionArbiter = this.f7692b;
                if (subscriptionArbiter.isCancelled()) {
                    return;
                }
                long j = this.f7695e;
                if (j != 0) {
                    this.f7695e = 0L;
                    subscriptionArbiter.produced(j);
                }
                this.f7693c.subscribe(this);
                i = addAndGet(-i);
            } while (i != 0);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        Subscriber subscriber = this.f7691a;
        try {
            if (this.f7694d.getAsBoolean()) {
                subscriber.onComplete();
            } else {
                m1956a();
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            subscriber.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f7691a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f7695e++;
        this.f7691a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        this.f7692b.setSubscription(subscription);
    }
}
