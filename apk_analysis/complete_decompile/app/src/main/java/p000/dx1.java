package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class dx1 extends BasicIntQueueDisposable implements Observer, Runnable {
    private static final long serialVersionUID = 6576896619930983584L;

    /* renamed from: a */
    public final Observer f16578a;

    /* renamed from: b */
    public final Scheduler.Worker f16579b;

    /* renamed from: c */
    public final boolean f16580c;

    /* renamed from: d */
    public final int f16581d;

    /* renamed from: e */
    public SimpleQueue f16582e;

    /* renamed from: f */
    public Disposable f16583f;

    /* renamed from: g */
    public Throwable f16584g;

    /* renamed from: h */
    public volatile boolean f16585h;

    /* renamed from: i */
    public volatile boolean f16586i;

    /* renamed from: j */
    public int f16587j;

    /* renamed from: k */
    public boolean f16588k;

    public dx1(Observer observer, Scheduler.Worker worker, boolean z, int i) {
        this.f16578a = observer;
        this.f16579b = worker;
        this.f16580c = z;
        this.f16581d = i;
    }

    /* renamed from: a */
    public final boolean m4632a(boolean z, boolean z2, Observer observer) {
        if (this.f16586i) {
            this.f16582e.clear();
            return true;
        }
        if (z) {
            Throwable th = this.f16584g;
            if (this.f16580c) {
                if (z2) {
                    this.f16586i = true;
                    if (th != null) {
                        observer.onError(th);
                    } else {
                        observer.onComplete();
                    }
                    this.f16579b.dispose();
                    return true;
                }
                return false;
            }
            if (th != null) {
                this.f16586i = true;
                this.f16582e.clear();
                observer.onError(th);
                this.f16579b.dispose();
                return true;
            }
            if (z2) {
                this.f16586i = true;
                observer.onComplete();
                this.f16579b.dispose();
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f16582e.clear();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (!this.f16586i) {
            this.f16586i = true;
            this.f16583f.dispose();
            this.f16579b.dispose();
            if (!this.f16588k && getAndIncrement() == 0) {
                this.f16582e.clear();
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f16586i;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        return this.f16582e.isEmpty();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (this.f16585h) {
            return;
        }
        this.f16585h = true;
        if (getAndIncrement() == 0) {
            this.f16579b.schedule(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f16585h) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f16584g = th;
        this.f16585h = true;
        if (getAndIncrement() == 0) {
            this.f16579b.schedule(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f16585h) {
            return;
        }
        if (this.f16587j != 2) {
            this.f16582e.offer(obj);
        }
        if (getAndIncrement() == 0) {
            this.f16579b.schedule(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f16583f, disposable)) {
            this.f16583f = disposable;
            if (disposable instanceof QueueDisposable) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(7);
                if (requestFusion == 1) {
                    this.f16587j = requestFusion;
                    this.f16582e = queueDisposable;
                    this.f16585h = true;
                    this.f16578a.onSubscribe(this);
                    if (getAndIncrement() == 0) {
                        this.f16579b.schedule(this);
                        return;
                    }
                    return;
                }
                if (requestFusion == 2) {
                    this.f16587j = requestFusion;
                    this.f16582e = queueDisposable;
                    this.f16578a.onSubscribe(this);
                    return;
                }
            }
            this.f16582e = new SpscLinkedArrayQueue(this.f16581d);
            this.f16578a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        return this.f16582e.poll();
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        if ((i & 2) != 0) {
            this.f16588k = true;
            return 2;
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0075, code lost:
    
        r3 = addAndGet(-r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007a, code lost:
    
        if (r3 != 0) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:?, code lost:
    
        return;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        boolean z;
        if (this.f16588k) {
            int i = 1;
            while (!this.f16586i) {
                boolean z2 = this.f16585h;
                Throwable th = this.f16584g;
                if (!this.f16580c && z2 && th != null) {
                    this.f16586i = true;
                    this.f16578a.onError(this.f16584g);
                    this.f16579b.dispose();
                    return;
                }
                this.f16578a.onNext(null);
                if (z2) {
                    this.f16586i = true;
                    Throwable th2 = this.f16584g;
                    if (th2 != null) {
                        this.f16578a.onError(th2);
                    } else {
                        this.f16578a.onComplete();
                    }
                    this.f16579b.dispose();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
            return;
        }
        SimpleQueue simpleQueue = this.f16582e;
        Observer observer = this.f16578a;
        int i2 = 1;
        while (!m4632a(this.f16585h, simpleQueue.isEmpty(), observer)) {
            while (true) {
                boolean z3 = this.f16585h;
                try {
                    Object poll = simpleQueue.poll();
                    if (poll == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!m4632a(z3, z, observer)) {
                        if (z) {
                            break;
                        } else {
                            observer.onNext(poll);
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.f16586i = true;
                    this.f16583f.dispose();
                    simpleQueue.clear();
                    observer.onError(th3);
                    this.f16579b.dispose();
                    return;
                }
            }
        }
    }
}
