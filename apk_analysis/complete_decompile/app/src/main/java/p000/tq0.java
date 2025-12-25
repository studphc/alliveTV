package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class tq0 extends AtomicInteger implements FlowableSubscriber, Subscription {

    /* renamed from: l */
    public static final sq0 f26925l;
    private static final long serialVersionUID = -3491074160481096299L;

    /* renamed from: a */
    public final Subscriber f26926a;

    /* renamed from: b */
    public final Function f26927b;

    /* renamed from: c */
    public final int f26928c;

    /* renamed from: d */
    public final boolean f26929d;

    /* renamed from: e */
    public volatile boolean f26930e;

    /* renamed from: g */
    public volatile boolean f26932g;

    /* renamed from: h */
    public Subscription f26933h;

    /* renamed from: k */
    public volatile long f26936k;

    /* renamed from: i */
    public final AtomicReference f26934i = new AtomicReference();

    /* renamed from: j */
    public final AtomicLong f26935j = new AtomicLong();

    /* renamed from: f */
    public final AtomicThrowable f26931f = new AtomicThrowable();

    static {
        sq0 sq0Var = new sq0(null, -1L, 1);
        f26925l = sq0Var;
        SubscriptionHelper.cancel(sq0Var);
    }

    public tq0(int i, Function function, Subscriber subscriber, boolean z) {
        this.f26926a = subscriber;
        this.f26927b = function;
        this.f26928c = i;
        this.f26929d = z;
    }

    /* renamed from: a */
    public final void m7503a() {
        AtomicReference atomicReference = this.f26934i;
        sq0 sq0Var = f26925l;
        sq0 sq0Var2 = (sq0) atomicReference.getAndSet(sq0Var);
        if (sq0Var2 != sq0Var && sq0Var2 != null) {
            SubscriptionHelper.cancel(sq0Var2);
        }
    }

    /* renamed from: b */
    public final void m7504b() {
        SimpleQueue simpleQueue;
        boolean z;
        Object obj;
        boolean z2;
        if (getAndIncrement() != 0) {
            return;
        }
        Subscriber<?> subscriber = this.f26926a;
        int i = 1;
        while (!this.f26932g) {
            if (this.f26930e) {
                if (this.f26929d) {
                    if (this.f26934i.get() == null) {
                        this.f26931f.tryTerminateConsumer(subscriber);
                        return;
                    }
                } else if (this.f26931f.get() != null) {
                    m7503a();
                    this.f26931f.tryTerminateConsumer(subscriber);
                    return;
                } else if (this.f26934i.get() == null) {
                    subscriber.onComplete();
                    return;
                }
            }
            sq0 sq0Var = (sq0) this.f26934i.get();
            if (sq0Var != null) {
                simpleQueue = sq0Var.f26530d;
            } else {
                simpleQueue = null;
            }
            if (simpleQueue != null) {
                long j = this.f26935j.get();
                long j2 = 0;
                while (j2 != j) {
                    if (this.f26932g) {
                        return;
                    }
                    boolean z3 = sq0Var.f26531e;
                    try {
                        obj = simpleQueue.poll();
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        SubscriptionHelper.cancel(sq0Var);
                        this.f26931f.tryAddThrowableOrReport(th);
                        obj = null;
                        z3 = true;
                    }
                    if (obj == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (sq0Var == this.f26934i.get()) {
                        if (z3) {
                            if (!this.f26929d) {
                                if (this.f26931f.get() != null) {
                                    this.f26931f.tryTerminateConsumer(subscriber);
                                    return;
                                } else if (z2) {
                                    AtomicReference atomicReference = this.f26934i;
                                    while (!atomicReference.compareAndSet(sq0Var, null) && atomicReference.get() == sq0Var) {
                                    }
                                }
                            } else if (z2) {
                                AtomicReference atomicReference2 = this.f26934i;
                                while (!atomicReference2.compareAndSet(sq0Var, null) && atomicReference2.get() == sq0Var) {
                                }
                            }
                        }
                        if (z2) {
                            break;
                        }
                        subscriber.onNext(obj);
                        j2++;
                    }
                    z = true;
                    break;
                }
                z = false;
                if (j2 == j && sq0Var.f26531e) {
                    if (!this.f26929d) {
                        if (this.f26931f.get() != null) {
                            m7503a();
                            this.f26931f.tryTerminateConsumer(subscriber);
                            return;
                        } else if (simpleQueue.isEmpty()) {
                            AtomicReference atomicReference3 = this.f26934i;
                            while (!atomicReference3.compareAndSet(sq0Var, null) && atomicReference3.get() == sq0Var) {
                            }
                        }
                    } else if (simpleQueue.isEmpty()) {
                        AtomicReference atomicReference4 = this.f26934i;
                        while (!atomicReference4.compareAndSet(sq0Var, null) && atomicReference4.get() == sq0Var) {
                        }
                    }
                }
                if (j2 != 0 && !this.f26932g) {
                    if (j != Long.MAX_VALUE) {
                        this.f26935j.addAndGet(-j2);
                    }
                    if (sq0Var.f26532f != 1) {
                        ((Subscription) sq0Var.get()).request(j2);
                    }
                }
                if (z) {
                    continue;
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (!this.f26932g) {
            this.f26932g = true;
            this.f26933h.cancel();
            m7503a();
            this.f26931f.tryTerminateAndReport();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f26930e) {
            return;
        }
        this.f26930e = true;
        m7504b();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (!this.f26930e && this.f26931f.tryAddThrowable(th)) {
            if (!this.f26929d) {
                m7503a();
            }
            this.f26930e = true;
            m7504b();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f26930e) {
            return;
        }
        long j = this.f26936k + 1;
        this.f26936k = j;
        sq0 sq0Var = (sq0) this.f26934i.get();
        if (sq0Var != null) {
            SubscriptionHelper.cancel(sq0Var);
        }
        try {
            Object apply = this.f26927b.apply(obj);
            Objects.requireNonNull(apply, "The publisher returned is null");
            Publisher publisher = (Publisher) apply;
            sq0 sq0Var2 = new sq0(this, j, this.f26928c);
            while (true) {
                sq0 sq0Var3 = (sq0) this.f26934i.get();
                if (sq0Var3 != f26925l) {
                    AtomicReference atomicReference = this.f26934i;
                    while (!atomicReference.compareAndSet(sq0Var3, sq0Var2)) {
                        if (atomicReference.get() != sq0Var3) {
                            break;
                        }
                    }
                    publisher.subscribe(sq0Var2);
                    return;
                }
                return;
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f26933h.cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f26933h, subscription)) {
            this.f26933h = subscription;
            this.f26926a.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f26935j, j);
            if (this.f26936k == 0) {
                this.f26933h.request(Long.MAX_VALUE);
            } else {
                m7504b();
            }
        }
    }
}
