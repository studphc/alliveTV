package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class vi0 extends AtomicInteger implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = -5616169793639412593L;

    /* renamed from: a */
    public final Subscriber f27798a;

    /* renamed from: b */
    public final Supplier f27799b;

    /* renamed from: c */
    public final int f27800c;

    /* renamed from: d */
    public final int f27801d;

    /* renamed from: e */
    public Collection f27802e;

    /* renamed from: f */
    public Subscription f27803f;

    /* renamed from: g */
    public boolean f27804g;

    /* renamed from: h */
    public int f27805h;

    public vi0(Subscriber subscriber, int i, int i2, Supplier supplier) {
        this.f27798a = subscriber;
        this.f27800c = i;
        this.f27801d = i2;
        this.f27799b = supplier;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f27803f.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f27804g) {
            return;
        }
        this.f27804g = true;
        Collection collection = this.f27802e;
        this.f27802e = null;
        Subscriber subscriber = this.f27798a;
        if (collection != null) {
            subscriber.onNext(collection);
        }
        subscriber.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f27804g) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f27804g = true;
        this.f27802e = null;
        this.f27798a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f27804g) {
            return;
        }
        Collection collection = this.f27802e;
        int i = this.f27805h;
        int i2 = i + 1;
        if (i == 0) {
            try {
                Object obj2 = this.f27799b.get();
                Objects.requireNonNull(obj2, "The bufferSupplier returned a null buffer");
                collection = (Collection) obj2;
                this.f27802e = collection;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                onError(th);
                return;
            }
        }
        if (collection != null) {
            collection.add(obj);
            if (collection.size() == this.f27800c) {
                this.f27802e = null;
                this.f27798a.onNext(collection);
            }
        }
        if (i2 == this.f27801d) {
            i2 = 0;
        }
        this.f27805h = i2;
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f27803f, subscription)) {
            this.f27803f = subscription;
            this.f27798a.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            int i = get();
            int i2 = this.f27801d;
            if (i == 0 && compareAndSet(0, 1)) {
                this.f27803f.request(BackpressureHelper.addCap(BackpressureHelper.multiplyCap(j, this.f27800c), BackpressureHelper.multiplyCap(i2 - r0, j - 1)));
                return;
            }
            this.f27803f.request(BackpressureHelper.multiplyCap(i2, j));
        }
    }
}
