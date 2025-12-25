package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class a32 extends y22 {
    private static final long serialVersionUID = 1075119423897941642L;

    /* renamed from: k */
    public final ConditionalSubscriber f31k;

    public a32(ConditionalSubscriber conditionalSubscriber, int i, SpscArrayQueue spscArrayQueue, Scheduler.Worker worker) {
        super(i, spscArrayQueue, worker);
        this.f31k = conditionalSubscriber;
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f28811e, subscription)) {
            this.f28811e = subscription;
            this.f31k.onSubscribe(this);
            subscription.request(this.f28807a);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        Throwable th;
        int i = this.f28816j;
        SpscArrayQueue spscArrayQueue = this.f28809c;
        ConditionalSubscriber conditionalSubscriber = this.f31k;
        int i2 = this.f28808b;
        int i3 = 1;
        do {
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
                    conditionalSubscriber.onError(th);
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
                    conditionalSubscriber.onComplete();
                    this.f28810d.dispose();
                    return;
                } else {
                    if (z) {
                        break;
                    }
                    if (conditionalSubscriber.tryOnNext(poll)) {
                        j2++;
                    }
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
                        conditionalSubscriber.onError(th2);
                        this.f28810d.dispose();
                        return;
                    } else if (spscArrayQueue.isEmpty()) {
                        conditionalSubscriber.onComplete();
                        this.f28810d.dispose();
                        return;
                    }
                }
            }
            if (j2 != 0) {
                BackpressureHelper.produced(this.f28814h, j2);
            }
            this.f28816j = i;
            i3 = addAndGet(-i3);
        } while (i3 != 0);
    }
}
