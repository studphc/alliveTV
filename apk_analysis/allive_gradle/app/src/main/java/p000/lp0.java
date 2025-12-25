package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class lp0 implements Publisher {

    /* renamed from: a */
    public final AtomicReference f22605a;

    /* renamed from: b */
    public final Supplier f22606b;

    public lp0(AtomicReference atomicReference, Supplier supplier) {
        this.f22605a = atomicReference;
        this.f22606b = supplier;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.reactivestreams.Publisher
    public final void subscribe(Subscriber subscriber) {
        mp0 mp0Var;
        loop0: while (true) {
            AtomicReference atomicReference = this.f22605a;
            mp0Var = (mp0) atomicReference.get();
            if (mp0Var != null) {
                break;
            }
            try {
                mp0 mp0Var2 = new mp0((jp0) this.f22606b.get(), atomicReference);
                while (!atomicReference.compareAndSet(null, mp0Var2)) {
                    if (atomicReference.get() != null) {
                        break;
                    }
                }
                mp0Var = mp0Var2;
                break loop0;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
                return;
            }
        }
        gp0 gp0Var = new gp0(mp0Var, subscriber);
        subscriber.onSubscribe(gp0Var);
        loop2: while (true) {
            AtomicReference atomicReference2 = mp0Var.f23040c;
            gp0[] gp0VarArr = (gp0[]) atomicReference2.get();
            if (gp0VarArr != mp0.f23037i) {
                int length = gp0VarArr.length;
                gp0[] gp0VarArr2 = new gp0[length + 1];
                System.arraycopy(gp0VarArr, 0, gp0VarArr2, 0, length);
                gp0VarArr2[length] = gp0Var;
                while (!atomicReference2.compareAndSet(gp0VarArr, gp0VarArr2)) {
                    if (atomicReference2.get() != gp0VarArr) {
                        break;
                    }
                }
                break loop2;
            }
            break;
        }
        if (gp0Var.isDisposed()) {
            mp0Var.m6207b(gp0Var);
        } else {
            mp0Var.m6206a();
            mp0Var.f23038a.mo4742c(gp0Var);
        }
    }
}
