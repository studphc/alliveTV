package p000;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class c02 extends Observable implements Observer, Disposable {

    /* renamed from: a */
    public final f02 f8217a;

    /* renamed from: b */
    public final UnicastSubject f8218b;

    /* renamed from: c */
    public final AtomicReference f8219c = new AtomicReference();

    /* renamed from: d */
    public final AtomicBoolean f8220d = new AtomicBoolean();

    public c02(f02 f02Var, UnicastSubject unicastSubject) {
        this.f8217a = f02Var;
        this.f8218b = unicastSubject;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f8219c);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f8219c.get() == DisposableHelper.DISPOSED) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        f02 f02Var = this.f8217a;
        f02Var.f17063h.offer(this);
        f02Var.m4764a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (isDisposed()) {
            RxJavaPlugins.onError(th);
            return;
        }
        f02 f02Var = this.f8217a;
        f02Var.f17070o.dispose();
        e02 e02Var = f02Var.f17061f;
        e02Var.getClass();
        DisposableHelper.dispose(e02Var);
        f02Var.f17060e.dispose();
        if (f02Var.f17069n.tryAddThrowableOrReport(th)) {
            f02Var.f17067l = true;
            f02Var.m4764a();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (DisposableHelper.dispose(this.f8219c)) {
            f02 f02Var = this.f8217a;
            f02Var.f17063h.offer(this);
            f02Var.m4764a();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f8219c, disposable);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public final void subscribeActual(Observer observer) {
        this.f8218b.subscribe(observer);
        this.f8220d.set(true);
    }
}
