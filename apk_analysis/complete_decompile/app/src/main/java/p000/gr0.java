package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class gr0 extends AtomicLong implements FlowableSubscriber, Subscription, Runnable {
    private static final long serialVersionUID = -9102637559663639004L;

    /* renamed from: a */
    public final SerializedSubscriber f17801a;

    /* renamed from: b */
    public final long f17802b;

    /* renamed from: c */
    public final TimeUnit f17803c;

    /* renamed from: d */
    public final Scheduler.Worker f17804d;

    /* renamed from: e */
    public Subscription f17805e;

    /* renamed from: f */
    public final SequentialDisposable f17806f = new SequentialDisposable();

    /* renamed from: g */
    public volatile boolean f17807g;

    /* renamed from: h */
    public boolean f17808h;

    public gr0(SerializedSubscriber serializedSubscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker) {
        this.f17801a = serializedSubscriber;
        this.f17802b = j;
        this.f17803c = timeUnit;
        this.f17804d = worker;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f17805e.cancel();
        this.f17804d.dispose();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f17808h) {
            return;
        }
        this.f17808h = true;
        this.f17801a.onComplete();
        this.f17804d.dispose();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f17808h) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f17808h = true;
        this.f17801a.onError(th);
        this.f17804d.dispose();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (!this.f17808h && !this.f17807g) {
            this.f17807g = true;
            if (get() != 0) {
                this.f17801a.onNext(obj);
                BackpressureHelper.produced(this, 1L);
                Disposable disposable = this.f17806f.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                this.f17806f.replace(this.f17804d.schedule(this, this.f17802b, this.f17803c));
                return;
            }
            this.f17808h = true;
            cancel();
            this.f17801a.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f17805e, subscription)) {
            this.f17805e = subscription;
            this.f17801a.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this, j);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17807g = false;
    }
}
