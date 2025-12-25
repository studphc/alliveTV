package p000;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class vk0 extends DisposableSubscriber {

    /* renamed from: b */
    public final wk0 f27826b;

    /* renamed from: c */
    public final long f27827c;

    /* renamed from: d */
    public final Object f27828d;

    /* renamed from: e */
    public boolean f27829e;

    /* renamed from: f */
    public final AtomicBoolean f27830f = new AtomicBoolean();

    public vk0(wk0 wk0Var, long j, Object obj) {
        this.f27826b = wk0Var;
        this.f27827c = j;
        this.f27828d = obj;
    }

    /* renamed from: a */
    public final void m7914a() {
        if (this.f27830f.compareAndSet(false, true)) {
            wk0 wk0Var = this.f27826b;
            long j = this.f27827c;
            Object obj = this.f27828d;
            if (j == wk0Var.f28211e) {
                if (wk0Var.get() != 0) {
                    wk0Var.f28207a.onNext(obj);
                    BackpressureHelper.produced(wk0Var, 1L);
                } else {
                    wk0Var.cancel();
                    wk0Var.f28207a.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f27829e) {
            return;
        }
        this.f27829e = true;
        m7914a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f27829e) {
            RxJavaPlugins.onError(th);
        } else {
            this.f27829e = true;
            this.f27826b.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f27829e) {
            return;
        }
        this.f27829e = true;
        cancel();
        m7914a();
    }
}
