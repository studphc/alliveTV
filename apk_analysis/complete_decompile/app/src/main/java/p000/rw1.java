package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class rw1 extends AtomicReference implements Disposable, Runnable {
    private static final long serialVersionUID = 1891866368734007884L;

    /* renamed from: a */
    public final Observer f26168a;

    /* renamed from: b */
    public final long f26169b;

    /* renamed from: c */
    public long f26170c;

    public rw1(Observer observer, long j, long j2) {
        this.f26168a = observer;
        this.f26170c = j;
        this.f26169b = j2;
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
        if (!isDisposed()) {
            long j = this.f26170c;
            Long valueOf = Long.valueOf(j);
            Observer observer = this.f26168a;
            observer.onNext(valueOf);
            if (j == this.f26169b) {
                if (!isDisposed()) {
                    observer.onComplete();
                }
                DisposableHelper.dispose(this);
                return;
            }
            this.f26170c = j + 1;
        }
    }
}
