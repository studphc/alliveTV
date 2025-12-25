package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public abstract class aq0 extends AtomicReference implements FlowableSubscriber, Subscription, Runnable {
    private static final long serialVersionUID = -3517602651313910099L;

    /* renamed from: a */
    public final SerializedSubscriber f7702a;

    /* renamed from: b */
    public final long f7703b;

    /* renamed from: c */
    public final TimeUnit f7704c;

    /* renamed from: d */
    public final Scheduler f7705d;

    /* renamed from: e */
    public final AtomicLong f7706e = new AtomicLong();

    /* renamed from: f */
    public final SequentialDisposable f7707f = new SequentialDisposable();

    /* renamed from: g */
    public Subscription f7708g;

    public aq0(SerializedSubscriber serializedSubscriber, long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f7702a = serializedSubscriber;
        this.f7703b = j;
        this.f7704c = timeUnit;
        this.f7705d = scheduler;
    }

    /* renamed from: a */
    public abstract void mo1958a();

    /* renamed from: b */
    public final void m1959b() {
        Object andSet = getAndSet(null);
        if (andSet != null) {
            AtomicLong atomicLong = this.f7706e;
            long j = atomicLong.get();
            SerializedSubscriber serializedSubscriber = this.f7702a;
            if (j != 0) {
                serializedSubscriber.onNext(andSet);
                BackpressureHelper.produced(atomicLong, 1L);
            } else {
                cancel();
                serializedSubscriber.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        DisposableHelper.dispose(this.f7707f);
        this.f7708g.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        DisposableHelper.dispose(this.f7707f);
        mo1958a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        DisposableHelper.dispose(this.f7707f);
        this.f7702a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        lazySet(obj);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f7708g, subscription)) {
            this.f7708g = subscription;
            this.f7702a.onSubscribe(this);
            TimeUnit timeUnit = this.f7704c;
            Scheduler scheduler = this.f7705d;
            long j = this.f7703b;
            this.f7707f.replace(scheduler.schedulePeriodicallyDirect(this, j, j, timeUnit));
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f7706e, j);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        m1959b();
    }
}
