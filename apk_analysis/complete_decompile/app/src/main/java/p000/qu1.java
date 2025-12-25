package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class qu1 extends AtomicInteger implements Observer, Disposable, Runnable {
    private static final long serialVersionUID = -6951100001833242599L;

    /* renamed from: a */
    public final Observer f25755a;

    /* renamed from: b */
    public final Function f25756b;

    /* renamed from: c */
    public final int f25757c;

    /* renamed from: d */
    public final AtomicThrowable f25758d = new AtomicThrowable();

    /* renamed from: e */
    public final pu1 f25759e;

    /* renamed from: f */
    public final boolean f25760f;

    /* renamed from: g */
    public final Scheduler.Worker f25761g;

    /* renamed from: h */
    public SimpleQueue f25762h;

    /* renamed from: i */
    public Disposable f25763i;

    /* renamed from: j */
    public volatile boolean f25764j;

    /* renamed from: k */
    public volatile boolean f25765k;

    /* renamed from: l */
    public volatile boolean f25766l;

    /* renamed from: m */
    public int f25767m;

    public qu1(Observer observer, Function function, int i, boolean z, Scheduler.Worker worker) {
        this.f25755a = observer;
        this.f25756b = function;
        this.f25757c = i;
        this.f25760f = z;
        this.f25759e = new pu1(observer, this);
        this.f25761g = worker;
    }

    /* renamed from: a */
    public final void m7147a() {
        if (getAndIncrement() != 0) {
            return;
        }
        this.f25761g.schedule(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f25766l = true;
        this.f25763i.dispose();
        pu1 pu1Var = this.f25759e;
        pu1Var.getClass();
        DisposableHelper.dispose(pu1Var);
        this.f25761g.dispose();
        this.f25758d.tryTerminateAndReport();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f25766l;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f25765k = true;
        m7147a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f25758d.tryAddThrowableOrReport(th)) {
            this.f25765k = true;
            m7147a();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f25767m == 0) {
            this.f25762h.offer(obj);
        }
        m7147a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f25763i, disposable)) {
            this.f25763i = disposable;
            if (disposable instanceof QueueDisposable) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(3);
                if (requestFusion == 1) {
                    this.f25767m = requestFusion;
                    this.f25762h = queueDisposable;
                    this.f25765k = true;
                    this.f25755a.onSubscribe(this);
                    m7147a();
                    return;
                }
                if (requestFusion == 2) {
                    this.f25767m = requestFusion;
                    this.f25762h = queueDisposable;
                    this.f25755a.onSubscribe(this);
                    return;
                }
            }
            this.f25762h = new SpscLinkedArrayQueue(this.f25757c);
            this.f25755a.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        Observer<?> observer = this.f25755a;
        SimpleQueue simpleQueue = this.f25762h;
        AtomicThrowable atomicThrowable = this.f25758d;
        while (true) {
            if (!this.f25764j) {
                if (this.f25766l) {
                    simpleQueue.clear();
                    return;
                }
                if (!this.f25760f && atomicThrowable.get() != null) {
                    simpleQueue.clear();
                    this.f25766l = true;
                    atomicThrowable.tryTerminateConsumer(observer);
                    this.f25761g.dispose();
                    return;
                }
                boolean z2 = this.f25765k;
                try {
                    Object poll = simpleQueue.poll();
                    if (poll == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z2 && z) {
                        this.f25766l = true;
                        atomicThrowable.tryTerminateConsumer(observer);
                        this.f25761g.dispose();
                        return;
                    }
                    if (!z) {
                        try {
                            Object apply = this.f25756b.apply(poll);
                            Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                            ObservableSource observableSource = (ObservableSource) apply;
                            if (observableSource instanceof Supplier) {
                                try {
                                    Object obj = ((Supplier) observableSource).get();
                                    if (obj != 0 && !this.f25766l) {
                                        observer.onNext(obj);
                                    }
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    atomicThrowable.tryAddThrowableOrReport(th);
                                }
                            } else {
                                this.f25764j = true;
                                observableSource.subscribe(this.f25759e);
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.f25766l = true;
                            this.f25763i.dispose();
                            simpleQueue.clear();
                            atomicThrowable.tryAddThrowableOrReport(th2);
                            atomicThrowable.tryTerminateConsumer(observer);
                            this.f25761g.dispose();
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.f25766l = true;
                    this.f25763i.dispose();
                    atomicThrowable.tryAddThrowableOrReport(th3);
                    atomicThrowable.tryTerminateConsumer(observer);
                    this.f25761g.dispose();
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }
}
