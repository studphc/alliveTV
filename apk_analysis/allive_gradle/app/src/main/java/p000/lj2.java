package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class lj2 implements FlowableSubscriber, Disposable {

    /* renamed from: a */
    public final SingleObserver f22535a;

    /* renamed from: b */
    public Subscription f22536b;

    /* renamed from: c */
    public Object f22537c;

    /* renamed from: d */
    public boolean f22538d;

    /* renamed from: e */
    public volatile boolean f22539e;

    public lj2(SingleObserver singleObserver) {
        this.f22535a = singleObserver;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f22539e = true;
        this.f22536b.cancel();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f22539e;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f22538d) {
            return;
        }
        this.f22538d = true;
        Object obj = this.f22537c;
        this.f22537c = null;
        SingleObserver singleObserver = this.f22535a;
        if (obj == null) {
            singleObserver.onError(new NoSuchElementException("The source Publisher is empty"));
        } else {
            singleObserver.onSuccess(obj);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f22538d) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f22538d = true;
        this.f22537c = null;
        this.f22535a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f22538d) {
            return;
        }
        if (this.f22537c != null) {
            this.f22536b.cancel();
            this.f22538d = true;
            this.f22537c = null;
            this.f22535a.onError(new IndexOutOfBoundsException("Too many elements in the Publisher"));
            return;
        }
        this.f22537c = obj;
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f22536b, subscription)) {
            this.f22536b = subscription;
            this.f22535a.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
