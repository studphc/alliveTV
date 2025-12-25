package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class xq0 extends AtomicInteger implements FlowableSubscriber, Subscription {

    /* renamed from: k */
    public static final wq0 f28685k = new wq0(null);
    private static final long serialVersionUID = -5402190102429853762L;

    /* renamed from: a */
    public final Subscriber f28686a;

    /* renamed from: b */
    public final Function f28687b;

    /* renamed from: c */
    public final boolean f28688c;

    /* renamed from: d */
    public final AtomicThrowable f28689d = new AtomicThrowable();

    /* renamed from: e */
    public final AtomicLong f28690e = new AtomicLong();

    /* renamed from: f */
    public final AtomicReference f28691f = new AtomicReference();

    /* renamed from: g */
    public Subscription f28692g;

    /* renamed from: h */
    public volatile boolean f28693h;

    /* renamed from: i */
    public volatile boolean f28694i;

    /* renamed from: j */
    public long f28695j;

    public xq0(Subscriber subscriber, Function function, boolean z) {
        this.f28686a = subscriber;
        this.f28687b = function;
        this.f28688c = z;
    }

    /* renamed from: a */
    public final void m8177a() {
        AtomicReference atomicReference = this.f28691f;
        wq0 wq0Var = f28685k;
        wq0 wq0Var2 = (wq0) atomicReference.getAndSet(wq0Var);
        if (wq0Var2 != null && wq0Var2 != wq0Var) {
            DisposableHelper.dispose(wq0Var2);
        }
    }

    /* renamed from: b */
    public final void m8178b() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        Subscriber<?> subscriber = this.f28686a;
        AtomicThrowable atomicThrowable = this.f28689d;
        AtomicReference atomicReference = this.f28691f;
        AtomicLong atomicLong = this.f28690e;
        long j = this.f28695j;
        int i = 1;
        while (!this.f28694i) {
            if (atomicThrowable.get() != null && !this.f28688c) {
                atomicThrowable.tryTerminateConsumer(subscriber);
                return;
            }
            boolean z2 = this.f28693h;
            wq0 wq0Var = (wq0) atomicReference.get();
            if (wq0Var == null) {
                z = true;
            } else {
                z = false;
            }
            if (z2 && z) {
                atomicThrowable.tryTerminateConsumer(subscriber);
                return;
            }
            if (!z && wq0Var.f28283b != null && j != atomicLong.get()) {
                while (!atomicReference.compareAndSet(wq0Var, null) && atomicReference.get() == wq0Var) {
                }
                subscriber.onNext(wq0Var.f28283b);
                j++;
            } else {
                this.f28695j = j;
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f28694i = true;
        this.f28692g.cancel();
        m8177a();
        this.f28689d.tryTerminateAndReport();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f28693h = true;
        m8178b();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f28689d.tryAddThrowableOrReport(th)) {
            if (!this.f28688c) {
                m8177a();
            }
            this.f28693h = true;
            m8178b();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        wq0 wq0Var = f28685k;
        AtomicReference atomicReference = this.f28691f;
        wq0 wq0Var2 = (wq0) atomicReference.get();
        if (wq0Var2 != null) {
            DisposableHelper.dispose(wq0Var2);
        }
        try {
            Object apply = this.f28687b.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
            MaybeSource maybeSource = (MaybeSource) apply;
            wq0 wq0Var3 = new wq0(this);
            while (true) {
                wq0 wq0Var4 = (wq0) atomicReference.get();
                if (wq0Var4 == wq0Var) {
                    return;
                }
                while (!atomicReference.compareAndSet(wq0Var4, wq0Var3)) {
                    if (atomicReference.get() != wq0Var4) {
                        break;
                    }
                }
                maybeSource.subscribe(wq0Var3);
                return;
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f28692g.cancel();
            atomicReference.getAndSet(wq0Var);
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f28692g, subscription)) {
            this.f28692g = subscription;
            this.f28686a.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        BackpressureHelper.add(this.f28690e, j);
        m8178b();
    }
}
