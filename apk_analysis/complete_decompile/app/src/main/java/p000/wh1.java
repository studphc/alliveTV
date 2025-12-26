package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class wh1 extends AtomicInteger implements MaybeObserver, Subscription {
    private static final long serialVersionUID = 3520831347801429610L;

    /* renamed from: a */
    public final Subscriber f28187a;

    /* renamed from: e */
    public final Iterator f28191e;

    /* renamed from: f */
    public long f28192f;

    /* renamed from: b */
    public final AtomicLong f28188b = new AtomicLong();

    /* renamed from: d */
    public final SequentialDisposable f28190d = new SequentialDisposable();

    /* renamed from: c */
    public final AtomicReference f28189c = new AtomicReference(NotificationLite.COMPLETE);

    public wh1(Subscriber subscriber, Iterator it) {
        this.f28187a = subscriber;
        this.f28191e = it;
    }

    /* renamed from: a */
    public final void m8057a() {
        Iterator it = this.f28191e;
        if (getAndIncrement() != 0) {
            return;
        }
        AtomicReference atomicReference = this.f28189c;
        do {
            SequentialDisposable sequentialDisposable = this.f28190d;
            if (sequentialDisposable.isDisposed()) {
                atomicReference.lazySet(null);
                return;
            }
            Object obj = atomicReference.get();
            if (obj != null) {
                NotificationLite notificationLite = NotificationLite.COMPLETE;
                Subscriber subscriber = this.f28187a;
                if (obj != notificationLite) {
                    long j = this.f28192f;
                    if (j != this.f28188b.get()) {
                        this.f28192f = j + 1;
                        atomicReference.lazySet(null);
                        subscriber.onNext(obj);
                    }
                } else {
                    atomicReference.lazySet(null);
                }
                if (!sequentialDisposable.isDisposed()) {
                    try {
                        if (it.hasNext()) {
                            try {
                                Object next = it.next();
                                Objects.requireNonNull(next, "The source Iterator returned a null MaybeSource");
                                ((MaybeSource) next).subscribe(this);
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                subscriber.onError(th);
                                return;
                            }
                        } else {
                            subscriber.onComplete();
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        subscriber.onError(th2);
                        return;
                    }
                }
            }
        } while (decrementAndGet() != 0);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f28190d.dispose();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        this.f28189c.lazySet(NotificationLite.COMPLETE);
        m8057a();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        this.f28187a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        this.f28190d.replace(disposable);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        this.f28189c.lazySet(obj);
        m8057a();
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f28188b, j);
            m8057a();
        }
    }
}
