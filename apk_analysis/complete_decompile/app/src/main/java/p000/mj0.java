package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class mj0 extends AtomicReference implements FlowableSubscriber {
    private static final long serialVersionUID = -8730235182291002949L;

    /* renamed from: a */
    public final lj0 f22955a;

    /* renamed from: b */
    public final int f22956b;

    /* renamed from: c */
    public final int f22957c;

    /* renamed from: d */
    public final int f22958d;

    /* renamed from: e */
    public int f22959e;

    public mj0(lj0 lj0Var, int i, int i2) {
        this.f22955a = lj0Var;
        this.f22956b = i;
        this.f22957c = i2;
        this.f22958d = i2 - (i2 >> 2);
    }

    /* renamed from: a */
    public final void m6146a() {
        int i = this.f22959e + 1;
        if (i == this.f22958d) {
            this.f22959e = 0;
            ((Subscription) get()).request(i);
        } else {
            this.f22959e = i;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f22955a.m5928g(this.f22956b);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        lj0 lj0Var = this.f22955a;
        int i = this.f22956b;
        if (ExceptionHelper.addThrowable(lj0Var.f22532m, th)) {
            if (!lj0Var.f22525f) {
                lj0Var.m5926e();
                lj0Var.f22531l = true;
                lj0Var.drain();
                return;
            }
            lj0Var.m5928g(i);
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        boolean z;
        lj0 lj0Var = this.f22955a;
        int i = this.f22956b;
        synchronized (lj0Var) {
            try {
                Object[] objArr = lj0Var.f22524e;
                int i2 = lj0Var.f22527h;
                if (objArr[i] == null) {
                    i2++;
                    lj0Var.f22527h = i2;
                }
                objArr[i] = obj;
                if (objArr.length == i2) {
                    lj0Var.f22523d.offer(lj0Var.f22522c[i], objArr.clone());
                    z = false;
                } else {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            lj0Var.f22522c[i].m6146a();
        } else {
            lj0Var.drain();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, this.f22957c);
    }
}
