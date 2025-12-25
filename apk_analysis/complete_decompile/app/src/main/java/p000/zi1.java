package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class zi1 extends BasicIntQueueSubscription implements MaybeObserver, SingleObserver {
    private static final long serialVersionUID = 7363336003027148283L;

    /* renamed from: a */
    public final Subscriber f29386a;

    /* renamed from: b */
    public final Function f29387b;

    /* renamed from: c */
    public final AtomicLong f29388c = new AtomicLong();

    /* renamed from: d */
    public Disposable f29389d;

    /* renamed from: e */
    public volatile Iterator f29390e;

    /* renamed from: f */
    public AutoCloseable f29391f;

    /* renamed from: g */
    public boolean f29392g;

    /* renamed from: h */
    public volatile boolean f29393h;

    /* renamed from: i */
    public boolean f29394i;

    /* renamed from: j */
    public long f29395j;

    public zi1(Subscriber subscriber, Function function) {
        this.f29386a = subscriber;
        this.f29387b = function;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f29393h = true;
        this.f29389d.dispose();
        if (!this.f29394i) {
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f29390e = null;
        AutoCloseable autoCloseable = this.f29391f;
        this.f29391f = null;
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    public final void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        Subscriber subscriber = this.f29386a;
        long j = this.f29395j;
        long j2 = this.f29388c.get();
        Iterator it = this.f29390e;
        int i = 1;
        while (true) {
            if (this.f29393h) {
                clear();
            } else if (this.f29394i) {
                if (it != null) {
                    subscriber.onNext(null);
                    subscriber.onComplete();
                }
            } else if (it != null && j != j2) {
                try {
                    Object next = it.next();
                    if (!this.f29393h) {
                        subscriber.onNext(next);
                        j++;
                        if (!this.f29393h) {
                            try {
                                boolean hasNext = it.hasNext();
                                if (!this.f29393h && !hasNext) {
                                    subscriber.onComplete();
                                    this.f29393h = true;
                                }
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                subscriber.onError(th);
                                this.f29393h = true;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    subscriber.onError(th2);
                    this.f29393h = true;
                }
            }
            this.f29395j = j;
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
            j2 = this.f29388c.get();
            if (it == null) {
                it = this.f29390e;
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        Iterator it = this.f29390e;
        if (it != null) {
            if (!this.f29392g || it.hasNext()) {
                return false;
            }
            clear();
            return true;
        }
        return true;
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        this.f29386a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        this.f29386a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f29389d, disposable)) {
            this.f29389d = disposable;
            this.f29386a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        Iterator it;
        try {
            Object apply = this.f29387b.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null Stream");
            Stream m5549q = ki0.m5549q(apply);
            it = m5549q.iterator();
            if (!it.hasNext()) {
                this.f29386a.onComplete();
                try {
                    m5549q.close();
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                    return;
                }
            }
            this.f29390e = it;
            this.f29391f = m5549q;
            drain();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            this.f29386a.onError(th2);
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        Iterator it = this.f29390e;
        if (it == null) {
            return null;
        }
        if (this.f29392g) {
            if (!it.hasNext()) {
                clear();
                return null;
            }
        } else {
            this.f29392g = true;
        }
        return it.next();
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f29388c, j);
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        if ((i & 2) != 0) {
            this.f29394i = true;
            return 2;
        }
        return 0;
    }
}
