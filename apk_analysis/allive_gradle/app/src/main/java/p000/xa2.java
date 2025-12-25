package p000;

import java.lang.reflect.Array;
import java.util.ArrayList;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class xa2 implements sa2 {

    /* renamed from: a */
    public final ArrayList f28487a;

    /* renamed from: b */
    public Throwable f28488b;

    /* renamed from: c */
    public volatile boolean f28489c;

    /* renamed from: d */
    public volatile int f28490d;

    public xa2(int i) {
        this.f28487a = new ArrayList(i);
    }

    @Override // p000.sa2
    /* renamed from: a */
    public final void mo7349a(Object obj) {
        this.f28487a.add(obj);
        this.f28490d++;
    }

    @Override // p000.sa2
    /* renamed from: b */
    public final void mo7350b(Throwable th) {
        this.f28488b = th;
        this.f28489c = true;
    }

    @Override // p000.sa2
    public final void complete() {
        this.f28489c = true;
    }

    @Override // p000.sa2
    /* renamed from: d */
    public final Object[] mo7352d(Object[] objArr) {
        int i = this.f28490d;
        if (i == 0) {
            if (objArr.length != 0) {
                objArr[0] = null;
            }
            return objArr;
        }
        ArrayList arrayList = this.f28487a;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = arrayList.get(i2);
        }
        if (objArr.length > i) {
            objArr[i] = null;
        }
        return objArr;
    }

    @Override // p000.sa2
    /* renamed from: e */
    public final void mo7353e(ta2 ta2Var) {
        int i;
        if (ta2Var.getAndIncrement() != 0) {
            return;
        }
        ArrayList arrayList = this.f28487a;
        Subscriber subscriber = ta2Var.f26750a;
        Integer num = (Integer) ta2Var.f26752c;
        if (num != null) {
            i = num.intValue();
        } else {
            i = 0;
            ta2Var.f26752c = 0;
        }
        long j = ta2Var.f26755f;
        int i2 = 1;
        do {
            long j2 = ta2Var.f26753d.get();
            while (j != j2) {
                if (ta2Var.f26754e) {
                    ta2Var.f26752c = null;
                    return;
                }
                boolean z = this.f28489c;
                int i3 = this.f28490d;
                if (z && i == i3) {
                    ta2Var.f26752c = null;
                    ta2Var.f26754e = true;
                    Throwable th = this.f28488b;
                    if (th == null) {
                        subscriber.onComplete();
                        return;
                    } else {
                        subscriber.onError(th);
                        return;
                    }
                }
                if (i == i3) {
                    break;
                }
                subscriber.onNext(arrayList.get(i));
                i++;
                j++;
            }
            if (j == j2) {
                if (ta2Var.f26754e) {
                    ta2Var.f26752c = null;
                    return;
                }
                boolean z2 = this.f28489c;
                int i4 = this.f28490d;
                if (z2 && i == i4) {
                    ta2Var.f26752c = null;
                    ta2Var.f26754e = true;
                    Throwable th2 = this.f28488b;
                    if (th2 == null) {
                        subscriber.onComplete();
                        return;
                    } else {
                        subscriber.onError(th2);
                        return;
                    }
                }
            }
            ta2Var.f26752c = Integer.valueOf(i);
            ta2Var.f26755f = j;
            i2 = ta2Var.addAndGet(-i2);
        } while (i2 != 0);
    }

    @Override // p000.sa2
    public final Throwable getError() {
        return this.f28488b;
    }

    @Override // p000.sa2
    public final Object getValue() {
        int i = this.f28490d;
        if (i == 0) {
            return null;
        }
        return this.f28487a.get(i - 1);
    }

    @Override // p000.sa2
    public final boolean isDone() {
        return this.f28489c;
    }

    @Override // p000.sa2
    public final int size() {
        return this.f28490d;
    }

    @Override // p000.sa2
    /* renamed from: c */
    public final void mo7351c() {
    }
}
