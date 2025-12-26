package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class nt1 extends AtomicReference implements Observer {
    private static final long serialVersionUID = -1185974347409665484L;

    /* renamed from: a */
    public final mt1 f23490a;

    /* renamed from: b */
    public final int f23491b;

    /* renamed from: c */
    public final Observer f23492c;

    /* renamed from: d */
    public boolean f23493d;

    public nt1(mt1 mt1Var, int i, Observer observer) {
        this.f23490a = mt1Var;
        this.f23491b = i;
        this.f23492c = observer;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        boolean z = this.f23493d;
        Observer observer = this.f23492c;
        if (z) {
            observer.onComplete();
        } else if (this.f23490a.m6248a(this.f23491b)) {
            this.f23493d = true;
            observer.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        boolean z = this.f23493d;
        Observer observer = this.f23492c;
        if (z) {
            observer.onError(th);
        } else if (this.f23490a.m6248a(this.f23491b)) {
            this.f23493d = true;
            observer.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        boolean z = this.f23493d;
        Observer observer = this.f23492c;
        if (z) {
            observer.onNext(obj);
        } else if (this.f23490a.m6248a(this.f23491b)) {
            this.f23493d = true;
            observer.onNext(obj);
        } else {
            ((Disposable) get()).dispose();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
