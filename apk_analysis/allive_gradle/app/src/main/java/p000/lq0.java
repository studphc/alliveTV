package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class lq0 extends AtomicReference implements FlowableSubscriber {
    private static final long serialVersionUID = -5592042965931999169L;

    /* renamed from: a */
    public final /* synthetic */ mq0 f22636a;

    public lq0(mq0 mq0Var) {
        this.f22636a = mq0Var;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f22636a.f23057f = true;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        mq0 mq0Var = this.f22636a;
        SubscriptionHelper.cancel(mq0Var.f23053b);
        HalfSerializer.onError((Subscriber<?>) mq0Var.f23052a, th, mq0Var, mq0Var.f23056e);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f22636a.f23057f = true;
        ((Subscription) get()).cancel();
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
    }
}
