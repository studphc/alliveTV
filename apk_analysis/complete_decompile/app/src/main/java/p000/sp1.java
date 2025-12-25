package p000;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.processors.MulticastProcessor;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class sp1 extends AtomicLong implements Subscription {
    private static final long serialVersionUID = -363282618957264509L;

    /* renamed from: a */
    public final Subscriber f26519a;

    /* renamed from: b */
    public final MulticastProcessor f26520b;

    /* renamed from: c */
    public long f26521c;

    public sp1(Subscriber subscriber, MulticastProcessor multicastProcessor) {
        this.f26519a = subscriber;
        this.f26520b = multicastProcessor;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
            this.f26520b.m5313f(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            long addCancel = BackpressureHelper.addCancel(this, j);
            if (addCancel != Long.MIN_VALUE && addCancel != Long.MAX_VALUE) {
                this.f26520b.m5312e();
            }
        }
    }
}
