package p000;

import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;

/* renamed from: g4 */
/* loaded from: classes2.dex */
public final class C1219g4 extends i92 {
    private static final long serialVersionUID = -8219729196779211169L;

    @Override // p000.i92
    /* renamed from: a */
    public final void mo4915a(Object obj) {
        try {
            ((Action) obj).run();
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        return "ActionDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }
}
