package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class uv1 extends AtomicInteger implements Disposable, Observer {

    /* renamed from: p */
    public static final tv1[] f27467p = new tv1[0];

    /* renamed from: q */
    public static final tv1[] f27468q = new tv1[0];
    private static final long serialVersionUID = -2117620485640801370L;

    /* renamed from: a */
    public final Observer f27469a;

    /* renamed from: b */
    public final Function f27470b;

    /* renamed from: c */
    public final boolean f27471c;

    /* renamed from: d */
    public final int f27472d;

    /* renamed from: e */
    public final int f27473e;

    /* renamed from: f */
    public volatile SimplePlainQueue f27474f;

    /* renamed from: g */
    public volatile boolean f27475g;

    /* renamed from: h */
    public final AtomicThrowable f27476h = new AtomicThrowable();

    /* renamed from: i */
    public volatile boolean f27477i;

    /* renamed from: j */
    public final AtomicReference f27478j;

    /* renamed from: k */
    public Disposable f27479k;

    /* renamed from: l */
    public long f27480l;

    /* renamed from: m */
    public int f27481m;

    /* renamed from: n */
    public final ArrayDeque f27482n;

    /* renamed from: o */
    public int f27483o;

    public uv1(int i, int i2, Observer observer, Function function, boolean z) {
        this.f27469a = observer;
        this.f27470b = function;
        this.f27471c = z;
        this.f27472d = i;
        this.f27473e = i2;
        if (i != Integer.MAX_VALUE) {
            this.f27482n = new ArrayDeque(i);
        }
        this.f27478j = new AtomicReference(f27467p);
    }

    /* renamed from: a */
    public final boolean m7771a() {
        if (this.f27477i) {
            return true;
        }
        Throwable th = this.f27476h.get();
        if (!this.f27471c && th != null) {
            m7772b();
            this.f27476h.tryTerminateConsumer(this.f27469a);
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public final boolean m7772b() {
        this.f27479k.dispose();
        AtomicReference atomicReference = this.f27478j;
        tv1[] tv1VarArr = f27468q;
        tv1[] tv1VarArr2 = (tv1[]) atomicReference.getAndSet(tv1VarArr);
        if (tv1VarArr2 == tv1VarArr) {
            return false;
        }
        for (tv1 tv1Var : tv1VarArr2) {
            tv1Var.getClass();
            DisposableHelper.dispose(tv1Var);
        }
        return true;
    }

    /* renamed from: c */
    public final void m7773c() {
        if (getAndIncrement() == 0) {
            m7774d();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x007d, code lost:
    
        if (r10 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ad, code lost:
    
        r10 = r9.f26975b;
        r11 = r9.f26976c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b1, code lost:
    
        if (r10 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b3, code lost:
    
        if (r11 == null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b9, code lost:
    
        if (r11.isEmpty() == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00bb, code lost:
    
        m7775e(r9);
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c0, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c2, code lost:
    
        if (r5 != r8) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c4, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c5, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x007f, code lost:
    
        r11 = r10.poll();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0083, code lost:
    
        if (r11 != null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0086, code lost:
    
        r0.onNext(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x008d, code lost:
    
        if (m7771a() == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x008f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0090, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0091, code lost:
    
        io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r10);
        io.reactivex.rxjava3.internal.disposables.DisposableHelper.dispose(r9);
        r12.f27476h.tryAddThrowableOrReport(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00a0, code lost:
    
        if (m7771a() != false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00a3, code lost:
    
        m7775e(r9);
        r4 = r4 + 1;
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00aa, code lost:
    
        if (r5 != r8) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00a2, code lost:
    
        return;
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m7774d() {
        int i;
        Observer observer = this.f27469a;
        int i2 = 1;
        while (!m7771a()) {
            SimplePlainQueue simplePlainQueue = this.f27474f;
            int i3 = 0;
            if (simplePlainQueue != null) {
                while (!m7771a()) {
                    Object poll = simplePlainQueue.poll();
                    if (poll != null) {
                        observer.onNext(poll);
                        i3++;
                    }
                }
                return;
            }
            if (i3 != 0) {
                if (this.f27472d != Integer.MAX_VALUE) {
                    m7777g(i3);
                }
            } else {
                boolean z = this.f27475g;
                SimplePlainQueue simplePlainQueue2 = this.f27474f;
                tv1[] tv1VarArr = (tv1[]) this.f27478j.get();
                int length = tv1VarArr.length;
                if (this.f27472d != Integer.MAX_VALUE) {
                    synchronized (this) {
                        i = this.f27482n.size();
                    }
                } else {
                    i = 0;
                }
                if (z && ((simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) && length == 0 && i == 0)) {
                    this.f27476h.tryTerminateConsumer(this.f27469a);
                    return;
                }
                if (length != 0) {
                    int min = Math.min(length - 1, this.f27481m);
                    int i4 = 0;
                    while (i4 < length) {
                        if (m7771a()) {
                            return;
                        }
                        tv1 tv1Var = tv1VarArr[min];
                        SimpleQueue simpleQueue = tv1Var.f26976c;
                    }
                    this.f27481m = min;
                }
                if (i3 != 0) {
                    if (this.f27472d != Integer.MAX_VALUE) {
                        m7777g(i3);
                    }
                } else {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f27477i = true;
        if (m7772b()) {
            this.f27476h.tryTerminateAndReport();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    public final void m7775e(tv1 tv1Var) {
        tv1[] tv1VarArr;
        while (true) {
            AtomicReference atomicReference = this.f27478j;
            tv1[] tv1VarArr2 = (tv1[]) atomicReference.get();
            int length = tv1VarArr2.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (tv1VarArr2[i] == tv1Var) {
                        break;
                    } else {
                        i++;
                    }
                } else {
                    i = -1;
                    break;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                tv1VarArr = f27467p;
            } else {
                tv1[] tv1VarArr3 = new tv1[length - 1];
                System.arraycopy(tv1VarArr2, 0, tv1VarArr3, 0, i);
                System.arraycopy(tv1VarArr2, i + 1, tv1VarArr3, i, (length - i) - 1);
                tv1VarArr = tv1VarArr3;
            }
            while (!atomicReference.compareAndSet(tv1VarArr2, tv1VarArr)) {
                if (atomicReference.get() != tv1VarArr2) {
                    break;
                }
            }
            return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        if (decrementAndGet() == 0) goto L28;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m7776f(ObservableSource observableSource) {
        boolean z;
        do {
            z = false;
            if (observableSource instanceof Supplier) {
                try {
                    Object obj = ((Supplier) observableSource).get();
                    if (obj != null) {
                        if (get() == 0 && compareAndSet(0, 1)) {
                            this.f27469a.onNext(obj);
                        } else {
                            SimplePlainQueue simplePlainQueue = this.f27474f;
                            if (simplePlainQueue == null) {
                                if (this.f27472d == Integer.MAX_VALUE) {
                                    simplePlainQueue = new SpscLinkedArrayQueue(this.f27473e);
                                } else {
                                    simplePlainQueue = new SpscArrayQueue(this.f27472d);
                                }
                                this.f27474f = simplePlainQueue;
                            }
                            simplePlainQueue.offer(obj);
                            if (getAndIncrement() != 0) {
                                return;
                            }
                        }
                        m7774d();
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f27476h.tryAddThrowableOrReport(th);
                    m7773c();
                }
                if (this.f27472d != Integer.MAX_VALUE) {
                    synchronized (this) {
                        try {
                            observableSource = (ObservableSource) this.f27482n.poll();
                            if (observableSource == null) {
                                this.f27483o--;
                                z = true;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                } else {
                    return;
                }
            } else {
                this.f27480l++;
                tv1 tv1Var = new tv1(this);
                while (true) {
                    AtomicReference atomicReference = this.f27478j;
                    tv1[] tv1VarArr = (tv1[]) atomicReference.get();
                    if (tv1VarArr == f27468q) {
                        DisposableHelper.dispose(tv1Var);
                        return;
                    }
                    int length = tv1VarArr.length;
                    tv1[] tv1VarArr2 = new tv1[length + 1];
                    System.arraycopy(tv1VarArr, 0, tv1VarArr2, 0, length);
                    tv1VarArr2[length] = tv1Var;
                    while (!atomicReference.compareAndSet(tv1VarArr, tv1VarArr2)) {
                        if (atomicReference.get() != tv1VarArr) {
                            break;
                        }
                    }
                    observableSource.subscribe(tv1Var);
                    return;
                }
            }
        } while (!z);
        m7773c();
    }

    /* renamed from: g */
    public final void m7777g(int i) {
        while (true) {
            int i2 = i - 1;
            if (i != 0) {
                synchronized (this) {
                    try {
                        ObservableSource observableSource = (ObservableSource) this.f27482n.poll();
                        if (observableSource == null) {
                            this.f27483o--;
                        } else {
                            m7776f(observableSource);
                        }
                    } finally {
                    }
                }
                i = i2;
            } else {
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f27477i;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (this.f27475g) {
            return;
        }
        this.f27475g = true;
        m7773c();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f27475g) {
            RxJavaPlugins.onError(th);
        } else if (this.f27476h.tryAddThrowableOrReport(th)) {
            this.f27475g = true;
            m7773c();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f27475g) {
            return;
        }
        try {
            Object apply = this.f27470b.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
            ObservableSource observableSource = (ObservableSource) apply;
            if (this.f27472d != Integer.MAX_VALUE) {
                synchronized (this) {
                    try {
                        int i = this.f27483o;
                        if (i == this.f27472d) {
                            this.f27482n.offer(observableSource);
                            return;
                        }
                        this.f27483o = i + 1;
                    } finally {
                    }
                }
            }
            m7776f(observableSource);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f27479k.dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f27479k, disposable)) {
            this.f27479k = disposable;
            this.f27469a.onSubscribe(this);
        }
    }
}
