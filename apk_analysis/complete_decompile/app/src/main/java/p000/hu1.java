package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
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
public final class hu1 extends AtomicInteger implements Observer, Disposable {
    private static final long serialVersionUID = -6951100001833242599L;

    /* renamed from: a */
    public final Observer f18183a;

    /* renamed from: b */
    public final Function f18184b;

    /* renamed from: c */
    public final int f18185c;

    /* renamed from: d */
    public final AtomicThrowable f18186d = new AtomicThrowable();

    /* renamed from: e */
    public final gu1 f18187e;

    /* renamed from: f */
    public final boolean f18188f;

    /* renamed from: g */
    public SimpleQueue f18189g;

    /* renamed from: h */
    public Disposable f18190h;

    /* renamed from: i */
    public volatile boolean f18191i;

    /* renamed from: j */
    public volatile boolean f18192j;

    /* renamed from: k */
    public volatile boolean f18193k;

    /* renamed from: l */
    public int f18194l;

    public hu1(Observer observer, Function function, int i, boolean z) {
        this.f18183a = observer;
        this.f18184b = function;
        this.f18185c = i;
        this.f18188f = z;
        this.f18187e = new gu1(observer, this);
    }

    /* renamed from: a */
    public final void m5131a() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        Observer<?> observer = this.f18183a;
        SimpleQueue simpleQueue = this.f18189g;
        AtomicThrowable atomicThrowable = this.f18186d;
        while (true) {
            if (!this.f18191i) {
                if (this.f18193k) {
                    simpleQueue.clear();
                    return;
                }
                if (!this.f18188f && atomicThrowable.get() != null) {
                    simpleQueue.clear();
                    this.f18193k = true;
                    atomicThrowable.tryTerminateConsumer(observer);
                    return;
                }
                boolean z2 = this.f18192j;
                try {
                    Object poll = simpleQueue.poll();
                    if (poll == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z2 && z) {
                        this.f18193k = true;
                        atomicThrowable.tryTerminateConsumer(observer);
                        return;
                    }
                    if (!z) {
                        try {
                            Object apply = this.f18184b.apply(poll);
                            Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                            ObservableSource observableSource = (ObservableSource) apply;
                            if (observableSource instanceof Supplier) {
                                try {
                                    Object obj = ((Supplier) observableSource).get();
                                    if (obj != 0 && !this.f18193k) {
                                        observer.onNext(obj);
                                    }
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    atomicThrowable.tryAddThrowableOrReport(th);
                                }
                            } else {
                                this.f18191i = true;
                                observableSource.subscribe(this.f18187e);
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.f18193k = true;
                            this.f18190h.dispose();
                            simpleQueue.clear();
                            atomicThrowable.tryAddThrowableOrReport(th2);
                            atomicThrowable.tryTerminateConsumer(observer);
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.f18193k = true;
                    this.f18190h.dispose();
                    atomicThrowable.tryAddThrowableOrReport(th3);
                    atomicThrowable.tryTerminateConsumer(observer);
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f18193k = true;
        this.f18190h.dispose();
        gu1 gu1Var = this.f18187e;
        gu1Var.getClass();
        DisposableHelper.dispose(gu1Var);
        this.f18186d.tryTerminateAndReport();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f18193k;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f18192j = true;
        m5131a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f18186d.tryAddThrowableOrReport(th)) {
            this.f18192j = true;
            m5131a();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f18194l == 0) {
            this.f18189g.offer(obj);
        }
        m5131a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f18190h, disposable)) {
            this.f18190h = disposable;
            if (disposable instanceof QueueDisposable) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(3);
                if (requestFusion == 1) {
                    this.f18194l = requestFusion;
                    this.f18189g = queueDisposable;
                    this.f18192j = true;
                    this.f18183a.onSubscribe(this);
                    m5131a();
                    return;
                }
                if (requestFusion == 2) {
                    this.f18194l = requestFusion;
                    this.f18189g = queueDisposable;
                    this.f18183a.onSubscribe(this);
                    return;
                }
            }
            this.f18189g = new SpscLinkedArrayQueue(this.f18185c);
            this.f18183a.onSubscribe(this);
        }
    }
}
