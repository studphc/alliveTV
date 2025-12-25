package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class dj1 extends BasicIntQueueSubscription implements MaybeObserver {
    private static final long serialVersionUID = -660395290758764731L;

    /* renamed from: a */
    public final Subscriber f16385a;

    /* renamed from: d */
    public final Object f16388d;

    /* renamed from: f */
    public final int f16390f;

    /* renamed from: g */
    public volatile boolean f16391g;

    /* renamed from: h */
    public boolean f16392h;

    /* renamed from: i */
    public long f16393i;

    /* renamed from: b */
    public final CompositeDisposable f16386b = new CompositeDisposable();

    /* renamed from: c */
    public final AtomicLong f16387c = new AtomicLong();

    /* renamed from: e */
    public final AtomicThrowable f16389e = new AtomicThrowable();

    public dj1(Subscriber subscriber, int i, fj1 fj1Var) {
        this.f16385a = subscriber;
        this.f16390f = i;
        this.f16388d = fj1Var;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [io.reactivex.rxjava3.operators.SimpleQueue, java.lang.Object] */
    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (!this.f16391g) {
            this.f16391g = true;
            this.f16386b.dispose();
            if (getAndIncrement() == 0) {
                this.f16388d.clear();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [io.reactivex.rxjava3.operators.SimpleQueue, java.lang.Object] */
    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f16388d.clear();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.rxjava3.operators.SimpleQueue, java.lang.Object, fj1] */
    /* JADX WARN: Type inference failed for: r2v1, types: [io.reactivex.rxjava3.operators.SimpleQueue, java.lang.Object, fj1] */
    public final void drain() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        int i = 1;
        if (this.f16392h) {
            Subscriber subscriber = this.f16385a;
            ?? r2 = this.f16388d;
            int i2 = 1;
            while (!this.f16391g) {
                Throwable th = this.f16389e.get();
                if (th != null) {
                    r2.clear();
                    subscriber.onError(th);
                    return;
                }
                if (r2.mo2257b() == this.f16390f) {
                    z = true;
                } else {
                    z = false;
                }
                if (!r2.isEmpty()) {
                    subscriber.onNext(null);
                }
                if (z) {
                    subscriber.onComplete();
                    return;
                } else {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
            r2.clear();
            return;
        }
        Subscriber subscriber2 = this.f16385a;
        ?? r22 = this.f16388d;
        long j = this.f16393i;
        do {
            long j2 = this.f16387c.get();
            while (j != j2) {
                if (this.f16391g) {
                    r22.clear();
                    return;
                }
                if (this.f16389e.get() != null) {
                    r22.clear();
                    this.f16389e.tryTerminateConsumer(this.f16385a);
                    return;
                } else {
                    if (r22.mo2259d() == this.f16390f) {
                        subscriber2.onComplete();
                        return;
                    }
                    Object poll = r22.poll();
                    if (poll == null) {
                        break;
                    } else if (poll != NotificationLite.COMPLETE) {
                        subscriber2.onNext(poll);
                        j++;
                    }
                }
            }
            if (j == j2) {
                if (this.f16389e.get() != null) {
                    r22.clear();
                    this.f16389e.tryTerminateConsumer(this.f16385a);
                    return;
                } else {
                    while (r22.peek() == NotificationLite.COMPLETE) {
                        r22.mo2258c();
                    }
                    if (r22.mo2259d() == this.f16390f) {
                        subscriber2.onComplete();
                        return;
                    }
                }
            }
            this.f16393i = j;
            i = addAndGet(-i);
        } while (i != 0);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [io.reactivex.rxjava3.operators.SimpleQueue, java.lang.Object] */
    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        return this.f16388d.isEmpty();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [io.reactivex.rxjava3.operators.SimpleQueue, java.lang.Object] */
    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        this.f16388d.offer(NotificationLite.COMPLETE);
        drain();
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [io.reactivex.rxjava3.operators.SimpleQueue, java.lang.Object] */
    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        if (this.f16389e.tryAddThrowableOrReport(th)) {
            this.f16386b.dispose();
            this.f16388d.offer(NotificationLite.COMPLETE);
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        this.f16386b.add(disposable);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [io.reactivex.rxjava3.operators.SimpleQueue, java.lang.Object] */
    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        this.f16388d.offer(obj);
        drain();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [io.reactivex.rxjava3.operators.SimpleQueue, java.lang.Object] */
    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        Object poll;
        do {
            poll = this.f16388d.poll();
        } while (poll == NotificationLite.COMPLETE);
        return poll;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f16387c, j);
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        if ((i & 2) != 0) {
            this.f16392h = true;
            return 2;
        }
        return 0;
    }
}
