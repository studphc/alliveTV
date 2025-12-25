package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class zo0 extends AtomicInteger implements FlowableSubscriber {
    private static final long serialVersionUID = -7098360935104053232L;

    /* renamed from: a */
    public final Subscriber f29452a;

    /* renamed from: b */
    public final SubscriptionArbiter f29453b;

    /* renamed from: c */
    public final Publisher f29454c;

    /* renamed from: d */
    public long f29455d;

    /* renamed from: e */
    public long f29456e;

    public zo0(Subscriber subscriber, long j, SubscriptionArbiter subscriptionArbiter, Publisher publisher) {
        this.f29452a = subscriber;
        this.f29453b = subscriptionArbiter;
        this.f29454c = publisher;
        this.f29455d = j;
    }

    /* renamed from: a */
    public final void m8421a() {
        if (getAndIncrement() == 0) {
            int i = 1;
            do {
                SubscriptionArbiter subscriptionArbiter = this.f29453b;
                if (subscriptionArbiter.isCancelled()) {
                    return;
                }
                long j = this.f29456e;
                if (j != 0) {
                    this.f29456e = 0L;
                    subscriptionArbiter.produced(j);
                }
                this.f29454c.subscribe(this);
                i = addAndGet(-i);
            } while (i != 0);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        long j = this.f29455d;
        if (j != Long.MAX_VALUE) {
            this.f29455d = j - 1;
        }
        if (j != 0) {
            m8421a();
        } else {
            this.f29452a.onComplete();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f29452a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f29456e++;
        this.f29452a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        this.f29453b.setSubscription(subscription);
    }
}
