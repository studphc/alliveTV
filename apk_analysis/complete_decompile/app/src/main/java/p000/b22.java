package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class b22 extends AtomicReference implements FlowableSubscriber {
    private static final long serialVersionUID = -7954444275102466525L;

    /* renamed from: a */
    public final c22 f7870a;

    /* renamed from: b */
    public final BiConsumer f7871b;

    /* renamed from: c */
    public final BinaryOperator f7872c;

    /* renamed from: d */
    public Object f7873d;

    /* renamed from: e */
    public boolean f7874e;

    public b22(c22 c22Var, Object obj, BiConsumer biConsumer, BinaryOperator binaryOperator) {
        this.f7870a = c22Var;
        this.f7871b = biConsumer;
        this.f7872c = binaryOperator;
        this.f7873d = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0080 A[EDGE_INSN: B:42:0x0080->B:43:0x0080 BREAK  A[LOOP:0: B:4:0x000e->B:12:0x000e], SYNTHETIC] */
    @Override // org.reactivestreams.Subscriber
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onComplete() {
        c22 c22Var;
        AtomicReference atomicReference;
        int i;
        Object apply;
        if (!this.f7874e) {
            Object obj = this.f7873d;
            this.f7873d = null;
            this.f7874e = true;
            BinaryOperator binaryOperator = this.f7872c;
            while (true) {
                c22Var = this.f7870a;
                atomicReference = c22Var.f8234b;
                d22 d22Var = (d22) atomicReference.get();
                if (d22Var == null) {
                    d22 d22Var2 = new d22();
                    while (!atomicReference.compareAndSet(null, d22Var2)) {
                        if (atomicReference.get() != null) {
                            break;
                        }
                    }
                    d22Var = d22Var2;
                }
                while (true) {
                    i = d22Var.get();
                    if (i >= 2) {
                        i = -1;
                        break;
                    } else if (d22Var.compareAndSet(i, i + 1)) {
                        break;
                    }
                }
                if (i < 0) {
                    while (!atomicReference.compareAndSet(d22Var, null) && atomicReference.get() == d22Var) {
                    }
                } else {
                    if (i == 0) {
                        d22Var.f16221a = obj;
                    } else {
                        d22Var.f16222b = obj;
                    }
                    if (d22Var.f16223c.incrementAndGet() != 2) {
                        d22Var = null;
                        if (d22Var != null) {
                            break;
                        }
                        try {
                            obj = binaryOperator.apply(d22Var.f16221a, d22Var.f16222b);
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            c22Var.m2183a(th);
                            return;
                        }
                    }
                    while (!atomicReference.compareAndSet(d22Var, null) && atomicReference.get() == d22Var) {
                    }
                    if (d22Var != null) {
                    }
                }
            }
            if (c22Var.f8235c.decrementAndGet() == 0) {
                d22 d22Var3 = (d22) atomicReference.get();
                atomicReference.lazySet(null);
                try {
                    apply = c22Var.f8237e.apply(d22Var3.f16221a);
                    Objects.requireNonNull(apply, "The finisher returned a null value");
                    c22Var.complete(apply);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    c22Var.m2183a(th2);
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f7874e) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f7873d = null;
        this.f7874e = true;
        this.f7870a.m2183a(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (!this.f7874e) {
            try {
                this.f7871b.accept(this.f7873d, obj);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                ((Subscription) get()).cancel();
                onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
    }
}
