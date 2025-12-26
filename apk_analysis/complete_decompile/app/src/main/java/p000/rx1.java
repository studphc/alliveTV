package p000;

import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class rx1 extends AtomicReference implements wx1 {
    private static final long serialVersionUID = 2346567790059478686L;

    /* renamed from: a */
    public vx1 f26175a;

    /* renamed from: b */
    public int f26176b;

    /* renamed from: c */
    public final boolean f26177c;

    public rx1(boolean z) {
        this.f26177c = z;
        vx1 vx1Var = new vx1(null);
        this.f26175a = vx1Var;
        set(vx1Var);
    }

    @Override // p000.wx1
    /* renamed from: a */
    public final void mo4503a(Object obj) {
        vx1 vx1Var = new vx1(mo1976d(NotificationLite.next(obj)));
        this.f26175a.set(vx1Var);
        this.f26175a = vx1Var;
        this.f26176b++;
        mo1979h();
    }

    @Override // p000.wx1
    /* renamed from: b */
    public final void mo4504b(Throwable th) {
        vx1 vx1Var = new vx1(mo1976d(NotificationLite.error(th)));
        this.f26175a.set(vx1Var);
        this.f26175a = vx1Var;
        this.f26176b++;
        mo1980i();
    }

    @Override // p000.wx1
    /* renamed from: c */
    public final void mo4505c(tx1 tx1Var) {
        if (tx1Var.getAndIncrement() != 0) {
            return;
        }
        int i = 1;
        do {
            vx1 vx1Var = (vx1) tx1Var.f27014c;
            if (vx1Var == null) {
                vx1Var = mo1977e();
                tx1Var.f27014c = vx1Var;
            }
            while (!tx1Var.f27015d) {
                vx1 vx1Var2 = (vx1) vx1Var.get();
                if (vx1Var2 != null) {
                    if (NotificationLite.accept(mo1978f(vx1Var2.f27987a), tx1Var.f27013b)) {
                        tx1Var.f27014c = null;
                        return;
                    }
                    vx1Var = vx1Var2;
                } else {
                    tx1Var.f27014c = vx1Var;
                    i = tx1Var.addAndGet(-i);
                }
            }
            tx1Var.f27014c = null;
            return;
        } while (i != 0);
    }

    @Override // p000.wx1
    public final void complete() {
        vx1 vx1Var = new vx1(mo1976d(NotificationLite.complete()));
        this.f26175a.set(vx1Var);
        this.f26175a = vx1Var;
        this.f26176b++;
        mo1980i();
    }

    /* renamed from: e */
    public vx1 mo1977e() {
        return (vx1) get();
    }

    /* renamed from: g */
    public final void m7308g(vx1 vx1Var) {
        if (this.f26177c) {
            vx1 vx1Var2 = new vx1(null);
            vx1Var2.lazySet(vx1Var.get());
            vx1Var = vx1Var2;
        }
        set(vx1Var);
    }

    /* renamed from: h */
    public abstract void mo1979h();

    /* renamed from: i */
    public void mo1980i() {
        vx1 vx1Var = (vx1) get();
        if (vx1Var.f27987a != null) {
            vx1 vx1Var2 = new vx1(null);
            vx1Var2.lazySet(vx1Var.get());
            set(vx1Var2);
        }
    }

    /* renamed from: d */
    public Object mo1976d(Object obj) {
        return obj;
    }

    /* renamed from: f */
    public Object mo1978f(Object obj) {
        return obj;
    }
}
