package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class jk0 extends SinglePostCompleteSubscriber implements SingleObserver {
    private static final long serialVersionUID = -7346385463600070225L;

    /* renamed from: a */
    public final AtomicReference f20528a;

    /* renamed from: b */
    public SingleSource f20529b;

    public jk0(Subscriber subscriber, SingleSource singleSource) {
        super(subscriber);
        this.f20529b = singleSource;
        this.f20528a = new AtomicReference();
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber, org.reactivestreams.Subscription
    public final void cancel() {
        super.cancel();
        DisposableHelper.dispose(this.f20528a);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.upstream = SubscriptionHelper.CANCELLED;
        SingleSource singleSource = this.f20529b;
        this.f20529b = null;
        singleSource.subscribe(this);
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

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f20528a, disposable);
    }
}
