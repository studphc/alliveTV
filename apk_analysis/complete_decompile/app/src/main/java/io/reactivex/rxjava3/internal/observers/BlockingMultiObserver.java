package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p000.AbstractC0002a1;

/* loaded from: classes2.dex */
public final class BlockingMultiObserver<T> extends CountDownLatch implements SingleObserver<T>, CompletableObserver, MaybeObserver<T> {

    /* renamed from: a */
    public Object f18596a;

    /* renamed from: b */
    public Throwable f18597b;

    /* renamed from: c */
    public Disposable f18598c;

    /* renamed from: d */
    public volatile boolean f18599d;

    public BlockingMultiObserver() {
        super(1);
    }

    /* renamed from: a */
    public final void m5272a() {
        this.f18599d = true;
        Disposable disposable = this.f18598c;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public boolean blockingAwait(long j, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                if (!await(j, timeUnit)) {
                    m5272a();
                    return false;
                }
            } catch (InterruptedException e) {
                m5272a();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.f18597b;
        if (th == null) {
            return true;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }

    public void blockingConsume(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        try {
            if (getCount() != 0) {
                try {
                    BlockingHelper.verifyNonBlocking();
                    await();
                } catch (InterruptedException e) {
                    m5272a();
                    consumer2.accept(e);
                    return;
                }
            }
            Throwable th = this.f18597b;
            if (th != null) {
                consumer2.accept(th);
                return;
            }
            AbstractC0002a1 abstractC0002a1 = (Object) this.f18596a;
            if (abstractC0002a1 != null) {
                consumer.accept(abstractC0002a1);
            } else {
                action.run();
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(th2);
        }
    }

    public T blockingGet() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                m5272a();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.f18597b;
        if (th == null) {
            return (T) this.f18596a;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public void onComplete() {
        countDown();
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onError(Throwable th) {
        this.f18597b = th;
        countDown();
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onSubscribe(Disposable disposable) {
        this.f18598c = disposable;
        if (this.f18599d) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onSuccess(T t) {
        this.f18596a = t;
        countDown();
    }

    public T blockingGet(T t) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                m5272a();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.f18597b;
        if (th == null) {
            T t2 = (T) this.f18596a;
            return t2 != null ? t2 : t;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }
}
