package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ks0 extends AtomicInteger implements ConditionalSubscriber, Subscription {
    private static final long serialVersionUID = 1577321883966341961L;

    /* renamed from: a */
    public final Subscriber f22178a;

    /* renamed from: b */
    public final Function f22179b;

    /* renamed from: c */
    public final ls0[] f22180c;

    /* renamed from: d */
    public final AtomicReferenceArray f22181d;

    /* renamed from: e */
    public final AtomicReference f22182e;

    /* renamed from: f */
    public final AtomicLong f22183f;

    /* renamed from: g */
    public final AtomicThrowable f22184g;

    /* renamed from: h */
    public volatile boolean f22185h;

    public ks0(Subscriber subscriber, Function function, int i) {
        this.f22178a = subscriber;
        this.f22179b = function;
        ls0[] ls0VarArr = new ls0[i];
        for (int i2 = 0; i2 < i; i2++) {
            ls0VarArr[i2] = new ls0(this, i2);
        }
        this.f22180c = ls0VarArr;
        this.f22181d = new AtomicReferenceArray(i);
        this.f22182e = new AtomicReference();
        this.f22183f = new AtomicLong();
        this.f22184g = new AtomicThrowable();
    }

    /* renamed from: a */
    public final void m5784a(int i) {
        int i2 = 0;
        while (true) {
            ls0[] ls0VarArr = this.f22180c;
            if (i2 < ls0VarArr.length) {
                if (i2 != i) {
                    ls0 ls0Var = ls0VarArr[i2];
                    ls0Var.getClass();
                    SubscriptionHelper.cancel(ls0Var);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        SubscriptionHelper.cancel(this.f22182e);
        for (ls0 ls0Var : this.f22180c) {
            ls0Var.getClass();
            SubscriptionHelper.cancel(ls0Var);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (!this.f22185h) {
            this.f22185h = true;
            m5784a(-1);
            HalfSerializer.onComplete((Subscriber<?>) this.f22178a, this, this.f22184g);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f22185h) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f22185h = true;
        m5784a(-1);
        HalfSerializer.onError((Subscriber<?>) this.f22178a, th, this, this.f22184g);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (!tryOnNext(obj) && !this.f22185h) {
            ((Subscription) this.f22182e.get()).request(1L);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.f22182e, this.f22183f, subscription);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        SubscriptionHelper.deferredRequest(this.f22182e, this.f22183f, j);
    }

    @Override // io.reactivex.rxjava3.operators.ConditionalSubscriber
    public final boolean tryOnNext(Object obj) {
        if (this.f22185h) {
            return false;
        }
        AtomicReferenceArray atomicReferenceArray = this.f22181d;
        int length = atomicReferenceArray.length();
        Object[] objArr = new Object[length + 1];
        objArr[0] = obj;
        int i = 0;
        while (i < length) {
            Object obj2 = atomicReferenceArray.get(i);
            if (obj2 == null) {
                return false;
            }
            i++;
            objArr[i] = obj2;
        }
        try {
            Object apply = this.f22179b.apply(objArr);
            Objects.requireNonNull(apply, "The combiner returned a null value");
            HalfSerializer.onNext((Subscriber<? super Object>) this.f22178a, apply, this, this.f22184g);
            return true;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            cancel();
            onError(th);
            return false;
        }
    }
}
