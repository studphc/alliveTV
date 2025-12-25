package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class wi0 extends AtomicReference implements FlowableSubscriber, Disposable {
    private static final long serialVersionUID = -8498650778633225126L;

    /* renamed from: a */
    public final xi0 f28194a;

    public wi0(xi0 xi0Var) {
        this.f28194a = xi0Var;
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

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        lazySet(SubscriptionHelper.CANCELLED);
        xi0 xi0Var = this.f28194a;
        xi0Var.f28568e.delete(this);
        if (xi0Var.f28568e.size() == 0) {
            SubscriptionHelper.cancel(xi0Var.f28570g);
            xi0Var.f28572i = true;
            xi0Var.m8170b();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        lazySet(SubscriptionHelper.CANCELLED);
        xi0 xi0Var = this.f28194a;
        SubscriptionHelper.cancel(xi0Var.f28570g);
        xi0Var.f28568e.delete(this);
        xi0Var.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        xi0 xi0Var = this.f28194a;
        xi0Var.getClass();
        try {
            Object obj2 = xi0Var.f28565b.get();
            Objects.requireNonNull(obj2, "The bufferSupplier returned a null Collection");
            Collection collection = (Collection) obj2;
            Object apply = xi0Var.f28567d.apply(obj);
            Objects.requireNonNull(apply, "The bufferClose returned a null Publisher");
            Publisher publisher = (Publisher) apply;
            long j = xi0Var.f28575l;
            xi0Var.f28575l = 1 + j;
            synchronized (xi0Var) {
                try {
                    LinkedHashMap linkedHashMap = xi0Var.f28576m;
                    if (linkedHashMap != null) {
                        linkedHashMap.put(Long.valueOf(j), collection);
                        yi0 yi0Var = new yi0(xi0Var, j);
                        xi0Var.f28568e.add(yi0Var);
                        publisher.subscribe(yi0Var);
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            SubscriptionHelper.cancel(xi0Var.f28570g);
            xi0Var.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
    }
}
