package p000;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class qi0 implements Subscription {

    /* renamed from: a */
    public final Subscriber f25597a;

    /* renamed from: b */
    public final ri0[] f25598b;

    /* renamed from: c */
    public final AtomicInteger f25599c = new AtomicInteger();

    public qi0(Subscriber subscriber, int i) {
        this.f25597a = subscriber;
        this.f25598b = new ri0[i];
    }

    /* renamed from: a */
    public final boolean m7035a(int i) {
        AtomicInteger atomicInteger = this.f25599c;
        int i2 = 0;
        if (atomicInteger.get() != 0 || !atomicInteger.compareAndSet(0, i)) {
            return false;
        }
        ri0[] ri0VarArr = this.f25598b;
        int length = ri0VarArr.length;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (i3 != i) {
                ri0 ri0Var = ri0VarArr[i2];
                ri0Var.getClass();
                SubscriptionHelper.cancel(ri0Var);
            }
            i2 = i3;
        }
        return true;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        AtomicInteger atomicInteger = this.f25599c;
        if (atomicInteger.get() != -1) {
            atomicInteger.lazySet(-1);
            for (ri0 ri0Var : this.f25598b) {
                ri0Var.getClass();
                SubscriptionHelper.cancel(ri0Var);
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            int i = this.f25599c.get();
            ri0[] ri0VarArr = this.f25598b;
            if (i > 0) {
                ri0VarArr[i - 1].request(j);
                return;
            }
            if (i == 0) {
                for (ri0 ri0Var : ri0VarArr) {
                    ri0Var.request(j);
                }
            }
        }
    }
}
