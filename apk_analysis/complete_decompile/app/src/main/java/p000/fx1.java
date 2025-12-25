package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class fx1 extends AtomicReference implements Disposable {
    private static final long serialVersionUID = 7463222674719692880L;

    /* renamed from: a */
    public final Observer f17425a;

    public fx1(Observer observer, gx1 gx1Var) {
        this.f17425a = observer;
        lazySet(gx1Var);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        gx1 gx1Var = (gx1) getAndSet(null);
        if (gx1Var != null) {
            gx1Var.m5025a(this);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (get() == null) {
            return true;
        }
        return false;
    }
}
