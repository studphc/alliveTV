package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.MaybeSubject;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ij1 extends AtomicReference implements Disposable {
    private static final long serialVersionUID = -7650903191002190468L;

    /* renamed from: a */
    public final MaybeObserver f18436a;

    public ij1(MaybeObserver maybeObserver, MaybeSubject maybeSubject) {
        this.f18436a = maybeObserver;
        lazySet(maybeSubject);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        MaybeSubject maybeSubject = (MaybeSubject) getAndSet(null);
        if (maybeSubject != null) {
            maybeSubject.m5323a(this);
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
