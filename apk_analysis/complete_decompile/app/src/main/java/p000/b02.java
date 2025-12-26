package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class b02 extends AtomicInteger implements Observer, Disposable, Runnable {

    /* renamed from: k */
    public static final Object f7834k = new Object();
    private static final long serialVersionUID = 2233020065421370272L;

    /* renamed from: a */
    public final Observer f7835a;

    /* renamed from: b */
    public final int f7836b;

    /* renamed from: c */
    public final a02 f7837c = new a02(this);

    /* renamed from: d */
    public final AtomicReference f7838d = new AtomicReference();

    /* renamed from: e */
    public final AtomicInteger f7839e = new AtomicInteger(1);

    /* renamed from: f */
    public final MpscLinkedQueue f7840f = new MpscLinkedQueue();

    /* renamed from: g */
    public final AtomicThrowable f7841g = new AtomicThrowable();

    /* renamed from: h */
    public final AtomicBoolean f7842h = new AtomicBoolean();

    /* renamed from: i */
    public volatile boolean f7843i;

    /* renamed from: j */
    public UnicastSubject f7844j;

    public b02(Observer observer, int i) {
        this.f7835a = observer;
        this.f7836b = i;
    }

    /* renamed from: a */
    public final void m2002a() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        Observer observer = this.f7835a;
        MpscLinkedQueue mpscLinkedQueue = this.f7840f;
        AtomicThrowable atomicThrowable = this.f7841g;
        int i = 1;
        while (this.f7839e.get() != 0) {
            UnicastSubject unicastSubject = this.f7844j;
            boolean z2 = this.f7843i;
            if (z2 && atomicThrowable.get() != null) {
                mpscLinkedQueue.clear();
                Throwable terminate = atomicThrowable.terminate();
                if (unicastSubject != null) {
                    this.f7844j = null;
                    unicastSubject.onError(terminate);
                }
                observer.onError(terminate);
                return;
            }
            Object poll = mpscLinkedQueue.poll();
            if (poll == null) {
                z = true;
            } else {
                z = false;
            }
            if (z2 && z) {
                Throwable terminate2 = atomicThrowable.terminate();
                if (terminate2 == null) {
                    if (unicastSubject != null) {
                        this.f7844j = null;
                        unicastSubject.onComplete();
                    }
                    observer.onComplete();
                    return;
                }
                if (unicastSubject != null) {
                    this.f7844j = null;
                    unicastSubject.onError(terminate2);
                }
                observer.onError(terminate2);
                return;
            }
            if (z) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else if (poll != f7834k) {
                unicastSubject.onNext(poll);
            } else {
                if (unicastSubject != null) {
                    this.f7844j = null;
                    unicastSubject.onComplete();
                }
                if (!this.f7842h.get()) {
                    UnicastSubject create = UnicastSubject.create(this.f7836b, this);
                    this.f7844j = create;
                    this.f7839e.getAndIncrement();
                    ux1 ux1Var = new ux1(create);
                    observer.onNext(ux1Var);
                    if (ux1Var.m7788d()) {
                        create.onComplete();
                    }
                }
            }
        }
        mpscLinkedQueue.clear();
        this.f7844j = null;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (this.f7842h.compareAndSet(false, true)) {
            this.f7837c.dispose();
            if (this.f7839e.decrementAndGet() == 0) {
                DisposableHelper.dispose(this.f7838d);
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f7842h.get();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f7837c.dispose();
        this.f7843i = true;
        m2002a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f7837c.dispose();
        if (this.f7841g.tryAddThrowableOrReport(th)) {
            this.f7843i = true;
            m2002a();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f7840f.offer(obj);
        m2002a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this.f7838d, disposable)) {
            this.f7840f.offer(f7834k);
            m2002a();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f7839e.decrementAndGet() == 0) {
            DisposableHelper.dispose(this.f7838d);
        }
    }
}
