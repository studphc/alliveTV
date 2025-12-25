package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class fm0 extends BasicIntQueueSubscription implements FlowableSubscriber {
    private static final long serialVersionUID = -3096000382929934955L;

    /* renamed from: a */
    public final Subscriber f17319a;

    /* renamed from: b */
    public final Function f17320b;

    /* renamed from: c */
    public final int f17321c;

    /* renamed from: d */
    public final int f17322d;

    /* renamed from: f */
    public Subscription f17324f;

    /* renamed from: g */
    public SimpleQueue f17325g;

    /* renamed from: h */
    public volatile boolean f17326h;

    /* renamed from: i */
    public volatile boolean f17327i;

    /* renamed from: k */
    public Iterator f17329k;

    /* renamed from: l */
    public int f17330l;

    /* renamed from: m */
    public int f17331m;

    /* renamed from: j */
    public final AtomicReference f17328j = new AtomicReference();

    /* renamed from: e */
    public final AtomicLong f17323e = new AtomicLong();

    public fm0(Subscriber subscriber, Function function, int i) {
        this.f17319a = subscriber;
        this.f17320b = function;
        this.f17321c = i;
        this.f17322d = i - (i >> 2);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (!this.f17327i) {
            this.f17327i = true;
            this.f17324f.cancel();
            if (getAndIncrement() == 0) {
                this.f17325g.clear();
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f17329k = null;
        this.f17325g.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0140, code lost:
    
        if (r6 == null) goto L78;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void drain() {
        Object[] objArr;
        boolean z;
        boolean z2;
        if (getAndIncrement() != 0) {
            return;
        }
        Subscriber subscriber = this.f17319a;
        SimpleQueue simpleQueue = this.f17325g;
        int i = 1;
        boolean z3 = false;
        if (this.f17331m != 1) {
            objArr = true;
        } else {
            objArr = false;
        }
        Iterator it = this.f17329k;
        int i2 = 1;
        while (true) {
            if (it == null) {
                boolean z4 = this.f17326h;
                try {
                    Object poll = simpleQueue.poll();
                    if (poll == null) {
                        z2 = i;
                    } else {
                        z2 = z3 ? 1 : 0;
                    }
                    if (m4814e(z4, z2, subscriber, simpleQueue)) {
                        return;
                    }
                    if (poll != null) {
                        try {
                            it = ((Iterable) this.f17320b.apply(poll)).iterator();
                            if (!it.hasNext()) {
                                if (objArr != false) {
                                    int i3 = this.f17330l + i;
                                    if (i3 == this.f17322d) {
                                        this.f17330l = z3 ? 1 : 0;
                                        this.f17324f.request(i3);
                                    } else {
                                        this.f17330l = i3;
                                    }
                                }
                                it = null;
                            } else {
                                this.f17329k = it;
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.f17324f.cancel();
                            ExceptionHelper.addThrowable(this.f17328j, th);
                            subscriber.onError(ExceptionHelper.terminate(this.f17328j));
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f17324f.cancel();
                    ExceptionHelper.addThrowable(this.f17328j, th2);
                    Throwable terminate = ExceptionHelper.terminate(this.f17328j);
                    this.f17329k = null;
                    simpleQueue.clear();
                    subscriber.onError(terminate);
                    return;
                }
            }
            if (it != null) {
                long j = this.f17323e.get();
                long j2 = 0;
                while (true) {
                    if (j2 == j) {
                        break;
                    }
                    if (m4814e(this.f17326h, z3, subscriber, simpleQueue)) {
                        return;
                    }
                    try {
                        Object next = it.next();
                        Objects.requireNonNull(next, "The iterator returned a null value");
                        subscriber.onNext(next);
                        if (m4814e(this.f17326h, z3, subscriber, simpleQueue)) {
                            return;
                        }
                        j2++;
                        try {
                            if (!it.hasNext()) {
                                if (objArr != false) {
                                    int i4 = this.f17330l + i;
                                    if (i4 == this.f17322d) {
                                        this.f17330l = z3 ? 1 : 0;
                                        this.f17324f.request(i4);
                                    } else {
                                        this.f17330l = i4;
                                    }
                                }
                                this.f17329k = null;
                                it = null;
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            this.f17329k = null;
                            this.f17324f.cancel();
                            ExceptionHelper.addThrowable(this.f17328j, th3);
                            subscriber.onError(ExceptionHelper.terminate(this.f17328j));
                            return;
                        }
                    } catch (Throwable th4) {
                        Exceptions.throwIfFatal(th4);
                        this.f17329k = null;
                        this.f17324f.cancel();
                        ExceptionHelper.addThrowable(this.f17328j, th4);
                        subscriber.onError(ExceptionHelper.terminate(this.f17328j));
                        return;
                    }
                }
                if (j2 == j) {
                    boolean z5 = this.f17326h;
                    if (simpleQueue.isEmpty() && it == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (m4814e(z5, z, subscriber, simpleQueue)) {
                        return;
                    }
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.f17323e.addAndGet(-j2);
                }
            }
            i2 = addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
            i = 1;
            z3 = false;
        }
    }

    /* renamed from: e */
    public final boolean m4814e(boolean z, boolean z2, Subscriber subscriber, SimpleQueue simpleQueue) {
        if (this.f17327i) {
            this.f17329k = null;
            simpleQueue.clear();
            return true;
        }
        if (z) {
            if (((Throwable) this.f17328j.get()) != null) {
                Throwable terminate = ExceptionHelper.terminate(this.f17328j);
                this.f17329k = null;
                simpleQueue.clear();
                subscriber.onError(terminate);
                return true;
            }
            if (z2) {
                subscriber.onComplete();
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        if (this.f17329k == null && this.f17325g.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f17326h) {
            return;
        }
        this.f17326h = true;
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (!this.f17326h && ExceptionHelper.addThrowable(this.f17328j, th)) {
            this.f17326h = true;
            drain();
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f17326h) {
            return;
        }
        if (this.f17331m == 0 && !this.f17325g.offer(obj)) {
            onError(new MissingBackpressureException("Queue is full?!"));
        } else {
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f17324f, subscription)) {
            this.f17324f = subscription;
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.f17331m = requestFusion;
                    this.f17325g = queueSubscription;
                    this.f17326h = true;
                    this.f17319a.onSubscribe(this);
                    return;
                }
                if (requestFusion == 2) {
                    this.f17331m = requestFusion;
                    this.f17325g = queueSubscription;
                    this.f17319a.onSubscribe(this);
                    subscription.request(this.f17321c);
                    return;
                }
            }
            this.f17325g = new SpscArrayQueue(this.f17321c);
            this.f17319a.onSubscribe(this);
            subscription.request(this.f17321c);
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        Iterator it = this.f17329k;
        while (true) {
            if (it == null) {
                Object poll = this.f17325g.poll();
                if (poll == null) {
                    return null;
                }
                it = ((Iterable) this.f17320b.apply(poll)).iterator();
                if (!it.hasNext()) {
                    it = null;
                } else {
                    this.f17329k = it;
                    break;
                }
            } else {
                break;
            }
        }
        Object next = it.next();
        Objects.requireNonNull(next, "The iterator returned a null value");
        if (!it.hasNext()) {
            this.f17329k = null;
        }
        return next;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f17323e, j);
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        if ((i & 1) != 0 && this.f17331m == 1) {
            return 1;
        }
        return 0;
    }
}
