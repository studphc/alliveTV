package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class vq0 implements FlowableSubscriber, Disposable {

    /* renamed from: h */
    public static final uq0 f27919h = new uq0(null);

    /* renamed from: a */
    public final CompletableObserver f27920a;

    /* renamed from: b */
    public final Function f27921b;

    /* renamed from: c */
    public final boolean f27922c;

    /* renamed from: d */
    public final AtomicThrowable f27923d = new AtomicThrowable();

    /* renamed from: e */
    public final AtomicReference f27924e = new AtomicReference();

    /* renamed from: f */
    public volatile boolean f27925f;

    /* renamed from: g */
    public Subscription f27926g;

    public vq0(CompletableObserver completableObserver, Function function, boolean z) {
        this.f27920a = completableObserver;
        this.f27921b = function;
        this.f27922c = z;
    }

    /* renamed from: a */
    public final void m7929a() {
        AtomicReference atomicReference = this.f27924e;
        uq0 uq0Var = f27919h;
        uq0 uq0Var2 = (uq0) atomicReference.getAndSet(uq0Var);
        if (uq0Var2 != null && uq0Var2 != uq0Var) {
            DisposableHelper.dispose(uq0Var2);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f27926g.cancel();
        m7929a();
        this.f27923d.tryTerminateAndReport();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f27924e.get() == f27919h) {
            return true;
        }
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f27925f = true;
        if (this.f27924e.get() == null) {
            this.f27923d.tryTerminateConsumer(this.f27920a);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        AtomicThrowable atomicThrowable = this.f27923d;
        if (atomicThrowable.tryAddThrowableOrReport(th)) {
            if (this.f27922c) {
                onComplete();
            } else {
                m7929a();
                atomicThrowable.tryTerminateConsumer(this.f27920a);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        try {
            Object apply = this.f27921b.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
            CompletableSource completableSource = (CompletableSource) apply;
            uq0 uq0Var = new uq0(this);
            while (true) {
                AtomicReference atomicReference = this.f27924e;
                uq0 uq0Var2 = (uq0) atomicReference.get();
                if (uq0Var2 == f27919h) {
                    return;
                }
                while (!atomicReference.compareAndSet(uq0Var2, uq0Var)) {
                    if (atomicReference.get() != uq0Var2) {
                        break;
                    }
                }
                if (uq0Var2 != null) {
                    DisposableHelper.dispose(uq0Var2);
                }
                completableSource.subscribe(uq0Var);
                return;
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f27926g.cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f27926g, subscription)) {
            this.f27926g = subscription;
            this.f27920a.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
