package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class pr0 extends AtomicLong implements FlowableSubscriber, Subscription, qr0 {
    private static final long serialVersionUID = 3764492702657003550L;

    /* renamed from: a */
    public final Subscriber f25265a;

    /* renamed from: b */
    public final long f25266b;

    /* renamed from: c */
    public final TimeUnit f25267c;

    /* renamed from: d */
    public final Scheduler.Worker f25268d;

    /* renamed from: e */
    public final SequentialDisposable f25269e = new SequentialDisposable();

    /* renamed from: f */
    public final AtomicReference f25270f = new AtomicReference();

    /* renamed from: g */
    public final AtomicLong f25271g = new AtomicLong();

    public pr0(Subscriber subscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker) {
        this.f25265a = subscriber;
        this.f25266b = j;
        this.f25267c = timeUnit;
        this.f25268d = worker;
    }

    @Override // p000.qr0
    /* renamed from: a */
    public final void mo5780a(long j) {
        if (compareAndSet(j, Long.MAX_VALUE)) {
            SubscriptionHelper.cancel(this.f25270f);
            this.f25265a.onError(new TimeoutException(ExceptionHelper.timeoutMessage(this.f25266b, this.f25267c)));
            this.f25268d.dispose();
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        SubscriptionHelper.cancel(this.f25270f);
        this.f25268d.dispose();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.f25269e.dispose();
            this.f25265a.onComplete();
            this.f25268d.dispose();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.f25269e.dispose();
            this.f25265a.onError(th);
            this.f25268d.dispose();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        long j = get();
        if (j != Long.MAX_VALUE) {
            long j2 = 1 + j;
            if (compareAndSet(j, j2)) {
                SequentialDisposable sequentialDisposable = this.f25269e;
                sequentialDisposable.get().dispose();
                this.f25265a.onNext(obj);
                sequentialDisposable.replace(this.f25268d.schedule(new pq0(j2, this), this.f25266b, this.f25267c));
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.f25270f, this.f25271g, subscription);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        SubscriptionHelper.deferredRequest(this.f25270f, this.f25271g, j);
    }
}
