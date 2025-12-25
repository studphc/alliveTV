package p000;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLongArray;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class j22 implements Subscription {

    /* renamed from: a */
    public final int f20351a;

    /* renamed from: b */
    public final int f20352b;

    /* renamed from: c */
    public final /* synthetic */ k22 f20353c;

    public j22(k22 k22Var, int i, int i2) {
        this.f20353c = k22Var;
        this.f20351a = i;
        this.f20352b = i2;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (this.f20353c.f20728b.compareAndSet(this.f20351a + this.f20352b, 0L, 1L)) {
            k22 k22Var = this.f20353c;
            int i = this.f20352b;
            if (k22Var.f20728b.decrementAndGet(i + i) == 0) {
                k22Var.f20737k = true;
                k22Var.f20732f.cancel();
                if (k22Var.getAndIncrement() == 0) {
                    k22Var.f20733g.clear();
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        long j2;
        if (SubscriptionHelper.validate(j)) {
            k22 k22Var = this.f20353c;
            AtomicLongArray atomicLongArray = k22Var.f20728b;
            do {
                j2 = atomicLongArray.get(this.f20351a);
                if (j2 == Long.MAX_VALUE) {
                    return;
                }
            } while (!atomicLongArray.compareAndSet(this.f20351a, j2, BackpressureHelper.addCap(j2, j)));
            if (k22Var.f20738l.get() == this.f20352b) {
                k22Var.m5482a();
            }
        }
    }
}
