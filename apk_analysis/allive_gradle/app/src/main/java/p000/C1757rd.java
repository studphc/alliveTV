package p000;

import io.reactivex.rxjava3.internal.util.ExceptionHelper;

/* renamed from: rd */
/* loaded from: classes2.dex */
public final class C1757rd extends i92 {
    private static final long serialVersionUID = -6646144244598696847L;

    @Override // p000.i92
    /* renamed from: a */
    public final void mo4915a(Object obj) {
        try {
            ((AutoCloseable) obj).close();
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        return "AutoCloseableDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }
}
