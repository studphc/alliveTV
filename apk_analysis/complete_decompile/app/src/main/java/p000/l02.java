package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class l02 extends AtomicReference implements Observer, Disposable {
    private static final long serialVersionUID = -312246233408980075L;

    /* renamed from: a */
    public final SerializedObserver f22271a;

    /* renamed from: b */
    public final BiFunction f22272b;

    /* renamed from: c */
    public final AtomicReference f22273c = new AtomicReference();

    /* renamed from: d */
    public final AtomicReference f22274d = new AtomicReference();

    public l02(SerializedObserver serializedObserver, BiFunction biFunction) {
        this.f22271a = serializedObserver;
        this.f22272b = biFunction;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f22273c);
        DisposableHelper.dispose(this.f22274d);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) this.f22273c.get());
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        DisposableHelper.dispose(this.f22274d);
        this.f22271a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        DisposableHelper.dispose(this.f22274d);
        this.f22271a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        SerializedObserver serializedObserver = this.f22271a;
        Object obj2 = get();
        if (obj2 != null) {
            try {
                Object apply = this.f22272b.apply(obj, obj2);
                Objects.requireNonNull(apply, "The combiner returned a null value");
                serializedObserver.onNext(apply);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                dispose();
                serializedObserver.onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f22273c, disposable);
    }
}
