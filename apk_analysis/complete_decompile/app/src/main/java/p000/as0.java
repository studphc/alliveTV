package p000;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class as0 extends Flowable implements FlowableSubscriber, Disposable {

    /* renamed from: b */
    public final ds0 f7730b;

    /* renamed from: c */
    public final UnicastProcessor f7731c;

    /* renamed from: d */
    public final AtomicReference f7732d = new AtomicReference();

    /* renamed from: e */
    public final AtomicBoolean f7733e = new AtomicBoolean();

    public as0(ds0 ds0Var, UnicastProcessor unicastProcessor) {
        this.f7730b = ds0Var;
        this.f7731c = unicastProcessor;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        SubscriptionHelper.cancel(this.f7732d);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f7732d.get() == SubscriptionHelper.CANCELLED) {
            return true;
        }
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        ds0 ds0Var = this.f7730b;
        ds0Var.f16520h.offer(this);
        ds0Var.m4606a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (isDisposed()) {
            RxJavaPlugins.onError(th);
            return;
        }
        ds0 ds0Var = this.f7730b;
        ds0Var.f16529q.cancel();
        cs0 cs0Var = ds0Var.f16518f;
        cs0Var.getClass();
        SubscriptionHelper.cancel(cs0Var);
        ds0Var.f16517e.dispose();
        if (ds0Var.f16528p.tryAddThrowableOrReport(th)) {
            ds0Var.f16526n = true;
            ds0Var.m4606a();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (SubscriptionHelper.cancel(this.f7732d)) {
            ds0 ds0Var = this.f7730b;
            ds0Var.f16520h.offer(this);
            ds0Var.m4606a();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.f7732d, subscription)) {
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public final void subscribeActual(Subscriber subscriber) {
        this.f7731c.subscribe(subscriber);
        this.f7733e.set(true);
    }
}
