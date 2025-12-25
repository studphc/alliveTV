package p000;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class xk0 extends AtomicReference implements Runnable, Disposable {
    private static final long serialVersionUID = 6812032969491025141L;

    /* renamed from: a */
    public final Object f28594a;

    /* renamed from: b */
    public final long f28595b;

    /* renamed from: c */
    public final yk0 f28596c;

    /* renamed from: d */
    public final AtomicBoolean f28597d = new AtomicBoolean();

    public xk0(Object obj, long j, yk0 yk0Var) {
        this.f28594a = obj;
        this.f28595b = j;
        this.f28596c = yk0Var;
    }

    /* renamed from: a */
    public final void m8171a() {
        if (this.f28597d.compareAndSet(false, true)) {
            yk0 yk0Var = this.f28596c;
            long j = this.f28595b;
            Object obj = this.f28594a;
            if (j == yk0Var.f28999g) {
                if (yk0Var.get() != 0) {
                    yk0Var.f28993a.onNext(obj);
                    BackpressureHelper.produced(yk0Var, 1L);
                    DisposableHelper.dispose(this);
                } else {
                    yk0Var.cancel();
                    yk0Var.f28993a.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                }
            }
        }
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
        m8171a();
    }
}
