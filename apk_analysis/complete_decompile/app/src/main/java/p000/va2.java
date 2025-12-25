package p000;

import java.lang.reflect.Array;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class va2 implements sa2 {

    /* renamed from: a */
    public final int f27716a;

    /* renamed from: b */
    public int f27717b;

    /* renamed from: c */
    public volatile ra2 f27718c;

    /* renamed from: d */
    public ra2 f27719d;

    /* renamed from: e */
    public Throwable f27720e;

    /* renamed from: f */
    public volatile boolean f27721f;

    public va2(int i) {
        this.f27716a = i;
        ra2 ra2Var = new ra2(null);
        this.f27719d = ra2Var;
        this.f27718c = ra2Var;
    }

    @Override // p000.sa2
    /* renamed from: a */
    public final void mo7349a(Object obj) {
        ra2 ra2Var = new ra2(obj);
        ra2 ra2Var2 = this.f27719d;
        this.f27719d = ra2Var;
        this.f27717b++;
        ra2Var2.set(ra2Var);
        int i = this.f27717b;
        if (i > this.f27716a) {
            this.f27717b = i - 1;
            this.f27718c = (ra2) this.f27718c.get();
        }
    }

    @Override // p000.sa2
    /* renamed from: b */
    public final void mo7350b(Throwable th) {
        this.f27720e = th;
        mo7351c();
        this.f27721f = true;
    }

    @Override // p000.sa2
    /* renamed from: c */
    public final void mo7351c() {
        if (this.f27718c.f25915a != null) {
            ra2 ra2Var = new ra2(null);
            ra2Var.lazySet(this.f27718c.get());
            this.f27718c = ra2Var;
        }
    }

    @Override // p000.sa2
    public final void complete() {
        mo7351c();
        this.f27721f = true;
    }

    @Override // p000.sa2
    /* renamed from: d */
    public final Object[] mo7352d(Object[] objArr) {
        ra2 ra2Var = this.f27718c;
        ra2 ra2Var2 = ra2Var;
        int i = 0;
        while (true) {
            ra2Var2 = (ra2) ra2Var2.get();
            if (ra2Var2 == null) {
                break;
            }
            i++;
        }
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        for (int i2 = 0; i2 < i; i2++) {
            ra2Var = (ra2) ra2Var.get();
            objArr[i2] = ra2Var.f25915a;
        }
        if (objArr.length > i) {
            objArr[i] = null;
        }
        return objArr;
    }

    @Override // p000.sa2
    /* renamed from: e */
    public final void mo7353e(ta2 ta2Var) {
        boolean z;
        if (ta2Var.getAndIncrement() != 0) {
            return;
        }
        Subscriber subscriber = ta2Var.f26750a;
        ra2 ra2Var = (ra2) ta2Var.f26752c;
        if (ra2Var == null) {
            ra2Var = this.f27718c;
        }
        long j = ta2Var.f26755f;
        int i = 1;
        do {
            long j2 = ta2Var.f26753d.get();
            while (j != j2) {
                if (ta2Var.f26754e) {
                    ta2Var.f26752c = null;
                    return;
                }
                boolean z2 = this.f27721f;
                ra2 ra2Var2 = (ra2) ra2Var.get();
                if (ra2Var2 == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z2 && z) {
                    ta2Var.f26752c = null;
                    ta2Var.f26754e = true;
                    Throwable th = this.f27720e;
                    if (th == null) {
                        subscriber.onComplete();
                        return;
                    } else {
                        subscriber.onError(th);
                        return;
                    }
                }
                if (z) {
                    break;
                }
                subscriber.onNext(ra2Var2.f25915a);
                j++;
                ra2Var = ra2Var2;
            }
            if (j == j2) {
                if (ta2Var.f26754e) {
                    ta2Var.f26752c = null;
                    return;
                }
                if (this.f27721f && ra2Var.get() == null) {
                    ta2Var.f26752c = null;
                    ta2Var.f26754e = true;
                    Throwable th2 = this.f27720e;
                    if (th2 == null) {
                        subscriber.onComplete();
                        return;
                    } else {
                        subscriber.onError(th2);
                        return;
                    }
                }
            }
            ta2Var.f26752c = ra2Var;
            ta2Var.f26755f = j;
            i = ta2Var.addAndGet(-i);
        } while (i != 0);
    }

    @Override // p000.sa2
    public final Throwable getError() {
        return this.f27720e;
    }

    @Override // p000.sa2
    public final Object getValue() {
        ra2 ra2Var = this.f27718c;
        while (true) {
            ra2 ra2Var2 = (ra2) ra2Var.get();
            if (ra2Var2 == null) {
                return ra2Var.f25915a;
            }
            ra2Var = ra2Var2;
        }
    }

    @Override // p000.sa2
    public final boolean isDone() {
        return this.f27721f;
    }

    @Override // p000.sa2
    public final int size() {
        ra2 ra2Var = this.f27718c;
        int i = 0;
        while (i != Integer.MAX_VALUE && (ra2Var = (ra2) ra2Var.get()) != null) {
            i++;
        }
        return i;
    }
}
