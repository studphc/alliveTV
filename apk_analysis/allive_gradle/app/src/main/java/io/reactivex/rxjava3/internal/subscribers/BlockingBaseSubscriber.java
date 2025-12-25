package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public abstract class BlockingBaseSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T> {

    /* renamed from: a */
    public Object f19890a;

    /* renamed from: b */
    public Throwable f19891b;

    /* renamed from: c */
    public Subscription f19892c;

    public BlockingBaseSubscriber() {
        super(1);
    }

    public final T blockingGet() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                Subscription subscription = this.f19892c;
                this.f19892c = SubscriptionHelper.CANCELLED;
                if (subscription != null) {
                    subscription.cancel();
                }
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.f19891b;
        if (th == null) {
            return (T) this.f19890a;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        countDown();
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f19892c, subscription)) {
            this.f19892c = subscription;
            subscription.request(Long.MAX_VALUE);
        }
    }
}
