package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.observers.LambdaConsumerIntrospection;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class DisposableAutoReleaseSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = 8924480688481408726L;

    /* renamed from: a */
    public final AtomicReference f19900a;

    /* renamed from: b */
    public final Consumer f19901b;

    /* renamed from: c */
    public final Consumer f19902c;

    /* renamed from: d */
    public final Action f19903d;

    public DisposableAutoReleaseSubscriber(DisposableContainer disposableContainer, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        this.f19901b = consumer;
        this.f19902c = consumer2;
        this.f19903d = action;
        this.f19900a = new AtomicReference(disposableContainer);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        SubscriptionHelper.cancel(this);
        DisposableContainer disposableContainer = (DisposableContainer) this.f19900a.getAndSet(null);
        if (disposableContainer != null) {
            disposableContainer.delete(this);
        }
    }

    @Override // io.reactivex.rxjava3.observers.LambdaConsumerIntrospection
    public boolean hasCustomOnError() {
        if (this.f19902c != Functions.ON_ERROR_MISSING) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        if (SubscriptionHelper.CANCELLED == get()) {
            return true;
        }
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Subscription subscription = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (subscription != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.f19903d.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
        DisposableContainer disposableContainer = (DisposableContainer) this.f19900a.getAndSet(null);
        if (disposableContainer != null) {
            disposableContainer.delete(this);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        Subscription subscription = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (subscription != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.f19902c.accept(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(new CompositeException(th, th2));
            }
        } else {
            RxJavaPlugins.onError(th);
        }
        DisposableContainer disposableContainer = (DisposableContainer) this.f19900a.getAndSet(null);
        if (disposableContainer != null) {
            disposableContainer.delete(this);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (get() != SubscriptionHelper.CANCELLED) {
            try {
                this.f19901b.accept(t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                get().cancel();
                onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            subscription.request(Long.MAX_VALUE);
        }
    }
}
