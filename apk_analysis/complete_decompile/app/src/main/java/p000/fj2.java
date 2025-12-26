package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class fj2 extends BasicIntQueueSubscription implements SingleObserver {
    private static final long serialVersionUID = -8938804753851907758L;

    /* renamed from: a */
    public final Subscriber f17291a;

    /* renamed from: b */
    public final Function f17292b;

    /* renamed from: c */
    public final AtomicLong f17293c = new AtomicLong();

    /* renamed from: d */
    public Disposable f17294d;

    /* renamed from: e */
    public volatile Iterator f17295e;

    /* renamed from: f */
    public volatile boolean f17296f;

    /* renamed from: g */
    public boolean f17297g;

    public fj2(Subscriber subscriber, Function function) {
        this.f17291a = subscriber;
        this.f17292b = function;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f17296f = true;
        this.f17294d.dispose();
        this.f17294d = DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f17295e = null;
    }

    public final void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        Subscriber subscriber = this.f17291a;
        Iterator it = this.f17295e;
        if (this.f17297g && it != null) {
            subscriber.onNext(null);
            subscriber.onComplete();
            return;
        }
        int i = 1;
        while (true) {
            if (it != null) {
                long j = this.f17293c.get();
                if (j == Long.MAX_VALUE) {
                    while (!this.f17296f) {
                        try {
                            subscriber.onNext(it.next());
                            if (!this.f17296f) {
                                try {
                                    if (!it.hasNext()) {
                                        subscriber.onComplete();
                                        return;
                                    }
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    subscriber.onError(th);
                                    return;
                                }
                            } else {
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
                long j2 = 0;
                while (j2 != j) {
                    if (this.f17296f) {
                        return;
                    }
                    try {
                        Object next = it.next();
                        Objects.requireNonNull(next, "The iterator returned a null value");
                        subscriber.onNext(next);
                        if (this.f17296f) {
                            return;
                        }
                        j2++;
                        try {
                            if (!it.hasNext()) {
                                subscriber.onComplete();
                                return;
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            subscriber.onError(th3);
                            return;
                        }
                    } catch (Throwable th4) {
                        Exceptions.throwIfFatal(th4);
                        subscriber.onError(th4);
                        return;
                    }
                }
                if (j2 != 0) {
                    BackpressureHelper.produced(this.f17293c, j2);
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
            if (it == null) {
                it = this.f17295e;
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        if (this.f17295e == null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        this.f17294d = DisposableHelper.DISPOSED;
        this.f17291a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f17294d, disposable)) {
            this.f17294d = disposable;
            this.f17291a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        try {
            Iterator it = ((Iterable) this.f17292b.apply(obj)).iterator();
            if (!it.hasNext()) {
                this.f17291a.onComplete();
            } else {
                this.f17295e = it;
                drain();
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f17291a.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        Iterator it = this.f17295e;
        if (it == null) {
            return null;
        }
        Object next = it.next();
        Objects.requireNonNull(next, "The iterator returned a null value");
        if (!it.hasNext()) {
            this.f17295e = null;
        }
        return next;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f17293c, j);
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        if ((i & 2) != 0) {
            this.f17297g = true;
            return 2;
        }
        return 0;
    }
}
