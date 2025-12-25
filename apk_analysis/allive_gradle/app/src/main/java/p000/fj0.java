package p000;

import io.reactivex.rxjava3.internal.operators.flowable.FlowableCache;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class fj0 extends AtomicInteger implements Subscription {
    private static final long serialVersionUID = 6770240836423125754L;

    /* renamed from: a */
    public final Subscriber f17285a;

    /* renamed from: b */
    public final FlowableCache f17286b;

    /* renamed from: c */
    public final AtomicLong f17287c = new AtomicLong();

    /* renamed from: d */
    public gj0 f17288d;

    /* renamed from: e */
    public int f17289e;

    /* renamed from: f */
    public long f17290f;

    public fj0(Subscriber subscriber, FlowableCache flowableCache) {
        this.f17285a = subscriber;
        this.f17286b = flowableCache;
        this.f17288d = flowableCache.f18763f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        fj0[] fj0VarArr;
        if (this.f17287c.getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
            return;
        }
        while (true) {
            AtomicReference atomicReference = this.f17286b.f18761d;
            fj0[] fj0VarArr2 = (fj0[]) atomicReference.get();
            int length = fj0VarArr2.length;
            if (length != 0) {
                int i = 0;
                while (true) {
                    if (i < length) {
                        if (fj0VarArr2[i] == this) {
                            break;
                        } else {
                            i++;
                        }
                    } else {
                        i = -1;
                        break;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        fj0VarArr = FlowableCache.f18757k;
                    } else {
                        fj0[] fj0VarArr3 = new fj0[length - 1];
                        System.arraycopy(fj0VarArr2, 0, fj0VarArr3, 0, i);
                        System.arraycopy(fj0VarArr2, i + 1, fj0VarArr3, i, (length - i) - 1);
                        fj0VarArr = fj0VarArr3;
                    }
                    while (!atomicReference.compareAndSet(fj0VarArr2, fj0VarArr)) {
                        if (atomicReference.get() != fj0VarArr2) {
                            break;
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.addCancel(this.f17287c, j);
            this.f17286b.m5274e(this);
        }
    }
}
