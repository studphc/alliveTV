package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class yk0 extends AtomicLong implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = -9102637559663639004L;

    /* renamed from: a */
    public final SerializedSubscriber f28993a;

    /* renamed from: b */
    public final long f28994b;

    /* renamed from: c */
    public final TimeUnit f28995c;

    /* renamed from: d */
    public final Scheduler.Worker f28996d;

    /* renamed from: e */
    public Subscription f28997e;

    /* renamed from: f */
    public xk0 f28998f;

    /* renamed from: g */
    public volatile long f28999g;

    /* renamed from: h */
    public boolean f29000h;

    public yk0(SerializedSubscriber serializedSubscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker) {
        this.f28993a = serializedSubscriber;
        this.f28994b = j;
        this.f28995c = timeUnit;
        this.f28996d = worker;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f28997e.cancel();
        this.f28996d.dispose();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f29000h) {
            return;
        }
        this.f29000h = true;
        xk0 xk0Var = this.f28998f;
        if (xk0Var != null) {
            DisposableHelper.dispose(xk0Var);
        }
        if (xk0Var != null) {
            xk0Var.m8171a();
        }
        this.f28993a.onComplete();
        this.f28996d.dispose();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f29000h) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f29000h = true;
        xk0 xk0Var = this.f28998f;
        if (xk0Var != null) {
            DisposableHelper.dispose(xk0Var);
        }
        this.f28993a.onError(th);
        this.f28996d.dispose();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f29000h) {
            return;
        }
        long j = this.f28999g + 1;
        this.f28999g = j;
        xk0 xk0Var = this.f28998f;
        if (xk0Var != null) {
            DisposableHelper.dispose(xk0Var);
        }
        xk0 xk0Var2 = new xk0(obj, j, this);
        this.f28998f = xk0Var2;
        DisposableHelper.replace(xk0Var2, this.f28996d.schedule(xk0Var2, this.f28994b, this.f28995c));
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f28997e, subscription)) {
            this.f28997e = subscription;
            this.f28993a.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this, j);
        }
    }
}
