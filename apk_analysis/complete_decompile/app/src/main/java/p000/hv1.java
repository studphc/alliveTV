package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class hv1 implements Observer, Disposable {

    /* renamed from: a */
    public final Observer f18197a;

    /* renamed from: b */
    public final long f18198b;

    /* renamed from: c */
    public final TimeUnit f18199c;

    /* renamed from: d */
    public final Scheduler.Worker f18200d;

    /* renamed from: e */
    public final boolean f18201e;

    /* renamed from: f */
    public Disposable f18202f;

    public hv1(Observer observer, long j, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
        this.f18197a = observer;
        this.f18198b = j;
        this.f18199c = timeUnit;
        this.f18200d = worker;
        this.f18201e = z;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f18202f.dispose();
        this.f18200d.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f18200d.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f18200d.schedule(new fv1(this), this.f18198b, this.f18199c);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        long j;
        gv1 gv1Var = new gv1(this, th);
        if (this.f18201e) {
            j = this.f18198b;
        } else {
            j = 0;
        }
        this.f18200d.schedule(gv1Var, j, this.f18199c);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f18200d.schedule(new xy1(10, this, obj), this.f18198b, this.f18199c);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f18202f, disposable)) {
            this.f18202f = disposable;
            this.f18197a.onSubscribe(this);
        }
    }
}
