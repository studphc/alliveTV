package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class ev1 implements Observer, Disposable {

    /* renamed from: a */
    public final SerializedObserver f16990a;

    /* renamed from: b */
    public final long f16991b;

    /* renamed from: c */
    public final TimeUnit f16992c;

    /* renamed from: d */
    public final Scheduler.Worker f16993d;

    /* renamed from: e */
    public Disposable f16994e;

    /* renamed from: f */
    public dv1 f16995f;

    /* renamed from: g */
    public volatile long f16996g;

    /* renamed from: h */
    public boolean f16997h;

    public ev1(SerializedObserver serializedObserver, long j, TimeUnit timeUnit, Scheduler.Worker worker) {
        this.f16990a = serializedObserver;
        this.f16991b = j;
        this.f16992c = timeUnit;
        this.f16993d = worker;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f16994e.dispose();
        this.f16993d.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f16993d.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (this.f16997h) {
            return;
        }
        this.f16997h = true;
        dv1 dv1Var = this.f16995f;
        if (dv1Var != null) {
            DisposableHelper.dispose(dv1Var);
        }
        if (dv1Var != null) {
            dv1Var.run();
        }
        this.f16990a.onComplete();
        this.f16993d.dispose();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f16997h) {
            RxJavaPlugins.onError(th);
            return;
        }
        dv1 dv1Var = this.f16995f;
        if (dv1Var != null) {
            DisposableHelper.dispose(dv1Var);
        }
        this.f16997h = true;
        this.f16990a.onError(th);
        this.f16993d.dispose();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f16997h) {
            return;
        }
        long j = this.f16996g + 1;
        this.f16996g = j;
        dv1 dv1Var = this.f16995f;
        if (dv1Var != null) {
            DisposableHelper.dispose(dv1Var);
        }
        dv1 dv1Var2 = new dv1(obj, j, this);
        this.f16995f = dv1Var2;
        DisposableHelper.replace(dv1Var2, this.f16993d.schedule(dv1Var2, this.f16991b, this.f16992c));
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f16994e, disposable)) {
            this.f16994e = disposable;
            this.f16990a.onSubscribe(this);
        }
    }
}
