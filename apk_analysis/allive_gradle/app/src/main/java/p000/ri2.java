package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.ResumeSingleObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ri2 extends AtomicReference implements Observer, Disposable {
    private static final long serialVersionUID = -8565274649390031272L;

    /* renamed from: a */
    public final SingleObserver f25985a;

    /* renamed from: b */
    public final SingleSource f25986b;

    /* renamed from: c */
    public boolean f25987c;

    public ri2(SingleObserver singleObserver, SingleSource singleSource) {
        this.f25985a = singleObserver;
        this.f25986b = singleSource;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (this.f25987c) {
            return;
        }
        this.f25987c = true;
        this.f25986b.subscribe(new ResumeSingleObserver(this, this.f25985a));
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f25987c) {
            RxJavaPlugins.onError(th);
        } else {
            this.f25987c = true;
            this.f25985a.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        ((Disposable) get()).dispose();
        onComplete();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.f25985a.onSubscribe(this);
        }
    }
}
