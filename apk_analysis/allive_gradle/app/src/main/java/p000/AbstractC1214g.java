package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* renamed from: g */
/* loaded from: classes2.dex */
public abstract class AbstractC1214g extends AtomicInteger implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = -5050301752721603566L;

    /* renamed from: a */
    public final Subscriber f17494a;

    /* renamed from: b */
    public Subscription f17495b;

    /* renamed from: c */
    public volatile boolean f17496c;

    /* renamed from: d */
    public Throwable f17497d;

    /* renamed from: e */
    public volatile boolean f17498e;

    /* renamed from: f */
    public final AtomicLong f17499f = new AtomicLong();

    /* renamed from: g */
    public final AtomicReference f17500g = new AtomicReference();

    public AbstractC1214g(Subscriber subscriber) {
        this.f17494a = subscriber;
    }

    /* renamed from: a */
    public final boolean m4893a(boolean z, boolean z2, Subscriber subscriber, AtomicReference atomicReference) {
        if (this.f17498e) {
            atomicReference.lazySet(null);
            return true;
        }
        if (z) {
            Throwable th = this.f17497d;
            if (th != null) {
                atomicReference.lazySet(null);
                subscriber.onError(th);
                return true;
            }
            if (z2) {
                subscriber.onComplete();
                return true;
            }
            return false;
        }
        return false;
    }

    /* renamed from: b */
    public final void m4894b() {
        boolean z;
        boolean z2;
        if (getAndIncrement() != 0) {
            return;
        }
        Subscriber subscriber = this.f17494a;
        AtomicLong atomicLong = this.f17499f;
        AtomicReference atomicReference = this.f17500g;
        int i = 1;
        do {
            long j = 0;
            while (true) {
                z = false;
                if (j == atomicLong.get()) {
                    break;
                }
                boolean z3 = this.f17496c;
                Object andSet = atomicReference.getAndSet(null);
                if (andSet == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (m4893a(z3, z2, subscriber, atomicReference)) {
                    return;
                }
                if (z2) {
                    break;
                }
                subscriber.onNext(andSet);
                j++;
            }
            if (j == atomicLong.get()) {
                boolean z4 = this.f17496c;
                if (atomicReference.get() == null) {
                    z = true;
                }
                if (m4893a(z4, z, subscriber, atomicReference)) {
                    return;
                }
            }
            if (j != 0) {
                BackpressureHelper.produced(atomicLong, j);
            }
            i = addAndGet(-i);
        } while (i != 0);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (!this.f17498e) {
            this.f17498e = true;
            this.f17495b.cancel();
            if (getAndIncrement() == 0) {
                this.f17500g.lazySet(null);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f17496c = true;
        m4894b();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f17497d = th;
        this.f17496c = true;
        m4894b();
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f17495b, subscription)) {
            this.f17495b = subscription;
            this.f17494a.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f17499f, j);
            m4894b();
        }
    }
}
