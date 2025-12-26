package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class gk2 extends AtomicInteger implements Disposable {
    private static final long serialVersionUID = -5556924161382950569L;

    /* renamed from: a */
    public final SingleObserver f17742a;

    /* renamed from: b */
    public final Function f17743b;

    /* renamed from: c */
    public final hk2[] f17744c;

    /* renamed from: d */
    public Object[] f17745d;

    public gk2(SingleObserver singleObserver, int i, Function function) {
        super(i);
        this.f17742a = singleObserver;
        this.f17743b = function;
        hk2[] hk2VarArr = new hk2[i];
        for (int i2 = 0; i2 < i; i2++) {
            hk2VarArr[i2] = new hk2(this, i2);
        }
        this.f17744c = hk2VarArr;
        this.f17745d = new Object[i];
    }

    /* renamed from: a */
    public final void m4954a(Throwable th, int i) {
        if (getAndSet(0) > 0) {
            hk2[] hk2VarArr = this.f17744c;
            int length = hk2VarArr.length;
            for (int i2 = 0; i2 < i; i2++) {
                hk2 hk2Var = hk2VarArr[i2];
                hk2Var.getClass();
                DisposableHelper.dispose(hk2Var);
            }
            while (true) {
                i++;
                if (i < length) {
                    hk2 hk2Var2 = hk2VarArr[i];
                    hk2Var2.getClass();
                    DisposableHelper.dispose(hk2Var2);
                } else {
                    this.f17745d = null;
                    this.f17742a.onError(th);
                    return;
                }
            }
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (getAndSet(0) > 0) {
            for (hk2 hk2Var : this.f17744c) {
                hk2Var.getClass();
                DisposableHelper.dispose(hk2Var);
            }
            this.f17745d = null;
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
