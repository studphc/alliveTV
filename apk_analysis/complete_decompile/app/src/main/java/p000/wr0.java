package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Processor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class wr0 extends AtomicInteger implements FlowableSubscriber, Subscription, Runnable {
    private static final long serialVersionUID = 2428527070996323976L;

    /* renamed from: a */
    public final Subscriber f28297a;

    /* renamed from: b */
    public final SpscLinkedArrayQueue f28298b;

    /* renamed from: c */
    public final long f28299c;

    /* renamed from: d */
    public final long f28300d;

    /* renamed from: e */
    public final ArrayDeque f28301e;

    /* renamed from: f */
    public final AtomicBoolean f28302f;

    /* renamed from: g */
    public final AtomicBoolean f28303g;

    /* renamed from: h */
    public final AtomicLong f28304h;

    /* renamed from: i */
    public final AtomicInteger f28305i;

    /* renamed from: j */
    public final int f28306j;

    /* renamed from: k */
    public long f28307k;

    /* renamed from: l */
    public long f28308l;

    /* renamed from: m */
    public Subscription f28309m;

    /* renamed from: n */
    public volatile boolean f28310n;

    /* renamed from: o */
    public Throwable f28311o;

    /* renamed from: p */
    public volatile boolean f28312p;

    public wr0(Subscriber subscriber, long j, long j2, int i) {
        super(1);
        this.f28297a = subscriber;
        this.f28299c = j;
        this.f28300d = j2;
        this.f28298b = new SpscLinkedArrayQueue(i);
        this.f28301e = new ArrayDeque();
        this.f28302f = new AtomicBoolean();
        this.f28303g = new AtomicBoolean();
        this.f28304h = new AtomicLong();
        this.f28305i = new AtomicInteger();
        this.f28306j = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x000f, code lost:
    
        continue;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m8071a() {
        boolean z;
        if (this.f28305i.getAndIncrement() != 0) {
            return;
        }
        Subscriber subscriber = this.f28297a;
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f28298b;
        int i = 1;
        while (true) {
            if (this.f28312p) {
                while (true) {
                    UnicastProcessor unicastProcessor = (UnicastProcessor) spscLinkedArrayQueue.poll();
                    if (unicastProcessor == null) {
                        break;
                    } else {
                        unicastProcessor.onComplete();
                    }
                }
            } else {
                long j = this.f28304h.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z2 = this.f28310n;
                    UnicastProcessor unicastProcessor2 = (UnicastProcessor) spscLinkedArrayQueue.poll();
                    if (unicastProcessor2 == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!this.f28312p) {
                        if (z2) {
                            Throwable th = this.f28311o;
                            if (th != null) {
                                spscLinkedArrayQueue.clear();
                                subscriber.onError(th);
                                return;
                            } else if (z) {
                                subscriber.onComplete();
                                return;
                            }
                        }
                        if (z) {
                            break;
                        }
                        hp0 hp0Var = new hp0(unicastProcessor2);
                        subscriber.onNext(hp0Var);
                        if (hp0Var.m5121e()) {
                            unicastProcessor2.onComplete();
                        }
                        j2++;
                    }
                }
                if (j2 == j) {
                    if (this.f28312p) {
                        continue;
                    } else {
                        boolean z3 = this.f28310n;
                        boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                        if (z3) {
                            Throwable th2 = this.f28311o;
                            if (th2 != null) {
                                spscLinkedArrayQueue.clear();
                                subscriber.onError(th2);
                                return;
                            } else if (isEmpty) {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    }
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.f28304h.addAndGet(-j2);
                }
            }
            i = this.f28305i.addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f28312p = true;
        if (this.f28302f.compareAndSet(false, true)) {
            run();
        }
        m8071a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        Iterator it = this.f28301e.iterator();
        while (it.hasNext()) {
            ((Processor) it.next()).onComplete();
        }
        this.f28301e.clear();
        this.f28310n = true;
        m8071a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        Iterator it = this.f28301e.iterator();
        while (it.hasNext()) {
            ((Processor) it.next()).onError(th);
        }
        this.f28301e.clear();
        this.f28311o = th;
        this.f28310n = true;
        m8071a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        UnicastProcessor unicastProcessor;
        long j = this.f28307k;
        if (j == 0 && !this.f28312p) {
            getAndIncrement();
            unicastProcessor = UnicastProcessor.create(this.f28306j, this);
            this.f28301e.offer(unicastProcessor);
        } else {
            unicastProcessor = null;
        }
        long j2 = j + 1;
        Iterator it = this.f28301e.iterator();
        while (it.hasNext()) {
            ((Processor) it.next()).onNext(obj);
        }
        if (unicastProcessor != null) {
            this.f28298b.offer(unicastProcessor);
            m8071a();
        }
        long j3 = this.f28308l + 1;
        if (j3 == this.f28299c) {
            this.f28308l = j3 - this.f28300d;
            Processor processor = (Processor) this.f28301e.poll();
            if (processor != null) {
                processor.onComplete();
            }
        } else {
            this.f28308l = j3;
        }
        if (j2 == this.f28300d) {
            this.f28307k = 0L;
        } else {
            this.f28307k = j2;
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f28309m, subscription)) {
            this.f28309m = subscription;
            this.f28297a.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f28304h, j);
            AtomicBoolean atomicBoolean = this.f28303g;
            boolean z = atomicBoolean.get();
            long j2 = this.f28300d;
            if (!z && atomicBoolean.compareAndSet(false, true)) {
                this.f28309m.request(BackpressureHelper.addCap(this.f28299c, BackpressureHelper.multiplyCap(j2, j - 1)));
            } else {
                this.f28309m.request(BackpressureHelper.multiplyCap(j2, j));
            }
            m8071a();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (decrementAndGet() == 0) {
            this.f28309m.cancel();
        }
    }
}
