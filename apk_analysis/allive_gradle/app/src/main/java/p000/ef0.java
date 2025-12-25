package p000;

import java.util.concurrent.Flow;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class ef0 implements Flow.Subscriber {

    /* renamed from: a */
    public final Subscriber f16784a;

    public ef0(Subscriber subscriber) {
        this.f16784a = subscriber;
    }

    @Override // java.util.concurrent.Flow.Subscriber
    public final void onComplete() {
        this.f16784a.onComplete();
    }

    @Override // java.util.concurrent.Flow.Subscriber
    public final void onError(Throwable th) {
        this.f16784a.onError(th);
    }

    @Override // java.util.concurrent.Flow.Subscriber
    public final void onNext(Object obj) {
        this.f16784a.onNext(obj);
    }

    @Override // java.util.concurrent.Flow.Subscriber
    public final void onSubscribe(Flow.Subscription subscription) {
        jf0 jf0Var;
        Subscriber subscriber = this.f16784a;
        if (subscription == null) {
            jf0Var = null;
        } else {
            jf0Var = new jf0(subscription);
        }
        subscriber.onSubscribe(jf0Var);
    }
}
