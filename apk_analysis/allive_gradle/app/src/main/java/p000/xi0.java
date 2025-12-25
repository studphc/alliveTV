package p000;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class xi0 extends AtomicInteger implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = -8466418554264089604L;

    /* renamed from: a */
    public final Subscriber f28564a;

    /* renamed from: b */
    public final Supplier f28565b;

    /* renamed from: c */
    public final Publisher f28566c;

    /* renamed from: d */
    public final Function f28567d;

    /* renamed from: i */
    public volatile boolean f28572i;

    /* renamed from: k */
    public volatile boolean f28574k;

    /* renamed from: l */
    public long f28575l;

    /* renamed from: n */
    public long f28577n;

    /* renamed from: j */
    public final SpscLinkedArrayQueue f28573j = new SpscLinkedArrayQueue(Flowable.bufferSize());

    /* renamed from: e */
    public final CompositeDisposable f28568e = new CompositeDisposable();

    /* renamed from: f */
    public final AtomicLong f28569f = new AtomicLong();

    /* renamed from: g */
    public final AtomicReference f28570g = new AtomicReference();

    /* renamed from: m */
    public LinkedHashMap f28576m = new LinkedHashMap();

    /* renamed from: h */
    public final AtomicThrowable f28571h = new AtomicThrowable();

    public xi0(Subscriber subscriber, Publisher publisher, Function function, Supplier supplier) {
        this.f28564a = subscriber;
        this.f28565b = supplier;
        this.f28566c = publisher;
        this.f28567d = function;
    }

    /* renamed from: a */
    public final void m8169a(yi0 yi0Var, long j) {
        boolean z;
        this.f28568e.delete(yi0Var);
        if (this.f28568e.size() == 0) {
            SubscriptionHelper.cancel(this.f28570g);
            z = true;
        } else {
            z = false;
        }
        synchronized (this) {
            try {
                LinkedHashMap linkedHashMap = this.f28576m;
                if (linkedHashMap == null) {
                    return;
                }
                this.f28573j.offer(linkedHashMap.remove(Long.valueOf(j)));
                if (z) {
                    this.f28572i = true;
                }
                m8170b();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: b */
    public final void m8170b() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        long j = this.f28577n;
        Subscriber<?> subscriber = this.f28564a;
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f28573j;
        int i = 1;
        do {
            long j2 = this.f28569f.get();
            while (j != j2) {
                if (this.f28574k) {
                    spscLinkedArrayQueue.clear();
                    return;
                }
                boolean z2 = this.f28572i;
                if (z2 && this.f28571h.get() != null) {
                    spscLinkedArrayQueue.clear();
                    this.f28571h.tryTerminateConsumer(subscriber);
                    return;
                }
                Collection collection = (Collection) spscLinkedArrayQueue.poll();
                if (collection == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z2 && z) {
                    subscriber.onComplete();
                    return;
                } else {
                    if (z) {
                        break;
                    }
                    subscriber.onNext(collection);
                    j++;
                }
            }
            if (j == j2) {
                if (this.f28574k) {
                    spscLinkedArrayQueue.clear();
                    return;
                }
                if (this.f28572i) {
                    if (this.f28571h.get() != null) {
                        spscLinkedArrayQueue.clear();
                        this.f28571h.tryTerminateConsumer(subscriber);
                        return;
                    } else if (spscLinkedArrayQueue.isEmpty()) {
                        subscriber.onComplete();
                        return;
                    }
                }
            }
            this.f28577n = j;
            i = addAndGet(-i);
        } while (i != 0);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (SubscriptionHelper.cancel(this.f28570g)) {
            this.f28574k = true;
            this.f28568e.dispose();
            synchronized (this) {
                this.f28576m = null;
            }
            if (getAndIncrement() != 0) {
                this.f28573j.clear();
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f28568e.dispose();
        synchronized (this) {
            try {
                LinkedHashMap linkedHashMap = this.f28576m;
                if (linkedHashMap == null) {
                    return;
                }
                Iterator it = linkedHashMap.values().iterator();
                while (it.hasNext()) {
                    this.f28573j.offer((Collection) it.next());
                }
                this.f28576m = null;
                this.f28572i = true;
                m8170b();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f28571h.tryAddThrowableOrReport(th)) {
            this.f28568e.dispose();
            synchronized (this) {
                this.f28576m = null;
            }
            this.f28572i = true;
            m8170b();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        synchronized (this) {
            try {
                LinkedHashMap linkedHashMap = this.f28576m;
                if (linkedHashMap == null) {
                    return;
                }
                Iterator it = linkedHashMap.values().iterator();
                while (it.hasNext()) {
                    ((Collection) it.next()).add(obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.f28570g, subscription)) {
            wi0 wi0Var = new wi0(this);
            this.f28568e.add(wi0Var);
            this.f28566c.subscribe(wi0Var);
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        BackpressureHelper.add(this.f28569f, j);
        m8170b();
    }
}
