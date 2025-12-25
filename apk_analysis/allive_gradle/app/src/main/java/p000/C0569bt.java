package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.CompletableSubject;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: bt */
/* loaded from: classes2.dex */
public final class C0569bt extends AtomicReference implements Disposable {
    private static final long serialVersionUID = -7650903191002190468L;

    /* renamed from: a */
    public final CompletableObserver f8149a;

    public C0569bt(CompletableObserver completableObserver, CompletableSubject completableSubject) {
        this.f8149a = completableObserver;
        lazySet(completableSubject);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        CompletableSubject completableSubject = (CompletableSubject) getAndSet(null);
        if (completableSubject != null) {
            completableSubject.m5322d(this);
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
