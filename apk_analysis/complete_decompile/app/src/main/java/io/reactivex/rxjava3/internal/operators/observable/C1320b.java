package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableGroupBy;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: io.reactivex.rxjava3.internal.operators.observable.b */
/* loaded from: classes2.dex */
public final class C1320b extends AtomicInteger implements Disposable, ObservableSource {
    private static final long serialVersionUID = -3852313036005250360L;

    /* renamed from: a */
    public final Object f19642a;

    /* renamed from: b */
    public final SpscLinkedArrayQueue f19643b;

    /* renamed from: c */
    public final ObservableGroupBy.GroupByObserver f19644c;

    /* renamed from: d */
    public final boolean f19645d;

    /* renamed from: e */
    public volatile boolean f19646e;

    /* renamed from: f */
    public Throwable f19647f;

    /* renamed from: g */
    public final AtomicBoolean f19648g = new AtomicBoolean();

    /* renamed from: h */
    public final AtomicReference f19649h = new AtomicReference();

    /* renamed from: i */
    public final AtomicInteger f19650i = new AtomicInteger();

    public C1320b(int i, ObservableGroupBy.GroupByObserver groupByObserver, Object obj, boolean z) {
        this.f19643b = new SpscLinkedArrayQueue(i);
        this.f19644c = groupByObserver;
        this.f19642a = obj;
        this.f19645d = z;
    }

    /* renamed from: a */
    public final void m5295a() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f19643b;
        boolean z2 = this.f19645d;
        Observer observer = (Observer) this.f19649h.get();
        int i = 1;
        while (true) {
            if (observer != null) {
                while (true) {
                    boolean z3 = this.f19646e;
                    Object poll = spscLinkedArrayQueue.poll();
                    if (poll == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean z4 = this.f19648g.get();
                    SpscLinkedArrayQueue spscLinkedArrayQueue2 = this.f19643b;
                    AtomicReference atomicReference = this.f19649h;
                    if (z4) {
                        spscLinkedArrayQueue2.clear();
                        atomicReference.lazySet(null);
                        if ((this.f19650i.get() & 2) == 0) {
                            this.f19644c.cancel(this.f19642a);
                            return;
                        }
                        return;
                    }
                    if (z3) {
                        if (z2) {
                            if (z) {
                                Throwable th = this.f19647f;
                                atomicReference.lazySet(null);
                                if (th != null) {
                                    observer.onError(th);
                                    return;
                                } else {
                                    observer.onComplete();
                                    return;
                                }
                            }
                        } else {
                            Throwable th2 = this.f19647f;
                            if (th2 != null) {
                                spscLinkedArrayQueue2.clear();
                                atomicReference.lazySet(null);
                                observer.onError(th2);
                                return;
                            } else if (z) {
                                atomicReference.lazySet(null);
                                observer.onComplete();
                                return;
                            }
                        }
                    }
                    if (z) {
                        break;
                    } else {
                        observer.onNext(poll);
                    }
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
            if (observer == null) {
                observer = (Observer) this.f19649h.get();
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (this.f19648g.compareAndSet(false, true) && getAndIncrement() == 0) {
            this.f19649h.lazySet(null);
            if ((this.f19650i.get() & 2) == 0) {
                this.f19644c.cancel(this.f19642a);
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f19648g.get();
    }

    @Override // io.reactivex.rxjava3.core.ObservableSource
    public final void subscribe(Observer observer) {
        AtomicInteger atomicInteger;
        int i;
        do {
            atomicInteger = this.f19650i;
            i = atomicInteger.get();
            if ((i & 1) != 0) {
                EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), (Observer<?>) observer);
                return;
            }
        } while (!atomicInteger.compareAndSet(i, i | 1));
        observer.onSubscribe(this);
        AtomicReference atomicReference = this.f19649h;
        atomicReference.lazySet(observer);
        if (this.f19648g.get()) {
            atomicReference.lazySet(null);
        } else {
            m5295a();
        }
    }
}
