package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class lj0 extends BasicIntQueueSubscription {
    private static final long serialVersionUID = -5082275438355852221L;

    /* renamed from: a */
    public final Subscriber f22520a;

    /* renamed from: b */
    public final Function f22521b;

    /* renamed from: c */
    public final mj0[] f22522c;

    /* renamed from: d */
    public final SpscLinkedArrayQueue f22523d;

    /* renamed from: e */
    public final Object[] f22524e;

    /* renamed from: f */
    public final boolean f22525f;

    /* renamed from: g */
    public boolean f22526g;

    /* renamed from: h */
    public int f22527h;

    /* renamed from: i */
    public int f22528i;

    /* renamed from: j */
    public volatile boolean f22529j;

    /* renamed from: k */
    public final AtomicLong f22530k;

    /* renamed from: l */
    public volatile boolean f22531l;

    /* renamed from: m */
    public final AtomicThrowable f22532m;

    public lj0(Subscriber subscriber, Function function, boolean z, int i, int i2) {
        this.f22520a = subscriber;
        this.f22521b = function;
        mj0[] mj0VarArr = new mj0[i];
        for (int i3 = 0; i3 < i; i3++) {
            mj0VarArr[i3] = new mj0(this, i3, i2);
        }
        this.f22522c = mj0VarArr;
        this.f22524e = new Object[i];
        this.f22523d = new SpscLinkedArrayQueue(i2);
        this.f22530k = new AtomicLong();
        this.f22532m = new AtomicThrowable();
        this.f22525f = z;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f22529j = true;
        m5926e();
        drain();
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f22523d.clear();
    }

    public final void drain() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        int i = 1;
        if (this.f22526g) {
            Subscriber subscriber = this.f22520a;
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f22523d;
            while (!this.f22529j) {
                Throwable th = this.f22532m.get();
                if (th != null) {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(th);
                    return;
                }
                boolean z2 = this.f22531l;
                boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                if (!isEmpty) {
                    subscriber.onNext(null);
                }
                if (z2 && isEmpty) {
                    subscriber.onComplete();
                    return;
                } else {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
            spscLinkedArrayQueue.clear();
            return;
        }
        Subscriber subscriber2 = this.f22520a;
        SpscLinkedArrayQueue spscLinkedArrayQueue2 = this.f22523d;
        int i2 = 1;
        do {
            long j = this.f22530k.get();
            long j2 = 0;
            while (j2 != j) {
                boolean z3 = this.f22531l;
                Object poll = spscLinkedArrayQueue2.poll();
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (!m5927f(z3, z, subscriber2, spscLinkedArrayQueue2)) {
                    if (z) {
                        break;
                    }
                    try {
                        Object apply = this.f22521b.apply((Object[]) spscLinkedArrayQueue2.poll());
                        Objects.requireNonNull(apply, "The combiner returned a null value");
                        subscriber2.onNext(apply);
                        ((mj0) poll).m6146a();
                        j2++;
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        m5926e();
                        ExceptionHelper.addThrowable(this.f22532m, th2);
                        subscriber2.onError(ExceptionHelper.terminate(this.f22532m));
                        return;
                    }
                } else {
                    return;
                }
            }
            if (j2 != j || !m5927f(this.f22531l, spscLinkedArrayQueue2.isEmpty(), subscriber2, spscLinkedArrayQueue2)) {
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.f22530k.addAndGet(-j2);
                }
                i2 = addAndGet(-i2);
            } else {
                return;
            }
        } while (i2 != 0);
    }

    /* renamed from: e */
    public final void m5926e() {
        for (mj0 mj0Var : this.f22522c) {
            mj0Var.getClass();
            SubscriptionHelper.cancel(mj0Var);
        }
    }

    /* renamed from: f */
    public final boolean m5927f(boolean z, boolean z2, Subscriber subscriber, SpscLinkedArrayQueue spscLinkedArrayQueue) {
        if (this.f22529j) {
            m5926e();
            spscLinkedArrayQueue.clear();
            this.f22532m.tryTerminateAndReport();
            return true;
        }
        if (z) {
            if (this.f22525f) {
                if (z2) {
                    m5926e();
                    this.f22532m.tryTerminateConsumer((Subscriber<?>) subscriber);
                    return true;
                }
                return false;
            }
            Throwable terminate = ExceptionHelper.terminate(this.f22532m);
            if (terminate != null && terminate != ExceptionHelper.TERMINATED) {
                m5926e();
                spscLinkedArrayQueue.clear();
                subscriber.onError(terminate);
                return true;
            }
            if (z2) {
                m5926e();
                subscriber.onComplete();
                return true;
            }
            return false;
        }
        return false;
    }

    /* renamed from: g */
    public final void m5928g(int i) {
        synchronized (this) {
            try {
                Object[] objArr = this.f22524e;
                if (objArr[i] != null) {
                    int i2 = this.f22528i + 1;
                    if (i2 == objArr.length) {
                        this.f22531l = true;
                    } else {
                        this.f22528i = i2;
                        return;
                    }
                } else {
                    this.f22531l = true;
                }
                drain();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        return this.f22523d.isEmpty();
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f22523d;
        Object poll = spscLinkedArrayQueue.poll();
        if (poll == null) {
            return null;
        }
        Object apply = this.f22521b.apply((Object[]) spscLinkedArrayQueue.poll());
        Objects.requireNonNull(apply, "The combiner returned a null value");
        ((mj0) poll).m6146a();
        return apply;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f22530k, j);
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        boolean z = false;
        if ((i & 4) != 0) {
            return 0;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            z = true;
        }
        this.f22526g = z;
        return i2;
    }
}
