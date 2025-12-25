package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p000.AbstractC1607o2;
import p000.au1;
import p000.gj0;

/* loaded from: classes2.dex */
public final class ObservableCache<T> extends AbstractC1607o2 implements Observer<T> {

    /* renamed from: j */
    public static final au1[] f19349j = new au1[0];

    /* renamed from: k */
    public static final au1[] f19350k = new au1[0];

    /* renamed from: a */
    public final AtomicBoolean f19351a;

    /* renamed from: b */
    public final int f19352b;

    /* renamed from: c */
    public final AtomicReference f19353c;

    /* renamed from: d */
    public volatile long f19354d;

    /* renamed from: e */
    public final gj0 f19355e;

    /* renamed from: f */
    public gj0 f19356f;

    /* renamed from: g */
    public int f19357g;

    /* renamed from: h */
    public Throwable f19358h;

    /* renamed from: i */
    public volatile boolean f19359i;

    public ObservableCache(Observable<T> observable, int i) {
        super(observable);
        this.f19352b = i;
        this.f19351a = new AtomicBoolean();
        gj0 gj0Var = new gj0(i, 1);
        this.f19355e = gj0Var;
        this.f19356f = gj0Var;
        this.f19353c = new AtomicReference(f19349j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public final void m5291d(au1 au1Var) {
        boolean z;
        if (au1Var.getAndIncrement() != 0) {
            return;
        }
        long j = au1Var.f7749e;
        int i = au1Var.f7748d;
        gj0 gj0Var = au1Var.f7747c;
        Observer observer = au1Var.f7745a;
        int i2 = this.f19352b;
        int i3 = 1;
        while (!au1Var.f7750f) {
            boolean z2 = this.f19359i;
            if (this.f19354d == j) {
                z = true;
            } else {
                z = false;
            }
            if (z2 && z) {
                au1Var.f7747c = null;
                Throwable th = this.f19358h;
                if (th != null) {
                    observer.onError(th);
                    return;
                } else {
                    observer.onComplete();
                    return;
                }
            }
            if (!z) {
                if (i == i2) {
                    gj0Var = (gj0) gj0Var.f17717b;
                    i = 0;
                }
                observer.onNext(gj0Var.f17716a[i]);
                i++;
                j++;
            } else {
                au1Var.f7749e = j;
                au1Var.f7748d = i;
                au1Var.f7747c = gj0Var;
                i3 = au1Var.addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            }
        }
        au1Var.f7747c = null;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        this.f19359i = true;
        for (au1 au1Var : (au1[]) this.f19353c.getAndSet(f19350k)) {
            m5291d(au1Var);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable th) {
        this.f19358h = th;
        this.f19359i = true;
        for (au1 au1Var : (au1[]) this.f19353c.getAndSet(f19350k)) {
            m5291d(au1Var);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        int i = this.f19357g;
        if (i == this.f19352b) {
            gj0 gj0Var = new gj0(i, 1);
            gj0Var.f17716a[0] = t;
            this.f19357g = 1;
            this.f19356f.f17717b = gj0Var;
            this.f19356f = gj0Var;
        } else {
            this.f19356f.f17716a[i] = t;
            this.f19357g = i + 1;
        }
        this.f19354d++;
        for (au1 au1Var : (au1[]) this.f19353c.get()) {
            m5291d(au1Var);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable disposable) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        au1 au1Var = new au1(observer, this);
        observer.onSubscribe(au1Var);
        loop0: while (true) {
            AtomicReference atomicReference = this.f19353c;
            au1[] au1VarArr = (au1[]) atomicReference.get();
            if (au1VarArr != f19350k) {
                int length = au1VarArr.length;
                au1[] au1VarArr2 = new au1[length + 1];
                System.arraycopy(au1VarArr, 0, au1VarArr2, 0, length);
                au1VarArr2[length] = au1Var;
                while (!atomicReference.compareAndSet(au1VarArr, au1VarArr2)) {
                    if (atomicReference.get() != au1VarArr) {
                        break;
                    }
                }
                break loop0;
            }
            break;
        }
        AtomicBoolean atomicBoolean = this.f19351a;
        if (!atomicBoolean.get() && atomicBoolean.compareAndSet(false, true)) {
            this.source.subscribe(this);
        } else {
            m5291d(au1Var);
        }
    }
}
