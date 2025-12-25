package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ck1 extends AtomicInteger implements Disposable {
    private static final long serialVersionUID = -5556924161382950569L;

    /* renamed from: a */
    public final MaybeObserver f8403a;

    /* renamed from: b */
    public final Function f8404b;

    /* renamed from: c */
    public final dk1[] f8405c;

    /* renamed from: d */
    public Object[] f8406d;

    public ck1(int i, MaybeObserver maybeObserver, Function function) {
        super(i);
        this.f8403a = maybeObserver;
        this.f8404b = function;
        dk1[] dk1VarArr = new dk1[i];
        for (int i2 = 0; i2 < i; i2++) {
            dk1VarArr[i2] = new dk1(this, i2);
        }
        this.f8405c = dk1VarArr;
        this.f8406d = new Object[i];
    }

    /* renamed from: a */
    public final void m2263a(int i) {
        dk1[] dk1VarArr = this.f8405c;
        int length = dk1VarArr.length;
        for (int i2 = 0; i2 < i; i2++) {
            dk1 dk1Var = dk1VarArr[i2];
            dk1Var.getClass();
            DisposableHelper.dispose(dk1Var);
        }
        while (true) {
            i++;
            if (i < length) {
                dk1 dk1Var2 = dk1VarArr[i];
                dk1Var2.getClass();
                DisposableHelper.dispose(dk1Var2);
            } else {
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (getAndSet(0) > 0) {
            for (dk1 dk1Var : this.f8405c) {
                dk1Var.getClass();
                DisposableHelper.dispose(dk1Var);
            }
            this.f8406d = null;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (get() <= 0) {
            return true;
        }
        return false;
    }
}
