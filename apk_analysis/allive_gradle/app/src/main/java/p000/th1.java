package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeCache;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class th1 extends AtomicReference implements Disposable {
    private static final long serialVersionUID = -5791853038359966195L;

    /* renamed from: a */
    public final MaybeObserver f26814a;

    public th1(MaybeObserver maybeObserver, MaybeCache maybeCache) {
        super(maybeCache);
        this.f26814a = maybeObserver;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        MaybeCache maybeCache = (MaybeCache) getAndSet(null);
        if (maybeCache != null) {
            maybeCache.m5285a(this);
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
