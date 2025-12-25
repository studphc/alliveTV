package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class js0 extends AtomicReference implements ConditionalSubscriber, Subscription {
    private static final long serialVersionUID = -312246233408980075L;

    /* renamed from: a */
    public final SerializedSubscriber f20594a;

    /* renamed from: b */
    public final BiFunction f20595b;

    /* renamed from: c */
    public final AtomicReference f20596c = new AtomicReference();

    /* renamed from: d */
    public final AtomicLong f20597d = new AtomicLong();

    /* renamed from: e */
    public final AtomicReference f20598e = new AtomicReference();

    public js0(SerializedSubscriber serializedSubscriber, BiFunction biFunction) {
        this.f20594a = serializedSubscriber;
        this.f20595b = biFunction;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        SubscriptionHelper.cancel(this.f20596c);
        SubscriptionHelper.cancel(this.f20598e);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        SubscriptionHelper.cancel(this.f20598e);
        this.f20594a.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        SubscriptionHelper.cancel(this.f20598e);
        this.f20594a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (!tryOnNext(obj)) {
            ((Subscription) this.f20596c.get()).request(1L);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.f20596c, this.f20597d, subscription);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        SubscriptionHelper.deferredRequest(this.f20596c, this.f20597d, j);
    }

    @Override // io.reactivex.rxjava3.operators.ConditionalSubscriber
    public final boolean tryOnNext(Object obj) {
        SerializedSubscriber serializedSubscriber = this.f20594a;
        Object obj2 = get();
        if (obj2 != null) {
            try {
                Object apply = this.f20595b.apply(obj, obj2);
                Objects.requireNonNull(apply, "The combiner returned a null value");
                serializedSubscriber.onNext(apply);
                return true;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                serializedSubscriber.onError(th);
            }
        }
        return false;
    }
}
