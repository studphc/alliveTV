package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class my1 extends AtomicReference implements Observer, Disposable {
    private static final long serialVersionUID = -3517602651313910099L;

    /* renamed from: a */
    public final SerializedObserver f23160a;

    /* renamed from: b */
    public final ObservableSource f23161b;

    /* renamed from: c */
    public final AtomicReference f23162c = new AtomicReference();

    /* renamed from: d */
    public Disposable f23163d;

    public my1(SerializedObserver serializedObserver, ObservableSource observableSource) {
        this.f23160a = serializedObserver;
        this.f23161b = observableSource;
    }

    /* renamed from: a */
    public abstract void mo5800a();

    /* renamed from: b */
    public abstract void mo5801b();

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f23162c);
        this.f23163d.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f23162c.get() == DisposableHelper.DISPOSED) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        DisposableHelper.dispose(this.f23162c);
        mo5800a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        DisposableHelper.dispose(this.f23162c);
        this.f23160a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        lazySet(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f23163d, disposable)) {
            this.f23163d = disposable;
            this.f23160a.onSubscribe(this);
            if (this.f23162c.get() == null) {
                this.f23161b.subscribe(new C1698ps(2, this));
            }
        }
    }
}
