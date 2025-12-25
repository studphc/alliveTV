package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class i82 extends AtomicBoolean implements Disposable {
    private static final long serialVersionUID = 3562861878281475070L;

    /* renamed from: a */
    public final Observer f18336a;

    /* renamed from: b */
    public final PublishSubject f18337b;

    public i82(Observer observer, PublishSubject publishSubject) {
        this.f18336a = observer;
        this.f18337b = publishSubject;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (compareAndSet(false, true)) {
            this.f18337b.m5324d(this);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return get();
    }
}
