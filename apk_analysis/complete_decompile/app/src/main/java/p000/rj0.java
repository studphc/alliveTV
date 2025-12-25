package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class rj0 extends qj0 {
    private static final long serialVersionUID = -2945777694260521066L;

    /* renamed from: m */
    public final Subscriber f25993m;

    /* renamed from: n */
    public final boolean f25994n;

    public rj0(int i, Function function, Subscriber subscriber, boolean z) {
        super(function, i);
        this.f25993m = subscriber;
        this.f25994n = z;
    }

    @Override // p000.uj0
    /* renamed from: a */
    public final void mo4587a(Throwable th) {
        if (this.f25620j.tryAddThrowableOrReport(th)) {
            if (!this.f25994n) {
                this.f25615e.cancel();
                this.f25618h = true;
            }
            this.f25621k = false;
            mo7071d();
        }
    }

    @Override // p000.uj0
    /* renamed from: c */
    public final void mo4588c(Object obj) {
        this.f25993m.onNext(obj);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (!this.f25619i) {
            this.f25619i = true;
            this.f25611a.cancel();
            this.f25615e.cancel();
            this.f25620j.tryTerminateAndReport();
        }
    }

    @Override // p000.qj0
    /* renamed from: d */
    public final void mo7071d() {
        boolean z;
        Object obj;
        if (getAndIncrement() == 0) {
            while (!this.f25619i) {
                if (!this.f25621k) {
                    boolean z2 = this.f25618h;
                    if (z2 && !this.f25994n && this.f25620j.get() != null) {
                        this.f25620j.tryTerminateConsumer(this.f25993m);
                        return;
                    }
                    try {
                        Object poll = this.f25617g.poll();
                        if (poll == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z2 && z) {
                            this.f25620j.tryTerminateConsumer(this.f25993m);
                            return;
                        }
                        if (!z) {
                            try {
                                Object apply = this.f25612b.apply(poll);
                                Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                                Publisher publisher = (Publisher) apply;
                                if (this.f25622l != 1) {
                                    int i = this.f25616f + 1;
                                    if (i == this.f25614d) {
                                        this.f25616f = 0;
                                        this.f25615e.request(i);
                                    } else {
                                        this.f25616f = i;
                                    }
                                }
                                if (publisher instanceof Supplier) {
                                    try {
                                        obj = ((Supplier) publisher).get();
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        this.f25620j.tryAddThrowableOrReport(th);
                                        if (!this.f25994n) {
                                            this.f25615e.cancel();
                                            this.f25620j.tryTerminateConsumer(this.f25993m);
                                            return;
                                        }
                                        obj = null;
                                    }
                                    if (obj == null) {
                                        continue;
                                    } else if (this.f25611a.isUnbounded()) {
                                        this.f25993m.onNext(obj);
                                    } else {
                                        this.f25621k = true;
                                        this.f25611a.setSubscription(new vj0(obj, this.f25611a));
                                    }
                                } else {
                                    this.f25621k = true;
                                    publisher.subscribe(this.f25611a);
                                }
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.f25615e.cancel();
                                this.f25620j.tryAddThrowableOrReport(th2);
                                this.f25620j.tryTerminateConsumer(this.f25993m);
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        this.f25615e.cancel();
                        this.f25620j.tryAddThrowableOrReport(th3);
                        this.f25620j.tryTerminateConsumer(this.f25993m);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    @Override // p000.qj0
    /* renamed from: e */
    public final void mo7072e() {
        this.f25993m.onSubscribe(this);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f25620j.tryAddThrowableOrReport(th)) {
            this.f25618h = true;
            mo7071d();
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        this.f25611a.request(j);
    }
}
