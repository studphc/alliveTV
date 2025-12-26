package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class b32 extends y22 {
    private static final long serialVersionUID = 1075119423897941642L;

    /* renamed from: k */
    public final Subscriber f7881k;

    public b32(Subscriber subscriber, int i, SpscArrayQueue spscArrayQueue, Scheduler.Worker worker) {
        super(i, spscArrayQueue, worker);
        this.f7881k = subscriber;
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f28811e, subscription)) {
            this.f28811e = subscription;
            this.f7881k.onSubscribe(this);
            subscription.request(this.f28807a);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        Throwable th;
        int i = this.f28816j;
        SpscArrayQueue spscArrayQueue = this.f28809c;
        Subscriber subscriber = this.f7881k;
        int i2 = this.f28808b;
        int i3 = 1;
        while (true) {
            long j = this.f28814h.get();
            long j2 = 0;
            while (j2 != j) {
                if (this.f28815i) {
                    spscArrayQueue.clear();
                    return;
                }
                boolean z2 = this.f28812f;
                if (z2 && (th = this.f28813g) != null) {
                    spscArrayQueue.clear();
                    subscriber.onError(th);
                    this.f28810d.dispose();
                    return;
                }
                Object poll = spscArrayQueue.poll();
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z2 && z) {
                    subscriber.onComplete();
                    this.f28810d.dispose();
                    return;
                } else {
                    if (z) {
                        break;
                    }
                    subscriber.onNext(poll);
                    j2++;
                    i++;
                    if (i == i2) {
                        this.f28811e.request(i);
                        i = 0;
                    }
                }
            }
            if (j2 == j) {
                if (this.f28815i) {
                    spscArrayQueue.clear();
                    return;
                }
                if (this.f28812f) {
                    Throwable th2 = this.f28813g;
                    if (th2 != null) {
                        spscArrayQueue.clear();
                        subscriber.onError(th2);
                        this.f28810d.dispose();
                        return;
                    } else if (spscArrayQueue.isEmpty()) {
                        subscriber.onComplete();
                        this.f28810d.dispose();
                        return;
                    }
                }
            }
            if (j2 != 0 && j != Long.MAX_VALUE) {
                this.f28814h.addAndGet(-j2);
            }
            int i4 = get();
            if (i4 == i3) {
                this.f28816j = i;
                i3 = addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            } else {
                i3 = i4;
            }
        }
    }
}
