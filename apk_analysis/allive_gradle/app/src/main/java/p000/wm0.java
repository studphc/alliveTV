package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class wm0 extends AtomicReference implements FlowableSubscriber, Disposable {
    private static final long serialVersionUID = 1883890389173668373L;

    /* renamed from: a */
    public final AtomicInteger f28239a;

    /* renamed from: b */
    public final boolean f28240b;

    /* renamed from: c */
    public final int f28241c;

    /* JADX WARN: Multi-variable type inference failed */
    public wm0(vm0 vm0Var, boolean z, int i) {
        this.f28239a = (AtomicInteger) vm0Var;
        this.f28240b = z;
        this.f28241c = i;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (get() == SubscriptionHelper.CANCELLED) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.atomic.AtomicInteger, vm0] */
    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f28239a.mo6195e(this.f28240b, this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.atomic.AtomicInteger, vm0] */
    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f28239a.mo6192b(th);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.concurrent.atomic.AtomicInteger, vm0] */
    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (SubscriptionHelper.cancel(this)) {
            this.f28239a.mo6195e(this.f28240b, this);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
    }
}
