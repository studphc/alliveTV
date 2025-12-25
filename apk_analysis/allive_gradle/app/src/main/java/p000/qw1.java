package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class qw1 extends AtomicReference implements Disposable, Runnable {
    private static final long serialVersionUID = 346773832286157679L;

    /* renamed from: a */
    public final Observer f25783a;

    /* renamed from: b */
    public long f25784b;

    public qw1(Observer observer) {
        this.f25783a = observer;
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
        if (get() != DisposableHelper.DISPOSED) {
            long j = this.f25784b;
            this.f25784b = 1 + j;
            this.f25783a.onNext(Long.valueOf(j));
        }
    }
}
