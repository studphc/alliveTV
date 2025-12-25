package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class eu1 extends AtomicReference implements Observer {
    private static final long serialVersionUID = -4823716997131257941L;

    /* renamed from: a */
    public final fu1 f16982a;

    /* renamed from: b */
    public final int f16983b;

    public eu1(fu1 fu1Var, int i) {
        this.f16982a = fu1Var;
        this.f16983b = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001d, code lost:
    
        if (r4 == r2.length) goto L17;
     */
    @Override // io.reactivex.rxjava3.core.Observer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onComplete() {
        boolean z;
        fu1 fu1Var = this.f16982a;
        int i = this.f16983b;
        synchronized (fu1Var) {
            try {
                Object[] objArr = fu1Var.f17402d;
                if (objArr != null) {
                    if (objArr[i] == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        int i2 = fu1Var.f17409k + 1;
                        fu1Var.f17409k = i2;
                    }
                    fu1Var.f17406h = true;
                    if (z) {
                        fu1Var.m4841a();
                    }
                    fu1Var.m4843c();
                }
            } finally {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0029, code lost:
    
        if (r3 == r5.length) goto L20;
     */
    @Override // io.reactivex.rxjava3.core.Observer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onError(Throwable th) {
        boolean z;
        fu1 fu1Var = this.f16982a;
        int i = this.f16983b;
        if (fu1Var.f17407i.tryAddThrowableOrReport(th)) {
            boolean z2 = true;
            if (fu1Var.f17404f) {
                synchronized (fu1Var) {
                    try {
                        Object[] objArr = fu1Var.f17402d;
                        if (objArr != null) {
                            if (objArr[i] == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                int i2 = fu1Var.f17409k + 1;
                                fu1Var.f17409k = i2;
                            }
                            fu1Var.f17406h = true;
                            z2 = z;
                        } else {
                            return;
                        }
                    } finally {
                    }
                }
            }
            if (z2) {
                fu1Var.m4841a();
            }
            fu1Var.m4843c();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        boolean z;
        fu1 fu1Var = this.f16982a;
        int i = this.f16983b;
        synchronized (fu1Var) {
            try {
                Object[] objArr = fu1Var.f17402d;
                if (objArr != null) {
                    Object obj2 = objArr[i];
                    int i2 = fu1Var.f17408j;
                    if (obj2 == null) {
                        i2++;
                        fu1Var.f17408j = i2;
                    }
                    objArr[i] = obj;
                    if (i2 == objArr.length) {
                        fu1Var.f17403e.offer(objArr.clone());
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        fu1Var.m4843c();
                    }
                }
            } finally {
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
