package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class dk0 extends ck0 {
    private static final long serialVersionUID = -2945777694260521066L;

    /* renamed from: n */
    public final Subscriber f16397n;

    /* renamed from: o */
    public final boolean f16398o;

    public dk0(Subscriber subscriber, Function function, int i, boolean z, Scheduler.Worker worker) {
        super(function, i, worker);
        this.f16397n = subscriber;
        this.f16398o = z;
    }

    @Override // p000.uj0
    /* renamed from: a */
    public final void mo4587a(Throwable th) {
        if (this.f8400k.tryAddThrowableOrReport(th)) {
            if (!this.f16398o) {
                this.f8395f.cancel();
                this.f8398i = true;
            }
            this.f8401l = false;
            mo2261d();
        }
    }

    @Override // p000.uj0
    /* renamed from: c */
    public final void mo4588c(Object obj) {
        this.f16397n.onNext(obj);
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
        if (getAndIncrement() == 0) {
            this.f8394e.schedule(this);
        }
    }

    @Override // p000.ck0
    /* renamed from: e */
    public final void mo2262e() {
        this.f16397n.onSubscribe(this);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f8400k.tryAddThrowableOrReport(th)) {
            this.f8398i = true;
            mo2261d();
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        this.f8390a.request(j);
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        Object obj;
        while (!this.f8399j) {
            if (!this.f8401l) {
                boolean z2 = this.f8398i;
                if (z2 && !this.f16398o && this.f8400k.get() != null) {
                    this.f8400k.tryTerminateConsumer(this.f16397n);
                    this.f8394e.dispose();
                    return;
                }
                try {
                    Object poll = this.f8397h.poll();
                    if (poll == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z2 && z) {
                        this.f8400k.tryTerminateConsumer(this.f16397n);
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
                                    obj = ((Supplier) publisher).get();
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    this.f8400k.tryAddThrowableOrReport(th);
                                    if (!this.f16398o) {
                                        this.f8395f.cancel();
                                        this.f8400k.tryTerminateConsumer(this.f16397n);
                                        this.f8394e.dispose();
                                        return;
                                    }
                                    obj = null;
                                }
                                if (obj != null && !this.f8399j) {
                                    if (this.f8390a.isUnbounded()) {
                                        this.f16397n.onNext(obj);
                                    } else {
                                        this.f8401l = true;
                                        this.f8390a.setSubscription(new vj0(obj, this.f8390a));
                                    }
                                }
                            } else {
                                this.f8401l = true;
                                publisher.subscribe(this.f8390a);
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.f8395f.cancel();
                            this.f8400k.tryAddThrowableOrReport(th2);
                            this.f8400k.tryTerminateConsumer(this.f16397n);
                            this.f8394e.dispose();
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.f8395f.cancel();
                    this.f8400k.tryAddThrowableOrReport(th3);
                    this.f8400k.tryTerminateConsumer(this.f16397n);
                    this.f8394e.dispose();
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }
}
