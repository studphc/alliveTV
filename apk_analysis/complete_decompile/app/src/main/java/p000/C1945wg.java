package p000;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: wg */
/* loaded from: classes2.dex */
public final class C1945wg extends DisposableSubscriber implements Iterator {

    /* renamed from: b */
    public final Semaphore f28174b = new Semaphore(0);

    /* renamed from: c */
    public final AtomicReference f28175c = new AtomicReference();

    /* renamed from: d */
    public Notification f28176d;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Notification notification = this.f28176d;
        if (notification != null && notification.isOnError()) {
            throw ExceptionHelper.wrapOrThrow(this.f28176d.getError());
        }
        Notification notification2 = this.f28176d;
        if ((notification2 == null || notification2.isOnNext()) && this.f28176d == null) {
            try {
                BlockingHelper.verifyNonBlocking();
                this.f28174b.acquire();
                Notification notification3 = (Notification) this.f28175c.getAndSet(null);
                this.f28176d = notification3;
                if (notification3.isOnError()) {
                    throw ExceptionHelper.wrapOrThrow(notification3.getError());
                }
            } catch (InterruptedException e) {
                dispose();
                this.f28176d = Notification.createOnError(e);
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        return this.f28176d.isOnNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext() && this.f28176d.isOnNext()) {
            Object value = this.f28176d.getValue();
            this.f28176d = null;
            return value;
        }
        throw new NoSuchElementException();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f28175c.getAndSet((Notification) obj) == null) {
            this.f28174b.release();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Read-only iterator.");
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
    }
}
