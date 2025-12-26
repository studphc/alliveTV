package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ns0 extends AtomicReference implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = -4627193790118206028L;

    /* renamed from: a */
    public final ms0 f23473a;

    /* renamed from: b */
    public final int f23474b;

    /* renamed from: c */
    public final int f23475c;

    /* renamed from: d */
    public SimpleQueue f23476d;

    /* renamed from: e */
    public long f23477e;

    /* renamed from: f */
    public volatile boolean f23478f;

    /* renamed from: g */
    public int f23479g;

    public ns0(ms0 ms0Var, int i) {
        this.f23473a = ms0Var;
        this.f23474b = i;
        this.f23475c = i - (i >> 2);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f23478f = true;
        this.f23473a.m6245b();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        ms0 ms0Var = this.f23473a;
        if (ms0Var.f23097e.tryAddThrowableOrReport(th)) {
            this.f23478f = true;
            ms0Var.m6245b();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f23479g != 2) {
            this.f23476d.offer(obj);
        }
        this.f23473a.m6245b();
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(7);
                if (requestFusion == 1) {
                    this.f23479g = requestFusion;
                    this.f23476d = queueSubscription;
                    this.f23478f = true;
                    this.f23473a.m6245b();
                    return;
                }
                if (requestFusion == 2) {
                    this.f23479g = requestFusion;
                    this.f23476d = queueSubscription;
                    subscription.request(this.f23474b);
                    return;
                }
            }
            this.f23476d = new SpscArrayQueue(this.f23474b);
            subscription.request(this.f23474b);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (this.f23479g != 1) {
            long j2 = this.f23477e + j;
            if (j2 >= this.f23475c) {
                this.f23477e = 0L;
                ((Subscription) get()).request(j2);
            } else {
                this.f23477e = j2;
            }
        }
    }
}
