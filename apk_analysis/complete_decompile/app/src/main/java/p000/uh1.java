package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class uh1 extends AtomicInteger implements MaybeObserver, Subscription {
    private static final long serialVersionUID = 3520831347801429610L;

    /* renamed from: a */
    public final Subscriber f27268a;

    /* renamed from: e */
    public final MaybeSource[] f27272e;

    /* renamed from: f */
    public int f27273f;

    /* renamed from: g */
    public long f27274g;

    /* renamed from: b */
    public final AtomicLong f27269b = new AtomicLong();

    /* renamed from: d */
    public final SequentialDisposable f27271d = new SequentialDisposable();

    /* renamed from: c */
    public final AtomicReference f27270c = new AtomicReference(NotificationLite.COMPLETE);

    public uh1(Subscriber subscriber, MaybeSource[] maybeSourceArr) {
        this.f27268a = subscriber;
        this.f27272e = maybeSourceArr;
    }

    /* renamed from: a */
    public final void m7705a() {
        if (getAndIncrement() != 0) {
            return;
        }
        AtomicReference atomicReference = this.f27270c;
        do {
            SequentialDisposable sequentialDisposable = this.f27271d;
            if (sequentialDisposable.isDisposed()) {
                atomicReference.lazySet(null);
                return;
            }
            Object obj = atomicReference.get();
            if (obj != null) {
                NotificationLite notificationLite = NotificationLite.COMPLETE;
                Subscriber subscriber = this.f27268a;
                if (obj != notificationLite) {
                    long j = this.f27274g;
                    if (j != this.f27269b.get()) {
                        this.f27274g = j + 1;
                        atomicReference.lazySet(null);
                        subscriber.onNext(obj);
                    }
                } else {
                    atomicReference.lazySet(null);
                }
                if (!sequentialDisposable.isDisposed()) {
                    int i = this.f27273f;
                    MaybeSource[] maybeSourceArr = this.f27272e;
                    if (i == maybeSourceArr.length) {
                        subscriber.onComplete();
                        return;
                    } else {
                        this.f27273f = i + 1;
                        maybeSourceArr[i].subscribe(this);
                    }
                }
            }
        } while (decrementAndGet() != 0);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f27271d.dispose();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        this.f27270c.lazySet(NotificationLite.COMPLETE);
        m7705a();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        this.f27268a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        this.f27271d.replace(disposable);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        this.f27270c.lazySet(obj);
        m7705a();
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f27269b, j);
            m7705a();
        }
    }
}
