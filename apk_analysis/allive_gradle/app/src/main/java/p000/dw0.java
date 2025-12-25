package p000;

import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class dw0 extends AtomicReference implements Disposable {
    private static final long serialVersionUID = 6545242830671168775L;

    /* renamed from: a */
    public final boolean f16563a;

    public dw0(Future future, boolean z) {
        super(future);
        this.f16563a = z;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        Future future = (Future) getAndSet(null);
        if (future != null) {
            future.cancel(this.f16563a);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        Future future = (Future) get();
        if (future != null && !future.isDone()) {
            return false;
        }
        return true;
    }
}
