package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ul0 extends AtomicReference implements FlowableSubscriber, Disposable {
    private static final long serialVersionUID = -4606175640614850599L;

    /* renamed from: a */
    public final long f27313a;

    /* renamed from: b */
    public final vl0 f27314b;

    /* renamed from: c */
    public final int f27315c;

    /* renamed from: d */
    public final int f27316d;

    /* renamed from: e */
    public volatile boolean f27317e;

    /* renamed from: f */
    public volatile SimpleQueue f27318f;

    /* renamed from: g */
    public long f27319g;

    /* renamed from: h */
    public int f27320h;

    public ul0(vl0 vl0Var, int i, long j) {
        this.f27313a = j;
        this.f27314b = vl0Var;
        this.f27316d = i;
        this.f27315c = i >> 2;
    }

    /* renamed from: a */
    public final void m7737a(long j) {
        if (this.f27320h != 1) {
            long j2 = this.f27319g + j;
            if (j2 >= this.f27315c) {
                this.f27319g = 0L;
                ((Subscription) get()).request(j2);
            } else {
                this.f27319g = j2;
            }
        }
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
        this.f27317e = true;
        this.f27314b.m7919b();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        lazySet(SubscriptionHelper.CANCELLED);
        vl0 vl0Var = this.f27314b;
        if (vl0Var.f27844h.tryAddThrowableOrReport(th)) {
            this.f27317e = true;
            if (!vl0Var.f27839c) {
                vl0Var.f27848l.cancel();
                for (ul0 ul0Var : (ul0[]) vl0Var.f27846j.getAndSet(vl0.f27836s)) {
                    ul0Var.getClass();
                    SubscriptionHelper.cancel(ul0Var);
                }
            }
            vl0Var.m7919b();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f27320h != 2) {
            vl0 vl0Var = this.f27314b;
            if (vl0Var.get() == 0 && vl0Var.compareAndSet(0, 1)) {
                long j = vl0Var.f27847k.get();
                SimpleQueue simpleQueue = this.f27318f;
                if (j != 0 && (simpleQueue == null || simpleQueue.isEmpty())) {
                    vl0Var.f27837a.onNext(obj);
                    if (j != Long.MAX_VALUE) {
                        vl0Var.f27847k.decrementAndGet();
                    }
                    m7737a(1L);
                } else {
                    if (simpleQueue == null) {
                        simpleQueue = new SpscArrayQueue(vl0Var.f27841e);
                        this.f27318f = simpleQueue;
                    }
                    if (!simpleQueue.offer(obj)) {
                        vl0Var.onError(new MissingBackpressureException("Inner queue full?!"));
                    }
                }
                if (vl0Var.decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimpleQueue simpleQueue2 = this.f27318f;
                if (simpleQueue2 == null) {
                    simpleQueue2 = new SpscArrayQueue(vl0Var.f27841e);
                    this.f27318f = simpleQueue2;
                }
                if (!simpleQueue2.offer(obj)) {
                    vl0Var.onError(new MissingBackpressureException("Inner queue full?!"));
                    return;
                } else if (vl0Var.getAndIncrement() != 0) {
                    return;
                }
            }
            vl0Var.m7920c();
            return;
        }
        this.f27314b.m7919b();
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(7);
                if (requestFusion == 1) {
                    this.f27320h = requestFusion;
                    this.f27318f = queueSubscription;
                    this.f27317e = true;
                    this.f27314b.m7919b();
                    return;
                }
                if (requestFusion == 2) {
                    this.f27320h = requestFusion;
                    this.f27318f = queueSubscription;
                }
            }
            subscription.request(this.f27316d);
        }
    }
}
