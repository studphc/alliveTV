package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ql0 extends DeferredScalarSubscription implements FlowableSubscriber {
    private static final long serialVersionUID = 4066607327284737757L;

    /* renamed from: a */
    public final long f25672a;

    /* renamed from: b */
    public final Object f25673b;

    /* renamed from: c */
    public final boolean f25674c;

    /* renamed from: d */
    public Subscription f25675d;

    /* renamed from: e */
    public long f25676e;

    /* renamed from: f */
    public boolean f25677f;

    public ql0(Subscriber subscriber, long j, Object obj, boolean z) {
        super(subscriber);
        this.f25672a = j;
        this.f25673b = obj;
        this.f25674c = z;
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public final void cancel() {
        super.cancel();
        this.f25675d.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (!this.f25677f) {
            this.f25677f = true;
            Object obj = this.f25673b;
            if (obj == null) {
                if (this.f25674c) {
                    this.downstream.onError(new NoSuchElementException());
                    return;
                } else {
                    this.downstream.onComplete();
                    return;
                }
            }
            complete(obj);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f25677f) {
            RxJavaPlugins.onError(th);
        } else {
            this.f25677f = true;
            this.downstream.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f25677f) {
            return;
        }
        long j = this.f25676e;
        if (j == this.f25672a) {
            this.f25677f = true;
            this.f25675d.cancel();
            complete(obj);
            return;
        }
        this.f25676e = j + 1;
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f25675d, subscription)) {
            this.f25675d = subscription;
            this.downstream.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
