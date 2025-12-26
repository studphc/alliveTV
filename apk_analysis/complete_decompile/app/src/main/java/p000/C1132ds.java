package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableCache;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: ds */
/* loaded from: classes2.dex */
public final class C1132ds extends AtomicBoolean implements Disposable {
    private static final long serialVersionUID = 8943152917179642732L;

    /* renamed from: a */
    public final CompletableObserver f16511a;

    /* renamed from: b */
    public final /* synthetic */ CompletableCache f16512b;

    public C1132ds(CompletableCache completableCache, CompletableObserver completableObserver) {
        this.f16512b = completableCache;
        this.f16511a = completableObserver;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (compareAndSet(false, true)) {
            this.f16512b.m5273d(this);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return get();
    }
}
