package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class wk0 extends AtomicLong implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = 6725975399620862591L;

    /* renamed from: a */
    public final SerializedSubscriber f28207a;

    /* renamed from: b */
    public final Function f28208b;

    /* renamed from: c */
    public Subscription f28209c;

    /* renamed from: d */
    public final AtomicReference f28210d = new AtomicReference();

    /* renamed from: e */
    public volatile long f28211e;

    /* renamed from: f */
    public boolean f28212f;

    public wk0(SerializedSubscriber serializedSubscriber, Function function) {
        this.f28207a = serializedSubscriber;
        this.f28208b = function;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f28209c.cancel();
        DisposableHelper.dispose(this.f28210d);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f28212f) {
            return;
        }
        this.f28212f = true;
        AtomicReference atomicReference = this.f28210d;
        Disposable disposable = (Disposable) atomicReference.get();
        if (!DisposableHelper.isDisposed(disposable)) {
            vk0 vk0Var = (vk0) disposable;
            if (vk0Var != null) {
                vk0Var.m7914a();
            }
            DisposableHelper.dispose(atomicReference);
            this.f28207a.onComplete();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        DisposableHelper.dispose(this.f28210d);
        this.f28207a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f28212f) {
            return;
        }
        long j = this.f28211e + 1;
        this.f28211e = j;
        Disposable disposable = (Disposable) this.f28210d.get();
        if (disposable != null) {
            disposable.dispose();
        }
        try {
            Object apply = this.f28208b.apply(obj);
            Objects.requireNonNull(apply, "The publisher supplied is null");
            Publisher publisher = (Publisher) apply;
            vk0 vk0Var = new vk0(this, j, obj);
            AtomicReference atomicReference = this.f28210d;
            while (!atomicReference.compareAndSet(disposable, vk0Var)) {
                if (atomicReference.get() != disposable) {
                    return;
                }
            }
            publisher.subscribe(vk0Var);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            cancel();
            this.f28207a.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f28209c, subscription)) {
            this.f28209c = subscription;
            this.f28207a.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this, j);
        }
    }
}
