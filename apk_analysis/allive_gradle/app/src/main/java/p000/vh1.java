package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class vh1 extends AtomicInteger implements MaybeObserver, Subscription {
    private static final long serialVersionUID = 3520831347801429610L;

    /* renamed from: a */
    public final Subscriber f27786a;

    /* renamed from: e */
    public final MaybeSource[] f27790e;

    /* renamed from: g */
    public int f27792g;

    /* renamed from: h */
    public long f27793h;

    /* renamed from: b */
    public final AtomicLong f27787b = new AtomicLong();

    /* renamed from: d */
    public final SequentialDisposable f27789d = new SequentialDisposable();

    /* renamed from: c */
    public final AtomicReference f27788c = new AtomicReference(NotificationLite.COMPLETE);

    /* renamed from: f */
    public final AtomicThrowable f27791f = new AtomicThrowable();

    public vh1(Subscriber subscriber, MaybeSource[] maybeSourceArr) {
        this.f27786a = subscriber;
        this.f27790e = maybeSourceArr;
    }

    /* renamed from: a */
    public final void m7912a() {
        if (getAndIncrement() != 0) {
            return;
        }
        AtomicReference atomicReference = this.f27788c;
        do {
            SequentialDisposable sequentialDisposable = this.f27789d;
            if (sequentialDisposable.isDisposed()) {
                atomicReference.lazySet(null);
                return;
            }
            Object obj = atomicReference.get();
            if (obj != null) {
                NotificationLite notificationLite = NotificationLite.COMPLETE;
                Subscriber<?> subscriber = this.f27786a;
                if (obj != notificationLite) {
                    long j = this.f27793h;
                    if (j != this.f27787b.get()) {
                        this.f27793h = j + 1;
                        atomicReference.lazySet(null);
                        subscriber.onNext(obj);
                    }
                } else {
                    atomicReference.lazySet(null);
                }
                if (!sequentialDisposable.isDisposed()) {
                    int i = this.f27792g;
                    MaybeSource[] maybeSourceArr = this.f27790e;
                    if (i == maybeSourceArr.length) {
                        this.f27791f.tryTerminateConsumer(subscriber);
                        return;
                    } else {
                        this.f27792g = i + 1;
                        maybeSourceArr[i].subscribe(this);
                    }
                }
            }
        } while (decrementAndGet() != 0);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f27789d.dispose();
        this.f27791f.tryTerminateAndReport();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        this.f27788c.lazySet(NotificationLite.COMPLETE);
        m7912a();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        this.f27788c.lazySet(NotificationLite.COMPLETE);
        if (this.f27791f.tryAddThrowableOrReport(th)) {
            m7912a();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        this.f27789d.replace(disposable);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        this.f27788c.lazySet(obj);
        m7912a();
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f27787b, j);
            m7912a();
        }
    }
}
