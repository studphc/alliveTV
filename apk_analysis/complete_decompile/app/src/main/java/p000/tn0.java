package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class tn0 extends AtomicInteger implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = -4592979584110982903L;

    /* renamed from: a */
    public final Subscriber f26893a;

    /* renamed from: b */
    public final AtomicReference f26894b = new AtomicReference();

    /* renamed from: c */
    public final sn0 f26895c = new sn0(this);

    /* renamed from: d */
    public final AtomicThrowable f26896d = new AtomicThrowable();

    /* renamed from: e */
    public final AtomicLong f26897e = new AtomicLong();

    /* renamed from: f */
    public volatile boolean f26898f;

    /* renamed from: g */
    public volatile boolean f26899g;

    public tn0(Subscriber subscriber) {
        this.f26893a = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        SubscriptionHelper.cancel(this.f26894b);
        DisposableHelper.dispose(this.f26895c);
        this.f26896d.tryTerminateAndReport();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f26898f = true;
        if (this.f26899g) {
            HalfSerializer.onComplete((Subscriber<?>) this.f26893a, this, this.f26896d);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        DisposableHelper.dispose(this.f26895c);
        HalfSerializer.onError((Subscriber<?>) this.f26893a, th, this, this.f26896d);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        HalfSerializer.onNext((Subscriber<? super Object>) this.f26893a, obj, this, this.f26896d);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.f26894b, this.f26897e, subscription);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        SubscriptionHelper.deferredRequest(this.f26894b, this.f26897e, j);
    }
}
