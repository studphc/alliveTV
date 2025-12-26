package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes2.dex */
public abstract class BlockingBaseObserver<T> extends CountDownLatch implements Observer<T>, Disposable {

    /* renamed from: a */
    public Object f18589a;

    /* renamed from: b */
    public Throwable f18590b;

    /* renamed from: c */
    public Disposable f18591c;

    /* renamed from: d */
    public volatile boolean f18592d;

    public BlockingBaseObserver() {
        super(1);
    }

    public final T blockingGet() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                dispose();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.f18590b;
        if (th == null) {
            return (T) this.f18589a;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f18592d = true;
        Disposable disposable = this.f18591c;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f18592d;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        countDown();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        this.f18591c = disposable;
        if (this.f18592d) {
            disposable.dispose();
        }
    }
}
