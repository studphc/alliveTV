package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ForEachWhileSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
    private static final long serialVersionUID = -4403180040475402120L;

    /* renamed from: a */
    public final Predicate f19904a;

    /* renamed from: b */
    public final Consumer f19905b;

    /* renamed from: c */
    public final Action f19906c;

    /* renamed from: d */
    public boolean f19907d;

    public ForEachWhileSubscriber(Predicate<? super T> predicate, Consumer<? super Throwable> consumer, Action action) {
        this.f19904a = predicate;
        this.f19905b = consumer;
        this.f19906c = action;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        if (get() == SubscriptionHelper.CANCELLED) {
            return true;
        }
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f19907d) {
            return;
        }
        this.f19907d = true;
        try {
            this.f19906c.run();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f19907d) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f19907d = true;
        try {
            this.f19905b.accept(th);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(th, th2));
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.f19907d) {
            return;
        }
        try {
            if (!this.f19904a.test(t)) {
                dispose();
                onComplete();
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
    }
}
