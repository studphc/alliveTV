package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

/* renamed from: qs */
/* loaded from: classes2.dex */
public final class C1735qs implements FlowableSubscriber, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f25733a;

    /* renamed from: b */
    public final Object f25734b;

    /* renamed from: c */
    public Subscription f25735c;

    public /* synthetic */ C1735qs(int i, Object obj) {
        this.f25733a = i;
        this.f25734b = obj;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f25733a) {
            case 0:
                this.f25735c.cancel();
                this.f25735c = SubscriptionHelper.CANCELLED;
                return;
            case 1:
                this.f25735c.cancel();
                this.f25735c = SubscriptionHelper.CANCELLED;
                return;
            default:
                this.f25735c.cancel();
                this.f25735c = SubscriptionHelper.CANCELLED;
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f25733a) {
            case 0:
                if (this.f25735c == SubscriptionHelper.CANCELLED) {
                    return true;
                }
                return false;
            case 1:
                if (this.f25735c == SubscriptionHelper.CANCELLED) {
                    return true;
                }
                return false;
            default:
                if (this.f25735c == SubscriptionHelper.CANCELLED) {
                    return true;
                }
                return false;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        switch (this.f25733a) {
            case 0:
                ((CompletableObserver) this.f25734b).onComplete();
                return;
            case 1:
                this.f25735c = SubscriptionHelper.CANCELLED;
                ((CompletableObserver) this.f25734b).onComplete();
                return;
            default:
                ((Observer) this.f25734b).onComplete();
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        switch (this.f25733a) {
            case 0:
                ((CompletableObserver) this.f25734b).onError(th);
                return;
            case 1:
                this.f25735c = SubscriptionHelper.CANCELLED;
                ((CompletableObserver) this.f25734b).onError(th);
                return;
            default:
                ((Observer) this.f25734b).onError(th);
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        switch (this.f25733a) {
            case 0:
            case 1:
                return;
            default:
                ((Observer) this.f25734b).onNext(obj);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        switch (this.f25733a) {
            case 0:
                if (SubscriptionHelper.validate(this.f25735c, subscription)) {
                    this.f25735c = subscription;
                    ((CompletableObserver) this.f25734b).onSubscribe(this);
                    subscription.request(Long.MAX_VALUE);
                    return;
                }
                return;
            case 1:
                if (SubscriptionHelper.validate(this.f25735c, subscription)) {
                    this.f25735c = subscription;
                    ((CompletableObserver) this.f25734b).onSubscribe(this);
                    subscription.request(Long.MAX_VALUE);
                    return;
                }
                return;
            default:
                if (SubscriptionHelper.validate(this.f25735c, subscription)) {
                    this.f25735c = subscription;
                    ((Observer) this.f25734b).onSubscribe(this);
                    subscription.request(Long.MAX_VALUE);
                    return;
                }
                return;
        }
    }

    /* renamed from: a */
    private final void m7141a(Object obj) {
    }

    /* renamed from: b */
    private final void m7142b(Object obj) {
    }
}
