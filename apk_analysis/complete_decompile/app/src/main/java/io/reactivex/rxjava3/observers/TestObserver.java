package io.reactivex.rxjava3.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import p000.ns2;

/* loaded from: classes2.dex */
public class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements Observer<T>, Disposable, MaybeObserver<T>, SingleObserver<T>, CompletableObserver {

    /* renamed from: a */
    public final Observer f19991a;

    /* renamed from: b */
    public final AtomicReference f19992b;

    public TestObserver() {
        this(ns2.f23481a);
    }

    @NonNull
    public static <T> TestObserver<T> create() {
        return new TestObserver<>();
    }

    @Override // io.reactivex.rxjava3.observers.BaseTestConsumer, io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f19992b);
    }

    public final boolean hasSubscription() {
        if (this.f19992b.get() != null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.observers.BaseTestConsumer, io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) this.f19992b.get());
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.f19992b.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.lastThread = Thread.currentThread();
            this.completions++;
            this.f19991a.onComplete();
        } finally {
            this.done.countDown();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(@NonNull Throwable th) {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.f19992b.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.lastThread = Thread.currentThread();
            if (th == null) {
                this.errors.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.errors.add(th);
            }
            this.f19991a.onError(th);
            this.done.countDown();
        } catch (Throwable th2) {
            this.done.countDown();
            throw th2;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(@NonNull T t) {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.f19992b.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.lastThread = Thread.currentThread();
        this.values.add(t);
        if (t == null) {
            this.errors.add(new NullPointerException("onNext received a null value"));
        }
        this.f19991a.onNext(t);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(@NonNull Disposable disposable) {
        this.lastThread = Thread.currentThread();
        if (disposable == null) {
            this.errors.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        AtomicReference atomicReference = this.f19992b;
        while (!atomicReference.compareAndSet(null, disposable)) {
            if (atomicReference.get() != null) {
                disposable.dispose();
                if (atomicReference.get() != DisposableHelper.DISPOSED) {
                    this.errors.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + disposable));
                    return;
                }
                return;
            }
        }
        this.f19991a.onSubscribe(disposable);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onSuccess(@NonNull T t) {
        onNext(t);
        onComplete();
    }

    public TestObserver(@NonNull Observer<? super T> observer) {
        this.f19992b = new AtomicReference();
        this.f19991a = observer;
    }

    @NonNull
    public static <T> TestObserver<T> create(@NonNull Observer<? super T> observer) {
        return new TestObserver<>(observer);
    }

    @Override // io.reactivex.rxjava3.observers.BaseTestConsumer
    @NonNull
    public final TestObserver<T> assertSubscribed() {
        if (this.f19992b.get() != null) {
            return this;
        }
        throw fail("Not subscribed!");
    }
}
