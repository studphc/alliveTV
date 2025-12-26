package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public abstract class ck0 extends AtomicInteger implements FlowableSubscriber, uj0, Subscription, Runnable {
    private static final long serialVersionUID = -3511336836796789179L;

    /* renamed from: b */
    public final Function f8391b;

    /* renamed from: c */
    public final int f8392c;

    /* renamed from: d */
    public final int f8393d;

    /* renamed from: e */
    public final Scheduler.Worker f8394e;

    /* renamed from: f */
    public Subscription f8395f;

    /* renamed from: g */
    public int f8396g;

    /* renamed from: h */
    public SimpleQueue f8397h;

    /* renamed from: i */
    public volatile boolean f8398i;

    /* renamed from: j */
    public volatile boolean f8399j;

    /* renamed from: l */
    public volatile boolean f8401l;

    /* renamed from: m */
    public int f8402m;

    /* renamed from: a */
    public final tj0 f8390a = new tj0(this);

    /* renamed from: k */
    public final AtomicThrowable f8400k = new AtomicThrowable();

    public ck0(Function function, int i, Scheduler.Worker worker) {
        this.f8391b = function;
        this.f8392c = i;
        this.f8393d = i - (i >> 2);
        this.f8394e = worker;
    }

    @Override // p000.uj0
    /* renamed from: b */
    public final void mo2260b() {
        this.f8401l = false;
        mo2261d();
    }

    /* renamed from: d */
    public abstract void mo2261d();

    /* renamed from: e */
    public abstract void mo2262e();

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f8398i = true;
        mo2261d();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f8402m != 2 && !this.f8397h.offer(obj)) {
            this.f8395f.cancel();
            onError(new IllegalStateException("Queue full?!"));
        } else {
            mo2261d();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f8395f, subscription)) {
            this.f8395f = subscription;
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(7);
                if (requestFusion == 1) {
                    this.f8402m = requestFusion;
                    this.f8397h = queueSubscription;
                    this.f8398i = true;
                    mo2262e();
                    mo2261d();
                    return;
                }
                if (requestFusion == 2) {
                    this.f8402m = requestFusion;
                    this.f8397h = queueSubscription;
                    mo2262e();
                    subscription.request(this.f8392c);
                    return;
                }
            }
            this.f8397h = new SpscArrayQueue(this.f8392c);
            mo2262e();
            subscription.request(this.f8392c);
        }
    }
}
