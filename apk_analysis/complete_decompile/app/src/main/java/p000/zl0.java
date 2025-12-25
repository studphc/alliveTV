package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class zl0 extends AtomicInteger implements FlowableSubscriber, Disposable {
    private static final long serialVersionUID = 8443155186132538303L;

    /* renamed from: a */
    public final CompletableObserver f29418a;

    /* renamed from: c */
    public final Function f29420c;

    /* renamed from: d */
    public final boolean f29421d;

    /* renamed from: f */
    public final int f29423f;

    /* renamed from: g */
    public Subscription f29424g;

    /* renamed from: h */
    public volatile boolean f29425h;

    /* renamed from: b */
    public final AtomicThrowable f29419b = new AtomicThrowable();

    /* renamed from: e */
    public final CompositeDisposable f29422e = new CompositeDisposable();

    public zl0(CompletableObserver completableObserver, Function function, boolean z, int i) {
        this.f29418a = completableObserver;
        this.f29420c = function;
        this.f29421d = z;
        this.f29423f = i;
        lazySet(1);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f29425h = true;
        this.f29424g.cancel();
        this.f29422e.dispose();
        this.f29419b.tryTerminateAndReport();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f29422e.isDisposed();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (decrementAndGet() == 0) {
            this.f29419b.tryTerminateConsumer(this.f29418a);
        } else if (this.f29423f != Integer.MAX_VALUE) {
            this.f29424g.request(1L);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f29419b.tryAddThrowableOrReport(th)) {
            if (this.f29421d) {
                if (decrementAndGet() == 0) {
                    this.f29419b.tryTerminateConsumer(this.f29418a);
                    return;
                } else {
                    if (this.f29423f != Integer.MAX_VALUE) {
                        this.f29424g.request(1L);
                        return;
                    }
                    return;
                }
            }
            this.f29425h = true;
            this.f29424g.cancel();
            this.f29422e.dispose();
            this.f29419b.tryTerminateConsumer(this.f29418a);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        try {
            Object apply = this.f29420c.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
            CompletableSource completableSource = (CompletableSource) apply;
            getAndIncrement();
            yl0 yl0Var = new yl0(this);
            if (!this.f29425h && this.f29422e.add(yl0Var)) {
                completableSource.subscribe(yl0Var);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f29424g.cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f29424g, subscription)) {
            this.f29424g = subscription;
            this.f29418a.onSubscribe(this);
            int i = this.f29423f;
            if (i == Integer.MAX_VALUE) {
                subscription.request(Long.MAX_VALUE);
            } else {
                subscription.request(i);
            }
        }
    }
}
