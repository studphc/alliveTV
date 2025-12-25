package p000;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.processors.ReplayProcessor;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ta2 extends AtomicInteger implements Subscription {
    private static final long serialVersionUID = 466549804534799122L;

    /* renamed from: a */
    public final Subscriber f26750a;

    /* renamed from: b */
    public final ReplayProcessor f26751b;

    /* renamed from: c */
    public Serializable f26752c;

    /* renamed from: d */
    public final AtomicLong f26753d = new AtomicLong();

    /* renamed from: e */
    public volatile boolean f26754e;

    /* renamed from: f */
    public long f26755f;

    public ta2(Subscriber subscriber, ReplayProcessor replayProcessor) {
        this.f26750a = subscriber;
        this.f26751b = replayProcessor;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (!this.f26754e) {
            this.f26754e = true;
            this.f26751b.m5315e(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f26753d, j);
            this.f26751b.f20071b.mo7353e(this);
        }
    }
}
