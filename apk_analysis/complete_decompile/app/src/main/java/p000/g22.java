package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class g22 implements ConditionalSubscriber, Subscription {

    /* renamed from: a */
    public final Predicate f17531a;

    /* renamed from: b */
    public Subscription f17532b;

    /* renamed from: c */
    public boolean f17533c;

    /* renamed from: d */
    public final /* synthetic */ int f17534d;

    /* renamed from: e */
    public final Subscriber f17535e;

    public g22(Subscriber subscriber, Predicate predicate, int i) {
        this.f17534d = i;
        this.f17531a = predicate;
        this.f17535e = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f17532b.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        switch (this.f17534d) {
            case 0:
                if (!this.f17533c) {
                    this.f17533c = true;
                    ((ConditionalSubscriber) this.f17535e).onComplete();
                    return;
                }
                return;
            default:
                if (!this.f17533c) {
                    this.f17533c = true;
                    this.f17535e.onComplete();
                    return;
                }
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        switch (this.f17534d) {
            case 0:
                if (this.f17533c) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f17533c = true;
                    ((ConditionalSubscriber) this.f17535e).onError(th);
                    return;
                }
            default:
                if (this.f17533c) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f17533c = true;
                    this.f17535e.onError(th);
                    return;
                }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (!tryOnNext(obj) && !this.f17533c) {
            this.f17532b.request(1L);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        switch (this.f17534d) {
            case 0:
                if (SubscriptionHelper.validate(this.f17532b, subscription)) {
                    this.f17532b = subscription;
                    ((ConditionalSubscriber) this.f17535e).onSubscribe(this);
                    return;
                }
                return;
            default:
                if (SubscriptionHelper.validate(this.f17532b, subscription)) {
                    this.f17532b = subscription;
                    this.f17535e.onSubscribe(this);
                    return;
                }
                return;
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        this.f17532b.request(j);
    }

    @Override // io.reactivex.rxjava3.operators.ConditionalSubscriber
    public final boolean tryOnNext(Object obj) {
        switch (this.f17534d) {
            case 0:
                if (this.f17533c) {
                    return false;
                }
                try {
                    if (!this.f17531a.test(obj)) {
                        return false;
                    }
                    return ((ConditionalSubscriber) this.f17535e).tryOnNext(obj);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    onError(th);
                    return false;
                }
            default:
                if (this.f17533c) {
                    return false;
                }
                try {
                    if (!this.f17531a.test(obj)) {
                        return false;
                    }
                    this.f17535e.onNext(obj);
                    return true;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    cancel();
                    onError(th2);
                    return false;
                }
        }
    }
}
