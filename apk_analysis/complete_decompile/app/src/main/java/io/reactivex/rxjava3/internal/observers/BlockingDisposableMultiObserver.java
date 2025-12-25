package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import java.util.concurrent.CountDownLatch;
import p000.AbstractC0002a1;
import p000.g50;

/* loaded from: classes2.dex */
public final class BlockingDisposableMultiObserver<T> extends CountDownLatch implements MaybeObserver<T>, SingleObserver<T>, CompletableObserver, Disposable {

    /* renamed from: a */
    public Object f18593a;

    /* renamed from: b */
    public Throwable f18594b;

    /* renamed from: c */
    public final SequentialDisposable f18595c;

    public BlockingDisposableMultiObserver() {
        super(1);
        this.f18595c = new SequentialDisposable();
    }

    public void blockingConsume(CompletableObserver completableObserver) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                dispose();
                completableObserver.onError(e);
                return;
            }
        }
        if (isDisposed()) {
            return;
        }
        Throwable th = this.f18594b;
        if (th != null) {
            completableObserver.onError(th);
        } else {
            completableObserver.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        this.f18595c.dispose();
        countDown();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return this.f18595c.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onComplete() {
        this.f18595c.lazySet(g50.m4919a());
        countDown();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onError(@NonNull Throwable th) {
        this.f18594b = th;
        this.f18595c.lazySet(g50.m4919a());
        countDown();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onSubscribe(@NonNull Disposable disposable) {
        DisposableHelper.setOnce(this.f18595c, disposable);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onSuccess(@NonNull T t) {
        this.f18593a = t;
        this.f18595c.lazySet(g50.m4919a());
        countDown();
    }

    public void blockingConsume(SingleObserver<? super T> singleObserver) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                dispose();
                singleObserver.onError(e);
                return;
            }
        }
        if (isDisposed()) {
            return;
        }
        Throwable th = this.f18594b;
        if (th != null) {
            singleObserver.onError(th);
        } else {
            singleObserver.onSuccess((Object) this.f18593a);
        }
    }

    public void blockingConsume(MaybeObserver<? super T> maybeObserver) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                dispose();
                maybeObserver.onError(e);
                return;
            }
        }
        if (isDisposed()) {
            return;
        }
        Throwable th = this.f18594b;
        if (th != null) {
            maybeObserver.onError(th);
            return;
        }
        AbstractC0002a1 abstractC0002a1 = (Object) this.f18593a;
        if (abstractC0002a1 == null) {
            maybeObserver.onComplete();
        } else {
            maybeObserver.onSuccess(abstractC0002a1);
        }
    }
}
