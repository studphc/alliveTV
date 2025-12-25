package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class l22 extends AtomicReference implements FlowableSubscriber {
    private static final long serialVersionUID = 8410034718427740355L;

    /* renamed from: a */
    public final n22 f22303a;

    /* renamed from: b */
    public final int f22304b;

    /* renamed from: c */
    public final int f22305c;

    /* renamed from: d */
    public long f22306d;

    /* renamed from: e */
    public volatile SpscArrayQueue f22307e;

    public l22(n22 n22Var, int i) {
        this.f22303a = n22Var;
        this.f22304b = i;
        this.f22305c = i - (i >> 2);
    }

    /* renamed from: a */
    public final SimplePlainQueue m5817a() {
        SpscArrayQueue spscArrayQueue = this.f22307e;
        if (spscArrayQueue == null) {
            SpscArrayQueue spscArrayQueue2 = new SpscArrayQueue(this.f22304b);
            this.f22307e = spscArrayQueue2;
            return spscArrayQueue2;
        }
        return spscArrayQueue;
    }

    /* renamed from: b */
    public final void m5818b() {
        long j = this.f22306d + 1;
        if (j == this.f22305c) {
            this.f22306d = 0L;
            ((Subscription) get()).request(j);
        } else {
            this.f22306d = j;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f22303a.mo6011d();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f22303a.mo6012e(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f22303a.mo6013f(this, obj);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, this.f22304b);
    }
}
