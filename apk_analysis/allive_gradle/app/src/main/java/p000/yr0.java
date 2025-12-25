package p000;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;

/* loaded from: classes2.dex */
public final class yr0 extends DisposableSubscriber {

    /* renamed from: b */
    public final zr0 f29110b;

    /* renamed from: c */
    public boolean f29111c;

    public yr0(zr0 zr0Var) {
        this.f29110b = zr0Var;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f29111c) {
            return;
        }
        this.f29111c = true;
        zr0 zr0Var = this.f29110b;
        SubscriptionHelper.cancel(zr0Var.f29495d);
        zr0Var.f29501j = true;
        zr0Var.m8426a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f29111c) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f29111c = true;
        zr0 zr0Var = this.f29110b;
        SubscriptionHelper.cancel(zr0Var.f29495d);
        if (zr0Var.f29498g.tryAddThrowableOrReport(th)) {
            zr0Var.f29501j = true;
            zr0Var.m8426a();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f29111c) {
            return;
        }
        Object obj2 = zr0.f29491m;
        zr0 zr0Var = this.f29110b;
        zr0Var.f29497f.offer(obj2);
        zr0Var.m8426a();
    }
}
