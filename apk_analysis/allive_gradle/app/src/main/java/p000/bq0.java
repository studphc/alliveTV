package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class bq0 implements FlowableSubscriber, Subscription {

    /* renamed from: a */
    public final /* synthetic */ int f8126a = 0;

    /* renamed from: b */
    public final Subscriber f8127b;

    /* renamed from: c */
    public final BiFunction f8128c;

    /* renamed from: d */
    public Subscription f8129d;

    /* renamed from: e */
    public boolean f8130e;

    /* renamed from: f */
    public Object f8131f;

    public bq0(Subscriber subscriber, BiFunction biFunction) {
        this.f8127b = subscriber;
        this.f8128c = biFunction;
    }

    /* renamed from: a */
    public void m2126a(Throwable th) {
        Exceptions.throwIfFatal(th);
        this.f8130e = true;
        this.f8129d.cancel();
        this.f8127b.onError(th);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        switch (this.f8126a) {
            case 0:
                this.f8129d.cancel();
                return;
            default:
                this.f8129d.cancel();
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        switch (this.f8126a) {
            case 0:
                if (!this.f8130e) {
                    this.f8130e = true;
                    this.f8127b.onComplete();
                    return;
                }
                return;
            default:
                if (!this.f8130e) {
                    this.f8130e = true;
                    this.f8127b.onComplete();
                    return;
                }
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        switch (this.f8126a) {
            case 0:
                if (this.f8130e) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f8130e = true;
                    this.f8127b.onError(th);
                    return;
                }
            default:
                if (this.f8130e) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f8130e = true;
                    this.f8127b.onError(th);
                    return;
                }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        switch (this.f8126a) {
            case 0:
                if (!this.f8130e) {
                    Object obj2 = this.f8131f;
                    Subscriber subscriber = this.f8127b;
                    if (obj2 == null) {
                        this.f8131f = obj;
                        subscriber.onNext(obj);
                        return;
                    }
                    try {
                        Object apply = this.f8128c.apply(obj2, obj);
                        Objects.requireNonNull(apply, "The value returned by the accumulator is null");
                        this.f8131f = apply;
                        subscriber.onNext(apply);
                        return;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f8129d.cancel();
                        onError(th);
                        return;
                    }
                }
                return;
            default:
                Iterator it = (Iterator) this.f8131f;
                if (!this.f8130e) {
                    try {
                        Object next = it.next();
                        Objects.requireNonNull(next, "The iterator returned a null value");
                        try {
                            Object apply2 = this.f8128c.apply(obj, next);
                            Objects.requireNonNull(apply2, "The zipper function returned a null value");
                            Subscriber subscriber2 = this.f8127b;
                            subscriber2.onNext(apply2);
                            try {
                                if (!it.hasNext()) {
                                    this.f8130e = true;
                                    this.f8129d.cancel();
                                    subscriber2.onComplete();
                                    return;
                                }
                                return;
                            } catch (Throwable th2) {
                                m2126a(th2);
                                return;
                            }
                        } catch (Throwable th3) {
                            m2126a(th3);
                            return;
                        }
                    } catch (Throwable th4) {
                        m2126a(th4);
                        return;
                    }
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        switch (this.f8126a) {
            case 0:
                if (SubscriptionHelper.validate(this.f8129d, subscription)) {
                    this.f8129d = subscription;
                    this.f8127b.onSubscribe(this);
                    return;
                }
                return;
            default:
                if (SubscriptionHelper.validate(this.f8129d, subscription)) {
                    this.f8129d = subscription;
                    this.f8127b.onSubscribe(this);
                    return;
                }
                return;
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        switch (this.f8126a) {
            case 0:
                this.f8129d.request(j);
                return;
            default:
                this.f8129d.request(j);
                return;
        }
    }

    public bq0(Subscriber subscriber, Iterator it, BiFunction biFunction) {
        this.f8127b = subscriber;
        this.f8131f = it;
        this.f8128c = biFunction;
    }
}
