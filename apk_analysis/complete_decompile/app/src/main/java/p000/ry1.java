package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

/* loaded from: classes2.dex */
public final class ry1 extends ArrayDeque implements Observer, Disposable {
    private static final long serialVersionUID = -3807491841935125653L;

    /* renamed from: a */
    public final Observer f26185a;

    /* renamed from: b */
    public final int f26186b;

    /* renamed from: c */
    public Disposable f26187c;

    public ry1(Observer observer, int i) {
        super(i);
        this.f26185a = observer;
        this.f26186b = i;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f26187c.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f26187c.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f26185a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f26185a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f26186b == size()) {
            this.f26185a.onNext(poll());
        }
        offer(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f26187c, disposable)) {
            this.f26187c = disposable;
            this.f26185a.onSubscribe(this);
        }
    }
}
