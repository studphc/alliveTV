package p000;

import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class os2 extends AtomicReference implements Disposable {
    private static final long serialVersionUID = -7874968252110604360L;

    /* renamed from: a */
    public final /* synthetic */ ps2 f24896a;

    public os2(ps2 ps2Var, qs2 qs2Var) {
        this.f24896a = ps2Var;
        lazySet(qs2Var);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        qs2 qs2Var = (qs2) getAndSet(null);
        if (qs2Var != null) {
            this.f24896a.f25280b.f20090c.remove(qs2Var);
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
