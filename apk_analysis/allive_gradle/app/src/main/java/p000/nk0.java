package p000;

import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public abstract class nk0 extends AtomicLong implements FlowableEmitter, Subscription {
    private static final long serialVersionUID = 7326289992464377023L;

    /* renamed from: a */
    public final Subscriber f23385a;

    /* renamed from: b */
    public final SequentialDisposable f23386b = new SequentialDisposable();

    public nk0(Subscriber subscriber) {
        this.f23385a = subscriber;
    }

    /* renamed from: a */
    public final void m6350a() {
        SequentialDisposable sequentialDisposable = this.f23386b;
        if (sequentialDisposable.isDisposed()) {
            return;
        }
        try {
            this.f23385a.onComplete();
        } finally {
            sequentialDisposable.dispose();
        }
    }

    /* renamed from: b */
    public final boolean m6351b(Throwable th) {
        SequentialDisposable sequentialDisposable = this.f23386b;
        if (sequentialDisposable.isDisposed()) {
            return false;
        }
        try {
            this.f23385a.onError(th);
            sequentialDisposable.dispose();
            return true;
        } catch (Throwable th2) {
            sequentialDisposable.dispose();
            throw th2;
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f23386b.dispose();
        mo6353d();
    }

    /* renamed from: e */
    public boolean mo6354e(Throwable th) {
        return m6351b(th);
    }

    @Override // io.reactivex.rxjava3.core.FlowableEmitter
    public final boolean isCancelled() {
        return this.f23386b.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Emitter
    public void onComplete() {
        m6350a();
    }

    @Override // io.reactivex.rxjava3.core.Emitter
    public final void onError(Throwable th) {
        if (th == null) {
            th = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
        }
        if (!mo6354e(th)) {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this, j);
            mo6352c();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableEmitter
    public final long requested() {
        return get();
    }

    @Override // io.reactivex.rxjava3.core.FlowableEmitter
    public final FlowableEmitter serialize() {
        return new uk0(this);
    }

    @Override // io.reactivex.rxjava3.core.FlowableEmitter
    public final void setCancellable(Cancellable cancellable) {
        setDisposable(new CancellableDisposable(cancellable));
    }

    @Override // io.reactivex.rxjava3.core.FlowableEmitter
    public final void setDisposable(Disposable disposable) {
        this.f23386b.update(disposable);
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public final String toString() {
        return getClass().getSimpleName() + "{" + super.toString() + "}";
    }

    @Override // io.reactivex.rxjava3.core.FlowableEmitter
    public final boolean tryOnError(Throwable th) {
        if (th == null) {
            th = ExceptionHelper.createNullPointerException("tryOnError called with a null Throwable.");
        }
        return mo6354e(th);
    }

    /* renamed from: c */
    public void mo6352c() {
    }

    /* renamed from: d */
    public void mo6353d() {
    }
}
