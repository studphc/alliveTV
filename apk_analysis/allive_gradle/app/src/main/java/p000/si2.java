package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.ResumeSingleObserver;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class si2 extends AtomicReference implements FlowableSubscriber, Disposable {
    private static final long serialVersionUID = -8565274649390031272L;

    /* renamed from: a */
    public final SingleObserver f26442a;

    /* renamed from: b */
    public final SingleSource f26443b;

    /* renamed from: c */
    public boolean f26444c;

    /* renamed from: d */
    public Subscription f26445d;

    public si2(SingleObserver singleObserver, SingleSource singleSource) {
        this.f26442a = singleObserver;
        this.f26443b = singleSource;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f26445d.cancel();
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f26444c) {
            return;
        }
        this.f26444c = true;
        this.f26443b.subscribe(new ResumeSingleObserver(this, this.f26442a));
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f26444c) {
            RxJavaPlugins.onError(th);
        } else {
            this.f26444c = true;
            this.f26442a.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f26445d.cancel();
        onComplete();
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f26445d, subscription)) {
            this.f26445d = subscription;
            this.f26442a.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
