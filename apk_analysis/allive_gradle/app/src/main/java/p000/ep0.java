package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class ep0 extends AtomicReference implements jp0 {
    private static final long serialVersionUID = 2346567790059478686L;

    /* renamed from: a */
    public final boolean f16938a;

    /* renamed from: b */
    public ip0 f16939b;

    /* renamed from: c */
    public int f16940c;

    /* renamed from: d */
    public long f16941d;

    public ep0(boolean z) {
        this.f16938a = z;
        ip0 ip0Var = new ip0(null, 0L);
        this.f16939b = ip0Var;
        set(ip0Var);
    }

    @Override // p000.jp0
    /* renamed from: a */
    public final void mo4740a(Object obj) {
        Object mo4743d = mo4743d(NotificationLite.next(obj), false);
        long j = this.f16941d + 1;
        this.f16941d = j;
        ip0 ip0Var = new ip0(mo4743d, j);
        this.f16939b.set(ip0Var);
        this.f16939b = ip0Var;
        this.f16940c++;
        mo4747h();
    }

    @Override // p000.jp0
    /* renamed from: b */
    public final void mo4741b(Throwable th) {
        Object mo4743d = mo4743d(NotificationLite.error(th), true);
        long j = this.f16941d + 1;
        this.f16941d = j;
        ip0 ip0Var = new ip0(mo4743d, j);
        this.f16939b.set(ip0Var);
        this.f16939b = ip0Var;
        this.f16940c++;
        mo4748i();
    }

    @Override // p000.jp0
    /* renamed from: c */
    public final void mo4742c(gp0 gp0Var) {
        boolean z;
        synchronized (gp0Var) {
            try {
                if (gp0Var.f17788e) {
                    gp0Var.f17789f = true;
                    return;
                }
                gp0Var.f17788e = true;
                while (true) {
                    long j = gp0Var.get();
                    if (j == Long.MAX_VALUE) {
                        z = true;
                    } else {
                        z = false;
                    }
                    ip0 ip0Var = (ip0) gp0Var.f17786c;
                    if (ip0Var == null) {
                        ip0Var = mo4744e();
                        gp0Var.f17786c = ip0Var;
                        BackpressureHelper.add(gp0Var.f17787d, ip0Var.f20169b);
                    }
                    long j2 = 0;
                    while (j != 0) {
                        if (gp0Var.isDisposed()) {
                            gp0Var.f17786c = null;
                            return;
                        }
                        ip0 ip0Var2 = (ip0) ip0Var.get();
                        if (ip0Var2 == null) {
                            break;
                        }
                        Object mo4745f = mo4745f(ip0Var2.f20168a);
                        try {
                            if (NotificationLite.accept(mo4745f, gp0Var.f17785b)) {
                                gp0Var.f17786c = null;
                                return;
                            } else {
                                j2++;
                                j--;
                                ip0Var = ip0Var2;
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            gp0Var.f17786c = null;
                            gp0Var.dispose();
                            if (!NotificationLite.isError(mo4745f) && !NotificationLite.isComplete(mo4745f)) {
                                gp0Var.f17785b.onError(th);
                                return;
                            } else {
                                RxJavaPlugins.onError(th);
                                return;
                            }
                        }
                    }
                    if (j == 0 && gp0Var.isDisposed()) {
                        gp0Var.f17786c = null;
                        return;
                    }
                    if (j2 != 0) {
                        gp0Var.f17786c = ip0Var;
                        if (!z) {
                            BackpressureHelper.producedCancel(gp0Var, j2);
                        }
                    }
                    synchronized (gp0Var) {
                        try {
                            if (!gp0Var.f17789f) {
                                gp0Var.f17788e = false;
                                return;
                            }
                            gp0Var.f17789f = false;
                        } finally {
                        }
                    }
                }
            } finally {
            }
        }
    }

    @Override // p000.jp0
    public final void complete() {
        Object mo4743d = mo4743d(NotificationLite.complete(), true);
        long j = this.f16941d + 1;
        this.f16941d = j;
        ip0 ip0Var = new ip0(mo4743d, j);
        this.f16939b.set(ip0Var);
        this.f16939b = ip0Var;
        this.f16940c++;
        mo4748i();
    }

    /* renamed from: e */
    public ip0 mo4744e() {
        return (ip0) get();
    }

    /* renamed from: g */
    public final void m4746g(ip0 ip0Var) {
        if (this.f16938a) {
            ip0 ip0Var2 = new ip0(null, ip0Var.f20169b);
            ip0Var2.lazySet(ip0Var.get());
            ip0Var = ip0Var2;
        }
        set(ip0Var);
    }

    /* renamed from: h */
    public abstract void mo4747h();

    /* renamed from: i */
    public void mo4748i() {
        ip0 ip0Var = (ip0) get();
        if (ip0Var.f20168a != null) {
            ip0 ip0Var2 = new ip0(null, 0L);
            ip0Var2.lazySet(ip0Var.get());
            set(ip0Var2);
        }
    }

    /* renamed from: f */
    public Object mo4745f(Object obj) {
        return obj;
    }

    /* renamed from: d */
    public Object mo4743d(Object obj, boolean z) {
        return obj;
    }
}
