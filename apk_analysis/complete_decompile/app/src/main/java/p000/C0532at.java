package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: at */
/* loaded from: classes2.dex */
public final class C0532at extends AtomicReference implements CompletableObserver, Disposable {
    private static final long serialVersionUID = 5018523762564524046L;

    /* renamed from: a */
    public final CompletableObserver f7735a;

    /* renamed from: b */
    public final Function f7736b;

    /* renamed from: c */
    public boolean f7737c;

    public C0532at(CompletableObserver completableObserver, Function function) {
        this.f7735a = completableObserver;
        this.f7736b = function;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        this.f7735a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        boolean z = this.f7737c;
        CompletableObserver completableObserver = this.f7735a;
        if (z) {
            completableObserver.onError(th);
            return;
        }
        this.f7737c = true;
        try {
            Object apply = this.f7736b.apply(th);
            Objects.requireNonNull(apply, "The errorMapper returned a null CompletableSource");
            ((CompletableSource) apply).subscribe(this);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            completableObserver.onError(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this, disposable);
    }
}
