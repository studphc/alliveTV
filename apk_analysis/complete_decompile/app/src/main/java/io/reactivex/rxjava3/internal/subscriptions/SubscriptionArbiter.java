package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public class SubscriptionArbiter extends AtomicInteger implements Subscription {
    private static final long serialVersionUID = -2189523197179400958L;

    /* renamed from: a */
    public Subscription f19937a;

    /* renamed from: b */
    public long f19938b;

    /* renamed from: c */
    public final AtomicReference f19939c = new AtomicReference();

    /* renamed from: d */
    public final AtomicLong f19940d = new AtomicLong();

    /* renamed from: e */
    public final AtomicLong f19941e = new AtomicLong();

    /* renamed from: f */
    public final boolean f19942f;

    /* renamed from: g */
    public volatile boolean f19943g;
    protected boolean unbounded;

    public SubscriptionArbiter(boolean z) {
        this.f19942f = z;
    }

    /* renamed from: c */
    public final void m5300c() {
        int i = 1;
        long j = 0;
        Subscription subscription = null;
        do {
            Subscription subscription2 = (Subscription) this.f19939c.get();
            if (subscription2 != null) {
                subscription2 = (Subscription) this.f19939c.getAndSet(null);
            }
            long j2 = this.f19940d.get();
            if (j2 != 0) {
                j2 = this.f19940d.getAndSet(0L);
            }
            long j3 = this.f19941e.get();
            if (j3 != 0) {
                j3 = this.f19941e.getAndSet(0L);
            }
            Subscription subscription3 = this.f19937a;
            if (this.f19943g) {
                if (subscription3 != null) {
                    subscription3.cancel();
                    this.f19937a = null;
                }
                if (subscription2 != null) {
                    subscription2.cancel();
                }
            } else {
                long j4 = this.f19938b;
                if (j4 != Long.MAX_VALUE) {
                    j4 = BackpressureHelper.addCap(j4, j2);
                    if (j4 != Long.MAX_VALUE) {
                        j4 -= j3;
                        if (j4 < 0) {
                            SubscriptionHelper.reportMoreProduced(j4);
                            j4 = 0;
                        }
                    }
                    this.f19938b = j4;
                }
                if (subscription2 != null) {
                    if (subscription3 != null && this.f19942f) {
                        subscription3.cancel();
                    }
                    this.f19937a = subscription2;
                    if (j4 != 0) {
                        j = BackpressureHelper.addCap(j, j4);
                        subscription = subscription2;
                    }
                } else if (subscription3 != null && j2 != 0) {
                    j = BackpressureHelper.addCap(j, j2);
                    subscription = subscription3;
                }
            }
            i = addAndGet(-i);
        } while (i != 0);
        if (j != 0) {
            subscription.request(j);
        }
    }

    public void cancel() {
        if (!this.f19943g) {
            this.f19943g = true;
            if (getAndIncrement() == 0) {
                m5300c();
            }
        }
    }

    public final boolean isCancelled() {
        return this.f19943g;
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public void onSubscribe(Subscription subscription) {
        setSubscription(subscription);
    }

    public final void produced(long j) {
        if (this.unbounded) {
            return;
        }
        if (get() == 0 && compareAndSet(0, 1)) {
            long j2 = this.f19938b;
            if (j2 != Long.MAX_VALUE) {
                long j3 = j2 - j;
                if (j3 < 0) {
                    SubscriptionHelper.reportMoreProduced(j3);
                    j3 = 0;
                }
                this.f19938b = j3;
            }
            if (decrementAndGet() == 0) {
                return;
            }
            m5300c();
            return;
        }
        BackpressureHelper.add(this.f19941e, j);
        if (getAndIncrement() == 0) {
            m5300c();
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (!SubscriptionHelper.validate(j) || this.unbounded) {
            return;
        }
        if (get() == 0 && compareAndSet(0, 1)) {
            long j2 = this.f19938b;
            if (j2 != Long.MAX_VALUE) {
                long addCap = BackpressureHelper.addCap(j2, j);
                this.f19938b = addCap;
                if (addCap == Long.MAX_VALUE) {
                    this.unbounded = true;
                }
            }
            Subscription subscription = this.f19937a;
            if (decrementAndGet() != 0) {
                m5300c();
            }
            if (subscription != null) {
                subscription.request(j);
                return;
            }
            return;
        }
        BackpressureHelper.add(this.f19940d, j);
        if (getAndIncrement() == 0) {
            m5300c();
        }
    }

    public final void setSubscription(Subscription subscription) {
        if (this.f19943g) {
            subscription.cancel();
            return;
        }
        Objects.requireNonNull(subscription, "s is null");
        if (get() == 0 && compareAndSet(0, 1)) {
            Subscription subscription2 = this.f19937a;
            if (subscription2 != null && this.f19942f) {
                subscription2.cancel();
            }
            this.f19937a = subscription;
            long j = this.f19938b;
            if (decrementAndGet() != 0) {
                m5300c();
            }
            if (j != 0) {
                subscription.request(j);
                return;
            }
            return;
        }
        Subscription subscription3 = (Subscription) this.f19939c.getAndSet(subscription);
        if (subscription3 != null && this.f19942f) {
            subscription3.cancel();
        }
        if (getAndIncrement() == 0) {
            m5300c();
        }
    }
}
