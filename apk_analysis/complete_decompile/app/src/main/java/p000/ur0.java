package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ur0 extends AtomicBoolean implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = 5904473792286235046L;

    /* renamed from: a */
    public final Subscriber f27415a;

    /* renamed from: b */
    public final Object f27416b;

    /* renamed from: c */
    public final Consumer f27417c;

    /* renamed from: d */
    public final boolean f27418d;

    /* renamed from: e */
    public Subscription f27419e;

    public ur0(Subscriber subscriber, Object obj, Consumer consumer, boolean z) {
        this.f27415a = subscriber;
        this.f27416b = obj;
        this.f27417c = consumer;
        this.f27418d = z;
    }

    /* renamed from: a */
    public final void m7761a() {
        if (compareAndSet(false, true)) {
            try {
                this.f27417c.accept(this.f27416b);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (this.f27418d) {
            m7761a();
            this.f27419e.cancel();
            this.f27419e = SubscriptionHelper.CANCELLED;
        } else {
            this.f27419e.cancel();
            this.f27419e = SubscriptionHelper.CANCELLED;
            m7761a();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        boolean z = this.f27418d;
        Subscriber subscriber = this.f27415a;
        if (z) {
            if (compareAndSet(false, true)) {
                try {
                    this.f27417c.accept(this.f27416b);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    subscriber.onError(th);
                    return;
                }
            }
            subscriber.onComplete();
            return;
        }
        subscriber.onComplete();
        m7761a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        boolean z = this.f27418d;
        Subscriber subscriber = this.f27415a;
        if (z) {
            if (compareAndSet(false, true)) {
                try {
                    this.f27417c.accept(this.f27416b);
                } catch (Throwable th2) {
                    th = th2;
                    Exceptions.throwIfFatal(th);
                }
            }
            th = null;
            if (th != null) {
                subscriber.onError(new CompositeException(th, th));
                return;
            } else {
                subscriber.onError(th);
                return;
            }
        }
        subscriber.onError(th);
        m7761a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f27415a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f27419e, subscription)) {
            this.f27419e = subscription;
            this.f27415a.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        this.f27419e.request(j);
    }
}
