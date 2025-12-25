package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class w22 extends DeferredScalarSubscription {
    private static final long serialVersionUID = -5370107872170712765L;

    /* renamed from: a */
    public final v22[] f28048a;

    /* renamed from: b */
    public final BiFunction f28049b;

    /* renamed from: c */
    public final AtomicReference f28050c;

    /* renamed from: d */
    public final AtomicInteger f28051d;

    /* renamed from: e */
    public final AtomicThrowable f28052e;

    public w22(Subscriber subscriber, int i, BiFunction biFunction) {
        super(subscriber);
        this.f28050c = new AtomicReference();
        this.f28051d = new AtomicInteger();
        this.f28052e = new AtomicThrowable();
        v22[] v22VarArr = new v22[i];
        for (int i2 = 0; i2 < i; i2++) {
            v22VarArr[i2] = new v22(this, biFunction);
        }
        this.f28048a = v22VarArr;
        this.f28049b = biFunction;
        this.f28051d.lazySet(i);
    }

    /* renamed from: a */
    public final void m7965a(Throwable th) {
        AtomicThrowable atomicThrowable = this.f28052e;
        if (atomicThrowable.compareAndSet(null, th)) {
            cancel();
            this.downstream.onError(th);
        } else if (th != atomicThrowable.get()) {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public final void cancel() {
        for (v22 v22Var : this.f28048a) {
            v22Var.getClass();
            SubscriptionHelper.cancel(v22Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007a A[EDGE_INSN: B:41:0x007a->B:58:0x007a BREAK  A[LOOP:0: B:3:0x0005->B:11:0x0005], SYNTHETIC] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m7966e(Object obj) {
        int i;
        AtomicReference atomicReference = this.f28050c;
        if (obj != null) {
            while (true) {
                x22 x22Var = (x22) atomicReference.get();
                if (x22Var == null) {
                    x22 x22Var2 = new x22();
                    while (!atomicReference.compareAndSet(null, x22Var2)) {
                        if (atomicReference.get() != null) {
                            break;
                        }
                    }
                    x22Var = x22Var2;
                }
                while (true) {
                    i = x22Var.get();
                    if (i >= 2) {
                        i = -1;
                        break;
                    } else if (x22Var.compareAndSet(i, i + 1)) {
                        break;
                    }
                }
                if (i < 0) {
                    while (!atomicReference.compareAndSet(x22Var, null) && atomicReference.get() == x22Var) {
                    }
                } else {
                    if (i == 0) {
                        x22Var.f28429a = obj;
                    } else {
                        x22Var.f28430b = obj;
                    }
                    if (x22Var.f28431c.incrementAndGet() != 2) {
                        x22Var = null;
                        if (x22Var != null) {
                            break;
                        }
                        try {
                            obj = this.f28049b.apply(x22Var.f28429a, x22Var.f28430b);
                            Objects.requireNonNull(obj, "The reducer returned a null value");
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            m7965a(th);
                            return;
                        }
                    }
                    while (!atomicReference.compareAndSet(x22Var, null) && atomicReference.get() == x22Var) {
                    }
                    if (x22Var != null) {
                    }
                }
            }
        }
        if (this.f28051d.decrementAndGet() == 0) {
            x22 x22Var3 = (x22) atomicReference.get();
            atomicReference.lazySet(null);
            if (x22Var3 != null) {
                complete(x22Var3.f28429a);
            } else {
                this.downstream.onComplete();
            }
        }
    }
}
