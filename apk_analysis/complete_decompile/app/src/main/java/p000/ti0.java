package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ti0 implements FlowableSubscriber, Subscription {

    /* renamed from: a */
    public final Subscriber f26818a;

    /* renamed from: b */
    public final Supplier f26819b;

    /* renamed from: c */
    public final int f26820c;

    /* renamed from: d */
    public Collection f26821d;

    /* renamed from: e */
    public Subscription f26822e;

    /* renamed from: f */
    public boolean f26823f;

    /* renamed from: g */
    public int f26824g;

    public ti0(Subscriber subscriber, int i, Supplier supplier) {
        this.f26818a = subscriber;
        this.f26820c = i;
        this.f26819b = supplier;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f26822e.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f26823f) {
            return;
        }
        this.f26823f = true;
        Collection collection = this.f26821d;
        this.f26821d = null;
        Subscriber subscriber = this.f26818a;
        if (collection != null) {
            subscriber.onNext(collection);
        }
        subscriber.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f26823f) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f26821d = null;
        this.f26823f = true;
        this.f26818a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f26823f) {
            return;
        }
        Collection collection = this.f26821d;
        if (collection == null) {
            try {
                Object obj2 = this.f26819b.get();
                Objects.requireNonNull(obj2, "The bufferSupplier returned a null buffer");
                collection = (Collection) obj2;
                this.f26821d = collection;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                onError(th);
                return;
            }
        }
        collection.add(obj);
        int i = this.f26824g + 1;
        if (i == this.f26820c) {
            this.f26824g = 0;
            this.f26821d = null;
            this.f26818a.onNext(collection);
            return;
        }
        this.f26824g = i;
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f26822e, subscription)) {
            this.f26822e = subscription;
            this.f26818a.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            this.f26822e.request(BackpressureHelper.multiplyCap(j, this.f26820c));
        }
    }
}
