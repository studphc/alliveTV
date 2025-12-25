package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class rp0 extends AtomicInteger implements FlowableSubscriber {
    private static final long serialVersionUID = -7098360935104053232L;

    /* renamed from: a */
    public final Subscriber f26089a;

    /* renamed from: b */
    public final SubscriptionArbiter f26090b;

    /* renamed from: c */
    public final Publisher f26091c;

    /* renamed from: d */
    public final BiPredicate f26092d;

    /* renamed from: e */
    public int f26093e;

    /* renamed from: f */
    public long f26094f;

    public rp0(Subscriber subscriber, BiPredicate biPredicate, SubscriptionArbiter subscriptionArbiter, Publisher publisher) {
        this.f26089a = subscriber;
        this.f26090b = subscriptionArbiter;
        this.f26091c = publisher;
        this.f26092d = biPredicate;
    }

    /* renamed from: a */
    public final void m7295a() {
        if (getAndIncrement() == 0) {
            int i = 1;
            do {
                SubscriptionArbiter subscriptionArbiter = this.f26090b;
                if (subscriptionArbiter.isCancelled()) {
                    return;
                }
                long j = this.f26094f;
                if (j != 0) {
                    this.f26094f = 0L;
                    subscriptionArbiter.produced(j);
                }
                this.f26091c.subscribe(this);
                i = addAndGet(-i);
            } while (i != 0);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f26089a.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        Subscriber subscriber = this.f26089a;
        try {
            BiPredicate biPredicate = this.f26092d;
            int i = this.f26093e + 1;
            this.f26093e = i;
            if (!biPredicate.test(Integer.valueOf(i), th)) {
                subscriber.onError(th);
            } else {
                m7295a();
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            subscriber.onError(new CompositeException(th, th2));
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f26094f++;
        this.f26089a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        this.f26090b.setSubscription(subscription);
    }
}
