package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class nq0 implements FlowableSubscriber, Subscription {

    /* renamed from: a */
    public final /* synthetic */ int f23452a;

    /* renamed from: b */
    public final Subscriber f23453b;

    /* renamed from: c */
    public final Predicate f23454c;

    /* renamed from: d */
    public Subscription f23455d;

    /* renamed from: e */
    public boolean f23456e;

    public /* synthetic */ nq0(Subscriber subscriber, Predicate predicate, int i) {
        this.f23452a = i;
        this.f23453b = subscriber;
        this.f23454c = predicate;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        switch (this.f23452a) {
            case 0:
                this.f23455d.cancel();
                return;
            case 1:
                this.f23455d.cancel();
                return;
            default:
                this.f23455d.cancel();
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        switch (this.f23452a) {
            case 0:
                this.f23453b.onComplete();
                return;
            case 1:
                if (!this.f23456e) {
                    this.f23456e = true;
                    this.f23453b.onComplete();
                    return;
                }
                return;
            default:
                if (!this.f23456e) {
                    this.f23456e = true;
                    this.f23453b.onComplete();
                    return;
                }
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        switch (this.f23452a) {
            case 0:
                this.f23453b.onError(th);
                return;
            case 1:
                if (!this.f23456e) {
                    this.f23456e = true;
                    this.f23453b.onError(th);
                    return;
                } else {
                    RxJavaPlugins.onError(th);
                    return;
                }
            default:
                if (this.f23456e) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f23456e = true;
                    this.f23453b.onError(th);
                    return;
                }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        switch (this.f23452a) {
            case 0:
                boolean z = this.f23456e;
                Subscriber subscriber = this.f23453b;
                if (z) {
                    subscriber.onNext(obj);
                    return;
                }
                try {
                    if (this.f23454c.test(obj)) {
                        this.f23455d.request(1L);
                        return;
                    } else {
                        this.f23456e = true;
                        subscriber.onNext(obj);
                        return;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f23455d.cancel();
                    subscriber.onError(th);
                    return;
                }
            case 1:
                if (!this.f23456e) {
                    Subscriber subscriber2 = this.f23453b;
                    subscriber2.onNext(obj);
                    try {
                        if (this.f23454c.test(obj)) {
                            this.f23456e = true;
                            this.f23455d.cancel();
                            subscriber2.onComplete();
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f23455d.cancel();
                        onError(th2);
                        return;
                    }
                }
                return;
            default:
                if (!this.f23456e) {
                    try {
                        boolean test = this.f23454c.test(obj);
                        Subscriber subscriber3 = this.f23453b;
                        if (!test) {
                            this.f23456e = true;
                            this.f23455d.cancel();
                            subscriber3.onComplete();
                            return;
                        }
                        subscriber3.onNext(obj);
                        return;
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        this.f23455d.cancel();
                        onError(th3);
                        return;
                    }
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        switch (this.f23452a) {
            case 0:
                if (SubscriptionHelper.validate(this.f23455d, subscription)) {
                    this.f23455d = subscription;
                    this.f23453b.onSubscribe(this);
                    return;
                }
                return;
            case 1:
                if (SubscriptionHelper.validate(this.f23455d, subscription)) {
                    this.f23455d = subscription;
                    this.f23453b.onSubscribe(this);
                    return;
                }
                return;
            default:
                if (SubscriptionHelper.validate(this.f23455d, subscription)) {
                    this.f23455d = subscription;
                    this.f23453b.onSubscribe(this);
                    return;
                }
                return;
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        switch (this.f23452a) {
            case 0:
                this.f23455d.request(j);
                return;
            case 1:
                this.f23455d.request(j);
                return;
            default:
                this.f23455d.request(j);
                return;
        }
    }
}
