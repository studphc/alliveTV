package p000;

import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class c22 extends DeferredScalarSubscription {
    private static final long serialVersionUID = -5370107872170712765L;

    /* renamed from: a */
    public final b22[] f8233a;

    /* renamed from: b */
    public final AtomicReference f8234b;

    /* renamed from: c */
    public final AtomicInteger f8235c;

    /* renamed from: d */
    public final AtomicThrowable f8236d;

    /* renamed from: e */
    public final Function f8237e;

    public c22(Subscriber subscriber, int i, Collector collector) {
        super(subscriber);
        Function finisher;
        Supplier supplier;
        Object obj;
        BiConsumer accumulator;
        BinaryOperator combiner;
        this.f8234b = new AtomicReference();
        this.f8235c = new AtomicInteger();
        this.f8236d = new AtomicThrowable();
        finisher = collector.finisher();
        this.f8237e = finisher;
        b22[] b22VarArr = new b22[i];
        for (int i2 = 0; i2 < i; i2++) {
            supplier = collector.supplier();
            obj = supplier.get();
            accumulator = collector.accumulator();
            combiner = collector.combiner();
            b22VarArr[i2] = new b22(this, obj, accumulator, combiner);
        }
        this.f8233a = b22VarArr;
        this.f8235c.lazySet(i);
    }

    /* renamed from: a */
    public final void m2183a(Throwable th) {
        AtomicThrowable atomicThrowable = this.f8236d;
        if (atomicThrowable.compareAndSet(null, th)) {
            cancel();
            this.downstream.onError(th);
        } else if (th != atomicThrowable.get()) {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public final void cancel() {
        for (b22 b22Var : this.f8233a) {
            b22Var.getClass();
            SubscriptionHelper.cancel(b22Var);
        }
    }
}
