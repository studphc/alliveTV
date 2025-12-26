package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class yx1 extends AtomicReference implements Observer, Disposable {

    /* renamed from: f */
    public static final tx1[] f29161f = new tx1[0];

    /* renamed from: g */
    public static final tx1[] f29162g = new tx1[0];
    private static final long serialVersionUID = -533785617179540163L;

    /* renamed from: a */
    public final wx1 f29163a;

    /* renamed from: b */
    public boolean f29164b;

    /* renamed from: c */
    public final AtomicReference f29165c = new AtomicReference(f29161f);

    /* renamed from: d */
    public final AtomicBoolean f29166d = new AtomicBoolean();

    /* renamed from: e */
    public final AtomicReference f29167e;

    public yx1(wx1 wx1Var, AtomicReference atomicReference) {
        this.f29163a = wx1Var;
        this.f29167e = atomicReference;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final void m8331a(tx1 tx1Var) {
        tx1[] tx1VarArr;
        while (true) {
            AtomicReference atomicReference = this.f29165c;
            tx1[] tx1VarArr2 = (tx1[]) atomicReference.get();
            int length = tx1VarArr2.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i < length) {
                    if (tx1VarArr2[i].equals(tx1Var)) {
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
                tx1VarArr = f29161f;
            } else {
                tx1[] tx1VarArr3 = new tx1[length - 1];
                System.arraycopy(tx1VarArr2, 0, tx1VarArr3, 0, i);
                System.arraycopy(tx1VarArr2, i + 1, tx1VarArr3, i, (length - i) - 1);
                tx1VarArr = tx1VarArr3;
            }
            while (!atomicReference.compareAndSet(tx1VarArr2, tx1VarArr)) {
                if (atomicReference.get() != tx1VarArr2) {
                    break;
                }
            }
            return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        AtomicReference atomicReference;
        this.f29165c.set(f29162g);
        do {
            atomicReference = this.f29167e;
            if (atomicReference.compareAndSet(this, null)) {
                break;
            }
        } while (atomicReference.get() == this);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f29165c.get() == f29162g) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (!this.f29164b) {
            this.f29164b = true;
            wx1 wx1Var = this.f29163a;
            wx1Var.complete();
            for (tx1 tx1Var : (tx1[]) this.f29165c.getAndSet(f29162g)) {
                wx1Var.mo4505c(tx1Var);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (!this.f29164b) {
            this.f29164b = true;
            wx1 wx1Var = this.f29163a;
            wx1Var.mo4504b(th);
            for (tx1 tx1Var : (tx1[]) this.f29165c.getAndSet(f29162g)) {
                wx1Var.mo4505c(tx1Var);
            }
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (!this.f29164b) {
            wx1 wx1Var = this.f29163a;
            wx1Var.mo4503a(obj);
            for (tx1 tx1Var : (tx1[]) this.f29165c.get()) {
                wx1Var.mo4505c(tx1Var);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            for (tx1 tx1Var : (tx1[]) this.f29165c.get()) {
                this.f29163a.mo4505c(tx1Var);
            }
        }
    }
}
