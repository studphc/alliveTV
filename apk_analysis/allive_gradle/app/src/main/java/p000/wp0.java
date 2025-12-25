package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public abstract class wp0 extends AtomicReference implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = -3517602651313910099L;

    /* renamed from: a */
    public final SerializedSubscriber f28264a;

    /* renamed from: b */
    public final Publisher f28265b;

    /* renamed from: c */
    public final AtomicLong f28266c = new AtomicLong();

    /* renamed from: d */
    public final AtomicReference f28267d = new AtomicReference();

    /* renamed from: e */
    public Subscription f28268e;

    public wp0(SerializedSubscriber serializedSubscriber, Publisher publisher) {
        this.f28264a = serializedSubscriber;
        this.f28265b = publisher;
    }

    /* renamed from: a */
    public abstract void mo7759a();

    /* renamed from: b */
    public final void m8070b() {
        Object andSet = getAndSet(null);
        if (andSet != null) {
            AtomicLong atomicLong = this.f28266c;
            long j = atomicLong.get();
            SerializedSubscriber serializedSubscriber = this.f28264a;
            if (j != 0) {
                serializedSubscriber.onNext(andSet);
                BackpressureHelper.produced(atomicLong, 1L);
            } else {
                cancel();
                serializedSubscriber.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
            }
        }
    }

    /* renamed from: c */
    public abstract void mo7760c();

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        SubscriptionHelper.cancel(this.f28267d);
        this.f28268e.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        SubscriptionHelper.cancel(this.f28267d);
        mo7759a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        SubscriptionHelper.cancel(this.f28267d);
        this.f28264a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        lazySet(obj);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f28268e, subscription)) {
            this.f28268e = subscription;
            this.f28264a.onSubscribe(this);
            if (this.f28267d.get() == null) {
                this.f28265b.subscribe(new xp0(this, 0));
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f28266c, j);
        }
    }
}
