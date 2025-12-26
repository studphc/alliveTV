package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class jw1 implements QueueDisposable {

    /* renamed from: a */
    public final Observer f20659a;

    /* renamed from: b */
    public Iterator f20660b;

    /* renamed from: c */
    public AutoCloseable f20661c;

    /* renamed from: d */
    public volatile boolean f20662d;

    /* renamed from: e */
    public boolean f20663e;

    /* renamed from: f */
    public boolean f20664f;

    public jw1(Observer observer, Iterator it, AutoCloseable autoCloseable) {
        this.f20659a = observer;
        this.f20660b = it;
        this.f20661c = autoCloseable;
    }

    /* renamed from: a */
    public final void m5464a() {
        if (this.f20664f) {
            return;
        }
        Iterator it = this.f20660b;
        Observer observer = this.f20659a;
        while (!this.f20662d) {
            try {
                Object next = it.next();
                Objects.requireNonNull(next, "The Stream's Iterator.next returned a null value");
                if (!this.f20662d) {
                    observer.onNext(next);
                    if (!this.f20662d) {
                        try {
                            if (!it.hasNext()) {
                                observer.onComplete();
                                this.f20662d = true;
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            observer.onError(th);
                            this.f20662d = true;
                        }
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                observer.onError(th2);
                this.f20662d = true;
            }
        }
        clear();
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f20660b = null;
        AutoCloseable autoCloseable = this.f20661c;
        this.f20661c = null;
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f20662d = true;
        m5464a();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f20662d;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        Iterator it = this.f20660b;
        if (it != null) {
            if (this.f20663e && !it.hasNext()) {
                clear();
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue, java.util.Queue
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        Iterator it = this.f20660b;
        if (it == null) {
            return null;
        }
        if (!this.f20663e) {
            this.f20663e = true;
        } else if (!it.hasNext()) {
            clear();
            return null;
        }
        Object next = this.f20660b.next();
        Objects.requireNonNull(next, "The Stream's Iterator.next() returned a null value");
        return next;
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        if ((i & 1) != 0) {
            this.f20664f = true;
            return 1;
        }
        return 0;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }
}
