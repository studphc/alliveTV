package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class zx1 implements ObservableSource {

    /* renamed from: a */
    public final AtomicReference f29557a;

    /* renamed from: b */
    public final sx1 f29558b;

    public zx1(AtomicReference atomicReference, sx1 sx1Var) {
        this.f29557a = atomicReference;
        this.f29558b = sx1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.ObservableSource
    public final void subscribe(Observer observer) {
        yx1 yx1Var;
        loop0: while (true) {
            yx1Var = (yx1) this.f29557a.get();
            if (yx1Var != null) {
                break;
            }
            yx1 yx1Var2 = new yx1(this.f29558b.call(), this.f29557a);
            AtomicReference atomicReference = this.f29557a;
            while (!atomicReference.compareAndSet(null, yx1Var2)) {
                if (atomicReference.get() != null) {
                    break;
                }
            }
            yx1Var = yx1Var2;
            break loop0;
        }
        tx1 tx1Var = new tx1(yx1Var, observer);
        observer.onSubscribe(tx1Var);
        loop2: while (true) {
            AtomicReference atomicReference2 = yx1Var.f29165c;
            tx1[] tx1VarArr = (tx1[]) atomicReference2.get();
            if (tx1VarArr != yx1.f29162g) {
                int length = tx1VarArr.length;
                tx1[] tx1VarArr2 = new tx1[length + 1];
                System.arraycopy(tx1VarArr, 0, tx1VarArr2, 0, length);
                tx1VarArr2[length] = tx1Var;
                while (!atomicReference2.compareAndSet(tx1VarArr, tx1VarArr2)) {
                    if (atomicReference2.get() != tx1VarArr) {
                        break;
                    }
                }
                break loop2;
            }
            break;
        }
        if (tx1Var.f27015d) {
            yx1Var.m8331a(tx1Var);
        } else {
            yx1Var.f29163a.mo4505c(tx1Var);
        }
    }
}
