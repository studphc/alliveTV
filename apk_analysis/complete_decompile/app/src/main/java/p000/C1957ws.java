package p000;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;

/* renamed from: ws */
/* loaded from: classes2.dex */
public final class C1957ws implements Disposable {

    /* renamed from: a */
    public final AtomicThrowable f28313a;

    public C1957ws(AtomicThrowable atomicThrowable) {
        this.f28313a = atomicThrowable;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f28313a.tryTerminateAndReport();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f28313a.isTerminated();
    }
}
