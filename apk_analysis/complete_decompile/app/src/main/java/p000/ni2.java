package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.single.SingleCache;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class ni2 extends AtomicBoolean implements Disposable {
    private static final long serialVersionUID = 7514387411091976596L;

    /* renamed from: a */
    public final SingleObserver f23374a;

    /* renamed from: b */
    public final SingleCache f23375b;

    public ni2(SingleObserver singleObserver, SingleCache singleCache) {
        this.f23374a = singleObserver;
        this.f23375b = singleCache;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (compareAndSet(false, true)) {
            this.f23375b.m5297c(this);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return get();
    }
}
