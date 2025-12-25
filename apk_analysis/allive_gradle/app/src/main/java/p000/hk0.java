package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class hk0 extends AtomicReference implements FlowableSubscriber, CompletableObserver, Subscription {
    private static final long serialVersionUID = -7346385463600070225L;

    /* renamed from: a */
    public final Subscriber f18081a;

    /* renamed from: b */
    public Subscription f18082b;

    /* renamed from: c */
    public CompletableSource f18083c;

    /* renamed from: d */
    public boolean f18084d;

    public hk0(Subscriber subscriber, CompletableSource completableSource) {
        this.f18081a = subscriber;
        this.f18083c = completableSource;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f18082b.cancel();
        DisposableHelper.dispose(this);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f18084d) {
            this.f18081a.onComplete();
            return;
        }
        this.f18084d = true;
        this.f18082b = SubscriptionHelper.CANCELLED;
        CompletableSource completableSource = this.f18083c;
        this.f18083c = null;
        completableSource.subscribe(this);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f18081a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f18081a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f18082b, subscription)) {
            this.f18082b = subscription;
            this.f18081a.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        this.f18082b.request(j);
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
