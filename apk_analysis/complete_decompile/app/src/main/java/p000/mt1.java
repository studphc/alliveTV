package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class mt1 implements Disposable {

    /* renamed from: a */
    public final Observer f23103a;

    /* renamed from: b */
    public final nt1[] f23104b;

    /* renamed from: c */
    public final AtomicInteger f23105c = new AtomicInteger();

    public mt1(Observer observer, int i) {
        this.f23103a = observer;
        this.f23104b = new nt1[i];
    }

    /* renamed from: a */
    public final boolean m6248a(int i) {
        AtomicInteger atomicInteger = this.f23105c;
        int i2 = 0;
        if (atomicInteger.get() != 0 || !atomicInteger.compareAndSet(0, i)) {
            return false;
        }
        nt1[] nt1VarArr = this.f23104b;
        int length = nt1VarArr.length;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (i3 != i) {
                nt1 nt1Var = nt1VarArr[i2];
                nt1Var.getClass();
                DisposableHelper.dispose(nt1Var);
            }
            i2 = i3;
        }
        return true;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        AtomicInteger atomicInteger = this.f23105c;
        if (atomicInteger.get() != -1) {
            atomicInteger.lazySet(-1);
            for (nt1 nt1Var : this.f23104b) {
                nt1Var.getClass();
                DisposableHelper.dispose(nt1Var);
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f23105c.get() == -1) {
            return true;
        }
        return false;
    }
}
