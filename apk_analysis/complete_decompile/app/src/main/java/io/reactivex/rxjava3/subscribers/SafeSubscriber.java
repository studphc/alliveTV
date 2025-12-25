package io.reactivex.rxjava3.subscribers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class SafeSubscriber<T> implements FlowableSubscriber<T>, Subscription {

    /* renamed from: a */
    public final Subscriber f20152a;

    /* renamed from: b */
    public Subscription f20153b;

    /* renamed from: c */
    public boolean f20154c;

    public SafeSubscriber(@NonNull Subscriber<? super T> subscriber) {
        this.f20152a = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        try {
            this.f20153b.cancel();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f20154c) {
            return;
        }
        this.f20154c = true;
        Subscription subscription = this.f20153b;
        Subscriber subscriber = this.f20152a;
        if (subscription == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                subscriber.onSubscribe(EmptySubscription.INSTANCE);
                try {
                    subscriber.onError(nullPointerException);
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(new CompositeException(nullPointerException, th));
                    return;
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(new CompositeException(nullPointerException, th2));
                return;
            }
        }
        try {
            subscriber.onComplete();
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            RxJavaPlugins.onError(th3);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(@NonNull Throwable th) {
        if (this.f20154c) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f20154c = true;
        Subscription subscription = this.f20153b;
        Subscriber subscriber = this.f20152a;
        if (subscription == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                subscriber.onSubscribe(EmptySubscription.INSTANCE);
                try {
                    subscriber.onError(new CompositeException(th, nullPointerException));
                    return;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(new CompositeException(th, nullPointerException, th2));
                    return;
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(new CompositeException(th, nullPointerException, th3));
                return;
            }
        }
        if (th == null) {
            th = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
        }
        try {
            subscriber.onError(th);
        } catch (Throwable th4) {
            Exceptions.throwIfFatal(th4);
            RxJavaPlugins.onError(new CompositeException(th, th4));
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(@NonNull T t) {
        if (this.f20154c) {
            return;
        }
        Subscription subscription = this.f20153b;
        Subscriber subscriber = this.f20152a;
        if (subscription == null) {
            this.f20154c = true;
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                subscriber.onSubscribe(EmptySubscription.INSTANCE);
                try {
                    subscriber.onError(nullPointerException);
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(new CompositeException(nullPointerException, th));
                    return;
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(new CompositeException(nullPointerException, th2));
                return;
            }
        }
        if (t == null) {
            NullPointerException createNullPointerException = ExceptionHelper.createNullPointerException("onNext called with a null Throwable.");
            try {
                this.f20153b.cancel();
                onError(createNullPointerException);
                return;
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                onError(new CompositeException(createNullPointerException, th3));
                return;
            }
        }
        try {
            subscriber.onNext(t);
        } catch (Throwable th4) {
            Exceptions.throwIfFatal(th4);
            try {
                this.f20153b.cancel();
                onError(th4);
            } catch (Throwable th5) {
                Exceptions.throwIfFatal(th5);
                onError(new CompositeException(th4, th5));
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(@NonNull Subscription subscription) {
        if (SubscriptionHelper.validate(this.f20153b, subscription)) {
            this.f20153b = subscription;
            try {
                this.f20152a.onSubscribe(this);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f20154c = true;
                try {
                    subscription.cancel();
                    RxJavaPlugins.onError(th);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(new CompositeException(th, th2));
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        try {
            this.f20153b.request(j);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            try {
                this.f20153b.cancel();
                RxJavaPlugins.onError(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(new CompositeException(th, th2));
            }
        }
    }
}
