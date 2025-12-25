package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.Optional;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class p22 implements ConditionalSubscriber, Subscription {

    /* renamed from: a */
    public final /* synthetic */ int f25010a;

    /* renamed from: b */
    public final Subscriber f25011b;

    /* renamed from: c */
    public final Function f25012c;

    /* renamed from: d */
    public Subscription f25013d;

    /* renamed from: e */
    public boolean f25014e;

    public /* synthetic */ p22(Subscriber subscriber, Function function, int i) {
        this.f25010a = i;
        this.f25011b = subscriber;
        this.f25012c = function;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        switch (this.f25010a) {
            case 0:
                this.f25013d.cancel();
                return;
            case 1:
                this.f25013d.cancel();
                return;
            default:
                this.f25013d.cancel();
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        switch (this.f25010a) {
            case 0:
                if (!this.f25014e) {
                    this.f25014e = true;
                    ((ConditionalSubscriber) this.f25011b).onComplete();
                    return;
                }
                return;
            case 1:
                if (!this.f25014e) {
                    this.f25014e = true;
                    ((ConditionalSubscriber) this.f25011b).onComplete();
                    return;
                }
                return;
            default:
                if (!this.f25014e) {
                    this.f25014e = true;
                    this.f25011b.onComplete();
                    return;
                }
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        switch (this.f25010a) {
            case 0:
                if (this.f25014e) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f25014e = true;
                    ((ConditionalSubscriber) this.f25011b).onError(th);
                    return;
                }
            case 1:
                if (this.f25014e) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f25014e = true;
                    ((ConditionalSubscriber) this.f25011b).onError(th);
                    return;
                }
            default:
                if (this.f25014e) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f25014e = true;
                    this.f25011b.onError(th);
                    return;
                }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        switch (this.f25010a) {
            case 0:
                if (!this.f25014e) {
                    try {
                        Object apply = this.f25012c.apply(obj);
                        Objects.requireNonNull(apply, "The mapper returned a null value");
                        ((ConditionalSubscriber) this.f25011b).onNext(apply);
                        return;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        cancel();
                        onError(th);
                        return;
                    }
                }
                return;
            case 1:
                if (!tryOnNext(obj)) {
                    this.f25013d.request(1L);
                    return;
                }
                return;
            default:
                if (!tryOnNext(obj)) {
                    this.f25013d.request(1L);
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        switch (this.f25010a) {
            case 0:
                if (SubscriptionHelper.validate(this.f25013d, subscription)) {
                    this.f25013d = subscription;
                    ((ConditionalSubscriber) this.f25011b).onSubscribe(this);
                    return;
                }
                return;
            case 1:
                if (SubscriptionHelper.validate(this.f25013d, subscription)) {
                    this.f25013d = subscription;
                    ((ConditionalSubscriber) this.f25011b).onSubscribe(this);
                    return;
                }
                return;
            default:
                if (SubscriptionHelper.validate(this.f25013d, subscription)) {
                    this.f25013d = subscription;
                    this.f25011b.onSubscribe(this);
                    return;
                }
                return;
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        switch (this.f25010a) {
            case 0:
                this.f25013d.request(j);
                return;
            case 1:
                this.f25013d.request(j);
                return;
            default:
                this.f25013d.request(j);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.operators.ConditionalSubscriber
    public final boolean tryOnNext(Object obj) {
        boolean isPresent;
        Object obj2;
        boolean isPresent2;
        Object obj3;
        switch (this.f25010a) {
            case 0:
                if (this.f25014e) {
                    return false;
                }
                try {
                    Object apply = this.f25012c.apply(obj);
                    Objects.requireNonNull(apply, "The mapper returned a null value");
                    return ((ConditionalSubscriber) this.f25011b).tryOnNext(apply);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    onError(th);
                    return false;
                }
            case 1:
                if (this.f25014e) {
                    return false;
                }
                try {
                    Object apply2 = this.f25012c.apply(obj);
                    Objects.requireNonNull(apply2, "The mapper returned a null value");
                    Optional m5540h = ki0.m5540h(apply2);
                    isPresent = m5540h.isPresent();
                    if (!isPresent) {
                        return false;
                    }
                    ConditionalSubscriber conditionalSubscriber = (ConditionalSubscriber) this.f25011b;
                    obj2 = m5540h.get();
                    if (!conditionalSubscriber.tryOnNext(obj2)) {
                        return false;
                    }
                    return true;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    cancel();
                    onError(th2);
                    return false;
                }
            default:
                if (this.f25014e) {
                    return true;
                }
                try {
                    Object apply3 = this.f25012c.apply(obj);
                    Objects.requireNonNull(apply3, "The mapper returned a null Optional");
                    Optional m5540h2 = ki0.m5540h(apply3);
                    isPresent2 = m5540h2.isPresent();
                    if (isPresent2) {
                        Subscriber subscriber = this.f25011b;
                        obj3 = m5540h2.get();
                        subscriber.onNext(obj3);
                        return true;
                    }
                    return false;
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    cancel();
                    onError(th3);
                    return true;
                }
        }
    }
}
