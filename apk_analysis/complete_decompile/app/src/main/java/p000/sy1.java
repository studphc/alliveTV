package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class sy1 extends AtomicInteger implements Observer, Disposable {
    private static final long serialVersionUID = -5677354903406201275L;

    /* renamed from: a */
    public final Observer f26619a;

    /* renamed from: b */
    public final long f26620b;

    /* renamed from: c */
    public final TimeUnit f26621c;

    /* renamed from: d */
    public final Scheduler f26622d;

    /* renamed from: e */
    public final SpscLinkedArrayQueue f26623e;

    /* renamed from: f */
    public final boolean f26624f;

    /* renamed from: g */
    public Disposable f26625g;

    /* renamed from: h */
    public volatile boolean f26626h;

    /* renamed from: i */
    public volatile boolean f26627i;

    /* renamed from: j */
    public Throwable f26628j;

    public sy1(Observer observer, long j, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        this.f26619a = observer;
        this.f26620b = j;
        this.f26621c = timeUnit;
        this.f26622d = scheduler;
        this.f26623e = new SpscLinkedArrayQueue(i);
        this.f26624f = z;
    }

    /* renamed from: a */
    public final void m7425a() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        Observer observer = this.f26619a;
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f26623e;
        boolean z2 = this.f26624f;
        TimeUnit timeUnit = this.f26621c;
        Scheduler scheduler = this.f26622d;
        long j = this.f26620b;
        int i = 1;
        while (!this.f26626h) {
            boolean z3 = this.f26627i;
            Long l = (Long) spscLinkedArrayQueue.peek();
            if (l == null) {
                z = true;
            } else {
                z = false;
            }
            long now = scheduler.now(timeUnit);
            if (!z && l.longValue() > now - j) {
                z = true;
            }
            if (z3) {
                if (z2) {
                    if (z) {
                        Throwable th = this.f26628j;
                        if (th != null) {
                            observer.onError(th);
                            return;
                        } else {
                            observer.onComplete();
                            return;
                        }
                    }
                } else {
                    Throwable th2 = this.f26628j;
                    if (th2 != null) {
                        this.f26623e.clear();
                        observer.onError(th2);
                        return;
                    } else if (z) {
                        observer.onComplete();
                        return;
                    }
                }
            }
            if (z) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                spscLinkedArrayQueue.poll();
                observer.onNext(spscLinkedArrayQueue.poll());
            }
        }
        this.f26623e.clear();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (!this.f26626h) {
            this.f26626h = true;
            this.f26625g.dispose();
            if (getAndIncrement() == 0) {
                this.f26623e.clear();
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f26626h;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f26627i = true;
        m7425a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f26628j = th;
        this.f26627i = true;
        m7425a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f26623e.offer(Long.valueOf(this.f26622d.now(this.f26621c)), obj);
        m7425a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f26625g, disposable)) {
            this.f26625g = disposable;
            this.f26619a.onSubscribe(this);
        }
    }
}
