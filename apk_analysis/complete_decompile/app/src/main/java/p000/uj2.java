package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.SingleSubject;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class uj2 extends AtomicReference implements Disposable {
    private static final long serialVersionUID = -7650903191002190468L;

    /* renamed from: a */
    public final SingleObserver f27299a;

    public uj2(SingleObserver singleObserver, SingleSubject singleSubject) {
        this.f27299a = singleObserver;
        lazySet(singleSubject);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        SingleSubject singleSubject = (SingleSubject) getAndSet(null);
        if (singleSubject != null) {
            singleSubject.m5326c(this);
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
