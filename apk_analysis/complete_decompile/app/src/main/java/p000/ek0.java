package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class ek0 extends ck0 {
    private static final long serialVersionUID = 7898995095634264146L;

    /* renamed from: n */
    public final Subscriber f16854n;

    /* renamed from: o */
    public final AtomicInteger f16855o;

    public ek0(Subscriber subscriber, Function function, int i, Scheduler.Worker worker) {
        super(function, i, worker);
        this.f16854n = subscriber;
        this.f16855o = new AtomicInteger();
    }

    @Override // p000.uj0
    /* renamed from: a */
    public final void mo4587a(Throwable th) {
        AtomicThrowable atomicThrowable = this.f8400k;
        if (atomicThrowable.tryAddThrowableOrReport(th)) {
            this.f8395f.cancel();
            if (getAndIncrement() == 0) {
                atomicThrowable.tryTerminateConsumer(this.f16854n);
                this.f8394e.dispose();
            }
        }
    }

    @Override // p000.uj0
    /* renamed from: c */
    public final void mo4588c(Object obj) {
        if (get() == 0 && compareAndSet(0, 1)) {
            Subscriber<?> subscriber = this.f16854n;
            subscriber.onNext(obj);
            if (compareAndSet(1, 0)) {
                return;
            }
            this.f8400k.tryTerminateConsumer(subscriber);
            this.f8394e.dispose();
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (!this.f8399j) {
            this.f8399j = true;
            this.f8390a.cancel();
            this.f8395f.cancel();
            this.f8394e.dispose();
            this.f8400k.tryTerminateAndReport();
        }
    }

    @Override // p000.ck0
    /* renamed from: d */
    public final void mo2261d() {
        if (this.f16855o.getAndIncrement() == 0) {
            this.f8394e.schedule(this);
        }
    }

    @Override // p000.ck0
    /* renamed from: e */
    public final void mo2262e() {
        this.f16854n.onSubscribe(this);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        AtomicThrowable atomicThrowable = this.f8400k;
        if (atomicThrowable.tryAddThrowableOrReport(th)) {
            this.f8390a.cancel();
            if (getAndIncrement() == 0) {
                atomicThrowable.tryTerminateConsumer(this.f16854n);
                this.f8394e.dispose();
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        this.f8390a.request(j);
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        while (!this.f8399j) {
            if (!this.f8401l) {
                boolean z2 = this.f8398i;
                try {
                    Object poll = this.f8397h.poll();
                    if (poll == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z2 && z) {
                        this.f16854n.onComplete();
                        this.f8394e.dispose();
                        return;
                    }
                    if (!z) {
                        try {
                            Object apply = this.f8391b.apply(poll);
                            Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                            Publisher publisher = (Publisher) apply;
                            if (this.f8402m != 1) {
                                int i = this.f8396g + 1;
                                if (i == this.f8393d) {
                                    this.f8396g = 0;
                                    this.f8395f.request(i);
                                } else {
                                    this.f8396g = i;
                                }
                            }
                            if (publisher instanceof Supplier) {
                                try {
                                    Object obj = ((Supplier) publisher).get();
                                    if (obj != null && !this.f8399j) {
                                        if (this.f8390a.isUnbounded()) {
                                            if (get() == 0 && compareAndSet(0, 1)) {
                                                this.f16854n.onNext(obj);
                                                if (!compareAndSet(1, 0)) {
                                                    this.f8400k.tryTerminateConsumer(this.f16854n);
                                                    this.f8394e.dispose();
                                                    return;
                                                }
                                            }
                                        } else {
                                            this.f8401l = true;
                                            this.f8390a.setSubscription(new vj0(obj, this.f8390a));
                                        }
                                    }
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    this.f8395f.cancel();
                                    this.f8400k.tryAddThrowableOrReport(th);
                                    this.f8400k.tryTerminateConsumer(this.f16854n);
                                    this.f8394e.dispose();
                                    return;
                                }
                            } else {
                                this.f8401l = true;
                                publisher.subscribe(this.f8390a);
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.f8395f.cancel();
                            this.f8400k.tryAddThrowableOrReport(th2);
                            this.f8400k.tryTerminateConsumer(this.f16854n);
                            this.f8394e.dispose();
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.f8395f.cancel();
                    this.f8400k.tryAddThrowableOrReport(th3);
                    this.f8400k.tryTerminateConsumer(this.f16854n);
                    this.f8394e.dispose();
                    return;
                }
            }
            if (this.f16855o.decrementAndGet() == 0) {
                return;
            }
        }
    }
}
