package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class mr0 extends AtomicLong implements FlowableSubscriber, Subscription, lr0 {
    private static final long serialVersionUID = 3764492702657003550L;

    /* renamed from: a */
    public final Subscriber f23079a;

    /* renamed from: b */
    public final Function f23080b;

    /* renamed from: c */
    public final SequentialDisposable f23081c = new SequentialDisposable();

    /* renamed from: d */
    public final AtomicReference f23082d = new AtomicReference();

    /* renamed from: e */
    public final AtomicLong f23083e = new AtomicLong();

    public mr0(Subscriber subscriber, Function function) {
        this.f23079a = subscriber;
        this.f23080b = function;
    }

    @Override // p000.qr0
    /* renamed from: a */
    public final void mo5780a(long j) {
        if (compareAndSet(j, Long.MAX_VALUE)) {
            SubscriptionHelper.cancel(this.f23082d);
            this.f23079a.onError(new TimeoutException());
        }
    }

    @Override // p000.lr0
    /* renamed from: b */
    public final void mo5781b(long j, Throwable th) {
        if (compareAndSet(j, Long.MAX_VALUE)) {
            SubscriptionHelper.cancel(this.f23082d);
            this.f23079a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        SubscriptionHelper.cancel(this.f23082d);
        this.f23081c.dispose();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.f23081c.dispose();
            this.f23079a.onComplete();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.f23081c.dispose();
            this.f23079a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        long j = get();
        if (j != Long.MAX_VALUE) {
            long j2 = 1 + j;
            if (compareAndSet(j, j2)) {
                SequentialDisposable sequentialDisposable = this.f23081c;
                Disposable disposable = sequentialDisposable.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                Subscriber subscriber = this.f23079a;
                subscriber.onNext(obj);
                try {
                    Object apply = this.f23080b.apply(obj);
                    Objects.requireNonNull(apply, "The itemTimeoutIndicator returned a null Publisher.");
                    Publisher publisher = (Publisher) apply;
                    jr0 jr0Var = new jr0(j2, this);
                    if (sequentialDisposable.replace(jr0Var)) {
                        publisher.subscribe(jr0Var);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    ((Subscription) this.f23082d.get()).cancel();
                    getAndSet(Long.MAX_VALUE);
                    subscriber.onError(th);
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.f23082d, this.f23083e, subscription);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        SubscriptionHelper.deferredRequest(this.f23082d, this.f23083e, j);
    }
}
