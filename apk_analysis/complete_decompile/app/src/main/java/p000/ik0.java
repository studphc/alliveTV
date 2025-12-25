package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class ik0 extends SinglePostCompleteSubscriber implements MaybeObserver {
    private static final long serialVersionUID = -7346385463600070225L;

    /* renamed from: a */
    public final AtomicReference f18442a;

    /* renamed from: b */
    public MaybeSource f18443b;

    /* renamed from: c */
    public boolean f18444c;

    public ik0(Subscriber subscriber, MaybeSource maybeSource) {
        super(subscriber);
        this.f18443b = maybeSource;
        this.f18442a = new AtomicReference();
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber, org.reactivestreams.Subscription
    public final void cancel() {
        super.cancel();
        DisposableHelper.dispose(this.f18442a);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f18444c) {
            this.downstream.onComplete();
            return;
        }
        this.f18444c = true;
        this.upstream = SubscriptionHelper.CANCELLED;
        MaybeSource maybeSource = this.f18443b;
        this.f18443b = null;
        maybeSource.subscribe(this);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.downstream.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.produced++;
        this.downstream.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f18442a, disposable);
    }
}
