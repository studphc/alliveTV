package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class sj0 extends qj0 {
    private static final long serialVersionUID = 7898995095634264146L;

    /* renamed from: m */
    public final Subscriber f26450m;

    /* renamed from: n */
    public final AtomicInteger f26451n;

    public sj0(Subscriber subscriber, Function function, int i) {
        super(function, i);
        this.f26450m = subscriber;
        this.f26451n = new AtomicInteger();
    }

    @Override // p000.uj0
    /* renamed from: a */
    public final void mo4587a(Throwable th) {
        this.f25615e.cancel();
        HalfSerializer.onError((Subscriber<?>) this.f26450m, th, this, this.f25620j);
    }

    @Override // p000.uj0
    /* renamed from: c */
    public final void mo4588c(Object obj) {
        HalfSerializer.onNext((Subscriber<? super Object>) this.f26450m, obj, this, this.f25620j);
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
        if (this.f26451n.getAndIncrement() == 0) {
            while (!this.f25619i) {
                if (!this.f25621k) {
                    boolean z2 = this.f25618h;
                    try {
                        Object poll = this.f25617g.poll();
                        if (poll == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z2 && z) {
                            this.f26450m.onComplete();
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
                                        Object obj = ((Supplier) publisher).get();
                                        if (obj == null) {
                                            continue;
                                        } else if (this.f25611a.isUnbounded()) {
                                            if (!HalfSerializer.onNext((Subscriber<? super Object>) this.f26450m, obj, this, this.f25620j)) {
                                                return;
                                            }
                                        } else {
                                            this.f25621k = true;
                                            this.f25611a.setSubscription(new vj0(obj, this.f25611a));
                                        }
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        this.f25615e.cancel();
                                        this.f25620j.tryAddThrowableOrReport(th);
                                        this.f25620j.tryTerminateConsumer(this.f26450m);
                                        return;
                                    }
                                } else {
                                    this.f25621k = true;
                                    publisher.subscribe(this.f25611a);
                                }
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.f25615e.cancel();
                                this.f25620j.tryAddThrowableOrReport(th2);
                                this.f25620j.tryTerminateConsumer(this.f26450m);
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        this.f25615e.cancel();
                        this.f25620j.tryAddThrowableOrReport(th3);
                        this.f25620j.tryTerminateConsumer(this.f26450m);
                        return;
                    }
                }
                if (this.f26451n.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    @Override // p000.qj0
    /* renamed from: e */
    public final void mo7072e() {
        this.f26450m.onSubscribe(this);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f25611a.cancel();
        HalfSerializer.onError((Subscriber<?>) this.f26450m, th, this, this.f25620j);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        this.f25611a.request(j);
    }
}
