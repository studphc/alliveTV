package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class kr0 extends SubscriptionArbiter implements FlowableSubscriber, lr0 {
    private static final long serialVersionUID = 3764492702657003550L;

    /* renamed from: h */
    public final Subscriber f22165h;

    /* renamed from: i */
    public final Function f22166i;

    /* renamed from: j */
    public final SequentialDisposable f22167j;

    /* renamed from: k */
    public final AtomicReference f22168k;

    /* renamed from: l */
    public final AtomicLong f22169l;

    /* renamed from: m */
    public Publisher f22170m;

    /* renamed from: n */
    public long f22171n;

    public kr0(Publisher publisher, Subscriber subscriber, Function function) {
        super(true);
        this.f22165h = subscriber;
        this.f22166i = function;
        this.f22167j = new SequentialDisposable();
        this.f22168k = new AtomicReference();
        this.f22170m = publisher;
        this.f22169l = new AtomicLong();
    }

    @Override // p000.qr0
    /* renamed from: a */
    public final void mo5780a(long j) {
        if (this.f22169l.compareAndSet(j, Long.MAX_VALUE)) {
            SubscriptionHelper.cancel(this.f22168k);
            Publisher publisher = this.f22170m;
            this.f22170m = null;
            long j2 = this.f22171n;
            if (j2 != 0) {
                produced(j2);
            }
            publisher.subscribe(new nr0(this.f22165h, this));
        }
    }

    @Override // p000.lr0
    /* renamed from: b */
    public final void mo5781b(long j, Throwable th) {
        if (this.f22169l.compareAndSet(j, Long.MAX_VALUE)) {
            SubscriptionHelper.cancel(this.f22168k);
            this.f22165h.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
    public final void cancel() {
        super.cancel();
        this.f22167j.dispose();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f22169l.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            SequentialDisposable sequentialDisposable = this.f22167j;
            sequentialDisposable.dispose();
            this.f22165h.onComplete();
            sequentialDisposable.dispose();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f22169l.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            SequentialDisposable sequentialDisposable = this.f22167j;
            sequentialDisposable.dispose();
            this.f22165h.onError(th);
            sequentialDisposable.dispose();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        AtomicLong atomicLong = this.f22169l;
        long j = atomicLong.get();
        if (j != Long.MAX_VALUE) {
            long j2 = j + 1;
            if (atomicLong.compareAndSet(j, j2)) {
                SequentialDisposable sequentialDisposable = this.f22167j;
                Disposable disposable = sequentialDisposable.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                this.f22171n++;
                Subscriber subscriber = this.f22165h;
                subscriber.onNext(obj);
                try {
                    Object apply = this.f22166i.apply(obj);
                    Objects.requireNonNull(apply, "The itemTimeoutIndicator returned a null Publisher.");
                    Publisher publisher = (Publisher) apply;
                    jr0 jr0Var = new jr0(j2, this);
                    if (sequentialDisposable.replace(jr0Var)) {
                        publisher.subscribe(jr0Var);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    ((Subscription) this.f22168k.get()).cancel();
                    atomicLong.getAndSet(Long.MAX_VALUE);
                    subscriber.onError(th);
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter, io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.f22168k, subscription)) {
            setSubscription(subscription);
        }
    }
}
