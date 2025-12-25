package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.parallel.ParallelPeek;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class el0 implements FlowableSubscriber, Subscription {

    /* renamed from: a */
    public final /* synthetic */ int f16864a;

    /* renamed from: b */
    public final Subscriber f16865b;

    /* renamed from: c */
    public final Object f16866c;

    /* renamed from: d */
    public Subscription f16867d;

    /* renamed from: e */
    public boolean f16868e;

    public /* synthetic */ el0(Subscriber subscriber, Object obj, int i) {
        this.f16864a = i;
        this.f16865b = subscriber;
        this.f16866c = obj;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        switch (this.f16864a) {
            case 0:
                this.f16867d.cancel();
                return;
            case 1:
                this.f16867d.cancel();
                return;
            default:
                try {
                    ((ParallelPeek) this.f16866c).f19696i.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
                this.f16867d.cancel();
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        switch (this.f16864a) {
            case 0:
                if (!this.f16868e) {
                    this.f16868e = true;
                    this.f16865b.onComplete();
                    return;
                }
                return;
            case 1:
                if (!this.f16868e) {
                    this.f16868e = true;
                    this.f16865b.onComplete();
                    return;
                }
                return;
            default:
                Subscriber subscriber = this.f16865b;
                ParallelPeek parallelPeek = (ParallelPeek) this.f16866c;
                if (!this.f16868e) {
                    this.f16868e = true;
                    try {
                        parallelPeek.f19692e.run();
                        subscriber.onComplete();
                        try {
                            parallelPeek.f19693f.run();
                            return;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            RxJavaPlugins.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        subscriber.onError(th2);
                        return;
                    }
                }
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        Subscriber subscriber = this.f16865b;
        switch (this.f16864a) {
            case 0:
                if (this.f16868e) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f16868e = true;
                    subscriber.onError(th);
                    return;
                }
            case 1:
                if (this.f16868e) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f16868e = true;
                    subscriber.onError(th);
                    return;
                }
            default:
                ParallelPeek parallelPeek = (ParallelPeek) this.f16866c;
                if (this.f16868e) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                this.f16868e = true;
                try {
                    parallelPeek.f19691d.accept(th);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    th = new CompositeException(th, th2);
                }
                subscriber.onError(th);
                try {
                    parallelPeek.f19693f.run();
                    return;
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    RxJavaPlugins.onError(th3);
                    return;
                }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        switch (this.f16864a) {
            case 0:
                if (this.f16868e) {
                    if (obj instanceof Notification) {
                        Notification notification = (Notification) obj;
                        if (notification.isOnError()) {
                            RxJavaPlugins.onError(notification.getError());
                            return;
                        }
                        return;
                    }
                    return;
                }
                try {
                    Object apply = ((Function) this.f16866c).apply(obj);
                    Objects.requireNonNull(apply, "The selector returned a null Notification");
                    Notification notification2 = (Notification) apply;
                    if (notification2.isOnError()) {
                        this.f16867d.cancel();
                        onError(notification2.getError());
                        return;
                    } else if (notification2.isOnComplete()) {
                        this.f16867d.cancel();
                        onComplete();
                        return;
                    } else {
                        this.f16865b.onNext(notification2.getValue());
                        return;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f16867d.cancel();
                    onError(th);
                    return;
                }
            case 1:
                if (!this.f16868e) {
                    try {
                        Object apply2 = ((Function) this.f16866c).apply(obj);
                        Objects.requireNonNull(apply2, "The mapper returned a null value");
                        this.f16865b.onNext(apply2);
                        return;
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        cancel();
                        onError(th2);
                        return;
                    }
                }
                return;
            default:
                ParallelPeek parallelPeek = (ParallelPeek) this.f16866c;
                if (!this.f16868e) {
                    try {
                        parallelPeek.f19689b.accept(obj);
                        this.f16865b.onNext(obj);
                        try {
                            parallelPeek.f19690c.accept(obj);
                            return;
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            onError(th3);
                            return;
                        }
                    } catch (Throwable th4) {
                        Exceptions.throwIfFatal(th4);
                        onError(th4);
                        return;
                    }
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        switch (this.f16864a) {
            case 0:
                if (SubscriptionHelper.validate(this.f16867d, subscription)) {
                    this.f16867d = subscription;
                    this.f16865b.onSubscribe(this);
                    return;
                }
                return;
            case 1:
                if (SubscriptionHelper.validate(this.f16867d, subscription)) {
                    this.f16867d = subscription;
                    this.f16865b.onSubscribe(this);
                    return;
                }
                return;
            default:
                Subscriber subscriber = this.f16865b;
                if (SubscriptionHelper.validate(this.f16867d, subscription)) {
                    this.f16867d = subscription;
                    try {
                        ((ParallelPeek) this.f16866c).f19694g.accept(subscription);
                        subscriber.onSubscribe(this);
                        return;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        subscription.cancel();
                        subscriber.onSubscribe(EmptySubscription.INSTANCE);
                        onError(th);
                        return;
                    }
                }
                return;
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        switch (this.f16864a) {
            case 0:
                this.f16867d.request(j);
                return;
            case 1:
                this.f16867d.request(j);
                return;
            default:
                try {
                    ((ParallelPeek) this.f16866c).f19695h.accept(j);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
                this.f16867d.request(j);
                return;
        }
    }
}
