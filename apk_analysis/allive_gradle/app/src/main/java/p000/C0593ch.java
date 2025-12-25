package p000;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ch */
/* loaded from: classes2.dex */
public final class C0593ch extends DisposableObserver implements Iterator {

    /* renamed from: b */
    public Notification f8362b;

    /* renamed from: c */
    public final Semaphore f8363c = new Semaphore(0);

    /* renamed from: d */
    public final AtomicReference f8364d = new AtomicReference();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Notification notification = this.f8362b;
        if (notification != null && notification.isOnError()) {
            throw ExceptionHelper.wrapOrThrow(this.f8362b.getError());
        }
        if (this.f8362b == null) {
            try {
                BlockingHelper.verifyNonBlocking();
                this.f8363c.acquire();
                Notification notification2 = (Notification) this.f8364d.getAndSet(null);
                this.f8362b = notification2;
                if (notification2.isOnError()) {
                    throw ExceptionHelper.wrapOrThrow(notification2.getError());
                }
            } catch (InterruptedException e) {
                dispose();
                this.f8362b = Notification.createOnError(e);
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        return this.f8362b.isOnNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            Object value = this.f8362b.getValue();
            this.f8362b = null;
            return value;
        }
        throw new NoSuchElementException();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f8364d.getAndSet((Notification) obj) == null) {
            this.f8363c.release();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Read-only iterator.");
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
    }
}
