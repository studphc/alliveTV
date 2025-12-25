package p000;

import io.reactivex.rxjava3.disposables.Disposable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class i92 extends AtomicReference implements Disposable {
    private static final long serialVersionUID = 6537757548749041217L;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i92(Object obj) {
        super(obj);
        Objects.requireNonNull(obj, "value is null");
    }

    /* renamed from: a */
    public abstract void mo4915a(Object obj);

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        Object andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            mo4915a(andSet);
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
