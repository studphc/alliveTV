package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.InnerQueuedObserver;
import io.reactivex.rxjava3.internal.observers.InnerQueuedObserverSupport;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class mu1 extends AtomicInteger implements Observer, Disposable, InnerQueuedObserverSupport {
    private static final long serialVersionUID = 8080567949447303262L;

    /* renamed from: a */
    public final Observer f23118a;

    /* renamed from: b */
    public final Function f23119b;

    /* renamed from: c */
    public final int f23120c;

    /* renamed from: d */
    public final int f23121d;

    /* renamed from: e */
    public final ErrorMode f23122e;

    /* renamed from: f */
    public final AtomicThrowable f23123f = new AtomicThrowable();

    /* renamed from: g */
    public final ArrayDeque f23124g = new ArrayDeque();

    /* renamed from: h */
    public SimpleQueue f23125h;

    /* renamed from: i */
    public Disposable f23126i;

    /* renamed from: j */
    public volatile boolean f23127j;

    /* renamed from: k */
    public int f23128k;

    /* renamed from: l */
    public volatile boolean f23129l;

    /* renamed from: m */
    public InnerQueuedObserver f23130m;

    /* renamed from: n */
    public int f23131n;

    public mu1(Observer observer, Function function, int i, int i2, ErrorMode errorMode) {
        this.f23118a = observer;
        this.f23119b = function;
        this.f23120c = i;
        this.f23121d = i2;
        this.f23122e = errorMode;
    }

    /* renamed from: a */
    public final void m6259a() {
        InnerQueuedObserver innerQueuedObserver = this.f23130m;
        if (innerQueuedObserver != null) {
            innerQueuedObserver.dispose();
        }
        while (true) {
            InnerQueuedObserver innerQueuedObserver2 = (InnerQueuedObserver) this.f23124g.poll();
            if (innerQueuedObserver2 == null) {
                return;
            } else {
                innerQueuedObserver2.dispose();
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (this.f23129l) {
            return;
        }
        this.f23129l = true;
        this.f23126i.dispose();
        this.f23123f.tryTerminateAndReport();
        if (getAndIncrement() != 0) {
            return;
        }
        do {
            this.f23125h.clear();
            m6259a();
        } while (decrementAndGet() != 0);
    }

    @Override // io.reactivex.rxjava3.internal.observers.InnerQueuedObserverSupport
    public final void drain() {
        Object poll;
        boolean z;
        boolean z2;
        if (getAndIncrement() != 0) {
            return;
        }
        SimpleQueue simpleQueue = this.f23125h;
        ArrayDeque arrayDeque = this.f23124g;
        Observer<?> observer = this.f23118a;
        ErrorMode errorMode = this.f23122e;
        int i = 1;
        while (true) {
            int i2 = this.f23131n;
            while (i2 != this.f23120c) {
                if (this.f23129l) {
                    simpleQueue.clear();
                    m6259a();
                    return;
                }
                if (errorMode == ErrorMode.IMMEDIATE && this.f23123f.get() != null) {
                    simpleQueue.clear();
                    m6259a();
                    this.f23123f.tryTerminateConsumer(this.f23118a);
                    return;
                }
                try {
                    Object poll2 = simpleQueue.poll();
                    if (poll2 == null) {
                        break;
                    }
                    Object apply = this.f23119b.apply(poll2);
                    Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                    ObservableSource observableSource = (ObservableSource) apply;
                    InnerQueuedObserver innerQueuedObserver = new InnerQueuedObserver(this, this.f23121d);
                    arrayDeque.offer(innerQueuedObserver);
                    observableSource.subscribe(innerQueuedObserver);
                    i2++;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f23126i.dispose();
                    simpleQueue.clear();
                    m6259a();
                    this.f23123f.tryAddThrowableOrReport(th);
                    this.f23123f.tryTerminateConsumer(this.f23118a);
                    return;
                }
            }
            this.f23131n = i2;
            if (this.f23129l) {
                simpleQueue.clear();
                m6259a();
                return;
            }
            if (errorMode == ErrorMode.IMMEDIATE && this.f23123f.get() != null) {
                simpleQueue.clear();
                m6259a();
                this.f23123f.tryTerminateConsumer(this.f23118a);
                return;
            }
            InnerQueuedObserver innerQueuedObserver2 = this.f23130m;
            if (innerQueuedObserver2 == null) {
                if (errorMode == ErrorMode.BOUNDARY && this.f23123f.get() != null) {
                    simpleQueue.clear();
                    m6259a();
                    this.f23123f.tryTerminateConsumer(observer);
                    return;
                }
                boolean z3 = this.f23127j;
                InnerQueuedObserver innerQueuedObserver3 = (InnerQueuedObserver) arrayDeque.poll();
                if (innerQueuedObserver3 == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z3 && z2) {
                    if (this.f23123f.get() != null) {
                        simpleQueue.clear();
                        m6259a();
                        this.f23123f.tryTerminateConsumer(observer);
                        return;
                    }
                    observer.onComplete();
                    return;
                }
                if (!z2) {
                    this.f23130m = innerQueuedObserver3;
                }
                innerQueuedObserver2 = innerQueuedObserver3;
            }
            if (innerQueuedObserver2 != null) {
                SimpleQueue queue = innerQueuedObserver2.queue();
                while (!this.f23129l) {
                    boolean isDone = innerQueuedObserver2.isDone();
                    if (errorMode == ErrorMode.IMMEDIATE && this.f23123f.get() != null) {
                        simpleQueue.clear();
                        m6259a();
                        this.f23123f.tryTerminateConsumer(observer);
                        return;
                    }
                    try {
                        poll = queue.poll();
                        if (poll == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f23123f.tryAddThrowableOrReport(th2);
                        this.f23130m = null;
                        this.f23131n--;
                    }
                    if (isDone && z) {
                        this.f23130m = null;
                        this.f23131n--;
                    } else if (!z) {
                        observer.onNext(poll);
                    }
                }
                simpleQueue.clear();
                m6259a();
                return;
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.internal.observers.InnerQueuedObserverSupport
    public final void innerComplete(InnerQueuedObserver innerQueuedObserver) {
        innerQueuedObserver.setDone();
        drain();
    }

    @Override // io.reactivex.rxjava3.internal.observers.InnerQueuedObserverSupport
    public final void innerError(InnerQueuedObserver innerQueuedObserver, Throwable th) {
        if (this.f23123f.tryAddThrowableOrReport(th)) {
            if (this.f23122e == ErrorMode.IMMEDIATE) {
                this.f23126i.dispose();
            }
            innerQueuedObserver.setDone();
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.internal.observers.InnerQueuedObserverSupport
    public final void innerNext(InnerQueuedObserver innerQueuedObserver, Object obj) {
        innerQueuedObserver.queue().offer(obj);
        drain();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f23129l;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f23127j = true;
        drain();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f23123f.tryAddThrowableOrReport(th)) {
            this.f23127j = true;
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f23128k == 0) {
            this.f23125h.offer(obj);
        }
        drain();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f23126i, disposable)) {
            this.f23126i = disposable;
            if (disposable instanceof QueueDisposable) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(3);
                if (requestFusion == 1) {
                    this.f23128k = requestFusion;
                    this.f23125h = queueDisposable;
                    this.f23127j = true;
                    this.f23118a.onSubscribe(this);
                    drain();
                    return;
                }
                if (requestFusion == 2) {
                    this.f23128k = requestFusion;
                    this.f23125h = queueDisposable;
                    this.f23118a.onSubscribe(this);
                    return;
                }
            }
            this.f23125h = new SpscLinkedArrayQueue(this.f23121d);
            this.f23118a.onSubscribe(this);
        }
    }
}
