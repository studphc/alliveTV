package p000;

import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import java.util.function.BiConsumer;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class km0 extends DeferredScalarSubscription implements BiConsumer {
    private static final long serialVersionUID = 4665335664328839859L;

    /* renamed from: a */
    public final jm0 f20896a;

    public km0(Subscriber subscriber, jm0 jm0Var) {
        super(subscriber);
        this.f20896a = jm0Var;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        Throwable th = (Throwable) obj2;
        if (th != null) {
            this.downstream.onError(th);
        } else if (obj != null) {
            complete(obj);
        } else {
            this.downstream.onError(new NullPointerException("The CompletionStage terminated with null."));
        }
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public final void cancel() {
        super.cancel();
        this.f20896a.set(null);
    }
}
