package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public abstract class yn0 extends BasicIntQueueSubscription implements FlowableSubscriber, Runnable {
    private static final long serialVersionUID = -8241002408341274697L;

    /* renamed from: a */
    public final Scheduler.Worker f29032a;

    /* renamed from: b */
    public final boolean f29033b;

    /* renamed from: c */
    public final int f29034c;

    /* renamed from: d */
    public final int f29035d;

    /* renamed from: e */
    public final AtomicLong f29036e = new AtomicLong();

    /* renamed from: f */
    public Subscription f29037f;

    /* renamed from: g */
    public SimpleQueue f29038g;

    /* renamed from: h */
    public volatile boolean f29039h;

    /* renamed from: i */
    public volatile boolean f29040i;

    /* renamed from: j */
    public Throwable f29041j;

    /* renamed from: k */
    public int f29042k;

    /* renamed from: l */
    public long f29043l;

    /* renamed from: m */
    public boolean f29044m;

    public yn0(Scheduler.Worker worker, boolean z, int i) {
        this.f29032a = worker;
        this.f29033b = z;
        this.f29034c = i;
        this.f29035d = i - (i >> 2);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (this.f29039h) {
            return;
        }
        this.f29039h = true;
        this.f29037f.cancel();
        this.f29032a.dispose();
        if (!this.f29044m && getAndIncrement() == 0) {
            this.f29038g.clear();
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f29038g.clear();
    }

    /* renamed from: e */
    public final boolean m8313e(Subscriber subscriber, boolean z, boolean z2) {
        if (this.f29039h) {
            clear();
            return true;
        }
        if (z) {
            if (this.f29033b) {
                if (z2) {
                    this.f29039h = true;
                    Throwable th = this.f29041j;
                    if (th != null) {
                        subscriber.onError(th);
                    } else {
                        subscriber.onComplete();
                    }
                    this.f29032a.dispose();
                    return true;
                }
                return false;
            }
            Throwable th2 = this.f29041j;
            if (th2 != null) {
                this.f29039h = true;
                clear();
                subscriber.onError(th2);
                this.f29032a.dispose();
                return true;
            }
            if (z2) {
                this.f29039h = true;
                subscriber.onComplete();
                this.f29032a.dispose();
                return true;
            }
            return false;
        }
        return false;
    }

    /* renamed from: f */
    public abstract void mo1952f();

    /* renamed from: g */
    public abstract void mo1953g();

    /* renamed from: h */
    public abstract void mo1954h();

    /* renamed from: i */
    public final void m8314i() {
        if (getAndIncrement() != 0) {
            return;
        }
        this.f29032a.schedule(this);
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        return this.f29038g.isEmpty();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (!this.f29040i) {
            this.f29040i = true;
            m8314i();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f29040i) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f29041j = th;
        this.f29040i = true;
        m8314i();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f29040i) {
            return;
        }
        if (this.f29042k == 2) {
            m8314i();
            return;
        }
        if (!this.f29038g.offer(obj)) {
            this.f29037f.cancel();
            this.f29041j = new MissingBackpressureException("Queue is full?!");
            this.f29040i = true;
        }
        m8314i();
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f29036e, j);
            m8314i();
        }
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        if ((i & 2) != 0) {
            this.f29044m = true;
            return 2;
        }
        return 0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f29044m) {
            mo1953g();
        } else if (this.f29042k == 1) {
            mo1954h();
        } else {
            mo1952f();
        }
    }
}
