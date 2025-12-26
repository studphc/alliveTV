package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class cy1 extends ArrayList implements wx1 {
    private static final long serialVersionUID = 7063189396499112664L;

    /* renamed from: a */
    public volatile int f16179a;

    @Override // p000.wx1
    /* renamed from: a */
    public final void mo4503a(Object obj) {
        add(NotificationLite.next(obj));
        this.f16179a++;
    }

    @Override // p000.wx1
    /* renamed from: b */
    public final void mo4504b(Throwable th) {
        add(NotificationLite.error(th));
        this.f16179a++;
    }

    @Override // p000.wx1
    /* renamed from: c */
    public final void mo4505c(tx1 tx1Var) {
        int i;
        if (tx1Var.getAndIncrement() != 0) {
            return;
        }
        Observer observer = tx1Var.f27013b;
        int i2 = 1;
        while (!tx1Var.f27015d) {
            int i3 = this.f16179a;
            Integer num = (Integer) tx1Var.f27014c;
            if (num != null) {
                i = num.intValue();
            } else {
                i = 0;
            }
            while (i < i3) {
                if (NotificationLite.accept(get(i), observer) || tx1Var.f27015d) {
                    return;
                } else {
                    i++;
                }
            }
            tx1Var.f27014c = Integer.valueOf(i);
            i2 = tx1Var.addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
        }
    }

    @Override // p000.wx1
    public final void complete() {
        add(NotificationLite.complete());
        this.f16179a++;
    }
}
