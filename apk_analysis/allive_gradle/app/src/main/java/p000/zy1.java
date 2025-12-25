package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class zy1 extends AtomicInteger implements Observer, Disposable {

    /* renamed from: k */
    public static final yy1 f29562k;
    private static final long serialVersionUID = -3491074160481096299L;

    /* renamed from: a */
    public final Observer f29563a;

    /* renamed from: b */
    public final Function f29564b;

    /* renamed from: c */
    public final int f29565c;

    /* renamed from: d */
    public final boolean f29566d;

    /* renamed from: f */
    public volatile boolean f29568f;

    /* renamed from: g */
    public volatile boolean f29569g;

    /* renamed from: h */
    public Disposable f29570h;

    /* renamed from: j */
    public volatile long f29572j;

    /* renamed from: i */
    public final AtomicReference f29571i = new AtomicReference();

    /* renamed from: e */
    public final AtomicThrowable f29567e = new AtomicThrowable();

    static {
        yy1 yy1Var = new yy1(null, -1L, 1);
        f29562k = yy1Var;
        DisposableHelper.dispose(yy1Var);
    }

    public zy1(Observer observer, Function function, int i, boolean z) {
        this.f29563a = observer;
        this.f29564b = function;
        this.f29565c = i;
        this.f29566d = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x000f A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m8446a() {
        SimpleQueue simpleQueue;
        Object obj;
        boolean z;
        boolean z2;
        if (getAndIncrement() != 0) {
            return;
        }
        Observer<?> observer = this.f29563a;
        AtomicReference atomicReference = this.f29571i;
        boolean z3 = this.f29566d;
        int i = 1;
        while (!this.f29569g) {
            if (this.f29568f) {
                if (atomicReference.get() == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z3) {
                    if (z2) {
                        Throwable th = this.f29567e.get();
                        if (th != null) {
                            observer.onError(th);
                            return;
                        } else {
                            observer.onComplete();
                            return;
                        }
                    }
                } else if (this.f29567e.get() != null) {
                    this.f29567e.tryTerminateConsumer(observer);
                    return;
                } else if (z2) {
                    observer.onComplete();
                    return;
                }
            }
            yy1 yy1Var = (yy1) atomicReference.get();
            if (yy1Var != null && (simpleQueue = yy1Var.f29175d) != null) {
                boolean z4 = false;
                while (!this.f29569g) {
                    if (yy1Var == atomicReference.get()) {
                        if (!z3 && this.f29567e.get() != null) {
                            this.f29567e.tryTerminateConsumer(observer);
                            return;
                        }
                        boolean z5 = yy1Var.f29176e;
                        try {
                            obj = simpleQueue.poll();
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.f29567e.tryAddThrowableOrReport(th2);
                            while (!atomicReference.compareAndSet(yy1Var, null) && atomicReference.get() == yy1Var) {
                            }
                            if (!z3) {
                                yy1 yy1Var2 = (yy1) this.f29571i.getAndSet(f29562k);
                                if (yy1Var2 != null) {
                                    DisposableHelper.dispose(yy1Var2);
                                }
                                this.f29570h.dispose();
                                this.f29568f = true;
                            } else {
                                DisposableHelper.dispose(yy1Var);
                            }
                            z4 = true;
                            obj = null;
                        }
                        if (obj == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z5 && z) {
                            while (!atomicReference.compareAndSet(yy1Var, null) && atomicReference.get() == yy1Var) {
                            }
                        } else if (z) {
                            if (!z4) {
                                continue;
                            }
                        } else {
                            observer.onNext(obj);
                        }
                    }
                    z4 = true;
                    if (!z4) {
                    }
                }
                return;
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (!this.f29569g) {
            this.f29569g = true;
            this.f29570h.dispose();
            yy1 yy1Var = (yy1) this.f29571i.getAndSet(f29562k);
            if (yy1Var != null) {
                DisposableHelper.dispose(yy1Var);
            }
            this.f29567e.tryTerminateAndReport();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f29569g;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (!this.f29568f) {
            this.f29568f = true;
            m8446a();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        yy1 yy1Var;
        if (!this.f29568f && this.f29567e.tryAddThrowable(th)) {
            if (!this.f29566d && (yy1Var = (yy1) this.f29571i.getAndSet(f29562k)) != null) {
                DisposableHelper.dispose(yy1Var);
            }
            this.f29568f = true;
            m8446a();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        long j = this.f29572j + 1;
        this.f29572j = j;
        yy1 yy1Var = (yy1) this.f29571i.get();
        if (yy1Var != null) {
            DisposableHelper.dispose(yy1Var);
        }
        try {
            Object apply = this.f29564b.apply(obj);
            Objects.requireNonNull(apply, "The ObservableSource returned is null");
            ObservableSource observableSource = (ObservableSource) apply;
            yy1 yy1Var2 = new yy1(this, j, this.f29565c);
            while (true) {
                yy1 yy1Var3 = (yy1) this.f29571i.get();
                if (yy1Var3 != f29562k) {
                    AtomicReference atomicReference = this.f29571i;
                    while (!atomicReference.compareAndSet(yy1Var3, yy1Var2)) {
                        if (atomicReference.get() != yy1Var3) {
                            break;
                        }
                    }
                    observableSource.subscribe(yy1Var2);
                    return;
                }
                return;
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f29570h.dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f29570h, disposable)) {
            this.f29570h = disposable;
            this.f29563a.onSubscribe(this);
        }
    }
}
