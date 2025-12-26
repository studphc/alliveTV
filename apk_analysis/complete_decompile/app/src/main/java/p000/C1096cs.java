package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* renamed from: cs */
/* loaded from: classes2.dex */
public final class C1096cs extends AtomicReference implements FlowableSubscriber, CompletableObserver, Subscription {
    private static final long serialVersionUID = -8948264376121066672L;

    /* renamed from: a */
    public final Subscriber f16092a;

    /* renamed from: b */
    public Publisher f16093b;

    /* renamed from: c */
    public Disposable f16094c;

    /* renamed from: d */
    public final AtomicLong f16095d = new AtomicLong();

    public C1096cs(Publisher publisher, Subscriber subscriber) {
        this.f16092a = subscriber;
        this.f16093b = publisher;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f16094c.dispose();
        SubscriptionHelper.cancel(this);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        Publisher publisher = this.f16093b;
        if (publisher == null) {
            this.f16092a.onComplete();
        } else {
            this.f16093b = null;
            publisher.subscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f16092a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f16092a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f16094c, disposable)) {
            this.f16094c = disposable;
            this.f16092a.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        SubscriptionHelper.deferredRequest(this, this.f16095d, j);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this, this.f16095d, subscription);
    }
}
