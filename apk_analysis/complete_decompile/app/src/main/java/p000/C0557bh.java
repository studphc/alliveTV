package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: bh */
/* loaded from: classes2.dex */
public final class C0557bh extends AtomicReference implements Observer, Iterator, Disposable {
    private static final long serialVersionUID = 6695226475494099826L;

    /* renamed from: a */
    public final SpscLinkedArrayQueue f8009a;

    /* renamed from: b */
    public final ReentrantLock f8010b;

    /* renamed from: c */
    public final Condition f8011c;

    /* renamed from: d */
    public volatile boolean f8012d;

    /* renamed from: e */
    public volatile Throwable f8013e;

    public C0557bh(int i) {
        this.f8009a = new SpscLinkedArrayQueue(i);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f8010b = reentrantLock;
        this.f8011c = reentrantLock.newCondition();
    }

    /* renamed from: a */
    public final void m2096a() {
        ReentrantLock reentrantLock = this.f8010b;
        reentrantLock.lock();
        try {
            this.f8011c.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
        m2096a();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (!isDisposed()) {
            boolean z = this.f8012d;
            boolean isEmpty = this.f8009a.isEmpty();
            if (z) {
                Throwable th = this.f8013e;
                if (th == null) {
                    if (isEmpty) {
                        return false;
                    }
                } else {
                    throw ExceptionHelper.wrapOrThrow(th);
                }
            }
            if (isEmpty) {
                try {
                    BlockingHelper.verifyNonBlocking();
                    this.f8010b.lock();
                    while (!this.f8012d && this.f8009a.isEmpty() && !isDisposed()) {
                        try {
                            this.f8011c.await();
                        } finally {
                        }
                    }
                    this.f8010b.unlock();
                } catch (InterruptedException e) {
                    DisposableHelper.dispose(this);
                    m2096a();
                    throw ExceptionHelper.wrapOrThrow(e);
                }
            } else {
                return true;
            }
        }
        Throwable th2 = this.f8013e;
        if (th2 == null) {
            return false;
        }
        throw ExceptionHelper.wrapOrThrow(th2);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            return this.f8009a.poll();
        }
        throw new NoSuchElementException();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f8012d = true;
        m2096a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f8013e = th;
        this.f8012d = true;
        m2096a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f8009a.offer(obj);
        m2096a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
