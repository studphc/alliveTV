package p000;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class dv1 extends AtomicReference implements Runnable, Disposable {
    private static final long serialVersionUID = 6812032969491025141L;

    /* renamed from: a */
    public final Object f16559a;

    /* renamed from: b */
    public final long f16560b;

    /* renamed from: c */
    public final ev1 f16561c;

    /* renamed from: d */
    public final AtomicBoolean f16562d = new AtomicBoolean();

    public dv1(Object obj, long j, ev1 ev1Var) {
        this.f16559a = obj;
        this.f16560b = j;
        this.f16561c = ev1Var;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (get() == DisposableHelper.DISPOSED) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f16562d.compareAndSet(false, true)) {
            ev1 ev1Var = this.f16561c;
            long j = this.f16560b;
            Object obj = this.f16559a;
            if (j == ev1Var.f16996g) {
                ev1Var.f16990a.onNext(obj);
                DisposableHelper.dispose(this);
            }
        }
    }
}
