package p000;

import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class vj0 extends AtomicBoolean implements Subscription {
    private static final long serialVersionUID = -7606889335172043256L;

    /* renamed from: a */
    public final Subscriber f27813a;

    /* renamed from: b */
    public final Object f27814b;

    public vj0(Object obj, Subscriber subscriber) {
        this.f27814b = obj;
        this.f27813a = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (j > 0 && compareAndSet(false, true)) {
            Object obj = this.f27814b;
            Subscriber subscriber = this.f27813a;
            subscriber.onNext(obj);
            subscriber.onComplete();
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
    }
}
