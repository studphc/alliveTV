package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class sq0 extends AtomicReference implements FlowableSubscriber {
    private static final long serialVersionUID = 3837284832786408377L;

    /* renamed from: a */
    public final tq0 f26527a;

    /* renamed from: b */
    public final long f26528b;

    /* renamed from: c */
    public final int f26529c;

    /* renamed from: d */
    public volatile SimpleQueue f26530d;

    /* renamed from: e */
    public volatile boolean f26531e;

    /* renamed from: f */
    public int f26532f;

    public sq0(tq0 tq0Var, long j, int i) {
        this.f26527a = tq0Var;
        this.f26528b = j;
        this.f26529c = i;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        tq0 tq0Var = this.f26527a;
        if (this.f26528b == tq0Var.f26936k) {
            this.f26531e = true;
            tq0Var.m7504b();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        tq0 tq0Var = this.f26527a;
        if (this.f26528b == tq0Var.f26936k && tq0Var.f26931f.tryAddThrowable(th)) {
            if (!tq0Var.f26929d) {
                tq0Var.f26933h.cancel();
                tq0Var.f26930e = true;
            }
            this.f26531e = true;
            tq0Var.m7504b();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        tq0 tq0Var = this.f26527a;
        if (this.f26528b == tq0Var.f26936k) {
            if (this.f26532f == 0 && !this.f26530d.offer(obj)) {
                onError(new MissingBackpressureException("Queue full?!"));
            } else {
                tq0Var.m7504b();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(7);
                if (requestFusion == 1) {
                    this.f26532f = requestFusion;
                    this.f26530d = queueSubscription;
                    this.f26531e = true;
                    this.f26527a.m7504b();
                    return;
                }
                if (requestFusion == 2) {
                    this.f26532f = requestFusion;
                    this.f26530d = queueSubscription;
                    subscription.request(this.f26529c);
                    return;
                }
            }
            this.f26530d = new SpscArrayQueue(this.f26529c);
            subscription.request(this.f26529c);
        }
    }
}
