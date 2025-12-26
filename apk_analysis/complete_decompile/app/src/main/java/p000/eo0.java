package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class eo0 extends AtomicLong implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = -6246093802440953054L;

    /* renamed from: a */
    public final Subscriber f16922a;

    /* renamed from: b */
    public final Consumer f16923b;

    /* renamed from: c */
    public Subscription f16924c;

    /* renamed from: d */
    public boolean f16925d;

    public eo0(Subscriber subscriber, Consumer consumer) {
        this.f16922a = subscriber;
        this.f16923b = consumer;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f16924c.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f16925d) {
            return;
        }
        this.f16925d = true;
        this.f16922a.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f16925d) {
            RxJavaPlugins.onError(th);
        } else {
            this.f16925d = true;
            this.f16922a.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f16925d) {
            return;
        }
        if (get() != 0) {
            this.f16922a.onNext(obj);
            BackpressureHelper.produced(this, 1L);
            return;
        }
        try {
            this.f16923b.accept(obj);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f16924c, subscription)) {
            this.f16924c = subscription;
            this.f16922a.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this, j);
        }
    }
}
