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
public final class kn0 extends AtomicLong implements Subscription, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;

    /* renamed from: a */
    public final Subscriber f20911a;

    /* renamed from: b */
    public long f20912b;

    /* renamed from: c */
    public final AtomicReference f20913c = new AtomicReference();

    public kn0(Subscriber subscriber) {
        this.f20911a = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        DisposableHelper.dispose(this.f20913c);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this, j);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference = this.f20913c;
        if (atomicReference.get() != DisposableHelper.DISPOSED) {
            long j = get();
            Subscriber subscriber = this.f20911a;
            if (j != 0) {
                long j2 = this.f20912b;
                this.f20912b = j2 + 1;
                subscriber.onNext(Long.valueOf(j2));
                BackpressureHelper.produced(this, 1L);
                return;
            }
            subscriber.onError(new MissingBackpressureException(ye0.m8297q(new StringBuilder("Can't deliver value "), this.f20912b, " due to lack of requests")));
            DisposableHelper.dispose(atomicReference);
        }
    }
}
