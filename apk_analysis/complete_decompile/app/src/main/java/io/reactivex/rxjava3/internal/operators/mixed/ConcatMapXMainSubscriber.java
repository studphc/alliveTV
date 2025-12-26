package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public abstract class ConcatMapXMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -3214213361171757852L;

    /* renamed from: a */
    public final AtomicThrowable f19241a = new AtomicThrowable();

    /* renamed from: b */
    public final int f19242b;

    /* renamed from: c */
    public final ErrorMode f19243c;

    /* renamed from: d */
    public SimpleQueue f19244d;

    /* renamed from: e */
    public Subscription f19245e;

    /* renamed from: f */
    public volatile boolean f19246f;

    /* renamed from: g */
    public volatile boolean f19247g;

    /* renamed from: h */
    public boolean f19248h;

    public ConcatMapXMainSubscriber(int i, ErrorMode errorMode) {
        this.f19243c = errorMode;
        this.f19242b = i;
    }

    /* renamed from: a */
    public void mo109a() {
    }

    /* renamed from: b */
    public abstract void mo110b();

    /* renamed from: c */
    public abstract void mo111c();

    public void cancel() {
        m5290e();
    }

    /* renamed from: d */
    public abstract void mo112d();

    public void dispose() {
        m5290e();
    }

    /* renamed from: e */
    public final void m5290e() {
        this.f19247g = true;
        this.f19245e.cancel();
        mo110b();
        this.f19241a.tryTerminateAndReport();
        if (getAndIncrement() == 0) {
            this.f19244d.clear();
            mo109a();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f19246f = true;
        mo111c();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f19241a.tryAddThrowableOrReport(th)) {
            if (this.f19243c == ErrorMode.IMMEDIATE) {
                mo110b();
            }
            this.f19246f = true;
            mo111c();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(T t) {
        if (t != null && !this.f19244d.offer(t)) {
            this.f19245e.cancel();
            onError(new MissingBackpressureException("queue full?!"));
        } else {
            mo111c();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f19245e, subscription)) {
            this.f19245e = subscription;
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(7);
                if (requestFusion == 1) {
                    this.f19244d = queueSubscription;
                    this.f19248h = true;
                    this.f19246f = true;
                    mo112d();
                    mo111c();
                    return;
                }
                if (requestFusion == 2) {
                    this.f19244d = queueSubscription;
                    mo112d();
                    this.f19245e.request(this.f19242b);
                    return;
                }
            }
            this.f19244d = new SpscArrayQueue(this.f19242b);
            mo112d();
            this.f19245e.request(this.f19242b);
        }
    }
}
