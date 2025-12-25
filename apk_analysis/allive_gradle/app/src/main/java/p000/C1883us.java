package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscription;

/* renamed from: us */
/* loaded from: classes2.dex */
public final class C1883us extends AtomicInteger implements FlowableSubscriber, Disposable {
    private static final long serialVersionUID = -2108443387387077490L;

    /* renamed from: a */
    public final CompletableObserver f27420a;

    /* renamed from: b */
    public final int f27421b;

    /* renamed from: c */
    public final boolean f27422c;

    /* renamed from: f */
    public Subscription f27425f;

    /* renamed from: e */
    public final CompositeDisposable f27424e = new CompositeDisposable();

    /* renamed from: d */
    public final AtomicThrowable f27423d = new AtomicThrowable();

    public C1883us(CompletableObserver completableObserver, int i, boolean z) {
        this.f27420a = completableObserver;
        this.f27421b = i;
        this.f27422c = z;
        lazySet(1);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f27425f.cancel();
        this.f27424e.dispose();
        this.f27423d.tryTerminateAndReport();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f27424e.isDisposed();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (decrementAndGet() == 0) {
            this.f27423d.tryTerminateConsumer(this.f27420a);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        boolean z = this.f27422c;
        CompletableObserver completableObserver = this.f27420a;
        AtomicThrowable atomicThrowable = this.f27423d;
        if (!z) {
            this.f27424e.dispose();
            if (atomicThrowable.tryAddThrowableOrReport(th) && getAndSet(0) > 0) {
                atomicThrowable.tryTerminateConsumer(completableObserver);
                return;
            }
            return;
        }
        if (atomicThrowable.tryAddThrowableOrReport(th) && decrementAndGet() == 0) {
            atomicThrowable.tryTerminateConsumer(completableObserver);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        getAndIncrement();
        C1846ts c1846ts = new C1846ts(this);
        this.f27424e.add(c1846ts);
        ((CompletableSource) obj).subscribe(c1846ts);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f27425f, subscription)) {
            this.f27425f = subscription;
            this.f27420a.onSubscribe(this);
            int i = this.f27421b;
            if (i == Integer.MAX_VALUE) {
                subscription.request(Long.MAX_VALUE);
            } else {
                subscription.request(i);
            }
        }
    }
}
