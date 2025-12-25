package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class n02 extends AtomicReference implements Observer {
    private static final long serialVersionUID = 3256684027868224024L;

    /* renamed from: a */
    public final m02 f23187a;

    /* renamed from: b */
    public final int f23188b;

    /* renamed from: c */
    public boolean f23189c;

    public n02(m02 m02Var, int i) {
        this.f23187a = m02Var;
        this.f23188b = i;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        m02 m02Var = this.f23187a;
        int i = this.f23188b;
        if (!this.f23189c) {
            m02Var.f22752g = true;
            m02Var.m6001a(i);
            HalfSerializer.onComplete((Observer<?>) m02Var.f22746a, m02Var, m02Var.f22751f);
            return;
        }
        m02Var.getClass();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        m02 m02Var = this.f23187a;
        int i = this.f23188b;
        m02Var.f22752g = true;
        DisposableHelper.dispose(m02Var.f22750e);
        m02Var.m6001a(i);
        HalfSerializer.onError((Observer<?>) m02Var.f22746a, th, m02Var, m02Var.f22751f);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (!this.f23189c) {
            this.f23189c = true;
        }
        this.f23187a.f22749d.set(this.f23188b, obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
