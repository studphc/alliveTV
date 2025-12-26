package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ui0 extends AtomicLong implements FlowableSubscriber, Subscription, BooleanSupplier {
    private static final long serialVersionUID = -7370244972039324525L;

    /* renamed from: a */
    public final Subscriber f27276a;

    /* renamed from: b */
    public final Supplier f27277b;

    /* renamed from: c */
    public final int f27278c;

    /* renamed from: d */
    public final int f27279d;

    /* renamed from: g */
    public Subscription f27282g;

    /* renamed from: h */
    public boolean f27283h;

    /* renamed from: i */
    public int f27284i;

    /* renamed from: j */
    public volatile boolean f27285j;

    /* renamed from: k */
    public long f27286k;

    /* renamed from: f */
    public final AtomicBoolean f27281f = new AtomicBoolean();

    /* renamed from: e */
    public final ArrayDeque f27280e = new ArrayDeque();

    public ui0(Subscriber subscriber, int i, int i2, Supplier supplier) {
        this.f27276a = subscriber;
        this.f27278c = i;
        this.f27279d = i2;
        this.f27277b = supplier;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f27285j = true;
        this.f27282g.cancel();
    }

    @Override // io.reactivex.rxjava3.functions.BooleanSupplier
    public final boolean getAsBoolean() {
        return this.f27285j;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f27283h) {
            return;
        }
        this.f27283h = true;
        long j = this.f27286k;
        if (j != 0) {
            BackpressureHelper.produced(this, j);
        }
        QueueDrainHelper.postComplete(this.f27276a, this.f27280e, this, this);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f27283h) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f27283h = true;
        this.f27280e.clear();
        this.f27276a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f27283h) {
            return;
        }
        ArrayDeque arrayDeque = this.f27280e;
        int i = this.f27284i;
        int i2 = i + 1;
        if (i == 0) {
            try {
                Object obj2 = this.f27277b.get();
                Objects.requireNonNull(obj2, "The bufferSupplier returned a null buffer");
                arrayDeque.offer((Collection) obj2);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                onError(th);
                return;
            }
        }
        Collection collection = (Collection) arrayDeque.peek();
        if (collection.size() + 1 == this.f27278c) {
            arrayDeque.poll();
            collection.add(obj);
            this.f27286k++;
            this.f27276a.onNext(collection);
        }
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).add(obj);
        }
        if (i2 == this.f27279d) {
            i2 = 0;
        }
        this.f27284i = i2;
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f27282g, subscription)) {
            this.f27282g = subscription;
            this.f27276a.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            if (QueueDrainHelper.postCompleteRequest(j, this.f27276a, this.f27280e, this, this)) {
                return;
            }
            AtomicBoolean atomicBoolean = this.f27281f;
            boolean z = atomicBoolean.get();
            int i = this.f27279d;
            if (!z && atomicBoolean.compareAndSet(false, true)) {
                this.f27282g.request(BackpressureHelper.addCap(this.f27278c, BackpressureHelper.multiplyCap(i, j - 1)));
            } else {
                this.f27282g.request(BackpressureHelper.multiplyCap(i, j));
            }
        }
    }
}
