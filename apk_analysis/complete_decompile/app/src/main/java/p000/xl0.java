package p000;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class xl0 extends BasicIntQueueSubscription implements FlowableSubscriber {
    private static final long serialVersionUID = 8443155186132538303L;

    /* renamed from: a */
    public final Subscriber f28611a;

    /* renamed from: c */
    public final Function f28613c;

    /* renamed from: d */
    public final boolean f28614d;

    /* renamed from: f */
    public final int f28616f;

    /* renamed from: g */
    public Subscription f28617g;

    /* renamed from: h */
    public volatile boolean f28618h;

    /* renamed from: b */
    public final AtomicThrowable f28612b = new AtomicThrowable();

    /* renamed from: e */
    public final CompositeDisposable f28615e = new CompositeDisposable();

    public xl0(int i, Function function, Subscriber subscriber, boolean z) {
        this.f28611a = subscriber;
        this.f28613c = function;
        this.f28614d = z;
        this.f28616f = i;
        lazySet(1);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f28618h = true;
        this.f28617g.cancel();
        this.f28615e.dispose();
        this.f28612b.tryTerminateAndReport();
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        return true;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (decrementAndGet() == 0) {
            this.f28612b.tryTerminateConsumer(this.f28611a);
        } else if (this.f28616f != Integer.MAX_VALUE) {
            this.f28617g.request(1L);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f28612b.tryAddThrowableOrReport(th)) {
            if (this.f28614d) {
                if (decrementAndGet() == 0) {
                    this.f28612b.tryTerminateConsumer(this.f28611a);
                    return;
                } else {
                    if (this.f28616f != Integer.MAX_VALUE) {
                        this.f28617g.request(1L);
                        return;
                    }
                    return;
                }
            }
            this.f28618h = true;
            this.f28617g.cancel();
            this.f28615e.dispose();
            this.f28612b.tryTerminateConsumer(this.f28611a);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        try {
            Object apply = this.f28613c.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
            CompletableSource completableSource = (CompletableSource) apply;
            getAndIncrement();
            wl0 wl0Var = new wl0(this);
            if (!this.f28618h && this.f28615e.add(wl0Var)) {
                completableSource.subscribe(wl0Var);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f28617g.cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f28617g, subscription)) {
            this.f28617g = subscription;
            this.f28611a.onSubscribe(this);
            int i = this.f28616f;
            if (i == Integer.MAX_VALUE) {
                subscription.request(Long.MAX_VALUE);
            } else {
                subscription.request(i);
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        return null;
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        return i & 2;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
    }
}
