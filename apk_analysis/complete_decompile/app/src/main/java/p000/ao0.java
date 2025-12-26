package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ao0 extends yn0 {
    private static final long serialVersionUID = -4547113800637756442L;

    /* renamed from: n */
    public final Subscriber f7685n;

    public ao0(Subscriber subscriber, Scheduler.Worker worker, boolean z, int i) {
        super(worker, z, i);
        this.f7685n = subscriber;
    }

    @Override // p000.yn0
    /* renamed from: f */
    public final void mo1952f() {
        boolean z;
        Subscriber subscriber = this.f7685n;
        SimpleQueue simpleQueue = this.f29038g;
        long j = this.f29043l;
        int i = 1;
        while (true) {
            long j2 = this.f29036e.get();
            while (j != j2) {
                boolean z2 = this.f29040i;
                try {
                    Object poll = simpleQueue.poll();
                    if (poll == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (m8313e(subscriber, z2, z)) {
                        return;
                    }
                    if (z) {
                        break;
                    }
                    subscriber.onNext(poll);
                    j++;
                    if (j == this.f29035d) {
                        if (j2 != Long.MAX_VALUE) {
                            j2 = this.f29036e.addAndGet(-j);
                        }
                        this.f29037f.request(j);
                        j = 0;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f29039h = true;
                    this.f29037f.cancel();
                    simpleQueue.clear();
                    subscriber.onError(th);
                    this.f29032a.dispose();
                    return;
                }
            }
            if (j == j2 && m8313e(subscriber, this.f29040i, simpleQueue.isEmpty())) {
                return;
            }
            int i2 = get();
            if (i == i2) {
                this.f29043l = j;
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                i = i2;
            }
        }
    }

    @Override // p000.yn0
    /* renamed from: g */
    public final void mo1953g() {
        int i = 1;
        while (!this.f29039h) {
            boolean z = this.f29040i;
            this.f7685n.onNext(null);
            if (z) {
                this.f29039h = true;
                Throwable th = this.f29041j;
                if (th != null) {
                    this.f7685n.onError(th);
                } else {
                    this.f7685n.onComplete();
                }
                this.f29032a.dispose();
                return;
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
    }

    @Override // p000.yn0
    /* renamed from: h */
    public final void mo1954h() {
        Subscriber subscriber = this.f7685n;
        SimpleQueue simpleQueue = this.f29038g;
        long j = this.f29043l;
        int i = 1;
        do {
            long j2 = this.f29036e.get();
            while (j != j2) {
                try {
                    Object poll = simpleQueue.poll();
                    if (this.f29039h) {
                        return;
                    }
                    if (poll == null) {
                        this.f29039h = true;
                        subscriber.onComplete();
                        this.f29032a.dispose();
                        return;
                    }
                    subscriber.onNext(poll);
                    j++;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f29039h = true;
                    this.f29037f.cancel();
                    subscriber.onError(th);
                    this.f29032a.dispose();
                    return;
                }
            }
            if (this.f29039h) {
                return;
            }
            if (simpleQueue.isEmpty()) {
                this.f29039h = true;
                subscriber.onComplete();
                this.f29032a.dispose();
                return;
            }
            this.f29043l = j;
            i = addAndGet(-i);
        } while (i != 0);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f29037f, subscription)) {
            this.f29037f = subscription;
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(7);
                if (requestFusion == 1) {
                    this.f29042k = 1;
                    this.f29038g = queueSubscription;
                    this.f29040i = true;
                    this.f7685n.onSubscribe(this);
                    return;
                }
                if (requestFusion == 2) {
                    this.f29042k = 2;
                    this.f29038g = queueSubscription;
                    this.f7685n.onSubscribe(this);
                    subscription.request(this.f29034c);
                    return;
                }
            }
            this.f29038g = new SpscArrayQueue(this.f29034c);
            this.f7685n.onSubscribe(this);
            subscription.request(this.f29034c);
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        Object poll = this.f29038g.poll();
        if (poll != null && this.f29042k != 1) {
            long j = this.f29043l + 1;
            if (j == this.f29035d) {
                this.f29043l = 0L;
                this.f29037f.request(j);
            } else {
                this.f29043l = j;
            }
        }
        return poll;
    }
}
