package p000;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ln0 extends AtomicLong implements Subscription, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;

    /* renamed from: a */
    public final Subscriber f22582a;

    /* renamed from: b */
    public final long f22583b;

    /* renamed from: c */
    public long f22584c;

    /* renamed from: d */
    public final AtomicReference f22585d = new AtomicReference();

    public ln0(Subscriber subscriber, long j, long j2) {
        this.f22582a = subscriber;
        this.f22584c = j;
        this.f22583b = j2;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        DisposableHelper.dispose(this.f22585d);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this, j);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference = this.f22585d;
        Object obj = atomicReference.get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (obj != disposableHelper) {
            long j = get();
            Subscriber subscriber = this.f22582a;
            if (j != 0) {
                long j2 = this.f22584c;
                subscriber.onNext(Long.valueOf(j2));
                if (j2 == this.f22583b) {
                    if (atomicReference.get() != disposableHelper) {
                        subscriber.onComplete();
                    }
                    DisposableHelper.dispose(atomicReference);
                    return;
                } else {
                    this.f22584c = j2 + 1;
                    if (j != Long.MAX_VALUE) {
                        decrementAndGet();
                        return;
                    }
                    return;
                }
            }
            subscriber.onError(new MissingBackpressureException(ye0.m8297q(new StringBuilder("Can't deliver value "), this.f22584c, " due to lack of requests")));
            DisposableHelper.dispose(atomicReference);
        }
    }
}
