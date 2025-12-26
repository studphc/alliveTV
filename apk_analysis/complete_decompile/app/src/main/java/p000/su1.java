package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class su1 extends AtomicInteger implements Observer, Disposable, Runnable {
    private static final long serialVersionUID = 8828587559905699186L;

    /* renamed from: a */
    public final SerializedObserver f26558a;

    /* renamed from: b */
    public final Function f26559b;

    /* renamed from: c */
    public final ru1 f26560c;

    /* renamed from: d */
    public final int f26561d;

    /* renamed from: e */
    public final Scheduler.Worker f26562e;

    /* renamed from: f */
    public SimpleQueue f26563f;

    /* renamed from: g */
    public Disposable f26564g;

    /* renamed from: h */
    public volatile boolean f26565h;

    /* renamed from: i */
    public volatile boolean f26566i;

    /* renamed from: j */
    public volatile boolean f26567j;

    /* renamed from: k */
    public int f26568k;

    public su1(SerializedObserver serializedObserver, Function function, int i, Scheduler.Worker worker) {
        this.f26558a = serializedObserver;
        this.f26559b = function;
        this.f26561d = i;
        this.f26560c = new ru1(serializedObserver, this);
        this.f26562e = worker;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f26566i = true;
        ru1 ru1Var = this.f26560c;
        ru1Var.getClass();
        DisposableHelper.dispose(ru1Var);
        this.f26564g.dispose();
        this.f26562e.dispose();
        if (getAndIncrement() == 0) {
            this.f26563f.clear();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f26566i;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (this.f26567j) {
            return;
        }
        this.f26567j = true;
        if (getAndIncrement() == 0) {
            this.f26562e.schedule(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f26567j) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f26567j = true;
        dispose();
        this.f26558a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f26567j) {
            return;
        }
        if (this.f26568k == 0) {
            this.f26563f.offer(obj);
        }
        if (getAndIncrement() == 0) {
            this.f26562e.schedule(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f26564g, disposable)) {
            this.f26564g = disposable;
            if (disposable instanceof QueueDisposable) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(3);
                if (requestFusion == 1) {
                    this.f26568k = requestFusion;
                    this.f26563f = queueDisposable;
                    this.f26567j = true;
                    this.f26558a.onSubscribe(this);
                    if (getAndIncrement() == 0) {
                        this.f26562e.schedule(this);
                        return;
                    }
                    return;
                }
                if (requestFusion == 2) {
                    this.f26568k = requestFusion;
                    this.f26563f = queueDisposable;
                    this.f26558a.onSubscribe(this);
                    return;
                }
            }
            this.f26563f = new SpscLinkedArrayQueue(this.f26561d);
            this.f26558a.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        while (!this.f26566i) {
            if (!this.f26565h) {
                boolean z2 = this.f26567j;
                try {
                    Object poll = this.f26563f.poll();
                    if (poll == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z2 && z) {
                        this.f26566i = true;
                        this.f26558a.onComplete();
                        this.f26562e.dispose();
                        return;
                    } else if (!z) {
                        try {
                            Object apply = this.f26559b.apply(poll);
                            Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                            ObservableSource observableSource = (ObservableSource) apply;
                            this.f26565h = true;
                            observableSource.subscribe(this.f26560c);
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            dispose();
                            this.f26563f.clear();
                            this.f26558a.onError(th);
                            this.f26562e.dispose();
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    dispose();
                    this.f26563f.clear();
                    this.f26558a.onError(th2);
                    this.f26562e.dispose();
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
        this.f26563f.clear();
    }
}
