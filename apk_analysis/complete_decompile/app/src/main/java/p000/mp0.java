package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class mp0 extends AtomicReference implements FlowableSubscriber, Disposable {

    /* renamed from: h */
    public static final gp0[] f23036h = new gp0[0];

    /* renamed from: i */
    public static final gp0[] f23037i = new gp0[0];
    private static final long serialVersionUID = 7224554242710036740L;

    /* renamed from: a */
    public final jp0 f23038a;

    /* renamed from: b */
    public boolean f23039b;

    /* renamed from: f */
    public long f23043f;

    /* renamed from: g */
    public final AtomicReference f23044g;

    /* renamed from: e */
    public final AtomicInteger f23042e = new AtomicInteger();

    /* renamed from: c */
    public final AtomicReference f23040c = new AtomicReference(f23036h);

    /* renamed from: d */
    public final AtomicBoolean f23041d = new AtomicBoolean();

    public mp0(jp0 jp0Var, AtomicReference atomicReference) {
        this.f23038a = jp0Var;
        this.f23044g = atomicReference;
    }

    /* renamed from: a */
    public final void m6206a() {
        AtomicInteger atomicInteger = this.f23042e;
        if (atomicInteger.getAndIncrement() != 0) {
            return;
        }
        int i = 1;
        while (!isDisposed()) {
            Subscription subscription = (Subscription) get();
            if (subscription != null) {
                long j = this.f23043f;
                long j2 = j;
                for (gp0 gp0Var : (gp0[]) this.f23040c.get()) {
                    j2 = Math.max(j2, gp0Var.f17787d.get());
                }
                long j3 = j2 - j;
                if (j3 != 0) {
                    this.f23043f = j2;
                    subscription.request(j3);
                }
            }
            i = atomicInteger.addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public final void m6207b(gp0 gp0Var) {
        gp0[] gp0VarArr;
        while (true) {
            AtomicReference atomicReference = this.f23040c;
            gp0[] gp0VarArr2 = (gp0[]) atomicReference.get();
            int length = gp0VarArr2.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i < length) {
                    if (gp0VarArr2[i].equals(gp0Var)) {
                        break;
                    } else {
                        i++;
                    }
                } else {
                    i = -1;
                    break;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                gp0VarArr = f23036h;
            } else {
                gp0[] gp0VarArr3 = new gp0[length - 1];
                System.arraycopy(gp0VarArr2, 0, gp0VarArr3, 0, i);
                System.arraycopy(gp0VarArr2, i + 1, gp0VarArr3, i, (length - i) - 1);
                gp0VarArr = gp0VarArr3;
            }
            while (!atomicReference.compareAndSet(gp0VarArr2, gp0VarArr)) {
                if (atomicReference.get() != gp0VarArr2) {
                    break;
                }
            }
            return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        AtomicReference atomicReference;
        this.f23040c.set(f23037i);
        do {
            atomicReference = this.f23044g;
            if (atomicReference.compareAndSet(this, null)) {
                break;
            }
        } while (atomicReference.get() == this);
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f23040c.get() == f23037i) {
            return true;
        }
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (!this.f23039b) {
            this.f23039b = true;
            jp0 jp0Var = this.f23038a;
            jp0Var.complete();
            for (gp0 gp0Var : (gp0[]) this.f23040c.getAndSet(f23037i)) {
                jp0Var.mo4742c(gp0Var);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (!this.f23039b) {
            this.f23039b = true;
            jp0 jp0Var = this.f23038a;
            jp0Var.mo4741b(th);
            for (gp0 gp0Var : (gp0[]) this.f23040c.getAndSet(f23037i)) {
                jp0Var.mo4742c(gp0Var);
            }
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (!this.f23039b) {
            jp0 jp0Var = this.f23038a;
            jp0Var.mo4740a(obj);
            for (gp0 gp0Var : (gp0[]) this.f23040c.get()) {
                jp0Var.mo4742c(gp0Var);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            m6206a();
            for (gp0 gp0Var : (gp0[]) this.f23040c.get()) {
                this.f23038a.mo4742c(gp0Var);
            }
        }
    }
}
