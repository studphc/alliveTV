package p000;

import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class bv1 extends DisposableObserver {

    /* renamed from: b */
    public final cv1 f8163b;

    /* renamed from: c */
    public final long f8164c;

    /* renamed from: d */
    public final Object f8165d;

    /* renamed from: e */
    public boolean f8166e;

    /* renamed from: f */
    public final AtomicBoolean f8167f = new AtomicBoolean();

    public bv1(cv1 cv1Var, long j, Object obj) {
        this.f8163b = cv1Var;
        this.f8164c = j;
        this.f8165d = obj;
    }

    /* renamed from: a */
    public final void m2167a() {
        if (this.f8167f.compareAndSet(false, true)) {
            cv1 cv1Var = this.f8163b;
            long j = this.f8164c;
            Object obj = this.f8165d;
            if (j == cv1Var.f16127e) {
                cv1Var.f16123a.onNext(obj);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (this.f8166e) {
            return;
        }
        this.f8166e = true;
        m2167a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f8166e) {
            RxJavaPlugins.onError(th);
        } else {
            this.f8166e = true;
            this.f8163b.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f8166e) {
            return;
        }
        this.f8166e = true;
        dispose();
        m2167a();
    }
}
