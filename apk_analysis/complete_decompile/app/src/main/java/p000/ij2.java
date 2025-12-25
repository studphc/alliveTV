package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ij2 extends AtomicReference implements SingleObserver, Disposable {
    private static final long serialVersionUID = 4375739915521278546L;

    /* renamed from: a */
    public final SingleObserver f18437a;

    /* renamed from: b */
    public final Function f18438b;

    /* renamed from: c */
    public final Function f18439c;

    /* renamed from: d */
    public Disposable f18440d;

    public ij2(SingleObserver singleObserver, Function function, Function function2) {
        this.f18437a = singleObserver;
        this.f18438b = function;
        this.f18439c = function2;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
        this.f18440d.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        try {
            Object apply = this.f18439c.apply(th);
            Objects.requireNonNull(apply, "The onErrorMapper returned a null SingleSource");
            SingleSource singleSource = (SingleSource) apply;
            if (!isDisposed()) {
                singleSource.subscribe(new C1772rs(1, this));
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            this.f18437a.onError(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f18440d, disposable)) {
            this.f18440d = disposable;
            this.f18437a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        try {
            Object apply = this.f18438b.apply(obj);
            Objects.requireNonNull(apply, "The onSuccessMapper returned a null SingleSource");
            SingleSource singleSource = (SingleSource) apply;
            if (!isDisposed()) {
                singleSource.subscribe(new C1772rs(1, this));
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f18437a.onError(th);
        }
    }
}
