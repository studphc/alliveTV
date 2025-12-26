package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.jdk8.FlowableFromStream;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public abstract class pm0 extends AtomicLong implements QueueSubscription {
    private static final long serialVersionUID = -9082954702547571853L;

    /* renamed from: a */
    public Iterator f25222a;

    /* renamed from: b */
    public AutoCloseable f25223b;

    /* renamed from: c */
    public volatile boolean f25224c;

    /* renamed from: d */
    public boolean f25225d;

    public pm0(Iterator it, AutoCloseable autoCloseable) {
        this.f25222a = it;
        this.f25223b = autoCloseable;
    }

    /* renamed from: a */
    public abstract void mo6918a(long j);

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f25224c = true;
        request(1L);
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f25222a = null;
        AutoCloseable autoCloseable = this.f25223b;
        this.f25223b = null;
        if (autoCloseable != null) {
            int i = FlowableFromStream.f18539c;
            try {
                autoCloseable.close();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        Iterator it = this.f25222a;
        if (it != null) {
            if (this.f25225d && !it.hasNext()) {
                clear();
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue, java.util.Queue
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        Iterator it = this.f25222a;
        if (it == null) {
            return null;
        }
        if (!this.f25225d) {
            this.f25225d = true;
        } else if (!it.hasNext()) {
            clear();
            return null;
        }
        Object next = this.f25222a.next();
        Objects.requireNonNull(next, "The Stream's Iterator.next() returned a null value");
        return next;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
            mo6918a(j);
        }
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        if ((i & 1) != 0) {
            lazySet(Long.MAX_VALUE);
            return 1;
        }
        return 0;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }
}
