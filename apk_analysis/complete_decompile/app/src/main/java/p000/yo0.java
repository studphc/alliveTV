package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableRefCount;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class yo0 extends AtomicBoolean implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = -7419642935409022375L;

    /* renamed from: a */
    public final Subscriber f29049a;

    /* renamed from: b */
    public final FlowableRefCount f29050b;

    /* renamed from: c */
    public final xo0 f29051c;

    /* renamed from: d */
    public Subscription f29052d;

    public yo0(Subscriber subscriber, FlowableRefCount flowableRefCount, xo0 xo0Var) {
        this.f29049a = subscriber;
        this.f29050b = flowableRefCount;
        this.f29051c = xo0Var;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f29052d.cancel();
        if (compareAndSet(false, true)) {
            FlowableRefCount flowableRefCount = this.f29050b;
            xo0 xo0Var = this.f29051c;
            synchronized (flowableRefCount) {
                try {
                    xo0 xo0Var2 = flowableRefCount.f18981g;
                    if (xo0Var2 != null && xo0Var2 == xo0Var) {
                        long j = xo0Var.f28668c - 1;
                        xo0Var.f28668c = j;
                        if (j == 0 && xo0Var.f28669d) {
                            if (flowableRefCount.f18978d == 0) {
                                flowableRefCount.m5278f(xo0Var);
                            } else {
                                SequentialDisposable sequentialDisposable = new SequentialDisposable();
                                xo0Var.f28667b = sequentialDisposable;
                                sequentialDisposable.replace(flowableRefCount.f18980f.scheduleDirect(xo0Var, flowableRefCount.f18978d, flowableRefCount.f18979e));
                            }
                        }
                    }
                } finally {
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (compareAndSet(false, true)) {
            this.f29050b.m5277e(this.f29051c);
            this.f29049a.onComplete();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (compareAndSet(false, true)) {
            this.f29050b.m5277e(this.f29051c);
            this.f29049a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f29049a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f29052d, subscription)) {
            this.f29052d = subscription;
            this.f29049a.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        this.f29052d.request(j);
    }
}
