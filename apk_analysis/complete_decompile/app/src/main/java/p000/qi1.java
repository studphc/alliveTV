package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
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
public final class qi1 extends BasicIntQueueSubscription implements MaybeObserver {
    private static final long serialVersionUID = -8938804753851907758L;

    /* renamed from: a */
    public final Subscriber f25600a;

    /* renamed from: b */
    public final Function f25601b;

    /* renamed from: c */
    public final AtomicLong f25602c = new AtomicLong();

    /* renamed from: d */
    public Disposable f25603d;

    /* renamed from: e */
    public volatile Iterator f25604e;

    /* renamed from: f */
    public volatile boolean f25605f;

    /* renamed from: g */
    public boolean f25606g;

    public qi1(Subscriber subscriber, Function function) {
        this.f25600a = subscriber;
        this.f25601b = function;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f25605f = true;
        this.f25603d.dispose();
        this.f25603d = DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f25604e = null;
    }

    public final void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        Subscriber subscriber = this.f25600a;
        Iterator it = this.f25604e;
        if (this.f25606g && it != null) {
            subscriber.onNext(null);
            subscriber.onComplete();
            return;
        }
        int i = 1;
        while (true) {
            if (it != null) {
                long j = this.f25602c.get();
                if (j == Long.MAX_VALUE) {
                    while (!this.f25605f) {
                        try {
                            subscriber.onNext(it.next());
                            if (!this.f25605f) {
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
                    if (this.f25605f) {
                        return;
                    }
                    try {
                        Object next = it.next();
                        Objects.requireNonNull(next, "The iterator returned a null value");
                        subscriber.onNext(next);
                        if (this.f25605f) {
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
                    BackpressureHelper.produced(this.f25602c, j2);
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
            if (it == null) {
                it = this.f25604e;
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        if (this.f25604e == null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        this.f25600a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        this.f25603d = DisposableHelper.DISPOSED;
        this.f25600a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f25603d, disposable)) {
            this.f25603d = disposable;
            this.f25600a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        try {
            Iterator it = ((Iterable) this.f25601b.apply(obj)).iterator();
            if (!it.hasNext()) {
                this.f25600a.onComplete();
            } else {
                this.f25604e = it;
                drain();
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f25600a.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        Iterator it = this.f25604e;
        if (it == null) {
            return null;
        }
        Object next = it.next();
        Objects.requireNonNull(next, "The iterator returned a null value");
        if (!it.hasNext()) {
            this.f25604e = null;
        }
        return next;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f25602c, j);
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        if ((i & 2) != 0) {
            this.f25606g = true;
            return 2;
        }
        return 0;
    }
}
