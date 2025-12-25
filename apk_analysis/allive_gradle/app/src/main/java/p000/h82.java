package p000;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.processors.PublishProcessor;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class h82 extends AtomicLong implements Subscription {
    private static final long serialVersionUID = 3562861878281475070L;

    /* renamed from: a */
    public final Subscriber f17975a;

    /* renamed from: b */
    public final PublishProcessor f17976b;

    public h82(Subscriber subscriber, PublishProcessor publishProcessor) {
        this.f17975a = subscriber;
        this.f17976b = publishProcessor;
    }

    /* renamed from: a */
    public final void m5046a(Object obj) {
        long j = get();
        if (j == Long.MIN_VALUE) {
            return;
        }
        Subscriber subscriber = this.f17975a;
        if (j != 0) {
            subscriber.onNext(obj);
            BackpressureHelper.producedCancel(this, 1L);
        } else {
            cancel();
            subscriber.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
            this.f17976b.m5314e(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.addCancel(this, j);
        }
    }
}
