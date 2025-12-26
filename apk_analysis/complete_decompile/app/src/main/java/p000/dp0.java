package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.io.Serializable;

/* loaded from: classes2.dex */
public abstract class dp0 extends SubscriptionArbiter implements FlowableSubscriber {
    private static final long serialVersionUID = -5604623027276966720L;

    /* renamed from: h */
    public final SerializedSubscriber f16464h;

    /* renamed from: i */
    public final FlowableProcessor f16465i;

    /* renamed from: j */
    public final cp0 f16466j;

    /* renamed from: k */
    public long f16467k;

    public dp0(SerializedSubscriber serializedSubscriber, FlowableProcessor flowableProcessor, cp0 cp0Var) {
        super(false);
        this.f16464h = serializedSubscriber;
        this.f16465i = flowableProcessor;
        this.f16466j = cp0Var;
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
    public final void cancel() {
        super.cancel();
        this.f16466j.cancel();
    }

    /* renamed from: d */
    public final void m4597d(Serializable serializable) {
        setSubscription(EmptySubscription.INSTANCE);
        long j = this.f16467k;
        if (j != 0) {
            this.f16467k = 0L;
            produced(j);
        }
        this.f16466j.request(1L);
        this.f16465i.onNext(serializable);
    }

    public void onError(Throwable th) {
        m4597d(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f16467k++;
        this.f16464h.onNext(obj);
    }
}
