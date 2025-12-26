package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class fq0 extends AtomicReference implements FlowableSubscriber {
    private static final long serialVersionUID = 4804128302091633067L;

    /* renamed from: a */
    public final AtomicInteger f17362a;

    /* renamed from: b */
    public final int f17363b;

    /* renamed from: c */
    public final int f17364c;

    /* renamed from: d */
    public long f17365d;

    /* renamed from: e */
    public volatile SimpleQueue f17366e;

    /* renamed from: f */
    public volatile boolean f17367f;

    /* renamed from: g */
    public int f17368g;

    /* JADX WARN: Multi-variable type inference failed */
    public fq0(eq0 eq0Var, int i) {
        this.f17362a = (AtomicInteger) eq0Var;
        this.f17364c = i - (i >> 2);
        this.f17363b = i;
    }

    /* renamed from: a */
    public final void m4825a() {
        SimpleQueue simpleQueue = this.f17366e;
        if (simpleQueue != null) {
            simpleQueue.clear();
        }
    }

    /* renamed from: b */
    public final void m4826b() {
        if (this.f17368g != 1) {
            long j = this.f17365d + 1;
            if (j >= this.f17364c) {
                this.f17365d = 0L;
                ((Subscription) get()).request(j);
            } else {
                this.f17365d = j;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.concurrent.atomic.AtomicInteger, eq0] */
    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f17367f = true;
        this.f17362a.drain();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.atomic.AtomicInteger, eq0] */
    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f17362a.mo4601a(th);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.concurrent.atomic.AtomicInteger, eq0] */
    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f17368g == 0 && !this.f17366e.offer(obj)) {
            onError(new MissingBackpressureException());
        } else {
            this.f17362a.drain();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.concurrent.atomic.AtomicInteger, eq0] */
    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.f17368g = requestFusion;
                    this.f17366e = queueSubscription;
                    this.f17367f = true;
                    this.f17362a.drain();
                    return;
                }
                if (requestFusion == 2) {
                    this.f17368g = requestFusion;
                    this.f17366e = queueSubscription;
                    subscription.request(this.f17363b);
                    return;
                }
            }
            this.f17366e = new SpscArrayQueue(this.f17363b);
            subscription.request(this.f17363b);
        }
    }
}
