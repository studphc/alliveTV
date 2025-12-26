package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class er0 extends AtomicReference implements FlowableSubscriber {
    private static final long serialVersionUID = -3592821756711087922L;

    /* renamed from: a */
    public final /* synthetic */ fr0 f16956a;

    public er0(fr0 fr0Var) {
        this.f16956a = fr0Var;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        fr0 fr0Var = this.f16956a;
        SubscriptionHelper.cancel(fr0Var.f17371c);
        HalfSerializer.onComplete((Subscriber<?>) fr0Var.f17369a, fr0Var, fr0Var.f17372d);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        fr0 fr0Var = this.f16956a;
        SubscriptionHelper.cancel(fr0Var.f17371c);
        HalfSerializer.onError((Subscriber<?>) fr0Var.f17369a, th, fr0Var, fr0Var.f17372d);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        SubscriptionHelper.cancel(this);
        onComplete();
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
    }
}
