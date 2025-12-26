package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ds0 extends AtomicInteger implements FlowableSubscriber, Subscription, Runnable {
    private static final long serialVersionUID = 8646217640096099753L;

    /* renamed from: a */
    public final Subscriber f16513a;

    /* renamed from: b */
    public final Publisher f16514b;

    /* renamed from: c */
    public final Function f16515c;

    /* renamed from: d */
    public final int f16516d;

    /* renamed from: l */
    public long f16524l;

    /* renamed from: m */
    public volatile boolean f16525m;

    /* renamed from: n */
    public volatile boolean f16526n;

    /* renamed from: o */
    public volatile boolean f16527o;

    /* renamed from: q */
    public Subscription f16529q;

    /* renamed from: h */
    public final MpscLinkedQueue f16520h = new MpscLinkedQueue();

    /* renamed from: e */
    public final CompositeDisposable f16517e = new CompositeDisposable();

    /* renamed from: g */
    public final ArrayList f16519g = new ArrayList();

    /* renamed from: i */
    public final AtomicLong f16521i = new AtomicLong(1);

    /* renamed from: j */
    public final AtomicBoolean f16522j = new AtomicBoolean();

    /* renamed from: p */
    public final AtomicThrowable f16528p = new AtomicThrowable();

    /* renamed from: f */
    public final cs0 f16518f = new cs0(this);

    /* renamed from: k */
    public final AtomicLong f16523k = new AtomicLong();

    public ds0(Subscriber subscriber, Publisher publisher, Function function, int i) {
        this.f16513a = subscriber;
        this.f16514b = publisher;
        this.f16515c = function;
        this.f16516d = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final void m4606a() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        Subscriber subscriber = this.f16513a;
        MpscLinkedQueue mpscLinkedQueue = this.f16520h;
        ArrayList arrayList = this.f16519g;
        int i = 1;
        while (true) {
            if (this.f16525m) {
                mpscLinkedQueue.clear();
                arrayList.clear();
            } else {
                boolean z2 = this.f16526n;
                T poll = mpscLinkedQueue.poll();
                if (poll == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z2 && (z || this.f16528p.get() != null)) {
                    m4607b(subscriber);
                    this.f16525m = true;
                } else if (!z) {
                    if (poll instanceof bs0) {
                        if (!this.f16522j.get()) {
                            long j = this.f16524l;
                            if (this.f16523k.get() != j) {
                                this.f16524l = j + 1;
                                try {
                                    Object apply = this.f16515c.apply(((bs0) poll).f8147a);
                                    Objects.requireNonNull(apply, "The closingIndicator returned a null Publisher");
                                    Publisher publisher = (Publisher) apply;
                                    this.f16521i.getAndIncrement();
                                    UnicastProcessor create = UnicastProcessor.create(this.f16516d, this);
                                    as0 as0Var = new as0(this, create);
                                    subscriber.onNext(as0Var);
                                    AtomicBoolean atomicBoolean = as0Var.f7733e;
                                    if (!atomicBoolean.get() && atomicBoolean.compareAndSet(false, true)) {
                                        create.onComplete();
                                    } else {
                                        arrayList.add(create);
                                        this.f16517e.add(as0Var);
                                        publisher.subscribe(as0Var);
                                    }
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    this.f16529q.cancel();
                                    cs0 cs0Var = this.f16518f;
                                    cs0Var.getClass();
                                    SubscriptionHelper.cancel(cs0Var);
                                    this.f16517e.dispose();
                                    Exceptions.throwIfFatal(th);
                                    this.f16528p.tryAddThrowableOrReport(th);
                                    this.f16526n = true;
                                }
                            } else {
                                this.f16529q.cancel();
                                cs0 cs0Var2 = this.f16518f;
                                cs0Var2.getClass();
                                SubscriptionHelper.cancel(cs0Var2);
                                this.f16517e.dispose();
                                this.f16528p.tryAddThrowableOrReport(new MissingBackpressureException(FlowableWindowTimed.m5280e(j)));
                                this.f16526n = true;
                            }
                        }
                    } else if (poll instanceof as0) {
                        UnicastProcessor unicastProcessor = ((as0) poll).f7731c;
                        arrayList.remove(unicastProcessor);
                        this.f16517e.delete((Disposable) poll);
                        unicastProcessor.onComplete();
                    } else {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((UnicastProcessor) it.next()).onNext(poll);
                        }
                    }
                } else if (this.f16527o && arrayList.size() == 0) {
                    this.f16529q.cancel();
                    cs0 cs0Var3 = this.f16518f;
                    cs0Var3.getClass();
                    SubscriptionHelper.cancel(cs0Var3);
                    this.f16517e.dispose();
                    m4607b(subscriber);
                    this.f16525m = true;
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
    }

    /* renamed from: b */
    public final void m4607b(Subscriber subscriber) {
        Throwable terminate = this.f16528p.terminate();
        ArrayList arrayList = this.f16519g;
        if (terminate == null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((UnicastProcessor) it.next()).onComplete();
            }
            subscriber.onComplete();
            return;
        }
        if (terminate != ExceptionHelper.TERMINATED) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((UnicastProcessor) it2.next()).onError(terminate);
            }
            subscriber.onError(terminate);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (this.f16522j.compareAndSet(false, true)) {
            if (this.f16521i.decrementAndGet() == 0) {
                this.f16529q.cancel();
                cs0 cs0Var = this.f16518f;
                cs0Var.getClass();
                SubscriptionHelper.cancel(cs0Var);
                this.f16517e.dispose();
                this.f16528p.tryTerminateAndReport();
                this.f16525m = true;
                m4606a();
                return;
            }
            cs0 cs0Var2 = this.f16518f;
            cs0Var2.getClass();
            SubscriptionHelper.cancel(cs0Var2);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        cs0 cs0Var = this.f16518f;
        cs0Var.getClass();
        SubscriptionHelper.cancel(cs0Var);
        this.f16517e.dispose();
        this.f16526n = true;
        m4606a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        cs0 cs0Var = this.f16518f;
        cs0Var.getClass();
        SubscriptionHelper.cancel(cs0Var);
        this.f16517e.dispose();
        if (this.f16528p.tryAddThrowableOrReport(th)) {
            this.f16526n = true;
            m4606a();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f16520h.offer(obj);
        m4606a();
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f16529q, subscription)) {
            this.f16529q = subscription;
            this.f16513a.onSubscribe(this);
            this.f16514b.subscribe(this.f16518f);
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f16523k, j);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f16521i.decrementAndGet() == 0) {
            this.f16529q.cancel();
            cs0 cs0Var = this.f16518f;
            cs0Var.getClass();
            SubscriptionHelper.cancel(cs0Var);
            this.f16517e.dispose();
            this.f16528p.tryTerminateAndReport();
            this.f16525m = true;
            m4606a();
        }
    }
}
