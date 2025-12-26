package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleSource;
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
public final class zq0 extends AtomicInteger implements FlowableSubscriber, Subscription {

    /* renamed from: k */
    public static final yq0 f29465k = new yq0(null);
    private static final long serialVersionUID = -5402190102429853762L;

    /* renamed from: a */
    public final Subscriber f29466a;

    /* renamed from: b */
    public final Function f29467b;

    /* renamed from: c */
    public final boolean f29468c;

    /* renamed from: d */
    public final AtomicThrowable f29469d = new AtomicThrowable();

    /* renamed from: e */
    public final AtomicLong f29470e = new AtomicLong();

    /* renamed from: f */
    public final AtomicReference f29471f = new AtomicReference();

    /* renamed from: g */
    public Subscription f29472g;

    /* renamed from: h */
    public volatile boolean f29473h;

    /* renamed from: i */
    public volatile boolean f29474i;

    /* renamed from: j */
    public long f29475j;

    public zq0(Subscriber subscriber, Function function, boolean z) {
        this.f29466a = subscriber;
        this.f29467b = function;
        this.f29468c = z;
    }

    /* renamed from: a */
    public final void m8422a() {
        AtomicReference atomicReference = this.f29471f;
        yq0 yq0Var = f29465k;
        yq0 yq0Var2 = (yq0) atomicReference.getAndSet(yq0Var);
        if (yq0Var2 != null && yq0Var2 != yq0Var) {
            DisposableHelper.dispose(yq0Var2);
        }
    }

    /* renamed from: b */
    public final void m8423b() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        Subscriber<?> subscriber = this.f29466a;
        AtomicThrowable atomicThrowable = this.f29469d;
        AtomicReference atomicReference = this.f29471f;
        AtomicLong atomicLong = this.f29470e;
        long j = this.f29475j;
        int i = 1;
        while (!this.f29474i) {
            if (atomicThrowable.get() != null && !this.f29468c) {
                atomicThrowable.tryTerminateConsumer(subscriber);
                return;
            }
            boolean z2 = this.f29473h;
            yq0 yq0Var = (yq0) atomicReference.get();
            if (yq0Var == null) {
                z = true;
            } else {
                z = false;
            }
            if (z2 && z) {
                atomicThrowable.tryTerminateConsumer(subscriber);
                return;
            }
            if (!z && yq0Var.f29064b != null && j != atomicLong.get()) {
                while (!atomicReference.compareAndSet(yq0Var, null) && atomicReference.get() == yq0Var) {
                }
                subscriber.onNext(yq0Var.f29064b);
                j++;
            } else {
                this.f29475j = j;
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f29474i = true;
        this.f29472g.cancel();
        m8422a();
        this.f29469d.tryTerminateAndReport();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f29473h = true;
        m8423b();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f29469d.tryAddThrowableOrReport(th)) {
            if (!this.f29468c) {
                m8422a();
            }
            this.f29473h = true;
            m8423b();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        yq0 yq0Var = f29465k;
        AtomicReference atomicReference = this.f29471f;
        yq0 yq0Var2 = (yq0) atomicReference.get();
        if (yq0Var2 != null) {
            DisposableHelper.dispose(yq0Var2);
        }
        try {
            Object apply = this.f29467b.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
            SingleSource singleSource = (SingleSource) apply;
            yq0 yq0Var3 = new yq0(this);
            while (true) {
                yq0 yq0Var4 = (yq0) atomicReference.get();
                if (yq0Var4 == yq0Var) {
                    return;
                }
                while (!atomicReference.compareAndSet(yq0Var4, yq0Var3)) {
                    if (atomicReference.get() != yq0Var4) {
                        break;
                    }
                }
                singleSource.subscribe(yq0Var3);
                return;
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f29472g.cancel();
            atomicReference.getAndSet(yq0Var);
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f29472g, subscription)) {
            this.f29472g = subscription;
            this.f29466a.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        BackpressureHelper.add(this.f29470e, j);
        m8423b();
    }
}
