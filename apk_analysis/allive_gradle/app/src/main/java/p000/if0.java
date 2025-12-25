package p000;

import java.util.concurrent.Flow;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class if0 implements Subscriber {

    /* renamed from: a */
    public final Flow.Subscriber f18393a;

    public if0(Flow.Subscriber subscriber) {
        this.f18393a = subscriber;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f18393a.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f18393a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f18393a.onNext(obj);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        ff0 ff0Var;
        Flow.Subscriber subscriber = this.f18393a;
        if (subscription == null) {
            ff0Var = null;
        } else {
            ff0Var = new ff0(subscription);
        }
        subscriber.onSubscribe(ff0Var);
    }
}
