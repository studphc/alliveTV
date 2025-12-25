package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public abstract class qj0 extends AtomicInteger implements FlowableSubscriber, uj0, Subscription {
    private static final long serialVersionUID = -3511336836796789179L;

    /* renamed from: b */
    public final Function f25612b;

    /* renamed from: c */
    public final int f25613c;

    /* renamed from: d */
    public final int f25614d;

    /* renamed from: e */
    public Subscription f25615e;

    /* renamed from: f */
    public int f25616f;

    /* renamed from: g */
    public SimpleQueue f25617g;

    /* renamed from: h */
    public volatile boolean f25618h;

    /* renamed from: i */
    public volatile boolean f25619i;

    /* renamed from: k */
    public volatile boolean f25621k;

    /* renamed from: l */
    public int f25622l;

    /* renamed from: a */
    public final tj0 f25611a = new tj0(this);

    /* renamed from: j */
    public final AtomicThrowable f25620j = new AtomicThrowable();

    public qj0(Function function, int i) {
        this.f25612b = function;
        this.f25613c = i;
        this.f25614d = i - (i >> 2);
    }

    @Override // p000.uj0
    /* renamed from: b */
    public final void mo2260b() {
        this.f25621k = false;
        mo7071d();
    }

    /* renamed from: d */
    public abstract void mo7071d();

    /* renamed from: e */
    public abstract void mo7072e();

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f25618h = true;
        mo7071d();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f25622l != 2 && !this.f25617g.offer(obj)) {
            this.f25615e.cancel();
            onError(new IllegalStateException("Queue full?!"));
        } else {
            mo7071d();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f25615e, subscription)) {
            this.f25615e = subscription;
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(7);
                if (requestFusion == 1) {
                    this.f25622l = requestFusion;
                    this.f25617g = queueSubscription;
                    this.f25618h = true;
                    mo7072e();
                    mo7071d();
                    return;
                }
                if (requestFusion == 2) {
                    this.f25622l = requestFusion;
                    this.f25617g = queueSubscription;
                    mo7072e();
                    subscription.request(this.f25613c);
                    return;
                }
            }
            this.f25617g = new SpscArrayQueue(this.f25613c);
            mo7072e();
            subscription.request(this.f25613c);
        }
    }
}
