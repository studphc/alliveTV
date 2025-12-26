package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p000.AbstractC1215g0;
import p000.fj0;
import p000.gj0;

/* loaded from: classes2.dex */
public final class FlowableCache<T> extends AbstractC1215g0 implements FlowableSubscriber<T> {

    /* renamed from: k */
    public static final fj0[] f18757k = new fj0[0];

    /* renamed from: l */
    public static final fj0[] f18758l = new fj0[0];

    /* renamed from: b */
    public final AtomicBoolean f18759b;

    /* renamed from: c */
    public final int f18760c;

    /* renamed from: d */
    public final AtomicReference f18761d;

    /* renamed from: e */
    public volatile long f18762e;

    /* renamed from: f */
    public final gj0 f18763f;

    /* renamed from: g */
    public gj0 f18764g;

    /* renamed from: h */
    public int f18765h;

    /* renamed from: i */
    public Throwable f18766i;

    /* renamed from: j */
    public volatile boolean f18767j;

    public FlowableCache(Flowable<T> flowable, int i) {
        super(flowable);
        this.f18760c = i;
        this.f18759b = new AtomicBoolean();
        gj0 gj0Var = new gj0(i, 0);
        this.f18763f = gj0Var;
        this.f18764g = gj0Var;
        this.f18761d = new AtomicReference(f18757k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    public final void m5274e(fj0 fj0Var) {
        boolean z;
        if (fj0Var.getAndIncrement() != 0) {
            return;
        }
        long j = fj0Var.f17290f;
        int i = fj0Var.f17289e;
        gj0 gj0Var = fj0Var.f17288d;
        AtomicLong atomicLong = fj0Var.f17287c;
        Subscriber subscriber = fj0Var.f17285a;
        int i2 = this.f18760c;
        int i3 = 1;
        while (true) {
            boolean z2 = this.f18767j;
            if (this.f18762e == j) {
                z = true;
            } else {
                z = false;
            }
            if (z2 && z) {
                fj0Var.f17288d = null;
                Throwable th = this.f18766i;
                if (th != null) {
                    subscriber.onError(th);
                    return;
                } else {
                    subscriber.onComplete();
                    return;
                }
            }
            if (!z) {
                long j2 = atomicLong.get();
                if (j2 == Long.MIN_VALUE) {
                    fj0Var.f17288d = null;
                    return;
                } else if (j2 != j) {
                    if (i == i2) {
                        gj0Var = (gj0) gj0Var.f17717b;
                        i = 0;
                    }
                    subscriber.onNext(gj0Var.f17716a[i]);
                    i++;
                    j++;
                }
            }
            fj0Var.f17290f = j;
            fj0Var.f17289e = i;
            fj0Var.f17288d = gj0Var;
            i3 = fj0Var.addAndGet(-i3);
            if (i3 == 0) {
                return;
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.f18767j = true;
        for (fj0 fj0Var : (fj0[]) this.f18761d.getAndSet(f18758l)) {
            m5274e(fj0Var);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f18767j) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f18766i = th;
        this.f18767j = true;
        for (fj0 fj0Var : (fj0[]) this.f18761d.getAndSet(f18758l)) {
            m5274e(fj0Var);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        int i = this.f18765h;
        if (i == this.f18760c) {
            gj0 gj0Var = new gj0(i, 0);
            gj0Var.f17716a[0] = t;
            this.f18765h = 1;
            this.f18764g.f17717b = gj0Var;
            this.f18764g = gj0Var;
        } else {
            this.f18764g.f17716a[i] = t;
            this.f18765h = i + 1;
        }
        this.f18762e++;
        for (fj0 fj0Var : (fj0[]) this.f18761d.get()) {
            m5274e(fj0Var);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        fj0 fj0Var = new fj0(subscriber, this);
        subscriber.onSubscribe(fj0Var);
        loop0: while (true) {
            AtomicReference atomicReference = this.f18761d;
            fj0[] fj0VarArr = (fj0[]) atomicReference.get();
            if (fj0VarArr != f18758l) {
                int length = fj0VarArr.length;
                fj0[] fj0VarArr2 = new fj0[length + 1];
                System.arraycopy(fj0VarArr, 0, fj0VarArr2, 0, length);
                fj0VarArr2[length] = fj0Var;
                while (!atomicReference.compareAndSet(fj0VarArr, fj0VarArr2)) {
                    if (atomicReference.get() != fj0VarArr) {
                        break;
                    }
                }
                break loop0;
            }
            break;
        }
        AtomicBoolean atomicBoolean = this.f18759b;
        if (!atomicBoolean.get() && atomicBoolean.compareAndSet(false, true)) {
            this.source.subscribe((FlowableSubscriber<? super Object>) this);
        } else {
            m5274e(fj0Var);
        }
    }
}
