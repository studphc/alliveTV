package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class kj0 implements FlowableSubscriber, Disposable {

    /* renamed from: a */
    public final SingleObserver f20865a;

    /* renamed from: b */
    public final BiConsumer f20866b;

    /* renamed from: c */
    public final Function f20867c;

    /* renamed from: d */
    public Subscription f20868d;

    /* renamed from: e */
    public boolean f20869e;

    /* renamed from: f */
    public Object f20870f;

    public kj0(SingleObserver singleObserver, Object obj, BiConsumer biConsumer, Function function) {
        this.f20865a = singleObserver;
        this.f20870f = obj;
        this.f20866b = biConsumer;
        this.f20867c = function;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f20868d.cancel();
        this.f20868d = SubscriptionHelper.CANCELLED;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f20868d == SubscriptionHelper.CANCELLED) {
            return true;
        }
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        Object apply;
        SingleObserver singleObserver = this.f20865a;
        if (this.f20869e) {
            return;
        }
        this.f20869e = true;
        this.f20868d = SubscriptionHelper.CANCELLED;
        Object obj = this.f20870f;
        this.f20870f = null;
        try {
            apply = this.f20867c.apply(obj);
            Objects.requireNonNull(apply, "The finisher returned a null value");
            singleObserver.onSuccess(apply);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            singleObserver.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f20869e) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f20869e = true;
        this.f20868d = SubscriptionHelper.CANCELLED;
        this.f20870f = null;
        this.f20865a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (!this.f20869e) {
            try {
                this.f20866b.accept(this.f20870f, obj);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f20868d.cancel();
                onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f20868d, subscription)) {
            this.f20868d = subscription;
            this.f20865a.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
