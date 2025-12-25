package p000;

import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainSubscriber;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.operators.SimpleQueue;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ak0 extends ConcatMapXMainSubscriber implements Subscription {
    private static final long serialVersionUID = -9140123220065488293L;

    /* renamed from: i */
    public final Subscriber f234i;

    /* renamed from: j */
    public final Function f235j;

    /* renamed from: k */
    public final AtomicLong f236k;

    /* renamed from: l */
    public final zj0 f237l;

    /* renamed from: m */
    public long f238m;

    /* renamed from: n */
    public int f239n;

    /* renamed from: o */
    public Object f240o;

    /* renamed from: p */
    public volatile int f241p;

    public ak0(Subscriber subscriber, Function function, int i, ErrorMode errorMode) {
        super(i, errorMode);
        this.f234i = subscriber;
        this.f235j = function;
        this.f236k = new AtomicLong();
        this.f237l = new zj0(this);
    }

    @Override // io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainSubscriber
    /* renamed from: a */
    public final void mo109a() {
        this.f240o = null;
    }

    @Override // io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainSubscriber
    /* renamed from: b */
    public final void mo110b() {
        zj0 zj0Var = this.f237l;
        zj0Var.getClass();
        DisposableHelper.dispose(zj0Var);
    }

    @Override // io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainSubscriber
    /* renamed from: c */
    public final void mo111c() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        Subscriber<?> subscriber = this.f234i;
        ErrorMode errorMode = this.f19243c;
        SimpleQueue simpleQueue = this.f19244d;
        AtomicThrowable atomicThrowable = this.f19241a;
        AtomicLong atomicLong = this.f236k;
        int i = this.f19242b;
        int i2 = i - (i >> 1);
        boolean z2 = this.f19248h;
        int i3 = 1;
        while (true) {
            if (this.f19247g) {
                simpleQueue.clear();
                this.f240o = null;
            } else {
                int i4 = this.f241p;
                if (atomicThrowable.get() == null || (errorMode != ErrorMode.IMMEDIATE && (errorMode != ErrorMode.BOUNDARY || i4 != 0))) {
                    if (i4 == 0) {
                        boolean z3 = this.f19246f;
                        try {
                            Object poll = simpleQueue.poll();
                            if (poll == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z3 && z) {
                                atomicThrowable.tryTerminateConsumer(subscriber);
                                return;
                            }
                            if (!z) {
                                if (!z2) {
                                    int i5 = this.f239n + 1;
                                    if (i5 == i2) {
                                        this.f239n = 0;
                                        this.f19245e.request(i2);
                                    } else {
                                        this.f239n = i5;
                                    }
                                }
                                try {
                                    Object apply = this.f235j.apply(poll);
                                    Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                                    MaybeSource maybeSource = (MaybeSource) apply;
                                    this.f241p = 1;
                                    maybeSource.subscribe(this.f237l);
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    this.f19245e.cancel();
                                    simpleQueue.clear();
                                    atomicThrowable.tryAddThrowableOrReport(th);
                                    atomicThrowable.tryTerminateConsumer(subscriber);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.f19245e.cancel();
                            atomicThrowable.tryAddThrowableOrReport(th2);
                            atomicThrowable.tryTerminateConsumer(subscriber);
                            return;
                        }
                    } else if (i4 == 2) {
                        long j = this.f238m;
                        if (j != atomicLong.get()) {
                            Object obj = this.f240o;
                            this.f240o = null;
                            subscriber.onNext(obj);
                            this.f238m = j + 1;
                            this.f241p = 0;
                        }
                    }
                }
            }
            i3 = addAndGet(-i3);
            if (i3 == 0) {
                return;
            }
        }
        simpleQueue.clear();
        this.f240o = null;
        atomicThrowable.tryTerminateConsumer(subscriber);
    }

    @Override // io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainSubscriber
    /* renamed from: d */
    public final void mo112d() {
        this.f234i.onSubscribe(this);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        BackpressureHelper.add(this.f236k, j);
        mo111c();
    }
}
