package p000;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class rr0 extends AtomicReference implements Subscription, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;

    /* renamed from: a */
    public final Subscriber f26118a;

    /* renamed from: b */
    public volatile boolean f26119b;

    public rr0(Subscriber subscriber) {
        this.f26118a = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        DisposableHelper.dispose(this);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            this.f26119b = true;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (get() != DisposableHelper.DISPOSED) {
            if (this.f26119b) {
                this.f26118a.onNext(0L);
                lazySet(EmptyDisposable.INSTANCE);
                this.f26118a.onComplete();
            } else {
                lazySet(EmptyDisposable.INSTANCE);
                this.f26118a.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
            }
        }
    }
}
